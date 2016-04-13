package Conexao;

// @author Márison Tamiarana

import Classes.Modelo_Lote_Estoque;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class Controle_Lote_Estoque {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Modelo_Lote_Estoque ObjModLote = new Modelo_Lote_Estoque();
    public boolean Abaixo_Do_Minimo = false;
    public boolean Menos_De_30_Dias = false;
    public boolean Produto_Vencido = false;
    public boolean Controla_Lote = false;
    public boolean Confirma_Atualiza_Estoque;
    public boolean Confirma_Atualiza_Estoque_Lote;
    
    public Modelo_Lote_Estoque Consulta_Estoque_Produto(Modelo_Lote_Estoque ObjModeloLote, Object id)throws SQLException{
        ObjConecta.Conectar();
        
       String sql = "select sum(quantidade_estoque) as quant from lote_estoque where produto_id_produto="+id+"";
       
       try(PreparedStatement stm = ObjConecta.conn.prepareStatement(sql);
           ResultSet rs = stm.executeQuery()){
                    
           rs.first();
           
           ObjModeloLote.setQuantidade_estoque(rs.getDouble("quant"));
        
        ObjConecta.Desconecta(); 
        
        return ObjModeloLote;        
       }
    }
 
    public void Verificar_Abaixo_Do_Minimo(){
        try {
            //verifica se existe algum produto
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_produto");
            //faz o teste
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select distinct produto.id_produto, produto.descricao,  unidade, quantidade_minima, "
                    + "(select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto) as estoque "
                    + "from produto where (select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto)<quantidade_minima;");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_produto");
            Abaixo_Do_Minimo=true;
        } catch (SQLException ex) {
            Abaixo_Do_Minimo =false;
            ObjConecta.Desconecta(); 
        }ObjConecta.Desconecta(); 
    }
    
    public void Verifica_Validade_30_Dias(){
        try {
            //verifica se existe algum produto
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_produto");
            //faz o teste
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, +1); //Aumenta um mes na data
            String df = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            String di = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from lote_estoque inner join produto on produto.id_produto=lote_estoque.produto_id_produto "
                    + "where quantidade_estoque >0 and solicita_lote='SIM' and data_validade_lote between '"+di+"' and '"+df+"'");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_produto");
            Menos_De_30_Dias = true;
        } catch (SQLException ex) {
            Menos_De_30_Dias=false;
            ObjConecta.Desconecta(); 
        }ObjConecta.Desconecta(); 
    }
    
    public void Verifica_Produto_Vencido(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_produto");
            
            String da = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from lote_estoque inner join produto on produto.id_produto=lote_estoque.produto_id_produto "
                    + "where quantidade_estoque >0 and solicita_lote='SIM' and data_validade_lote < '"+da+"'");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_produto");
            Produto_Vencido = true;
        } catch (SQLException ex) {
            Produto_Vencido = false;
        }ObjConecta.Desconecta(); 
    }
    
    public Modelo_Lote_Estoque Quantidade_Estoque_Lote(Modelo_Lote_Estoque ObjModLote, int id_prod, String lote){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select* from lote_estoque where produto_id_produto="+id_prod+" and numero_lote= "+"'"+lote+"'"+"");
            ObjConecta.rs.first();
            ObjModLote.setQuantidade_estoque(ObjConecta.rs.getDouble("quantidade_estoque"));
            Controla_Lote = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            Controla_Lote = false;
        }
        return ObjModLote;
}

public Modelo_Lote_Estoque Quantidade_Estoque(Modelo_Lote_Estoque ObjModLote,int id_prod){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select* from lote_estoque where produto_id_produto="+id_prod+"");
            ObjConecta.rs.first();
            ObjModLote.setQuantidade_estoque(ObjConecta.rs.getDouble("quantidade_estoque"));
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
        }
        return ObjModLote;
}

public void Atualiza_Estoque(Modelo_Lote_Estoque ObjModLote, int id_prod, double quant){
        ObjConecta.Conectar();        
        String sql = "update lote_estoque set quantidade_estoque =? where produto_id_produto="+id_prod+"";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setDouble(1, ObjModLote.getQuantidade_estoque()+quant);
                    }
                    stmt.execute();
                    stmt.close();
                }           
                    Confirma_Atualiza_Estoque = true;      
                } catch (SQLException ex) {
                    Confirma_Atualiza_Estoque = false;
                    JOptionPane.showMessageDialog(null,"Erro ao atualizar o estoque no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
   public void Atualiza_Estoque_Lote(Modelo_Lote_Estoque ObjModLote, int id_prod, double quant, String lote){
        ObjConecta.Conectar();        
        String sql = "update lote_estoque set quantidade_estoque =? where produto_id_produto="+id_prod+" and numero_lote="+"'"+lote+"'"+"";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    
                    {
                        stmt.setDouble(1, ObjModLote.getQuantidade_estoque()+quant);
                    }
                    stmt.execute();
                    stmt.close();
                }           
                    Confirma_Atualiza_Estoque_Lote = true;      
                } catch (SQLException ex) {
                    Confirma_Atualiza_Estoque_Lote = false;
                    JOptionPane.showMessageDialog(null,"Erro ao atualizar o estoque e o lote no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
   
    public Modelo_Lote_Estoque Consulta_Id_Estoque(Modelo_Lote_Estoque ObjModeloLote, int id){
        try { 
            ObjConecta.Conectar();
        
            String sql = "select * from lote_estoque where produto_id_produto="+id+"";
       
            try(PreparedStatement stm = ObjConecta.conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery()){

                rs.first();

                     ObjModeloLote.setId_lote(rs.getInt("id_lote"));

                 ObjConecta.Desconecta(); 
             }
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao consultar o id do lote no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        return ObjModeloLote;
    }
    
    public Modelo_Lote_Estoque Consulta_Id_Lote_Estoque(Modelo_Lote_Estoque ObjModeloLote, int id, String lote){
        try { 
            ObjConecta.Conectar();
        
            String sql = "select * from lote_estoque where produto_id_produto="+id+" and numero_lote='"+lote+"'";
       
            try(PreparedStatement stm = ObjConecta.conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery()){

                rs.first();

                     ObjModeloLote.setId_lote(rs.getInt("id_lote"));

                 ObjConecta.Desconecta(); 
             }
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Erro ao consultar o id do lote no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        return ObjModeloLote;
    }
    
    public void Produto_Vencido(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_produto");
            Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
            obj.Verifica_Produto_Vencido();
            if(obj.Produto_Vencido ==true){
                obj.Produto_Vencido =false;
            }
        } catch (SQLException ex) {
           
        }ObjConecta.Desconecta();
    }
    
}


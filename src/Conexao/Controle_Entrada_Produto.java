package Conexao;

//@author Márison Tamiarana

import Classes.Modelo_Entrada_Produto;
import Classes.Modelo_Lote_Estoque;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

 
public class Controle_Entrada_Produto {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Modelo_Entrada_Produto ObjModeloEntrada = new Modelo_Entrada_Produto();
    Modelo_Lote_Estoque ObjModLote = new Modelo_Lote_Estoque();
    Controle_Lote_Estoque ObjControleLote = new Controle_Lote_Estoque();
    
    public boolean Confirma_Entrada;
    public boolean Confirma_Entrada_Item;
    public boolean Confirma_Entrada_Estoque;
    public boolean Confirma_Entrada_Estoque_Lote;
    public boolean Confirma_Atualiza_Estoque;
    public boolean Confirma_Atualiza_Estoque_Lote;
    public boolean Confirma_Atualiza_Estoque_Lote_Novo;
    public boolean Confirma_Efetivar_Entrada;
    public boolean Confirma_Excluir_Entrada;
    public boolean ControlaLote;
    public boolean Controle_Entrada;
    public long dt;
    
    public void Inserir_Entrada(Modelo_Entrada_Produto ObjModeloEntrada, String Data){
        ObjConecta.Conectar();
        
        String sql = "insert into entrada (data_entrada,descricao_entrada, situacao_entrada)values(?,?,?)";  
            try {                
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, Data);
                        stmt.setString(2, ObjModeloEntrada.getDescricao());
                        stmt.setString(3, "ABERTO");
                    }
                    stmt.execute();
                    stmt.close();
                    
                }
                Confirma_Entrada = true;
            } catch (SQLException ex) {
                Confirma_Entrada = false;
                JOptionPane.showMessageDialog(null, "Erro ao gerar a entrada no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
    
    public void Inserir_Entrada_Itens(int Id_Prod, int Id_Entrada, double Quant, String Lote, String Data_Val, double Preco){
        ObjConecta.Conectar();
        String sql = "insert into entrada_itens (Produto_id_produto, Entrada_id_entrada, quantidade, lote, data_validade, preco)"
                + "values(?,?,?,?,?,?)";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setInt   (1,  Id_Prod);
                        stmt.setInt   (2,  Id_Entrada);
                        stmt.setDouble(3,  Quant);
                        stmt.setString(4,  Lote);
                        stmt.setString(5,  Data_Val);
                        stmt.setDouble(6,  Preco);
                    }
                    stmt.execute();
                    stmt.close();
                }
                Confirma_Entrada_Item = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                Confirma_Entrada_Item = false;
                JOptionPane.showMessageDialog(null,"Erro ao dar entrada de itens no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }
    
    public void Inserir_Estoque_Lote(int id_prod, double quant, String lote, String data_val){
        try {
            ObjConecta.Conectar();
            String sql = "insert into lote_estoque (produto_id_produto, quantidade_estoque, numero_lote, data_validade_lote)"
                + "values(?,?,?,?)";
            
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setInt   (1,  id_prod);
                        stmt.setDouble(2,  quant);
                        stmt.setString(3,  lote);
                        stmt.setString(4,  data_val);
                    }
                    stmt.execute();
                    stmt.close();
                }
                Confirma_Entrada_Estoque_Lote = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                Confirma_Entrada_Estoque_Lote = false;
                JOptionPane.showMessageDialog(null,"Erro ao inserir lote e estoque no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }
    
    public void Inserir_Estoque(int id_prod, double quant){
        try {
            ObjConecta.Conectar();
            String sql = "insert into lote_estoque (produto_id_produto, quantidade_estoque)"
                + "values(?,?)";
            
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setInt   (1,  id_prod);
                        stmt.setDouble(2,  quant);
                    }
                    stmt.execute();
                    stmt.close();
                }
                Confirma_Entrada_Estoque = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                Confirma_Entrada_Estoque = false;
                JOptionPane.showMessageDialog(null,"Erro ao inserir o estoque no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
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
                    JOptionPane.showMessageDialog(null,"Erro ao atualzar o estoque no banco! \n"
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
                    JOptionPane.showMessageDialog(null,"Erro ao atualzar o estoque no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
   public void Atualiza_Estoque_Lote_Novo( int id_prod, double quant, String lote, String data_val){
        ObjConecta.Conectar();        
        String sql = "update lote_estoque set quantidade_estoque =?, numero_lote=?, data_validade_lote=? "
                + "where produto_id_produto="+id_prod+" and numero_lote='NOVO'";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    
                    {
                        stmt.setDouble(1, quant);
                        stmt.setString(2, lote);
                        stmt.setString(3, data_val);
                        
                    }
                    stmt.execute();
                    stmt.close();
                }           
                    Confirma_Atualiza_Estoque_Lote_Novo = true;      
                } catch (SQLException ex) {
                    Confirma_Atualiza_Estoque_Lote_Novo = false;
                    JOptionPane.showMessageDialog(null,"Erro ao atualzar o estoque NOVO no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
            
    public Modelo_Entrada_Produto Media_Produto(Modelo_Entrada_Produto ObjModeloEntradaProd, int id){
        try {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, -3); //diminuir datas - inicio para 90 dias;
            String data_atual = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String data_inicio = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            
            
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("select avg(quantidade) as media from entrada inner join entrada_itens on "
                        + "entrada.id_entrada=entrada_itens.entrada_id_entrada "
                        + "where entrada.data_entrada between "+"'"+data_inicio+"'"+" and "+"'"+data_atual+"'"+" and produto_id_produto=" + id + "");
                ObjConecta.rs.first();
                ObjModeloEntradaProd.setMedia(ObjConecta.rs.getInt("media"));
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao procurar a media de 90 dias do produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        return ObjModeloEntradaProd;
    }

public Modelo_Entrada_Produto Media_Prod_Mes_Entrada(Modelo_Entrada_Produto ObjModeloEntradaProd, int id){
        try {
            Conecta_Banco obj = new Conecta_Banco();
            obj.Conectar();
            
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, -3); //diminuir datas - inicio para 90 dias;
            Date dt_atual = Calendar.getInstance().getTime();
            Date dt_inicio = c.getTime();
            String data_atual = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String data_inicio = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            
            obj.ExecutaSQL("select * from entrada inner join entrada_itens on"
              + " entrada.id_entrada=entrada_itens.entrada_id_entrada where produto_id_produto="+id+"");
            obj.rs.first();
            Date dt1 = obj.rs.getDate("data_entrada");
            obj.rs.last();
            Date dt2 = obj.rs.getDate("data_entrada");
            obj.Desconecta();
            
            dt = (((dt_atual.getTime() - dt1.getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
                        
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("select sum(quantidade) as media from entrada inner join entrada_itens on "
                        + "entrada.id_entrada=entrada_itens.entrada_id_entrada "
                        + "where entrada.data_entrada between "+"'"+data_inicio+"'"+" and "+"'"+data_atual+"'"+" and produto_id_produto=" + id + "");
                ObjConecta.rs.first();
                int soma = ObjConecta.rs.getInt("media");
                if(dt_inicio.before(dt1)){               
                    if (dt <= 30) {
                        int resultado = soma;
                        ObjModeloEntradaProd.setMedia(resultado); }
                    if (dt > 30 && dt <= 60) {
                        int resultado = soma / 2;
                        ObjModeloEntradaProd.setMedia(resultado); }
                    if (dt > 60) {
                        int resultado = soma / 3;
                        ObjModeloEntradaProd.setMedia(resultado); }           
                }else{
                    int resultado = soma / 3;
                    ObjModeloEntradaProd.setMedia(resultado); }              
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                
                JOptionPane.showMessageDialog(null,"Erro ao procurar a media de 90 dias do produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        return ObjModeloEntradaProd;
    }

public void Controla_Lote(int id_prod){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select* from produto where id_produto="+id_prod+"");
            ObjConecta.rs.first();
            String Situacao = ObjConecta.rs.getString("solicita_lote");
            
                if(Situacao.equalsIgnoreCase("SIM")){
                   ControlaLote = true;
                }else{
                   ControlaLote = false;
                }
            ObjConecta.Desconecta();
                       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao procurar o controle de estoque do produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            ObjConecta.Desconecta();
        }
    }


public void Inseri_Atualiza_Lote_Estoque(int id_prod, double quant, String lote, String data_val){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select* from lote_estoque where produto_id_produto="+id_prod+"");
            ObjConecta.rs.first();
            String Lote = ObjConecta.rs.getString("numero_lote");
            
                if(Lote == null){//Produto com estoque e sem lote
                    ObjControleLote.Quantidade_Estoque(ObjModLote,id_prod);//buscar a quantidade existente do estoque sem lote
                    //Atualiza o estoque
                    Atualiza_Estoque(ObjModLote, id_prod, quant);

                }else{//produto com lote - nova inserção ou atualizaçao
                    try{
                        if(Lote.equalsIgnoreCase("NOVO")){
                            Atualiza_Estoque_Lote_Novo(id_prod, quant, lote, data_val);
                        }
                        else{
                            ObjControleLote.Quantidade_Estoque_Lote(ObjModLote,id_prod, lote);//buscar a quantidade existente do estoque com lote
                            if(ObjControleLote.Controla_Lote == true){                                
                                Atualiza_Estoque_Lote(ObjModLote, id_prod, quant, lote);//Atualiza o estoque
                            }else{
                                Inserir_Estoque_Lote(id_prod, quant, lote, data_val);//Inseri novo
                            }
                        }
                    }catch(Exception ex) {//inserir estoque de produto com novo lote
                        Inserir_Estoque_Lote(id_prod, quant, lote, data_val);}
                }
            ObjConecta.Desconecta();
        } catch (SQLException ex) {//inserir estoque de produto sem estoque cadastrados
            Controla_Lote(id_prod);
                if(ControlaLote== true){
                    Inserir_Estoque_Lote(id_prod, quant, lote, data_val);  
                }else{
                    Inserir_Estoque(id_prod, quant);
                }
                ObjConecta.Desconecta();
            }
    }



public void Consulta_Entrada_Id(int id_entrada){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("Select * from entrada where id_entrada = "+id_entrada+"");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_entrada");
            Controle_Entrada = true;
        } catch (SQLException ex) {
            Controle_Entrada = false;
        }
    }
    
     public void Consulta_Entrada_Todas(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("Select * from entrada");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_entrada");
            Controle_Entrada = true;
        } catch (SQLException ex) {
            Controle_Entrada = false;
        }
    }
     
    public void Efetivar_Entrada(int id, String situacao){
        ObjConecta.Conectar();
        String sql = "update entrada set situacao_entrada =? where id_entrada="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.setString(1,situacao);
                stmt.execute();
                stmt.close();
                Confirma_Efetivar_Entrada = true;
            }
        } catch (SQLException ex) 
            {
                ObjConecta.Desconecta();
                Confirma_Efetivar_Entrada = false;
                JOptionPane.showMessageDialog(null,"Erro ao atualizar a entrada no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();
        
    }
    
    public void Excluir_Entrada(int id){
        ObjConecta.Conectar();
        String sql = "delete from entrada where id_entrada="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.execute();
                stmt.close();
                Confirma_Excluir_Entrada = true;
            }
        } catch (SQLException ex) 
            {
                ObjConecta.Desconecta();
                Confirma_Excluir_Entrada = false;
                JOptionPane.showMessageDialog(null,"Erro ao atualizar a entrada no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();
        
    }
}

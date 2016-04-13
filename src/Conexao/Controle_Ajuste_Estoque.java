package Conexao;

// @author Márison Tamiarana

import Classes.Modelo_Ajuste_Estoque;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;


public class Controle_Ajuste_Estoque {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    
    public boolean Confirma_Inserir = false;
    public long dt;
    public boolean Controle_Ajuste;
    
    public Modelo_Ajuste_Estoque Inserir_Ajuste_Estoque(Modelo_Ajuste_Estoque ObjModeloAjuste, int id_usuario, int id_prod){
        ObjConecta.Conectar();
        
        String sql = "insert into ajuste_estoque (motivo, observacao, quantidade, produto_id_produto, lote_estoque_id_lote, usuario_id_usuario, situacao_ajuste, data_ajuste) "
                + "values(?,?,?,?,?,?,?,?)";
            try {                
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, ObjModeloAjuste.getMotivo());
                        stmt.setString(2, ObjModeloAjuste.getObservacao());
                        stmt.setDouble(3, ObjModeloAjuste.getQuantidade());
                        stmt.setInt   (4, id_prod);
                        stmt.setInt   (5, ObjModeloAjuste.getLote_id_lote());
                        stmt.setInt   (6, id_usuario);
                        stmt.setString(7, "CONFIRMADA");
                        stmt.setString(8, ObjModeloAjuste.getData_ajuste());
                    }
                    stmt.execute();
                    stmt.close();
                                        
                }
                Confirma_Inserir = true;
                ObjConecta.ExecutaSQL("select LAST_INSERT_ID()");
                ObjConecta.rs.first();
                ObjModeloAjuste.setId_ajuste_estoque(ObjConecta.rs.getInt(1));
                
            } catch (SQLException ex) {
                Confirma_Inserir = false;
                JOptionPane.showMessageDialog(null, "Erro ao inserir o ajuste no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
        return ObjModeloAjuste;
    }    
    
    public void Exclui_Ajuste(int id_ajuste){
        ObjConecta.Conectar();        
        String sql = "delete from ajuste_estoque where id_ajuste_estoque="+id_ajuste+"";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                   
                    stmt.execute();
                    stmt.close();
                }           
                    //Confirma_Atualiza_Estoque = true;      
                } catch (SQLException ex) {
                    //Confirma_Atualiza_Estoque = false;
                    JOptionPane.showMessageDialog(null,"Erro ao excluir o ajuste do banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
    
     public Modelo_Ajuste_Estoque Media_Prod_Mes_Ajuste(Modelo_Ajuste_Estoque ObjModAjusteEstoque, int id){
        try {
            Conecta_Banco obj = new Conecta_Banco();
            obj.Conectar();
            
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, -3); //diminuir datas - inicio para 90 dias;
            Date dt_atual = Calendar.getInstance().getTime();
            Date dt_inicio = c.getTime();
            String data_atual = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String data_inicio = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            
            obj.ExecutaSQL("select * from ajuste_estoque inner join lote_estoque on ajuste_estoque.lote_estoque_id_lote = lote_estoque.id_lote");
            //primeira saida
            obj.rs.first();
            Date dt1 = obj.rs.getDate("data_ajuste");
            //ultima saida
            obj.rs.last();
            Date dt2 = obj.rs.getDate("data_ajuste");
            obj.Desconecta();
            
            dt = (((dt_atual.getTime() - dt1.getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
                        
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("select sum(quantidade) as media from ajuste_estoque inner join lote_estoque "
                        + " on ajuste_estoque.lote_estoque_id_lote = lote_estoque.id_lote "
                        + " where ajuste_estoque.data_ajuste between "+"'"+data_inicio+"'"+" and "+"'"+data_atual+"'"+" and ajuste_estoque.produto_id_produto=" + id + "");
                ObjConecta.rs.first();
                float soma = ObjConecta.rs.getInt("media");//recebe o total
                ObjModAjusteEstoque.setTotal(soma);
                if(dt_inicio.before(dt1)){               
                    if (dt <= 30) {
                        float resultado = soma;
                        ObjModAjusteEstoque.setMedia(resultado); }
                    if (dt > 30 && dt <= 60) {
                        float resultado = soma / 2;
                        ObjModAjusteEstoque.setMedia(resultado); }
                    if (dt > 60) {
                        float resultado = soma / 3;
                        ObjModAjusteEstoque.setMedia(resultado); }           
                }else{
                    float resultado = soma / 3;
                    ObjModAjusteEstoque.setMedia(resultado); }              
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                
                JOptionPane.showMessageDialog(null,"Erro ao procurar a media do ajuste de 90 dias do produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        return ObjModAjusteEstoque;
    }
     
    public Modelo_Ajuste_Estoque Consulta_Ultimo_Ajuste(Modelo_Ajuste_Estoque ObjModAjusteEstoque, String id){
        try {
            ObjConecta.Conectar();
                        
            ObjConecta.ExecutaSQL("select * from ajuste_estoque inner join lote_estoque on ajuste_estoque.lote_estoque_id_lote = lote_estoque.id_lote "
              + " where ajuste_estoque.produto_id_produto="+id+"");
            //ultima saida
            ObjConecta.rs.last();
            Date dt2 = ObjConecta.rs.getDate("data_ajuste");
            ObjModAjusteEstoque.setData_ajuste(new SimpleDateFormat("dd-MM-yyyy").format(dt2.getTime()));
            ObjConecta.Desconecta();
           
        } catch (SQLException ex) {
            ObjConecta.Desconecta();                
            JOptionPane.showMessageDialog(null,"Erro ao consultar o ultimo ajuste do produto no banco! \n"
                +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
        }
        return ObjModAjusteEstoque;
    }
    
    public void Consulta_Iten_Ajuste(int id_prod){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from ajuste_estoque inner join lote_estoque on ajuste_estoque.lote_estoque_id_lote = lote_estoque.id_lote "
              + " where ajuste_estoque.produto_id_produto="+id_prod+"");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_ajuste_estoque");
            Controle_Ajuste = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Controle_Ajuste = false;
            ObjConecta.Desconecta();
        }
    }
}

package Conexao;

// @author Márison Tamiarana

import Classes.Modelo_Ajuste_Estoque;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Controle_Ajuste_Estoque {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    
    public boolean Confirma_Inserir = false;
    
    public Modelo_Ajuste_Estoque Inserir_Ajuste_Estoque(Modelo_Ajuste_Estoque ObjModeloAjuste, int id_usuario, int id_prod){
        ObjConecta.Conectar();
        
        String sql = "insert into ajuste_estoque (motivo, observacao, quantidade, produto_id_produto, lote_estoque_id_lote, usuario_id_usuario, situacao_ajuste) "
                + "values(?,?,?,?,?,?,?)";
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
                    JOptionPane.showMessageDialog(null,"Erro ao excluiro ajuste do banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
    
}

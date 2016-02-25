package Conexao;

// @author Márison Tamiarana

import Classes.Modelo_Ajuste_Estoque;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Controle_Ajuste_Estoque {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    
    public boolean Confirma_Ajuste = false;
    
    public void Inserir_Ajuste_Estoque(Modelo_Ajuste_Estoque ObjModeloAjuste, int id_usuario){
        ObjConecta.Conectar();
        
        String sql = "insert into ajuste_estoque (motivo, observacao, quantidade, produto_id_produto, lote_estoque_id_lote, usuario_id_usuario) "
                + "values(?,?,?,?,?,?)";  
            try {                
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, ObjModeloAjuste.getMotivo());
                        stmt.setString(2, ObjModeloAjuste.getObservacao());
                        stmt.setDouble(3, ObjModeloAjuste.getQuantidade());
                        stmt.setInt   (4, ObjModeloAjuste.getProduto_id_produto());
                        stmt.setInt   (5, ObjModeloAjuste.getLote_id_lote());
                        stmt.setInt   (6, id_usuario);
                    }
                    stmt.execute();
                    stmt.close();
                    
                }
                Confirma_Ajuste = true;
            } catch (SQLException ex) {
                Confirma_Ajuste = false;
                JOptionPane.showMessageDialog(null, "Erro ao ajustar o estoque no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
    
    
}

package Conexao;

//* @author Márison Tamiarana

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Controle_Log {

    Conecta_Banco ObjConecta = new Conecta_Banco();
    
    public void Registrar_Log(String acao, String id){
        ObjConecta.Conectar();
        try {
        String data = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
        String hora = new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
                
        String sql = "insert into log_sistema (acao, data, hora, usuario_id_usuario)"
                + "values(?,?,?,?)";
                
        
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, acao.toUpperCase());
                    stmt.setString(2, data);
                    stmt.setString(3, hora);
                    stmt.setInt   (4, Integer.parseInt(id));
                    
                }
                stmt.execute();
                stmt.close();
            }
                                 
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Erro ao inserir o log no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
        }        
        ObjConecta.Desconecta();
    }
    
}

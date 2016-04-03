package Conexao;

//* @author Márison Tamiarana

import com.toedter.calendar.JDateChooser;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Controle_Log {

    Conecta_Banco ObjConecta = new Conecta_Banco();
    public boolean controla_log;
    
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
    public void Consulta_Log_Intervalo(JDateChooser jdi,JDateChooser jdf){
        try {
            ObjConecta.Conectar();
            String di = new SimpleDateFormat("yyyy-MM-dd").format(jdi.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(jdf.getDate());
            ObjConecta.ExecutaSQL("select * from log_sistema where data between '"+di+"' and '"+df+"'");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_log_sistema");
            controla_log = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            controla_log = false;
            ObjConecta.Desconecta();
        }
    }
     public void Contar_Log_Hoje(JLabel jl, JTextField tf){
        try{
            ObjConecta.Conectar();
            String hoje = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
            ObjConecta.ExecutaSQL("select count(id_log_sistema) as cont from log_sistema where acao like '%"    
                    + tf.getText().toUpperCase() + "%' and data ='"+hoje+"'");
            ObjConecta.rs.first();
            jl.setText(String.valueOf(ObjConecta.rs.getInt("cont")));
            ObjConecta.Desconecta();
        
        }catch (SQLException ex){
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null,"Erro ao contar a quantidade de log no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);}
        }
     public void Contar_Log_Periodo(JLabel jl, String di, String df, JTextField tf){
        try{
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select count(id_log_sistema) as cont from log_sistema where acao like '%"    
                     + tf.getText().toUpperCase() + "%' and data between '"+di+"' and '"+df+"'");
            ObjConecta.rs.first();
            jl.setText(String.valueOf(ObjConecta.rs.getInt("cont")));
            ObjConecta.Desconecta();
        
        }catch (SQLException ex){
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null,"Erro ao contar a quantidade de log por periodo no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);}
        }
    
}

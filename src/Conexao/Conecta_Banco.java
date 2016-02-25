package Conexao;

//@author Márison Tamiarana
import java.sql.*; //Com "*" ele busca todas as importações
import javax.swing.JOptionPane;


public class Conecta_Banco {
    
    public PreparedStatement pstm;
    public Statement stm;//Responsavel por preparar e realizar pesquisas no banco de dados.
    public ResultSet rs;// Responsavel por armazenar o resulatdo de uma pesquisa passada para o statement.
    final String driver = "com.mysql.jdbc.Driver";//Responsavel por identificar o serviço do banco de dados.
    final String url = "jdbc:mysql://127.0.0.1/Coolab";//Responsavel por setar o local do banco de dados.
    final String usuario = "root";//Usuario padrão do banco
    final String senha = "andrey";//Senha criada na instalação do banco
    //final String senha = "SisCoE";//Senha criada na instalação do banco do Coolab
    public Connection conn;//Responsavel por realizar a conexão com o banco de dados.
    
    public boolean Conectado;

    public void Conectar() {//Metodo responsavel por realizar a conexão com o banco.
        try {//Tratatamento de erros.
            System.setProperty("jdbc.Drivers", driver);//Seta a propriedade do driver de conexão
            conn = DriverManager.getConnection(url, usuario, senha);//Realiza a conexão com o banco de dados.
            Conectado = true;
        } catch (SQLException ex) {
            Conectado = false;
             JOptionPane.showMessageDialog(null, "Erro De Conexao!\n "+ex.getMessage(),"Aviso",JOptionPane.INFORMATION_MESSAGE);
        }
}
    public void Conectar_Msg() {//Metodo responsavel por realizar a conexão com o banco.
        try {//Tratatamento de erros.
            System.setProperty("jdbc.Drivers", driver);//Seta a propriedade do driver de conexão
            conn = DriverManager.getConnection(url, usuario, senha);//Realiza a conexão com o banco de dados.
             JOptionPane.showMessageDialog(null, "Conexao Realizada Com Sucesso!","Aviso",JOptionPane.INFORMATION_MESSAGE);//Imprime uma mensagem.
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro De Conexao!\n "+ex.getMessage(),"Aviso",JOptionPane.INFORMATION_MESSAGE);
        }
}
     public void ExecutaSQL(String sql){
        try {
           
                //stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
                stm = conn.createStatement();
                rs = stm.executeQuery(sql);
            } catch (SQLException ex) {
        }
    }
     
     public void ExecutaSQL2(String sql){
        try{        
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
           }catch(SQLException ex){}
    }

    public void Desconecta(){//Metodo responsavel por encerrar a conexão com o banco.
        try {
            conn.close();//Fecha a conexão
            //JOptionPane.showMessageDialog(null, "Conexao Finalizada Com Sucesso!","Aviso",JOptionPane.INFORMATION_MESSAGE);//Imprime uma mensagem.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Ao Encerrar A Conexao!\n "+ex.getMessage(),"Aviso",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void Ultimo_Id(String sql, String sql2) throws Exception {
       
        try {
             Conectar();//Testa e abre a conexão com o banco
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            rs.last();
            
                int Id = rs.getInt(sql2);
                //JOptionPane.showMessageDialog(null, Id);
            
            Desconecta();//Fecha a conexão com o banco de dados

        } catch (SQLException ex) {

        }
    }
    

}

   
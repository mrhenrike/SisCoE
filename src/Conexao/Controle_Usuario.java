package Conexao;

//@author Márison Tamiarana

import Classes.Modelo_Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class Controle_Usuario {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    public boolean Confirma_Inserir = false;//Variavel para testar se o cadastro foi inserido com sucesso
    public boolean Confirma_Alterar= false;//Variavel para testar se o cadastro foi alterado com sucesso
    public boolean Confirma_Alterar_Senha= false;//Variavel para testar se a senha foi alterada com sucesso
    public boolean Confirma_Excluir= false;//Variavel para testar se o cadastro foi excluido com sucesso
    public boolean Confirma_Busca = false;//Variavel para testar se o cadastro foi encontrado com sucesso
    public boolean Confirma_Inativo = false;//Variavel para testar se o cadastro foi inativado com sucesso
    public boolean Confirma_Ativo = false;//Variavel para testar se o cadastro foi ativado com sucesso
    public boolean ControleExistente = false;//Variavel para testar se o usuario ja existe no sistema
    public boolean ControleAcesso = false;//Variavel para controlar o login
    public boolean ControleAcessoBloqueio = false;//Variavel para controlar o login na tela de bloqueio
    public boolean ControleAdm = false;//Variavel para verificar se ja existe um administrador
    public String Adm_Senha;
    public String Adm_Login;
    public int Adm_Id;
    
    public void Inserir_Usuario(Modelo_Usuario ObjUsu){
        ObjConecta.Conectar();
        
        String sql = "insert into usuario (situacao, nome, login, senha, telefone, data_cad, sexo, permissao)"
                + "values(?,?,?,?,?,?,?,?)";
                
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, "ATIVO");
                    stmt.setString(2, ObjUsu.getNome());
                    stmt.setString(3, ObjUsu.getLogin());
                    stmt.setString(4, ObjUsu.getSenha());
                    stmt.setString(5, ObjUsu.getTelefone());
                    stmt.setString(6, ObjUsu.getData_cad());
                    stmt.setString(7, ObjUsu.getSexo());
                    stmt.setString(8, ObjUsu.getPermissao());
                    
                }
                stmt.execute();
                stmt.close();
            }
           
           Confirma_Inserir = true;
           
        } catch (SQLException ex) {
            Confirma_Inserir=false;
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o usuario no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }
    
    public void Alterar_Usuario(Modelo_Usuario ObjModeloUser, String id){
        ObjConecta.Conectar();
        
        String sql = "update usuario set nome=?, login=?, senha=?, telefone=?, sexo=?, permissao=?, situacao=? where id_usuario="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, ObjModeloUser.getNome());
                    stmt.setString(2, ObjModeloUser.getLogin());
                    stmt.setString(3, ObjModeloUser.getSenha());
                    stmt.setString(4, ObjModeloUser.getTelefone());
                    stmt.setString(5, ObjModeloUser.getSexo());
                    stmt.setString(6, ObjModeloUser.getPermissao());
                    stmt.setString(7, ObjModeloUser.getSituacao());
                }
                stmt.execute();
                stmt.close();
            }
           
           Confirma_Alterar = true;           
           
        } catch (SQLException ex) {
            Confirma_Alterar = false;
            JOptionPane.showMessageDialog(null,"Erro ao alterar os dados do usuario no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }
    
    public Modelo_Usuario Consulta_Usuario_Senha(Modelo_Usuario ObjModeloUser, String login) throws SQLException{
        try {
            ObjConecta.Conectar();

            String sql = "select * from usuario where login=" + "'" + login + "'" + "";

            try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql);
                    ResultSet rs = stm.executeQuery()) {

                rs.first();
                ObjModeloUser.setLogin(rs.getString("login"));
                ObjModeloUser.setSenha(rs.getString("senha"));

                ObjConecta.Desconecta();
                Confirma_Busca = true;
            }
        } catch (SQLException Erro) {            
            Confirma_Busca = false;
            ObjConecta.Desconecta();
        }

    return ObjModeloUser;

}
    
    public void Alterar_Senha_Usuario(Modelo_Usuario ObjModeloUser, Modelo_Usuario ObjModeloUser2)throws SQLException{
        try {
            ObjConecta.Conectar();
        
            String sql = "update usuario set senha=? where login="+"'"+ObjModeloUser.getLogin()+"'"+" and senha="+"'"+ObjModeloUser.getSenha()+" '"+" ";
            
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, ObjModeloUser2.getSenha());
                }
                stmt.execute();
                stmt.close();
                Confirma_Alterar_Senha = true;
            } 
           
        } catch (SQLException ex) 
        {
            Confirma_Alterar_Senha = false;
            JOptionPane.showMessageDialog(null,"Erro ao alterar a senha do usuario no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
        }  
        
        ObjConecta.Desconecta();
    }
    
    public void Excluir_Usuario(String id){
        ObjConecta.Conectar();
        
        String sql = "delete from usuario where id_usuario="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.execute();
                stmt.close();
                Confirma_Excluir = true;
            }
        } catch (SQLException ex) 
            {
                Confirma_Excluir = false;
                JOptionPane.showMessageDialog(null,"Erro ao excluir os dados do usuario no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();
    }
    
    public void Desativar_Usuario(String id){
        ObjConecta.Conectar();
        String sql = "update usuario set situacao=? where id_usuario="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.setString(1,"INATIVO");
                stmt.execute();
                stmt.close();
                Confirma_Inativo = true;
            }
        } catch (SQLException ex) 
            {
                Confirma_Inativo = false;
                JOptionPane.showMessageDialog(null,"Erro ao Inativar os dados do usuario no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();
        
    }
    
    public void Ativar_Usuario(String id){
        ObjConecta.Conectar();
        String sql = "update usuario set situacao=? where id_usuario="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.setString(1,"ATIVO");
                stmt.execute();
                stmt.close();
                Confirma_Ativo = true;
            }
        } catch (SQLException ex) 
            {
                Confirma_Ativo = false;
                JOptionPane.showMessageDialog(null,"Erro ao Ativar os dados do usuario no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }  
        ObjConecta.Desconecta();
        
    }
    

public Modelo_Usuario Consulta_Usuario(Modelo_Usuario ObjModeloUser) throws SQLException{
      
        ObjConecta.Conectar();
        
        String sql = "select * from usuario where id_usuario=" +ObjModeloUser.getPesquisa()+"";
        try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql); 
             ResultSet rs = stm.executeQuery()) {
             
        rs.first();
      
            ObjModeloUser.setId_usuario(rs.getInt("id_usuario"));
            ObjModeloUser.setNome(rs.getString("nome"));
            ObjModeloUser.setSexo(rs.getString("sexo"));
            ObjModeloUser.setLogin(rs.getString("login"));
            ObjModeloUser.setSenha(rs.getString("senha"));
            ObjModeloUser.setPermissao(rs.getString("permissao"));
            ObjModeloUser.setTelefone(rs.getString("telefone"));
            ObjModeloUser.setSituacao(rs.getString("situacao"));
       
        ObjConecta.Desconecta();
   
    return ObjModeloUser;
    }
    }

 public void Testar_Existente(JTextField jt){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from usuario");        
            ObjConecta.rs.first();            
            do
            {
                String Login = ObjConecta.rs.getString("login");
                if(jt.getText().equalsIgnoreCase(Login)){
                   ControleExistente=true;
                }
            }
            while(ObjConecta.rs.next());
            } catch (SQLException ex) {
            ControleExistente=false;
            ObjConecta.Desconecta();            
        }
        ObjConecta.Desconecta();
    }
 
 public void Procura_Nome_Usuario(JLabel jl, String lg, JLabel jlcod){
      try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from usuario where login='"+lg+"' and situacao='ATIVO'" );        
            ObjConecta.rs.first();            
            
                jl.setText(ObjConecta.rs.getString("nome"));
                jlcod.setText(ObjConecta.rs.getString("id_usuario"));
            
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
        }
      ObjConecta.Desconecta();
    }
 public void Controle_Acesso(JTextField jt, JComboBox cb, JPasswordField jp){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from usuario");        
            ObjConecta.rs.first();            
            do
            {
                String Login = ObjConecta.rs.getString("login");
                String Permissao = ObjConecta.rs.getString("permissao");
                String Senha = ObjConecta.rs.getString("senha");
                String Situacao = ObjConecta.rs.getString("situacao");
                
                if(jt.getText().equalsIgnoreCase(Login) && cb.getSelectedItem().equals(Permissao)
                        && new String(jp.getPassword()).equals(Senha) && Situacao.equalsIgnoreCase("ATIVO")){
                   ControleAcesso=true;
                }
            }
            while(ObjConecta.rs.next());
            } catch (SQLException ex) {
            ControleAcesso=false;
            ObjConecta.Desconecta();
        }
        ObjConecta.Desconecta();
    }
 public void Controle_Acesso_Bloqueio(String user, JPasswordField jp){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from usuario");        
            ObjConecta.rs.first();            
            do
            {
                String Nome = ObjConecta.rs.getString("nome");
                String Senha = ObjConecta.rs.getString("senha");
                
                if(user.equalsIgnoreCase(Nome) && new String(jp.getPassword()).equals(Senha)){
                   ControleAcessoBloqueio=true;
                }
            }
            while(ObjConecta.rs.next());
            } catch (SQLException ex) {
            ControleAcessoBloqueio=false;
            
        }
    }
//inserir o administrador do sistema
 public void Inserir_Admin(Modelo_Usuario ObjUsu){
    ObjConecta.Conectar();
        String sql = "insert into usuario (situacao, login, senha, data_cad, permissao)"
                + "values(?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, "ATIVO");
                    stmt.setString(2, ObjUsu.getLogin());
                    stmt.setString(3, ObjUsu.getSenha());
                    stmt.setString(4, ObjUsu.getData_cad());
                    stmt.setString(5, "SISTEMA");
                }
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o administrador no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }//fim do metodo
 
 public void Primeiro_Acesso(){
    try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from usuario where permissao = 'SISTEMA'");        
        ObjConecta.rs.first();            
        String Usuario = ObjConecta.rs.getString("login");
        ControleExistente = true;
        ObjConecta.Desconecta();
    } catch (SQLException ex) {
        ControleExistente=false; 
        ObjConecta.Desconecta();
    }
}
 
 public void Acesso_Adm(String permissao){
    try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from usuario where situacao = 'ATIVO' and permissao = '"+permissao+"'");        
        ObjConecta.rs.first();            
        Adm_Login = ObjConecta.rs.getString("login");
        Adm_Senha = ObjConecta.rs.getString("senha");
        Adm_Id = ObjConecta.rs.getInt("id_usuario");
        ControleAdm = true;
        ObjConecta.Desconecta();
        
    } catch (SQLException ex) {   
        ObjConecta.Desconecta();
        ControleAdm = false;
    }
}
 
}
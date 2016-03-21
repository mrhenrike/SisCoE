package Conexao;

// @author Márison Tamiarana

import Classes.Modelo_Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Controle_Curso {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Modelo_Curso ObjModCurso = new Modelo_Curso();
    
    public boolean Confirma_Inserir = false;
    public boolean Confirma_Ativar = false;
    public boolean Controle_Existente = false;
    public boolean Confirma_Alterar = false;
    
    public void Inserir_Curso(Modelo_Curso ObjModeloCurso){
        try { 
                ObjConecta.Conectar();
                String sql = "insert into curso (nome_curso, abrev_curso, situacao_curso, data_cad_curso)values(?,?,?,?)";  
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, ObjModeloCurso.getNome_curso());
                        stmt.setString(2, ObjModeloCurso.getAbrev_curso());
                        stmt.setString(3, "ATIVO");
                        stmt.setString(4, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                    }
                    stmt.execute();
                    stmt.close();
                    
                }
                Confirma_Inserir = true;
                
                ObjConecta.ExecutaSQL("select LAST_INSERT_ID()");
                ObjConecta.rs.first();
                ObjModeloCurso.setId_curso(ObjConecta.rs.getInt(1));
                
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Inserir = false;
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar o curso no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
    
     public void Preencher_CB_Curso(JComboBox jb) {
        try {
            jb.removeAllItems();
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL2("select * from curso where situacao_curso= 'ATIVO' order by nome_curso");
            ObjConecta.rs.first();
            jb.addItem(" ");
            do {
                jb.addItem(ObjConecta.rs.getString("nome_curso"));                
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            //JOptionPane.showMessageDialog(null, "Erro Ao Preencher O ComboBox Curso!");
        }
    }
     
    public void Ativa_Curso(String id){
         try { 
                ObjConecta.Conectar();
                String sql = "update curso set situacao_curso=?, data_ultima_alteracao_curso=? where id_curso ="+id+"";  
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, "ATIVO");
                        stmt.setString(2, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                    }
                    stmt.execute();
                    stmt.close();                    
                }
                Confirma_Ativar = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Ativar = false;
                JOptionPane.showMessageDialog(null, "Erro ao Ativar o curso no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
    public Modelo_Curso Procura_Id_Curso(Modelo_Curso ObjModeloCurso, JComboBox jcb){
        if(jcb.getSelectedIndex()!=0){
            try {
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("Select * from curso where nome_curso='" + jcb.getSelectedItem().toString() + "' and situacao_curso = 'ATIVO'");
                ObjConecta.rs.first();
                ObjModeloCurso.setId_curso(ObjConecta.rs.getInt("id_curso"));
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                //JOptionPane.showMessageDialog(null,"Erro ao procurar o id do curso no banco! \n"
                   // +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return ObjModeloCurso;
    }
    
    public Modelo_Curso Consulta_Curso(Modelo_Curso ObjModeloCurso, Object id_curso){
        try{
            ObjConecta.Conectar();
        
            String sql = "select * from curso where id_curso = " +id_curso+"";
     
            try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql); 
                ResultSet rs = stm.executeQuery()) {
             
                rs.first();
      
                ObjModeloCurso.setId_curso(rs.getInt("id_curso"));
                ObjModeloCurso.setNome_curso(rs.getString("nome_curso"));
                ObjModeloCurso.setAbrev_curso(rs.getString("abrev_curso"));
                ObjModeloCurso.setSituacao(rs.getString("situacao_curso"));
                   
            ObjConecta.Desconecta();
        }
        }catch(SQLException erro){
            ObjConecta.Desconecta();}  
    return ObjModeloCurso;
    }
    
    public void Testar_Existente(JTextField jt){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from curso");        
            ObjConecta.rs.first();            
            do
            {
                String curso = ObjConecta.rs.getString("nome_curso");
                if(jt.getText().equalsIgnoreCase(curso)){
                   Controle_Existente=true;
                }
            }
            while(ObjConecta.rs.next());
            ObjConecta.Desconecta();
            } catch (SQLException ex) {
            Controle_Existente=false;
            ObjConecta.Desconecta();
        }
    }
    
     public void Alterar_Curso(Modelo_Curso ObjModeloCurso, String id){
         try { 
                ObjConecta.Conectar();
                String sql = "update curso set nome_curso=?, abrev_curso=?, situacao_curso=?, data_ultima_alteracao_curso=? where id_curso="+id+"";
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, ObjModeloCurso.getNome_curso());
                        stmt.setString(2, ObjModeloCurso.getAbrev_curso());
                        stmt.setString(3, ObjModeloCurso.getSituacao());
                        stmt.setString(4, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                    }
                    stmt.execute();
                    stmt.close();
                    
                }
                Confirma_Alterar = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Alterar = false;
                JOptionPane.showMessageDialog(null, "Erro ao alterar a curso no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    
    }
    
}

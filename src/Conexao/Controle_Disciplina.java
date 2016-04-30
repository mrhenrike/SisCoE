package Conexao;

// @author Márison Tamiarana

import Classes.Modelo_Disciplina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Controle_Disciplina {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Conecta_Banco ObjConecta2 = new Conecta_Banco();
    
    public boolean Confirma_Inserir_Disciplina;
    public boolean Controle_Existente = false;
    public boolean Confirma_Ativar_Disciplina = false;
    public boolean Confirma_Alterar = false;
    
    public void Inserir_Disciplina(Modelo_Disciplina ObjModDisciplina){
        try{
            ObjConecta.Conectar();
            String sql = "insert into disciplina (disciplina, semestre, curso_id_curso, situacao_disciplina, data_cad_disciplina) values (?,?,?,?,?)";
        
            try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
            {
                {
                    stmt.setString(1, ObjModDisciplina.getDisciplina());
                    stmt.setInt   (2, ObjModDisciplina.getSemestre());
                    stmt.setInt   (3, ObjModDisciplina.getId_curso());
                    stmt.setString(4, "ATIVO");
                    stmt.setString(5, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                }
                stmt.execute();
                stmt.close();
            }
            ObjConecta.ExecutaSQL("select LAST_INSERT_ID()");
            ObjConecta.rs.first();
            ObjModDisciplina.setId_disciplina(ObjConecta.rs.getInt(1));
            ObjConecta.Desconecta();
            
            Confirma_Inserir_Disciplina = true;
            
        } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Inserir_Disciplina = false;
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a disciplina no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
    
    public Modelo_Disciplina Procura_Id_Disciplina(Modelo_Disciplina ObjModeloDisciplina, JComboBox disciplina, JComboBox semestre){
        if(disciplina.getSelectedIndex()!=0){
            try {
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("Select * from disciplina where disciplina='" + disciplina.getSelectedItem().toString() + "' and situacao_disciplina = 'ATIVO' "
                        + " and semestre =" + semestre.getSelectedItem().toString().trim() + " ");
                ObjConecta.rs.first();
                ObjModeloDisciplina.setId_disciplina(ObjConecta.rs.getInt("id_disciplina"));
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                //JOptionPane.showMessageDialog(null,"Erro ao procurar o id da disciplina no banco! \n"
                   // +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return ObjModeloDisciplina;
    }
    
    public Modelo_Disciplina Procura_Id_Disciplina(Modelo_Disciplina ObjModeloDisciplina, JComboBox disciplina, String sql_semestre){
        if(disciplina.getSelectedIndex()!=0){
            try {
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("Select * from disciplina where disciplina='" + disciplina.getSelectedItem().toString() + "' and situacao_disciplina = 'ATIVO' "
                        + sql_semestre + " ");
                ObjConecta.rs.first();
                ObjModeloDisciplina.setId_disciplina(ObjConecta.rs.getInt("id_disciplina"));
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                //JOptionPane.showMessageDialog(null,"Erro ao procurar o id da disciplina no banco! \n"
                   // +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return ObjModeloDisciplina;
    }
    
    public void Preencher_CB_Disciplina_Semestre(JComboBox curso, JComboBox jcb) {
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select distinct disciplina.semestre from disciplina inner join curso "
                    + "on disciplina.curso_id_curso = curso.id_curso where curso.nome_curso='"+curso.getSelectedItem().toString()+"' "
                    + "and disciplina.situacao_disciplina ='ATIVO' order by disciplina.semestre");
            jcb.removeAllItems();
            ObjConecta.rs.first();
            jcb.addItem(" ");
            do {
                jcb.addItem(ObjConecta.rs.getString("semestre"));                
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
                jcb.removeAllItems();
        }
    }
    
    public void Preencher_CB_Disciplina(JComboBox curso, JComboBox semestre,JComboBox jcb) {
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select distinct disciplina.disciplina from disciplina inner join curso "
                    + "on disciplina.curso_id_curso = curso.id_curso where curso.nome_curso='"+curso.getSelectedItem().toString()+"' "
                    + "and semestre ="+semestre.getSelectedItem().toString()+" and disciplina.situacao_disciplina ='ATIVO' "
                    + "order by disciplina.disciplina");
            jcb.removeAllItems();
            ObjConecta.rs.first();
            jcb.addItem(" ");
            do {
                jcb.addItem(ObjConecta.rs.getString("disciplina"));                
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
                jcb.removeAllItems();
        }
    }
    
    public void Testar_Existente(JComboBox jc_semestre, JTextField jt_disciplina, JComboBox jc_curso){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from disciplina");        
            ObjConecta.rs.first();            
            do
            {
                String semestre = ObjConecta.rs.getString("semestre");
                String disciplina = ObjConecta.rs.getString("disciplina");
                int id = ObjConecta.rs.getInt("curso_id_curso");
                
                                
                ObjConecta2.Conectar();
                String sql = "Select * from curso where nome_curso="+"'"+jc_curso.getSelectedItem().toString()+"'"+"";
                Statement st = ObjConecta2.conn.createStatement();
                ResultSet rs2;
                rs2 = st.executeQuery(sql);
                rs2.first();
                int id_curso = rs2.getInt("id_curso");
                ObjConecta2.Desconecta();
                
                
                if(jc_semestre.getSelectedItem().toString().equalsIgnoreCase(semestre)
                        && jt_disciplina.getText().trim().equalsIgnoreCase(disciplina)
                        && id == id_curso ){
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
    
    public void Ativa_Disciplina(String id){
         try { 
                ObjConecta.Conectar();
                String sql = "update disciplina set situacao_disciplina =?, data_ultima_alteracao_disciplina =? where id_disciplina ="+id+"";  
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, "ATIVO");
                        stmt.setString(2, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                    }
                    stmt.execute();
                    stmt.close();                    
                }
                Confirma_Ativar_Disciplina = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Ativar_Disciplina = false;
                JOptionPane.showMessageDialog(null, "Erro ao ativar a disciplina no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
    
    public Modelo_Disciplina Consulta_Disciplina(Modelo_Disciplina ObjModeloDisciplina, Object id_Disciplina){
        try{
            ObjConecta.Conectar();
        
            String sql = "select * from disciplina where id_disciplina = " +id_Disciplina+"";
     
            try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql); 
                ResultSet rs = stm.executeQuery()) {
             
                rs.first();
      
                ObjModeloDisciplina.setId_disciplina(rs.getInt("id_disciplina"));
                ObjModeloDisciplina.setDisciplina(rs.getString("disciplina"));
                ObjModeloDisciplina.setSemestre(rs.getInt("semestre"));
                ObjModeloDisciplina.setSituacao(rs.getString("situacao_disciplina"));
                ObjModeloDisciplina.setId_curso(rs.getInt("curso_id_curso"));
                   
            ObjConecta.Desconecta();
        }
        }catch(SQLException erro){ObjConecta.Desconecta();}  
    return ObjModeloDisciplina;
    }
    
    public void Alterar_Disciplina (Modelo_Disciplina ObjModeloDisciplina, String id){
         try { 
                ObjConecta.Conectar();
                String sql = "update disciplina set disciplina=?, semestre=?, situacao_disciplina=?, curso_id_curso=?, data_ultima_alteracao_disciplina=? "
                        + "where id_disciplina="+id+"";
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, ObjModeloDisciplina.getDisciplina());
                        stmt.setInt   (2, ObjModeloDisciplina.getSemestre());
                        stmt.setString(3, ObjModeloDisciplina.getSituacao());
                        stmt.setInt   (4, ObjModeloDisciplina.getId_curso());
                        stmt.setString(5, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                    }
                    stmt.execute();
                    stmt.close();
                    
                }
                Confirma_Alterar = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Alterar = false;
                JOptionPane.showMessageDialog(null, "Erro ao alterar a disciplina no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    
    }
    
    public void Preencher_CB_Disciplina(JComboBox jb, String sql_semestre, String curso){
       try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from disciplina inner join curso on curso.id_curso = disciplina.curso_id_curso "
                    + " where situacao_disciplina = 'ATIVO' and nome_curso = '"+curso+"' "+sql_semestre+" order by semestre, disciplina");
            ObjConecta.rs.first();
            do {
                jb.addItem(ObjConecta.rs.getString("disciplina"));                
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            //JOptionPane.showMessageDialog(null, "Erro Ao Preencher O ComboBox Curso!");
        }
   }
    
}

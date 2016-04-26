package Conexao;

//@author Márison Tamiarana

import Classes.Modelo_Turma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Controle_Turma {
    
     Conecta_Banco ObjConecta = new Conecta_Banco();
     Conecta_Banco ObjConecta2 = new Conecta_Banco();
     
    public boolean Confirma_Inserir_Turma = false;
    public boolean Confirma_Ativar_Turma = false;
    public boolean Controle_Existente = false;
    public boolean Confirma_Alterar = false;
     
    public void Inserir_Turma(Modelo_Turma ObjModeloTurma){
        try { 
                ObjConecta.Conectar();
                String sql = "insert into turma (semestre, turno, ano_turma, semestre_vestibular, curso_id_curso, situacao_turma, turma, data_cad_turma)"
                        + "values(?,?,?,?,?,?,?,?)";  
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setInt   (1, ObjModeloTurma.getSemestre());
                        stmt.setString(2, ObjModeloTurma.getTurno());
                        stmt.setString(3, ObjModeloTurma.getAno_turma());
                        stmt.setInt   (4, ObjModeloTurma.getSemestre_vestibular());
                        stmt.setInt   (5, ObjModeloTurma.getId_curso());
                        stmt.setString(6, "ATIVO");
                        stmt.setString(7, ObjModeloTurma.getTurma());
                        stmt.setString(8, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                    }
                    stmt.execute();
                    stmt.close();
                    
                }
                Confirma_Inserir_Turma = true;
                
                ObjConecta.ExecutaSQL("select LAST_INSERT_ID()");
                ObjConecta.rs.first();
                ObjModeloTurma.setId_turma(ObjConecta.rs.getInt(1));
                       
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Inserir_Turma = false;
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a turma no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
    
    public void Ativa_Turma(String id){
         try { 
                ObjConecta.Conectar();
                String sql = "update turma set situacao_turma=?, data_ultima_alteracao_turma=? where id_turma ="+id+"";  
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, "ATIVO");
                        stmt.setString(2, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                    }
                    stmt.execute();
                    stmt.close();                    
                }
                Confirma_Ativar_Turma = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Ativar_Turma = false;
                JOptionPane.showMessageDialog(null, "Erro ao ativar a turma no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
    
    public Modelo_Turma Consulta_Turma_Concat(Modelo_Turma ObjModeloTurma, Object id)throws SQLException{
        ObjConecta.Conectar();
        
       String sql = "select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                + "from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma=" + id + "";
       
       try(PreparedStatement stm = ObjConecta.conn.prepareStatement(sql);
           ResultSet rs = stm.executeQuery()){
                    
           rs.first();
           
           ObjModeloTurma.setPesquisa(rs.getString("turma"));
        
        ObjConecta.Desconecta(); 
        
        return ObjModeloTurma;        
       }
    }
    
    public void Preencher_CB_Turma(JComboBox jcb, int id, String turno) {
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                + "from curso inner join turma on curso.id_curso = turma.curso_id_curso where curso.id_curso= "+ id + " "
                + " and turma.turno ='"+turno+"'");
            jcb.removeAllItems();
            ObjConecta.rs.first();
            jcb.addItem(" ");
            do {
                jcb.addItem(ObjConecta.rs.getString("turma"));                
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
                jcb.removeAllItems();
        }
    }
    public void Preencher_CB_Ano(JComboBox jcb, int id, String turno) {
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select distinct turma.ano_turma from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + "where curso.id_curso= "+ id + " and turma.turno ='"+turno+"'");
            jcb.removeAllItems();
            ObjConecta.rs.first();
            jcb.addItem(" ");
            do {
                jcb.addItem(ObjConecta.rs.getString("turma.ano_turma"));                
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
                jcb.removeAllItems();
        }
    }
    
    public void Preencher_CB_Semestre(JComboBox jcb, int id, String turno, String ano) {
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select distinct turma.semestre from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + "where curso.id_curso= "+ id + " and turma.turno ='"+turno+"' and turma.ano_turma = '"+ano+"'");
            jcb.removeAllItems();
            ObjConecta.rs.first();
            jcb.addItem(" ");
            do {
                jcb.addItem(ObjConecta.rs.getString("turma.semestre"));                
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
                jcb.removeAllItems();
        }
    }
    
    public void Preencher_CB_Vestibular(JComboBox jcb, int id, String turno, String ano, String semestre) {
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select distinct turma.semestre_vestibular from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + "where curso.id_curso= "+ id + " and turma.turno ='"+turno+"' and turma.ano_turma = '"+ano+"' "
                    + "and turma.semestre = "+semestre+"");
            jcb.removeAllItems();
            ObjConecta.rs.first();
            jcb.addItem(" ");
            do {
                jcb.addItem(ObjConecta.rs.getString("turma.semestre_vestibular"));                
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
                jcb.removeAllItems();
        }
    }
    public void Preencher_CB_Turma_Saida(JComboBox jcb, int id, String turno, String ano, String semestre, String semestre_vest) {
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select distinct turma.turma from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + "where curso.id_curso= "+ id + " and turma.turno ='"+turno+"' and turma.ano_turma = '"+ano+"' "
                    + "and turma.semestre = "+semestre+" and turma.semestre_vestibular= "+semestre_vest+" order by turma.turma");
            jcb.removeAllItems();
            ObjConecta.rs.first();
            String turma = ObjConecta.rs.getString("turma.turma");
            if(!turma.equalsIgnoreCase("")){
                jcb.addItem(" ");
                do {
                    jcb.addItem(ObjConecta.rs.getString("turma.turma"));                
                } while (ObjConecta.rs.next());
                ObjConecta.Desconecta();
            }else{jcb.removeAllItems();}
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
                jcb.removeAllItems();
        }
    }
    
   public Modelo_Turma Procura_Id_Turma(Modelo_Turma ObjModeloTurma, JComboBox curso,JComboBox semestre, JComboBox turno, 
           JComboBox ano, JComboBox vestibular, JComboBox turma){
        if(curso.getSelectedIndex()!=0){
            String sql;
            if(turma.getSelectedIndex()== -1){
                sql = "select* from turma where semestre='" + semestre.getSelectedItem().toString() + "' "
                        + " and turno = '" + turno.getSelectedItem().toString() + "' "
                        + " and ano_turma = '" + ano.getSelectedItem().toString() + "' "
                        + " and semestre_vestibular = '" + vestibular.getSelectedItem().toString() + "' "
                        + " and situacao_turma = 'ATIVO'";
            }else{
                sql = "select* from turma where semestre='" + semestre.getSelectedItem().toString() + "' "
                        + " and turno = '" + turno.getSelectedItem().toString() + "' "
                        + " and ano_turma = '" + ano.getSelectedItem().toString() + "' "
                        + " and semestre_vestibular = '" + vestibular.getSelectedItem().toString() + "' "
                        + " and turma = '" + turma.getSelectedItem().toString().trim() + "' "
                        + " and situacao_turma = 'ATIVO'";
            }
            try {
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL(sql);
                ObjConecta.rs.first();
                ObjModeloTurma.setId_turma(ObjConecta.rs.getInt("id_turma"));
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                //JOptionPane.showMessageDialog(null,"Erro ao procurar o id do curso no banco! \n"
                   // +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return ObjModeloTurma;
    }
   public void Testar_Existente(JComboBox jc_semestre,JComboBox jc_turno,JComboBox jc_ano_turma, 
           JComboBox jc_semestre_vest, JComboBox jc, JComboBox jc_turma){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from turma");        
            ObjConecta.rs.first();            
            do
            {
                ObjConecta2.Conectar();
                String sql = "Select * from curso where nome_curso="+"'"+jc.getSelectedItem().toString()+"'"+"";
                Statement st = ObjConecta2.conn.createStatement();
                ResultSet rs2;
                rs2 = st.executeQuery(sql);
                rs2.first();
                int id_curso = rs2.getInt("id_curso");
                ObjConecta2.Desconecta();
                                
                String semestre = ObjConecta.rs.getString("semestre");
                String turno = ObjConecta.rs.getString("turno");
                String ano_turma = ObjConecta.rs.getString("ano_turma");
                String Semestre_vest = ObjConecta.rs.getString("semestre_vestibular");
                String turma = ObjConecta.rs.getString("turma");
                int id = ObjConecta.rs.getInt("curso_id_curso");
                
                if(jc_semestre.getSelectedItem().toString().equalsIgnoreCase(semestre)
                        && jc_turno.getSelectedItem().toString().equalsIgnoreCase(turno)
                        && jc_ano_turma.getSelectedItem().toString().equalsIgnoreCase(ano_turma)
                        && jc_semestre_vest.getSelectedItem().toString().equalsIgnoreCase(Semestre_vest)
                        && jc_turma.getSelectedItem().toString().trim().equalsIgnoreCase(turma)
                        && id == id_curso ){
                   Controle_Existente=true;
                }
            }
            while(ObjConecta.rs.next());
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex);
            Controle_Existente=false;
            ObjConecta.Desconecta();
        }
        ObjConecta.Desconecta();
    }
   public Modelo_Turma Consulta_Turma(Modelo_Turma ObjModeloTurma, Object id_turma){
        try{
            ObjConecta.Conectar();
        
            String sql = "select * from turma where id_turma = " +id_turma+"";
     
            try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql); 
                ResultSet rs = stm.executeQuery()) {
             
                rs.first();
      
                ObjModeloTurma.setId_turma(rs.getInt("id_turma"));
                ObjModeloTurma.setSemestre(rs.getInt("semestre"));
                ObjModeloTurma.setTurno(rs.getString("turno"));
                ObjModeloTurma.setAno_turma(rs.getString("ano_turma"));
                ObjModeloTurma.setSemestre_vestibular(rs.getInt("semestre_vestibular"));
                ObjModeloTurma.setSituacao(rs.getString("situacao_turma"));
                ObjModeloTurma.setTurma(rs.getString("turma"));
                ObjModeloTurma.setId_curso(rs.getInt("curso_id_curso"));
                   
            ObjConecta.Desconecta();
        }
        }catch(SQLException erro){ObjConecta.Desconecta();}  
    return ObjModeloTurma;
    }
   
   public void Alterar_Turma(Modelo_Turma ObjModeloTurma, String id){
         try { 
                ObjConecta.Conectar();
                String sql = "update turma set semestre=?, turno=?, ano_turma=?, semestre_vestibular=?, situacao_turma=?, curso_id_curso=?, turma=?, "
                        + " data_ultima_alteracao_turma=? where id_turma= "+id+"";
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setInt   (1, ObjModeloTurma.getSemestre());
                        stmt.setString(2, ObjModeloTurma.getTurno());
                        stmt.setString(3, ObjModeloTurma.getAno_turma());
                        stmt.setInt   (4, ObjModeloTurma.getSemestre_vestibular());
                        stmt.setString(5, ObjModeloTurma.getSituacao());
                        stmt.setInt   (6, ObjModeloTurma.getId_curso());
                        stmt.setString(7, ObjModeloTurma.getTurma());
                        stmt.setString(8, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                    }
                    stmt.execute();
                    stmt.close();                    
                }
                Confirma_Alterar = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Alterar = false;
                JOptionPane.showMessageDialog(null, "Erro ao alterar a turma no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
   }
   
   public void Preencher_CB_Turma_Concat(JComboBox jb, String sql_semestre, String curso, String ano){
       try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turmas "
                    + " from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + " where situacao_turma = 'ATIVO' and nome_curso = '"+curso+"' "+sql_semestre+" and ano_turma = '"+ano+"' order by semestre, turma");
            ObjConecta.rs.first();
            do {
                jb.addItem(ObjConecta.rs.getString("turmas"));                
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            //JOptionPane.showMessageDialog(null, "Erro Ao Preencher O ComboBox Curso!");
        }
   }
   
   public Modelo_Turma Consulta_Turma_Id(Modelo_Turma ObjModeloTurma,  String sql_semestre, String curso, String turma){
       try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select id_turma from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + " where situacao_turma = 'ATIVO' and nome_curso = '"+curso+"' "+sql_semestre+" "
                    + " and (select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma)) = '"+turma+"'");
            ObjConecta.rs.first();
            ObjModeloTurma.setId_turma(ObjConecta.rs.getInt("id_turma"));
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            //JOptionPane.showMessageDialog(null, "Erro Ao Preencher O ComboBox Curso!");
        }
         return ObjModeloTurma;
   }
}

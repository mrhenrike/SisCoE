package Conexao;

//@author Márison Tamiarana

import static GUI_Frames.Tela_Principal.UserLogado;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Controle_Relatorio_Curso_Turma_Disciplina {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    
    public void Relatorio_Disciplina_Todas(){
        try {
            ObjConecta.Conectar();
            //conta os cursos
            ObjConecta.ExecutaSQL("select count(distinct id_curso) as cont from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_curso = 'ATIVO' ");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //Contar as disciplina
            ObjConecta.ExecutaSQL("select count(distinct id_disciplina)as cont from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_disciplina = 'ATIVO' ");
            ObjConecta.rs.first();
            int Cont_Disciplina = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("select * from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_curso = 'ATIVO' and situacao_disciplina = 'ATIVO' order by nome_curso, semestre, disciplina");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Tipo_Relatorio","Todas Disciplinas Por Curso");
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Disciplinas",Cont_Disciplina);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Curso_Disciplinas.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Disciplina");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            //mandar direto para a impressora;
            //true - abrir caixa de opção de impressora -- false manda direto para a padrao
            //JasperPrintManager.printReport(JPrint, true);
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }
    }
    public void Relatorio_Disciplina_Curso_Selecionado(int id){
        try {
            ObjConecta.Conectar();
            //conta os cursos
            ObjConecta.ExecutaSQL("select count(distinct id_curso) as cont from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_curso = 'ATIVO' and id_curso="+id);
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //Contar as disciplina
            ObjConecta.ExecutaSQL("select count(distinct id_disciplina)as cont from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_disciplina = 'ATIVO' and id_curso="+id);
            ObjConecta.rs.first();
            int Cont_Disciplina = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("select * from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_curso = 'ATIVO' and situacao_disciplina = 'ATIVO' and id_curso="+id+" order by nome_curso, semestre, disciplina");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Tipo_Relatorio","Todas Disciplinas Por Curso Selecionado");
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Disciplinas",Cont_Disciplina);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Curso_Disciplinas.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Disciplina");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            //mandar direto para a impressora;
            //true - abrir caixa de opção de impressora -- false manda direto para a padrao
            //JasperPrintManager.printReport(JPrint, true);
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }
    }
    
    public void Relatorio_Disciplina_Todas_Semestre(){
        try {
            ObjConecta.Conectar();
            //conta os cursos
            ObjConecta.ExecutaSQL("select count(distinct id_curso) as cont from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_curso = 'ATIVO' ");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //Contar as disciplina
            ObjConecta.ExecutaSQL("select count(distinct id_disciplina)as cont from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_disciplina = 'ATIVO' ");
            ObjConecta.rs.first();
            int Cont_Disciplina = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("select * from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_curso = 'ATIVO' and situacao_disciplina = 'ATIVO' order by nome_curso, semestre, disciplina");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Tipo_Relatorio","Todas Disciplinas Por Curso E Semestre");
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Disciplinas",Cont_Disciplina);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Curso_Disciplinas_Semestre.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Disciplina");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            //mandar direto para a impressora;
            //true - abrir caixa de opção de impressora -- false manda direto para a padrao
            //JasperPrintManager.printReport(JPrint, true);
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }
    }
    
    public void Relatorio_Disciplina_Curso_Selecionado_Semestre(int id){
        try {
            ObjConecta.Conectar();
            //conta os cursos
            ObjConecta.ExecutaSQL("select count(distinct id_curso) as cont from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_curso = 'ATIVO' and id_curso="+id);
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //Contar as disciplina
            ObjConecta.ExecutaSQL("select count(distinct id_disciplina)as cont from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_disciplina = 'ATIVO' and id_curso="+id);
            ObjConecta.rs.first();
            int Cont_Disciplina = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("select * from curso inner join disciplina on disciplina.curso_id_curso = curso.id_curso "
                    + " where situacao_curso = 'ATIVO' and situacao_disciplina = 'ATIVO' and id_curso="+id+" order by nome_curso, semestre, disciplina");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Tipo_Relatorio","Todas Disciplinas Por Curso Selecionado E Semestre");
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Disciplinas",Cont_Disciplina);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Curso_Disciplinas_Semestre.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Disciplina");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            //mandar direto para a impressora;
            //true - abrir caixa de opção de impressora -- false manda direto para a padrao
            //JasperPrintManager.printReport(JPrint, true);
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }
    }
    ///////////////////////////Cursos/////////////////////////////////////////////////
    
    public void Relatorio_Cursos(){
        try {
            ObjConecta.Conectar();
            //conta os cursos
            ObjConecta.ExecutaSQL("select count(distinct id_curso) as cont from curso where situacao_curso = 'ATIVO' ");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("select * from curso where situacao_curso = 'ATIVO' order by nome_curso");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Tipo_Relatorio","Todos Os Curso Ativos");
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Curso.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Curso");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            //mandar direto para a impressora;
            //true - abrir caixa de opção de impressora -- false manda direto para a padrao
            //JasperPrintManager.printReport(JPrint, true);
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }
    }
    
    /////////////////////////////// Turma /////////////////////////////////////////////////////////
    
    public void Relatorio_Turma(String ano){
        try {
            ObjConecta.Conectar();
            //conta os cursos
            ObjConecta.ExecutaSQL("select count(distinct id_curso) as cont from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + " where situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and ano_turma = '"+ano+"'");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //Contar as turmas
            ObjConecta.ExecutaSQL("select count(distinct id_turma) as cont from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + " where situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and ano_turma = '"+ano+"'");
            ObjConecta.rs.first();
            int Cont_Turma = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("select * from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + " where situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and ano_turma = '"+ano+"' "
                    + " order by nome_curso, ano_turma, semestre, semestre_vestibular, turma");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Tipo_Relatorio","Todas As Turma Por Curso No Ano De "+ano);
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Turmas",Cont_Turma);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Curso_Turmas.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Turma");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            //mandar direto para a impressora;
            //true - abrir caixa de opção de impressora -- false manda direto para a padrao
            //JasperPrintManager.printReport(JPrint, true);
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }
    }
    
    public void Relatorio_Turma_Selecionado_Curso(String ano, int id_curso){
        try {
            ObjConecta.Conectar();
            //conta os cursos
            ObjConecta.ExecutaSQL("select count(distinct id_curso) as cont from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + " where situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and ano_turma = '"+ano+"' and id_curso="+id_curso);
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //Contar as turmas
            ObjConecta.ExecutaSQL("select count(distinct id_turma) as cont from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + " where situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and ano_turma = '"+ano+"' and id_curso="+id_curso);
            ObjConecta.rs.first();
            int Cont_Turma = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("select * from curso inner join turma on curso.id_curso = turma.curso_id_curso "
                    + " where situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and ano_turma = '"+ano+"' and id_curso="+id_curso+" " 
                    + " order by nome_curso, ano_turma, semestre, semestre_vestibular, turma");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Tipo_Relatorio","Todas As Turma Por Curso Selecionado No Ano De "+ano);
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Turmas",Cont_Turma);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Curso_Turmas.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Turma");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            //mandar direto para a impressora;
            //true - abrir caixa de opção de impressora -- false manda direto para a padrao
            //JasperPrintManager.printReport(JPrint, true);
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }
    }
    
    public void Relatorio_Turma_Disciplina(String ano){
        try {
            ObjConecta.Conectar();
            //conta os cursos
            ObjConecta.ExecutaSQL("SELECT count(distinct id_curso) as cont "
                    + " FROM `curso` curso INNER JOIN `turma` turma ON curso.`id_curso` = turma.`curso_id_curso` "
                    + " INNER JOIN `disciplina` disciplina ON curso.`id_curso` = disciplina.`curso_id_curso` WHERE disciplina.`semestre` = turma.`semestre` "
                    + " AND situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and situacao_disciplina = 'ATIVO' and ano_turma = '"+ano+"'");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //Contar as turmas
            ObjConecta.ExecutaSQL("SELECT count(distinct id_turma) as cont "
                    + " FROM `curso` curso INNER JOIN `turma` turma ON curso.`id_curso` = turma.`curso_id_curso` "
                    + " INNER JOIN `disciplina` disciplina ON curso.`id_curso` = disciplina.`curso_id_curso` WHERE disciplina.`semestre` = turma.`semestre` "
                    + " AND situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and situacao_disciplina = 'ATIVO' and ano_turma = '"+ano+"'");
            ObjConecta.rs.first();
            int Cont_Turma = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("SELECT *, disciplina.`semestre` AS disciplina_semestre, turma.`semestre` AS turma_semestre "
                    + " FROM `curso` curso INNER JOIN `turma` turma ON curso.`id_curso` = turma.`curso_id_curso` "
                    + " INNER JOIN `disciplina` disciplina ON curso.`id_curso` = disciplina.`curso_id_curso` WHERE disciplina.`semestre` = turma.`semestre` "
                    + " AND situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and situacao_disciplina = 'ATIVO' and ano_turma = '"+ano+"'"
                    + " order by nome_curso, turma.`semestre`, semestre_vestibular, turma, disciplina.`semestre`, disciplina;");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Tipo_Relatorio","Todas As Turma Com Disciplina Por Curso No Ano De "+ano);
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Disciplinas",Cont_Turma);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Curso_Disciplinas_Turmas.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Turma");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            //mandar direto para a impressora;
            //true - abrir caixa de opção de impressora -- false manda direto para a padrao
            //JasperPrintManager.printReport(JPrint, true);
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }
    }
    
    public void Relatorio_Turma_Disciplina_Selecionado_Curso(String ano, int id_curso){
        try {
            ObjConecta.Conectar();
            //conta os cursos
            ObjConecta.ExecutaSQL("SELECT count(distinct id_curso) as cont "
                    + " FROM `curso` curso INNER JOIN `turma` turma ON curso.`id_curso` = turma.`curso_id_curso` "
                    + " INNER JOIN `disciplina` disciplina ON curso.`id_curso` = disciplina.`curso_id_curso` WHERE disciplina.`semestre` = turma.`semestre` "
                    + " AND situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and situacao_disciplina = 'ATIVO' and ano_turma = '"+ano+"'and id_curso="+id_curso);
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //Contar as turmas
            ObjConecta.ExecutaSQL("SELECT count(distinct id_turma) as cont "
                    + " FROM `curso` curso INNER JOIN `turma` turma ON curso.`id_curso` = turma.`curso_id_curso` "
                    + " INNER JOIN `disciplina` disciplina ON curso.`id_curso` = disciplina.`curso_id_curso` WHERE disciplina.`semestre` = turma.`semestre` "
                    + " AND situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and situacao_disciplina = 'ATIVO' and ano_turma = '"+ano+"' and id_curso="+id_curso);
            ObjConecta.rs.first();
            int Cont_Turma = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("SELECT *, disciplina.`semestre` AS disciplina_semestre, turma.`semestre` AS turma_semestre "
                    + " FROM `curso` curso INNER JOIN `turma` turma ON curso.`id_curso` = turma.`curso_id_curso` "
                    + " INNER JOIN `disciplina` disciplina ON curso.`id_curso` = disciplina.`curso_id_curso` WHERE disciplina.`semestre` = turma.`semestre` "
                    + " AND situacao_curso = 'ATIVO' and situacao_turma = 'ATIVO' and situacao_disciplina = 'ATIVO' and ano_turma = '"+ano+"' and id_curso = "+id_curso +" "
                    + " order by nome_curso, turma.`semestre`, semestre_vestibular, turma, disciplina.`semestre`, disciplina;");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Tipo_Relatorio","Todas As Turma Com Disciplina Por Curso Selecionado No Ano De "+ano);
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Disciplinas",Cont_Turma);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Curso_Disciplinas_Turmas.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Turma");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            //mandar direto para a impressora;
            //true - abrir caixa de opção de impressora -- false manda direto para a padrao
            //JasperPrintManager.printReport(JPrint, true);
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }
    }

}

package Conexao;

// @author Mársion Tamiarana

import static GUI_Frames.Tela_Principal.UserLogado;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Controle_Relatorio_Saidas {

    Conecta_Banco ObjConecta = new Conecta_Banco();
    
    public void Relatorio_Saida_Prod_Todos(){
        try {
                Calendar c = Calendar.getInstance();
                c.add(Calendar.YEAR, -1); //diminuir datas - um ano
                String df = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                String di = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
                
                ObjConecta.Conectar();//abre a conexão
                //Conta os itens;
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                    + "inner join produto on produto.id_produto = saida_itens.produto_id_produto where saida.data_saida between '" + di + "' and '" + df + "'");
                ObjConecta.rs.first();
                int ContItens = ObjConecta.rs.getInt("cont");
                
                //conta a quantidade de entradas
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida where saida.data_saida between '" + di + "' and '" + df + "'");
                ObjConecta.rs.first();
                int ContSaidas = ObjConecta.rs.getInt("cont");

                ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular) as turma "
                        + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma, "
                        + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                        + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' order by id_saida desc, produto.descricao");
                JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);               
                HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
                parametros.put("Usuario",UserLogado);//Se precisar passar algum parametro, tipo usuario logado
                parametros.put("Quant_Iten", ContItens);
                parametros.put("Quant_Saida", ContSaidas);
                parametros.put("Tipo_Relatorio","14 - Todas as Saídas - Último Ano");
                //Aqui fica o diretorio do arquivo
                JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas.jasper",parametros, Relatorio);
                JasperViewer JView = new JasperViewer(JPrint, false);
                JView.setVisible(true);//Seta visivel                
                JView.setTitle("Relatório De Saída");//Colocar titulo na janela
                JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
                ObjConecta.Desconecta();//fecjha a conexão
            } catch (SQLException | JRException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
            }
    }
    
    public void Relatorio_Saida_Ultimo_30_Dias(){
        try {
                Calendar c = Calendar.getInstance();
                c.add(Calendar.MONTH, -1); //diminuir datas - um ano
                String df = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                String di = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
                
                ObjConecta.Conectar();//abre a conexão
                //Conta os itens;
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                    + "inner join produto on produto.id_produto = saida_itens.produto_id_produto where saida.data_saida between '" + di + "' and '" + df + "'");
                ObjConecta.rs.first();
                int ContItens = ObjConecta.rs.getInt("cont");
                
                //conta a quantidade de entradas
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida where saida.data_saida between '" + di + "' and '" + df + "'");
                ObjConecta.rs.first();
                int ContSaidas = ObjConecta.rs.getInt("cont");

                ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular) as turma "
                        + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma, "
                        + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                        + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' order by id_saida desc, produto.descricao");
                JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);               
                HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
                parametros.put("Usuario",UserLogado);//Se precisar passar algum parametro, tipo usuario logado
                parametros.put("Quant_Iten", ContItens);
                parametros.put("Quant_Saida", ContSaidas);
                parametros.put("Tipo_Relatorio","15 - Todas as Saídas - Últimos 30 Dias");
                //Aqui fica o diretorio do arquivo
                JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas.jasper",parametros, Relatorio);
                JasperViewer JView = new JasperViewer(JPrint, false);
                JView.setVisible(true);//Seta visivel                
                JView.setTitle("Relatório De Saída");//Colocar titulo na janela
                JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
                ObjConecta.Desconecta();//fecjha a conexão
            } catch (SQLException | JRException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
            }
    }
    
    public void Relatorio_Saida_Periodo(String tipo_relatorio, JDateChooser dinicial,JDateChooser dfinal){
        try {
                String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
                String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
                String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
                String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
                String periodo = dti+" até "+dtf;
                
                ObjConecta.Conectar();//abre a conexão
                //Conta os itens;
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                    + "inner join produto on produto.id_produto = saida_itens.produto_id_produto where saida.data_saida between '" + di + "' and '" + df + "'");
                ObjConecta.rs.first();
                int ContItens = ObjConecta.rs.getInt("cont");
                
                //conta a quantidade de entradas
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida where saida.data_saida between '" + di + "' and '" + df + "'");
                ObjConecta.rs.first();
                int ContSaidas = ObjConecta.rs.getInt("cont");

                ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular) as turma "
                        + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma, "
                        + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                        + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' order by id_saida desc, produto.descricao");
                JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);               
                HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
                parametros.put("Usuario",UserLogado);//Se precisar passar algum parametro, tipo usuario logado
                parametros.put("Quant_Iten", ContItens);
                parametros.put("Quant_Saida", ContSaidas);
                parametros.put("Tipo_Relatorio",tipo_relatorio+periodo);
                //Aqui fica o diretorio do arquivo
                JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas.jasper",parametros, Relatorio);
                JasperViewer JView = new JasperViewer(JPrint, false);
                JView.setVisible(true);//Seta visivel                
                JView.setTitle("Relatório De Saída");//Colocar titulo na janela
                JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
                ObjConecta.Desconecta();//fecjha a conexão
            } catch (SQLException | JRException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
            }
    }
    
    public void Relatorio_Saida_Alteradas_Periodo(String situacao,String tipo_relatorio, JDateChooser dinicial,JDateChooser dfinal){
        try {
                String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
                String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
                String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
                String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
                String periodo = dti+" até "+dtf;
                
                ObjConecta.Conectar();//abre a conexão
                //Conta os itens;
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                    + "inner join produto on produto.id_produto = saida_itens.produto_id_produto where saida.data_saida between '" + di + "' and '" + df + "' "
                        + " and saida.situacao = '"+situacao+"'");
                ObjConecta.rs.first();
                int ContItens = ObjConecta.rs.getInt("cont");
                
                //conta a quantidade de entradas
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida where saida.data_saida between '" + di + "' and '" + df + "' "
                        + " and saida.situacao = '"+situacao+"'");
                ObjConecta.rs.first();
                int ContSaidas = ObjConecta.rs.getInt("cont");

                ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular) as turma "
                        + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma, "
                        + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                        + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao = '"+situacao+"' order by id_saida desc, produto.descricao");
                JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);               
                HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
                parametros.put("Usuario",UserLogado);//Se precisar passar algum parametro, tipo usuario logado
                parametros.put("Quant_Iten", ContItens);
                parametros.put("Quant_Saida", ContSaidas);
                parametros.put("Tipo_Relatorio",tipo_relatorio+periodo);
                //Aqui fica o diretorio do arquivo
                JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas.jasper",parametros, Relatorio);
                JasperViewer JView = new JasperViewer(JPrint, false);
                JView.setVisible(true);//Seta visivel                
                JView.setTitle("Relatório De Saída");//Colocar titulo na janela
                JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
                ObjConecta.Desconecta();//fecjha a conexão
            } catch (SQLException | JRException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
            }
    }
    
    public void Relatorio_Saida_Num(String id_saida){
        try {
                ObjConecta.Conectar();//abre a conexão
                //Conta os itens;
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                    + "inner join produto on produto.id_produto = saida_itens.produto_id_produto where saida.id_saida = "+id_saida);
                ObjConecta.rs.first();
                int ContItens = ObjConecta.rs.getInt("cont");
                
                //conta a quantidade de entradas
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida where saida.id_saida = "+id_saida);
                ObjConecta.rs.first();
                int ContSaidas = ObjConecta.rs.getInt("cont");

                ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                        + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma, "
                        + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                        + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " where saida.id_saida = "+id_saida + " order by id_saida desc, produto.descricao");
                JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);               
                HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
                parametros.put("Usuario",UserLogado);//Se precisar passar algum parametro, tipo usuario logado
                parametros.put("Quant_Iten", ContItens);
                parametros.put("Quant_Saida", ContSaidas);
                parametros.put("Tipo_Relatorio","17 - Por Saída - Nº "+id_saida);
                //Aqui fica o diretorio do arquivo
                JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas.jasper",parametros, Relatorio);
                JasperViewer JView = new JasperViewer(JPrint, false);
                JView.setVisible(true);//Seta visivel                
                JView.setTitle("Relatório De Saída");//Colocar titulo na janela
                JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
                ObjConecta.Desconecta();//fecjha a conexão
            } catch (SQLException | JRException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
            }
    }
    
    public void Relatorio_Saida_Cancelada_Ultimo_30_Dias(){
        try {
                Calendar c = Calendar.getInstance();
                c.add(Calendar.MONTH, -3); //diminuir datas - um ano
                String df = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                String di = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
                
                ObjConecta.Conectar();//abre a conexão
                //Conta os itens;
                ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                    + "inner join produto on produto.id_produto = saida_itens.produto_id_produto where saida.data_saida between '" + di + "' and '" + df + "' "
                        + " and saida.situacao = 'CANCELADA'");
                ObjConecta.rs.first();
                int ContItens = ObjConecta.rs.getInt("cont");
                
                //conta a quantidade de entradas
                ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                    + "inner join produto on produto.id_produto = saida_itens.produto_id_produto where saida.data_saida between '" + di + "' and '" + df + "' "
                        + " and saida.situacao = 'CANCELADA'");
                ObjConecta.rs.first();
                int ContSaidas = ObjConecta.rs.getInt("cont");

                ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular) as turma "
                        + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma, "
                        + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                        + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' "
                        + " and saida.situacao = 'CANCELADA' order by id_saida desc, produto.descricao");
                JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);               
                HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
                parametros.put("Usuario",UserLogado);//Se precisar passar algum parametro, tipo usuario logado
                parametros.put("Quant_Iten", ContItens);
                parametros.put("Quant_Saida", ContSaidas);
                parametros.put("Tipo_Relatorio","15 - Todas as Saídas Canceladas - Últimos 30 Dias");
                //Aqui fica o diretorio do arquivo
                JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas.jasper",parametros, Relatorio);
                JasperViewer JView = new JasperViewer(JPrint, false);
                JView.setVisible(true);//Seta visivel                
                JView.setTitle("Relatório De Saída");//Colocar titulo na janela
                JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
                ObjConecta.Desconecta();//fecjha a conexão
            } catch (SQLException | JRException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
            }
    }
    
    public void Relatorio_Saida_Curso_Analitico_Periodo(JDateChooser dinicial,JDateChooser dfinal){
        try {
                String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
                String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
                String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
                String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
                String periodo = dti+" até "+dtf;
                
                ObjConecta.Conectar();//abre a conexão
                //Conta os itens;
                ObjConecta.ExecutaSQL("select count(id_saida) as cont "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' ");
                ObjConecta.rs.first();
                int ContItens = ObjConecta.rs.getInt("cont");
                
                //conta a quantidade de saidas
                ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' ");
                ObjConecta.rs.first();
                int ContSaidas = ObjConecta.rs.getInt("cont");

                ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                        + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma, "
                        + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                        + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' order by nome_curso, saida.id_saida desc, produto.descricao");
                JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);               
                HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
                parametros.put("Usuario",UserLogado);//Se precisar passar algum parametro, tipo usuario logado
                parametros.put("Quant_Iten", ContItens);
                parametros.put("Quant_Saida", ContSaidas);
                parametros.put("Tipo_Relatorio","18 - Por Curso Analítico - Todos Cursos - de "+periodo);
                //Aqui fica o diretorio do arquivo
                JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas_Curso_Analitico.jasper",parametros, Relatorio);
                JasperViewer JView = new JasperViewer(JPrint, false);
                JView.setVisible(true);//Seta visivel                
                JView.setTitle("Relatório De Saída");//Colocar titulo na janela
                JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
                ObjConecta.Desconecta();//fecjha a conexão
            } catch (SQLException | JRException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
            }
    }
    
    public void Relatorio_Saida_Curso_Selecionado_Analitico_Periodo(String curso, JDateChooser dinicial,JDateChooser dfinal){
        try {
                String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
                String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
                String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
                String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
                String periodo = dti+" até "+dtf;
                
                ObjConecta.Conectar();//abre a conexão
                //Conta os itens;
                ObjConecta.ExecutaSQL("select count(id_saida) as cont "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' and curso.nome_curso ='"+curso+"' "
                        + " and saida.situacao != 'CANCELADA' ");
                ObjConecta.rs.first();
                int ContItens = ObjConecta.rs.getInt("cont");
                
                //conta a quantidade de saidas
                ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' and curso.nome_curso ='"+curso+"' "
                        + " and saida.situacao != 'CANCELADA' ");
                ObjConecta.rs.first();
                int ContSaidas = ObjConecta.rs.getInt("cont");

                ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                        + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma, "
                        + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                        + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                        + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                        + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                        + " where saida.data_saida between '" + di + "' and '" + df + "' and curso.nome_curso ='"+curso+"' "
                        + " and saida.situacao != 'CANCELADA' order by nome_curso, saida.id_saida desc, produto.descricao");
                JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);               
                HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
                parametros.put("Usuario",UserLogado);//Se precisar passar algum parametro, tipo usuario logado
                parametros.put("Quant_Iten", ContItens);
                parametros.put("Quant_Saida", ContSaidas);
                parametros.put("Tipo_Relatorio","18 - Por Curso Analítico - Selecionado - Período de "+periodo);
                //Aqui fica o diretorio do arquivo
                JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas_Curso_Analitico.jasper",parametros, Relatorio);
                JasperViewer JView = new JasperViewer(JPrint, false);
                JView.setVisible(true);//Seta visivel                
                JView.setTitle("Relatório De Saída");//Colocar titulo na janela
                JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
                ObjConecta.Desconecta();//fecjha a conexão
            } catch (SQLException | JRException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
            }
    }
    
    public void Relatorio_Saida_Curso_Selecionado_Sintetico_Periodo(String curso, JDateChooser dinicial,JDateChooser dfinal){
        try {
            String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
            String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
            String periodo = dti + " até " + dtf;

            ObjConecta.Conectar();//abre a conexão
            //Conta os itens;
            ObjConecta.ExecutaSQL("select count(id_saida_itens) as cont from saida_itens inner join saida on saida_itens.saida_id_saida = saida.id_saida "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso  "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and curso.nome_curso ='" + curso + "' "
                    + " and saida.situacao != 'CANCELADA'");
            ObjConecta.rs.first();
            int ContItens = ObjConecta.rs.getInt("cont");

            //conta a quantidade de saidas
            ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso  "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and curso.nome_curso ='" + curso + "' "
                    + " and saida.situacao != 'CANCELADA'");
            ObjConecta.rs.first();
            int ContSaidas = ObjConecta.rs.getInt("cont");

            ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                    + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma, "
                    + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                    + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso  "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and curso.nome_curso ='" + curso + "' "
                    + " and saida.situacao != 'CANCELADA' order by curso.nome_curso, saida.id_saida desc");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
            parametros.put("Usuario", UserLogado);//Se precisar passar algum parametro, tipo usuario logado
            parametros.put("Quant_Iten", ContItens);
            parametros.put("Quant_Saida", ContSaidas);
            parametros.put("Tipo_Relatorio", "18 - Por Curso Sintético - Selecionado - Período de " + periodo);
            //Aqui fica o diretorio do arquivo
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas_Curso_Sintetico.jasper", parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);//Seta visivel                
            JView.setTitle("Relatório De Saída");//Colocar titulo na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
            ObjConecta.Desconecta();//fecjha a conexão
        } catch (SQLException | JRException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    public void Relatorio_Saida_Curso_Sintetico_Periodo(JDateChooser dinicial,JDateChooser dfinal){
        try {
            String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
            String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
            String periodo = dti+" até "+dtf;
            
            ObjConecta.Conectar();//abre a conexão
            //Conta os itens;
            ObjConecta.ExecutaSQL("select count(id_saida_itens) as cont from saida_itens inner join saida on saida_itens.saida_id_saida = saida.id_saida "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso  "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' "
                    + " and saida.situacao != 'CANCELADA' ");
            ObjConecta.rs.first();
            int ContItens = ObjConecta.rs.getInt("cont");

            //conta a quantidade de saidas
            ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso  "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' "
                    + " and saida.situacao != 'CANCELADA' ");
            ObjConecta.rs.first();
            int ContSaidas = ObjConecta.rs.getInt("cont");

            ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                    + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma, "
                    + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                    + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso  "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' "
                    + " and saida.situacao != 'CANCELADA' order by curso.nome_curso, saida.id_saida desc");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
            parametros.put("Usuario", UserLogado);//Se precisar passar algum parametro, tipo usuario logado
            parametros.put("Quant_Iten", ContItens);
            parametros.put("Quant_Saida", ContSaidas);
            parametros.put("Tipo_Relatorio", "18 - Por Curso Sintético - Todos Cursos - Período de " + periodo);
            //Aqui fica o diretorio do arquivo
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas_Curso_Sintetico.jasper", parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);//Seta visivel                
            JView.setTitle("Relatório De Saída");//Colocar titulo na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
            ObjConecta.Desconecta();//fecjha a conexão
        } catch (SQLException | JRException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    /////////////////////////////////////Turma Sintetico///////////////////////////////////////////
    
    public void Relatorio_Saida_Turma_Sintetico_Periodo(String sql_semestre,String ano, JDateChooser dinicial,JDateChooser dfinal){
        try {
            String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
            String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
            String periodo = dti+" até "+dtf;
            
            ObjConecta.Conectar();//abre a conexão
            //Conta os itens;
            ObjConecta.ExecutaSQL("select count(id_saida_itens) as cont "
                    + " from saida_itens inner join saida on saida_itens.saida_id_saida = saida.id_saida "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' ");
            ObjConecta.rs.first();
            int ContItens = ObjConecta.rs.getInt("cont");

            //conta a quantidade de saidas
            ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' ");
            ObjConecta.rs.first();
            int ContSaidas = ObjConecta.rs.getInt("cont");

            ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turmas "
                    + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turmas, "
                    + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                    + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' order by curso.nome_curso, turmas, saida.id_saida desc");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
            parametros.put("Usuario", UserLogado);//Se precisar passar algum parametro, tipo usuario logado
            parametros.put("Quant_Iten", ContItens);
            parametros.put("Quant_Saida", ContSaidas);
            parametros.put("Tipo_Relatorio", "19 - Por Turma Sintético - Todas Turma de "+ano+" - de " + periodo);
            //Aqui fica o diretorio do arquivo
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas_Turma_Sintetico.jasper", parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);//Seta visivel                
            JView.setTitle("Relatório De Saída");//Colocar titulo na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
            ObjConecta.Desconecta();//fecjha a conexão
        } catch (SQLException | JRException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    public void Relatorio_Saida_Curso_Selecionada_Turmas_Todas_Sintetico_Periodo(String sql_semestre,String ano, JDateChooser dinicial,JDateChooser dfinal, String curso ){
        try {
            String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
            String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
            String periodo = dti+" até "+dtf;
            
            ObjConecta.Conectar();//abre a conexão
            //Conta os itens;
            ObjConecta.ExecutaSQL("select count(id_saida_itens) as cont "
                    + " from saida_itens inner join saida on saida_itens.saida_id_saida = saida.id_saida "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+"' ");
            ObjConecta.rs.first();
            int ContItens = ObjConecta.rs.getInt("cont");

            //conta a quantidade de saidas
            ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+" ' ");
            ObjConecta.rs.first();
            int ContSaidas = ObjConecta.rs.getInt("cont");

            ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turmas "
                    + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turmas, "
                    + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                    + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+" '  order by curso.nome_curso, turmas, saida.id_saida desc");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
            parametros.put("Usuario", UserLogado);//Se precisar passar algum parametro, tipo usuario logado
            parametros.put("Quant_Iten", ContItens);
            parametros.put("Quant_Saida", ContSaidas);
            parametros.put("Tipo_Relatorio", "19 - Por Turma Sintético - Todas Turma de "+ano+" - de " + periodo);
            //Aqui fica o diretorio do arquivo
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas_Turma_Sintetico.jasper", parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);//Seta visivel                
            JView.setTitle("Relatório De Saída");//Colocar titulo na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
            ObjConecta.Desconecta();//fecjha a conexão
        } catch (SQLException | JRException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    public void Relatorio_Saida_Curso_Selecionada_Turmas_Selecionada_Sintetico_Periodo(String sql_semestre,String ano, JDateChooser dinicial,JDateChooser dfinal, String curso ,String id_turma){
        try {
            String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
            String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
            String periodo = dti+" até "+dtf;
            
            ObjConecta.Conectar();//abre a conexão
            //Conta os itens;
            ObjConecta.ExecutaSQL("select count(id_saida_itens) as cont "
                    + " from saida_itens inner join saida on saida_itens.saida_id_saida = saida.id_saida "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+" 'and id_turma="+id_turma);
            ObjConecta.rs.first();
            int ContItens = ObjConecta.rs.getInt("cont");

            //conta a quantidade de saidas
            ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+" 'and id_turma="+id_turma);
            ObjConecta.rs.first();
            int ContSaidas = ObjConecta.rs.getInt("cont");

            ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turmas "
                    + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turmas, "
                    + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                    + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+" ' and id_turma= "+id_turma+ " order by curso.nome_curso, turmas, saida.id_saida desc");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
            parametros.put("Usuario", UserLogado);//Se precisar passar algum parametro, tipo usuario logado
            parametros.put("Quant_Iten", ContItens);
            parametros.put("Quant_Saida", ContSaidas);
            parametros.put("Tipo_Relatorio", "19 - Por Turma Sintético - Selecionada de "+ano+" - de " + periodo);
            //Aqui fica o diretorio do arquivo
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas_Turma_Sintetico.jasper", parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);//Seta visivel                
            JView.setTitle("Relatório De Saída");//Colocar titulo na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
            ObjConecta.Desconecta();//fecjha a conexão
        } catch (SQLException | JRException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    /////////////////////////////////Turma Analitico//////////////////////////////////
    
    public void Relatorio_Saida_Turma_Analitico_Periodo(String sql_semestre,String ano, JDateChooser dinicial,JDateChooser dfinal){
        try {
            String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
            String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
            String periodo = dti+" até "+dtf;
            
            ObjConecta.Conectar();//abre a conexão
            //Conta os itens;
            ObjConecta.ExecutaSQL("select count(id_saida_itens) as cont "
                    + " from saida_itens inner join saida on saida_itens.saida_id_saida = saida.id_saida "
                    + " inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' ");
            ObjConecta.rs.first();
            int ContItens = ObjConecta.rs.getInt("cont");

            //conta a quantidade de saidas
             ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' ");
            ObjConecta.rs.first();
            int ContSaidas = ObjConecta.rs.getInt("cont");

            ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                    + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turmas, "
                    + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                    + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                    + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA'  order by nome_curso, turmas, id_saida desc, produto.descricao");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
            parametros.put("Usuario", UserLogado);//Se precisar passar algum parametro, tipo usuario logado
            parametros.put("Quant_Iten", ContItens);
            parametros.put("Quant_Saida", ContSaidas);
            parametros.put("Tipo_Relatorio", "19 - Por Turma Analítico - Todas Turma de "+ano+" - de " + periodo);
            //Aqui fica o diretorio do arquivo
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas_Turma_Analitico.jasper", parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);//Seta visivel                
            JView.setTitle("Relatório De Saída");//Colocar titulo na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
            ObjConecta.Desconecta();//fecjha a conexão
        } catch (SQLException | JRException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    public void Relatorio_Saida_Curso_Selecionada_Turmas_Todas_Analitico_Periodo(String sql_semestre,String ano, JDateChooser dinicial,JDateChooser dfinal, String curso ){
        try {
            String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
            String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
            String periodo = dti+" até "+dtf;
            
            ObjConecta.Conectar();//abre a conexão
            //Conta os itens;
            ObjConecta.ExecutaSQL("select count(id_saida_itens) as cont "
                    + " from saida_itens inner join saida on saida_itens.saida_id_saida = saida.id_saida "
                    + " inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+"' ");
            ObjConecta.rs.first();
            int ContItens = ObjConecta.rs.getInt("cont");

            //conta a quantidade de saidas
            ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+" ' ");
            ObjConecta.rs.first();
            int ContSaidas = ObjConecta.rs.getInt("cont");

            ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                    + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turmas, "
                    + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                    + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                    + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+" '   order by nome_curso, turmas, id_saida desc, produto.descricao");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
            parametros.put("Usuario", UserLogado);//Se precisar passar algum parametro, tipo usuario logado
            parametros.put("Quant_Iten", ContItens);
            parametros.put("Quant_Saida", ContSaidas);
            parametros.put("Tipo_Relatorio", "19 - Por Turma Analítico - Todas Turma de "+ano+" - de " + periodo);
            //Aqui fica o diretorio do arquivo
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas_Turma_Analitico.jasper", parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);//Seta visivel                
            JView.setTitle("Relatório De Saída");//Colocar titulo na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
            ObjConecta.Desconecta();//fecjha a conexão
        } catch (SQLException | JRException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    public void Relatorio_Saida_Curso_Selecionada_Turmas_Selecionada_Analitico_Periodo(String sql_semestre,String ano, JDateChooser dinicial,JDateChooser dfinal, String curso ,String id_turma){
        try {
            String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
            String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
            String periodo = dti+" até "+dtf;
            
            ObjConecta.Conectar();//abre a conexão
            //Conta os itens;
            ObjConecta.ExecutaSQL("select count(id_saida_itens) as cont "
                    + " from saida_itens inner join saida on saida_itens.saida_id_saida = saida.id_saida "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+" ' and id_turma="+id_turma);
            ObjConecta.rs.first();
            int ContItens = ObjConecta.rs.getInt("cont");
                  
            ObjConecta.ExecutaSQL("select count(distinct id_saida) as cont "
                    + " from saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+" ' and id_turma="+id_turma);
            
            ObjConecta.rs.first();
            
            int ContSaidas = ObjConecta.rs.getInt("cont");

            ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                    + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turmas, "
                    + " (select disciplina from disciplina where id_disciplina = saida.disciplina_id_disciplina) as disciplina, "
                    + " (select count(id_saida_itens) from saida_itens where saida_itens.saida_id_saida = saida.id_saida) as itens "
                    + " from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto on produto.id_produto=saida_itens.produto_id_produto "
                    + " inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                    + " where saida.data_saida between '" + di + "' and '" + df + "' and ano_turma = "+ano+" "+sql_semestre+" "
                    + " and saida.situacao != 'CANCELADA' and nome_curso = '"+curso+" ' and id_turma= "+id_turma+ "  order by nome_curso, turmas, id_saida desc, produto.descricao");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
            parametros.put("Usuario", UserLogado);//Se precisar passar algum parametro, tipo usuario logado
            parametros.put("Quant_Iten", ContItens);
            parametros.put("Quant_Saida", ContSaidas);
            parametros.put("Tipo_Relatorio", "19 - Por Turma Analítico - Selecionada de "+ano+" - de " + periodo);
            //Aqui fica o diretorio do arquivo
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Saidas_Turma_Analitico.jasper", parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);//Seta visivel                
            JView.setTitle("Relatório De Saída");//Colocar titulo na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
            ObjConecta.Desconecta();//fecha a conexão
        } catch (SQLException | JRException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
}

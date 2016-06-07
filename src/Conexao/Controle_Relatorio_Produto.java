package Conexao;

//@author Márison Tamiarana

import static GUI_Frames.Tela_Principal.UserLogado;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Controle_Relatorio_Produto {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    String Org = "COOLAB - Coordenação de Laboratórios da Estácio | FCAT";
    
    public void Relatorio_Produto_Todos(String situacao, String relat){
    try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto "+situacao+"");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            
            ObjConecta.ExecutaSQL("select * from produto inner join categoria_produto "
            + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "+situacao+" order by descricao");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Tipo_Relatorio", relat);
            parametros.put("Organizacao",Org);
            String C = "C:\\Program Files (x86)\\SisCoE\\Relat_Produto_Geral.jasper";
            //String C = "/Relatorios/Relat_Produtos_Todos.jasper";
            JasperPrint JPrint = JasperFillManager.fillReport(C,parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Produto");
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
    public void Relatorio_Produto_Todos_Retrato(String situacao, String relat){
    try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto "+situacao+"");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            
            ObjConecta.ExecutaSQL("select * from produto inner join categoria_produto "
            + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "+situacao+" order by descricao");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Tipo_Relatorio", relat);
            parametros.put("Organizacao",Org);
            String C = "C:\\Program Files (x86)\\SisCoE/Relat_Produtos_Todos.jasper";
            //String C = "/Relatorios/Relat_Produtos_Todos.jasper";
            JasperPrint JPrint = JasperFillManager.fillReport(C,parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Produto");
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
    
    public void Relatorio_Produto_Entrada_Periodo(JDateChooser dinicial,JDateChooser dfinal, int id_prod ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade de entradas
        ObjConecta.ExecutaSQL("select count(id_entrada) as cont from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + "where entrada_itens.produto_id_produto ="+id_prod+" and entrada.data_entrada between '" + di + "' and '" + df + "' "
                + " and entrada.situacao_entrada != 'CANCELADA'");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        //metodo para soma a quantidade de estoque por iten
        ObjConecta.ExecutaSQL("select sum(quantidade) as soma from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + "where entrada_itens.produto_id_produto = "+id_prod+" and entrada.data_entrada between '" + di + "' and '" + df + "' "
                + " and entrada.situacao_entrada != 'CANCELADA'");
        ObjConecta.rs.first();
        double Soma = ObjConecta.rs.getDouble("soma");
        double Media =(Soma/Cont);
        
        //metodo para saber a primeira e a ultima data de entrada dentro do periodo;
        if(Soma != 0){
            if(di.equals(df)){}
            else{
                ObjConecta.ExecutaSQL("select * from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                        + "inner join produto on produto.id_produto=entrada_itens.produto_id_produto where produto.id_produto ="+id_prod+""
                        + " and entrada.data_entrada between '" + di + "' and '" + df + "' "
                        + " and entrada.situacao_entrada != 'CANCELADA'");
                ObjConecta.rs.first();
                int teste = ObjConecta.rs.getInt("id_entrada");
                Date dt1 = ObjConecta.rs.getDate("data_entrada");
                ObjConecta.rs.last();
                Date dt2 = ObjConecta.rs.getDate("data_entrada");
                DiasIntervalo = (((dt2.getTime() - dt1.getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
            }
        }
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select * from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + "inner join produto on produto.id_produto=entrada_itens.produto_id_produto where produto.id_produto ="+id_prod+""
                + " and entrada.data_entrada between '" + di + "' and '" + df + "' "
                + " and entrada.situacao_entrada != 'CANCELADA'");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Data_Inicial", di);
        parametros.put("Data_Final", df);
        parametros.put("Usuario", UserLogado);
        parametros.put("DTI", intervalo);
        parametros.put("Cont", Cont);
        parametros.put("Soma",Soma);
        parametros.put("Dias",Dias);
        parametros.put("Media", Media);
        parametros.put("Intervalo",DiasIntervalo);
        parametros.put("Organizacao",Org);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Produto_Entrada_Periodo.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    public void Relatorio_Produto_Categoria_Todas(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto where situacao = 'ATIVO'");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //Contar as categorias
            ObjConecta.ExecutaSQL("select count(distinct id_categoria) as cont from categoria_produto inner join produto "
            + "on categoria_produto.id_categoria = produto.Categoria_Produto_id_categoria where categoria_produto.situacao = 'ATIVO' "
                    + " and produto.situacao ='Ativo'");
            ObjConecta.rs.first();
            int Cont_Categorias = ObjConecta.rs.getInt("cont");
            
            ObjConecta.ExecutaSQL("select*from categoria_produto inner join produto "
            + "on categoria_produto.id_categoria = produto.Categoria_Produto_id_categoria where produto.situacao ='Ativo' order by categoria, descricao");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Categorias",Cont_Categorias);
            parametros.put("Organizacao",Org);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Produtos_Categoria_Todas.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Produto");
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
    
    public void Relatorio_Produto_Categoria_Selecionada(int cod){
    try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto where Categoria_Produto_id_categoria = "+cod+" and situacao = 'ATIVO'");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            
            ObjConecta.ExecutaSQL("select*from categoria_produto inner join produto on categoria_produto.id_categoria = produto.Categoria_Produto_id_categoria "
                    + " where categoria_produto.id_categoria= "+cod+" and produto.situacao ='Ativo' order by categoria, descricao");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Organizacao",Org);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE\\Relat_Produtos_Categoria_Seleciona.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Produto");
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
    
    public void Relatorio_Produto_Estoque_Sintetico(){
        try {
            ObjConecta.Conectar();
            //contar geral
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto where produto.situacao = 'ATIVO' "
                    + " and (select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto)>=0;");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //contar estoque
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto where produto.situacao = 'ATIVO' "
                    + " and (select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto)>0;");
            ObjConecta.rs.first();
            int Cont_Estoque = ObjConecta.rs.getInt("cont");
            //contar sem estoque
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto where produto.situacao = 'ATIVO' "
                    + " and (select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto)=0;");
            ObjConecta.rs.first();
            int Cont_Sem_Estoque = ObjConecta.rs.getInt("cont");
            
            ObjConecta.ExecutaSQL("select distinct id_produto, descricao, quantidade_minima, unidade,categoria,"
                    + "(select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto) as estoque from produto "
                    + " inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.situacao = 'ATIVO' "
                    + " and (select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto)>=0 order by produto.descricao");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Estoque",Cont_Estoque);
            parametros.put("Quant_Sem_Estoque",Cont_Sem_Estoque);
            parametros.put("Organizacao",Org);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Estoque_Sintetico.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Estoque");
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
    
    public void Relatorio_Produto_Estoque_Analitico(){
    try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto where produto.situacao = 'ATIVO' "
                    + " and (select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto)>0;");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            
            ObjConecta.ExecutaSQL("select * from produto "
                    + " inner join lote_estoque on produto.id_produto=lote_estoque.produto_id_produto inner join categoria_produto "
                    + " on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                    + " where produto.situacao = 'ATIVO'  and quantidade_estoque >0 order by descricao;");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Organizacao",Org);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Estoque_Analitico.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Estoque");
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
    
    public void Relatorio_Produto_Estoque_Geral(String tipo_relatorio, String sql){
        try {
            ObjConecta.Conectar();
            //contar geral
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto "
                    + " inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.situacao = 'ATIVO' "
                    + sql +" order by produto.descricao");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //contar estoque
                       
            ObjConecta.ExecutaSQL("select distinct id_produto, descricao, quantidade_minima, unidade,categoria, "
                    + "(select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto) as estoque from produto "
                    + " inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.situacao = 'ATIVO' "
                    + sql +" order by produto.descricao");
            //where produto.id_produto=lote_estoque.produto_id_produto)>=0 
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Tipo_Relatorio",tipo_relatorio);
            parametros.put("Organizacao",Org);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Estoque_Geral.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Estoque");
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
    
    public void Relatorio_Produto_Estoque_Abaixo_30_Dias(String tipo_relatorio){
        try {
            ObjConecta.Conectar();
            //contar geral
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, +1); //Aumenta um mes na data
            String df = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            String di = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from lote_estoque inner join produto on produto.id_produto=lote_estoque.produto_id_produto "
                    + " where produto.situacao = 'ATIVO' and quantidade_estoque >0 and solicita_lote='SIM' and data_validade_lote between '"+di+"' and '"+df+"'");                   
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //
            ObjConecta.ExecutaSQL("select * from lote_estoque inner join produto on produto.id_produto=lote_estoque.produto_id_produto "
                    + " inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                    + " where produto.situacao = 'ATIVO' and quantidade_estoque >0 and solicita_lote='SIM' and data_validade_lote between '"+di+"' and '"+df+"'");
            //where produto.id_produto=lote_estoque.produto_id_produto)>=0 
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Tipo_Relatorio",tipo_relatorio);
            parametros.put("Organizacao",Org);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Estoque_Vencido.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Estoque");
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
    
    public void Relatorio_Produto_Estoque_Vencido(String tipo_relatorio){
        try {
            ObjConecta.Conectar();
            //contar geral
            String da = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());            
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from lote_estoque inner join produto on produto.id_produto=lote_estoque.produto_id_produto "
                    + " where produto.situacao = 'ATIVO' and quantidade_estoque >0 and solicita_lote='SIM' and data_validade_lote and data_validade_lote < '"+da+"'");                 
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //
            ObjConecta.ExecutaSQL("select * from lote_estoque inner join produto on produto.id_produto=lote_estoque.produto_id_produto "
                    + " inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                    + " where produto.situacao = 'ATIVO' and quantidade_estoque >0 and solicita_lote='SIM' and data_validade_lote < '"+da+"'");
            //where produto.id_produto=lote_estoque.produto_id_produto)>=0 
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Tipo_Relatorio",tipo_relatorio);
            parametros.put("Organizacao",Org);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Estoque_Vencido.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Estoque");
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
    
    public void Relatorio_Produto_Estoque_Categoria(){
        try {
            ObjConecta.Conectar();
            //contar geral
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto where situacao = 'ATIVO'");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //Contar as categorias
            ObjConecta.ExecutaSQL("select count(distinct id_categoria) as cont from categoria_produto inner join produto "
            + "on categoria_produto.id_categoria = produto.Categoria_Produto_id_categoria where categoria_produto.situacao = 'ATIVO' "
                    + " and produto.situacao ='Ativo'");
            ObjConecta.rs.first();
            int Cont_Categorias = ObjConecta.rs.getInt("cont");
            
            ObjConecta.ExecutaSQL("select distinct id_produto, descricao, quantidade_minima, unidade,categoria, macro, quantidade_macro, id_categoria, data_cad_categoria, "
                    + "(select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto) as estoque from produto "
                    + " inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.situacao = 'ATIVO' "
                    + "  order by Categoria_produto.categoria, produto.descricao");
            
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Categorias",Cont_Categorias);
            parametros.put("Tipo_Relatorio", "Estoque de Produto Por Categoria - Todas Categorias");
            parametros.put("Organizacao",Org);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Estoque_Categoria.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Estoque");
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
    
    public void Relatorio_Produto_Estoque_Categoria_Selecionada(int id_categoria){
        try {
            ObjConecta.Conectar();
            //contar geral
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto where Categoria_Produto_id_categoria = "+id_categoria+" and situacao = 'ATIVO'");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            int Cont_Categorias = 1;
            
            ObjConecta.ExecutaSQL("select distinct id_produto, descricao, quantidade_minima, unidade,categoria, macro, quantidade_macro, id_categoria, data_cad_categoria, "
                    + "(select sum(quantidade_estoque) from lote_estoque where produto.id_produto=lote_estoque.produto_id_produto) as estoque from produto "
                    + " inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.situacao = 'ATIVO' "
                    + " and Categoria_Produto_id_categoria = "+id_categoria+" order by Categoria_produto.categoria, produto.descricao");
            
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Quant_Categorias",Cont_Categorias);
            parametros.put("Tipo_Relatorio", "Estoque de Produto Por Categoria - Categoria Selecionada");
            parametros.put("Organizacao",Org);
            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Estoque_Categoria.jasper",parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Estoque");
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
    
     public void Relatorio_Produto_Saida_Periodo(JDateChooser dinicial,JDateChooser dfinal, int id_prod ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade de entradas
        ObjConecta.ExecutaSQL("select count(id_saida) as cont from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                + " where saida_itens.produto_id_produto ="+id_prod+" and saida.data_saida between '" + di + "' and '" + df + "' "
                + " and saida.situacao != 'CANCELADA'");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        //metodo para soma a quantidade de estoque por iten
        ObjConecta.ExecutaSQL("select sum(quantidade) as soma from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                + " where saida_itens.produto_id_produto ="+id_prod+" and saida.data_saida between '" + di + "' and '" + df + "' "
                + " and saida.situacao != 'CANCELADA'");
        ObjConecta.rs.first();
        double Soma = ObjConecta.rs.getDouble("soma");
        double Media =(Soma/Cont);
        
        //metodo para saber a primeira e a ultima data de entrada dentro do periodo;
        if(Soma != 0){
            if(di.equals(df)){}
            else{
                ObjConecta.ExecutaSQL("select * from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                        + " inner join produto on produto.id_produto = saida_itens.produto_id_produto where produto.id_produto ="+id_prod+""
                        + " and saida.data_saida between '" + di + "' and '" + df + "' "
                        + " and saida.situacao != 'CANCELADA'");
                ObjConecta.rs.first();
                int teste = ObjConecta.rs.getInt("id_saida");
                Date dt1 = ObjConecta.rs.getDate("data_saida");
                ObjConecta.rs.last();
                Date dt2 = ObjConecta.rs.getDate("data_saida");
                DiasIntervalo = (((dt2.getTime() - dt1.getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
            }
        }
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select *,(select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma "
                        + " from curso inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma) as turma "
                        + " from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                        + " inner join produto on produto.id_produto = saida_itens.produto_id_produto where produto.id_produto ="+id_prod+""
                        + " and saida.data_saida between '" + di + "' and '" + df + "' "
                        + " and saida.situacao != 'CANCELADA' order by id_saida desc");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "34 - Movimentação de Saída por Produto de "+intervalo);
        parametros.put("Cont", Cont);
        parametros.put("Soma",Soma);
        parametros.put("Dias",Dias);
        parametros.put("Media", Media);
        parametros.put("Intervalo",DiasIntervalo);
        parametros.put("Organizacao",Org);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Produto_Saida_Periodo.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
     ///////////////////////////////////MOVIMENTAÇÃO/////////////////////////////
     
    public void Relatorio_Produto_Mov_Entrada_Periodo(JDateChooser dinicial,JDateChooser dfinal ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade de entradas
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " inner join entrada_itens on entrada_itens.produto_id_produto = produto.id_produto "
                + " inner join entrada on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where produto.situacao = 'ATIVO' and entrada.data_entrada between '" + di + "' and '" + df + "'"
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        //metodo para soma a quantidade de estoque por iten
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                + " (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as cont, "
                + " (select sum(quantidade) as soma from entrada inner join entrada_itens on entrada.id_entrada =  entrada_itens.entrada_id_entrada  "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as entradas "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0"
                + " order by entradas desc");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "59 - Movimentação de Entrada de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        parametros.put("Organizacao",Org);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Entrada_Produto.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    public void Relatorio_Produto_Mov_Saida_Periodo(JDateChooser dinicial,JDateChooser dfinal ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade de entradas
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida_itens on produto_id_produto = produto.id_produto "
                + " inner join saida on id_saida = saida_id_saida "
                + " where produto.situacao = 'ATIVO' and saida.data_saida between '" + di + "' and '" + df + "'"
                + " and (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        //metodo para soma a quantidade de estoque por iten
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as cont, "
                + " (select sum(quantidade) as soma from saida inner join saida_itens on id_saida =  saida_id_saida  "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as saidas "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                + " and (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0"
                + " order by saidas desc");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "59 - Movimentação de Saída de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    public void Relatorio_Produto_Mov_Ajuste_Periodo(JDateChooser dinicial,JDateChooser dfinal ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade de entradas
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " inner join ajuste_estoque on produto_id_produto = produto.id_produto "
                + " where produto.situacao = 'ATIVO' and data_ajuste between '" + di + "' and '" + df + "'"
                + " and (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        //metodo para soma a quantidade de estoque por iten
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                + " (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as cont, "
                + " (select sum(quantidade) as soma from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as ajustes "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                + " and (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0 "
                + " order by ajustes desc");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "59 - Movimentação de Ajuste de Estoque de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Ajuste_Produto.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
     ///////////////////////////////////MOVIMENTAÇÃO POR CATEGORIA/////////////////////////////
     
    public void Relatorio_Produto_Mov_Entrada_Periodo_Categoria(JDateChooser dinicial,JDateChooser dfinal ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont,  count(distinct id_categoria) as cont_categoria "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " inner join entrada_itens on entrada_itens.produto_id_produto = produto.id_produto "
                + " inner join entrada on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where produto.situacao = 'ATIVO' and entrada.data_entrada between '" + di + "' and '" + df + "'"
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Categoria = ObjConecta.rs.getInt("cont_categoria");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                + " (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as cont, "
                + " (select sum(quantidade) as soma from entrada inner join entrada_itens on entrada.id_entrada =  entrada_itens.entrada_id_entrada  "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as entradas "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0"
                + " order by categoria, entradas desc");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "60 - Movimentação de Entrada por Categoria de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        parametros.put("Quant_Categoria",Cont_Categoria);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Entrada_Produto_Categoria.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    public void Relatorio_Produto_Mov_Saida_Periodo_Categoria(JDateChooser dinicial,JDateChooser dfinal ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_categoria) as cont_categoria "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida_itens on produto_id_produto = produto.id_produto "
                + " inner join saida on id_saida = saida_id_saida "
                + " where produto.situacao = 'ATIVO' and saida.data_saida between '" + di + "' and '" + df + "'"
                + " and (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Categoria = ObjConecta.rs.getInt("cont_categoria");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as cont, "
                + " (select sum(quantidade) as soma from saida inner join saida_itens on id_saida =  saida_id_saida  "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as saidas "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                + " and (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0"
                + " order by categoria, saidas desc");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "60 - Movimentação de Saída por Categoria de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        parametros.put("Quant_Categoria",Cont_Categoria);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto_Categoria.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    public void Relatorio_Produto_Mov_Ajuste_Periodo_Categoria(JDateChooser dinicial,JDateChooser dfinal ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade de entradas
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_categoria) as cont_categoria "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " inner join ajuste_estoque on produto_id_produto = produto.id_produto "
                + " where produto.situacao = 'ATIVO' and data_ajuste between '" + di + "' and '" + df + "'"
                + " and (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Categoria = ObjConecta.rs.getInt("cont_categoria");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                + " (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as cont, "
                + " (select sum(quantidade) as soma from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as ajustes "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                + " and (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0 "
                + " order by categoria, ajustes desc");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "60 - Movimentação de Ajuste de Estoque por Categoria de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        parametros.put("Quant_Categoria",Cont_Categoria);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Ajuste_Produto_Categoria.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
     ///////////////////////////////////MOVIMENTAÇÃO POR CATEGORIA SELECIONADA/////////////////////////////
     
    public void Relatorio_Produto_Mov_Entrada_Periodo_Categoria_Selecionada(JDateChooser dinicial,JDateChooser dfinal, String categoria ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont,  count(distinct id_categoria) as cont_categoria "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " inner join entrada_itens on entrada_itens.produto_id_produto = produto.id_produto "
                + " inner join entrada on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where produto.situacao = 'ATIVO' and entrada.data_entrada between '" + di + "' and '" + df + "'"
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0"
                + " and categoria = '"+categoria+"'");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Categoria = ObjConecta.rs.getInt("cont_categoria");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                + " (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as cont, "
                + " (select sum(quantidade) as soma from entrada inner join entrada_itens on entrada.id_entrada =  entrada_itens.entrada_id_entrada  "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as entradas "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0"
                + " and categoria = '"+categoria+"' order by categoria, entradas desc");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "60 - Movimentação de Entrada por Categoria de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        parametros.put("Quant_Categoria",Cont_Categoria);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Entrada_Produto_Categoria.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    public void Relatorio_Produto_Mov_Saida_Periodo_Categoria_Selecionada(JDateChooser dinicial,JDateChooser dfinal, String categoria ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_categoria) as cont_categoria "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida_itens on produto_id_produto = produto.id_produto "
                + " inner join saida on id_saida = saida_id_saida "
                + " where produto.situacao = 'ATIVO' and saida.data_saida between '" + di + "' and '" + df + "'"
                + " and (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0"
                + " and categoria = '"+categoria+"'");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Categoria = ObjConecta.rs.getInt("cont_categoria");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as cont, "
                + " (select sum(quantidade) as soma from saida inner join saida_itens on id_saida =  saida_id_saida  "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as saidas "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                + " and (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0"
                + " and categoria = '"+categoria+"' order by categoria, saidas desc");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "60 - Movimentação de Saída por Categoria de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        parametros.put("Quant_Categoria",Cont_Categoria);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto_Categoria.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    public void Relatorio_Produto_Mov_Ajuste_Periodo_Categoria_Selecionada(JDateChooser dinicial,JDateChooser dfinal, String categoria ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade de entradas
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_categoria) as cont_categoria "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " inner join ajuste_estoque on produto_id_produto = produto.id_produto "
                + " where produto.situacao = 'ATIVO' and data_ajuste between '" + di + "' and '" + df + "'"
                + " and (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0"
                + " and categoria = '"+categoria+"'");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Categoria = ObjConecta.rs.getInt("cont_categoria");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                + " (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as cont, "
                + " (select sum(quantidade) as soma from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as ajustes "
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                + " and (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0 "
                + " and categoria = '"+categoria+"' order by categoria, ajustes desc");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "60 - Movimentação de Ajuste de Estoque por Categoria de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        parametros.put("Quant_Categoria",Cont_Categoria);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Ajuste_Produto_Categoria.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    /////////////////////////////////////////////GERAL///////////////////////
    
    public void Relatorio_Produto_Mov_Geral_Periodo(JDateChooser dinicial,JDateChooser dfinal ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont  "
                //Tabelas
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                //Condição Entrada
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0"
                //Condição Saida
                + " or (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0"
                //Condição Ajustes
                + " or (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0 ");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *,  "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                //Conta Entrada
                + " (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as cont_entrada, "
                //Soma Entradas
                + " (select ifnull(sum(quantidade),0) as soma from entrada inner join entrada_itens on entrada.id_entrada =  entrada_itens.entrada_id_entrada  "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as entradas, "
                //Conta Saida
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as cont_saida, "
                //Soma Saida
                + " (select ifnull(sum(quantidade),0) as soma from saida inner join saida_itens on id_saida =  saida_id_saida  "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as saidas, "
                //Conta Ajustes
                + " (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as cont_ajuste, "
                //Soma Ajustes
                + " (select ifnull(sum(quantidade),0) as soma from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as ajustes "
                //Tabelas
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                //Condição Entrada
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0"
                //Condição Saida
                + " or (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0"
                //Condição Ajustes
                + " or (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0 "
                //Ordenação
                + " order by produto.descricao");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                                
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "59 - Movimentação Geral de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Geral.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    public void Relatorio_Produto_Mov_Geral_Periodo_Categoria(JDateChooser dinicial,JDateChooser dfinal ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_categoria) as cont_categoria  "
                //Tabelas
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                //Condição Entrada
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0"
                //Condição Saida
                + " or (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0"
                //Condição Ajustes
                + " or (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0 ");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");  
        int Cont_Categoria = ObjConecta.rs.getInt("cont_categoria");
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *,  "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                //Conta Entrada
                + " (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as cont_entrada, "
                //Soma Entradas
                + " (select ifnull(sum(quantidade),0) as soma from entrada inner join entrada_itens on entrada.id_entrada =  entrada_itens.entrada_id_entrada  "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as entradas, "
                //Conta Saida
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as cont_saida, "
                //Soma Saida
                + " (select ifnull(sum(quantidade),0) as soma from saida inner join saida_itens on id_saida =  saida_id_saida  "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as saidas, "
                //Conta Ajustes
                + " (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as cont_ajuste, "
                //Soma Ajustes
                + " (select ifnull(sum(quantidade),0) as soma from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as ajustes "
                //Tabelas
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                //Condição Entrada
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0"
                //Condição Saida
                + " or (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0"
                //Condição Ajustes
                + " or (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0 "
                //Ordenação
                + " order by categoria,produto.descricao");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                                
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "59 - Movimentação Geral de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        parametros.put("Quant_Categoria",Cont_Categoria);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Geral_Categoria.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }

    public void Relatorio_Produto_Mov_Geral_Periodo_Categoria_Selecionada(JDateChooser dinicial,JDateChooser dfinal, String categoria ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_categoria) as cont_categoria  "
                //Tabelas
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' "
                //Condição Entrada
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0 and categoria = '"+categoria+"'"
                //Condição Saida
                + " or (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0 and categoria = '"+categoria+"'"
                //Condição Ajustes
                + " or (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0 and categoria = '"+categoria+"'");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");  
        int Cont_Categoria = ObjConecta.rs.getInt("cont_categoria");
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *,  "
                + " (select sum(quantidade_estoque) from lote_estoque where produto.id_produto = lote_estoque.produto_id_produto) as estoque, "
                //Conta Entrada
                + " (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as cont_entrada, "
                //Soma Entradas
                + " (select ifnull(sum(quantidade),0) as soma from entrada inner join entrada_itens on entrada.id_entrada =  entrada_itens.entrada_id_entrada  "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') as entradas, "
                //Conta Saida
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as cont_saida, "
                //Soma Saida
                + " (select ifnull(sum(quantidade),0) as soma from saida inner join saida_itens on id_saida =  saida_id_saida  "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as saidas, "
                //Conta Ajustes
                + " (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as cont_ajuste, "
                //Soma Ajustes
                + " (select ifnull(sum(quantidade),0) as soma from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') as ajustes "
                //Tabelas
                + " from produto inner join categoria_produto on produto.categoria_produto_id_categoria = categoria_produto.id_categoria "
                + " where produto.situacao = 'ATIVO' and categoria = '"+categoria+"' "
                //Condição Entrada
                + " and (select count(id_entrada) from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                + " where entrada_itens.produto_id_produto = id_produto and entrada.data_entrada between '" + di + "' and '" + df + "' and situacao_entrada != 'CANCELADA') > 0 and categoria = '"+categoria+"'"
                //Condição Saida
                + " or (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') > 0 and categoria = '"+categoria+"'"
                //Condição Ajustes
                + " or (select count(id_ajuste_estoque) from ajuste_estoque where produto_id_produto = id_produto "
                + " and data_ajuste between '" + di + "' and '" + df + "') > 0  and categoria = '"+categoria+"'"
                //Ordenação
                + " order by saidas desc, produto.descricao");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                                
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "59 - Movimentação Geral de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Itens",Cont);
        parametros.put("Quant_Categoria",Cont_Categoria);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Geral_Categoria.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    /////////////////////////////////////CURSO//////////////////////////
    
    public void Relatorio_Produto_Mov_Saida_Periodo_Curso(JDateChooser dinicial,JDateChooser dfinal ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_curso) as cont_curso"
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' ");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Curso = ObjConecta.rs.getInt("cont_curso");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as cont, "
                + " (select sum(quantidade) as soma from saida inner join saida_itens on id_saida = saida_id_saida "
                + " inner join turma on id_turma = turma_id_turma where produto_id_produto = id_produto and id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as saidas "
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' "
                + " group by nome_curso,saidas desc, descricao");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "61 - Movimentação de Saída por Curso de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Iten",Cont);
        parametros.put("Quant_Curso",Cont_Curso);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto_Curso.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    public void Relatorio_Produto_Mov_Saida_Periodo_Curso_Selecionado(JDateChooser dinicial,JDateChooser dfinal, String curso ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_curso) as cont_curso"
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and saida.situacao != 'CANCELADA' and nome_curso='"+curso+"'");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Curso = ObjConecta.rs.getInt("cont_curso");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where produto_id_produto = id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as cont, "
                + " (select sum(quantidade) as soma from saida inner join saida_itens on id_saida = saida_id_saida "
                + " inner join turma on id_turma = turma_id_turma where produto_id_produto = id_produto and id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA') as saidas "
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and nome_curso='"+curso+"'"
                + " group by nome_curso,saidas desc, descricao");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "61 - Movimentação de Saída por Curso Selecionado de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Iten",Cont);
        parametros.put("Quant_Curso",Cont_Curso);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto_Curso.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    /////////////////////////////////////TURMA//////////////////////////////////////q
    public void Relatorio_Produto_Mov_Saida_Periodo_Turma(JDateChooser dinicial,JDateChooser dfinal, String sql_semestre,String ano ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_turma) as cont_turma"
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+"");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Turma = ObjConecta.rs.getInt("cont_turma");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                //turma
                + " (select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma from curso "
                + " inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+") as turmas, "
                //cont
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida where id_turma = saida.turma_id_turma "
                + " and id_produto = produto_id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+") as cont, "
                //soma
                + " (select sum(quantidade) as soma from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where id_turma = saida.turma_id_turma and id_produto = produto_id_produto "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+") as saidas "
                //tabelas
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+""
                + " group by nome_curso, turmas,ano_turma,semestre,saidas desc, descricao;");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "62 - Movimentação de Saída por Turma de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Iten",Cont);
        parametros.put("Quant_Curso",Cont_Turma);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto_Turma.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    public void Relatorio_Produto_Mov_Saida_Periodo_Turma_Curso_Selecionado(JDateChooser dinicial,JDateChooser dfinal, String sql_semestre,String ano, String curso ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_turma) as cont_turma"
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"'");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Curso = ObjConecta.rs.getInt("cont_turma");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                //turma
                + " (select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma from curso "
                + " inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"') as turmas, "
                //cont
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida where id_turma = saida.turma_id_turma "
                + " and id_produto = produto_id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"') as cont, "
                //soma
                + " (select sum(quantidade) as soma from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where id_turma = saida.turma_id_turma and id_produto = produto_id_produto "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"') as saidas "
                //tabelas
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"' "
                + " group by nome_curso, turmas,ano_turma,semestre,saidas desc, descricao;");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "62 - Movimentação de Saída por Turma de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Iten",Cont);
        parametros.put("Quant_Curso",Cont_Curso);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto_Turma.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    public void Relatorio_Produto_Mov_Saida_Periodo_Turma_Selecionada_Curso_Selecionado(JDateChooser dinicial,JDateChooser dfinal, String sql_semestre,String ano, String curso, int id_turma ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_turma) as cont_turma"
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+" "
                + " and nome_curso ='"+curso+"' and id_turma="+id_turma);
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Turma = ObjConecta.rs.getInt("cont_turma");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct id_produto, descricao, categoria, solicita_devolucao, unidade, id_turma, nome_curso, data_cad_produto, "
                //turma
                + " (select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turma from curso "
                + " inner join turma on curso.id_curso = turma.curso_id_curso where turma.id_turma = saida.turma_id_turma "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"' and id_turma="+id_turma+") as turmas, "
                //cont
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida where id_turma = saida.turma_id_turma "
                + " and id_produto = produto_id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"' and id_turma="+id_turma+") as cont, "
                //soma
                + " (select sum(quantidade) as soma from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where id_turma = saida.turma_id_turma and id_produto = produto_id_produto "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"' and id_turma="+id_turma+") as saidas "
                //tabelas
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+" "
                + " and nome_curso ='"+curso+"' and id_turma="+id_turma+" "
                + " order by saidas desc, descricao");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "62 - Movimentação de Saída por Turma de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Iten",Cont);
        parametros.put("Quant_Curso",Cont_Turma);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto_Turma.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    /////////////////////////////DISCIPLINA/////////////////////////////////////////
    
    public void Relatorio_Produto_Mov_Saida_Periodo_Disciplina(JDateChooser dinicial,JDateChooser dfinal, String sql_semestre,String ano ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_disciplina) as cont_disciplina"
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " inner join disciplina on id_disciplina = disciplina_id_disciplina "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+"");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Disciplina = ObjConecta.rs.getInt("cont_disciplina");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                //cont
                 + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida where id_disciplina = saida.disciplina_id_disciplina "
                + " and id_produto = produto_id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+") as cont, "
                //soma
                + " (select sum(quantidade) as soma from saida inner join saida_itens on id_saida = saida_id_saida "
                + " where disciplina_id_disciplina = id_disciplina and id_produto = produto_id_produto "                
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+") as saidas "
                //tabelas
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " inner join disciplina on disciplina_id_disciplina = id_disciplina "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+""
                + " group by nome_curso,disciplina.semestre,disciplina,saidas desc,descricao;");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "63 - Movimentação de Saída por Disciplina Ano "+ano+" de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Iten",Cont);
        parametros.put("Quant_Curso",Cont_Disciplina);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto_Disciplina.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    public void Relatorio_Produto_Mov_Saida_Periodo_Disciplina_Curso_Selecionado(JDateChooser dinicial,JDateChooser dfinal, String sql_semestre,String ano, String curso ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_disciplina) as cont_disciplina"
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " inner join disciplina on id_disciplina = disciplina_id_disciplina "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"'");
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Disciplina = ObjConecta.rs.getInt("cont_disciplina");
        
        //metodo para preencher o relatorio
        ObjConecta.ExecutaSQL("select distinct *, "
                //cont
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida where id_disciplina = saida.disciplina_id_disciplina "
                + " and id_produto = produto_id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"') as cont, "
                //soma
                + " (select sum(quantidade) from saida inner join saida_itens on id_saida = saida_id_saida where saida.disciplina_id_disciplina = id_disciplina "
                + " and id_produto = produto_id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"') as saidas "
                //tabelas
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " inner join disciplina on disciplina_id_disciplina = id_disciplina "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+"and nome_curso ='"+curso+"' "
                + " group by nome_curso,disciplina.semestre,disciplina,saidas desc,descricao;");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "63 - Movimentação de Saída por Disciplina Ano "+ano+" de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Iten",Cont);
        parametros.put("Quant_Curso",Cont_Disciplina);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto_Disciplina.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
    
    public void Relatorio_Produto_Mov_Saida_Periodo_Disciplina_Selecionada_Curso_Selecionado(JDateChooser dinicial,JDateChooser dfinal, String sql_semestre,String ano, String curso, int id_disciplina ){
        try {
        ObjConecta.Conectar();
        
        String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
        String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
        String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
        String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());
        String intervalo = dti+" até "+dtf;
        long DiasIntervalo = 0;
        //calcular dias entre as datas
        long Dias = (((dfinal.getDate().getTime() - dinicial.getDate().getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        //metodo para contar a quantidade
        ObjConecta.ExecutaSQL("select count(distinct id_produto) as cont, count(distinct id_disciplina) as cont_disciplina"
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " inner join disciplina on id_disciplina = disciplina_id_disciplina "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' "
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"' and disciplina_id_disciplina ="+id_disciplina);
        ObjConecta.rs.first();
        int Cont = ObjConecta.rs.getInt("cont");
        int Cont_Disciplina = ObjConecta.rs.getInt("cont_disciplina");
        
        //metodo para preencher o relatorio
//        
        ObjConecta.ExecutaSQL("select distinct id_produto,descricao,id_disciplina,disciplina,disciplina.semestre,nome_curso,categoria,solicita_devolucao, unidade,data_cad_produto, "
                //cont
                + " (select count(id_saida) from saida inner join saida_itens on id_saida = saida_id_saida where id_disciplina = saida.disciplina_id_disciplina "
                + " and id_produto = produto_id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"' and disciplina_id_disciplina = "+id_disciplina+") as cont, "
                //soma
                + " (select sum(quantidade) from saida inner join saida_itens on id_saida = saida_id_saida where disciplina_id_disciplina = id_disciplina "
                + " and id_produto = produto_id_produto and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA'"
                + " and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"'and id_disciplina = "+id_disciplina+") as saidas "
                //tabelas
                + " from produto inner join saida_itens on id_produto = produto_id_produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                + " inner join saida on id_saida = saida_id_saida inner join turma on turma.id_turma = saida.turma_id_turma inner join curso on curso.id_curso = turma.curso_id_curso "
                + " inner join disciplina on disciplina_id_disciplina = id_disciplina "
                + " and saida.data_saida between '" + di + "' and '" + df + "' and saida.situacao != 'CANCELADA' and ano_turma = "+ano+" "+sql_semestre+" and nome_curso ='"+curso+"' and id_disciplina = "+id_disciplina+""
                + " order by nome_curso,disciplina.semestre,disciplina,saidas desc,descricao;");
                
        JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                        
        //passar parametros para o relátorio
        HashMap parametros = new HashMap();
        parametros.put("Usuario", UserLogado);
        parametros.put("Tipo_Relatorio", "63 - Movimentação de Saída por Disciplina Ano "+ano+" de "+intervalo);
        parametros.put("Organizacao",Org);
        parametros.put("Quant_Iten",Cont);
        parametros.put("Quant_Curso",Cont_Disciplina);
        JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Mov_Saida_Produto_Disciplina.jasper", parametros, Relatorio);
        JasperViewer JView = new JasperViewer(JPrint, false);
        JView.setVisible(true);
        //Colocar titulo na janela
        JView.setTitle("Relatório De Produto");
        //Colocar icone na janela
        JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
        ObjConecta.Desconecta();
    } catch (JRException | SQLException ex) {
        ObjConecta.Desconecta();
        JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
            }
    }
}

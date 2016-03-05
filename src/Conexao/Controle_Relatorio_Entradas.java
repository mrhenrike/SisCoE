package Conexao;

// @author Márison Tamiarana

import GUI_Frames.Tela_Principal;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Controle_Relatorio_Entradas {

    Conecta_Banco ObjConecta = new Conecta_Banco();
    Tela_Principal ObjTP = new Tela_Principal();
    
    @SuppressWarnings("unchecked")
    public void Relatorio_Entrada_Prod_Todos(){
        try {
                ObjConecta.Conectar();//abre a conexão
                ObjConecta.ExecutaSQL("select * from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada inner join produto"
                    + " on produto.id_produto=entrada_itens.produto_id_produto");
                JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);//instacia um objeto para receber o resultset da  sql                
                HashMap parametros = new HashMap();//instancia um hashMap para passar os parametros;
                parametros.put("Usuario",ObjTP.UserLogado);//Se precisar passar algum parametro, tipo usuario logado
                //Aqui fica o diretorio do arquivo
                JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Entradas_Todos.jasper",parametros, Relatorio);
                JasperViewer JView = new JasperViewer(JPrint, false);
                JView.setVisible(true);//Seta visivel                
                JView.setTitle("Relatório De Entrada");//Colocar titulo na janela
                JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage()); //Colocar icone na janela
                ObjConecta.Desconecta();//fecjha a conexão
            } catch (JRException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
            }
    }
    
    public void Relatorio_Entrada_Prod_Ultimos_30_Dias(){
        try {
                Calendar c = Calendar.getInstance();
                c.add(Calendar.MONTH, -1); //diminuir datas - inicio para 90 dias;
                String df = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                String di = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("select * from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                    + "inner join produto on produto.id_produto=entrada_itens.produto_id_produto where entrada.data_entrada between '"+di+"' and '"+df+"'");
                JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                //passar parametros para o relátorio
                HashMap parametros = new HashMap();
                parametros.put("Data_Inicial",di);
                parametros.put("Data_Final", df);
                parametros.put("Usuario",ObjTP.UserLogado);

                JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Entradas_Ultimos_30_Dias.jasper", parametros, Relatorio);
                JasperViewer JView = new JasperViewer(JPrint, false);
                JView.setVisible(true);
                //Colocar titulo na janela
                JView.setTitle("Relatório De Entrada");
                //Colocar icone na janela
                JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
                ObjConecta.Desconecta();
            } catch (JRException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
            }
    }
    
    public void Relatorio_Entrada_Periodo(JDateChooser dinicial,JDateChooser dfinal ){
        try {
            String di = new SimpleDateFormat("yyyy-MM-dd").format(dinicial.getDate());
            String dti = new SimpleDateFormat("dd-MM-yyyy").format(dinicial.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(dfinal.getDate());
            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(dfinal.getDate());

            ObjConecta.Conectar();
            //Conta quantidades de itens
            ObjConecta.ExecutaSQL("select count(id_entrada) as cont from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                    + "inner join produto on produto.id_produto=entrada_itens.produto_id_produto where entrada.data_entrada between '" + di + "' and '" + df + "'");
            ObjConecta.rs.first();
            int ContItens = ObjConecta.rs.getInt("cont");
            //conta a quantidade de entradas
            ObjConecta.ExecutaSQL("select count(id_entrada) as cont from entrada where entrada.data_entrada between '" + di + "' and '" + df + "'");
            ObjConecta.rs.first();
            int ContEntradas = ObjConecta.rs.getInt("cont");

            ObjConecta.ExecutaSQL("select * from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada "
                    + "inner join produto on produto.id_produto=entrada_itens.produto_id_produto where entrada.data_entrada between '" + di + "' and '" + df + "'");
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            //passar parametros para o relátorio
            HashMap parametros = new HashMap();
            parametros.put("Data_Inicial", di);
            parametros.put("Data_Final", df);
            parametros.put("Usuario", ObjTP.UserLogado);
            parametros.put("DTI", dti);
            parametros.put("DTF", dtf);
            parametros.put("Quant_Iten", ContItens);
            parametros.put("Quant_Entrada", ContEntradas);

            JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Entradas_Periodo.jasper", parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Entrada");
            //Colocar icone na janela
            JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
            ObjConecta.Desconecta();
        } catch (JRException | SQLException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + ex);
        }
    }
    
    public void Relatorio_Entrada_N_Entrada(JTextField jt){
    try {
                    ObjConecta.Conectar();
                    ObjConecta.ExecutaSQL("select * from entrada inner join entrada_itens on entrada.id_entrada=entrada_itens.entrada_id_entrada inner join produto"
                        + " on produto.id_produto=entrada_itens.produto_id_produto where entrada.id_entrada='"+jt.getText().trim()+"'");
                    JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                    HashMap parametros = new HashMap();
                    parametros.put("Usuario",ObjTP.UserLogado);
                    parametros.put("Num_Entrada",jt.getText().trim());
                    JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Entradas_Num_Entrada.jasper",parametros, Relatorio);
                    JasperViewer JView = new JasperViewer(JPrint, false);
                    JView.setVisible(true);
                    //Colocar titulo na janela
                    JView.setTitle("Relatório De Entrada");
                    //Colocar icone na janela
                    JView.setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png")).getImage());
                    ObjConecta.Desconecta();
                } catch (JRException ex) {
                    ObjConecta.Desconecta();
                    JOptionPane.showMessageDialog(null,"Erro ao gerar o relatório: "+ex);
                }
    }
    
    public void Relatorio_Inicialzar(){
    try {
                    ObjConecta.Conectar();
                    ObjConecta.ExecutaSQL("select * from usuario");
                    JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
                    JasperPrint JPrint = JasperFillManager.fillReport("C:\\Program Files (x86)\\SisCoE/Relat_Inicializar.jasper",new HashMap(), Relatorio);
                    JasperViewer JView = new JasperViewer(JPrint, false);
                    JView.setVisible(false);
                    JView.dispose();
                    ObjConecta.Desconecta();
                } catch (JRException ex) {
                    ObjConecta.Desconecta();
                    JOptionPane.showMessageDialog(null,"Erro ao gerar o inicializar: "+ex);
                }
    }
}

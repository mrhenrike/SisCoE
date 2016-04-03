package Conexao;

// @author Márison Tamiarana

import static GUI_Frames.Tela_Principal.UserLogado;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Controle_Relatorio_Log {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    
    public void Relatorio_Log_Hoje(String hoje, JTextField filtro){
        try {
            ObjConecta.Conectar();
            //contar registros
            ObjConecta.ExecutaSQL("select count(id_log_sistema) as cont from log_sistema inner join usuario on usuario_id_usuario = id_usuario "
                    + " where acao like '%"+ filtro.getText().toUpperCase() + "%' and data ='"+hoje+"'");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("select * from log_sistema inner join usuario on usuario_id_usuario = id_usuario "
                    + " where acao like '%"+ filtro.getText().toUpperCase() + "%' and data ='"+hoje+"' order by id_log_sistema");            
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Tipo_Relatorio","Relatório De Log Do Sistema Referente A Hoje");
            String C = "C:\\Program Files (x86)\\SisCoE/Relat_Log.jasper";
            //String C = "/Relatorios/Relat_Produtos_Todos.jasper";
            JasperPrint JPrint = JasperFillManager.fillReport(C,parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Log Do Sistema");
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
    
    public void Relatorio_Log_Periodo(String di,String df,String dti,String dtf, JTextField filtro){
        try {
            ObjConecta.Conectar();
            //contar registros
            ObjConecta.ExecutaSQL("select count(id_log_sistema) as cont from log_sistema inner join usuario on usuario_id_usuario = id_usuario "
                    + " where acao like '%"+ filtro.getText().toUpperCase() + "%' and data between '"+di+"' and '"+df+"'");
            ObjConecta.rs.first();
            int Cont = ObjConecta.rs.getInt("cont");
            //consulta
            ObjConecta.ExecutaSQL("select * from log_sistema inner join usuario on usuario_id_usuario = id_usuario "
                    + " where acao like '%"+ filtro.getText().toUpperCase() + "%' and data between '"+di+"' and '"+df+"' order by id_log_sistema");            
            JRResultSetDataSource Relatorio = new JRResultSetDataSource(ObjConecta.rs);
            HashMap parametros = new HashMap();
            parametros.put("Usuario",UserLogado);
            parametros.put("Quant_Itens",Cont);
            parametros.put("Tipo_Relatorio","Relatório De Log Do Sistema Referente Ao Período De "+dti+" Até "+dtf);
            String C = "C:\\Program Files (x86)\\SisCoE/Relat_Log.jasper";
            //String C = "/Relatorios/Relat_Produtos_Todos.jasper";
            JasperPrint JPrint = JasperFillManager.fillReport(C,parametros, Relatorio);
            JasperViewer JView = new JasperViewer(JPrint, false);
            JView.setVisible(true);
            //Colocar titulo na janela
            JView.setTitle("Relatório De Log Do Sistema");
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

package GUI_Frames;

//@author Márison Tamiarana

import Conexao.Conecta_Banco;
import Conexao.Controle_Relatorio_Entradas;
import Conexao.Controle_Usuario;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import static java.lang.Thread.sleep;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;



public class Tela_Splash extends javax.swing.JDialog {

    Conecta_Banco ObjConecta = new Conecta_Banco();
    Controle_Relatorio_Entradas ObjControlRelat = new Controle_Relatorio_Entradas();
    Controle_Usuario ObjControlUser = new Controle_Usuario();
    
    public Tela_Splash(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LookAndFeel();
        setLocationRelativeTo(parent);
        setResizable(false);
        setSize(650,280);
        Sleep();
}
    public final void Sleep (){
     new Thread(){
           
            @Override
            public void run (){
               
                for(int i = 0; i<101; i++){
                    try {
                        sleep(30);
                        jProgressBar1.setValue(i);
                        
                        jProgressBar1.setIndeterminate(true);
                                                                        
                        if(jProgressBar1.getValue() <= 20){
                            
                            JTF_Mensagem.setText("Carregando Banco de Dados...");
                            ObjConecta.Conectar(); 
                            
                            ObjControlUser.Primeiro_Acesso();
                            if(ObjControlUser.ControleExistente == true)
                            {
                                ObjControlRelat.Relatorio_Inicialzar();
                                ObjControlUser.ControleExistente = false;
                            }
                                if(ObjConecta.Conectado==false){
                                    JTF_Mensagem.setText("Erro Ao Conectar Ao Banco De Dados");
                                    sleep(3000);
                                    JTF_Mensagem.setText("O Sistema Será Encerrado!");
                                    sleep(3000);

                                    System.exit(0);
                                }                            
                        }else if(jProgressBar1.getValue() <=40)
                        {
                            JTF_Mensagem.setText("Banco De Dados Conectado...");
                        }                        
                        else if(jProgressBar1.getValue() <=60){
                            ObjConecta.Desconecta();
                            JTF_Mensagem.setText("Carregando Tabelas...");
                            
                        }
                        else if(jProgressBar1.getValue() <=80){
                            ObjConecta.Desconecta();
                            JTF_Mensagem.setText("Carregando Sistema...");
                        }
                        else{
                            JTF_Mensagem.setText("O Sistema Está Sendo Iniciado...");
                        }
                           
   
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao carregar o sistema"+ex);
                    }
                   
                } dispose(); 
               
             Primeiro_Acesso();
             
            }
    
  }.start(); 
    }
    
    void Primeiro_Acesso(){
        ObjControlUser.Primeiro_Acesso();
        if(ObjControlUser.ControleExistente == true){
            Tela_Principal obj = new Tela_Principal();
            obj.getInstancia().setVisible(true);
            Tela_Login ObjLogin = new Tela_Login(obj, true);
            ObjLogin.dispose();
        }else{
            Tela_Cadastro_Inicial Obj = new  Tela_Cadastro_Inicial(null, true);
            Obj.setVisible(true);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        JTF_Mensagem = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCoE - Sistema De Controle De Estoque");
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jProgressBar1.setStringPainted(true);

        JTF_Mensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Copyright © 2015 - 2016 SisCoE - Todos os direitos reservados");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("SisCoE - Sistema de Controle de Estoque");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Logo - SisCoE 2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTF_Mensagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(JTF_Mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(646, 278));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Tela_Splash dialog = new Tela_Splash(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JTF_Mensagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    
    public final void LookAndFeel(){
        try {
            
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
//            props.put("foregroundColor", "255 255 255"); //seleção letra
//            props.put("backgroundColor", "255 0 102"); //seleção fundo
//            props.put("backgroundColorLight", "255 0 102"); //cor dos componentes acima
//            props.put("backgroundColorDark", "255 50 102"); //cor dos componentes abaixo
//            props.put("inputForegroundColor", "255 0 153"); //cor da letra ao ser digitado
//            props.put("inputBackgroundColor", "255 0 153"); //cor do fundo dos campos            
//            props.put("selectionBackgroundColor", "255 0 102"); //seleção fundo ao passar o mouse
//            props.put("selectionForegroundColor", "255 255 255"); //seleção letra ao passar o mouse
//            props.put("frameColor", "255 0 102"); //contorno dos botoes e das textfileds            
//            props.put("gridColor", "255 0 102"); //linhas das tabelas  
//            props.put("controlColorLight", "255 0 103"); //barra de carregamento acima
//            props.put("controlColorDark", "255 0 103"); //barra da carregamento abaixo
            
            //Botoes
//            props.put("rolloverColorLight", "255 50 102"); //cor dos botoes ao passar o mouse acima
//            props.put("rolloverColorDark", "255 0 102"); //cor dos botoes ao passar o mouse abaixo
//            props.put("buttonColorLight", "255 0 102"); //cor dos botoes acima
//            props.put("buttonColorDark", "255 255 255"); //cor dos botoes abaixo            
//            props.put("buttonForegroundColor", "255 0 102"); //cor da fonte dos botoes 
//            props.put("focusColor", "0 0 0");//cor do focus no botao
//            props.put("controlForegroundColor", "255 0 102"); //cor da seta onde escreve piscando
            
            //Janela
//            props.put("windowTitleForegroundColor", "0 0 0");//Titulo da janela
//            props.put("windowTitleBackgroundColor", "255 0 153");//contorno do titulo
//            props.put("windowTitleColorLight", "255 0 153");//barra da janela cima
//            props.put("windowTitleColorDark", "255 51 153"); //barra da janela baixo
//            props.put("windowBorderColor", "255 0 153");//bordas da janela          
//            props.put("windowIconColor", "255 0 153"); //icones da janela(fechar, max e mini)
//            props.put("windowIconShadowColor", "255 0 102"); //sombra icones da janela(fechar, max e mini)
//            props.put("windowIconRolloverColor", "255 0 102"); //icones da janela(fechar, max e mini) ao passar o mouse
            
            //Menus
//            props.put("menuForegroundColor", "255 0 102"); //cor das letras dos menus
//            props.put("menuBackgroundColor", "0 0 0");//cor do fundo do menu(bordas)
//            props.put("menuColorLight", "255 0 153");//cor do menu acima
//            props.put("menuColorDark", "255 0 153");//cor do menu abaixo
//            props.put("menuSelectionBackgroundColor", "255 255 255");//cor da linha selecionada no menu
//            props.put("menuSelectionBackgroundColorLight", "255 51 103"); //cor do fundo selecionada no menu acima
//            props.put("menuSelectionBackgroundColorDark", "255 0 103"); //cor do fundo selecionada no menu abaixo
//            props.put("menuSelectionForegroundColor", "255 0 102");//cor da letra selecionada no menu
//            props.put("menuOpaque", "off"); //menu translucido
            
            //Texto de ajuda
//            props.put("tooltipForegroundColor", "0 0 0");//cor da letra do texto de ajuda
//            props.put("tooltipBackgroundColor", "255 0 102");//cor do fundo do texto de ajuda
//            props.put("tooltipBorderSize", "5");//largura da borda do texto de ajuda            
//            props.put("tooltipShadowSize", "8");//sombra do texto de ajuda 
            
            props.put("textureSet", "Snow");//bordas da janela
            props.put("backgroundTexture", "on"); //barra da janela baixo
            
//            props.put("windowBorderColor", "0 0 0");//bordas da janela
            
            GraphiteLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new GraphiteLookAndFeel());
             SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}


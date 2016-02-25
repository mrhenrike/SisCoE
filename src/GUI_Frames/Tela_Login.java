package GUI_Frames;

//@author Márison Tamiarana

import Conexao.Conecta_Banco;
import Conexao.Controle_Lote_Estoque;
import Conexao.Controle_Saida_Produto;
import Conexao.Controle_Usuario;
import GUI_Dialogs_Principal.Inf_Senha_Usuario_Invalido;
import GUI_Dialogs_Principal.Logoff_Login;
import Metodos.Formatacao;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;



public class Tela_Login extends javax.swing.JDialog {

    Conecta_Banco ObjConecta = new Conecta_Banco();
    Controle_Usuario ObjControlUser = new Controle_Usuario();
    private static Logoff_Login ObjLogoff;
    private static Tela_Principal TP;
    private static Inf_Senha_Usuario_Invalido ObjUserInvalido;
    Formatacao ObjFormat = new Formatacao();
        
    public Tela_Login(Tela_Principal parent, boolean modal) {
        this.TP = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(TP);
        setResizable(false);
        setSize(670,350);
        Setar_Atalho_BT_OK();
        JTF_LG_Usuario.setDocument(ObjFormat.new Format_Geral(50));
        JPF_LG_Senha.setDocument(ObjFormat.new Format_Geral(50));
        //JTF_LG_Usuario.setText("MÁRISON");
        //JPF_LG_Senha.setText("ANDREY");
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JCB_LG_Permissão = new javax.swing.JComboBox();
        JTF_LG_Usuario = new javax.swing.JTextField();
        JPF_LG_Senha = new javax.swing.JPasswordField();
        BT_Ok = new javax.swing.JButton();
        BT_Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCoE - Sistema De Controle De Estoque");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Login - Seja Bem Vindo!");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Logo - SisCoE 2.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Usuario");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Cadeado - Login.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Permissão");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Senha");

        JCB_LG_Permissão.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_LG_Permissão.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ADMINISTRADOR", "USUÁRIO" }));
        JCB_LG_Permissão.setToolTipText("Selecione O Tipo De Permissão Ao Sistema");

        JTF_LG_Usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_LG_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_LG_UsuarioActionPerformed(evt);
            }
        });

        JPF_LG_Senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JPF_LG_Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPF_LG_SenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JPF_LG_Senha)
                    .addComponent(JTF_LG_Usuario)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(JCB_LG_Permissão, 0, 195, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCB_LG_Permissão, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTF_LG_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JPF_LG_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        BT_Ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Ok.png"))); // NOI18N
        BT_Ok.setMnemonic('o');
        BT_Ok.setToolTipText("Clique Para Efetuar O Login Ou Pressione Alt + O");
        BT_Ok.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Ok Press.png"))); // NOI18N
        BT_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_OkActionPerformed(evt);
            }
        });

        BT_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar.png"))); // NOI18N
        BT_Cancelar.setMnemonic('c');
        BT_Cancelar.setToolTipText("Clique Para Cancelar Ou Pressione Alt + C");
        BT_Cancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar Press.png"))); // NOI18N
        BT_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(BT_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BT_Ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BT_Cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(646, 317));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_LG_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_LG_UsuarioActionPerformed
        JPF_LG_Senha.requestFocus();
    }//GEN-LAST:event_JTF_LG_UsuarioActionPerformed

    private void JPF_LG_SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPF_LG_SenhaActionPerformed
        BT_Ok.requestFocus();
    }//GEN-LAST:event_JPF_LG_SenhaActionPerformed

    private void BT_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_OkActionPerformed
        ObjControlUser.Acesso_Adm("SISTEMA");
        if((JTF_LG_Usuario.getText().equalsIgnoreCase(ObjControlUser.Adm_Login))&&(JCB_LG_Permissão.getSelectedItem().equals("ADMINISTRADOR"))
               && (new String(JPF_LG_Senha.getPassword()).equalsIgnoreCase(ObjControlUser.Adm_Senha))) 
       {
            dispose();
            TP.Setar_Usuario(JTF_LG_Usuario.getText(), "SISTEMA");
            ObjControlUser.Acesso_Adm("ADMINISTRADOR");
            if(ObjControlUser.ControleAdm == true){}
            else{
                TP.Mostrar_Cad_Usuario();
            }
       }else{
           ObjControlUser.Controle_Acesso(JTF_LG_Usuario, JCB_LG_Permissão, JPF_LG_Senha);
           if(ObjControlUser.ControleAcesso==true){
                dispose();
                TP.Setar_Usuario(JTF_LG_Usuario.getText(), JCB_LG_Permissão.getSelectedItem().toString());
                //TP.Controle_De_Acesso();
                Abaixo_Do_Minimo();
                Abaixo_De_30_Dias();
                Produto_Vencido();
                Devolucao_Pendente();
                ObjControlUser.ControleAcesso=false;
           }else{
               Mostrar_Usuario_Invalido();
           }
       }
       
    }//GEN-LAST:event_BT_OkActionPerformed

    private void BT_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CancelarActionPerformed
        Mostrar_Logoff();
    }//GEN-LAST:event_BT_CancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Mostrar_Logoff();
    }//GEN-LAST:event_formWindowClosing

    public void Abaixo_Do_Minimo(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_produto");            
            Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
            obj.Verificar_Abaixo_Do_Minimo();
            if(obj.Abaixo_Do_Minimo == true){
                TP.Mostrar_Abaixo_Do_Minimo();
                obj.Abaixo_Do_Minimo=false;
            }
        } catch (SQLException ex) {
            
        }ObjConecta.Desconecta();
    }
    
    public void Abaixo_De_30_Dias(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_produto");
            Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
            obj.Verifica_Validade_30_Dias();
            if(obj.Menos_De_30_Dias ==true){
                TP.Mostrar_Validade();
                obj.Menos_De_30_Dias=false;
            }
        } catch (SQLException ex) {
           
        }ObjConecta.Desconecta();
    }
    
    public void Produto_Vencido(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_produto");
            Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
            obj.Verifica_Produto_Vencido();
            if(obj.Produto_Vencido ==true){
                TP.Mostrar_Prod_Vencido();
                obj.Produto_Vencido =false;
            }
        } catch (SQLException ex) {
           
        }ObjConecta.Desconecta();
    }
    
    public void Devolucao_Pendente(){
        Controle_Saida_Produto obj = new Controle_Saida_Produto();
        obj.Devolucao_Pendente();
        if(obj.Controla_Devolucao_Pendente ==true){
            TP.Mostrar_Dev_Pendente();
            obj.Controla_Devolucao_Pendente =false;
        }
    }
    
    void Mostrar_Usuario_Invalido(){
        ObjUserInvalido = new Inf_Senha_Usuario_Invalido(this, true);
        ObjUserInvalido.setVisible(true);
    }
    public final void Setar_Atalho_BT_OK(){
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),"Tecla");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        this.getRootPane().getActionMap().put("Tecla", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Ok.doClick();
    }
    });
    }
    
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
            java.util.logging.Logger.getLogger(Tela_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Tela_Login dialog = new Tela_Login((Tela_Principal) new javax.swing.JFrame(), true);
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
    public void Mostrar_Logoff(){
        ObjLogoff = new Logoff_Login(this, true);
        ObjLogoff.setVisible(true);
    }
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Cancelar;
    private javax.swing.JButton BT_Ok;
    public javax.swing.JComboBox JCB_LG_Permissão;
    private javax.swing.JPasswordField JPF_LG_Senha;
    public javax.swing.JTextField JTF_LG_Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

   
}


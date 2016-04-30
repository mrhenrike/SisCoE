package GUI_Dialogs_Principal;

// @author Márison Tamiarana

import GUI_Frames.Tela_Principal;
import static GUI_Frames.Tela_Principal.UserLogado;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Inf_Mensagens extends javax.swing.JDialog {
    
    public static Tela_Principal ObjTP;
    String saudacao;    
    
    public Inf_Mensagens(Tela_Principal parent, boolean modal) {
        this.ObjTP = parent;
        this.setModal(modal);
        initComponents();
        setResizable(false);
        setSize(700,470);
        setLocationRelativeTo(ObjTP);
        JTP_Informacao.setEnabled(false);
        Saudacao();
        Add_Mensagen();        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JB_Ok = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTP_Informacao = new javax.swing.JTextPane();
        JL_Mensagem = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informação!");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Information_75X75.png"))); // NOI18N

        JB_Ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Ok.png"))); // NOI18N
        JB_Ok.setMnemonic('o');
        JB_Ok.setToolTipText("Ok (Alt+O)");
        JB_Ok.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Ok Press.png"))); // NOI18N
        JB_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_OkActionPerformed(evt);
            }
        });

        JTP_Informacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(JTP_Informacao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JL_Mensagem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JL_Mensagem.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Você tem mensagem(ns) importante(s) logo abaixo! Por favor as leia!");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Você pode rever essa mensagem clicando no botão ALERTAS ao lado!");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                            .addComponent(JL_Mensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JB_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jLabel2)
                    .addContainerGap(652, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2)
                    .addContainerGap(406, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_OkActionPerformed
        Saudacao();
        Add_Mensagen();
        dispose();
    }//GEN-LAST:event_JB_OkActionPerformed

    final void Add_Mensagen(){
        String minimo;
        String abaixo30;        
        String vencido;   
        String devolucao;
        String devolucao_outra;
        ObjTP.Verifica_Informacao();
        if(ObjTP.Abaixo_Minimo != true && ObjTP.Abaixo_30 != true && ObjTP.Vencido != true && ObjTP.Devolucao_Pendente != true
                && ObjTP.Devolucao_Pendente_Outra != true){
            JTP_Informacao.setText("MENSAGEM: \n\n>> VOCÊ NÃO TEM MENSAGEM(NS)!");
        }else{
            if(ObjTP.Abaixo_Minimo == true){
                minimo = "\n>> EXITE(M) PRODUTO(S) COM ESTOQUE ABAIXO DO MÍNIMO!\n";
            }else{
                minimo = "";
            }
            if(ObjTP.Abaixo_30 == true){
                abaixo30 = "\n>> EXITE(M) PRODUTO(S) COM VALIDADE ABAIXO DO 30 DIAS!\n";            
            }else{
                abaixo30 = "";
            }
            if(ObjTP.Vencido == true){
                vencido = "\n>> EXITE(M) PRODUTO(S) COM A VALIDADE VENCIDA!\n";            
            }else{
                vencido = "";
            }
            if(ObjTP.Devolucao_Pendente == true){
                devolucao = "\n>> EXITE(M) SAÍDA(S) COM DEVOLUÇÃO PENDENTE!\n";            
            }else{
                devolucao = "";
            }
            if(ObjTP.Devolucao_Pendente_Outra == true){
                devolucao_outra = "\n>> EXITE(M) OUTRA(S) SAÍDA(S) COM DEVOLUÇÃO PENDENTE!\n";            
            }else{
                devolucao_outra = "";
            }
            ObjTP.Abaixo_Minimo = false;
            ObjTP.Abaixo_30 = false;
            ObjTP.Vencido = false;
            ObjTP.Devolucao_Pendente = false;
            ObjTP.Devolucao_Pendente_Outra = false;
            JTP_Informacao.setText("MENSAGEM(NS): \n"+minimo+abaixo30+vencido+devolucao+devolucao_outra);
        }
    }
    
    final void Saudacao(){
        int hora = Integer.parseInt(new SimpleDateFormat("HH").format(new Date(System.currentTimeMillis())));        
        if(hora < 12){
            saudacao = "Olá! Bom Dia "+UserLogado;
            JL_Mensagem.setText(saudacao);
        }else if(hora < 18){
            saudacao = "Olá! Boa Tarde "+UserLogado;
            JL_Mensagem.setText(saudacao);
        }else{
            saudacao = "Olá! Boa Noite "+UserLogado;
            JL_Mensagem.setText(saudacao);
        }
        
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inf_Mensagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }      
   

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Inf_Mensagens dialog = new Inf_Mensagens(ObjTP, true);
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
    private javax.swing.JButton JB_Ok;
    private javax.swing.JLabel JL_Mensagem;
    private javax.swing.JTextPane JTP_Informacao;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

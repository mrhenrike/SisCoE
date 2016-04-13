package GUI_Dialogs_Entrada;

// @author Márison Tamiarana

import GUI_Frames.Tela_Entrada_Produto_Cont;


public class Conf_Sair_Sem_Salvar_Ent_Cont extends javax.swing.JDialog {
    
   public static Tela_Entrada_Produto_Cont ObjEntrada;
    
    public Conf_Sair_Sem_Salvar_Ent_Cont(Tela_Entrada_Produto_Cont parent, boolean modal) {
        this.ObjEntrada = parent;
        this.setModal(modal);
        initComponents();
        setResizable(false);
        setSize(430,130);
        setLocationRelativeTo(ObjEntrada);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JB_Nao = new javax.swing.JButton();
        JB_Sim = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmação Ao Sair");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Deseja sair sem salvar?");

        JB_Nao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Não.png"))); // NOI18N
        JB_Nao.setMnemonic('n');
        JB_Nao.setToolTipText("Não (Alt+N)");
        JB_Nao.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Não Press.png"))); // NOI18N
        JB_Nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_NaoActionPerformed(evt);
            }
        });

        JB_Sim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sim.png"))); // NOI18N
        JB_Sim.setMnemonic('s');
        JB_Sim.setToolTipText("Sim (Alt+S)");
        JB_Sim.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sim Press.png"))); // NOI18N
        JB_Sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_SimActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Log Out_75x75.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JB_Sim, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JB_Nao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jLabel2)
                    .addContainerGap(366, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JB_Sim, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_Nao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2)
                    .addContainerGap(60, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_NaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_NaoActionPerformed
        dispose();
    }//GEN-LAST:event_JB_NaoActionPerformed

    private void JB_SimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_SimActionPerformed
       ObjEntrada.dispose();
       dispose();
    }//GEN-LAST:event_JB_SimActionPerformed

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
            java.util.logging.Logger.getLogger(Conf_Sair_Sem_Salvar_Ent_Cont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
     
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Conf_Sair_Sem_Salvar_Ent_Cont dialog = new Conf_Sair_Sem_Salvar_Ent_Cont(ObjEntrada, true);
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
    private javax.swing.JButton JB_Nao;
    private javax.swing.JButton JB_Sim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}

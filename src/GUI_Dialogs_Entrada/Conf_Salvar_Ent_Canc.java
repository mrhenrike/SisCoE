package GUI_Dialogs_Entrada;

// @author Márison Tamiarana

import GUI_Frames.Tela_Cancelar_Entrada_Produto;


public class Conf_Salvar_Ent_Canc extends javax.swing.JDialog {
    
    public static Tela_Cancelar_Entrada_Produto ObjEntrada;
    
    
    public Conf_Salvar_Ent_Canc(Tela_Cancelar_Entrada_Produto parent, boolean modal) {
        this.ObjEntrada = parent;
        this.setModal(modal);
        initComponents();
        setResizable(false);
        setSize(420,130);
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
        setTitle("Confirmação Ao Salvar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Deseja cancelar a essa entrada?");

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Save_all 75x75.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JB_Sim, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JB_Nao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jLabel2)
                    .addContainerGap(358, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JB_Nao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_Sim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2)
                    .addContainerGap(57, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_NaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_NaoActionPerformed
        dispose();
        ObjEntrada.Mostrar_Dados_Nao_Salvos();        
    }//GEN-LAST:event_JB_NaoActionPerformed

    private void JB_SimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_SimActionPerformed
       dispose();
       ObjEntrada.Conf_Inserir_Entrada();
       
       
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
            java.util.logging.Logger.getLogger(Conf_Salvar_Ent_Canc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
   

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Conf_Salvar_Ent_Canc dialog = new Conf_Salvar_Ent_Canc(ObjEntrada, true);
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

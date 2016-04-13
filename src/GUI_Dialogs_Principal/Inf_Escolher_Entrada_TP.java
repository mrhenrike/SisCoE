package GUI_Dialogs_Principal;

// @author Márison Tamiarana

import GUI_Frames.Tela_Entrada_Produto;
import GUI_Frames.Tela_Entrada_Produto_Cont;
import GUI_Frames.Tela_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;


public class Inf_Escolher_Entrada_TP extends javax.swing.JDialog {
    
    public static Tela_Principal ObjTP;
    
    
    public Inf_Escolher_Entrada_TP(Tela_Principal parent, boolean modal) {
        this.ObjTP = parent;
        this.setModal(modal);
        initComponents();
        setResizable(false);
        setSize(550,130);
        setLocationRelativeTo(ObjTP);
        Setar_Atalho_BT();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BT_Sair = new javax.swing.JButton();
        BT_Nova = new javax.swing.JButton();
        BT_Continuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipo De Entrada");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Escolha o tipo de entrada que deseja realizar!");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Information_75X75.png"))); // NOI18N

        BT_Sair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Log Out_24x24.png"))); // NOI18N
        BT_Sair.setText("Sair");
        BT_Sair.setToolTipText("Clique Aqui Para Sair Ou Pressino A Tecla ESC");
        BT_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SairActionPerformed(evt);
            }
        });

        BT_Nova.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Nova.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Add Prod 24x24.png"))); // NOI18N
        BT_Nova.setText("Nova");
        BT_Nova.setToolTipText("Clique Aqui Para Efetuar Uma Nova Entrada Ou Pressine N");
        BT_Nova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_NovaActionPerformed(evt);
            }
        });

        BT_Continuar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Continuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Edit 22 x 22.png"))); // NOI18N
        BT_Continuar.setText("Continuar Entrada");
        BT_Continuar.setToolTipText("Clique Aqui Para Adicionar Novos Itens Em Uma Entrada Existente Ou Pressione C");
        BT_Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BT_Nova)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Continuar)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jLabel2)
                    .addContainerGap(499, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BT_Nova, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BT_Continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_NovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_NovaActionPerformed
        new Tela_Entrada_Produto().Open_Tela();
        dispose();
    }//GEN-LAST:event_BT_NovaActionPerformed

    private void BT_ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ContinuarActionPerformed
        new Tela_Entrada_Produto_Cont().Open_Tela();
        dispose();
    }//GEN-LAST:event_BT_ContinuarActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_N, 0),"Nova");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
        
        InputMap inputMap3 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0),"Continuar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);
        //método para executar
         this.getRootPane().getActionMap().put("Nova", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Nova.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Continuar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Continuar.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Sair.doClick();
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inf_Escolher_Entrada_TP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }      
   

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Inf_Escolher_Entrada_TP dialog = new Inf_Escolher_Entrada_TP(ObjTP, true);
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
    private javax.swing.JButton BT_Continuar;
    private javax.swing.JButton BT_Nova;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}

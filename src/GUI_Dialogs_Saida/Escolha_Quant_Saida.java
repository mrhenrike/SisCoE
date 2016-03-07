package GUI_Dialogs_Saida;

// @author Márison Tamiarana

import Classes.Modelo_Saida_Produto;
import Conexao.Controle_Saida_Produto;
import GUI_Frames.Tela_Saida_Produto;
import Metodos.Formatacao;


public class Escolha_Quant_Saida extends javax.swing.JDialog {
    
    public static Tela_Saida_Produto ObjSaida;
    public static Conf_Alterar_Quant_Lote_Saida ObjAlterarQuant;
    public static Escolha_Lote_Saida ObjLote;
    Modelo_Saida_Produto ObjModeloSaida = new Modelo_Saida_Produto();
    Controle_Saida_Produto ObjControlSaida = new Controle_Saida_Produto();
    Formatacao ObjFormat = new Formatacao();
    boolean flag = false;
                 
    public Escolha_Quant_Saida(Tela_Saida_Produto parent, boolean modal) {
        this.ObjSaida = parent;
        this.setModal(modal);
        initComponents();
        setResizable(false);
        setSize(270,200);
        setLocationRelativeTo(ObjSaida);
        JTF_Quantidade.setDocument(ObjFormat.new Format_Apenas_Numero(10));
        ObjControlSaida.Estoque(ObjModeloSaida, ObjSaida.Id_Prod);
        JL_Quant.setText(String.valueOf((ObjModeloSaida.getQuantidade())-ObjSaida.QuantidadeSemLote));
        JL_Un.setText(ObjSaida.unidade);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JB_Ok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTF_Quantidade = new javax.swing.JTextField();
        JL_Quant = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JL_Un = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informação!");
        setMinimumSize(new java.awt.Dimension(270, 195));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selecione a quantidade!");

        JB_Ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Ok.png"))); // NOI18N
        JB_Ok.setMnemonic('o');
        JB_Ok.setToolTipText("Ok (Alt+O)");
        JB_Ok.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Ok Press.png"))); // NOI18N
        JB_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_OkActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Quantidade*:");

        JTF_Quantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Quantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTF_Quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_QuantidadeActionPerformed(evt);
            }
        });

        JL_Quant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Quant.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Quantidade disponivel:");

        JL_Un.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Un.setText("UN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JB_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JL_Quant, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(20, 20, 20)
                                        .addComponent(JTF_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(JL_Un, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jLabel2)
                    .addContainerGap(222, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JL_Quant)
                    .addComponent(JL_Un))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTF_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JB_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2)
                    .addContainerGap(136, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(286, 217));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JB_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_OkActionPerformed
        flag = true;
        Testar_Campos();
              
    }//GEN-LAST:event_JB_OkActionPerformed

    private void JTF_QuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_QuantidadeActionPerformed
        JB_Ok.requestFocus();
    }//GEN-LAST:event_JTF_QuantidadeActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(flag == false){
            ObjSaida.Limpar_Produto();
        }
    }//GEN-LAST:event_formWindowClosed

     public void Adicionar_Quantidade(){
        try {
                double Quant = (Double.parseDouble(JTF_Quantidade.getText()));
                ObjSaida.Setar_Campo_Quant(Quant);
                dispose();
            } catch (Exception ex) {
        }
    }
     
    public void Testar_Campos(){
        if(!JTF_Quantidade.getText().equalsIgnoreCase("")){
            double QuantSolicitada = (Double.parseDouble(JTF_Quantidade.getText()));
            if(QuantSolicitada<1){
                ObjSaida.Mostrar_Quantidade_Invalida();
            }else{
                if(QuantSolicitada>Double.valueOf(JL_Quant.getText())){
                    ObjSaida.Mostrar_Quantidade_Maior();
                }else{
                    ObjSaida.Verifica_Se_Existe_Na_Lista(ObjSaida.Id_Prod);
                        if(ObjSaida.Controla_Prod == true){
                            ObjSaida.Controla_Prod=false;
                            ObjSaida.Mostrar_Conf_Alterar_Quantidade();
                            dispose(); }
                        else{
                             Adicionar_Quantidade();
                            }
                }
            }
            
        }else{
            ObjSaida.Mostrar_Preencher_Campos();
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Escolha_Quant_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Escolha_Quant_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Escolha_Quant_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Escolha_Quant_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
       

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Escolha_Quant_Saida dialog = new Escolha_Quant_Saida((Tela_Saida_Produto) new javax.swing.JInternalFrame(), true);
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
    private javax.swing.JLabel JL_Quant;
    private javax.swing.JLabel JL_Un;
    private javax.swing.JTextField JTF_Quantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}

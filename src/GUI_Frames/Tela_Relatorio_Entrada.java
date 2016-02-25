package GUI_Frames;

// @author Márison Tamiarana

import Conexao.Controle_Relatorio_Entradas;
import GUI_Dialogs_Relatorios.Inf_Data_Final_Inferior_Relat_Ent;
import GUI_Dialogs_Relatorios.Inf_Preencher_Campos_Relat_Ent_Prod;
import GUI_Dialogs_Relatorios.Inf_Preencher_Datas_Relat_Ent;
import GUI_Dialogs_Relatorios.Inf_Preencher_N_Entrada_Relat_Ent;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Tela_Relatorio_Entrada extends javax.swing.JInternalFrame {
    
    private static Tela_Relatorio_Entrada Obj;
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Relatorio_Entrada();
            Tela_Principal.getPainel().add(Obj);
            Obj.setVisible(true);
            Obj.setPosicao();            
        }
        try {  
            if(Obj.isIcon()) // se for um icon    
               Obj.setIcon(false); // tira desse estado    
            else // senão (não está iconizada)    
               Obj.toFront(); // trás para frente das outras    
         } catch (PropertyVetoException e) {}  
    }
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    //instancia dos objetos
    Controle_Relatorio_Entradas ObjRelatEntrada = new Controle_Relatorio_Entradas();
    
    Tela_Principal ObjTP = new Tela_Principal();
    boolean DataMenor=false;
    
    private static Inf_Data_Final_Inferior_Relat_Ent ObjDataInferior;
    private static Inf_Preencher_Campos_Relat_Ent_Prod ObjPreencherCampos;
    private static Inf_Preencher_N_Entrada_Relat_Ent ObjPreencherEntrada;
    private static Inf_Preencher_Datas_Relat_Ent ObjPreencherDatas;
    
      
    public Tela_Relatorio_Entrada() {
        initComponents();
        BT_Consultar.setEnabled(false);
        JD_Final.setEnabled(false);
        JD_Inicial.setEnabled(false);
        JTF_Num_Entrada.setEnabled(false);
        Preencher_CB_Pesquisa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JD_Inicial = new com.toedter.calendar.JDateChooser();
        JD_Final = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JCB_Tipo_Pesquisa = new javax.swing.JComboBox();
        BT_Consultar = new javax.swing.JButton();
        BT_Sair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JTF_Num_Entrada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Relatório De Entrada");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Relatorio - Entrada 24x24.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Tipo De Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JD_Inicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JD_Final.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("De:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Até:");

        JCB_Tipo_Pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Tipo_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_Tipo_PesquisaActionPerformed(evt);
            }
        });

        BT_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar.png"))); // NOI18N
        BT_Consultar.setMnemonic('n');
        BT_Consultar.setToolTipText("Clique Para Consultar Ou Pressione Alt + N");
        BT_Consultar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar Press.png"))); // NOI18N
        BT_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ConsultarActionPerformed(evt);
            }
        });

        BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sair.png"))); // NOI18N
        BT_Sair.setMnemonic('r');
        BT_Sair.setToolTipText("Clique Para Sair Ou Pressione Alt + R");
        BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sair press.png"))); // NOI18N
        BT_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SairActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nº Entrada:");

        JTF_Num_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tipo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BT_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JTF_Num_Entrada)
                            .addComponent(JCB_Tipo_Pesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JD_Final, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(JD_Inicial, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCB_Tipo_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(JD_Inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JD_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTF_Num_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Consultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BT_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConsultarActionPerformed
       Testar_Campos();
    }//GEN-LAST:event_BT_ConsultarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void JCB_Tipo_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_Tipo_PesquisaActionPerformed
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==0){
            BT_Consultar.setEnabled(false);
            JD_Final.setEnabled(false);
            JD_Inicial.setEnabled(false);
            JD_Final.setDate(null);
            JD_Inicial.setDate(null);
            JTF_Num_Entrada.setEnabled(false);
            JTF_Num_Entrada.setText("");
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==1){
            BT_Consultar.setEnabled(!false);
            JD_Final.setEnabled(false);
            JD_Inicial.setEnabled(false);
            JD_Final.setDate(null);
            JD_Inicial.setDate(null);
            JTF_Num_Entrada.setEnabled(false);
            JTF_Num_Entrada.setText("");
         }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==2){
            BT_Consultar.setEnabled(!false);
            JD_Final.setEnabled(false);
            JD_Inicial.setEnabled(false);
            JD_Final.setDate(null);
            JD_Inicial.setDate(null);
            JTF_Num_Entrada.setEnabled(false);
            JTF_Num_Entrada.setText("");
         }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==3){
            BT_Consultar.setEnabled(!false);
            JD_Final.setEnabled(!false);
            JD_Inicial.setEnabled(!false);
            JD_Final.setDate(null);
            JD_Inicial.setDate(null);
            JTF_Num_Entrada.setEnabled(false);
            JTF_Num_Entrada.setText("");
         }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==4){
            BT_Consultar.setEnabled(!false);
            JD_Final.setEnabled(false);
            JD_Inicial.setEnabled(false);
            JD_Final.setDate(null);
            JD_Inicial.setDate(null);
            JTF_Num_Entrada.setEnabled(!false);
            JTF_Num_Entrada.setText("");
         }
    }//GEN-LAST:event_JCB_Tipo_PesquisaActionPerformed

    public void Verifica_Datas(){//verifica se a data inicial é inferior a inicial
        Date dt1 = JD_Inicial.getDate();
        Date dt2 = JD_Final.getDate();

        if (dt2.after(dt1)) {//dt2 superior a dt1
            
        } else {//dt2 igual ou inferior a dt1
            int diaAtual = Integer.parseInt(new SimpleDateFormat("dd").format(dt1));
            int diaValidade = Integer.parseInt(new SimpleDateFormat("dd").format(dt2));
            if (diaValidade == diaAtual) {
                //JOptionPane.showMessageDialog(rootPane, "Hoje");
            } else {
                DataMenor=true;
            }
        }  
    }
    public void Testar_Campos(){
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==1){
            ObjRelatEntrada.Relatorio_Entrada_Prod_Todos();
        }

        if(JCB_Tipo_Pesquisa.getSelectedIndex()==2){
            ObjRelatEntrada.Relatorio_Entrada_Prod_Ultimos_30_Dias();
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==3){
            if(JD_Inicial.getDate()==null || JD_Final.getDate()==null){
                //Mostrar_Preencher_Datas();
            }else{
                Verifica_Datas();
                if(DataMenor == true){
                    //Mostrar_Data_Inferior();
                    DataMenor = false;
                }else{
                    ObjRelatEntrada.Relatorio_Entrada_Periodo(JD_Inicial, JD_Final);
                }
            }
        }
         if(JCB_Tipo_Pesquisa.getSelectedIndex()==4){
             if(JTF_Num_Entrada.getText().equalsIgnoreCase("")){
                //Mostrar_Preencher_N_Entrada();
             }else{
                 ObjRelatEntrada.Relatorio_Entrada_N_Entrada(JTF_Num_Entrada);
            }
        }
    }
    public final void Preencher_CB_Pesquisa(){
        JCB_Tipo_Pesquisa.removeAllItems();
        JCB_Tipo_Pesquisa.addItem(" ");
        JCB_Tipo_Pesquisa.addItem("TODOS");
        JCB_Tipo_Pesquisa.addItem("ÚLTIMOS 30 DIAS");
        JCB_Tipo_Pesquisa.addItem("POR PERÍODO");
        JCB_Tipo_Pesquisa.addItem("NÚMERO DA ENTRADA");        
    }
    
//    public void Mostrar_Preencher_Campos(){
//        ObjPreencherCampos = new Inf_Preencher_Campos_Relat_Ent(this, true);
//        ObjPreencherCampos.setVisible(true);
//    }
//    public void Mostrar_Preencher_Datas(){
//        ObjPreencherDatas = new Inf_Preencher_Datas_Relat_Ent(this, true);
//        ObjPreencherDatas.setVisible(true);
//    }
//    public void Mostrar_Data_Inferior(){
//        ObjDataInferior = new Inf_Data_Final_Inferior_Relat_Ent(this, true);
//        ObjDataInferior.setVisible(true);
//    }
//    public void Mostrar_Preencher_N_Entrada(){
//        ObjPreencherEntrada = new Inf_Preencher_N_Entrada_Relat_Ent(this, true);
//        ObjPreencherEntrada.setVisible(true);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Consultar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JComboBox JCB_Tipo_Pesquisa;
    private com.toedter.calendar.JDateChooser JD_Final;
    private com.toedter.calendar.JDateChooser JD_Inicial;
    private javax.swing.JTextField JTF_Num_Entrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

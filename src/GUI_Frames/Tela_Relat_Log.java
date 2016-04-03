package GUI_Frames;

// @Márison Tamiarana

import Classes.Modelo_Curso;
import Conexao.Controle_Curso;
import Conexao.Controle_Log;
import Conexao.Controle_Relatorio_Log;
import GUI_Dialogs_Relatorios.Inf_Data_Final_Inferior_Relat_Log;
import GUI_Dialogs_Relatorios.Inf_Log_Nao_Encontrado_Relat_Log;
import GUI_Dialogs_Relatorios.Inf_Preencher_Campos_Relat_Log;
import GUI_Dialogs_Relatorios.Inf_Preencher_Datas_Relat_Log;
import static GUI_Frames.Tela_Principal.CodLogado;
import Metodos.Formatacao;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;


public class Tela_Relat_Log extends javax.swing.JInternalFrame {
    
    public static Tela_Relat_Log Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Relat_Log();
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
    
    Modelo_Curso ObjModCurso = new Modelo_Curso();
    Controle_Curso ObjControleCurso = new Controle_Curso();
    Controle_Log ObjControleLog = new Controle_Log();
    Formatacao ObjFormat = new Formatacao();
    
    boolean DataMenor;//comparar datas
    
    private static Inf_Preencher_Campos_Relat_Log DLPreencherCampos;
    private static Inf_Log_Nao_Encontrado_Relat_Log DLLogNaoEncontrado;
    private static Inf_Data_Final_Inferior_Relat_Log DLDataFinalInferior;
    private static Inf_Preencher_Datas_Relat_Log DLPreencherDatas;

    public Tela_Relat_Log() {
        initComponents();
        JTF_Filtro.setDocument(ObjFormat.new Format_Geral(50));
        JTF_Filtro.setEnabled(false);
        Preencher_CB_Tipo();
        Desabilita_Periodo();
        Setar_Atalho_BT();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JCB_Tipo_Pesquisa = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        JTF_Filtro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BT_Sair = new javax.swing.JButton();
        BT_Consultar = new javax.swing.JButton();
        JL_Info = new javax.swing.JLabel();
        JL_Periodo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JD_Inicial = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        JD_Final = new com.toedter.calendar.JDateChooser();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Relatório De Log");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Log 24x24.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JCB_Tipo_Pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Tipo_Pesquisa.setToolTipText("Selecione A Categoria Que Deseja Consultar");
        JCB_Tipo_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_Tipo_PesquisaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tipo*:");

        JTF_Filtro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Filtro:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_Filtro)
                    .addComponent(JCB_Tipo_Pesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCB_Tipo_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sair.png"))); // NOI18N
        BT_Sair.setMnemonic('r');
        BT_Sair.setToolTipText("Clique Para Sair Ou Pressione Alt + R");
        BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sair press.png"))); // NOI18N
        BT_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SairActionPerformed(evt);
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

        JL_Info.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Info.setText("Esc - Sair | F2 - Consultar");

        JL_Periodo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Período", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("De:");

        JD_Inicial.setToolTipText("Selecione A Data Inicial");
        JD_Inicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Até:");

        JD_Final.setToolTipText("Selecione A Data Final");
        JD_Final.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JL_PeriodoLayout = new javax.swing.GroupLayout(JL_Periodo);
        JL_Periodo.setLayout(JL_PeriodoLayout);
        JL_PeriodoLayout.setHorizontalGroup(
            JL_PeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JL_PeriodoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(JD_Inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JD_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        JL_PeriodoLayout.setVerticalGroup(
            JL_PeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JL_PeriodoLayout.createSequentialGroup()
                .addGroup(JL_PeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JD_Inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(JD_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BT_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JL_Info))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JL_Periodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_Periodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_Info)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BT_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BT_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConsultarActionPerformed
        Testar_Campos();
    }//GEN-LAST:event_BT_ConsultarActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JCB_Tipo_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_Tipo_PesquisaActionPerformed
       if(JCB_Tipo_Pesquisa.getSelectedIndex()<=0){
           Desabilita_Periodo();
           BT_Consultar.setEnabled(false);
           JTF_Filtro.setEnabled(false);
       }
       if(JCB_Tipo_Pesquisa.getSelectedIndex()==1){
           Desabilita_Periodo();
           BT_Consultar.setEnabled(true);
           JTF_Filtro.setEnabled(true);
       }
       if(JCB_Tipo_Pesquisa.getSelectedIndex()==2){
           Habilita_Periodo();
           BT_Consultar.setEnabled(true);
           JTF_Filtro.setEnabled(true);
       }
      
    }//GEN-LAST:event_JCB_Tipo_PesquisaActionPerformed

    final void Preencher_CB_Tipo(){
        JCB_Tipo_Pesquisa.removeAllItems();
        JCB_Tipo_Pesquisa.addItem("");
        JCB_Tipo_Pesquisa.addItem("HOJE");
        JCB_Tipo_Pesquisa.addItem("PERÍODO");
    }
    void Habilita_Periodo(){
        jLabel1.setEnabled(true);
        jLabel2.setEnabled(true);
        JL_Periodo.setEnabled(true);
        JD_Final.setEnabled(true);
        JD_Inicial.setEnabled(true);
        JD_Final.setDate(null);
        JD_Inicial.setDate(null);
    }
    final void Desabilita_Periodo(){
        jLabel1.setEnabled(!true);
        jLabel2.setEnabled(!true);
        JL_Periodo.setEnabled(!true);
        JD_Final.setEnabled(!true);
        JD_Inicial.setEnabled(!true);
        JD_Final.setDate(null);
        JD_Inicial.setDate(null);
    }
    public void Verifica_Datas(){//verifica se a data inicial é inferior a inicial
        long dt1 = JD_Inicial.getDate().getTime();
        long dt2 = JD_Final.getDate().getTime();
        if (dt2==dt1) {
            DataMenor=!true;
        } else {    
            if (dt2 > dt1) {
                DataMenor=!true;
            } else {
                DataMenor=true;
            }
        }  
    }
    
    void Testar_Campos(){
        String log;
        if(JCB_Tipo_Pesquisa.getSelectedIndex()<=0){
            BT_Consultar.setEnabled(false);
            Mostrar_Preencher_Campos();
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==1){            
            String hoje = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
            String hoje2 = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));
            new Controle_Relatorio_Log().Relatorio_Log_Hoje(hoje, JTF_Filtro);
            if(JTF_Filtro.getText().equalsIgnoreCase("")){
                log = "Registro de log referente a hoje - data: "+hoje2;
            }else{
                log = "Registro de log com filtro '"+JTF_Filtro.getText()+"' referente a hoje - data: "+hoje2;
            }
            new Controle_Log().Registrar_Log("Gerou o relatório de " + log, CodLogado);
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==2){
            BT_Consultar.setEnabled(true);
            if(JD_Inicial.getDate()==null || JD_Final.getDate()==null){
                    Mostrar_Preencher_Data();
            }else{
                Verifica_Datas();
                if (DataMenor == true) {
                    Mostrar_Data_Inferior();
                    DataMenor = false;
                } else {
                    try {
                        ObjControleLog.Consulta_Log_Intervalo(JD_Inicial, JD_Final);
                        if (ObjControleLog.controla_log == true) {                            
                            String di = new SimpleDateFormat("yyyy-MM-dd").format(JD_Inicial.getDate());
                            String df = new SimpleDateFormat("yyyy-MM-dd").format(JD_Final.getDate());
                            String dti = new SimpleDateFormat("dd/MM/yyyy").format(JD_Inicial.getDate());
                            String dtf = new SimpleDateFormat("dd/MM/yyyy").format(JD_Final.getDate());
                            ObjControleLog.controla_log = false;
                            new Controle_Relatorio_Log().Relatorio_Log_Periodo(di, df, dti, dtf, JTF_Filtro);
                            //log
                            if (JTF_Filtro.getText().equalsIgnoreCase("")) {
                                log = "Registro de log referente ao período de "+dti+" até "+dtf;
                            } else {
                                log = "Registro de log com filtro '"+JTF_Filtro.getText()+"' referente ao período de "+dti+" até "+dtf;
                            }                            
                            new Controle_Log().Registrar_Log("Gerou o relatório de " + log, CodLogado);
                        } else {
                            Mostrar_Log_Nao_Encontrado();
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        }

    }
    
    public void Mostrar_Preencher_Campos(){
        DLPreencherCampos = new Inf_Preencher_Campos_Relat_Log(this, true);
        DLPreencherCampos.setVisible(true);
    }
    void Mostrar_Data_Inferior(){
        DLDataFinalInferior = new Inf_Data_Final_Inferior_Relat_Log(this, true);
        DLDataFinalInferior.setVisible(true);
    }
    void Mostrar_Log_Nao_Encontrado(){
        DLLogNaoEncontrado = new Inf_Log_Nao_Encontrado_Relat_Log(this, true);
        DLLogNaoEncontrado.setVisible(true);
    }
    void Mostrar_Preencher_Data(){
        DLPreencherDatas = new Inf_Preencher_Datas_Relat_Log(this, true);
        DLPreencherDatas.setVisible(true);
    }
    
     public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        //metodo para pegar a tecla pressionada
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0),"Procurar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
                
        this.getRootPane().getActionMap().put("Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Sair.doClick();
        }
        });
                        
        this.getRootPane().getActionMap().put("Procurar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Consultar.doClick();
        }
        });
    }
     
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Consultar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JComboBox JCB_Tipo_Pesquisa;
    private com.toedter.calendar.JDateChooser JD_Final;
    private com.toedter.calendar.JDateChooser JD_Inicial;
    private javax.swing.JLabel JL_Info;
    private javax.swing.JPanel JL_Periodo;
    private javax.swing.JTextField JTF_Filtro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

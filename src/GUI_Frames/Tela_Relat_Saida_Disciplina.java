package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Disciplina;
import Conexao.Controle_Curso;
import Conexao.Controle_Disciplina;
import Conexao.Controle_Log;
import Conexao.Controle_Relatorio_Saidas;
import Conexao.Controle_Saida_Produto;
import GUI_Dialogs_Relatorios.Inf_Data_Final_Inferior_Relat_Saida_Disciplina;
import GUI_Dialogs_Relatorios.Inf_Preencher_Datas_Relat_Saida_Disciplina;
import GUI_Dialogs_Relatorios.Inf_Saida_Nao_Encontrada_Relat_Saida_Disciplina;
import static GUI_Frames.Tela_Principal.CodLogado;
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


public class Tela_Relat_Saida_Disciplina extends javax.swing.JInternalFrame {
    
     public static Tela_Relat_Saida_Disciplina Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Relat_Saida_Disciplina();
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
    
    Modelo_Disciplina ObjModDisciplina = new Modelo_Disciplina();
    Controle_Relatorio_Saidas ObjRelatSaida = new Controle_Relatorio_Saidas();
    Controle_Saida_Produto ObjControleSaida = new Controle_Saida_Produto();
    Tela_Principal ObjTP = new Tela_Principal();
    
    private static Tela_Principal TP;
    
    boolean DataMenor=false;
    
    private static Inf_Preencher_Datas_Relat_Saida_Disciplina ObjPreencherDatas;
    private static Inf_Data_Final_Inferior_Relat_Saida_Disciplina ObjDataInferior;
    private static Inf_Saida_Nao_Encontrada_Relat_Saida_Disciplina DLSaidaNaoEncontrada;
    
    String sql_semestre = " ";
    String ano;
    
    public Tela_Relat_Saida_Disciplina() {
        initComponents();
        JCB_Disciplina.setEnabled(false);
        Preencher_CB_Tipo();
        Preencher_CB_Curso();
        Preencher_CB_Semestre();        
        Setar_Atalho_BT();
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JD_Inicial = new com.toedter.calendar.JDateChooser();
        JD_Final = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        JCB_Tipo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        JCB_Curso = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        JY_Ano = new com.toedter.calendar.JYearChooser();
        jLabel12 = new javax.swing.JLabel();
        JCB_Semestre = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        JCB_Disciplina = new javax.swing.JComboBox();
        JL_Info = new javax.swing.JLabel();
        BT_Relatorio = new javax.swing.JButton();
        BT_Sair = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("20 - Saída Por Disciplina");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Relatório - Saida 24x24.png"))); // NOI18N
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
        JD_Final.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JD_FinalFocusLost(evt);
            }
        });
        JD_Final.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JD_FinalMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("De:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Até:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tipo:");

        JCB_Tipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Curso:");

        JCB_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_CursoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Ano:");

        JY_Ano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Semestre:");

        JCB_Semestre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_SemestreActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Disciplina:");

        JCB_Disciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Disciplina.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JCB_DisciplinaFocusGained(evt);
            }
        });
        JCB_Disciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCB_DisciplinaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCB_Curso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCB_Tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JY_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JCB_Semestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(JCB_Disciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JD_Inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JD_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCB_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JCB_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(JY_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(JCB_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JCB_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(JD_Inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JD_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JL_Info.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Info.setText("Esc - Sair | F2 - Consultar");

        BT_Relatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar.png"))); // NOI18N
        BT_Relatorio.setMnemonic('n');
        BT_Relatorio.setToolTipText("Clique Para Consultar Ou Pressione Alt + N");
        BT_Relatorio.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar Press.png"))); // NOI18N
        BT_Relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_RelatorioActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BT_Relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JL_Info)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_Info)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BT_RelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_RelatorioActionPerformed
        Testar_Campos();
    }//GEN-LAST:event_BT_RelatorioActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JD_FinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JD_FinalFocusLost
        BT_Relatorio.requestFocus();
    }//GEN-LAST:event_JD_FinalFocusLost

    private void JD_FinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JD_FinalMouseClicked
        BT_Relatorio.requestFocus();
    }//GEN-LAST:event_JD_FinalMouseClicked

    private void JCB_SemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_SemestreActionPerformed
        if(JCB_Semestre.getSelectedIndex()==0){
            sql_semestre = " ";
            Preencher_CB_Disciplinas();
            JCB_Disciplina.setSelectedIndex(0);
            JCB_Disciplina.setEnabled(!true);
            ano = String.valueOf(JY_Ano.getValue());
            new Controle_Disciplina().Preencher_CB_Disciplina(JCB_Disciplina, sql_semestre, JCB_Curso.getSelectedItem().toString());
        }else{
            sql_semestre = " and semestre = "+JCB_Semestre.getSelectedItem().toString().trim()+" ";
            Preencher_CB_Disciplinas();
            ano = String.valueOf(JY_Ano.getValue());
            new Controle_Disciplina().Preencher_CB_Disciplina(JCB_Disciplina, sql_semestre, JCB_Curso.getSelectedItem().toString());
            JCB_Disciplina.setSelectedIndex(0);
            JCB_Disciplina.setEnabled(true);
        }        
    }//GEN-LAST:event_JCB_SemestreActionPerformed

    private void JCB_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_CursoActionPerformed
        
    }//GEN-LAST:event_JCB_CursoActionPerformed

    private void JCB_DisciplinaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCB_DisciplinaFocusGained
        Preencher_CB_Disciplinas();
        ano = String.valueOf(JY_Ano.getValue());
        new Controle_Disciplina().Preencher_CB_Disciplina(JCB_Disciplina, sql_semestre, JCB_Curso.getSelectedItem().toString());
    }//GEN-LAST:event_JCB_DisciplinaFocusGained

    private void JCB_DisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCB_DisciplinaMouseClicked
        Preencher_CB_Disciplinas();
        ano = String.valueOf(JY_Ano.getValue());
        new Controle_Disciplina().Preencher_CB_Disciplina(JCB_Disciplina, sql_semestre, JCB_Curso.getSelectedItem().toString());
    }//GEN-LAST:event_JCB_DisciplinaMouseClicked

    final void Preencher_CB_Tipo(){
        JCB_Tipo.addItem("ANALÍTICO");
        JCB_Tipo.addItem("SINTÉTICO");        
    }
    
    final void Preencher_CB_Curso(){        
        JCB_Curso.removeAllItems();
        JCB_Curso.addItem("TODOS");
        new Controle_Curso().Preencher_CB_Curso_Sem_Remove(JCB_Curso);
    }
    
    final void Preencher_CB_Semestre(){
        JCB_Semestre.removeAllItems();
        JCB_Semestre.addItem("TODOS");
        for(int i=1;i<=12;i++){
            JCB_Semestre.addItem(i);
        }
    }
    final void Preencher_CB_Disciplinas(){
        JCB_Disciplina.removeAllItems();
        JCB_Disciplina.addItem("TODAS");
    }
    
    
    void Id_Disciplina(){
        if(JCB_Semestre.getSelectedIndex()==0){
            new Controle_Disciplina().Procura_Id_Disciplina(ObjModDisciplina, JCB_Disciplina, "");
        }else{
            new Controle_Disciplina().Procura_Id_Disciplina(ObjModDisciplina, JCB_Disciplina, JCB_Semestre);
        }
    }
    
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
        if(JD_Inicial.getDate()==null || JD_Final.getDate()==null){
            Mostrar_Preencher_Datas();
        }else{
            Verifica_Datas();
            if(DataMenor == true){
                Mostrar_Data_Inferior();
                DataMenor = false;
            }else{
                if(JCB_Tipo.getSelectedIndex()==0){//analitico
                    ObjControleSaida.Consulta_Saida_Intervalo(JD_Inicial, JD_Final);
                    if(ObjControleSaida.Controle_Saida == true){
                        ObjControleSaida.Controle_Saida = false;
                        if(JCB_Curso.getSelectedIndex()==0){//todas cursos
                            ano = String.valueOf(JY_Ano.getValue());
                            new Controle_Relatorio_Saidas().Relatorio_Saida_Disciplina_Analitico_Periodo(sql_semestre, ano , JD_Inicial, JD_Final);
                            String dti = new SimpleDateFormat("dd-MM-yyyy").format(JD_Inicial.getDate());
                            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(JD_Final.getDate());
                            new Controle_Log().Registrar_Log("Gerou o relatório de saídas Analítico por disciplinas - todas de "+ano+" no período de "+dti+" até "+dtf, CodLogado);
                        }else{//curso selecionado
                            if(JCB_Disciplina.getSelectedIndex()==0){//todas disciplina
                                ano = String.valueOf(JY_Ano.getValue());
                                String curso = JCB_Curso.getSelectedItem().toString().trim();
                                new Controle_Relatorio_Saidas().Relatorio_Saida_Disciplina_Todas_Curso_Selecionado_Analitico_Periodo(sql_semestre, ano, JD_Inicial, JD_Final, curso);
                                String dti = new SimpleDateFormat("dd-MM-yyyy").format(JD_Inicial.getDate());
                                String dtf = new SimpleDateFormat("dd-MM-yyyy").format(JD_Final.getDate());
                                new Controle_Log().Registrar_Log("Gerou o relatório de saídas Analítico por Disciplina - todas de "+ano+" - curso: '"+curso+"' no período de "+dti+" até "+dtf, CodLogado);
                            }else{//disciplina selecionada
                                ano = String.valueOf(JY_Ano.getValue());
                                String curso = JCB_Curso.getSelectedItem().toString().trim();
                                Id_Disciplina();//consulta o id da disciplina
                                new Controle_Relatorio_Saidas().Relatorio_Saida_Disciplina_Selecionada_Curso_Selecionado_Analitico_Periodo(sql_semestre, ano, JD_Inicial, JD_Final, curso,String.valueOf(ObjModDisciplina.getId_disciplina()));
                                String dti = new SimpleDateFormat("dd-MM-yyyy").format(JD_Inicial.getDate());
                                String dtf = new SimpleDateFormat("dd-MM-yyyy").format(JD_Final.getDate());
                                new Controle_Log().Registrar_Log("Gerou o relatório de saídas Analítico por disciplina - selecionada id: "+ObjModDisciplina.getId_disciplina()+" - '"+JCB_Disciplina.getSelectedItem().toString()+"' de "+ano+" - curso: '"+curso+"' no período de "+dti+" até "+dtf, CodLogado);
                            }
                        }
                    }else{
                         Mostrar_Entrada_Nao_Encontrada();
                    }
                }               
                if(JCB_Tipo.getSelectedIndex()==1){//sintetico
                    ObjControleSaida.Consulta_Saida_Intervalo(JD_Inicial, JD_Final);
                    if(ObjControleSaida.Controle_Saida == true){
                        ObjControleSaida.Controle_Saida = false;
                        if(JCB_Curso.getSelectedIndex()==0){//todos cursos
                            ano = String.valueOf(JY_Ano.getValue());
                            new Controle_Relatorio_Saidas().Relatorio_Saida_Disciplina_Sintetico_Periodo(sql_semestre, ano , JD_Inicial, JD_Final);
                            String dti = new SimpleDateFormat("dd-MM-yyyy").format(JD_Inicial.getDate());
                            String dtf = new SimpleDateFormat("dd-MM-yyyy").format(JD_Final.getDate());
                            new Controle_Log().Registrar_Log("Gerou o relatório de saídas sintético por Disciplina todas de "+ano+" no período de "+dti+" até "+dtf, CodLogado);
                        }else{//curso selecionado
                            if(JCB_Disciplina.getSelectedIndex()==0){//todas disciplinas
                                ano = String.valueOf(JY_Ano.getValue());
                                String curso = JCB_Curso.getSelectedItem().toString().trim();
                                new Controle_Relatorio_Saidas().Relatorio_Saida_Disciplina_Todas_Curso_Selecionado_Sintetico_Periodo(sql_semestre, ano, JD_Inicial, JD_Final, curso);
                                String dti = new SimpleDateFormat("dd-MM-yyyy").format(JD_Inicial.getDate());
                                String dtf = new SimpleDateFormat("dd-MM-yyyy").format(JD_Final.getDate());
                                new Controle_Log().Registrar_Log("Gerou o relatório de saídas sintético por Disciplina todas de "+ano+" - curso: '"+curso+"' no período de "+dti+" até "+dtf, CodLogado);
                            }else{//disciplina selecionada
                                ano = String.valueOf(JY_Ano.getValue());
                                String curso = JCB_Curso.getSelectedItem().toString().trim();
                                Id_Disciplina();
                                new Controle_Relatorio_Saidas().Relatorio_Saida_Disciplina_Selecionada_Curso_Selecionado_Sintetico_Periodo(sql_semestre, ano, JD_Inicial, JD_Final, curso,String.valueOf(ObjModDisciplina.getId_disciplina()));
                                String dti = new SimpleDateFormat("dd-MM-yyyy").format(JD_Inicial.getDate());
                                String dtf = new SimpleDateFormat("dd-MM-yyyy").format(JD_Final.getDate());
                                new Controle_Log().Registrar_Log("Gerou o relatório de saídas sintético por disciplina selecionada id: "+ObjModDisciplina.getId_disciplina()+" - '"+JCB_Disciplina.getSelectedItem().toString()+"' de "+ano+" - curso: '"+curso+"' no período de "+dti+" até "+dtf, CodLogado);
                            }
                        }
                    }else{
                        Mostrar_Entrada_Nao_Encontrada();
                    }
                }            
            }
        }
    }
    
    public void Mostrar_Preencher_Datas(){
        ObjPreencherDatas = new Inf_Preencher_Datas_Relat_Saida_Disciplina(this, true);
        ObjPreencherDatas.setVisible(true);
    }
    public void Mostrar_Data_Inferior(){
        ObjDataInferior = new Inf_Data_Final_Inferior_Relat_Saida_Disciplina(this, true);
        ObjDataInferior.setVisible(true);
    }
    void Mostrar_Entrada_Nao_Encontrada(){
        DLSaidaNaoEncontrada = new Inf_Saida_Nao_Encontrada_Relat_Saida_Disciplina(this, true);
        DLSaidaNaoEncontrada.setVisible(true);
    }
    
     
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        //metodo para pegar a tecla pressionada
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0),"Relatorio");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
        
        this.getRootPane().getActionMap().put("Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Sair.doClick();
        }
        });
        
        this.getRootPane().getActionMap().put("Relatorio", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Relatorio.doClick();
        }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Relatorio;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JComboBox JCB_Curso;
    private javax.swing.JComboBox JCB_Disciplina;
    private javax.swing.JComboBox JCB_Semestre;
    private javax.swing.JComboBox JCB_Tipo;
    private com.toedter.calendar.JDateChooser JD_Final;
    private com.toedter.calendar.JDateChooser JD_Inicial;
    private javax.swing.JLabel JL_Info;
    private com.toedter.calendar.JYearChooser JY_Ano;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

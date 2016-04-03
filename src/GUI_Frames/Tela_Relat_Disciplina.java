package GUI_Frames;

// @Márison Tamiarana

import Classes.Modelo_Curso;
import Conexao.Controle_Curso;
import Conexao.Controle_Log;
import Conexao.Controle_Relatorio_Curso_Turma_Disciplina;
import GUI_Dialogs_Relatorios.Inf_Preencher_Campos_Relat_Disciplina;
import static GUI_Frames.Tela_Principal.CodLogado;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;


public class Tela_Relat_Disciplina extends javax.swing.JInternalFrame {
    
    public static Tela_Relat_Disciplina Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Relat_Disciplina();
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
    
    private static Inf_Preencher_Campos_Relat_Disciplina ObjPreencherCampos;

    public Tela_Relat_Disciplina() {
        initComponents();
        Preencher_CB_Tipo();
        BT_Consultar.setEnabled(false);
        Setar_Atalho_BT();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JCB_Tipo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JCB_Curso = new javax.swing.JComboBox();
        BT_Sair = new javax.swing.JButton();
        BT_Consultar = new javax.swing.JButton();
        JL_Info = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Relatório De Disciplina");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Curso 24x24.png"))); // NOI18N
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

        JCB_Tipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Tipo.setToolTipText("Selecione A Categoria Que Deseja Consultar");
        JCB_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_TipoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tipo*:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Curso*:");

        JCB_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Curso.setToolTipText("Selecione A Categoria Que Deseja Consultar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCB_Tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JCB_Curso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCB_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(JCB_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BT_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(JL_Info)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_Info)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BT_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void JCB_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_TipoActionPerformed
       if(JCB_Tipo.getSelectedIndex()<=0){
           JCB_Curso.removeAllItems();
           BT_Consultar.setEnabled(false);
       }
       if(JCB_Tipo.getSelectedIndex()>=1){
           JCB_Curso.removeAllItems();
           JCB_Curso.addItem("");
           JCB_Curso.addItem("TODOS");
           new Controle_Curso().Preencher_CB_Curso_Sem_Remove(JCB_Curso);
           BT_Consultar.setEnabled(!false);
       }
      
    }//GEN-LAST:event_JCB_TipoActionPerformed

    final void Preencher_CB_Tipo(){
         JCB_Tipo.removeAllItems();
         JCB_Tipo.addItem("");
         JCB_Tipo.addItem("POR CURSO");
         JCB_Tipo.addItem("POR CURSO E SEMESTRE");
     }
    
    public void Testar_Campos(){
        String log=null;
        if(JCB_Tipo.getSelectedIndex()<=0 || JCB_Curso.getSelectedIndex()<=0){
            Mostrar_Preencher_Campos();
        }else{
            if((JCB_Tipo.getSelectedIndex()==1) && (JCB_Curso.getSelectedIndex()==1)){
                new Controle_Relatorio_Curso_Turma_Disciplina().Relatorio_Disciplina_Todas();
                log = "todas as disciplinas de todos cursos";
            }
            if((JCB_Tipo.getSelectedIndex()==1) && (JCB_Curso.getSelectedIndex()>1)){
                ObjControleCurso.Procura_Id_Curso(ObjModCurso, JCB_Curso);
                new Controle_Relatorio_Curso_Turma_Disciplina().Relatorio_Disciplina_Curso_Selecionado(ObjModCurso.getId_curso());
                log = "todas as disciplinas do curso de '"+JCB_Curso.getSelectedItem().toString().trim()+"'";
            }
            if((JCB_Tipo.getSelectedIndex()==2) && (JCB_Curso.getSelectedIndex()==1)){
                new Controle_Relatorio_Curso_Turma_Disciplina().Relatorio_Disciplina_Todas_Semestre();
                log = "todas as disciplinas de todos cursos por semestre";
            }
            if((JCB_Tipo.getSelectedIndex()==2) && (JCB_Curso.getSelectedIndex()>1)){
                ObjControleCurso.Procura_Id_Curso(ObjModCurso, JCB_Curso);
                new Controle_Relatorio_Curso_Turma_Disciplina().Relatorio_Disciplina_Curso_Selecionado_Semestre(ObjModCurso.getId_curso());
                log = "todas as disciplinas do curso de '"+JCB_Curso.getSelectedItem().toString().trim()+"' por semestre";
            }
            new Controle_Log().Registrar_Log("Gerou o relatório de " + log, CodLogado);
        }              
    } 
    
    public void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Relat_Disciplina(this, true);
        ObjPreencherCampos.setVisible(true);
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
    private javax.swing.JComboBox JCB_Curso;
    private javax.swing.JComboBox JCB_Tipo;
    private javax.swing.JLabel JL_Info;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

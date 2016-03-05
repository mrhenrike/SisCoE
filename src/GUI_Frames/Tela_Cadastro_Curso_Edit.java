package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Curso;
import Conexao.Controle_Curso;
import GUI_Dialogs_Curso_Turma.Conf_Sair_Sem_Salvar_Curso_Edit;
import GUI_Dialogs_Curso_Turma.Conf_Salvar_Curso_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Cadastro_Existente_Curso_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Dados_Nao_Salvos_Curso_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Dados_Salvos_Curso_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Preencher_Campos_Curso_Edit;
import Metodos.Formatacao;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;


public class Tela_Cadastro_Curso_Edit extends javax.swing.JInternalFrame {
    
    public static Tela_Cadastro_Curso_Edit Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Cadastro_Curso_Edit();
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
    Formatacao ObjFormat = new Formatacao();
    
    private static Inf_Cadastro_Existente_Curso_Edit ObjCadExiste;
    private static Inf_Dados_Salvos_Curso_Edit ObjSalvo;
    public static Inf_Dados_Nao_Salvos_Curso_Edit ObjNaoSalvo;
    private static Inf_Preencher_Campos_Curso_Edit ObjPreencherCampo;
    private static Conf_Salvar_Curso_Edit ObjSalvar;
    private static Conf_Sair_Sem_Salvar_Curso_Edit ObjSairSemSalvar;
    
   
    public Tela_Cadastro_Curso_Edit() {
        initComponents();
        JTF_Id.setEnabled(false);
        JTF_Curso.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Abrev.setDocument(ObjFormat.new Format_Geral(10));
        Setar_Atalho_BT();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BT_Cancelar = new javax.swing.JButton();
        BT_Salvar = new javax.swing.JButton();
        JP_Curso = new javax.swing.JPanel();
        JL_Curso = new javax.swing.JLabel();
        JL_Abrev = new javax.swing.JLabel();
        JTF_Curso = new javax.swing.JTextField();
        JTF_Abrev = new javax.swing.JTextField();
        JTF_Id = new javax.swing.JTextField();
        JL_Curso1 = new javax.swing.JLabel();
        JL_Curso2 = new javax.swing.JLabel();
        JCB_Situacao = new javax.swing.JComboBox();
        JL_Quant_Itens1 = new javax.swing.JLabel();
        JL_Campos = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setTitle("Alterar Curso");
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

        BT_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar.png"))); // NOI18N
        BT_Cancelar.setMnemonic('c');
        BT_Cancelar.setToolTipText("Clique Para Cancelar A Edição Ou Pressione Alt + C");
        BT_Cancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar Press.png"))); // NOI18N
        BT_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CancelarActionPerformed(evt);
            }
        });

        BT_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar.png"))); // NOI18N
        BT_Salvar.setMnemonic('s');
        BT_Salvar.setToolTipText("Clique Para Salvar Ou Pressione Alt + S");
        BT_Salvar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar Press.png"))); // NOI18N
        BT_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SalvarActionPerformed(evt);
            }
        });

        JP_Curso.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados Do Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JL_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Curso.setText("Curso*:");

        JL_Abrev.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Abrev.setText("Abreviatura*:");

        JTF_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Abrev.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JL_Curso1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Curso1.setText("Id*:");

        JL_Curso2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Curso2.setText("Situação*:");

        JCB_Situacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Situacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ATIVO", "INATIVO" }));

        javax.swing.GroupLayout JP_CursoLayout = new javax.swing.GroupLayout(JP_Curso);
        JP_Curso.setLayout(JP_CursoLayout);
        JP_CursoLayout.setHorizontalGroup(
            JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_Curso1)
                    .addComponent(JL_Curso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_CursoLayout.createSequentialGroup()
                        .addComponent(JTF_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JL_Abrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTF_Abrev, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JL_Curso2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCB_Situacao, 0, 129, Short.MAX_VALUE))
                    .addComponent(JTF_Curso))
                .addContainerGap())
        );
        JP_CursoLayout.setVerticalGroup(
            JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Curso)
                    .addComponent(JTF_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Abrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Curso2)
                    .addComponent(JCB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Abrev)
                    .addComponent(JL_Curso1)
                    .addComponent(JTF_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Cancelar | F10 - Salvar");

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_Curso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_Quant_Itens1)
                            .addComponent(JL_Campos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BT_Cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Quant_Itens1)
                        .addGap(18, 18, 18)
                        .addComponent(JL_Campos)))
                .addContainerGap())
        );

        setBounds(0, 0, 700, 225);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CancelarActionPerformed
        Sair_Sem_Salvar();
    }//GEN-LAST:event_BT_CancelarActionPerformed

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        Testar_Campos();
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj = null;
    }//GEN-LAST:event_formInternalFrameClosed

    public void Setar_Campos_Curso(Object id_curso){
        ObjControleCurso.Consulta_Curso(ObjModCurso, id_curso);
        JTF_Curso.setText(ObjModCurso.getNome_curso());
        JTF_Abrev.setText(ObjModCurso.getAbrev_curso());
        JTF_Id.setText(String.valueOf(ObjModCurso.getId_curso()));
        JCB_Situacao.setSelectedItem(ObjModCurso.getSituacao());
    }
    
    public void Preencher_Objetos(){
        ObjModCurso.setAbrev_curso(JTF_Abrev.getText().trim());
        ObjModCurso.setNome_curso(JTF_Curso.getText().trim());
        ObjModCurso.setSituacao(JCB_Situacao.getSelectedItem().toString().trim());
    }
    
    public void Testar_Campos(){
        if(JTF_Id.getText().equalsIgnoreCase("")||JTF_Curso.getText().equalsIgnoreCase("")
                ||JTF_Abrev.getText().equalsIgnoreCase("")|| JCB_Situacao.getSelectedItem().equals("")){
            Mostrar_Preencher_Campos();
        }
        if (JTF_Curso.getText().equalsIgnoreCase(ObjModCurso.getNome_curso())){
            Mostrar_Conf_Salvar();
        }else{
            ObjControleCurso.Testar_Existente(JTF_Curso);
            if(ObjControleCurso.Controle_Existente==true){
                Mostrar_Cadastro_Existente();
                ObjControleCurso.Controle_Existente = false;
            }else{
                Mostrar_Conf_Salvar();
            }
        }
    }
    
    public void Conf_Alterar(){
        Preencher_Objetos();
        ObjControleCurso.Alterar_Curso(ObjModCurso, JTF_Id.getText());
        if(ObjControleCurso.Confirma_Alterar==true){
            Mostrar_Dados_Salvos();
            dispose();
            Mostrar_Tela_Consulta();
            ObjControleCurso.Confirma_Alterar = false;
        }else{
            Mostrar_Dados_Nao_Salvos();
            Mostrar_Tela_Consulta();
            ObjControleCurso.Confirma_Alterar = false;
        }
    }
    
    void Sair_Sem_Salvar(){
        if(!JTF_Id.getText().equalsIgnoreCase("")||!JTF_Curso.getText().equalsIgnoreCase("")
                ||!JTF_Abrev.getText().equalsIgnoreCase("")|| !JCB_Situacao.getSelectedItem().equals("")){
            Mostrar_Sair_Sem_Salvar();
        }else{
            dispose();
            Mostrar_Tela_Consulta();
        }
    }
    public void Mostrar_Tela_Consulta(){
        Tela_Consulta_Curso_Turma obj = new Tela_Consulta_Curso_Turma();
        obj.Open_Tela();
    }
        
    
    //mostrar dialogs
    void Mostrar_Conf_Salvar(){
        ObjSalvar = new Conf_Salvar_Curso_Edit(this, true);
        ObjSalvar.setVisible(true);
    }
   void Mostrar_Sair_Sem_Salvar(){
       ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Curso_Edit(this, true);
       ObjSairSemSalvar.setVisible(true);
   }
   public void Mostrar_Dados_Salvos(){
       ObjSalvo = new Inf_Dados_Salvos_Curso_Edit(this, true);
       ObjSalvo.setVisible(true);
   }
   public void Mostrar_Dados_Nao_Salvos(){
       ObjNaoSalvo = new Inf_Dados_Nao_Salvos_Curso_Edit(this, true);
       ObjNaoSalvo.setVisible(true);
   }
   void Mostrar_Cadastro_Existente(){
       ObjCadExiste = new Inf_Cadastro_Existente_Curso_Edit(this, true);
       ObjCadExiste.setVisible(true);
   }
   void Mostrar_Preencher_Campos(){
       ObjPreencherCampo = new Inf_Preencher_Campos_Curso_Edit(this, true);
       ObjPreencherCampo.setVisible(true);
   }
   
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0),"Salvar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap4);
                
        //método para executar
         this.getRootPane().getActionMap().put("Salvar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Salvar.doClick();
        }
        });        
        this.getRootPane().getActionMap().put("Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Cancelar.doClick();
        }
        });               
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Cancelar;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JComboBox JCB_Situacao;
    private javax.swing.JLabel JL_Abrev;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Curso;
    private javax.swing.JLabel JL_Curso1;
    private javax.swing.JLabel JL_Curso2;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JPanel JP_Curso;
    private javax.swing.JTextField JTF_Abrev;
    private javax.swing.JTextField JTF_Curso;
    private javax.swing.JTextField JTF_Id;
    // End of variables declaration//GEN-END:variables
}

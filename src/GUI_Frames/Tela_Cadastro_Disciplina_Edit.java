package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Curso;
import Classes.Modelo_Disciplina;
import Conexao.Controle_Curso;
import Conexao.Controle_Disciplina;
import GUI_Dialogs_Curso_Turma.Conf_Sair_Sem_Salvar_Disc_Edit;
import GUI_Dialogs_Curso_Turma.Conf_Salvar_Disc_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Cadastro_Existente_Disc_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Dados_Nao_Salvos_Disc_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Dados_Salvos_Disc_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Preencher_Campos_Disc_Edit;
import Metodos.Formatacao;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import javax.swing.JComboBox;


public class Tela_Cadastro_Disciplina_Edit extends javax.swing.JInternalFrame {
    
    public static Tela_Cadastro_Disciplina_Edit Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Cadastro_Disciplina_Edit();
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
    Modelo_Curso ObjModCurso = new Modelo_Curso();
    Controle_Disciplina ObjControleDisciplina = new Controle_Disciplina();
    Controle_Curso ObjControleCurso = new Controle_Curso();
    Formatacao ObjFormat = new Formatacao();
    
    private static Inf_Cadastro_Existente_Disc_Edit ObjCadExiste;
    private static Inf_Dados_Salvos_Disc_Edit ObjSalvo;
    public static Inf_Dados_Nao_Salvos_Disc_Edit ObjNaoSalvo;
    private static Inf_Preencher_Campos_Disc_Edit ObjPreencherCampo;
    private static Conf_Salvar_Disc_Edit ObjSalvar;
    private static Conf_Sair_Sem_Salvar_Disc_Edit ObjSairSemSalvar;
    
   
    public Tela_Cadastro_Disciplina_Edit() {
        initComponents();
        JTF_Id.setEnabled(false);
        JTF_Disciplina.setDocument(ObjFormat.new Format_Geral(100));
        ObjControleCurso.Preencher_CB_Curso(JCB_Curso_Disc);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BT_Cancelar = new javax.swing.JButton();
        BT_Salvar = new javax.swing.JButton();
        JP_Curso = new javax.swing.JPanel();
        JL_Disciplina = new javax.swing.JLabel();
        JTF_Disciplina = new javax.swing.JTextField();
        JTF_Id = new javax.swing.JTextField();
        JL_Id = new javax.swing.JLabel();
        JL_Situacao = new javax.swing.JLabel();
        JCB_Situacao = new javax.swing.JComboBox();
        JL_Curso_Disc = new javax.swing.JLabel();
        JCB_Curso_Disc = new javax.swing.JComboBox();
        JL_Semestre_Disc = new javax.swing.JLabel();
        JCB_Semestre_Disc = new javax.swing.JComboBox();
        JL_Campos = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setTitle("Altera Disciplina");
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

        JP_Curso.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados Da Disciplina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JL_Disciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Disciplina.setText("Disciplina*:");

        JTF_Disciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JL_Id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Id.setText("Id*:");

        JL_Situacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Situacao.setText("Situação*:");

        JCB_Situacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Situacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ATIVO", "INATIVO" }));
        JCB_Situacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_SituacaoActionPerformed(evt);
            }
        });

        JL_Curso_Disc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Curso_Disc.setText("Curso*:");

        JCB_Curso_Disc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JL_Semestre_Disc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Semestre_Disc.setText("Semestre*:");

        JCB_Semestre_Disc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Semestre_Disc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout JP_CursoLayout = new javax.swing.GroupLayout(JP_Curso);
        JP_Curso.setLayout(JP_CursoLayout);
        JP_CursoLayout.setHorizontalGroup(
            JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_Disciplina)
                    .addComponent(JL_Id)
                    .addComponent(JL_Semestre_Disc))
                .addGap(18, 18, 18)
                .addGroup(JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_Disciplina)
                    .addGroup(JP_CursoLayout.createSequentialGroup()
                        .addComponent(JTF_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JL_Curso_Disc)
                        .addGap(18, 18, 18)
                        .addComponent(JCB_Curso_Disc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_CursoLayout.createSequentialGroup()
                        .addComponent(JCB_Semestre_Disc, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JL_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JCB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 222, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_CursoLayout.setVerticalGroup(
            JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CursoLayout.createSequentialGroup()
                .addGroup(JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCB_Curso_Disc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Curso_Disc)
                    .addComponent(JL_Id)
                    .addComponent(JTF_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Disciplina)
                    .addComponent(JTF_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Situacao)
                    .addComponent(JCB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Semestre_Disc)
                    .addComponent(JCB_Semestre_Disc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Campos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(JL_Campos)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 700, 262);
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

    private void JCB_SituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_SituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCB_SituacaoActionPerformed

    public void Setar_Campos(Object id_Disciplina){
        ObjControleDisciplina.Consulta_Disciplina(ObjModDisciplina, id_Disciplina);
        JTF_Disciplina.setText(ObjModDisciplina.getDisciplina());
        JTF_Id.setText(String.valueOf(ObjModDisciplina.getId_disciplina()));
        JCB_Situacao.setSelectedItem(ObjModDisciplina.getSituacao());
        JCB_Semestre_Disc.setSelectedItem(String.valueOf(ObjModDisciplina.getSemestre()));
        ObjControleCurso.Consulta_Curso(ObjModCurso, ObjModDisciplina.getId_curso());
        JCB_Curso_Disc.setSelectedItem(ObjModCurso.getNome_curso());
    }
    
    public void Preencher_Objetos(){
        ObjModDisciplina.setDisciplina(JTF_Disciplina.getText().trim());
        ObjModDisciplina.setSemestre(Integer.parseInt(JCB_Semestre_Disc.getSelectedItem().toString().trim()));
        ObjModDisciplina.setSituacao(JCB_Situacao.getSelectedItem().toString().trim());
        ObjControleCurso.Procura_Id_Curso(ObjModCurso, JCB_Curso_Disc);
        ObjModDisciplina.setId_curso(ObjModCurso.getId_curso());
    }
    
    public void Testar_Campos(){
        if(JCB_Curso_Disc.getSelectedIndex()==0 || JCB_Semestre_Disc.getSelectedIndex()==0
                || JTF_Disciplina.getText().equalsIgnoreCase("") || JCB_Situacao.getSelectedIndex()==0)
        {
            Mostrar_Preencher_Campos();
        }
        if (JTF_Disciplina.getText().equalsIgnoreCase(ObjModDisciplina.getDisciplina())
                && JCB_Semestre_Disc.getSelectedItem().toString().equalsIgnoreCase(String.valueOf(ObjModDisciplina.getSemestre()))
                && JCB_Curso_Disc.getSelectedItem().toString().equalsIgnoreCase(ObjModCurso.getNome_curso())){
            Mostrar_Conf_Salvar();
        }else{
            ObjControleDisciplina.Testar_Existente(JCB_Semestre_Disc,JTF_Disciplina, JCB_Curso_Disc);
            if(ObjControleDisciplina.Controle_Existente==true){
                Mostrar_Cadastro_Existente();
                ObjControleDisciplina.Controle_Existente = false;
            }else{
                Mostrar_Conf_Salvar();
            }
        }
    }
    
    public void Conf_Alterar(){
        Preencher_Objetos();
        ObjControleDisciplina.Alterar_Disciplina(ObjModDisciplina, JTF_Id.getText());
        if(ObjControleDisciplina.Confirma_Alterar==true){
            Mostrar_Dados_Salvos();
            dispose();
            Mostrar_Tela_Consulta();
            ObjControleDisciplina.Confirma_Alterar = false;
        }else{
            Mostrar_Dados_Nao_Salvos();
            Mostrar_Tela_Consulta();
            ObjControleDisciplina.Confirma_Alterar = false;
        }
    }
    
    void Sair_Sem_Salvar(){
        if(JCB_Curso_Disc.getSelectedIndex()!=0 || JCB_Semestre_Disc.getSelectedIndex()!=0
                || !JTF_Disciplina.getText().equalsIgnoreCase("")){
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
        ObjSalvar = new Conf_Salvar_Disc_Edit(this, true);
        ObjSalvar.setVisible(true);
    }
   void Mostrar_Sair_Sem_Salvar(){
       ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Disc_Edit(this, true);
       ObjSairSemSalvar.setVisible(true);
   }
   public void Mostrar_Dados_Salvos(){
       ObjSalvo = new Inf_Dados_Salvos_Disc_Edit(this, true);
       ObjSalvo.setVisible(true);
   }
   public void Mostrar_Dados_Nao_Salvos(){
       ObjNaoSalvo = new Inf_Dados_Nao_Salvos_Disc_Edit(this, true);
       ObjNaoSalvo.setVisible(true);
   }
   void Mostrar_Cadastro_Existente(){
       ObjCadExiste = new Inf_Cadastro_Existente_Disc_Edit(this, true);
       ObjCadExiste.setVisible(true);
   }
   void Mostrar_Preencher_Campos(){
       ObjPreencherCampo = new Inf_Preencher_Campos_Disc_Edit(this, true);
       ObjPreencherCampo.setVisible(true);
   }
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Cancelar;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JComboBox JCB_Curso_Disc;
    private javax.swing.JComboBox JCB_Semestre_Disc;
    private javax.swing.JComboBox JCB_Situacao;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Curso_Disc;
    private javax.swing.JLabel JL_Disciplina;
    private javax.swing.JLabel JL_Id;
    private javax.swing.JLabel JL_Semestre_Disc;
    private javax.swing.JLabel JL_Situacao;
    private javax.swing.JPanel JP_Curso;
    private javax.swing.JTextField JTF_Disciplina;
    private javax.swing.JTextField JTF_Id;
    // End of variables declaration//GEN-END:variables
}

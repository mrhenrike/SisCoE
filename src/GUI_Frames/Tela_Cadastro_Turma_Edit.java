package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Curso;
import Classes.Modelo_Turma;
import Conexao.Controle_Curso;
import Conexao.Controle_Turma;
import GUI_Dialogs_Curso_Turma.Conf_Sair_Sem_Salvar_Turma_Edit;
import GUI_Dialogs_Curso_Turma.Conf_Salvar_Turma_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Cadastro_Existente_Turma_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Dados_Nao_Salvos_Turma_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Dados_Salvos_Turma_Edit;
import GUI_Dialogs_Curso_Turma.Inf_Preencher_Campos_Turma_Edit;
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


public class Tela_Cadastro_Turma_Edit extends javax.swing.JInternalFrame {
    
    public static Tela_Cadastro_Turma_Edit Obj;
    
    public void Open_Tela(){
        
        if(Obj==null){
            Obj = new Tela_Cadastro_Turma_Edit();
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
    
        
    Modelo_Turma ObjModTurma = new Modelo_Turma();
    Modelo_Curso ObjModCurso = new Modelo_Curso();
    Controle_Turma ObjControleTurma = new Controle_Turma();
    Controle_Curso ObjControleCurso = new Controle_Curso();
        
    private static Inf_Cadastro_Existente_Turma_Edit ObjCadExiste;
    private static Inf_Dados_Salvos_Turma_Edit ObjSalvo;
    public static Inf_Dados_Nao_Salvos_Turma_Edit ObjNaoSalvo;
    private static Inf_Preencher_Campos_Turma_Edit ObjPreencherCampo;
    private static Conf_Salvar_Turma_Edit ObjSalvar;
    private static Conf_Sair_Sem_Salvar_Turma_Edit ObjSairSemSalvar;
    
   
    public Tela_Cadastro_Turma_Edit() {
        initComponents();
        JTF_Id.setEnabled(false);
        ObjControleCurso.Preencher_CB_Curso(JCB_Curso);
        Preencher_CB_Ano();
        Setar_Atalho_BT();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BT_Cancelar = new javax.swing.JButton();
        BT_Salvar = new javax.swing.JButton();
        JP_Turma = new javax.swing.JPanel();
        JL_Curso_Turma = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCB_Curso = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JCB_Vestibular = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        JCB_Turno = new javax.swing.JComboBox();
        JCB_Semestre = new javax.swing.JComboBox();
        JCB_Ano = new javax.swing.JComboBox();
        JL_Curso3 = new javax.swing.JLabel();
        JTF_Id = new javax.swing.JTextField();
        JCB_Situacao = new javax.swing.JComboBox();
        JL_Curso2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JCB_Turma = new javax.swing.JComboBox();
        JL_Campos = new javax.swing.JLabel();
        JL_Quant_Itens1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setTitle("Alterar Turma");
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

        JP_Turma.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados Da Turma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JL_Curso_Turma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Curso_Turma.setText("Curso*:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Turno*:");

        JCB_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Semestre*:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Vestibular*:");

        JCB_Vestibular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Vestibular.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1", "2" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ano*:");

        JCB_Turno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Turno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "M", "V", "N" }));

        JCB_Semestre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Semestre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        JCB_Ano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", " " }));

        JL_Curso3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Curso3.setText("Id*:");

        JTF_Id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JCB_Situacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Situacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ATIVO", "INATIVO" }));

        JL_Curso2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Curso2.setText("Situação*:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Turma:");

        JCB_Turma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Turma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "A", "B", "C", "D", "E" }));

        javax.swing.GroupLayout JP_TurmaLayout = new javax.swing.GroupLayout(JP_Turma);
        JP_Turma.setLayout(JP_TurmaLayout);
        JP_TurmaLayout.setHorizontalGroup(
            JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_TurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_Curso3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_Id)
                    .addComponent(JCB_Turno, 0, 59, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_Curso_Turma)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(JP_TurmaLayout.createSequentialGroup()
                        .addComponent(JCB_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCB_Turma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JCB_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(JL_Curso2))
                .addGap(10, 10, 10)
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_TurmaLayout.createSequentialGroup()
                        .addComponent(JCB_Vestibular, 0, 56, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(11, 11, 11)
                        .addComponent(JCB_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JCB_Situacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JP_TurmaLayout.setVerticalGroup(
            JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_TurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCB_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Curso3)
                    .addComponent(JTF_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Curso_Turma)
                    .addComponent(jLabel7)
                    .addComponent(JCB_Vestibular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(JCB_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(JCB_Turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JCB_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Curso2)
                    .addComponent(jLabel9)
                    .addComponent(JCB_Turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Cancelar | F10 - Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_Campos)
                            .addComponent(JL_Quant_Itens1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JP_Turma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BT_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Quant_Itens1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Campos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 750, 232);
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

    public final void Preencher_CB_Ano(){
        JCB_Ano.removeAllItems();
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        int Ano_Atual = (Integer.parseInt((String)df.format(new Date(System.currentTimeMillis()))));
        int Ano_Inicial = Ano_Atual - 6;
        JCB_Ano.addItem(" ");
        for (int i = Ano_Inicial;i<=Ano_Atual;i++){
            JCB_Ano.addItem(i);
        }
    }
    
    public void Setar_Campos_Turma(Object id_turma){
        ObjControleTurma.Consulta_Turma(ObjModTurma, id_turma);
        JCB_Ano.setSelectedItem(Integer.parseInt(ObjModTurma.getAno_turma()));
        JCB_Semestre.setSelectedItem(String.valueOf(ObjModTurma.getSemestre()));
        JCB_Vestibular.setSelectedItem(String.valueOf(ObjModTurma.getSemestre_vestibular()));
        JCB_Turno.setSelectedItem(ObjModTurma.getTurno());
        JTF_Id.setText(String.valueOf(ObjModTurma.getId_turma()));
        JCB_Situacao.setSelectedItem(ObjModTurma.getSituacao());
        ObjControleCurso.Consulta_Curso(ObjModCurso, ObjModTurma.getId_curso());
        JCB_Curso.setSelectedItem(ObjModCurso.getNome_curso());
        JCB_Turma.setSelectedItem(ObjModTurma.getTurma());
    }
    
    public void Preencher_Objetos(){
        ObjModTurma.setAno_turma(JCB_Ano.getSelectedItem().toString());
        ObjModTurma.setSemestre(Integer.parseInt(JCB_Semestre.getSelectedItem().toString()));
        ObjModTurma.setTurno(JCB_Turno.getSelectedItem().toString());
        ObjModTurma.setSemestre_vestibular(Integer.parseInt(JCB_Vestibular.getSelectedItem().toString()));
        ObjModTurma.setSituacao(JCB_Situacao.getSelectedItem().toString().trim());
        ObjModTurma.setTurma(JCB_Turma.getSelectedItem().toString().trim());
        ObjControleCurso.Procura_Id_Curso(ObjModCurso, JCB_Curso);
        ObjModTurma.setId_curso(ObjModCurso.getId_curso());
    }
    
    public void Testar_Campos(){
        if ((JCB_Ano.getSelectedIndex()==0)||(JCB_Curso.getSelectedIndex()==0)||(JCB_Semestre.getSelectedIndex()==0)
                ||(JCB_Turno.getSelectedIndex()==0)||(JCB_Vestibular.getSelectedIndex()==0))
        {
            Mostrar_Preencher_Campos();
        }
        if (JCB_Curso.getSelectedItem().toString().equalsIgnoreCase(ObjModCurso.getNome_curso())
                && JCB_Semestre.getSelectedItem().toString().equalsIgnoreCase(String.valueOf(ObjModTurma.getSemestre()))
                && JCB_Ano.getSelectedItem().toString().equalsIgnoreCase(ObjModTurma.getAno_turma())
                && JCB_Turno.getSelectedItem().toString().equalsIgnoreCase(ObjModTurma.getTurno())
                && JCB_Vestibular.getSelectedItem().toString().equalsIgnoreCase(String.valueOf(ObjModTurma.getSemestre_vestibular()))
                && JCB_Turma.getSelectedItem().toString().trim().equalsIgnoreCase(ObjModTurma.getTurma())
                ){
            Mostrar_Conf_Salvar();
        }else{
            ObjControleTurma.Testar_Existente(JCB_Semestre,JCB_Turno,JCB_Ano,JCB_Vestibular,JCB_Curso, JCB_Turma);
            if(ObjControleTurma.Controle_Existente==true)
            {
                Mostrar_Cadastro_Existente();
                ObjControleTurma.Controle_Existente = false;
            }else{
                Mostrar_Conf_Salvar();
            }
        }
    }
    
    public void Conf_Alterar(){
        Preencher_Objetos();
        ObjControleTurma.Alterar_Turma(ObjModTurma, JTF_Id.getText());
        if(ObjControleTurma.Confirma_Alterar==true){
            Mostrar_Dados_Salvos();
            dispose();
            Mostrar_Tela_Consulta();
            ObjControleTurma.Confirma_Alterar = false;
        }else{
            Mostrar_Dados_Nao_Salvos();
            Mostrar_Tela_Consulta();
            ObjControleTurma.Confirma_Alterar = false;
        }
    }
    
    void Sair_Sem_Salvar(){
        if(!JTF_Id.getText().equalsIgnoreCase("")||!(JCB_Ano.getSelectedIndex()==0)  
                ||!(JCB_Curso.getSelectedIndex()==0)||!(JCB_Semestre.getSelectedIndex()==0)
                ||!(JCB_Turno.getSelectedIndex()==0)||!(JCB_Vestibular.getSelectedIndex()==0)
                ||!(JCB_Turma.getSelectedIndex()==0)){
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
        ObjSalvar = new Conf_Salvar_Turma_Edit(this, true);
        ObjSalvar.setVisible(true);
    }
   void Mostrar_Sair_Sem_Salvar(){
       ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Turma_Edit(this, true);
       ObjSairSemSalvar.setVisible(true);
   }
   public void Mostrar_Dados_Salvos(){
       ObjSalvo = new Inf_Dados_Salvos_Turma_Edit(this, true);
       ObjSalvo.setVisible(true);
   }
   public void Mostrar_Dados_Nao_Salvos(){
       ObjNaoSalvo = new Inf_Dados_Nao_Salvos_Turma_Edit(this, true);
       ObjNaoSalvo.setVisible(true);
   }
   void Mostrar_Cadastro_Existente(){
       ObjCadExiste = new Inf_Cadastro_Existente_Turma_Edit(this, true);
       ObjCadExiste.setVisible(true);
   }
   void Mostrar_Preencher_Campos(){
       ObjPreencherCampo = new Inf_Preencher_Campos_Turma_Edit(this, true);
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
    private javax.swing.JComboBox JCB_Ano;
    private javax.swing.JComboBox JCB_Curso;
    private javax.swing.JComboBox JCB_Semestre;
    private javax.swing.JComboBox JCB_Situacao;
    private javax.swing.JComboBox JCB_Turma;
    private javax.swing.JComboBox JCB_Turno;
    private javax.swing.JComboBox JCB_Vestibular;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Curso2;
    private javax.swing.JLabel JL_Curso3;
    private javax.swing.JLabel JL_Curso_Turma;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JPanel JP_Turma;
    private javax.swing.JTextField JTF_Id;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

   
}

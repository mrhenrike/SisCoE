package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Curso;
import Classes.Modelo_Disciplina;
import Classes.Modelo_Turma;
import Conexao.Conecta_Banco;
import Conexao.Controle_Curso;
import Conexao.Controle_Disciplina;
import Conexao.Controle_Turma;
import GUI_Dialogs_Curso_Turma.Conf_Sair_Sem_Salvar_Curso;
import GUI_Dialogs_Curso_Turma.Conf_Salvar_Curso;
import GUI_Dialogs_Curso_Turma.Conf_Salvar_Disciplina;
import GUI_Dialogs_Curso_Turma.Conf_Salvar_Turma;
import GUI_Dialogs_Curso_Turma.Inf_Cadastro_Existente_Curso;
import GUI_Dialogs_Curso_Turma.Inf_Dados_Nao_Salvos_Curso;
import GUI_Dialogs_Curso_Turma.Inf_Dados_Salvos_Curso;
import GUI_Dialogs_Curso_Turma.Inf_Preencher_Campos_Curso;
import Metodos.Formatacao;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Tela_Cadastro_Curso_Turma extends javax.swing.JInternalFrame {
    
    public static Tela_Cadastro_Curso_Turma Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Cadastro_Curso_Turma();
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
    
    Formatacao ObjFormat = new Formatacao();
    Controle_Curso ObjControlCurso = new Controle_Curso();
    Controle_Turma ObjControlTurma = new Controle_Turma();
    Controle_Disciplina ObjControlDisciplina = new Controle_Disciplina();
    Modelo_Curso ObjModeloCurso = new Modelo_Curso();
    Modelo_Turma ObjModeloTurma = new Modelo_Turma();
    Modelo_Disciplina ObjModeloDisciplina = new Modelo_Disciplina();
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Conecta_Banco ObjConecta2 = new Conecta_Banco();
    
    //Instância de objetos do tipo dialog
    private static Inf_Preencher_Campos_Curso ObjPreencherCampos;
    private static Inf_Dados_Salvos_Curso ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_Curso ObjDadosNaoSalvos;
    private static Conf_Salvar_Curso ObjConfSalvarCurso;
    private static Conf_Salvar_Turma ObjConfSalvarTurma;
    private static Conf_Salvar_Disciplina ObjConfSalvarDisciplina;
    private static Conf_Sair_Sem_Salvar_Curso ObjSairSemSalvar;
    private static Inf_Cadastro_Existente_Curso ObjCadExistente;
    
    
       

    public Tela_Cadastro_Curso_Turma() {
        initComponents();
        
        JTF_Curso.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Abrev.setDocument(ObjFormat.new Format_Geral(10));
        JTF_Disciplina.setDocument(ObjFormat.new Format_Geral(100));
        
        JRB_Curso.setSelected(true);
        Desabilita_Campos_Turma();
        Desabilita_Campos_Disciplina();
        Preencher_CB_Ano();
        ObjControlCurso.Preencher_CB_Curso(JCB_Curso);
        ObjControlCurso.Preencher_CB_Curso(JCB_Curso_Disc);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_Tipo_Cad = new javax.swing.ButtonGroup();
        JP_Curso = new javax.swing.JPanel();
        JL_Curso = new javax.swing.JLabel();
        JL_Abrev = new javax.swing.JLabel();
        JTF_Curso = new javax.swing.JTextField();
        JTF_Abrev = new javax.swing.JTextField();
        BT_Sair = new javax.swing.JButton();
        BT_Salvar = new javax.swing.JButton();
        BT_Consulta = new javax.swing.JButton();
        JL_Campos = new javax.swing.JLabel();
        JP_Cadastro = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JRB_Curso = new javax.swing.JRadioButton();
        JRB_Turma = new javax.swing.JRadioButton();
        JRB_Disciplina = new javax.swing.JRadioButton();
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
        CHB_Turma = new javax.swing.JCheckBox();
        JCB_Turma = new javax.swing.JComboBox();
        JP_Disciplina = new javax.swing.JPanel();
        JCB_Curso_Disc = new javax.swing.JComboBox();
        JL_Curso_Disc = new javax.swing.JLabel();
        JTF_Disciplina = new javax.swing.JTextField();
        JL_Disciplina = new javax.swing.JLabel();
        JL_Semestre_Disc = new javax.swing.JLabel();
        JCB_Semestre_Disc = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Cadastro De Curso - Turma - Disciplina");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Curso 24x24.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(805, 400));
        setMinimumSize(new java.awt.Dimension(805, 400));
        setPreferredSize(new java.awt.Dimension(805, 400));
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

        JP_Curso.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados Do Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JL_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Curso.setText("Curso*:");

        JL_Abrev.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Abrev.setText("Abreviatura*:");

        JTF_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Curso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_CursoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTF_CursoFocusLost(evt);
            }
        });

        JTF_Abrev.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JP_CursoLayout = new javax.swing.GroupLayout(JP_Curso);
        JP_Curso.setLayout(JP_CursoLayout);
        JP_CursoLayout.setHorizontalGroup(
            JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CursoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_Curso)
                .addGap(18, 18, 18)
                .addComponent(JTF_Curso, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(JL_Abrev)
                .addGap(18, 18, 18)
                .addComponent(JTF_Abrev, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JP_CursoLayout.setVerticalGroup(
            JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_CursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Curso)
                    .addComponent(JTF_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Abrev)
                    .addComponent(JTF_Abrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        BT_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar.png"))); // NOI18N
        BT_Salvar.setMnemonic('s');
        BT_Salvar.setToolTipText("Clique Para Salvar Ou Pressione Alt + S");
        BT_Salvar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar Press.png"))); // NOI18N
        BT_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SalvarActionPerformed(evt);
            }
        });

        BT_Consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar.png"))); // NOI18N
        BT_Consulta.setMnemonic('n');
        BT_Consulta.setToolTipText("Clique Para Consultar Ou Pressione Alt + N");
        BT_Consulta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar Press.png"))); // NOI18N
        BT_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ConsultaActionPerformed(evt);
            }
        });

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        JP_Cadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Opção De Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tipo De Cadastro*:");

        BG_Tipo_Cad.add(JRB_Curso);
        JRB_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Curso.setText("Curso");
        JRB_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_CursoActionPerformed(evt);
            }
        });

        BG_Tipo_Cad.add(JRB_Turma);
        JRB_Turma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Turma.setText("Turma");
        JRB_Turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_TurmaActionPerformed(evt);
            }
        });

        BG_Tipo_Cad.add(JRB_Disciplina);
        JRB_Disciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Disciplina.setText("Disciplina");
        JRB_Disciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_DisciplinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_CadastroLayout = new javax.swing.GroupLayout(JP_Cadastro);
        JP_Cadastro.setLayout(JP_CadastroLayout);
        JP_CadastroLayout.setHorizontalGroup(
            JP_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(JRB_Curso)
                .addGap(18, 18, 18)
                .addComponent(JRB_Turma)
                .addGap(18, 18, 18)
                .addComponent(JRB_Disciplina)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_CadastroLayout.setVerticalGroup(
            JP_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_CadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JRB_Curso)
                    .addComponent(JRB_Turma)
                    .addComponent(JRB_Disciplina))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        CHB_Turma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CHB_Turma.setText("Turma:");
        CHB_Turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHB_TurmaActionPerformed(evt);
            }
        });

        JCB_Turma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Turma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "A", "B", "C", "D", "E" }));

        javax.swing.GroupLayout JP_TurmaLayout = new javax.swing.GroupLayout(JP_Turma);
        JP_Turma.setLayout(JP_TurmaLayout);
        JP_TurmaLayout.setHorizontalGroup(
            JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_TurmaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_Curso_Turma)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_TurmaLayout.createSequentialGroup()
                        .addComponent(JCB_Ano, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCB_Turno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCB_Semestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JCB_Curso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JP_TurmaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(JCB_Vestibular, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_TurmaLayout.createSequentialGroup()
                        .addComponent(CHB_Turma)
                        .addGap(18, 18, 18)
                        .addComponent(JCB_Turma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_TurmaLayout.setVerticalGroup(
            JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_TurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Curso_Turma)
                    .addComponent(JCB_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JCB_Vestibular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JP_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(JCB_Turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JCB_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CHB_Turma)
                    .addComponent(JCB_Turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        JP_Disciplina.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados Da Disciplina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        JP_Disciplina.setPreferredSize(new java.awt.Dimension(607, 125));

        JCB_Curso_Disc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JL_Curso_Disc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Curso_Disc.setText("Curso*:");

        JTF_Disciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Disciplina.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_DisciplinaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTF_DisciplinaFocusLost(evt);
            }
        });

        JL_Disciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Disciplina.setText("Disciplina*:");

        JL_Semestre_Disc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Semestre_Disc.setText("Semestre*:");

        JCB_Semestre_Disc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Semestre_Disc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout JP_DisciplinaLayout = new javax.swing.GroupLayout(JP_Disciplina);
        JP_Disciplina.setLayout(JP_DisciplinaLayout);
        JP_DisciplinaLayout.setHorizontalGroup(
            JP_DisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_DisciplinaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(JP_DisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JL_Disciplina)
                    .addComponent(JL_Curso_Disc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_DisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_Disciplina)
                    .addGroup(JP_DisciplinaLayout.createSequentialGroup()
                        .addComponent(JCB_Curso_Disc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(JL_Semestre_Disc)
                        .addGap(18, 18, 18)
                        .addComponent(JCB_Semestre_Disc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JP_DisciplinaLayout.setVerticalGroup(
            JP_DisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_DisciplinaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_DisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Curso_Disc)
                    .addComponent(JCB_Curso_Disc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Semestre_Disc)
                    .addComponent(JCB_Semestre_Disc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JP_DisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Disciplina)
                    .addComponent(JTF_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Campos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JP_Curso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JP_Cadastro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JP_Turma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JP_Disciplina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE))
                        .addGap(11, 11, 11))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JP_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JP_Turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JP_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BT_Consulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JL_Campos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(20, 20, 700, 531);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Sair_Sem_Salvar();
        
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        if(JRB_Turma.isSelected()){
            Testar_Campos_Turma();
        }
        if(JRB_Curso.isSelected()){
            Testar_Campos_Curso();
        }
        if(JRB_Disciplina.isSelected()){
           Testar_Campos_Disciplina();
        }
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void BT_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConsultaActionPerformed
        Tela_Consulta_Curso_Turma obj =new Tela_Consulta_Curso_Turma();
        obj.Open_Tela();
        dispose();
    }//GEN-LAST:event_BT_ConsultaActionPerformed

    private void JRB_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_CursoActionPerformed
        if(JRB_Curso.isSelected()){
            Desabilita_Campos_Turma();
            Desabilita_Campos_Disciplina();
            Habilita_Campos_Cursos();
            Limpar_Campos_Turma();
            Limpar_Campos_Disciplina();
        }
    }//GEN-LAST:event_JRB_CursoActionPerformed

    private void JRB_TurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_TurmaActionPerformed
        if(JRB_Turma.isSelected()){
            ObjControlCurso.Preencher_CB_Curso(JCB_Curso);
            Desabilita_Campos_Cursos();
            Desabilita_Campos_Disciplina();
            Habilita_Campos_Turma();
            Limpar_Campos_Curso();
            Limpar_Campos_Disciplina();            
        }
    }//GEN-LAST:event_JRB_TurmaActionPerformed

    private void JTF_CursoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_CursoFocusGained
//        if(JTF_Curso.getText().equalsIgnoreCase("Digite...")){
//            JTF_Curso.setText("");
//            JTF_Curso.setForeground(Color.BLACK);
//        }else{ }
    }//GEN-LAST:event_JTF_CursoFocusGained

    private void JTF_CursoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_CursoFocusLost
//        if(JTF_Curso.getText().equalsIgnoreCase("")){
//            JTF_Curso.setText("Digite...");
//            JTF_Curso.setForeground(Color.red);}
//        else{
//            JTF_Curso.setForeground(Color.black);
//        }
    }//GEN-LAST:event_JTF_CursoFocusLost

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JRB_DisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_DisciplinaActionPerformed
        if(JRB_Disciplina.isSelected()){
            ObjControlCurso.Preencher_CB_Curso(JCB_Curso_Disc);
            Desabilita_Campos_Turma();
            Desabilita_Campos_Cursos();
            Habilita_Campos_Disciplina();
            Limpar_Campos_Curso();
            Limpar_Campos_Turma();
                    }
    }//GEN-LAST:event_JRB_DisciplinaActionPerformed

    private void JTF_DisciplinaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_DisciplinaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_DisciplinaFocusGained

    private void JTF_DisciplinaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_DisciplinaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_DisciplinaFocusLost

    private void CHB_TurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHB_TurmaActionPerformed
        if(CHB_Turma.isEnabled()){
            JCB_Turma.setEnabled(true);
        }
        if(CHB_Turma.isSelected()==false){
            JCB_Turma.setEnabled(!true);
            JCB_Turma.setSelectedIndex(0);
        }
    }//GEN-LAST:event_CHB_TurmaActionPerformed

    public void Limpar_Campos_Curso(){
        JTF_Abrev.setText("");
        JTF_Curso.setText("");
    }
    public void Limpar_Campos_Turma(){
        JCB_Ano.setSelectedIndex(0);
        JCB_Semestre.setSelectedIndex(0);
        JCB_Turno.setSelectedIndex(0);
        JCB_Vestibular.setSelectedIndex(0);
        JCB_Curso.setSelectedIndex(0);
        JCB_Turma.setSelectedIndex(0);
        CHB_Turma.setSelected(false);
    }
    public void Limpar_Campos_Disciplina(){
        JTF_Disciplina.setText("");
        JCB_Semestre_Disc.setSelectedIndex(0);
        JCB_Curso_Disc.setSelectedIndex(0);
    }
    
    public void Testar_Campos_Curso(){
        if((JTF_Curso.getText().equalsIgnoreCase(""))||(JTF_Abrev.getText().equalsIgnoreCase("")))
        {
            Mostrar_Preencher_Campos();
        }else{
            ObjControlCurso.Testar_Existente(JTF_Curso);
                if(ObjControlCurso.Controle_Existente==true)
                {
                   Mostrar_Cadastro_Existente();
                   ObjControlCurso.Controle_Existente = false;
                }else{
                   Mostrar_Conf_Salvar_Curso();
                }
        }
    }
    public void Testar_Campos_Turma(){
        if ((JCB_Ano.getSelectedIndex()==0)||(JCB_Curso.getSelectedIndex()==0)||(JCB_Semestre.getSelectedIndex()==0)
                ||(JCB_Turno.getSelectedIndex()==0)||(JCB_Vestibular.getSelectedIndex()==0))
        {
            Mostrar_Preencher_Campos();
        }else{
            ObjControlTurma.Testar_Existente(JCB_Semestre,JCB_Turno,JCB_Ano,JCB_Vestibular,JCB_Curso, JCB_Turma);
            if(ObjControlTurma.Controle_Existente==true)
            {
                Mostrar_Cadastro_Existente();
                ObjControlTurma.Controle_Existente = false;
            }else{
                Mostrar_Conf_Salvar_Turma();
            }
        }
        
    }
    public void Testar_Campos_Disciplina(){
        if(JCB_Curso_Disc.getSelectedIndex()==0 || JCB_Semestre_Disc.getSelectedIndex()==0
                || JTF_Disciplina.getText().equalsIgnoreCase(""))
        {
            Mostrar_Preencher_Campos();
        }else{
            ObjControlDisciplina.Testar_Existente(JCB_Semestre_Disc,JTF_Disciplina,JCB_Curso_Disc);
            if(ObjControlDisciplina.Controle_Existente==true)
            {
                Mostrar_Cadastro_Existente();
                ObjControlDisciplina.Controle_Existente = false;
            }else{
                Mostrar_Conf_Salvar_Disciplina();
            }
        }
    }
    
    public void Sair_Sem_Salvar(){
        if(JRB_Curso.isSelected()){
            if ((!JTF_Curso.getText().equalsIgnoreCase("")) || (!JTF_Abrev.getText().equalsIgnoreCase(""))) {
                Mostrar_Sair_Sem_Salvar();
            } else {
                dispose();
            }
        }
        if(JRB_Turma.isSelected()){
            if ((JCB_Ano.getSelectedIndex()!=0)
                 ||(JCB_Curso.getSelectedIndex()!=0)
                 ||(JCB_Semestre.getSelectedIndex()!=0)
                 ||(JCB_Turno.getSelectedIndex()!=0)
                 ||(JCB_Vestibular.getSelectedIndex()!=0)
                 || (JCB_Turma.getSelectedIndex()!=0)) {
                 Mostrar_Sair_Sem_Salvar();  
            } else {                
                dispose();
            }
        }
        if(JRB_Disciplina.isSelected()){
            if(JCB_Curso_Disc.getSelectedIndex()!=0 || JCB_Semestre_Disc.getSelectedIndex()!=0
                || !JTF_Disciplina.getText().equalsIgnoreCase("")){
                Mostrar_Sair_Sem_Salvar();
            } else {
                dispose();
            }
        }
    }
    
    
    public void Preencher_Objetos_Curso(){
        ObjModeloCurso.setNome_curso(JTF_Curso.getText().trim());
        ObjModeloCurso.setAbrev_curso(JTF_Abrev.getText().trim());
    }
    public void Preencher_Objetos_Turma(){
        ObjModeloTurma.setAno_turma(JCB_Ano.getSelectedItem().toString());
        ObjModeloTurma.setSemestre(Integer.parseInt(JCB_Semestre.getSelectedItem().toString()));
        ObjModeloTurma.setTurno(JCB_Turno.getSelectedItem().toString());
        ObjModeloTurma.setSemestre_vestibular(Integer.parseInt(JCB_Vestibular.getSelectedItem().toString()));
        ObjModeloTurma.setTurma(JCB_Turma.getSelectedItem().toString().trim());
    }
    public void Preencher_Objetos_Disciplina(){
        ObjModeloDisciplina.setDisciplina(JTF_Disciplina.getText().trim());
        ObjModeloDisciplina.setSemestre(Integer.parseInt(JCB_Semestre_Disc.getSelectedItem().toString()));
    }
    
    public void Desabilita_Campos_Cursos(){
        JTF_Curso.setEnabled(false);
        JTF_Abrev.setEnabled(false);
        JP_Curso.setEnabled(false);
        JL_Curso.setEnabled(false);
        JL_Abrev.setEnabled(false);
    }
    public void Habilita_Campos_Cursos(){
        JTF_Curso.setEnabled(!false);
        JTF_Abrev.setEnabled(!false);
        JP_Curso.setEnabled(!false);
        JL_Curso.setEnabled(!false);
        JL_Abrev.setEnabled(!false);
    }
    
    public final void Desabilita_Campos_Turma(){
        JCB_Ano.setEnabled(false);
        JCB_Curso.setEnabled(false);
        JCB_Semestre.setEnabled(false);
        JCB_Turno.setEnabled(false);
        JCB_Vestibular.setEnabled(false);
        JP_Turma.setEnabled(false);
        JL_Curso_Turma.setEnabled(false);
        jLabel5.setEnabled(false);
        jLabel6.setEnabled(false);
        jLabel7.setEnabled(false);
        jLabel8.setEnabled(false);
        CHB_Turma.setEnabled(false);
        JCB_Turma.setEnabled(false);
    }
    public void Habilita_Campos_Turma(){
        JCB_Ano.setEnabled(!false);
        JCB_Curso.setEnabled(!false);
        JCB_Semestre.setEnabled(!false);
        JCB_Turno.setEnabled(!false);
        JCB_Vestibular.setEnabled(!false);
        JP_Turma.setEnabled(!false);
        JL_Curso_Turma.setEnabled(!false);
        jLabel5.setEnabled(!false);
        jLabel6.setEnabled(!false);
        jLabel7.setEnabled(!false);
        jLabel8.setEnabled(!false);
        CHB_Turma.setEnabled(!false);
        //JCB_Turma.setEnabled(!false);
    }
    public final void Desabilita_Campos_Disciplina(){
        JL_Curso_Disc.setEnabled(false);
        JCB_Curso_Disc.setEnabled(false);
        JP_Disciplina.setEnabled(false);
        JL_Semestre_Disc.setEnabled(false);
        JTF_Disciplina.setEnabled(false);
        JL_Disciplina.setEnabled(false);
        JCB_Semestre_Disc.setEnabled(false);
    }
     public void Habilita_Campos_Disciplina(){
        JL_Curso_Disc.setEnabled(!false);
        JCB_Curso_Disc.setEnabled(!false);
        JP_Disciplina.setEnabled(!false);
        JL_Semestre_Disc.setEnabled(!false);
        JTF_Disciplina.setEnabled(!false);
        JL_Disciplina.setEnabled(!false);
        JCB_Semestre_Disc.setEnabled(!false);
    }
    
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
    
    public void Procura_Id_Curso(){
     try {
         ObjConecta2.Conectar();
         ObjConecta2.ExecutaSQL("Select * from curso where nome_curso="+"'"+JCB_Curso.getSelectedItem().toString()+"'"+"");
         ObjConecta2.rs.first();
         ObjModeloTurma.setId_curso(ObjConecta2.rs.getInt("id_curso"));
         ObjConecta2.Desconecta();
        } catch (SQLException ex) {
            ObjConecta2.Desconecta();
            JOptionPane.showMessageDialog(rootPane, "Erro ao procurar o id do curso\n"+ex);
        }
     
    }
    public void Procura_Id_Curso_Disciplina(){
     try {
         ObjConecta2.Conectar();
         ObjConecta2.ExecutaSQL("Select * from curso where nome_curso="+"'"+JCB_Curso_Disc.getSelectedItem().toString()+"'"+"");
         ObjConecta2.rs.first();
         ObjModeloDisciplina.setId_curso(ObjConecta2.rs.getInt("id_curso"));
         ObjConecta2.Desconecta();
        } catch (SQLException ex) {
            ObjConecta2.Desconecta();
            JOptionPane.showMessageDialog(rootPane, "Erro ao procurar o id do curso - disciplina\n"+ex);
        }
     
    }
    
    public void Conf_Inserir_Curso(){
        Preencher_Objetos_Curso();
        ObjControlCurso.Inserir_Curso(ObjModeloCurso);
        if (ObjControlCurso.Confirma_Inserir == true) 
            {
                Mostrar_Dados_Salvos();
                Limpar_Campos_Curso();
                ObjControlCurso.Confirma_Inserir = false;
            }
            else{
                Mostrar_Dados_Nao_Salvos();
                ObjControlCurso.Confirma_Inserir = false;
                }
    }
    
    public void Conf_Inserir_Turma(){
        Procura_Id_Curso();
        Preencher_Objetos_Turma();
        ObjControlTurma.Inserir_Turma(ObjModeloTurma);
        if (ObjControlTurma.Confirma_Inserir_Turma == true) 
            {
                Mostrar_Dados_Salvos();
                Limpar_Campos_Turma();
                ObjControlTurma.Confirma_Inserir_Turma = false;
            }
            else{
                Mostrar_Dados_Nao_Salvos();
                ObjControlTurma.Confirma_Inserir_Turma = false;
                }  
    }
    
    public void Conf_Inserir_Disciplina(){
        Procura_Id_Curso_Disciplina();
        Preencher_Objetos_Disciplina();
        ObjControlDisciplina.Inserir_Disciplina(ObjModeloDisciplina);
        if (ObjControlDisciplina.Confirma_Inserir_Disciplina == true) 
            {
                Mostrar_Dados_Salvos();
                Limpar_Campos_Disciplina();
                ObjControlDisciplina.Confirma_Inserir_Disciplina = false;
            }
            else{
                Mostrar_Dados_Nao_Salvos();
                ObjControlDisciplina.Confirma_Inserir_Disciplina = false;
                }  
    }
   
    //metodos para mostrar as dialogs
    void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Curso(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Curso(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Curso(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    void Mostrar_Conf_Salvar_Curso(){
        ObjConfSalvarCurso = new Conf_Salvar_Curso(this, true);
        ObjConfSalvarCurso.setVisible(true);        
    }
    void Mostrar_Conf_Salvar_Turma(){
        ObjConfSalvarTurma = new Conf_Salvar_Turma(this, true);
        ObjConfSalvarTurma.setVisible(true);        
    }
    void Mostrar_Conf_Salvar_Disciplina(){
        ObjConfSalvarDisciplina = new Conf_Salvar_Disciplina(this, true);
        ObjConfSalvarDisciplina.setVisible(true);        
    }
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Curso(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    void Mostrar_Cadastro_Existente(){
        ObjCadExistente = new Inf_Cadastro_Existente_Curso(this, true);
        ObjCadExistente.setVisible(true);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_Tipo_Cad;
    private javax.swing.JButton BT_Consulta;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JCheckBox CHB_Turma;
    private javax.swing.JComboBox JCB_Ano;
    private javax.swing.JComboBox JCB_Curso;
    private javax.swing.JComboBox JCB_Curso_Disc;
    private javax.swing.JComboBox JCB_Semestre;
    private javax.swing.JComboBox JCB_Semestre_Disc;
    private javax.swing.JComboBox JCB_Turma;
    private javax.swing.JComboBox JCB_Turno;
    private javax.swing.JComboBox JCB_Vestibular;
    private javax.swing.JLabel JL_Abrev;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Curso;
    private javax.swing.JLabel JL_Curso_Disc;
    private javax.swing.JLabel JL_Curso_Turma;
    private javax.swing.JLabel JL_Disciplina;
    private javax.swing.JLabel JL_Semestre_Disc;
    private javax.swing.JPanel JP_Cadastro;
    private javax.swing.JPanel JP_Curso;
    private javax.swing.JPanel JP_Disciplina;
    private javax.swing.JPanel JP_Turma;
    private javax.swing.JRadioButton JRB_Curso;
    private javax.swing.JRadioButton JRB_Disciplina;
    private javax.swing.JRadioButton JRB_Turma;
    private javax.swing.JTextField JTF_Abrev;
    private javax.swing.JTextField JTF_Curso;
    private javax.swing.JTextField JTF_Disciplina;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}

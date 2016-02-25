package GUI_Frames;

import Classes.Modelo_Curso;
import Classes.Modelo_Tabela;
import Classes.Modelo_Turma;
import Conexao.Conecta_Banco;
import Conexao.Controle_Curso;
import Conexao.Controle_Turma;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

// @author Márison Tamiarana
public class Tela_Consulta_Curso_Turma extends javax.swing.JInternalFrame {

    public static Tela_Consulta_Curso_Turma Obj;

    public void Open_Tela() {
        if (Obj == null) {
            Obj = new Tela_Consulta_Curso_Turma();
            Tela_Principal.getPainel().add(Obj);
            Obj.setVisible(true);
            Obj.setPosicao();
        }
        try {
            if (Obj.isIcon()) // se for um icon    
            {
                Obj.setIcon(false); // tira desse estado    
            } else // senão (não está iconizada)    
            {
                Obj.toFront(); // trás para frente das outras    
            }
        } catch (PropertyVetoException e) {
        }
    }

    // setar a internal frame centralizada

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    //Instancia de objetos
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Conecta_Banco ObjConecta_2 = new Conecta_Banco();
    Formatacao ObjFormat = new Formatacao();
    Controle_Curso ObjControleCurso = new Controle_Curso();
    Controle_Turma ObjControleTurma = new Controle_Turma();
    Modelo_Curso ObjModCurso = new Modelo_Curso();
    Modelo_Turma ObjModTurma = new Modelo_Turma();

    public Tela_Consulta_Curso_Turma() {
        initComponents();

        Desabilita_RB_Turma();
        Desabilita_RB_Disciplina();
        BT_Editar_Turma.setEnabled(false);
        BT_Editar_Disciplina.setEnabled(false);
        Preencher_Tabela_Curso("select * from curso where situacao_curso = 'ATIVO' order by nome_curso");
        JRB_Nome.setSelected(true);
        BT_Editar_Curso.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_Organizar = new javax.swing.ButtonGroup();
        BG_Organizar_Turma = new javax.swing.ButtonGroup();
        BG_Organizar_Disciplina = new javax.swing.ButtonGroup();
        JP_Dados_Turma = new javax.swing.JPanel();
        JP_Org_Turma = new javax.swing.JPanel();
        JRB_Cod_T = new javax.swing.JRadioButton();
        JRB_Ano = new javax.swing.JRadioButton();
        JRB_Turno = new javax.swing.JRadioButton();
        JRB_Semestre = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTB_Turma = new javax.swing.JTable();
        BT_Editar_Turma = new javax.swing.JButton();
        BT_Sair = new javax.swing.JButton();
        BT_Cadastrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Curso = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        JRB_Cod = new javax.swing.JRadioButton();
        JRB_Nome = new javax.swing.JRadioButton();
        BT_Editar_Curso = new javax.swing.JButton();
        JP_Dados_Disciplinas = new javax.swing.JPanel();
        JP_Org_Disciplina = new javax.swing.JPanel();
        JRB_Nome_D = new javax.swing.JRadioButton();
        JRB_Semestre_D = new javax.swing.JRadioButton();
        BT_Editar_Disciplina = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTB_Disciplina = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Consulta De Turma E Curso");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Curso 24x24.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(545, 413));
        setMinimumSize(new java.awt.Dimension(545, 413));
        setPreferredSize(new java.awt.Dimension(545, 413));
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

        JP_Dados_Turma.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Turma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JP_Org_Turma.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Organizar Por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        BG_Organizar_Turma.add(JRB_Cod_T);
        JRB_Cod_T.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Cod_T.setText("Código");
        JRB_Cod_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_Cod_TActionPerformed(evt);
            }
        });

        BG_Organizar_Turma.add(JRB_Ano);
        JRB_Ano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Ano.setText("Ano");
        JRB_Ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_AnoActionPerformed(evt);
            }
        });

        BG_Organizar_Turma.add(JRB_Turno);
        JRB_Turno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Turno.setText("Turno");
        JRB_Turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_TurnoActionPerformed(evt);
            }
        });

        BG_Organizar_Turma.add(JRB_Semestre);
        JRB_Semestre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Semestre.setText("Semestre");
        JRB_Semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_SemestreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Org_TurmaLayout = new javax.swing.GroupLayout(JP_Org_Turma);
        JP_Org_Turma.setLayout(JP_Org_TurmaLayout);
        JP_Org_TurmaLayout.setHorizontalGroup(
            JP_Org_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Org_TurmaLayout.createSequentialGroup()
                .addGroup(JP_Org_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Org_TurmaLayout.createSequentialGroup()
                        .addComponent(JRB_Cod_T)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JRB_Turno))
                    .addGroup(JP_Org_TurmaLayout.createSequentialGroup()
                        .addComponent(JRB_Semestre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JRB_Ano)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_Org_TurmaLayout.setVerticalGroup(
            JP_Org_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Org_TurmaLayout.createSequentialGroup()
                .addGroup(JP_Org_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRB_Cod_T)
                    .addComponent(JRB_Turno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Org_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRB_Semestre)
                    .addComponent(JRB_Ano)))
        );

        JTB_Turma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Turma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Turma.setToolTipText("Clique Duas Vezes Na Turma Para Editar Os Dados");
        JTB_Turma.getTableHeader().setReorderingAllowed(false);
        JTB_Turma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_TurmaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTB_Turma);

        BT_Editar_Turma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar.png"))); // NOI18N
        BT_Editar_Turma.setMnemonic('r');
        BT_Editar_Turma.setToolTipText("Clique Para Sair Ou Pressione Alt + R");
        BT_Editar_Turma.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar press.png"))); // NOI18N
        BT_Editar_Turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Editar_TurmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Dados_TurmaLayout = new javax.swing.GroupLayout(JP_Dados_Turma);
        JP_Dados_Turma.setLayout(JP_Dados_TurmaLayout);
        JP_Dados_TurmaLayout.setHorizontalGroup(
            JP_Dados_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_TurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(JP_Dados_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Dados_TurmaLayout.createSequentialGroup()
                        .addComponent(BT_Editar_Turma, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JP_Org_Turma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JP_Dados_TurmaLayout.setVerticalGroup(
            JP_Dados_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_TurmaLayout.createSequentialGroup()
                .addGroup(JP_Dados_TurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JP_Dados_TurmaLayout.createSequentialGroup()
                        .addComponent(JP_Org_Turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BT_Editar_Turma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
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

        BT_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cadastrar.png"))); // NOI18N
        BT_Cadastrar.setMnemonic('d');
        BT_Cadastrar.setToolTipText("Clique Para Cadastrar Novo Usuario Ou Pressione Alt + D");
        BT_Cadastrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cadastrar Press.png"))); // NOI18N
        BT_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CadastrarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTB_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Curso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Curso.setToolTipText("Clique Duas Vezes No Curso Para Editar Os Dados");
        JTB_Curso.getTableHeader().setReorderingAllowed(false);
        JTB_Curso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_CursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Curso);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Organizar Por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        BG_Organizar.add(JRB_Cod);
        JRB_Cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Cod.setText("Código");
        JRB_Cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_CodActionPerformed(evt);
            }
        });

        BG_Organizar.add(JRB_Nome);
        JRB_Nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Nome.setText("Nome");
        JRB_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_NomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JRB_Cod)
                    .addComponent(JRB_Nome))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(JRB_Cod)
                .addGap(0, 0, 0)
                .addComponent(JRB_Nome))
        );

        BT_Editar_Curso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar.png"))); // NOI18N
        BT_Editar_Curso.setMnemonic('r');
        BT_Editar_Curso.setToolTipText("Clique Para Sair Ou Pressione Alt + R");
        BT_Editar_Curso.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar press.png"))); // NOI18N
        BT_Editar_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Editar_CursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Editar_Curso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BT_Editar_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        JP_Dados_Disciplinas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Disciplina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JP_Org_Disciplina.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Organizar Por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        BG_Organizar_Disciplina.add(JRB_Nome_D);
        JRB_Nome_D.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Nome_D.setText("Nome");
        JRB_Nome_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_Nome_DActionPerformed(evt);
            }
        });

        BG_Organizar_Disciplina.add(JRB_Semestre_D);
        JRB_Semestre_D.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Semestre_D.setText("Semestre");
        JRB_Semestre_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_Semestre_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Org_DisciplinaLayout = new javax.swing.GroupLayout(JP_Org_Disciplina);
        JP_Org_Disciplina.setLayout(JP_Org_DisciplinaLayout);
        JP_Org_DisciplinaLayout.setHorizontalGroup(
            JP_Org_DisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Org_DisciplinaLayout.createSequentialGroup()
                .addGroup(JP_Org_DisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JRB_Nome_D)
                    .addComponent(JRB_Semestre_D))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        JP_Org_DisciplinaLayout.setVerticalGroup(
            JP_Org_DisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Org_DisciplinaLayout.createSequentialGroup()
                .addComponent(JRB_Nome_D)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JRB_Semestre_D))
        );

        BT_Editar_Disciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar.png"))); // NOI18N
        BT_Editar_Disciplina.setMnemonic('r');
        BT_Editar_Disciplina.setToolTipText("Clique Para Sair Ou Pressione Alt + R");
        BT_Editar_Disciplina.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar press.png"))); // NOI18N
        BT_Editar_Disciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Editar_DisciplinaActionPerformed(evt);
            }
        });

        JTB_Disciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Disciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Disciplina.setToolTipText("Clique Duas Vezes Na Disciplina Para Editar Os Dados");
        JTB_Disciplina.getTableHeader().setReorderingAllowed(false);
        JTB_Disciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_DisciplinaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JTB_Disciplina);

        javax.swing.GroupLayout JP_Dados_DisciplinasLayout = new javax.swing.GroupLayout(JP_Dados_Disciplinas);
        JP_Dados_Disciplinas.setLayout(JP_Dados_DisciplinasLayout);
        JP_Dados_DisciplinasLayout.setHorizontalGroup(
            JP_Dados_DisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_DisciplinasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Dados_DisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Dados_DisciplinasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BT_Editar_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JP_Org_Disciplina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JP_Dados_DisciplinasLayout.setVerticalGroup(
            JP_Dados_DisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_DisciplinasLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(JP_Dados_DisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(JP_Dados_DisciplinasLayout.createSequentialGroup()
                        .addComponent(JP_Org_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BT_Editar_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BT_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JP_Dados_Turma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JP_Dados_Disciplinas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(JP_Dados_Turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(JP_Dados_Disciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        setBounds(20, 20, 805, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void JRB_CodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_CodActionPerformed
        Preencher_Tabela_Curso("select * from curso where situacao_curso = 'ATIVO' order by id_curso");
        Desabilita_RB_Turma();
        Desabilita_RB_Disciplina();
        Limpar_Tabela(JTB_Turma);
        Limpar_Tabela(JTB_Disciplina);
        BT_Editar_Curso.setEnabled(false);

    }//GEN-LAST:event_JRB_CodActionPerformed

    private void JRB_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_NomeActionPerformed
        Preencher_Tabela_Curso("select * from curso where situacao_curso = 'ATIVO' order by nome_curso");
        Desabilita_RB_Turma();
        Desabilita_RB_Disciplina();
        Limpar_Tabela(JTB_Turma);
        Limpar_Tabela(JTB_Disciplina);
        BT_Editar_Curso.setEnabled(false);
    }//GEN-LAST:event_JRB_NomeActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void JTB_CursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_CursoMouseClicked
        try {
            int Sel_Curso = JTB_Curso.getSelectedRow();
            if (Sel_Curso >= 0) {
                BT_Editar_Curso.setEnabled(true);
                BT_Editar_Turma.setEnabled(false);
                BT_Editar_Disciplina.setEnabled(false);
                Habilita_RB_Disciplina();
                Habilita_RB_Turma();
                Object resultado = JTB_Curso.getValueAt(JTB_Curso.getSelectedRow(), 0);
                Preencher_Tabela_Turma("select * from curso inner join turma on "
                        + "turma.curso_id_curso = curso.id_curso where turma.situacao_turma = 'ATIVO' and curso.id_curso =" + resultado + "");
                Preencher_Tabela_Disciplina("select * from disciplina where situacao_disciplina = 'ATIVO' and curso_id_curso =" + resultado + " order by semestre");
                if (evt.getClickCount() == 2) {
                    dispose();
                    Tela_Cadastro_Curso_Edit ObjCurso = new Tela_Cadastro_Curso_Edit();
                    Tela_Principal.getPainel().add(ObjCurso);
                    ObjCurso.setVisible(true);
                    ObjCurso.setPosicao();
                    ObjControleCurso.Consulta_Curso(ObjModCurso, resultado);
                    ObjCurso.Setar_Campos_Curso(resultado);
                    ObjCurso.Obj = new Tela_Cadastro_Curso_Edit();
                }
            }
        } catch (HeadlessException ex) {

        }
    }//GEN-LAST:event_JTB_CursoMouseClicked

    private void BT_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CadastrarActionPerformed
        Tela_Cadastro_Curso_Turma obj = new Tela_Cadastro_Curso_Turma();
        obj.Open_Tela();
        dispose();
    }//GEN-LAST:event_BT_CadastrarActionPerformed

    private void JRB_Cod_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_Cod_TActionPerformed
        try {
            Object resultado = JTB_Curso.getValueAt(JTB_Curso.getSelectedRow(), 0);
            Preencher_Tabela_Turma("select* from curso inner join turma on "
                    + "turma.curso_id_curso = curso.id_curso where turma.situacao_turma = 'ATIVO' and "
                    + "curso.id_curso =" + resultado + " order by turma.id_turma");

        } catch (HeadlessException ex) {
        }
    }//GEN-LAST:event_JRB_Cod_TActionPerformed

    private void JRB_AnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_AnoActionPerformed
        try {
            Object resultado = JTB_Curso.getValueAt(JTB_Curso.getSelectedRow(), 0);
            Preencher_Tabela_Turma("select* from curso inner join turma on "
                    + "turma.curso_id_curso = curso.id_curso where turma.situacao_turma = 'ATIVO' and "
                    + "curso.id_curso =" + resultado + " order by turma.ano_turma");

        } catch (HeadlessException ex) {
        }
    }//GEN-LAST:event_JRB_AnoActionPerformed

    private void JTB_TurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_TurmaMouseClicked
        try {
            int Sel_Turma = JTB_Turma.getSelectedRow();
            if (Sel_Turma >= 0) {
                BT_Editar_Turma.setEnabled(true);
                BT_Editar_Disciplina.setEnabled(false);
                JRB_Semestre_D.setSelected(true);
                Object semestre_turma = JTB_Turma.getValueAt(JTB_Turma.getSelectedRow(), 1);
                Object id_curso = JTB_Curso.getValueAt(JTB_Curso.getSelectedRow(), 0);
                Preencher_Tabela_Disciplina("select * from disciplina where situacao_disciplina = 'ATIVO' "
                        + "and semestre =" + semestre_turma + " and curso_id_curso =" + id_curso + " order by semestre");

                if (evt.getClickCount() == 2) {
                    dispose();
                    Object id_turma = JTB_Turma.getValueAt(JTB_Turma.getSelectedRow(), 0);
                    Tela_Cadastro_Turma_Edit ObjTurma = new Tela_Cadastro_Turma_Edit();
                    Tela_Principal.getPainel().add(ObjTurma);
                    ObjTurma.setVisible(true);
                    ObjTurma.setPosicao();
                    ObjTurma.Setar_Campos_Turma(id_turma);
                    ObjTurma.Obj = new Tela_Cadastro_Turma_Edit();
                }
            }

        } catch (HeadlessException ex) {
        }
    }//GEN-LAST:event_JTB_TurmaMouseClicked

    private void JRB_TurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_TurnoActionPerformed
        try {
            Object resultado = JTB_Curso.getValueAt(JTB_Curso.getSelectedRow(), 0);
            Preencher_Tabela_Turma("select* from curso inner join turma on "
                    + "turma.curso_id_curso = curso.id_curso where turma.situacao_turma = 'ATIVO' and "
                    + "curso.id_curso =" + resultado + " order by turma.turno");

        } catch (HeadlessException ex) {
        }
    }//GEN-LAST:event_JRB_TurnoActionPerformed

    private void JRB_SemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_SemestreActionPerformed
        try {
            Object resultado = JTB_Curso.getValueAt(JTB_Curso.getSelectedRow(), 0);
            Preencher_Tabela_Turma("select* from curso inner join turma on "
                    + "turma.curso_id_curso = curso.id_curso where turma.situacao_turma = 'ATIVO' "
                    + "and curso.id_curso =" + resultado + " order by turma.semestre");

        } catch (HeadlessException ex) {
        }
    }//GEN-LAST:event_JRB_SemestreActionPerformed

    private void BT_Editar_TurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Editar_TurmaActionPerformed
        dispose();
        Object id_turma = JTB_Turma.getValueAt(JTB_Turma.getSelectedRow(), 0);
        Tela_Cadastro_Turma_Edit ObjTurma = new Tela_Cadastro_Turma_Edit();
        Tela_Principal.getPainel().add(ObjTurma);
        ObjTurma.setVisible(true);
        ObjTurma.setPosicao();
        ObjTurma.Setar_Campos_Turma(id_turma);
        ObjTurma.Obj = new Tela_Cadastro_Turma_Edit();
    }//GEN-LAST:event_BT_Editar_TurmaActionPerformed

    private void BT_Editar_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Editar_CursoActionPerformed
        dispose();
        Object resultado = JTB_Curso.getValueAt(JTB_Curso.getSelectedRow(), 0);
        Tela_Cadastro_Curso_Edit ObjCurso = new Tela_Cadastro_Curso_Edit();
        Tela_Principal.getPainel().add(ObjCurso);
        ObjCurso.setVisible(true);
        ObjCurso.setPosicao();
        ObjCurso.Setar_Campos_Curso(resultado);
        ObjCurso.Obj = new Tela_Cadastro_Curso_Edit();
    }//GEN-LAST:event_BT_Editar_CursoActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JRB_Nome_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_Nome_DActionPerformed
        try {
            Object resultado = JTB_Curso.getValueAt(JTB_Curso.getSelectedRow(), 0);
            Preencher_Tabela_Disciplina("select * from disciplina where situacao_disciplina = 'ATIVO' "
                    + "and curso_id_curso =" + resultado + " order by disciplina");
        } catch (HeadlessException ex) {
        }
    }//GEN-LAST:event_JRB_Nome_DActionPerformed

    private void JRB_Semestre_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_Semestre_DActionPerformed
        try {
            Object resultado = JTB_Curso.getValueAt(JTB_Curso.getSelectedRow(), 0);
            Preencher_Tabela_Disciplina("select * from disciplina where situacao_disciplina = 'ATIVO' "
                    + "and curso_id_curso =" + resultado + " order by semestre");
        } catch (HeadlessException ex) {
        }
    }//GEN-LAST:event_JRB_Semestre_DActionPerformed

    private void BT_Editar_DisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Editar_DisciplinaActionPerformed
        dispose();
        Object id_disciplina = JTB_Disciplina.getValueAt(JTB_Disciplina.getSelectedRow(), 0);
        Tela_Cadastro_Disciplina_Edit ObjDisciplina = new Tela_Cadastro_Disciplina_Edit();
        Tela_Principal.getPainel().add(ObjDisciplina);
        ObjDisciplina.setVisible(true);
        ObjDisciplina.setPosicao();
        ObjDisciplina.Setar_Campos(id_disciplina);
        ObjDisciplina.Obj = new Tela_Cadastro_Disciplina_Edit();
    }//GEN-LAST:event_BT_Editar_DisciplinaActionPerformed

    private void JTB_DisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_DisciplinaMouseClicked
        try {
            int Sel_Disciplina = JTB_Disciplina.getSelectedRow();
            if (Sel_Disciplina >= 0) {
                BT_Editar_Disciplina.setEnabled(true);
                JRB_Semestre_D.setSelected(true);
                Object id_disciplina = JTB_Disciplina.getValueAt(JTB_Disciplina.getSelectedRow(), 0);
                
                if (evt.getClickCount() == 2) {
                    dispose();
                    Tela_Cadastro_Disciplina_Edit ObjDisciplina = new Tela_Cadastro_Disciplina_Edit();
                    Tela_Principal.getPainel().add(ObjDisciplina);
                    ObjDisciplina.setVisible(true);
                    ObjDisciplina.setPosicao();
                    ObjDisciplina.Setar_Campos(id_disciplina);
                    ObjDisciplina.Obj = new Tela_Cadastro_Disciplina_Edit();
                }
            }
        } catch (HeadlessException ex) {
        }
    }//GEN-LAST:event_JTB_DisciplinaMouseClicked

    public final void Desabilita_RB_Turma() {
        JRB_Cod_T.setEnabled(false);
        JRB_Ano.setEnabled(false);
        JRB_Semestre.setEnabled(false);
        JRB_Turno.setEnabled(false);
        JP_Org_Turma.setEnabled(false);
    }

    public void Habilita_RB_Turma() {
        JRB_Cod_T.setEnabled(!false);
        JRB_Ano.setEnabled(!false);
        JRB_Semestre.setEnabled(!false);
        JRB_Turno.setEnabled(!false);
        JP_Org_Turma.setEnabled(!false);
        JRB_Cod_T.setSelected(true);
    }

    public final void Desabilita_RB_Disciplina() {
        JRB_Semestre_D.setEnabled(false);
        JRB_Nome_D.setEnabled(false);
        JP_Org_Disciplina.setEnabled(false);
    }

    public void Habilita_RB_Disciplina() {
        JRB_Semestre_D.setEnabled(!false);
        JRB_Semestre_D.setSelected(true);
        JRB_Nome_D.setEnabled(!false);
        JP_Org_Disciplina.setEnabled(!false);
    }

    public final void Preencher_Tabela_Curso(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Curso", "Abreviatura"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();

            do {
                dados.add(new Object[]{ObjConecta.rs.getInt("id_curso"), ObjConecta.rs.getString("nome_curso"),
                    ObjConecta.rs.getString("Abrev_curso")});
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Curso.setModel(tabela);
        JTB_Curso.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Curso.getColumnModel().getColumn(0).setPreferredWidth(90);//Tamanho da coluna
        JTB_Curso.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Curso.getColumnModel().getColumn(1).setPreferredWidth(380);
        JTB_Curso.getColumnModel().getColumn(1).setResizable(false);
        JTB_Curso.getColumnModel().getColumn(2).setPreferredWidth(98);
        JTB_Curso.getColumnModel().getColumn(2).setResizable(false);
        JTB_Curso.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Curso.setAutoResizeMode(JTB_Curso.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(todas colunas)
        JTB_Curso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
    }

    public final void Preencher_Tabela_Turma(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Semestre", "Turma", "Turno", "Ano", "Vestibular","Turma"};//Seta os indices da tabela
        ObjConecta_2.Conectar();
        ObjConecta_2.ExecutaSQL(SQL);
        try {
            ObjConecta_2.rs.first();

            do {
                dados.add(new Object[]{ObjConecta_2.rs.getInt("id_turma"), ObjConecta_2.rs.getInt("semestre"),
                    ObjConecta_2.rs.getString("abrev_curso"), ObjConecta_2.rs.getString("turno"), ObjConecta_2.rs.getString("ano_turma"),
                    ObjConecta_2.rs.getString("semestre_vestibular"), ObjConecta_2.rs.getString("turma")});
            } while (ObjConecta_2.rs.next());
            ObjConecta_2.Desconecta();
        } catch (SQLException ex) {
            ObjConecta_2.Desconecta();
            //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Turma.setModel(tabela);
        JTB_Turma.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Turma.getColumnModel().getColumn(0).setPreferredWidth(90);//Tamanho da coluna
        JTB_Turma.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Turma.getColumnModel().getColumn(1).setPreferredWidth(95);
        JTB_Turma.getColumnModel().getColumn(1).setResizable(false);
        JTB_Turma.getColumnModel().getColumn(2).setPreferredWidth(95);
        JTB_Turma.getColumnModel().getColumn(2).setResizable(false);
        JTB_Turma.getColumnModel().getColumn(3).setPreferredWidth(95);
        JTB_Turma.getColumnModel().getColumn(3).setResizable(false);
        JTB_Turma.getColumnModel().getColumn(4).setPreferredWidth(95);
        JTB_Turma.getColumnModel().getColumn(4).setResizable(false);
        JTB_Turma.getColumnModel().getColumn(5).setPreferredWidth(95);
        JTB_Turma.getColumnModel().getColumn(5).setResizable(false);
        JTB_Turma.getColumnModel().getColumn(6).setPreferredWidth(95);
        JTB_Turma.getColumnModel().getColumn(6).setResizable(false);
        JTB_Turma.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Turma.setAutoResizeMode(JTB_Turma.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(todas colunas)
        JTB_Turma.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
    }

    public final void Preencher_Tabela_Disciplina(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Semestre", "Disciplina"};//Seta os indices da tabela
        ObjConecta_2.Conectar();
        ObjConecta_2.ExecutaSQL(SQL);
        try {
            ObjConecta_2.rs.first();

            do {
                dados.add(new Object[]{ObjConecta_2.rs.getInt("id_disciplina"), ObjConecta_2.rs.getInt("semestre"),
                    ObjConecta_2.rs.getString("disciplina")});
            } while (ObjConecta_2.rs.next());
            ObjConecta_2.Desconecta();
        } catch (SQLException ex) {
            ObjConecta_2.Desconecta();
            //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Disciplina.setModel(tabela);
        JTB_Disciplina.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Disciplina.getColumnModel().getColumn(0).setPreferredWidth(90);//Tamanho da coluna
        JTB_Disciplina.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Disciplina.getColumnModel().getColumn(1).setPreferredWidth(95);
        JTB_Disciplina.getColumnModel().getColumn(1).setResizable(false);
        JTB_Disciplina.getColumnModel().getColumn(2).setPreferredWidth(380);
        JTB_Disciplina.getColumnModel().getColumn(2).setResizable(false);
        JTB_Disciplina.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Disciplina.setAutoResizeMode(JTB_Turma.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(todas colunas)
        JTB_Disciplina.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela     
    }

    public final void Limpar_Tabela(JTable tb) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{};//Seta os indices da tabela
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        tb.setModel(tabela);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_Organizar;
    private javax.swing.ButtonGroup BG_Organizar_Disciplina;
    private javax.swing.ButtonGroup BG_Organizar_Turma;
    private javax.swing.JButton BT_Cadastrar;
    private javax.swing.JButton BT_Editar_Curso;
    private javax.swing.JButton BT_Editar_Disciplina;
    private javax.swing.JButton BT_Editar_Turma;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JPanel JP_Dados_Disciplinas;
    private javax.swing.JPanel JP_Dados_Turma;
    private javax.swing.JPanel JP_Org_Disciplina;
    private javax.swing.JPanel JP_Org_Turma;
    private javax.swing.JRadioButton JRB_Ano;
    private javax.swing.JRadioButton JRB_Cod;
    private javax.swing.JRadioButton JRB_Cod_T;
    private javax.swing.JRadioButton JRB_Nome;
    private javax.swing.JRadioButton JRB_Nome_D;
    private javax.swing.JRadioButton JRB_Semestre;
    private javax.swing.JRadioButton JRB_Semestre_D;
    private javax.swing.JRadioButton JRB_Turno;
    private javax.swing.JTable JTB_Curso;
    private javax.swing.JTable JTB_Disciplina;
    private javax.swing.JTable JTB_Turma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

}

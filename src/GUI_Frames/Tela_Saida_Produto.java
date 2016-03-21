package GUI_Frames;

import Classes.Modelo_Curso;
import Classes.Modelo_Disciplina;
import Classes.Modelo_Saida_Produto;
import Classes.Modelo_Turma;
import Conexao.Conecta_Banco;
import Conexao.Controle_Curso;
import Conexao.Controle_Disciplina;
import Conexao.Controle_Saida_Produto;
import Conexao.Controle_Turma;
import GUI_Dialogs_Saida.Conf_Alterar_Quant_Lote_Saida;
import GUI_Dialogs_Saida.Conf_Alterar_Quant_Saida;
import GUI_Dialogs_Saida.Conf_Excluir_Saida;
import GUI_Dialogs_Saida.Conf_Sair_Sem_Salvar_Saida;
import GUI_Dialogs_Saida.Conf_Salvar_Saida;
import GUI_Dialogs_Saida.Escolha_Lote_Saida;
import GUI_Dialogs_Saida.Escolha_Nova_Quant_Lote_Saida;
import GUI_Dialogs_Saida.Escolha_Nova_Quant_Saida;
import GUI_Dialogs_Saida.Escolha_Quant_Saida;
import GUI_Dialogs_Saida.Inf_Dados_Nao_Salvos_Saida;
import GUI_Dialogs_Saida.Inf_Dados_Salvos_Saida;
import GUI_Dialogs_Saida.Inf_Nao_Existe_Linha_Saida;
import GUI_Dialogs_Saida.Inf_Nao_Ha_Itens_Salvar_Saida;
import GUI_Dialogs_Saida.Inf_Preencher_Campos_Saida;
import GUI_Dialogs_Saida.Inf_Produto_Existente_Lote_Saida;
import GUI_Dialogs_Saida.Inf_Produto_Existente_Saida;
import GUI_Dialogs_Saida.Inf_Quant_Invalida_Saida;
import GUI_Dialogs_Saida.Inf_Quant_Maior_Saida;
import GUI_Dialogs_Saida.Inf_Selecione_Linha_Excluir_Saida;
import GUI_Dialogs_Saida.Inf_Selecione_Linha_Saida;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

// @author Márison Tamiarana

public class Tela_Saida_Produto extends javax.swing.JInternalFrame {
    
public static Tela_Saida_Produto Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Saida_Produto();
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
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Controle_Curso ObjControleCurso = new Controle_Curso();
    Controle_Turma ObjControleTurma = new Controle_Turma();
    Controle_Disciplina ObjControleDisciplina = new Controle_Disciplina();
    Modelo_Curso ObjModeloCurso = new Modelo_Curso();
    Modelo_Turma ObjModeloTurma = new Modelo_Turma();
    Modelo_Disciplina ObjModeloDisciplina = new Modelo_Disciplina();
    Formatacao ObjFormat = new Formatacao();
    Modelo_Saida_Produto ObjModeloSaida = new Modelo_Saida_Produto();
    Controle_Saida_Produto ObjControleSaida = new Controle_Saida_Produto();
    //telas dialogs
    private static Tela_Consulta_Produto_Saida_DL ObjProdSaida;
    private static Escolha_Lote_Saida ObjEscolhaLote;
    private static Escolha_Nova_Quant_Lote_Saida ObjNovaQuantLote;
    private static Escolha_Nova_Quant_Saida ObjNovaQuant;
    public static Conf_Alterar_Quant_Lote_Saida ObjAlterarQuantLote;
    public static Conf_Alterar_Quant_Saida ObjAlterarQuant;
    public static Escolha_Quant_Saida ObjQuantSaida;
    //
    private static Inf_Preencher_Campos_Saida ObjPreencherCampos;
    private static Inf_Dados_Salvos_Saida ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_Saida ObjDadosNaoSalvos;
    private static Conf_Salvar_Saida ObjConfSalvar;
    private static Conf_Sair_Sem_Salvar_Saida ObjSairSemSalvar;
    private static Inf_Produto_Existente_Saida ObjProdExistente;
    private static Inf_Produto_Existente_Lote_Saida ObjProdExistenteLote;
    private static Inf_Quant_Invalida_Saida ObjQuantInvalida;
    private static Inf_Selecione_Linha_Saida ObjSelecioneLinha;
    private static Inf_Selecione_Linha_Excluir_Saida ObjSelecioneLinhaExcluir;
    private static Inf_Nao_Existe_Linha_Saida ObjNaoExisteLinha;
    private static Inf_Nao_Ha_Itens_Salvar_Saida ObjNaoHaItensSalvar;
    private static Conf_Excluir_Saida ObjExcluir;
    private static Inf_Quant_Maior_Saida ObjQuantMaior;
    
    public String Pesquisa;
    public double Quantidade=0;
    public String num_lote;
    public boolean controla_lote = false;
    public boolean controla_prod = false;
    public int numero_linha;
    public double quant_retirada = 0;
    public double quant_disponivel;
    public int id_produto;
    public String unidade;
    public double quantidade_sem_lote=0;
    public boolean confirma_saida;
    int cont_turma= -1;
    public double quantidade_na_tabela=0;
    
    public Tela_Saida_Produto() {
        initComponents();
        Preencher_CB_Curso();
        JCB_Ano.setEnabled(false);
        JCB_Turno.setEnabled(false);
        JCB_Tipo.setEnabled(false);
        JCB_Disciplina.setEnabled(false);
        JCB_Semestre.setEnabled(false);
        JCB_Vestibular.setEnabled(false);
        JCB_Turma.setEnabled(false);
        JTF_Cod.setEnabled(false);
        JTF_Quant.setEnabled(false);
        JTF_Validade.setEnabled(false);
        JTF_Lote.setEnabled(false);
        JTF_Un.setEnabled(false);
        JTF_Observacao.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Descricao.setDocument(ObjFormat.new Format_Geral(100));
        JTB_Saida_Itens.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        Setar_Atalho_BT();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JCB_Curso = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        JCB_Ano = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        JTF_Observacao = new javax.swing.JTextField();
        JCB_Turno = new javax.swing.JComboBox();
        JCB_Tipo = new javax.swing.JComboBox();
        JCB_Disciplina = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JCB_Semestre = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        JCB_Vestibular = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        JCB_Turma = new javax.swing.JComboBox();
        BT_Sair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JTF_Cod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTF_Descricao = new javax.swing.JTextField();
        BT_Procurar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        JTF_Quant = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JTF_Lote = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTF_Validade = new javax.swing.JTextField();
        BT_Adicionar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        JTF_Un = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Saida_Itens = new javax.swing.JTable();
        JL_Quant_Itens = new javax.swing.JLabel();
        JL_Campos = new javax.swing.JLabel();
        BT_Excluir = new javax.swing.JButton();
        BT_Salvar = new javax.swing.JButton();
        JL_Quant_Item = new javax.swing.JLabel();
        JL_Quant_Itens1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Saída De Produto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Saida Mercadoria 24x24.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(920, 560));
        setMinimumSize(new java.awt.Dimension(920, 560));
        setPreferredSize(new java.awt.Dimension(920, 560));
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Descrição Da Saída", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JCB_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_CursoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Curso*:");

        JCB_Ano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_AnoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Obs:");

        JTF_Observacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JCB_Turno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_TurnoActionPerformed(evt);
            }
        });

        JCB_Tipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_TipoActionPerformed(evt);
            }
        });

        JCB_Disciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Disciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_DisciplinaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tipo*:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Ano*:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Turno*:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Disciplina*:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Semestre*:");

        JCB_Semestre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_SemestreActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Vestibular*:");

        JCB_Vestibular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Vestibular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_VestibularActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Turma*:");

        JCB_Turma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_TurmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCB_Curso, 0, 176, Short.MAX_VALUE)
                            .addComponent(JCB_Tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JCB_Turno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JCB_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JCB_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JCB_Vestibular, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JCB_Turma, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JCB_Disciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(JTF_Observacao))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JCB_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(JCB_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(JCB_Vestibular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(JCB_Turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCB_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Observacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Descrição Dos Itens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código:");

        JTF_Cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Produto*:");

        JTF_Descricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_DescricaoActionPerformed(evt);
            }
        });

        BT_Procurar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BT_Procurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Search_24x24.png"))); // NOI18N
        BT_Procurar.setText("Consultar(F3)");
        BT_Procurar.setToolTipText("Clique Para Pesquisar Um Produto");
        BT_Procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ProcurarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Quantidade*:");

        JTF_Quant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Lote*:");

        JTF_Lote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Validade*:");

        JTF_Validade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        BT_Adicionar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BT_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Add_24x24.png"))); // NOI18N
        BT_Adicionar.setMnemonic('+');
        BT_Adicionar.setText("Adicionar(F4)");
        BT_Adicionar.setToolTipText("Clique Para Adicinar O Produto");
        BT_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AdicionarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Unidade:");

        JTF_Un.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Quant, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JTF_Validade)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_Un, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JTF_Descricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BT_Adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_Procurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Procurar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(JTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(JTF_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(JTF_Quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(JTF_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTF_Validade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8)
                        .addComponent(JTF_Un, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BT_Adicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTB_Saida_Itens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Saida_Itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade", "Validade", "Lote", "Un"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTB_Saida_Itens.getTableHeader().setReorderingAllowed(false);
        JTB_Saida_Itens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_Saida_ItensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Saida_Itens);
        if (JTB_Saida_Itens.getColumnModel().getColumnCount() > 0) {
            JTB_Saida_Itens.getColumnModel().getColumn(0).setResizable(false);
            JTB_Saida_Itens.getColumnModel().getColumn(0).setPreferredWidth(100);
            JTB_Saida_Itens.getColumnModel().getColumn(1).setResizable(false);
            JTB_Saida_Itens.getColumnModel().getColumn(1).setPreferredWidth(400);
            JTB_Saida_Itens.getColumnModel().getColumn(2).setResizable(false);
            JTB_Saida_Itens.getColumnModel().getColumn(2).setPreferredWidth(100);
            JTB_Saida_Itens.getColumnModel().getColumn(3).setResizable(false);
            JTB_Saida_Itens.getColumnModel().getColumn(3).setPreferredWidth(100);
            JTB_Saida_Itens.getColumnModel().getColumn(4).setResizable(false);
            JTB_Saida_Itens.getColumnModel().getColumn(4).setPreferredWidth(100);
            JTB_Saida_Itens.getColumnModel().getColumn(5).setResizable(false);
            JTB_Saida_Itens.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        JL_Quant_Itens.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens.setText("Quantidade De Itens:");

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        BT_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Excluir.png"))); // NOI18N
        BT_Excluir.setMnemonic('x');
        BT_Excluir.setToolTipText("Selecione Uma Linha E Clique Para Excluir O Iten Ou Pressione Alt + X");
        BT_Excluir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Excluir Press.png"))); // NOI18N
        BT_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ExcluirActionPerformed(evt);
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

        JL_Quant_Item.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Item.setText("0");

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Sair | F9 - Excluir Linha | F10 - Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JL_Quant_Itens)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JL_Quant_Item, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JL_Quant_Itens1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(JL_Campos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JL_Quant_Itens1)
                            .addComponent(JL_Campos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JL_Quant_Itens)
                            .addComponent(JL_Quant_Item)))
                    .addComponent(BT_Salvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Excluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(992, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Sair_Sem_Salvar();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JCB_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_CursoActionPerformed
        if(JCB_Curso.getSelectedIndex()<=0){
            JCB_Turno.setEnabled(!true);
            JCB_Turno.removeAllItems(); 
            JCB_Ano.setEnabled(!true);
            JCB_Ano.removeAllItems();
            JCB_Semestre.setEnabled(!true);
            JCB_Semestre.removeAllItems();
            JCB_Vestibular.setEnabled(!true);
            JCB_Vestibular.removeAllItems();
            JCB_Tipo.setEnabled(!true);
            JCB_Tipo.removeAllItems();
            JCB_Disciplina.setEnabled(!true);
            JCB_Disciplina.removeAllItems();
            JCB_Turma.setEnabled(!true);
            JCB_Turma.removeAllItems();
        }
        if(JCB_Curso.getSelectedIndex()>0){ 
            if(JCB_Curso.getSelectedItem().equals("OUTROS")){
                JCB_Turno.setEnabled(!true);
                JCB_Turno.removeAllItems();
                JCB_Turno.addItem("OUTROS");
                JCB_Ano.setEnabled(!true);
                JCB_Ano.removeAllItems();
                JCB_Ano.addItem("OUTROS");
                JCB_Semestre.setEnabled(!true);
                JCB_Semestre.removeAllItems();
                JCB_Semestre.addItem("OUTROS");
                JCB_Vestibular.setEnabled(!true);
                JCB_Vestibular.removeAllItems();
                JCB_Vestibular.addItem("OUTROS");
                JCB_Tipo.setEnabled(!true);
                JCB_Tipo.removeAllItems();
                JCB_Tipo.addItem("OUTROS");
                JCB_Disciplina.setEnabled(!true);
                JCB_Disciplina.removeAllItems();
                JCB_Disciplina.addItem("OUTROS");
            }else{
            JCB_Turno.setEnabled(true);
            Preencher_CB_Turno();
            }
        }
        
    }//GEN-LAST:event_JCB_CursoActionPerformed

    private void JCB_AnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_AnoActionPerformed
        if(JCB_Ano.getSelectedIndex()>0){ 
            JCB_Semestre.setEnabled(true);
            ObjControleCurso.Procura_Id_Curso(ObjModeloCurso, JCB_Curso);
            ObjControleTurma.Preencher_CB_Semestre(JCB_Semestre,ObjModeloCurso.getId_curso(),JCB_Turno.getSelectedItem().toString(),JCB_Ano.getSelectedItem().toString());
            
        }
        if(JCB_Ano.getSelectedIndex()==0){
            JCB_Semestre.setEnabled(!true);
            JCB_Semestre.removeAllItems();
            JCB_Vestibular.setEnabled(!true);
            JCB_Vestibular.removeAllItems();
            JCB_Tipo.setEnabled(!true);
            JCB_Tipo.removeAllItems();
            JCB_Disciplina.setEnabled(!true);
            JCB_Disciplina.removeAllItems();
            JCB_Turma.setEnabled(!true);
            JCB_Turma.removeAllItems();
            
        }
    }//GEN-LAST:event_JCB_AnoActionPerformed

    private void JTF_DescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_DescricaoActionPerformed
        Pesquisa = JTF_Descricao.getText().trim();
        Mostrar_Pesquisa_Produto();
        
    }//GEN-LAST:event_JTF_DescricaoActionPerformed

    private void BT_ProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ProcurarActionPerformed
        Pesquisa = JTF_Descricao.getText().trim();
        Quantidade = 0;
        Mostrar_Pesquisa_Produto();
        

    }//GEN-LAST:event_BT_ProcurarActionPerformed

    private void BT_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AdicionarActionPerformed
        if(!JTF_Cod.getText().equalsIgnoreCase("") && (!JTF_Quant.getText().equalsIgnoreCase("")))
        {
            Add_Tabela();
            Limpar_Produto();
        }else{
            Mostrar_Preencher_Campos();
        }
    }//GEN-LAST:event_BT_AdicionarActionPerformed

    private void BT_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ExcluirActionPerformed
      Remove_Item_Da_Tabela();
        
    }//GEN-LAST:event_BT_ExcluirActionPerformed

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        Testar_Campos();
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void JCB_TurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_TurnoActionPerformed
        if(JCB_Turno.getSelectedIndex()==0){
            JCB_Ano.setEnabled(!true);
            JCB_Ano.removeAllItems();
            JCB_Semestre.setEnabled(!true);
            JCB_Semestre.removeAllItems();
            JCB_Vestibular.setEnabled(!true);
            JCB_Vestibular.removeAllItems();
            JCB_Tipo.setEnabled(!true);
            JCB_Tipo.removeAllItems();
            JCB_Disciplina.setEnabled(!true);
            JCB_Disciplina.removeAllItems();
            JCB_Turma.setEnabled(!true);
            JCB_Turma.removeAllItems();
        }
        if(JCB_Turno.getSelectedIndex()>0){ 
            JCB_Ano.setEnabled(true);
            ObjControleCurso.Procura_Id_Curso(ObjModeloCurso, JCB_Curso);
            ObjControleTurma.Preencher_CB_Ano(JCB_Ano,ObjModeloCurso.getId_curso(),JCB_Turno.getSelectedItem().toString());
        }
    }//GEN-LAST:event_JCB_TurnoActionPerformed

    private void JCB_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_TipoActionPerformed
        if(JCB_Tipo.getSelectedIndex()>0){ 
            JCB_Disciplina.setEnabled(true);
            ObjControleDisciplina.Preencher_CB_Disciplina(JCB_Curso,JCB_Semestre,JCB_Disciplina);
        }
        if(JCB_Tipo.getSelectedIndex()<=0){
            JCB_Disciplina.setEnabled(!true);
            JCB_Disciplina.removeAllItems();
            
        }
    }//GEN-LAST:event_JCB_TipoActionPerformed

    private void JCB_DisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_DisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCB_DisciplinaActionPerformed

    private void JCB_SemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_SemestreActionPerformed
        if(JCB_Semestre.getSelectedIndex()>0){ 
            JCB_Vestibular.setEnabled(true);
            ObjControleCurso.Procura_Id_Curso(ObjModeloCurso, JCB_Curso);
            ObjControleTurma.Preencher_CB_Vestibular(JCB_Vestibular,ObjModeloCurso.getId_curso(), 
            JCB_Turno.getSelectedItem().toString(),JCB_Ano.getSelectedItem().toString(), JCB_Semestre.getSelectedItem().toString());
            
        }
        if(JCB_Semestre.getSelectedIndex()==0){
            JCB_Vestibular.setEnabled(!true);
            JCB_Vestibular.removeAllItems();
            JCB_Tipo.setEnabled(!true);
            JCB_Tipo.removeAllItems();
            JCB_Disciplina.setEnabled(!true);
            JCB_Disciplina.removeAllItems();
            JCB_Turma.setEnabled(!true);
            JCB_Turma.removeAllItems();
        }
    }//GEN-LAST:event_JCB_SemestreActionPerformed

    private void JCB_VestibularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_VestibularActionPerformed
        if(JCB_Vestibular.getSelectedIndex()>0){ 
            JCB_Turma.setEnabled(true);
            ObjControleCurso.Procura_Id_Curso(ObjModeloCurso, JCB_Curso);
            ObjControleTurma.Preencher_CB_Turma_Saida(JCB_Turma, ObjModeloCurso.getId_curso(),JCB_Turno.getSelectedItem().toString(),
                    JCB_Ano.getSelectedItem().toString(), JCB_Semestre.getSelectedItem().toString(),JCB_Vestibular.getSelectedItem().toString());
            cont_turma = JCB_Turma.getItemCount();
            if(cont_turma==0){
                JCB_Tipo.setEnabled(true);
                Preencher_CB_Tipo(); 
                JCB_Turma.setEnabled(false);
            }
            
        }
        if(JCB_Vestibular.getSelectedIndex()==0){
            JCB_Turma.setEnabled(!true);
            JCB_Turma.removeAllItems();
            JCB_Tipo.setEnabled(!true);
            JCB_Tipo.removeAllItems();
            JCB_Disciplina.setEnabled(!true);
            JCB_Disciplina.removeAllItems();
        }
    }//GEN-LAST:event_JCB_VestibularActionPerformed

    private void JCB_TurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_TurmaActionPerformed
        if(cont_turma>0){
            if(JCB_Turma.getSelectedIndex()>0){ 
                JCB_Tipo.setEnabled(true);
                Preencher_CB_Tipo(); 
            }    
            if(JCB_Turma.getSelectedIndex()==0){
                JCB_Tipo.setEnabled(!true);
                JCB_Tipo.removeAllItems();
                JCB_Disciplina.setEnabled(!true);
                JCB_Disciplina.removeAllItems();
            }
        }
        
        
    }//GEN-LAST:event_JCB_TurmaActionPerformed

    private void JTB_Saida_ItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Saida_ItensMouseClicked
        //JTF_Cod.requestFocus();
    }//GEN-LAST:event_JTB_Saida_ItensMouseClicked

    public final void Preencher_CB_Curso(){
        ObjControleCurso.Preencher_CB_Curso(JCB_Curso);
        //JCB_Curso.addItem("OUTROS");
    }
    void Preencher_CB_Turno(){
        JCB_Turno.removeAllItems();
        JCB_Turno.addItem(" ");
        JCB_Turno.addItem("M");
        JCB_Turno.addItem("V");
        JCB_Turno.addItem("N");
    }
    void Preencher_CB_Tipo(){
        JCB_Tipo.removeAllItems();
        JCB_Tipo.addItem(" ");
        JCB_Tipo.addItem("AULA DE CAMPO");
        JCB_Tipo.addItem("AULA DE PRÁTICA");
        JCB_Tipo.addItem("ESTÁGIO");
        JCB_Tipo.addItem("INICIAÇÃO CIENTÍFICA");
        JCB_Tipo.addItem("OUTROS");
    }
    
    public void Setar_Campo_Cod_Desc(String Desc,int cd, String un){
        JTF_Cod.setText(String.valueOf(cd));
        JTF_Descricao.setText(Desc);
        JTF_Un.setText(un);
    }
    public void Setar_Campo_Lote_Quant(String data,double quant, String lote){
        JTF_Lote.setEnabled(false);
        JTF_Quant.setEnabled(false);
        JTF_Validade.setEnabled(false);
        JTF_Quant.setText(String.valueOf(quant).replace(".", ","));
        JTF_Lote.setText(lote);
        JTF_Validade.setText(data);
    }
    public void Setar_Campo_Quant(double quant){
        JTF_Lote.setEnabled(false);
        JTF_Quant.setEnabled(false);
        JTF_Validade.setEnabled(false);
        JTF_Quant.setText(String.valueOf(quant).replace(".", ","));
    }
        
    public void Limpar_Produto(){
        JTF_Cod.setText("");
        JTF_Descricao.setText("");
        JTF_Lote.setText("");
        JTF_Validade.setText("");
        JTF_Quant.setText("");
        JTF_Descricao.requestFocus();
        JTF_Un.setText("");
    }
    public void Limpar_descricao(){
        JCB_Curso.setSelectedIndex(0);
        JTF_Observacao.setText("");
    }
    public void Remove_Item_Da_Tabela(){       
        int Sel_Linha = JTB_Saida_Itens.getSelectedRow();
        int Linha = JTB_Saida_Itens.getRowCount();
        if(Linha == 0){
            Mostrar_Nao_Existe_Linha();
        }else{
            if (Sel_Linha >= 0) {
                Mostrar_Excluir_Linha();
                }
            else{
                Mostrar_Selecione_Linha_Excluir();
            }
        }
    }
    public void Excluir_Linha(){
        (( DefaultTableModel)JTB_Saida_Itens.getModel()).removeRow(JTB_Saida_Itens.getSelectedRow());
        int cont = JTB_Saida_Itens.getRowCount();
        JL_Quant_Item.setText(String.valueOf(cont));
    }
    
    public void Alterar_Quantidade_Lote_Na_Tabela(String quant,int linha){
        String cod = String.valueOf(JTB_Saida_Itens.getValueAt(linha, 0));
        String descricao = String.valueOf(JTB_Saida_Itens.getValueAt(linha, 1));
        String data = String.valueOf(JTB_Saida_Itens.getValueAt(linha, 3));
        String lote = String.valueOf(JTB_Saida_Itens.getValueAt(linha, 4));
        String un = String.valueOf(JTB_Saida_Itens.getValueAt(linha, 5));
        
        DefaultTableModel tb = (DefaultTableModel)JTB_Saida_Itens.getModel();
        tb.addRow(new String[]{cod,descricao,quant,data,lote,un});
        JTB_Saida_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        (( DefaultTableModel)JTB_Saida_Itens.getModel()).removeRow(linha);
    }
    
    public void Alterar_Quantidade_Na_Tabela(String quant,int linha){
        String cod = String.valueOf(JTB_Saida_Itens.getValueAt(linha, 0));
        String descricao = String.valueOf(JTB_Saida_Itens.getValueAt(linha, 1));
        String data = "";
        String lote = "";
        String un = String.valueOf(JTB_Saida_Itens.getValueAt(linha, 5));
        
        DefaultTableModel tb = (DefaultTableModel)JTB_Saida_Itens.getModel();
        tb.addRow(new String[]{cod,descricao,quant,data,lote,un});
        JTB_Saida_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        (( DefaultTableModel)JTB_Saida_Itens.getModel()).removeRow(linha);
    }
    public void Quantidade_Solicitada_Lote(int linha, JLabel jl){
        jl.setText(String.valueOf(JTB_Saida_Itens.getValueAt(linha, 2)));
    }
    
     public void Add_Tabela(){
       if(JTF_Validade.getText().equalsIgnoreCase(""))
       {
            String cod = JTF_Cod.getText().trim();
            String descricao = JTF_Descricao.getText().trim();
            String quant = JTF_Quant.getText().trim().replace(",", ".");
            String lote = "";
            String data = "";
            String un = JTF_Un.getText().trim();
       
            DefaultTableModel tb = (DefaultTableModel)JTB_Saida_Itens.getModel();
            tb.addRow(new String[]{cod,descricao,quant,data,lote,un});
            JTB_Saida_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
            JL_Quant_Item.setText(String.valueOf(JTB_Saida_Itens.getRowCount()));
       }else
       {    
            String cod = JTF_Cod.getText().trim();
            String descricao = JTF_Descricao.getText().trim();
            String quant = JTF_Quant.getText().trim().replace(",", ".");
            String data = JTF_Validade.getText().trim();
            String lote = JTF_Lote.getText().trim();
            String un = JTF_Un.getText().trim();
            //adicionando na tabela
            DefaultTableModel tb = (DefaultTableModel)JTB_Saida_Itens.getModel();
            tb.addRow(new String[]{cod,descricao,quant,data,lote,un});
            JTB_Saida_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            //quantidade de itens
            JL_Quant_Item.setText(String.valueOf(JTB_Saida_Itens.getRowCount()));
       }
    }
       
    public void Verifica_Se_Existe_Lote(Object id, String lote){
        int Quant_Linhas = JTB_Saida_Itens.getRowCount();
        if(Quant_Linhas>0){
            Quantidade = 0;
            num_lote = "";
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Saida_Itens.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    String Id_Produto = String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 0));
                    String Lote = String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 4));
                        if(Id_Produto.equalsIgnoreCase(JTF_Cod.getText())&&(Lote.equalsIgnoreCase(lote)))
                        {
                            Quantidade = Double.valueOf(String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 2)));
                            num_lote = Lote;
                        }
                    }catch(NumberFormatException ex){
                }
            }
    }else{
         Quantidade = 0;
         num_lote = "";
    }
    }
    
    public void Verifica_Se_Existe_Lote_Na_Lista(Object id, String lote){
        numero_linha=0;
        quant_retirada = 0;
        int Quant_Linhas = JTB_Saida_Itens.getRowCount();
        if(Quant_Linhas>0){
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Saida_Itens.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    String Id_Produto = String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 0));
                    String Lote = String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 4));
                    String Quant = String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 2));
                        if(Id_Produto.equalsIgnoreCase(String.valueOf(id))&&(Lote.equalsIgnoreCase(lote)))
                        {
                            controla_lote = true;
                            numero_linha = Linha + 1;
                            quant_retirada = Double.parseDouble(Quant);
                        }
                    }catch(NumberFormatException ex){
                }
            }
        }else{
            controla_lote = false;
        }
    }
    
    public void Verifica_Se_Existe(Object id){
        numero_linha=0;
        int Quant_Linhas = JTB_Saida_Itens.getRowCount();
        if(Quant_Linhas>0){
            quantidade_sem_lote = 0;
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Saida_Itens.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    String Id_Produto = String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 0));
                        if(Id_Produto.equalsIgnoreCase(JTF_Cod.getText()))
                        {
                            quantidade_sem_lote = Double.valueOf(String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 2)));
                            
                        }
                    }catch(NumberFormatException ex){
                }
            }
            
        }else{
            Quantidade = 0;
        }
    }
    public void Verifica_Se_Existe_Na_Lista(Object id){
        numero_linha=0;
        int Quant_Linhas = JTB_Saida_Itens.getRowCount();
        if(Quant_Linhas>0){
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Saida_Itens.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    String Id_Produto = String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 0));
                        if(Id_Produto.equalsIgnoreCase(String.valueOf(id)))
                        {
                            controla_prod = true;
                            numero_linha = Linha + 1;
                        }
                    }catch(NumberFormatException ex){
                }
            }
        }else{
             controla_prod = false;
        }
    }
    
    public void Verifica_A_Quantidade_Na_Lista(Object id){
        quantidade_na_tabela =0;
        int quant_linhas = JTB_Saida_Itens.getRowCount();
        if(quant_linhas>0){
            for(int Linha = 0; Linha < quant_linhas; Linha++){
                try {
                    JTB_Saida_Itens.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    String id_prod = String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 0));
                    double quant =Double.parseDouble(String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 2)));
                        if(id_prod.equalsIgnoreCase(String.valueOf(id)))
                        {
                            quantidade_na_tabela = quantidade_na_tabela + quant;
                        }
                    }catch(NumberFormatException ex){quantidade_na_tabela =0;
                }
            }
        }
    }
    
    public void Preencher_Objetos_Saida(){
        if(JCB_Curso.getSelectedItem().equals("OUTROS")){
            
        }else{
        ObjControleTurma.Procura_Id_Turma(ObjModeloTurma, JCB_Curso, JCB_Semestre, JCB_Turno, JCB_Ano, JCB_Vestibular,JCB_Turma);//procura o id da turma
        ObjModeloSaida.setTurma_id_turma(ObjModeloTurma.getId_turma());//passa para o modelo saida
        ObjControleDisciplina.Procura_Id_Disciplina(ObjModeloDisciplina, JCB_Disciplina);//procura o id da disciplina
        ObjModeloSaida.setDisciplina_id_disciplina(ObjModeloDisciplina.getId_disciplina());//passa para o modelo saida
        ObjModeloSaida.setTipo(JCB_Tipo.getSelectedItem().toString().trim());//pega o tipo de saida
        ObjModeloSaida.setObservacao(JTF_Observacao.getText().toUpperCase().trim());//pega a observação
        }
    }
     
     
    void Inserir_Saida(){
    try {
        ObjConecta.Conectar();
        //carrega os objetos
        Preencher_Objetos_Saida();
        //Faz a saida
        ObjControleSaida.Inserir_Saida(ObjModeloSaida,new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
        //Busca o ultimo Id inserido           
        ObjConecta.ExecutaSQL("Select * from saida");
        ObjConecta.rs.last();
        int Id_Saida = ObjConecta.rs.getInt("id_saida");
        //Conta quantas linha tem para inserção
        int Quant_Linhas = JTB_Saida_Itens.getRowCount();
        //Laço para fazer todas as inserçoes no banco de saída de itens
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Saida_Itens.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                                        
                    if(JTB_Saida_Itens.getValueAt(Linha, 3).equals("")){   //Produto sem validade     
                    
                        int Id_Produto = (Integer.parseInt((String)JTB_Saida_Itens.getValueAt(Linha, 0)));//Pega o id do produto na linha da tabela
                        double Quant = (Double.parseDouble((String) JTB_Saida_Itens.getValueAt(Linha, 2)));//pega a quantidade na linha da tabela
                        String Validade = null;
                        String Lote = (String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 4)));//pega o lote na linha da tabela
                        
                        ObjControleSaida.Inserir_Saida_Itens(Id_Produto, Id_Saida, Quant, Lote, Validade);//Metodo para inserira no banco
                        ObjControleSaida.Atualiza_Estoque_Produto(Id_Produto, Quant, Lote,Validade);
                        //verifica se o produto solicita devolucao
                        ObjControleSaida.Controla_Devolucao_Produto(Id_Produto);
                        if(ObjControleSaida.Controla_Devolucao_Produto == true){
                            ObjControleSaida.Atualiza_Devolucao(Id_Saida);
                            ObjControleSaida.Controla_Devolucao_Produto = false;
                        }
                    }
                    else{//Com validade
                        int Id_Produto = (Integer.parseInt((String)JTB_Saida_Itens.getValueAt(Linha, 0)));//Pega o id do produto na linha da tabela
                        double Quant =  (Double.parseDouble((String) JTB_Saida_Itens.getValueAt(Linha, 2)));//pega a quantidade na linha da tabela
                        String Validade = (String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format
                        (new SimpleDateFormat("dd-MM-yyyy").parse((String) (JTB_Saida_Itens.getValueAt(Linha, 3))))));//pega a trata a data de validade
                        String Lote = (String.valueOf(JTB_Saida_Itens.getValueAt(Linha, 4)));//pega o lote na linha da tabela
                        
                        ObjControleSaida.Inserir_Saida_Itens(Id_Produto, Id_Saida, Quant, Lote, Validade);
                        ObjControleSaida.Atualiza_Estoque_Produto(Id_Produto, Quant, Lote, Validade);
                        //verifica se o produto solicita devolucao
                        ObjControleSaida.Controla_Devolucao_Produto(Id_Produto);
                        if(ObjControleSaida.Controla_Devolucao_Produto == true){
                            ObjControleSaida.Atualiza_Devolucao(Id_Saida);
                            ObjControleSaida.Controla_Devolucao_Produto = false;
                        }
                    }
                } catch (NumberFormatException | ParseException ex){JOptionPane.showMessageDialog(rootPane, "Erro No Laço: "+ex);}
            }
            confirma_saida=true;
            ObjConecta.Desconecta();
            ObjControleSaida.Controla_Devolucao(Id_Saida);
            if(ObjControleSaida.Controla_Devolucao == false){
                ObjControleSaida.Efetivar_Devolucao(String.valueOf(Id_Saida),"SEM DEVOLUÇÃO");
            }
        
        } catch (SQLException ex) {
            confirma_saida = false;
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(rootPane,"Erro na saida de produtos \n"+ex);
        }   
    }
    public void Conf_Inserir_Saida() {
        Inserir_Saida();
        if (confirma_saida == true) 
            {
                Mostrar_Dados_Salvos();                
                Limpar_Tabela();
                Limpar_Produto();
                Limpar_descricao();
                confirma_saida = false;
            }
            else{
                Mostrar_Dados_Nao_Salvos();
                confirma_saida = false;
            }
    }
    public void Sair_Sem_Salvar(){
        int cont = JTB_Saida_Itens.getRowCount();
        if(cont > 0 || JCB_Curso.getSelectedIndex()>0){
            Mostrar_Sair_Sem_Salvar();
        }else{
            dispose();
        }
    }
    
    public void Testar_Campos(){
        int linha = JTB_Saida_Itens.getRowCount();
        if(linha <=0){
            Mostrar_Nao_Ha_Itens_Salvar();
        }else{
            if(JCB_Curso.getSelectedIndex()<=0 || JCB_Disciplina.getSelectedIndex()<=0){
                Mostrar_Preencher_Campos();
            }else{
                Mostrar_Conf_Salvar();
            }
        }
    }
    
     public final void Limpar_Tabela() {
        (( DefaultTableModel)JTB_Saida_Itens.getModel()).setNumRows(0);
        int cont = JTB_Saida_Itens.getRowCount();
        JL_Quant_Item.setText(String.valueOf(cont));
    }
        
    
    public final void Mostrar_Pesquisa_Produto(){
        ObjProdSaida = new Tela_Consulta_Produto_Saida_DL(this, true);
        ObjProdSaida.setVisible(true);
    }
    public void Mostrar_Escolha_Lote(Object id){
        ObjEscolhaLote = new Escolha_Lote_Saida(this, true, id);
        ObjEscolhaLote.setVisible(true);
    }
    public void Mostrar_Nova_Quantidade_Lote(){
        ObjNovaQuantLote = new Escolha_Nova_Quant_Lote_Saida(this,true);
        ObjNovaQuantLote.setVisible(true);
    }
     public void Mostrar_Conf_Alterar_Quantidade_Lote(){
        ObjAlterarQuantLote = new Conf_Alterar_Quant_Lote_Saida(this, true,numero_linha);
        ObjAlterarQuantLote.setVisible(true);
    }
     public void Mostrar_Quantidade_Saida(){
         ObjQuantSaida = new Escolha_Quant_Saida(this, true);
         ObjQuantSaida.setVisible(true);
     }
     public void Mostrar_Nova_Quantidade(){
        ObjNovaQuant = new Escolha_Nova_Quant_Saida(this,true);
        ObjNovaQuant.setVisible(true);
    }
     public void Mostrar_Conf_Alterar_Quantidade(){
        ObjAlterarQuant = new Conf_Alterar_Quant_Saida(this, true,numero_linha);
        ObjAlterarQuant.setVisible(true);
    }
    public void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Saida(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    void Mostrar_Conf_Salvar(){
        ObjConfSalvar = new Conf_Salvar_Saida(this, true);
        ObjConfSalvar.setVisible(true);        
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Saida(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Saida(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Saida(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    void Mostrar_Produto_Existente(){
        ObjProdExistente = new Inf_Produto_Existente_Saida(this, true);
        ObjProdExistente.setVisible(true);
    }
    void Mostrar_Produto_Existente_Lote(){
        ObjProdExistenteLote = new Inf_Produto_Existente_Lote_Saida(this, true);
        ObjProdExistenteLote.setVisible(true);
    }
    public void Mostrar_Quantidade_Invalida(){
        ObjQuantInvalida = new Inf_Quant_Invalida_Saida(this, true);
        ObjQuantInvalida.setVisible(true);
    }
    public void Mostrar_Selecione_Linha(){
        ObjSelecioneLinha = new Inf_Selecione_Linha_Saida(this, true);
        ObjSelecioneLinha.setVisible(true);
    }
    public void Mostrar_Selecione_Linha_Excluir(){
        ObjSelecioneLinhaExcluir = new Inf_Selecione_Linha_Excluir_Saida(this, true);
        ObjSelecioneLinhaExcluir.setVisible(true);
    }
    void Mostrar_Nao_Existe_Linha(){
        ObjNaoExisteLinha = new Inf_Nao_Existe_Linha_Saida(this, true);
        ObjNaoExisteLinha.setVisible(true);
    }
    void Mostrar_Nao_Ha_Itens_Salvar(){
        ObjNaoHaItensSalvar = new Inf_Nao_Ha_Itens_Salvar_Saida(this, true);
        ObjNaoHaItensSalvar.setVisible(true);
    }
    void Mostrar_Excluir_Linha(){
        ObjExcluir = new Conf_Excluir_Saida(this, true);
        ObjExcluir.setVisible(true);
    }
    public void Mostrar_Quantidade_Maior(){
        ObjQuantMaior = new Inf_Quant_Maior_Saida(this, true);
        ObjQuantMaior.setVisible(true);
    }
    //metodo para definir uma tecla para um botao
    
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Tecla Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),"Tecla Procurar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
        
        InputMap inputMap3 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0),"Tecla Adicionar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);
        
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0),"Tecla Salvar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap4);
                
        InputMap inputMap5 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap5.put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0),"Tecla Excluir");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap5);
        //método para executar
         this.getRootPane().getActionMap().put("Tecla Salvar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Salvar.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Tecla Procurar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Procurar.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Tecla Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Sair.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Tecla Adicionar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Adicionar.doClick();
        }
        });
       
         this.getRootPane().getActionMap().put("Tecla Excluir", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Excluir.doClick();
        }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Adicionar;
    private javax.swing.JButton BT_Excluir;
    private javax.swing.JButton BT_Procurar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JComboBox JCB_Ano;
    private javax.swing.JComboBox JCB_Curso;
    private javax.swing.JComboBox JCB_Disciplina;
    private javax.swing.JComboBox JCB_Semestre;
    private javax.swing.JComboBox JCB_Tipo;
    private javax.swing.JComboBox JCB_Turma;
    private javax.swing.JComboBox JCB_Turno;
    private javax.swing.JComboBox JCB_Vestibular;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Quant_Item;
    private javax.swing.JLabel JL_Quant_Itens;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JTable JTB_Saida_Itens;
    private javax.swing.JTextField JTF_Cod;
    private javax.swing.JTextField JTF_Descricao;
    private javax.swing.JTextField JTF_Lote;
    private javax.swing.JTextField JTF_Observacao;
    private javax.swing.JTextField JTF_Quant;
    private javax.swing.JTextField JTF_Un;
    private javax.swing.JTextField JTF_Validade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}

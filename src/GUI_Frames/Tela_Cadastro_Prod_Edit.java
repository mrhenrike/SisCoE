package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Entrada_Produto;
import Classes.Modelo_Lote_Estoque;
import Classes.Modelo_Produto;
import Classes.Modelo_Saida_Produto;
import Classes.Modelo_Tabela;
import Classes.Modelo_Turma;
import Conexao.Conecta_Banco;
import Conexao.Controle_Categoria;
import Conexao.Controle_Entrada_Produto;
import Conexao.Controle_Lote_Estoque;
import Conexao.Controle_Produto;
import Conexao.Controle_Saida_Produto;
import Conexao.Controle_Turma;
import GUI_Dialogs_Produto.Conf_Sair_Sem_Salvar_Prod_Edit;
import GUI_Dialogs_Produto.Conf_Salvar_Prod_Edit;
import GUI_Dialogs_Produto.Inf_Cadastro_Existente_Prod_Edit;
import GUI_Dialogs_Produto.Inf_Dados_Nao_Salvos_Prod_Edit;
import GUI_Dialogs_Produto.Inf_Dados_Salvos_Prod_Edit;
import GUI_Dialogs_Produto.Inf_Impossivel_Inativar_Prod_Edit;
import GUI_Dialogs_Produto.Inf_Preencher_Campos_Prod_Edit;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;


public class Tela_Cadastro_Prod_Edit extends javax.swing.JInternalFrame {
    
    public static Tela_Cadastro_Prod_Edit Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Cadastro_Prod_Edit();
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
    
    public static Tela_Cadastro_Categoria_DL1 ObjCadCategoria;
    private static Inf_Preencher_Campos_Prod_Edit ObjPreencherCampos;
    private static Inf_Dados_Salvos_Prod_Edit ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_Prod_Edit ObjDadosNaoSalvos;
    private static Conf_Salvar_Prod_Edit ObjConfSalvar;
    private static Conf_Sair_Sem_Salvar_Prod_Edit ObjSairSemSalvar;
    private static Inf_Impossivel_Inativar_Prod_Edit ObjImpossivelInativar;
    private static Inf_Cadastro_Existente_Prod_Edit ObjCadExiste;
    
    Controle_Categoria ObjControlCat = new Controle_Categoria();
    Modelo_Produto ObjModeloProduto = new Modelo_Produto();
    Controle_Produto ObjControlProd = new Controle_Produto();
    Formatacao ObjFormat = new Formatacao();
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Conecta_Banco ObjConecta2 = new Conecta_Banco();
    Controle_Lote_Estoque ObjControlLote = new Controle_Lote_Estoque();
    Modelo_Lote_Estoque ObjModeloLote = new Modelo_Lote_Estoque();
    Modelo_Turma ObjModeloTurma = new Modelo_Turma();
    Controle_Turma ObjControlTurma = new Controle_Turma();
    Modelo_Entrada_Produto ObjModeloEntradaProd = new Modelo_Entrada_Produto();
    Controle_Entrada_Produto ObjControlEntradaProd = new Controle_Entrada_Produto();
    Controle_Saida_Produto ObjControlSaida = new Controle_Saida_Produto();
    Modelo_Saida_Produto ObjModeloSaida = new Modelo_Saida_Produto();
    
    
    boolean Testar_Sair=false;
    
    public Tela_Cadastro_Prod_Edit() {
        initComponents();
        
        Desabilitar_Campos();
        
        JTF_Descricao.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Quant_Min.setDocument(ObjFormat.new Format_Apenas_Numero(10));
        JTF_Quant_Macro.setDocument(ObjFormat.new Format_Apenas_Numero(10));
        JTF_Id.setDocument(ObjFormat.new Format_Geral(50));
                
        Preencher_CB_Categoria();
        Preencher_CB_Macro();
        Preencher_CB_Unidade();
        
        BT_Salvar.setEnabled(false);
        Setar_Atalho_BT();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JP_Descricao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JCB_Categoria = new javax.swing.JComboBox();
        JCB_Unidade = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        JTF_Quant_Min = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        JTF_Quant_Macro = new javax.swing.JTextField();
        JCB_Macro = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JTF_Preco = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        JTF_Cod = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        JTF_Estoque = new javax.swing.JFormattedTextField();
        JTF_Descricao = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        JTF_Id = new javax.swing.JTextField();
        JP_Controle = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JCB_Solicita_Lote = new javax.swing.JComboBox();
        JCB_Solicita_Dev = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JCB_Situacao = new javax.swing.JComboBox();
        BT_Sair = new javax.swing.JButton();
        BT_Cadastrar = new javax.swing.JButton();
        JL_Campos = new javax.swing.JLabel();
        BT_Editar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Consulta_Prod = new javax.swing.JTable();
        JCB_Tipo_Pesquisa = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        JL_Ultimo = new javax.swing.JLabel();
        JTF_Ultimo = new javax.swing.JTextField();
        JL_Media = new javax.swing.JLabel();
        JTF_Media = new javax.swing.JTextField();
        BT_Salvar = new javax.swing.JButton();
        JL_Quant_Itens1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Consultar E Alterar Produto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Prod 24x24.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(805, 560));
        setMinimumSize(new java.awt.Dimension(805, 560));
        setPreferredSize(new java.awt.Dimension(805, 560));
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

        JP_Descricao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Categoria*:");

        JCB_Categoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_CategoriaActionPerformed(evt);
            }
        });

        JCB_Unidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Mínimo*:");

        JTF_Quant_Min.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Macro:");

        JTF_Quant_Macro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JCB_Macro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Quantidade:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Unidade*:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Preço:");

        JTF_Preco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        JTF_Preco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_PrecoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Descrição*:");

        JTF_Cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Id:");

        JTF_Estoque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        JTF_Estoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Estoque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTF_EstoqueFocusLost(evt);
            }
        });
        JTF_Estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_EstoqueActionPerformed(evt);
            }
        });

        JTF_Descricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Estoque:");

        JTF_Id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JP_DescricaoLayout = new javax.swing.GroupLayout(JP_Descricao);
        JP_Descricao.setLayout(JP_DescricaoLayout);
        JP_DescricaoLayout.setHorizontalGroup(
            JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_DescricaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(4, 4, 4)
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_DescricaoLayout.createSequentialGroup()
                        .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JP_DescricaoLayout.createSequentialGroup()
                                .addComponent(JTF_Quant_Min, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(JCB_Macro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(JCB_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTF_Quant_Macro)
                            .addComponent(JCB_Unidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(JP_DescricaoLayout.createSequentialGroup()
                        .addComponent(JTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_Descricao)))
                .addGap(18, 18, 18)
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_DescricaoLayout.createSequentialGroup()
                        .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_DescricaoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)))
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTF_Estoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(JTF_Preco)
                    .addComponent(JTF_Id))
                .addContainerGap())
        );
        JP_DescricaoLayout.setVerticalGroup(
            JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_DescricaoLayout.createSequentialGroup()
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JTF_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(JTF_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCB_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(JTF_Estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Quant_Macro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(JCB_Macro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(JTF_Quant_Min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(JTF_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        JP_Controle.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Controle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Solicita Lote E Validade?*:");

        JCB_Solicita_Lote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Solicita_Lote.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "SIM", "NÃO" }));

        JCB_Solicita_Dev.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Solicita_Dev.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "SIM", "NÃO" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Solicita Devolução?*:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Situação:*");

        JCB_Situacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Situacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ATIVO", "INATIVO" }));

        javax.swing.GroupLayout JP_ControleLayout = new javax.swing.GroupLayout(JP_Controle);
        JP_Controle.setLayout(JP_ControleLayout);
        JP_ControleLayout.setHorizontalGroup(
            JP_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ControleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(JCB_Solicita_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(JCB_Solicita_Dev, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(JCB_Situacao, 0, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        JP_ControleLayout.setVerticalGroup(
            JP_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ControleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(JP_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JCB_Solicita_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Solicita_Dev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14)
                    .addComponent(JCB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Voltar.png"))); // NOI18N
        BT_Sair.setMnemonic('l');
        BT_Sair.setToolTipText("Clique Para Voltar Ou Pressione Alt + L");
        BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Voltar Press.png"))); // NOI18N
        BT_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SairActionPerformed(evt);
            }
        });

        BT_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cadastrar.png"))); // NOI18N
        BT_Cadastrar.setMnemonic('d');
        BT_Cadastrar.setToolTipText("Clique Para Cadastrar Ou Pressione Alt + D");
        BT_Cadastrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cadastrar Press.png"))); // NOI18N
        BT_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CadastrarActionPerformed(evt);
            }
        });

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        BT_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar.png"))); // NOI18N
        BT_Editar.setMnemonic('e');
        BT_Editar.setToolTipText("Clique Para Editar Os Dados Ou Pressione Alt + E");
        BT_Editar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar press.png"))); // NOI18N
        BT_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_EditarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Movimentação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTB_Consulta_Prod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Consulta_Prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Consulta_Prod.setToolTipText("Clique Duas Vezes Em Uma Linha Para Mais Detalhes");
        JTB_Consulta_Prod.getTableHeader().setReorderingAllowed(false);
        JTB_Consulta_Prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_Consulta_ProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Consulta_Prod);

        JCB_Tipo_Pesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ENTRADA", "SAÍDA" }));
        JCB_Tipo_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_Tipo_PesquisaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tipo:");

        JL_Ultimo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Ultimo.setText("Ultima Entrada:");

        JTF_Ultimo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JL_Media.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Media.setText("Ultimos 3 Meses:");

        JTF_Media.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_Ultimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(JTF_Ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Tipo_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Media, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Media))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCB_Tipo_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Ultimo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTF_Ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Media)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTF_Media, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        BT_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar.png"))); // NOI18N
        BT_Salvar.setMnemonic('s');
        BT_Salvar.setToolTipText("Clique Para Salvar Ou Pressione Alt + S");
        BT_Salvar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar Press.png"))); // NOI18N
        BT_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SalvarActionPerformed(evt);
            }
        });

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Voltar/Cancelar | F6 - Cadastrar | F7 - Editar | F10 - Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_Controle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JP_Descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(649, 649, 649)
                                .addComponent(JL_Campos))
                            .addComponent(JL_Quant_Itens1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JP_Controle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(JL_Campos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Quant_Itens1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BT_Cadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Salvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(20, 20, 805, 560);
    }// </editor-fold>//GEN-END:initComponents

       
    private void JCB_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_CategoriaActionPerformed
       if(JCB_Categoria.getSelectedItem().equals("+ ADICIONAR NOVO")){
           Inicio_CB_Categoria();
           Mostrar_Cadastro_Categoria();           
       }
    }//GEN-LAST:event_JCB_CategoriaActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Tela_Consulta_Entrada obj = new Tela_Consulta_Entrada();
        if(Testar_Sair == true){
            Mostrar_Sair_Sem_Salvar();
        }else{
            if(obj.Objteste != null){obj.Open_Tela();dispose();obj.Objteste= null;}
            else{Abri_Tela_Consulta_Prod();}
        }
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CadastrarActionPerformed
        Tela_Cadastro_Prod obj = new Tela_Cadastro_Prod();
        obj.Open_Tela();
        dispose();
    }//GEN-LAST:event_BT_CadastrarActionPerformed

    private void JTF_EstoqueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_EstoqueFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_EstoqueFocusLost

    private void JTF_EstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_EstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_EstoqueActionPerformed

    private void BT_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_EditarActionPerformed
        Virar_BT_Cancelar();
        Habilitar_Campos();
        BT_Salvar.setEnabled(true);
        BT_Editar.setEnabled(false);
        BT_Cadastrar.setEnabled(false);
        Testar_Sair = true;
    }//GEN-LAST:event_BT_EditarActionPerformed

    private void JCB_Tipo_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_Tipo_PesquisaActionPerformed
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -3); //diminuir datas - inicio para 90 dias;
        String data_atual = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String data_inicio = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        
        
        if(JCB_Tipo_Pesquisa.getSelectedItem()=="SAÍDA")
        {   JTF_Ultimo.setText("");JL_Ultimo.setText("Ultima Saída");JTF_Media.setText("");
            Preencher_Tabela_Saidas("select * from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida "
                    + "where saida_itens.produto_id_produto="+JTF_Cod.getText().trim()+" "
                    + "and saida.data_saida between '"+data_inicio+"' and '"+data_atual+"';");
        }
        if(JCB_Tipo_Pesquisa.getSelectedItem()=="ENTRADA")
        {   JTF_Ultimo.setText("");JL_Ultimo.setText("Ultima Entrada");JTF_Media.setText("");
            Preencher_Tabela_Entradas("select * from entrada inner join entrada_itens on"
                + " entrada.id_entrada=entrada_itens.entrada_id_entrada where produto_id_produto="+JTF_Cod.getText().trim()+" "
                    + "and entrada.data_entrada between '"+data_inicio+"' and '"+data_atual+"';");
        }
    }//GEN-LAST:event_JCB_Tipo_PesquisaActionPerformed

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        Testar_Campos();
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JTF_PrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PrecoActionPerformed
        JCB_Solicita_Lote.requestFocus();
    }//GEN-LAST:event_JTF_PrecoActionPerformed

    private void JTB_Consulta_ProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Consulta_ProdMouseClicked
         try {
            if (evt.getClickCount() == 2) {
                if(JCB_Tipo_Pesquisa.getSelectedIndex()==0){
                    Object Descricao = JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1);
                    Object Data = JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 2);
                    Object Num_Entrada = JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0);
                    JOptionPane.showMessageDialog(rootPane,"Número Da Entrada: "+ Num_Entrada+"   Data: "+Data+
                        "\nDescrição: "+Descricao,"Descrição Da Entrada",JOptionPane.INFORMATION_MESSAGE);
                }
                if(JCB_Tipo_Pesquisa.getSelectedIndex()==1){
                    Object Num_Saida = JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0);
                    Object Data = JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1);
                    try {
                        ObjConecta.Conectar();
                        ObjConecta.ExecutaSQL("select * from saida where id_saida="+Num_Saida+"");
                        ObjConecta.rs.first();
                        String Tipo = ObjConecta.rs.getString("tipo");
                        String Observacao = ObjConecta.rs.getString("observacao");
                        String Situacao = ObjConecta.rs.getString("situacao");
                        ObjConecta.ExecutaSQL("select concat(semestre,abrev_curso,turno,ano_turma,'.',semestre_vestibular,' ',turma) as turmas "
                                + "from curso inner join turma on curso.id_curso = turma.curso_id_curso inner join saida on id_turma = saida.turma_id_turma "
                                + "where saida.id_saida="+Num_Saida+"");
                        ObjConecta.rs.first();
                        String turma = ObjConecta.rs.getString("turmas");
                        ObjConecta.ExecutaSQL("select * from saida inner join disciplina on id_disciplina = saida.disciplina_id_disciplina where saida.id_saida="+Num_Saida+"");
                        ObjConecta.rs.first();
                        String Disciplina = ObjConecta.rs.getInt("semestre")+"º SEM - "+ ObjConecta.rs.getString("disciplina");
                        
                        JOptionPane.showMessageDialog(rootPane,"Número Da Saída: "+ Num_Saida+"   Data: "+Data+
                        "\nTipo: "+Tipo + "\nTurma: "+turma + "\nDisciplina: "+Disciplina +
                        "\nSituação: "+Situacao+ "\nObservação: "+Observacao,
                        "Descrição Da Saída",JOptionPane.INFORMATION_MESSAGE);
                        ObjConecta.Desconecta();
                
                    }catch (SQLException ex) {
                        ObjConecta.Desconecta();  
                    }
                    
                }
            }
        } catch (HeadlessException ex) {
    }
    }//GEN-LAST:event_JTB_Consulta_ProdMouseClicked
    
    private void Preencher_CB_Macro(){
    JCB_Macro.removeAllItems();
    JCB_Macro.addItem("");
    JCB_Macro.addItem("AMP");
    JCB_Macro.addItem("CT");
    JCB_Macro.addItem("CX");
    JCB_Macro.addItem("FD");
    JCB_Macro.addItem("L");
    JCB_Macro.addItem("ML");
    JCB_Macro.addItem("PCT");
    JCB_Macro.addItem("UN");
    }
    
    private void Preencher_CB_Unidade(){
    JCB_Unidade.removeAllItems();
    JCB_Unidade.addItem("");
    JCB_Unidade.addItem("CM");
    JCB_Unidade.addItem("G");    
    JCB_Unidade.addItem("L");
    JCB_Unidade.addItem("MG");
    JCB_Unidade.addItem("ML");
    JCB_Unidade.addItem("MM");
    JCB_Unidade.addItem("UN");
    }
    
    public void Limpar_Campos(){
        JTF_Descricao.setText("");
        JTF_Quant_Macro.setText("");
        JTF_Quant_Min.setText("");
        JTF_Preco.setValue(null);
        JCB_Categoria.setSelectedIndex(0);
        JCB_Macro.setSelectedIndex(0);
        JTF_Id.setText("");
        JCB_Solicita_Dev.setSelectedIndex(0);
        JCB_Solicita_Lote.setSelectedIndex(0);
        JCB_Unidade.setSelectedIndex(0);
        
    }
    
    public void Testar_Campos(){
        Double estoque = Double.parseDouble(JTF_Estoque.getText());
        if((JTF_Descricao.getText().equalsIgnoreCase(""))
        ||(JTF_Quant_Min.getText().equalsIgnoreCase(""))
        ||(JCB_Categoria.getSelectedIndex()==0)
        ||(JCB_Solicita_Dev.getSelectedIndex()==0)
        ||(JCB_Solicita_Lote.getSelectedIndex()==0)
        ||(JCB_Unidade.getSelectedIndex()==0)
        ||(JCB_Situacao.getSelectedIndex()==0))
        {
            Mostrar_Preencher_Campos();
        }
        else if(JCB_Situacao.getSelectedItem().equals("INATIVO") && estoque>0){
            Mostrar_Impossivel_Inativar();
        }else{
            if(JTF_Descricao.getText().equalsIgnoreCase(ObjModeloProduto.getDescricao())){
                Mostrar_Conf_Salvar();
            }else{
                ObjControlProd.Testar_Existente(JTF_Descricao);
                if(ObjControlProd.Controle_Existente == true){
                    Mostrar_Cad_Existente();
                    ObjControlProd.Controle_Existente = false;
                }else{
                    Mostrar_Conf_Salvar();
                }
            }
        }
    }
    
    public void Preencher_Objetos_Produtos(){
        ObjModeloProduto.setDescricao(JTF_Descricao.getText().trim());
        ObjModeloProduto.setIdentificacao(JTF_Id.getText().trim());
        //teste para setar sem valores no banco;
        if(!JTF_Quant_Min.getText().equalsIgnoreCase(""))
        { ObjModeloProduto.setQuant_minima(Integer.parseInt(JTF_Quant_Min.getText().trim())); }
        else
        { ObjModeloProduto.setQuant_minima(0); }
        if(!JTF_Quant_Macro.getText().equalsIgnoreCase(""))
        { ObjModeloProduto.setQuant_macro(Integer.parseInt(JTF_Quant_Macro.getText().trim())); }
        else
        { ObjModeloProduto.setQuant_macro(0); }
        if(!JTF_Preco.getText().equalsIgnoreCase(""))
        { ObjModeloProduto.setPreco(Double.valueOf(JTF_Preco.getText().trim().replace(",", "."))); }
        else
        { ObjModeloProduto.setPreco(0); }

        ObjModeloProduto.setMacro(JCB_Macro.getSelectedItem().toString().toUpperCase().trim());
        ObjModeloProduto.setUnidade(JCB_Unidade.getSelectedItem().toString().toUpperCase().trim());
        ObjModeloProduto.setSolicita_lote(JCB_Solicita_Lote.getSelectedItem().toString().toUpperCase().trim());
        ObjModeloProduto.setSolicita_devolucao(JCB_Solicita_Dev.getSelectedItem().toString().trim());
        ObjModeloProduto.setSituacao(JCB_Situacao.getSelectedItem().toString().toUpperCase().trim());
        
    }
        
    public final void Desabilitar_Campos(){
        JTF_Cod.setEnabled(false);
        JTF_Descricao.setEnabled(false);
        JTF_Estoque.setEnabled(false);
        JTF_Media.setEnabled(false);
        JTF_Preco.setEnabled(false);
        JTF_Quant_Macro.setEnabled(false);
        JTF_Quant_Min.setEnabled(false);
        JTF_Ultimo.setEnabled(false);
        JCB_Categoria.setEnabled(false);
        JCB_Macro.setEnabled(false);
        JTF_Id.setEnabled(false);
        JCB_Solicita_Dev.setEnabled(false);
        JCB_Solicita_Lote.setEnabled(false);
        JCB_Unidade.setEnabled(false);
        JCB_Situacao.setEnabled(false);
    }
    
    public void Habilitar_Campos(){
        JTF_Descricao.setEnabled(!false);
        JTF_Quant_Macro.setEnabled(!false);
        JTF_Quant_Min.setEnabled(!false);
        JCB_Categoria.setEnabled(!false);
        JCB_Macro.setEnabled(!false);
        JTF_Id.setEnabled(!false);
        JCB_Solicita_Dev.setEnabled(!false);
        JCB_Solicita_Lote.setEnabled(!false);
        JCB_Unidade.setEnabled(!false);
        JCB_Situacao.setEnabled(!false);
    }
     
       
    public void Conf_Alterar_Produto(){
        ObjControlProd.Procura_Id_Categoria(ObjModeloProduto, JCB_Categoria);
        Preencher_Objetos_Produtos();
        ObjControlProd.Atualizar_Produto(ObjModeloProduto, JTF_Cod.getText());
            if (ObjControlProd.Confirma_Alterar == true) {
                Mostrar_Dados_Salvos();
                Limpar_Campos();
                ObjControlProd.Confirma_Alterar = false;
                Testar_Sair=false;
                Abri_Tela_Consulta_Prod();
            } else {
                Mostrar_Dados_Nao_Salvos();
                ObjControlProd.Confirma_Alterar = false;
            }
    }
    
    public final void Preencher_CB_Categoria(){
        ObjControlCat.Preencher_CB_Categoria(JCB_Categoria);
    }
    
    public void Inicio_CB_Categoria(){
        JCB_Categoria.setSelectedIndex(0);
    } 
    
    
    
    public void Carregar_Dados_Produtos(Object LinhaSelecionada) throws SQLException { 
        try {           
            //Modelo_Produto ObjModeloProduto = new Modelo_Produto();
            
            ObjModeloProduto.setPesquisa(String.valueOf(LinhaSelecionada));
            
            ObjControlLote.Consulta_Estoque_Produto(ObjModeloLote,LinhaSelecionada);//Consulta o estoque do produto
               
            ObjControlProd.Consulta_Produto_Alterar(ObjModeloProduto);
            
            Preencher_Tabela_Entradas("select * from entrada inner join entrada_itens on"
              + " entrada.id_entrada=entrada_itens.entrada_id_entrada where produto_id_produto="+LinhaSelecionada+"");
                        
            ObjControlProd.Procura_Nome_Categoria(ObjModeloProduto,ObjModeloProduto.getCategoria_id_produto());
            
            JTF_Cod.setText(String.valueOf(ObjModeloProduto.getId_produto()));
            JTF_Descricao.setText(String.valueOf(ObjModeloProduto.getDescricao()));
            JCB_Categoria.setSelectedItem(String.valueOf(ObjModeloProduto.getNome_categoria()));
            JCB_Unidade.setSelectedItem(String.valueOf(ObjModeloProduto.getUnidade()));
            JCB_Macro.setSelectedItem(String.valueOf(ObjModeloProduto.getMacro()));
            JTF_Quant_Min.setText(String.valueOf(ObjModeloProduto.getQuant_minima()));
            JTF_Quant_Macro.setText(String.valueOf(ObjModeloProduto.getQuant_macro()));
            JCB_Solicita_Lote.setSelectedItem(String.valueOf(ObjModeloProduto.getSolicita_lote()));
            JCB_Solicita_Dev.setSelectedItem(String.valueOf(ObjModeloProduto.getSolicita_devolucao()));
            JTF_Id.setText(String.valueOf(ObjModeloProduto.getIdentificacao()));
            JCB_Situacao.setSelectedItem(String.valueOf(ObjModeloProduto.getSituacao()));
            JTF_Estoque.setText(String.valueOf(ObjModeloLote.getQuantidade_estoque()));
            JTF_Preco.setText(String.valueOf(ObjModeloProduto.getPreco()).replace(".", ","));
        } catch (SQLException ex) {
        }
    }
    
    public void Virar_BT_Cancelar(){
    BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar.png")));
    BT_Sair.setMnemonic('c');
    BT_Sair.setToolTipText("Clique Para Cancelar Ou Pressione Alt + C");
    BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar Press.png"))); 
}
    
    public void Virar_BT_Voltar(){
        BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Voltar.png"))); // NOI18N
        BT_Sair.setMnemonic('l');
        BT_Sair.setToolTipText("Clique Para Voltar Ou Pressione Alt + L");
        BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Voltar Press.png"))); // NOI18N
    }
    
       
     void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Prod_Edit(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Prod_Edit(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Prod_Edit(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    void Mostrar_Conf_Salvar(){
        ObjConfSalvar = new Conf_Salvar_Prod_Edit(this, true);
        ObjConfSalvar.setVisible(true);        
    }
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Prod_Edit(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    void Mostrar_Impossivel_Inativar(){
        ObjImpossivelInativar = new Inf_Impossivel_Inativar_Prod_Edit(this, true);
        ObjImpossivelInativar.setVisible(true);
    }       
    public void Mostrar_Cadastro_Categoria(){
        ObjCadCategoria = new Tela_Cadastro_Categoria_DL1(this, true);
        ObjCadCategoria.setVisible(true);
    }
    void Mostrar_Cad_Existente(){
        ObjCadExiste = new Inf_Cadastro_Existente_Prod_Edit(this, true);
        ObjCadExiste.setVisible(true);
    }
    
    public void Abri_Tela_Consulta_Prod(){
        Tela_Consulta_Produto obj = new Tela_Consulta_Produto();
        obj.Open_Tela();
        dispose();
    }
    public final void Preencher_Tabela_Entradas(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Nº Entrada","Descrição", "Data Entrada","Quantidade", "Lote","Validade","Preço"};//Seta os indices da tabela
        ObjConecta2.Conectar();
        ObjConecta2.ExecutaSQL(SQL);
        try {
            ObjConecta2.rs.first();
           
            do {
                String lote = ObjConecta2.rs.getString("lote");
                Date validade = ObjConecta2.rs.getDate("data_validade");
                String data_val= "";
                if((lote == null)||(lote.equalsIgnoreCase("null"))) {lote = "";}
                if(validade != null){data_val = String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta2.rs.getDate("data_validade")));}
                
                dados.add(new Object[]{ObjConecta2.rs.getInt("id_entrada"),ObjConecta2.rs.getString("descricao_entrada"),
                new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta2.rs.getDate("data_entrada")),
                ObjConecta2.rs.getDouble("quantidade"), lote, data_val, ObjConecta2.rs.getDouble("preco") });
            } while (ObjConecta2.rs.next());
            //data da ultima entrada
            ObjConecta2.rs.last();
            JL_Ultimo.setText("Ultima Entrada:");
            JTF_Ultimo.setText(String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta2.rs.getDate("data_entrada"))));
            //Média das entradas
            ObjControlEntradaProd.Media_Prod_Mes_Entrada(ObjModeloEntradaProd,ObjConecta2.rs.getInt("produto_id_produto"));
            JTF_Media.setText(String.valueOf(ObjModeloEntradaProd.getMedia()));
            //Setar a label media
            if (ObjControlEntradaProd.dt <= 30) {
                JL_Media.setText("Ultimo Mês");}
            if (ObjControlEntradaProd.dt > 30 && ObjControlEntradaProd.dt <= 60) {
                JL_Media.setText("Ultimos 2 Meses");}
            if (ObjControlEntradaProd.dt > 60) {
                JL_Media.setText("Ultimos 3 Meses"); }   
            ObjConecta2.Desconecta();
        } catch (SQLException ex) {
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Consulta_Prod.setModel(tabela);
        JTB_Consulta_Prod.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Consulta_Prod.getColumnModel().getColumn(0).setPreferredWidth(100);//Tamanho da coluna
        JTB_Consulta_Prod.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Consulta_Prod.getColumnModel().getColumn(1).setPreferredWidth(250);
        JTB_Consulta_Prod.getColumnModel().getColumn(1).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(2).setPreferredWidth(150);
        JTB_Consulta_Prod.getColumnModel().getColumn(2).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(3).setPreferredWidth(100);
        JTB_Consulta_Prod.getColumnModel().getColumn(3).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTB_Consulta_Prod.getColumnModel().getColumn(4).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(5).setPreferredWidth(150);
        JTB_Consulta_Prod.getColumnModel().getColumn(5).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(6).setPreferredWidth(100);
        JTB_Consulta_Prod.getColumnModel().getColumn(6).setResizable(false);
        JTB_Consulta_Prod.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Consulta_Prod.setAutoResizeMode(JTB_Consulta_Prod.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Todas colunas)
        JTB_Consulta_Prod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
        JTB_Consulta_Prod.setToolTipText("Clique Duas Vezes Em Uma Linha Para Mais Informações!");
    }
    
    public final void Preencher_Tabela_Saidas(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Nº Saída", "Data Saída","Descrição","Quantidade", "Lote","Validade","Situação"};//Seta os indices da tabela
        ObjConecta2.Conectar();
        ObjConecta2.ExecutaSQL(SQL);
        try {
            ObjConecta2.rs.first();
           
            do {
                //ObjControlTurma.Consulta_Turma_Concat(ObjModeloTurma,ObjConecta2.rs.getInt("turma_id_turma"));
                String lote = ObjConecta2.rs.getString("lote");
                Date validade = ObjConecta2.rs.getDate("validade");
                String data_val= "";
                String descricao = ObjConecta2.rs.getString("tipo")+" - "+ObjConecta2.rs.getString("observacao");
                if((lote == null)||(lote.equalsIgnoreCase("null"))) {lote = "";}
                if(validade != null){data_val = String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta2.rs.getDate("validade")));}
                
                dados.add(new Object[]{ObjConecta2.rs.getInt("id_saida"),
                new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta2.rs.getDate("data_saida")),descricao,
                ObjConecta2.rs.getDouble("quantidade"), lote, data_val, ObjConecta2.rs.getString("situacao") });
            
            } while (ObjConecta2.rs.next());
            ObjConecta2.rs.last();
            JL_Ultimo.setText("Ultima Saída:");
            JTF_Ultimo.setText(String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta2.rs.getDate("data_saida"))));
            ObjControlSaida.Media_Prod_Mes_Saida(ObjModeloSaida,ObjConecta2.rs.getInt("produto_id_produto"));
            JTF_Media.setText(String.valueOf(ObjModeloSaida.getMedia()));
            //Setar a label media
            if (ObjControlSaida.dt <= 30) {
                JL_Media.setText("Ultimo Mês");}
            if (ObjControlSaida.dt > 30 && ObjControlSaida.dt <= 60) {
                JL_Media.setText("Ultimos 2 Meses");}
            if (ObjControlSaida.dt > 60) {
                JL_Media.setText("Ultimos 3 Meses"); }   
            ObjConecta2.Desconecta();
        } catch (SQLException ex) {
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Consulta_Prod.setModel(tabela);
        JTB_Consulta_Prod.getColumnModel().getColumn(0).setPreferredWidth(100);//Tamanho da coluna
        JTB_Consulta_Prod.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Consulta_Prod.getColumnModel().getColumn(1).setPreferredWidth(100);
        JTB_Consulta_Prod.getColumnModel().getColumn(1).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(2).setPreferredWidth(150);
        JTB_Consulta_Prod.getColumnModel().getColumn(2).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(3).setPreferredWidth(100);
        JTB_Consulta_Prod.getColumnModel().getColumn(3).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTB_Consulta_Prod.getColumnModel().getColumn(4).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTB_Consulta_Prod.getColumnModel().getColumn(5).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(6).setPreferredWidth(150);
        JTB_Consulta_Prod.getColumnModel().getColumn(6).setResizable(false);
        JTB_Consulta_Prod.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Consulta_Prod.setAutoResizeMode(JTB_Consulta_Prod.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Todas colunas)
        JTB_Consulta_Prod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
        JTB_Consulta_Prod.setToolTipText("Clique Duas Vezes Em Uma Linha Para Mais Informações!");
    }
    
    
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0),"Cadastrar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
        //metodo para pegar a tecla pressionada
        InputMap inputMap3 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0),"Salvar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);
        //metodo para pegar a tecla pressionada
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0),"Editar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap4);
        
        //método para executar
        this.getRootPane().getActionMap().put("Cadastrar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
            BT_Cadastrar.doClick();
    }
    });
        this.getRootPane().getActionMap().put("Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
            BT_Sair.doClick();
    }
    });
         this.getRootPane().getActionMap().put("Editar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
           BT_Editar.doClick();
    }
    });
          this.getRootPane().getActionMap().put("Salvar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
            BT_Salvar.doClick();
    }
    });
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Cadastrar;
    private javax.swing.JButton BT_Editar;
    public javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JComboBox JCB_Categoria;
    private javax.swing.JComboBox JCB_Macro;
    private javax.swing.JComboBox JCB_Situacao;
    private javax.swing.JComboBox JCB_Solicita_Dev;
    private javax.swing.JComboBox JCB_Solicita_Lote;
    private javax.swing.JComboBox JCB_Tipo_Pesquisa;
    private javax.swing.JComboBox JCB_Unidade;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Media;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JLabel JL_Ultimo;
    private javax.swing.JPanel JP_Controle;
    private javax.swing.JPanel JP_Descricao;
    private javax.swing.JTable JTB_Consulta_Prod;
    private javax.swing.JTextField JTF_Cod;
    private javax.swing.JTextField JTF_Descricao;
    private javax.swing.JFormattedTextField JTF_Estoque;
    private javax.swing.JTextField JTF_Id;
    private javax.swing.JTextField JTF_Media;
    private javax.swing.JFormattedTextField JTF_Preco;
    private javax.swing.JTextField JTF_Quant_Macro;
    private javax.swing.JTextField JTF_Quant_Min;
    private javax.swing.JTextField JTF_Ultimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

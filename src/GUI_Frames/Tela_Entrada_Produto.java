package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Entrada_Produto;
import Classes.Modelo_Produto;
import Conexao.Conecta_Banco;
import Conexao.Controle_Entrada_Produto;
import Conexao.Controle_Produto;
import GUI_Dialogs_Entrada.Conf_Add_Tabela_Ent;
import GUI_Dialogs_Entrada.Conf_Excluir_Ent;
import GUI_Dialogs_Entrada.Conf_Sair_Sem_Salvar_Ent;
import GUI_Dialogs_Entrada.Conf_Salvar_Ent;
import GUI_Dialogs_Entrada.Inf_Dados_Nao_Salvos_Ent;
import GUI_Dialogs_Entrada.Inf_Dados_Salvos_Ent;
import GUI_Dialogs_Entrada.Inf_Data_Fabricacao_Maior_Ent;
import GUI_Dialogs_Entrada.Inf_Nao_Existe_Linha_Ent;
import GUI_Dialogs_Entrada.Inf_Nao_Ha_Itens_Salvar_Ent;
import GUI_Dialogs_Entrada.Inf_Preencher_Campos_Ent;
import GUI_Dialogs_Entrada.Inf_Preencher_Lote_Validade_Ent;
import GUI_Dialogs_Entrada.Inf_Prod_Vencido_Ent;
import GUI_Dialogs_Entrada.Inf_Produto_Existente_Ent;
import GUI_Dialogs_Entrada.Inf_Produto_Existente_Lote_Ent;
import GUI_Dialogs_Entrada.Inf_Quant_Invalida_Ent;
import GUI_Dialogs_Entrada.Inf_Selecione_Linha_Ent;
import Metodos.Formatacao;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class Tela_Entrada_Produto extends javax.swing.JInternalFrame {
    
    public static Tela_Entrada_Produto Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Entrada_Produto();
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
    Controle_Produto ObjControlProd = new Controle_Produto();
    Controle_Entrada_Produto ObjControlEnt = new Controle_Entrada_Produto();
    Modelo_Entrada_Produto ObjModeloEntrada = new Modelo_Entrada_Produto();
    Modelo_Produto ObjModeloProd = new Modelo_Produto();
    Formatacao ObjFormat = new Formatacao();
       
    private static Inf_Preencher_Campos_Ent ObjPreencherCampos;
    private static Inf_Preencher_Lote_Validade_Ent ObjPreencherLote;
    private static Inf_Dados_Salvos_Ent ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_Ent ObjDadosNaoSalvos;
    private static Conf_Salvar_Ent ObjConfSalvar;
    private static Conf_Sair_Sem_Salvar_Ent ObjSairSemSalvar;
    private static Inf_Produto_Existente_Ent ObjProdExistente;
    private static Inf_Produto_Existente_Lote_Ent ObjProdExistenteLote;
    private static Inf_Quant_Invalida_Ent ObjQuantInvalida;
    private static Inf_Selecione_Linha_Ent ObjSelecioneLinha;
    private static Inf_Nao_Existe_Linha_Ent ObjNaoExisteLinha;
    private static Inf_Nao_Ha_Itens_Salvar_Ent ObjNaoHaItensSalvar;
    private static Conf_Excluir_Ent ObjExcluir;
    private static Conf_Add_Tabela_Ent ObjAddTabela;
    private static Inf_Prod_Vencido_Ent ObjProdVencido;
    private static Inf_Data_Fabricacao_Maior_Ent ObjDataFabMaior;
    
    public String Pesquisa;
    public boolean ProcuraEstoque;
    boolean ConfirmaEntrada;
    boolean VerificaExistente;
    boolean VerificaExistenteLote;
    boolean Menos30Dias;
    boolean DataMenor;
    boolean FabricacaoMaior;
    
    private static Tela_Consulta_Produto_Entrada_DL ObjConsultaProdDl;
    
    
    public Tela_Entrada_Produto() {
        initComponents();
       
        JTF_Cod.setEnabled(false);
        JTF_Un.setEnabled(false);
        JTF_Descricao_Entrada.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Descricao.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Quant.setDocument(ObjFormat.new Format_Valor(10));
        JTF_Lote.setDocument(ObjFormat.new Format_Geral(50));
        JTF_Descricao.requestFocus();
        
        JRB_Quant_Dias.setSelected(true);
        JTF_Quant_Dias.setEnabled(false);
        JTF_Data_Fabricado.setEnabled(false);
        JTF_Data_Validade.setEnabled(false);
        JRB_Data.setEnabled(false);
        JRB_Quant_Dias.setEnabled(false);
        JTF_Lote.setEnabled(false);
        Setar_Atalho_BT();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBG_Validade = new javax.swing.ButtonGroup();
        BT_Sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Add_Itens = new javax.swing.JTable();
        JP_Dados_Entrada = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTF_Cod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTF_Descricao = new javax.swing.JTextField();
        BT_Procurar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JTF_Quant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTF_Data_Validade = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        JTF_Lote = new javax.swing.JTextField();
        BT_Adicionar = new javax.swing.JButton();
        JTF_Quant_Dias = new javax.swing.JTextField();
        JRB_Data = new javax.swing.JRadioButton();
        JRB_Quant_Dias = new javax.swing.JRadioButton();
        JTF_Data_Fabricado = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JTF_Preco = new javax.swing.JFormattedTextField();
        JTF_Un = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        BT_Excluir = new javax.swing.JButton();
        BT_Salvar = new javax.swing.JButton();
        JP_Descricao_Entrada = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JTF_Descricao_Entrada = new javax.swing.JTextField();
        JL_Campos = new javax.swing.JLabel();
        JTF_Quant_Item = new javax.swing.JLabel();
        JL_Quant_Itens1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Entrada De Produtos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Entrada Mercadoria 24x24.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(805, 635));
        setMinimumSize(new java.awt.Dimension(805, 635));
        setPreferredSize(new java.awt.Dimension(805, 635));
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
                formInternalFrameOpened(evt);
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

        JTB_Add_Itens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Add_Itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade", "Validade", "Lote", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTB_Add_Itens.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTB_Add_Itens);
        if (JTB_Add_Itens.getColumnModel().getColumnCount() > 0) {
            JTB_Add_Itens.getColumnModel().getColumn(0).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(0).setPreferredWidth(80);
            JTB_Add_Itens.getColumnModel().getColumn(1).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(1).setPreferredWidth(350);
            JTB_Add_Itens.getColumnModel().getColumn(2).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(2).setPreferredWidth(100);
            JTB_Add_Itens.getColumnModel().getColumn(3).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(3).setPreferredWidth(100);
            JTB_Add_Itens.getColumnModel().getColumn(4).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(4).setPreferredWidth(100);
            JTB_Add_Itens.getColumnModel().getColumn(5).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        JP_Dados_Entrada.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados Dos Itens"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Código:");

        JTF_Cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Produto*:");

        JTF_Descricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_DescricaoActionPerformed(evt);
            }
        });

        BT_Procurar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Procurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Search_24x24.png"))); // NOI18N
        BT_Procurar.setText("(F3)");
        BT_Procurar.setToolTipText("Clique Para Pesquisar Um Produto");
        BT_Procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ProcurarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Quantidade*:");

        JTF_Quant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Quant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_QuantFocusGained(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Data Fabricação*:");

        JTF_Data_Validade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Data_Validade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTF_Data_ValidadeFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Validade*:");

        JTF_Lote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Lote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_LoteFocusGained(evt);
            }
        });

        BT_Adicionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Add_24x24.png"))); // NOI18N
        BT_Adicionar.setText("(F4)");
        BT_Adicionar.setToolTipText("Clique Para Adicinar O Produto");
        BT_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AdicionarActionPerformed(evt);
            }
        });

        JTF_Quant_Dias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Quant_Dias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_Quant_DiasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTF_Quant_DiasFocusLost(evt);
            }
        });
        JTF_Quant_Dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Quant_DiasActionPerformed(evt);
            }
        });

        JBG_Validade.add(JRB_Data);
        JRB_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Data.setText("Vencimento");
        JRB_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_DataActionPerformed(evt);
            }
        });

        JBG_Validade.add(JRB_Quant_Dias);
        JRB_Quant_Dias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Quant_Dias.setText("Dia");
        JRB_Quant_Dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_Quant_DiasActionPerformed(evt);
            }
        });

        JTF_Data_Fabricado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Data_Fabricado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTF_Data_FabricadoFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Lote*:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Preço:");

        JTF_Preco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        JTF_Preco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Un.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JP_Dados_EntradaLayout = new javax.swing.GroupLayout(JP_Dados_Entrada);
        JP_Dados_Entrada.setLayout(JP_Dados_EntradaLayout);
        JP_Dados_EntradaLayout.setHorizontalGroup(
            JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                        .addComponent(JRB_Quant_Dias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTF_Quant_Dias, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JRB_Data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTF_Data_Validade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTF_Lote, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                    .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                        .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                                .addComponent(JTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                                .addComponent(JTF_Quant, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                                .addComponent(JTF_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(JTF_Data_Fabricado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                                .addComponent(JTF_Descricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTF_Un, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Adicionar)
                    .addComponent(BT_Procurar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        JP_Dados_EntradaLayout.setVerticalGroup(
            JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(JTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(JTF_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTF_Un, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BT_Procurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(JTF_Quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel8)
                        .addComponent(JTF_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JTF_Data_Fabricado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(JTF_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(JRB_Quant_Dias)
                        .addComponent(JTF_Quant_Dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JRB_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BT_Adicionar)
                    .addComponent(JTF_Data_Validade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Quantidade De Itens");

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

        JP_Descricao_Entrada.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Descrição Da Entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Descrição*:");

        JTF_Descricao_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Descricao_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Descricao_EntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Descricao_EntradaLayout = new javax.swing.GroupLayout(JP_Descricao_Entrada);
        JP_Descricao_Entrada.setLayout(JP_Descricao_EntradaLayout);
        JP_Descricao_EntradaLayout.setHorizontalGroup(
            JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Descricao_EntradaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTF_Descricao_Entrada, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
        );
        JP_Descricao_EntradaLayout.setVerticalGroup(
            JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Descricao_EntradaLayout.createSequentialGroup()
                .addGroup(JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JTF_Descricao_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        JTF_Quant_Item.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JTF_Quant_Item.setText("0");

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Sair | F3 - Consultar | F4 - Adicionar | F9 - Excluir Linha | F10 - Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_Dados_Entrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTF_Quant_Item, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Salvar)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JP_Descricao_Entrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JL_Campos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Quant_Itens1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Descricao_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JP_Dados_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JL_Campos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Quant_Itens1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(JTF_Quant_Item))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BT_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        setBounds(20, 20, 840, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Sair_Sem_Salvar();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AdicionarActionPerformed
        Preencher_Validade();
        if(JTF_Cod.getText().equalsIgnoreCase(""))
        {        
        }else
        {
        Testar_Campos();
        }
    }//GEN-LAST:event_BT_AdicionarActionPerformed

    private void BT_ProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ProcurarActionPerformed
        Pesquisa = JTF_Descricao.getText().trim();
        Limpar_Campos();
        Mostrar_Consulta_Prod();
        JTF_Quant.requestFocus();
        
    }//GEN-LAST:event_BT_ProcurarActionPerformed

    private void JTF_DescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_DescricaoActionPerformed
        Pesquisa = JTF_Descricao.getText().trim();
        Mostrar_Consulta_Prod();
        JTF_Quant.requestFocus();
        
    }//GEN-LAST:event_JTF_DescricaoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        JTF_Descricao.requestFocus();
    }//GEN-LAST:event_formInternalFrameOpened

    private void JTF_QuantFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_QuantFocusGained
        try{
            if(JTF_Cod.getText().equalsIgnoreCase(""))
            {
                JTF_Descricao.setEnabled(true);
            }else{
                ObjControlEnt.Controla_Lote(Integer.parseInt(JTF_Cod.getText()));
                if (ObjControlEnt.ControlaLote == true) {
                    JTF_Lote.setEnabled(true);
                    JTF_Data_Validade.setEnabled(!true);
                    JTF_Data_Fabricado.setEnabled(true);
                    JTF_Quant_Dias.setEnabled(true);
                    JRB_Data.setEnabled(true);
                    JRB_Quant_Dias.setEnabled(true);
                    JRB_Quant_Dias.setSelected(true);
                } else {
                    JTF_Lote.setEnabled(false);
                    JTF_Data_Validade.setEnabled(false);
                    JTF_Data_Fabricado.setEnabled(false);
                    JTF_Quant_Dias.setEnabled(false);
                    JRB_Data.setEnabled(false);
                    JRB_Quant_Dias.setEnabled(false);
                }
            }
        }catch(NumberFormatException e){}      
    }//GEN-LAST:event_JTF_QuantFocusGained

    private void BT_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ExcluirActionPerformed
        Remove_Item();
    }//GEN-LAST:event_BT_ExcluirActionPerformed

    private void JTF_Quant_DiasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_Quant_DiasFocusGained
        
    }//GEN-LAST:event_JTF_Quant_DiasFocusGained

    private void JRB_Quant_DiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_Quant_DiasActionPerformed
        JTF_Quant_Dias.setEnabled(true);
        JTF_Data_Validade.setEnabled(false);
        JTF_Quant_Dias.setText("");
    }//GEN-LAST:event_JRB_Quant_DiasActionPerformed

    private void JRB_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_DataActionPerformed
        JTF_Quant_Dias.setEnabled(!true);
        JTF_Data_Validade.setEnabled(!false);
        JTF_Data_Validade.setDate(null);
    }//GEN-LAST:event_JRB_DataActionPerformed

    private void JTF_Quant_DiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Quant_DiasActionPerformed
        Setar_Data();
        JTF_Lote.requestFocus();
    }//GEN-LAST:event_JTF_Quant_DiasActionPerformed

    private void JTF_Quant_DiasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_Quant_DiasFocusLost
        if(!JTF_Quant_Dias.getText().equalsIgnoreCase("") && JTF_Data_Fabricado.getDate()!=null){
        Setar_Data();}
    }//GEN-LAST:event_JTF_Quant_DiasFocusLost

    private void JTF_Data_ValidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_Data_ValidadeFocusLost
        if(JTF_Data_Validade.getDate()!= null && JTF_Data_Fabricado.getDate()!=null){
        Setar_Dias();}
        
    }//GEN-LAST:event_JTF_Data_ValidadeFocusLost

    private void JTF_LoteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_LoteFocusGained
      if(JRB_Data.isSelected()){          
                if(JTF_Data_Validade.getDate()!= null && JTF_Data_Fabricado.getDate()!=null){
                    Preencher_Validade();
            }
            if(JRB_Quant_Dias.isSelected()){
                if(!JTF_Quant_Dias.getText().equalsIgnoreCase("") && JTF_Data_Fabricado.getDate()!=null){
                    Preencher_Validade();
                }
                
            }
        }
    }//GEN-LAST:event_JTF_LoteFocusGained

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        int linha = JTB_Add_Itens.getRowCount();
        if(linha <=0){
            Mostrar_Nao_Ha_Itens_Salvar();
        }else{
            if(JTF_Descricao_Entrada.getText().equalsIgnoreCase("")){
                Mostrar_Preencher_Campos();
            }else{
                Mostrar_Conf_Salvar();}
        }
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JTF_Data_FabricadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_Data_FabricadoFocusLost
     if(JRB_Data.isSelected()){
         if(JTF_Data_Validade.getDate()!=null && JTF_Data_Fabricado.getDate()!=null){
             Setar_Dias();
         }
     }
     if(JRB_Quant_Dias.isSelected()){
        if(!JTF_Quant_Dias.getText().equalsIgnoreCase("") && JTF_Data_Fabricado.getDate()!=null){
            Setar_Data();
        }
    }
    }//GEN-LAST:event_JTF_Data_FabricadoFocusLost

    private void JTF_Descricao_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Descricao_EntradaActionPerformed
        JTF_Descricao.requestFocus();
    }//GEN-LAST:event_JTF_Descricao_EntradaActionPerformed

     public void Inserir_Entrada(){       
        try {
            ObjConecta.Conectar();//Abre a conexão            
            //Faz a Entrada
            ObjModeloEntrada.setDescricao(JTF_Descricao_Entrada.getText().trim());
            ObjControlEnt.Inserir_Entrada(ObjModeloEntrada,new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));              
            //Busca o ultimo Id inserido           
            ObjConecta.ExecutaSQL("Select * from entrada");
            ObjConecta.rs.last();
            int Id_Entrada = ObjConecta.rs.getInt("id_entrada");
            //Conta quantas linha tem para inserção
            int Quant_Linhas = JTB_Add_Itens.getRowCount();                       
            //Laço para fazer todas as inserçoes no banco de entrada de itens
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Add_Itens.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    
                    if(JTB_Add_Itens.getValueAt(Linha, 3).equals("")){   //Produto sem validade     
                    
                        int Id_Produto = (Integer.parseInt((String)JTB_Add_Itens.getValueAt(Linha, 0)));//Pega o id do produto na linha da tabela
                        double Quantidade =  (Double.parseDouble((String) JTB_Add_Itens.getValueAt(Linha, 2)));//pega a quantidade na linha da tabela
                        String Validade = null;
                        String Lote = (String.valueOf(JTB_Add_Itens.getValueAt(Linha, 4)));//pega o lote na linha da tabela
                        if(JTB_Add_Itens.getValueAt(Linha, 5).equals("")){
                            ObjControlProd.Buscar_Ultimo_Preco(ObjModeloProd, Id_Produto);}
                        else{
                            ObjModeloProd.setPreco(Double.parseDouble((String) JTB_Add_Itens.getValueAt(Linha, 5)));//pega o preço na linha da tabela
                        }
                        ObjControlEnt.Inserir_Entrada_Itens(Id_Produto,Id_Entrada,Quantidade,Lote,Validade,ObjModeloProd.getPreco());//Metodo para inserira no banco
                        ObjControlEnt.Inseri_Atualiza_Lote_Estoque(Id_Produto, Quantidade, Lote, Validade);
                        ObjControlProd.Atualiza_Preco_Produto(ObjModeloProd,Id_Produto);
                    }
                    else{//Com validade
                        int Id_Produto = (Integer.parseInt((String)JTB_Add_Itens.getValueAt(Linha, 0)));//Pega o id do produto na linha da tabela
                        double Quantidade =  (Double.parseDouble((String) JTB_Add_Itens.getValueAt(Linha, 2)));//pega a quantidade na linha da tabela
                        String Validade = (String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format
                        (new SimpleDateFormat("dd-MM-yyyy").parse((String) (JTB_Add_Itens.getValueAt(Linha, 3))))));//pega a trata a data de validade
                        String Lote = (String.valueOf(JTB_Add_Itens.getValueAt(Linha, 4)));//pega o lote na linha da tabela
                        if(JTB_Add_Itens.getValueAt(Linha, 5).equals("")){
                            ObjControlProd.Buscar_Ultimo_Preco(ObjModeloProd, Id_Produto);}
                        else{
                            ObjModeloProd.setPreco(Double.parseDouble((String) JTB_Add_Itens.getValueAt(Linha, 5)));//pega o preço na linha da tabela
                        }

                        ObjControlEnt.Inserir_Entrada_Itens(Id_Produto,Id_Entrada,Quantidade,Lote,Validade, ObjModeloProd.getPreco());//Metodo para inserira no banco
                        ObjControlEnt.Inseri_Atualiza_Lote_Estoque(Id_Produto, Quantidade, Lote, Validade);
                        ObjControlProd.Atualiza_Preco_Produto(ObjModeloProd,Id_Produto);
                    }
                } catch (NumberFormatException | ParseException ex){
                    ObjControlEnt.Excluir_Entrada(Id_Entrada);
                    JOptionPane.showMessageDialog(rootPane, "Erro No Laço: "+ex);}
            }
            if(ObjControlEnt.Confirma_Entrada_Item == true){
            ConfirmaEntrada=true;
            ObjControlEnt.Efetivar_Entrada(Id_Entrada, "EFETIVADA");
            ObjControlEnt.Confirma_Entrada_Item = false;
            }else{
                ObjControlEnt.Excluir_Entrada(Id_Entrada);
                ConfirmaEntrada = false;
            }
            ObjConecta.Desconecta();
        } catch (SQLException | HeadlessException ex) {
            ObjConecta.Desconecta();
            ConfirmaEntrada=false;
            JOptionPane.showMessageDialog(rootPane,"Erro na entrada de produtos \n"+ex);
        }
    }
          
    public void Add_Tabela(){
       if(JTF_Data_Validade.getDate()== null)
       {
            String cod = JTF_Cod.getText().trim();
            String descricao = JTF_Descricao.getText().trim();
            String quant = JTF_Quant.getText().trim().replace(",", ".");
            String lote = JTF_Lote.getText().trim();
            String data = "";
            String preco = JTF_Preco.getText().trim().replace(",", ".");
       
            DefaultTableModel tb = (DefaultTableModel)JTB_Add_Itens.getModel();
            tb.addRow(new String[]{cod,descricao,quant,data,lote,preco});
            JTB_Add_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
            JTF_Quant_Item.setText(String.valueOf(JTB_Add_Itens.getRowCount()));
       }else
       {
            String cod = JTF_Cod.getText().trim();
            String descricao = JTF_Descricao.getText().trim();
            String quant = JTF_Quant.getText().trim().replace(",", ".");
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String data = (String.valueOf(df.format(JTF_Data_Validade.getDate())));
            String lote = JTF_Lote.getText().trim();
            String preco = JTF_Preco.getText().trim().replace(",", ".");
       
            DefaultTableModel tb = (DefaultTableModel)JTB_Add_Itens.getModel();
            tb.addRow(new String[]{cod,descricao,quant,data,lote,preco});
            JTB_Add_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
            JTF_Quant_Item.setText(String.valueOf(JTB_Add_Itens.getRowCount()));
       }
   } 
    
   public void Testar_Campos(){
       ObjControlEnt.Controla_Lote(Integer.parseInt(JTF_Cod.getText()));
       if(ObjControlEnt.ControlaLote == false){ 
           
            if((JTF_Cod.getText().equalsIgnoreCase(""))
                ||(JTF_Descricao.getText().equalsIgnoreCase(""))
                ||(JTF_Quant.getText().equalsIgnoreCase("")))
            {
                Mostrar_Preencher_Campos();
            }
            else
            {
               Verifica_Se_Existe();
               if (VerificaExistente == true) {
                   Mostrar_Produto_Existente();
                   VerificaExistente = false;
               } else {
                   if(Integer.parseInt(JTF_Quant.getText())<=0){
                       Mostrar_Quantidade_Invalida();
                   }else{                       
                        Add_Tabela();
                        Limpar_Campos();
                        JTF_Descricao.requestFocus();
                        JTF_Descricao.setEnabled(true);
                        JTF_Lote.setEnabled(false);
                        JTF_Quant_Dias.setEnabled(false);
                        JTF_Data_Validade.setEnabled(false);
                   }
               }
           }
        }else{  
                if((JTF_Cod.getText().equalsIgnoreCase(""))
                ||(JTF_Descricao.getText().equalsIgnoreCase(""))
                ||(JTF_Quant.getText().equalsIgnoreCase("")))
                {
                    Mostrar_Preencher_Campos();
                }
                else{                                       
                    if((JTF_Lote.getText().equalsIgnoreCase(""))
                        ||(JTF_Data_Validade.getDate() == null)
                        ||(JTF_Data_Fabricado.getDate() == null)
                        ||(JTF_Quant_Dias.getText().equalsIgnoreCase(""))){
                        Mostrar_Preencher_Lote_Validade();
                    }else{
                        Verifica_Se_Existe_Lote();
                        if(VerificaExistenteLote == true){
                            Mostrar_Produto_Existente_Lote();
                            VerificaExistenteLote=false;
                        }else{
                            if(Integer.parseInt(JTF_Quant.getText())<=0){
                                Mostrar_Quantidade_Invalida();
                            }else{
                                Verifica_Validade();
                                if(DataMenor == true){
                                    Mostrar_Produto_Vencido();
                                    DataMenor=false;
                                }else{
                                    Verifica_Fabricacao();
                                        if(FabricacaoMaior == true){
                                            Mostrar_Data_Fabricacao_Maior();
                                            FabricacaoMaior = false;}
                                    else{
                                        Verifica_Validade_30_Dias();
                                            if(Menos30Dias == true){
                                                Mostrar_Add_Na_Tabela();
                                                Menos30Dias = false;}
                                            else{
                                            Add_Tabela();
                                            Limpar_Campos();
                                            JTF_Descricao.requestFocus();
                                            JTF_Descricao.setEnabled(true);
                                            JTF_Lote.setEnabled(false);
                                            JTF_Quant_Dias.setEnabled(false);
                                            JTF_Data_Validade.setEnabled(false);
                                            JRB_Data.setEnabled(false);
                                            JRB_Quant_Dias.setEnabled(false);
                                            JTF_Data_Fabricado.setEnabled(false);
                                        }
                                    } 
                                }
                            }
                        }
                    }
                }
            }
    }
   public void Add_Na_Tabela(){
       Add_Tabela();
       Limpar_Campos();
       JTF_Descricao.requestFocus();
       JTF_Descricao.setEnabled(true);
       JTF_Lote.setEnabled(false);
       JTF_Quant_Dias.setEnabled(false);
       JTF_Data_Validade.setEnabled(false);
       JRB_Data.setEnabled(false);
       JRB_Quant_Dias.setEnabled(false);
       JTF_Data_Fabricado.setEnabled(false);
   }
   public void Nao_Add_Na_Tabela(){
       Limpar_Campos();
       JTF_Descricao.requestFocus();
       JTF_Descricao.setEnabled(true);
       JTF_Lote.setEnabled(false);
       JTF_Quant_Dias.setEnabled(false);
       JTF_Data_Validade.setEnabled(false);
       JRB_Data.setEnabled(false);
       JRB_Quant_Dias.setEnabled(false);
       JTF_Data_Fabricado.setEnabled(false);
   }
   
    public void Verifica_Se_Existe(){
        int Quant_Linhas = JTB_Add_Itens.getRowCount();
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Add_Itens.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    String Id_Produto = ((String)JTB_Add_Itens.getValueAt(Linha, 0));
                        if(Id_Produto.equalsIgnoreCase(JTF_Cod.getText()))
                        {
                            VerificaExistente=true;
                        }
                    }catch(NumberFormatException ex){
                        
                }
            }
    }
     public void Verifica_Se_Existe_Lote(){
        int Quant_Linhas = JTB_Add_Itens.getRowCount();
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Add_Itens.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    String Id_Produto = ((String)JTB_Add_Itens.getValueAt(Linha, 0));
                    String Lote = ((String)JTB_Add_Itens.getValueAt(Linha, 4));
                        if(Id_Produto.equalsIgnoreCase(JTF_Cod.getText())&&(Lote.equalsIgnoreCase(JTF_Lote.getText())))
                        {
                            VerificaExistenteLote=true;
                        }
                    }catch(NumberFormatException ex){
                        
                }
            }
    }
   
    public void Remove_Item(){       
        int Sel_Linha = JTB_Add_Itens.getSelectedRow();
        int Linha = JTB_Add_Itens.getRowCount();
        if(Linha == 0){
            Mostrar_Nao_Existe_Linha();
        }else{
            if (Sel_Linha >= 0) {
                Mostrar_Excluir_Linha();
                }
            else{
                Mostrar_Selecione_Linha();
            }
        }
    }
    
    public void Excluir_Linha(){
        (( DefaultTableModel)JTB_Add_Itens.getModel()).removeRow(JTB_Add_Itens.getSelectedRow());
        int cont = JTB_Add_Itens.getRowCount();
        JTF_Quant_Item.setText(String.valueOf(cont));
    }
    
    public void Sair_Sem_Salvar(){
        int cont = JTB_Add_Itens.getRowCount();
        if(cont > 0 || !JTF_Descricao_Entrada.getText().equalsIgnoreCase("")){
            Mostrar_Sair_Sem_Salvar();
        }else{
            dispose();
        }
    }
    
    public void Conf_Inserir_Entrada(){
       Inserir_Entrada();
        if (ConfirmaEntrada == true) 
            {
                Mostrar_Dados_Salvos();                
                Limpar_Tabela();
                JTF_Descricao_Entrada.setText("");
                ConfirmaEntrada = false;
            }
            else{
                Mostrar_Dados_Nao_Salvos();
                ConfirmaEntrada = false;
            }
        }
      
    public void Setar_Campo_Cod_Desc(String Desc,int id, String un){
        JTF_Cod.setText(String.valueOf(id));
        JTF_Descricao.setText(Desc);
        JTF_Un.setText(un);
    }
  
    public void Limpar_Campos(){
      JTF_Cod.setText("");
      JTF_Descricao.setText("");
      JTF_Quant.setText("");
      JTF_Data_Validade.setDate(null);
      JTF_Data_Fabricado.setDate(null);
      JTF_Preco.setValue(null);
      JTF_Lote.setText("");
      JTF_Quant_Dias.setText("");
    }
    
    public void Setar_Data(){
        Date d1 = JTF_Data_Fabricado.getDate();
        int dia = Integer.parseInt(new SimpleDateFormat("dd").format(d1));
        int mes = Integer.parseInt(new SimpleDateFormat("MM").format(d1))-1;
        int ano = Integer.parseInt(new SimpleDateFormat("yyyy").format(d1));
        GregorianCalendar c = new GregorianCalendar(ano, mes, dia);
        c.add(Calendar.DAY_OF_MONTH, +Integer.parseInt(JTF_Quant_Dias.getText())); //diminuir datas
        JTF_Data_Validade.setDate(c.getTime());
    }
    
    public void Setar_Dias(){
        
        Date d1 = JTF_Data_Fabricado.getDate();
        Date d2 = JTF_Data_Validade.getDate();
        long dt = (((d2.getTime() - d1.getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
        JTF_Quant_Dias.setText(String.valueOf(dt));
    }
     public void Setar_Dias2(){
        Date d1 = JTF_Data_Fabricado.getDate();
        Date d2 = JTF_Data_Validade.getDate();
        long dt = (((d2.getTime() - d1.getTime()) + 3600000) / 86400000L)+1;//Quantidade de dias entra as datas
        JTF_Quant_Dias.setText(String.valueOf(dt));
    }
    public void Preencher_Validade(){
        if(JRB_Data.isSelected()){          
                if(JTF_Data_Validade.getDate()!= null && JTF_Data_Fabricado.getDate()!=null){
                    Date dt1 = JTF_Data_Fabricado.getDate();
                    Date dt2 = JTF_Data_Validade.getDate();
                    if(dt1.before(dt2)){
                            Setar_Dias();}
                }
            }         
            if(JRB_Quant_Dias.isSelected()){
                if(!JTF_Quant_Dias.getText().equalsIgnoreCase("") && JTF_Data_Fabricado.getDate()!=null){
                    Setar_Data();
                }else{}
            }
    }
    public void Verifica_Validade(){
        Date dt1 = new Date(System.currentTimeMillis());  
        Date dt2 = JTF_Data_Validade.getDate();

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
    public void Verifica_Validade_30_Dias(){
        Date d1 = new GregorianCalendar().getTime();
        Date d2 = JTF_Data_Validade.getDate();
        long dt = (((d2.getTime() - d1.getTime()) + 3600000) / 86400000L)+1;//Quantidade de dias entra as datas
            if(dt<30){
                Menos30Dias=true;
            }
    }
    public void Verifica_Fabricacao(){
        Date dt1 = JTF_Data_Fabricado.getDate();
        Date dt2 = new Date(System.currentTimeMillis());  
            if(dt2.before(dt1)){
                FabricacaoMaior = true;}
    }
    
    public final void Limpar_Tabela() {
        (( DefaultTableModel)JTB_Add_Itens.getModel()).setNumRows(0);
        int cont = JTB_Add_Itens.getRowCount();
        JTF_Quant_Item.setText(String.valueOf(cont));
    }
    
    public void Mostrar_Consulta_Prod(){        
        ObjConsultaProdDl = new Tela_Consulta_Produto_Entrada_DL(this, true);
        ObjConsultaProdDl.setVisible(true); 
    }
    void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Ent(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    void Mostrar_Preencher_Lote_Validade(){
        ObjPreencherLote = new Inf_Preencher_Lote_Validade_Ent(this, true);
        ObjPreencherLote.setVisible(true);
    }
    void Mostrar_Conf_Salvar(){
        ObjConfSalvar = new Conf_Salvar_Ent(this, true);
        ObjConfSalvar.setVisible(true);        
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Ent(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Ent(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Ent (this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    void Mostrar_Produto_Existente(){
        ObjProdExistente = new Inf_Produto_Existente_Ent(this, true);
        ObjProdExistente.setVisible(true);
    }
    void Mostrar_Produto_Existente_Lote(){
        ObjProdExistenteLote = new Inf_Produto_Existente_Lote_Ent(this, true);
        ObjProdExistenteLote.setVisible(true);
    }
    void Mostrar_Quantidade_Invalida(){
        ObjQuantInvalida = new Inf_Quant_Invalida_Ent(this, true);
        ObjQuantInvalida.setVisible(true);
    }
    void Mostrar_Selecione_Linha(){
        ObjSelecioneLinha = new Inf_Selecione_Linha_Ent(this, true);
        ObjSelecioneLinha.setVisible(true);
    }
    void Mostrar_Nao_Existe_Linha(){
        ObjNaoExisteLinha = new Inf_Nao_Existe_Linha_Ent(this, true);
        ObjNaoExisteLinha.setVisible(true);
    }
    void Mostrar_Nao_Ha_Itens_Salvar(){
        ObjNaoHaItensSalvar = new Inf_Nao_Ha_Itens_Salvar_Ent(this, true);
        ObjNaoHaItensSalvar.setVisible(true);
    }
    void Mostrar_Excluir_Linha(){
        ObjExcluir = new Conf_Excluir_Ent(this, true);
        ObjExcluir.setVisible(true);
    }
    void Mostrar_Add_Na_Tabela(){
        ObjAddTabela = new Conf_Add_Tabela_Ent(this, true);
        ObjAddTabela.setVisible(true);
    }
    void Mostrar_Produto_Vencido(){
        ObjProdVencido = new Inf_Prod_Vencido_Ent(this, true);
        ObjProdVencido.setVisible(true);
    }
    void Mostrar_Data_Fabricacao_Maior(){
        ObjDataFabMaior = new Inf_Data_Fabricacao_Maior_Ent(this, true);
        ObjDataFabMaior.setVisible(true);
    }
    
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),"Procurar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
        
        InputMap inputMap3 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0),"Adicionar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);
        
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0),"Salvar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap4);
                
        InputMap inputMap5 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap5.put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0),"Excluir");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap5);
        //método para executar
         this.getRootPane().getActionMap().put("Salvar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Salvar.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Procurar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Procurar.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Sair.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Adicionar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Adicionar.doClick();
        }
        });
       
         this.getRootPane().getActionMap().put("Excluir", new AbstractAction(){
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
    private javax.swing.ButtonGroup JBG_Validade;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JPanel JP_Dados_Entrada;
    private javax.swing.JPanel JP_Descricao_Entrada;
    private javax.swing.JRadioButton JRB_Data;
    private javax.swing.JRadioButton JRB_Quant_Dias;
    private javax.swing.JTable JTB_Add_Itens;
    private javax.swing.JTextField JTF_Cod;
    private com.toedter.calendar.JDateChooser JTF_Data_Fabricado;
    private com.toedter.calendar.JDateChooser JTF_Data_Validade;
    private javax.swing.JTextField JTF_Descricao;
    private javax.swing.JTextField JTF_Descricao_Entrada;
    private javax.swing.JTextField JTF_Lote;
    private javax.swing.JFormattedTextField JTF_Preco;
    private javax.swing.JTextField JTF_Quant;
    private javax.swing.JTextField JTF_Quant_Dias;
    private javax.swing.JLabel JTF_Quant_Item;
    private javax.swing.JTextField JTF_Un;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

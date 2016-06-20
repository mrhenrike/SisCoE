package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Entrada_Produto;
import Classes.Modelo_Lote_Estoque;
import Classes.Modelo_Produto;
import Classes.Modelo_Tabela;
import Conexao.Conecta_Banco;
import Conexao.Controle_Entrada_Produto;
import Conexao.Controle_Log;
import Conexao.Controle_Lote_Estoque;
import Conexao.Controle_Produto;
import GUI_Dialogs_Entrada.Conf_Add_Tabela_Ent_Cont;
import GUI_Dialogs_Entrada.Conf_Excluir_Ent_Cont;
import GUI_Dialogs_Entrada.Conf_Excluir_Ent_Cont_Iten;
import GUI_Dialogs_Entrada.Conf_Sair_Sem_Salvar_Ent_Cont;
import GUI_Dialogs_Entrada.Conf_Salvar_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Dados_Nao_Salvos_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Dados_Salvos_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Data_Fabricacao_Maior_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Entrada_Nao_Encontrada_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Impossivel_Alterar_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Impossivel_Excluir_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Impossivel_Excluir_Estoque_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Nao_Existe_Linha_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Nao_Ha_Itens_Salvar_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Preencher_Campos_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Preencher_Campos_Id_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Preencher_Fabricacao_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Preencher_Lote_Validade_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Prod_Vencido_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Produto_Existente_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Produto_Existente_Lote_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Quant_Invalida_Ent_Cont;
import GUI_Dialogs_Entrada.Inf_Selecione_Linha_Ent_Cont;
import static GUI_Frames.Tela_Principal.CodLogado;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class Tela_Entrada_Produto_Cont extends javax.swing.JInternalFrame {
    
    public static Tela_Entrada_Produto_Cont Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Entrada_Produto_Cont();
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
    Conecta_Banco ObjConecta_2 = new Conecta_Banco();
    Controle_Produto ObjControlProd = new Controle_Produto();
    Controle_Entrada_Produto ObjControlEnt = new Controle_Entrada_Produto();
    Controle_Lote_Estoque ObjControlLote = new Controle_Lote_Estoque();
    Modelo_Entrada_Produto ObjModeloEntrada = new Modelo_Entrada_Produto();
    Modelo_Produto ObjModeloProd = new Modelo_Produto();
    Modelo_Lote_Estoque ObjModLote = new Modelo_Lote_Estoque();
    Formatacao ObjFormat = new Formatacao();
       
    private static Inf_Preencher_Campos_Ent_Cont ObjPreencherCampos;
    private static Inf_Preencher_Fabricacao_Ent_Cont ObjPreencherFabricacao;
    private static Inf_Preencher_Lote_Validade_Ent_Cont ObjPreencherLote;
    private static Inf_Dados_Salvos_Ent_Cont ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_Ent_Cont ObjDadosNaoSalvos;
    private static Conf_Salvar_Ent_Cont ObjConfSalvar;
    private static Conf_Sair_Sem_Salvar_Ent_Cont ObjSairSemSalvar;
    private static Inf_Produto_Existente_Ent_Cont ObjProdExistente;
    private static Inf_Produto_Existente_Lote_Ent_Cont ObjProdExistenteLote;
    private static Inf_Quant_Invalida_Ent_Cont ObjQuantInvalida;
    private static Inf_Selecione_Linha_Ent_Cont ObjSelecioneLinha;
    private static Inf_Nao_Existe_Linha_Ent_Cont ObjNaoExisteLinha;
    private static Inf_Nao_Ha_Itens_Salvar_Ent_Cont ObjNaoHaItensSalvar;
    private static Conf_Excluir_Ent_Cont ObjExcluir;
    private static Conf_Add_Tabela_Ent_Cont ObjAddTabela;
    private static Inf_Prod_Vencido_Ent_Cont ObjProdVencido;
    private static Inf_Data_Fabricacao_Maior_Ent_Cont ObjDataFabMaior;
    private static Inf_Impossivel_Alterar_Ent_Cont ObjImpossivelAlterarEntrada;
    private static Inf_Preencher_Campos_Id_Ent_Cont ObjPreencherCamposId;
    private static Inf_Entrada_Nao_Encontrada_Ent_Cont ObjEntradaNaoEncontrada;
    private static Conf_Excluir_Ent_Cont_Iten ObjConfExcluir;
    private static Inf_Impossivel_Excluir_Ent_Cont ObjImpossivelExcluir;
    private static Inf_Impossivel_Excluir_Estoque_Ent_Cont ObjImpossivelEstoque;
    
    public String Pesquisa;
    public String Pesquisa_Entrada;
    public boolean ProcuraEstoque;
    boolean ConfirmaEntrada;
    boolean VerificaExistente;
    boolean VerificaExistenteLote;
    boolean VerificaExistenteEntrada;
    boolean VerificaExistenteLoteEntrada;
    boolean Menos30Dias;
    boolean DataMenor;
    boolean FabricacaoMaior;
    
    private static Tela_Consulta_Produto_Entrada_Cont_DL ObjConsultaProdDl;
    private static Tela_Consulta_Entrada_Cont_DL DLConsultaEntradaDL;
    
    
    public Tela_Entrada_Produto_Cont() {
        initComponents();
       
        JTF_Cod.setEnabled(false);
        JTF_Un.setEnabled(false);
        JTF_Descricao_Entrada.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Descricao_Prod.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Quant.setDocument(ObjFormat.new Format_Valor(10));
        JTF_Lote.setDocument(ObjFormat.new Format_Geral(50));
        JTF_Pesquisa.setDocument(ObjFormat.new Format_Geral(50));
        JTF_Descricao_Prod.requestFocus();
        JTF_Descricao_Entrada.setEnabled(false);
        JTF_Cod_Entrada.setEnabled(false);
        
        JRB_Quant_Dias.setSelected(true);
        JTF_Quant_Dias.setEnabled(false);
        JTF_Data_Fabricado.setEnabled(false);
        JTF_Data_Validade.setEnabled(false);
        JRB_Data.setEnabled(false);
        JRB_Quant_Dias.setEnabled(false);
        JTF_Lote.setEnabled(false);
        Setar_Atalho_BT();
        
        JTB_Itens_Entrada.setEnabled(true);
        BT_Remove_Item.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBG_Validade = new javax.swing.ButtonGroup();
        BT_Sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Itens_Entrada = new javax.swing.JTable();
        JP_Dados_Entrada = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTF_Cod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTF_Descricao_Prod = new javax.swing.JTextField();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        JTB_Add_Itens = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        BT_Salvar = new javax.swing.JButton();
        JP_Descricao_Entrada = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JTF_Descricao_Entrada = new javax.swing.JTextField();
        JTF_Cod_Entrada = new javax.swing.JTextField();
        JL_Campos = new javax.swing.JLabel();
        JL_Quant_Item = new javax.swing.JLabel();
        JL_Informacao = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JTF_Pesquisa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BT_Confirmar = new javax.swing.JButton();
        BT_Procurar_Entrada = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        JL_Quant_Item_Add = new javax.swing.JLabel();
        BT_Remove_Item = new javax.swing.JButton();
        BT_Remove_Item_Novo = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("43 - Entrada De Produtos");
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

        JTB_Itens_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Itens_Entrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Itens_Entrada.getTableHeader().setReorderingAllowed(false);
        JTB_Itens_Entrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_Itens_EntradaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Itens_Entrada);

        JP_Dados_Entrada.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados Dos Itens"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Código:");

        JTF_Cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Produto*:");

        JTF_Descricao_Prod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Descricao_Prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Descricao_ProdActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fabricação:");

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
                .addGap(21, 21, 21)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTF_Cod)
                    .addComponent(JTF_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                        .addComponent(JTF_Descricao_Prod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTF_Un, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                        .addComponent(JTF_Data_Fabricado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JRB_Quant_Dias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTF_Quant_Dias, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JRB_Data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTF_Data_Validade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTF_Quant)
                    .addComponent(JTF_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BT_Adicionar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Procurar))
                .addContainerGap())
        );
        JP_Dados_EntradaLayout.setVerticalGroup(
            JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                        .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(JTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(JTF_Descricao_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTF_Un, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(JTF_Quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BT_Procurar))
                        .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(JRB_Quant_Dias)
                                            .addComponent(JTF_Quant_Dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JRB_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(JP_Dados_EntradaLayout.createSequentialGroup()
                                            .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel8)
                                                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel4)
                                                    .addComponent(JTF_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(JTF_Data_Fabricado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(3, 3, 3))))
                                .addComponent(JTF_Data_Validade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Dados_EntradaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(JP_Dados_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(JTF_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(BT_Adicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTB_Add_Itens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Add_Itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade", "Un", "Validade", "Lote", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTB_Add_Itens.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(JTB_Add_Itens);
        if (JTB_Add_Itens.getColumnModel().getColumnCount() > 0) {
            JTB_Add_Itens.getColumnModel().getColumn(0).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(0).setPreferredWidth(80);
            JTB_Add_Itens.getColumnModel().getColumn(1).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(1).setPreferredWidth(500);
            JTB_Add_Itens.getColumnModel().getColumn(2).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(2).setPreferredWidth(100);
            JTB_Add_Itens.getColumnModel().getColumn(3).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(3).setPreferredWidth(50);
            JTB_Add_Itens.getColumnModel().getColumn(4).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(4).setPreferredWidth(100);
            JTB_Add_Itens.getColumnModel().getColumn(5).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(5).setPreferredWidth(100);
            JTB_Add_Itens.getColumnModel().getColumn(6).setResizable(false);
            JTB_Add_Itens.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Itens Entrada:");

        BT_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar.png"))); // NOI18N
        BT_Salvar.setMnemonic('s');
        BT_Salvar.setToolTipText("Clique Para Salvar Ou Pressione Alt + S");
        BT_Salvar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar Press.png"))); // NOI18N
        BT_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SalvarActionPerformed(evt);
            }
        });

        JP_Descricao_Entrada.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Código E Descrição Da Entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Descrição*:");

        JTF_Descricao_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Descricao_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Descricao_EntradaActionPerformed(evt);
            }
        });

        JTF_Cod_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JP_Descricao_EntradaLayout = new javax.swing.GroupLayout(JP_Descricao_Entrada);
        JP_Descricao_Entrada.setLayout(JP_Descricao_EntradaLayout);
        JP_Descricao_EntradaLayout.setHorizontalGroup(
            JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Descricao_EntradaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTF_Cod_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTF_Descricao_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JP_Descricao_EntradaLayout.setVerticalGroup(
            JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Descricao_EntradaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JTF_Cod_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Descricao_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        JL_Quant_Item.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Item.setText("0");

        JL_Informacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Informacao.setText("Esc - Sair | F3 - Consultar | F4 - Adicionar | F9 - Excluir Linha | F10 - Salvar");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Pesquisa Entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTF_Pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Pesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_PesquisaFocusGained(evt);
            }
        });
        JTF_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_PesquisaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Número Ou descrição*:");

        BT_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Ativar 24x24.png"))); // NOI18N
        BT_Confirmar.setToolTipText("Clique Para Confirmar Um Produto");
        BT_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ConfirmarActionPerformed(evt);
            }
        });

        BT_Procurar_Entrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Search_24x24.png"))); // NOI18N
        BT_Procurar_Entrada.setToolTipText("Clique Para Pesquisar Um Produto");
        BT_Procurar_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Procurar_EntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_Confirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BT_Procurar_Entrada)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(BT_Confirmar)
                    .addComponent(BT_Procurar_Entrada))
                .addGap(5, 5, 5))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Novos Itens:");

        JL_Quant_Item_Add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Item_Add.setText("0");

        BT_Remove_Item.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Remove_Item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/messagebox_critical.png"))); // NOI18N
        BT_Remove_Item.setToolTipText("Selecione Uma Linha E Clique Para Excluir");
        BT_Remove_Item.setContentAreaFilled(false);
        BT_Remove_Item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Remove_ItemActionPerformed(evt);
            }
        });

        BT_Remove_Item_Novo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Remove_Item_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/messagebox_critical.png"))); // NOI18N
        BT_Remove_Item_Novo.setToolTipText("Selecione Uma Linha E Clique Para Excluir");
        BT_Remove_Item_Novo.setContentAreaFilled(false);
        BT_Remove_Item_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Remove_Item_NovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JL_Quant_Item, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JL_Quant_Item_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JL_Campos))
                            .addComponent(JL_Informacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Salvar)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JP_Dados_Entrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JP_Descricao_Entrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BT_Remove_Item, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BT_Remove_Item_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JP_Descricao_Entrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Remove_Item))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JP_Dados_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BT_Remove_Item_Novo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Informacao)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JL_Quant_Item, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JL_Campos)
                            .addComponent(jLabel11)
                            .addComponent(JL_Quant_Item_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BT_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(BT_Salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(9, 9, 9))
        );

        setBounds(20, 20, 1111, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Sair_Sem_Salvar();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AdicionarActionPerformed
        Preencher_Validade();
        if(JTF_Cod_Entrada.getText().equalsIgnoreCase("")){
            Mostrar_Preencher_Campos_Id();
        }else{
            if(JTF_Cod.getText().equalsIgnoreCase("")){        
            }else{
                if(JRB_Quant_Dias.isSelected() && JTF_Data_Fabricado.getDate()==null && !JTF_Quant_Dias.getText().equalsIgnoreCase("") ){
                    Mostrar_Preencher_Data_Fabricacao();
                }else{
                    Testar_Campos_Adicionar();
                }
            }
        }
    }//GEN-LAST:event_BT_AdicionarActionPerformed

    private void BT_ProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ProcurarActionPerformed
        Pesquisa = JTF_Descricao_Prod.getText().trim();
        Limpar_Campos();
        Mostrar_Consulta_Prod();                
        if(!JTF_Cod.getText().equalsIgnoreCase("")){
            Habilita_Lote();
            JTF_Quant.requestFocus();
        }
    }//GEN-LAST:event_BT_ProcurarActionPerformed

    private void JTF_Descricao_ProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Descricao_ProdActionPerformed
        Pesquisa = JTF_Descricao_Prod.getText().trim();
        Limpar_Campos();
        Mostrar_Consulta_Prod();                
        if(!JTF_Cod.getText().equalsIgnoreCase("")){
            Habilita_Lote();
            JTF_Quant.requestFocus();
        }        
    }//GEN-LAST:event_JTF_Descricao_ProdActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        JTF_Descricao_Prod.requestFocus();
    }//GEN-LAST:event_formInternalFrameOpened

    private void JRB_Quant_DiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_Quant_DiasActionPerformed
        JTF_Quant_Dias.setEnabled(true);
        JTF_Data_Validade.setEnabled(false);
        JTF_Quant_Dias.setText("");
        JTF_Data_Validade.setDate(null);
    }//GEN-LAST:event_JRB_Quant_DiasActionPerformed

    private void JRB_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_DataActionPerformed
        JTF_Quant_Dias.setEnabled(!true);
        JTF_Quant_Dias.setText("");
        JTF_Data_Validade.setEnabled(!false);
        JTF_Data_Validade.setDate(null);
    }//GEN-LAST:event_JRB_DataActionPerformed

    private void JTF_Quant_DiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Quant_DiasActionPerformed
        if(JTF_Data_Fabricado.getDate()!=null){
            Setar_Data();
            JTF_Lote.requestFocus();
        }else{
            Mostrar_Preencher_Data_Fabricacao();
        }
        
    }//GEN-LAST:event_JTF_Quant_DiasActionPerformed

    private void JTF_Data_ValidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_Data_ValidadeFocusLost
        if(JTF_Data_Validade.getDate()!= null && JTF_Data_Fabricado.getDate()!=null){
            Setar_Dias();}
        
    }//GEN-LAST:event_JTF_Data_ValidadeFocusLost

    private void JTF_LoteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_LoteFocusGained
        if(JRB_Data.isSelected()){          
            if(JTF_Data_Validade.getDate()!= null && JTF_Data_Fabricado.getDate()!=null){
                    Preencher_Validade();
            }
        }
        if(JRB_Quant_Dias.isSelected()){            
            if(!JTF_Quant_Dias.getText().equalsIgnoreCase("") && JTF_Data_Fabricado.getDate()!=null){
                    Preencher_Validade();
                }
        }
       
    }//GEN-LAST:event_JTF_LoteFocusGained

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        int linha = JTB_Add_Itens.getRowCount();
        if(linha <=0){
            Mostrar_Nao_Ha_Itens_Salvar();
        }else{
            if(JTF_Descricao_Entrada.getText().equalsIgnoreCase("")  && JTF_Cod_Entrada.getText().equalsIgnoreCase("")){
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
        JTF_Descricao_Prod.requestFocus();
    }//GEN-LAST:event_JTF_Descricao_EntradaActionPerformed

    private void JTF_PesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_PesquisaFocusGained
        //PesquisarNome();
    }//GEN-LAST:event_JTF_PesquisaFocusGained

    private void JTF_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PesquisaActionPerformed
        int cont = JTB_Add_Itens.getRowCount();
        
            if(cont > 0){
                Mostrar_Impossivel_Alterar_Entrada();
                JTF_Cod.setText("");
            }else{
                Pesquisa_Automatica();
            }
        
    }//GEN-LAST:event_JTF_PesquisaActionPerformed

    private void BT_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConfirmarActionPerformed
        int cont = JTB_Add_Itens.getRowCount();
        if(JTF_Pesquisa.getText().equalsIgnoreCase("")){
            Mostrar_Preencher_Campos();
        }else{
            if(cont > 0){
                Mostrar_Impossivel_Alterar_Entrada();
                JTF_Cod.setText("");
            }else{
                Pesquisa_Automatica();
            }     
        }
    }//GEN-LAST:event_BT_ConfirmarActionPerformed

    private void BT_Procurar_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Procurar_EntradaActionPerformed
        int cont = JTB_Add_Itens.getRowCount();
        if(cont > 0){
            Mostrar_Impossivel_Alterar_Entrada();
            JTF_Cod.setText("");
        }else{
            Pesquisa_Entrada = JTF_Pesquisa.getText();
            Mostrar_Consulta_Entrada();
        }         
    }//GEN-LAST:event_BT_Procurar_EntradaActionPerformed

    private void BT_Remove_ItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Remove_ItemActionPerformed
        Excluir_Item_Entrada();
    }//GEN-LAST:event_BT_Remove_ItemActionPerformed

    private void BT_Remove_Item_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Remove_Item_NovoActionPerformed
        Remove_Item();
    }//GEN-LAST:event_BT_Remove_Item_NovoActionPerformed

    private void JTB_Itens_EntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Itens_EntradaMouseClicked
        BT_Remove_Item.setEnabled(true);
    }//GEN-LAST:event_JTB_Itens_EntradaMouseClicked

     public void Inserir_Entrada(){       
        try {
            ObjConecta.Conectar();//Abre a conexão            
            //seta o id da entrada
            int Id_Entrada = Integer.parseInt(JTF_Cod_Entrada.getText());
            ObjControlEnt.Confirma_Entrada = true;
            //Conta quantas linha tem para inserção
            int Quant_Linhas = JTB_Add_Itens.getRowCount();                       
            //Laço para fazer todas as inserçoes no banco de entrada de itens
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Add_Itens.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    
                    if(JTB_Add_Itens.getValueAt(Linha, 4).equals("")){   //Produto sem validade     
                        try{
                            int Id_Produto = (Integer.parseInt((String)JTB_Add_Itens.getValueAt(Linha, 0)));//Pega o id do produto na linha da tabela
                            double Quantidade =  (Double.parseDouble((String) JTB_Add_Itens.getValueAt(Linha, 2)));//pega a quantidade na linha da tabela
                            String Validade = null;
                            String Lote = (String.valueOf(JTB_Add_Itens.getValueAt(Linha, 5)));//pega o lote na linha da tabela
                            //verifica o preço
                            if(JTB_Add_Itens.getValueAt(Linha, 6).equals("")){
                                ObjControlProd.Buscar_Ultimo_Preco(ObjModeloProd, Id_Produto);}
                            else{
                                ObjModeloProd.setPreco(Double.parseDouble((String) JTB_Add_Itens.getValueAt(Linha, 6)));//pega o preço na linha da tabela
                            }
                            ObjControlEnt.Inserir_Entrada_Itens(Id_Produto,Id_Entrada,Quantidade,Lote,Validade,ObjModeloProd.getPreco());//Metodo para inserir o iten no banco
                            if(ObjControlEnt.Confirma_Entrada_Item == true){//se for inserido
                                ObjControlEnt.Inseri_Atualiza_Estoque(Id_Produto, Quantidade);//atualiza o estoque
                                ObjControlProd.Atualiza_Preco_Produto(ObjModeloProd,Id_Produto);//atualiza o preço
                                ObjControlEnt.Confirma_Entrada_Item = false;
                            }
                        }catch(NumberFormatException | Error ex){JOptionPane.showMessageDialog(rootPane, "Erro ao inserir o iten!\n"+ex);}
                    }
                    else{//Com validade
                        try{
                            int Id_Produto = (Integer.parseInt((String)JTB_Add_Itens.getValueAt(Linha, 0)));//Pega o id do produto na linha da tabela
                            double Quantidade =  (Double.parseDouble((String) JTB_Add_Itens.getValueAt(Linha, 2)));//pega a quantidade na linha da tabela
                            String Validade = (String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format
                            (new SimpleDateFormat("dd-MM-yyyy").parse((String) (JTB_Add_Itens.getValueAt(Linha, 4))))));//pega e trata a data de validade
                            String Lote = (String.valueOf(JTB_Add_Itens.getValueAt(Linha, 5)));//pega o lote na linha da tabela
                            //verifica o preço
                            if(JTB_Add_Itens.getValueAt(Linha, 6).equals("")){
                                ObjControlProd.Buscar_Ultimo_Preco(ObjModeloProd, Id_Produto);}
                            else{
                                ObjModeloProd.setPreco(Double.parseDouble((String) JTB_Add_Itens.getValueAt(Linha, 6)));//pega o preço na linha da tabela
                            }

                            ObjControlEnt.Inserir_Entrada_Itens(Id_Produto,Id_Entrada,Quantidade,Lote,Validade, ObjModeloProd.getPreco());//Metodo para inserira no banco
                            if(ObjControlEnt.Confirma_Entrada_Item == true){//se for inserido
                                ObjControlEnt.Inseri_Atualiza_Lote_Estoque_(Id_Produto, Quantidade, Lote, Validade);//atualiza o estoque
                                ObjControlProd.Atualiza_Preco_Produto(ObjModeloProd,Id_Produto);//atualiza o preço
                                ObjControlEnt.Confirma_Entrada_Item = false;
                            }
                        }catch(NumberFormatException | ParseException | Error ex){JOptionPane.showMessageDialog(rootPane, "Erro ao inserir o iten com lote!\n"+ex);}
                    }
                } catch (NumberFormatException | Error ex){
                    JOptionPane.showMessageDialog(rootPane, "Erro No Laço: "+ex);}
            }
            if(ObjControlEnt.Confirma_Entrada == true){//entrada confirmada
                ConfirmaEntrada=true;
                ObjControlEnt.Atualiza_Situacao_Entrada(Id_Entrada, "EFETIVADA COM ALTERAÇÃO");//altera o status da entrada
                ObjControlEnt.Atualiza_Data_Alteracao_Entrada(Id_Entrada);//altera a data de alteração
                ObjControlEnt.Confirma_Entrada = false;
            }
            ObjControlEnt.Verifica_Entrada_Sem_Itens(Id_Entrada);//verifica se a entrada existe itens
            if(ObjControlEnt.Verifica_Entrada_Sem_Itens == false){//se não existir
                ObjControlEnt.Excluir_Entrada(Id_Entrada);//exclui a entrada
                new Controle_Log().Registrar_Log("Inserida e excluída a entrada id: "+ObjModeloEntrada.getId_entrada(), CodLogado);
                ConfirmaEntrada = false;
            }
            ObjConecta.Desconecta();
        } catch (HeadlessException ex) {
            ObjConecta.Desconecta();
            ConfirmaEntrada=false;
            JOptionPane.showMessageDialog(rootPane,"Erro na entrada de produtos \n"+ex);
        }
    }
          
    public void Add_Tabela(){
       if(JTF_Data_Validade.getDate()== null)
       {
            String cod = JTF_Cod.getText().trim();
            String descricao = JTF_Descricao_Prod.getText().trim();
            String unidade = JTF_Un.getText().trim();
            String quant = JTF_Quant.getText().trim().replace(",", ".");
            String lote = JTF_Lote.getText().trim();
            String data = "";
            String preco = JTF_Preco.getText().trim().replace(",", ".");
       
            DefaultTableModel tb = (DefaultTableModel)JTB_Add_Itens.getModel();
            tb.addRow(new String[]{cod,descricao,quant,unidade,data,lote,preco});
            JTB_Add_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
            JL_Quant_Item_Add.setText(String.valueOf(JTB_Add_Itens.getRowCount()));
       }else
       {
            String cod = JTF_Cod.getText().trim();
            String descricao = JTF_Descricao_Prod.getText().trim();
            String unidade = JTF_Un.getText().trim();
            String quant = JTF_Quant.getText().trim().replace(",", ".");
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String data = (String.valueOf(df.format(JTF_Data_Validade.getDate())));
            String lote = JTF_Lote.getText().trim();
            String preco = JTF_Preco.getText().trim().replace(",", ".");
       
            DefaultTableModel tb = (DefaultTableModel)JTB_Add_Itens.getModel();
            tb.addRow(new String[]{cod,descricao,quant,unidade,data,lote,preco});
            JTB_Add_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
            JL_Quant_Item_Add.setText(String.valueOf(JTB_Add_Itens.getRowCount()));
       }
   } 
    
   public void Testar_Campos_Adicionar(){
       if(JTF_Lote.getText().equalsIgnoreCase("")){       
//       ObjControlEnt.Controla_Lote(Integer.parseInt(JTF_Cod.getText()));//testa lote
//       if(ObjControlEnt.ControlaLote == false){ //sem lote
           
            if((JTF_Cod.getText().equalsIgnoreCase(""))
                ||(JTF_Descricao_Prod.getText().equalsIgnoreCase(""))
                ||(JTF_Quant.getText().equalsIgnoreCase("")))
            {
                Mostrar_Preencher_Campos();
            }
            else
            {
                Verifica_Se_Existe_Entrada();
                Verifica_Se_Existe();
              
               if (VerificaExistente == true || VerificaExistenteEntrada == true) {
                   Mostrar_Produto_Existente();
                   VerificaExistente = false;
                   VerificaExistenteEntrada = false;
               } else {
                   if(Integer.parseInt(JTF_Quant.getText())<=0){
                       Mostrar_Quantidade_Invalida();
                   }else{                       
                        Add_Tabela();
                        Limpar_Campos();
                        JTF_Descricao_Prod.requestFocus();
                        JTF_Descricao_Prod.setEnabled(true);
                        JTF_Lote.setEnabled(false);
                        JTF_Quant_Dias.setEnabled(false);
                        JTF_Data_Validade.setEnabled(false);
                   }
               }
           }
        }else{  //com lote
                if((JTF_Cod.getText().equalsIgnoreCase(""))
                ||(JTF_Descricao_Prod.getText().equalsIgnoreCase(""))
                ||(JTF_Quant.getText().equalsIgnoreCase("")))
                {
                    Mostrar_Preencher_Campos();
                }
                else{                        
                    if((JTF_Lote.getText().equalsIgnoreCase(""))
                        ||(JTF_Data_Validade.getDate() == null)){
                        Mostrar_Preencher_Lote_Validade();                        
                    }else{
                        Verifica_Se_Existe_Lote_Entrada();
                        Verifica_Se_Existe_Lote();
                        
                        if(VerificaExistenteLote == true || VerificaExistenteLoteEntrada == true){
                            Mostrar_Produto_Existente_Lote();
                            VerificaExistenteLote=false;
                            VerificaExistenteLoteEntrada = false;
                        }else{
                            if(Integer.parseInt(JTF_Quant.getText())<=0){
                                Mostrar_Quantidade_Invalida();
                            }else{
                                Verifica_Validade();
                                if(DataMenor == true){
                                    Mostrar_Produto_Vencido();
                                    DataMenor=false;
                                }else{
                                    if(JRB_Quant_Dias.isSelected() && JTF_Data_Fabricado.getDate()!=null){
                                        Verifica_Fabricacao();
                                        if(FabricacaoMaior == true){
                                            Mostrar_Data_Fabricacao_Maior();
                                            FabricacaoMaior = false;
                                            JTF_Lote.requestFocus();
                                        }else {
                                            Verifica_Validade_30_Dias();
                                            if (Menos30Dias == true) {
                                                Mostrar_Add_Na_Tabela();
                                                Menos30Dias = false;
                                            } else {
                                                Add_Tabela();
                                                Limpar_Campos();
                                                JTF_Descricao_Prod.requestFocus();
                                                JTF_Descricao_Prod.setEnabled(true);
                                                JTF_Lote.setEnabled(false);
                                                JTF_Quant_Dias.setEnabled(false);
                                                JTF_Data_Validade.setEnabled(false);
                                                JRB_Data.setEnabled(false);
                                                JRB_Quant_Dias.setEnabled(false);
                                                JTF_Data_Fabricado.setEnabled(false);
                                            }   
                                        }
                                    }else{
                                        Verifica_Validade_30_Dias();
                                        if (Menos30Dias == true) {
                                            Mostrar_Add_Na_Tabela();
                                            Menos30Dias = false;
                                        } else {
                                            Add_Tabela();
                                            Limpar_Campos();
                                            JTF_Descricao_Prod.requestFocus();
                                            JTF_Descricao_Prod.setEnabled(true);
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
            ObjControlEnt.ControlaLote = false;
            }
    }
   
   public void Add_Na_Tabela(){
       Add_Tabela();
       Limpar_Campos();
       JTF_Descricao_Prod.requestFocus();
       JTF_Descricao_Prod.setEnabled(true);
       JTF_Lote.setEnabled(false);
       JTF_Quant_Dias.setEnabled(false);
       JTF_Data_Validade.setEnabled(false);
       JRB_Data.setEnabled(false);
       JRB_Quant_Dias.setEnabled(false);
       JTF_Data_Fabricado.setEnabled(false);
   }
   public void Nao_Add_Na_Tabela(){
       Limpar_Campos();
       JTF_Descricao_Prod.requestFocus();
       JTF_Descricao_Prod.setEnabled(true);
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
    
    public void Verifica_Se_Existe_Entrada(){
        int Quant_Linhas = JTB_Itens_Entrada.getRowCount();
        JTB_Itens_Entrada.setRowSelectionInterval(0,0); 
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Itens_Entrada.setRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    String Id_Produto = String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 0));
                    String Lote = String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 5));
                        if(Id_Produto.equalsIgnoreCase(JTF_Cod.getText()) && Lote.equalsIgnoreCase(""))
                        {
                            VerificaExistenteEntrada = true;
                        }
                    }catch(NumberFormatException ex){
                            VerificaExistenteEntrada = false;
                }
            }
    }
    
     public void Verifica_Se_Existe_Lote(){
        int Quant_Linhas = JTB_Add_Itens.getRowCount();
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Add_Itens.setRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    String Id_Produto = ((String)JTB_Add_Itens.getValueAt(Linha, 0));
                    String Lote = ((String)JTB_Add_Itens.getValueAt(Linha, 5));
                    String Validade = String.valueOf(JTB_Add_Itens.getValueAt(Linha, 4));//validade na tabela                    
                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    String data = (String.valueOf(df.format(JTF_Data_Validade.getDate())));//validade do campo
                        if(Id_Produto.equalsIgnoreCase(JTF_Cod.getText())&&(Lote.equalsIgnoreCase(JTF_Lote.getText()))
                                &&(Validade.equalsIgnoreCase(data)))
                        {
                            VerificaExistenteLote=true;
                        }
                    }catch(NumberFormatException ex){
                            VerificaExistenteLote=false;
                }
            }
    }
     
     public void Verifica_Se_Existe_Lote_Entrada(){
        int Quant_Linhas = JTB_Itens_Entrada.getRowCount();
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Itens_Entrada.setRowSelectionInterval(Linha, Linha);//seta na primeira linha da tabela
                    String Id_Produto = String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 0));
                    String Lote = String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 5));
                    String Validade = String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 4));//validade na tabela                    
                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    String data = (String.valueOf(df.format(JTF_Data_Validade.getDate())));//validade do campo
                    
                        if(Id_Produto.equalsIgnoreCase(JTF_Cod.getText())&&(Lote.equalsIgnoreCase(JTF_Lote.getText()))
                                &&(Validade.equalsIgnoreCase(data)))
                        {
                            VerificaExistenteLoteEntrada = true;
                        }
                    }catch(NumberFormatException ex){
                            VerificaExistenteLoteEntrada = false;
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
    
    public void Excluir_Linha(){//exclui linha da tabela
        (( DefaultTableModel)JTB_Add_Itens.getModel()).removeRow(JTB_Add_Itens.getSelectedRow());
        int cont = JTB_Add_Itens.getRowCount();
        JL_Quant_Item_Add.setText(String.valueOf(cont));
    }
    
    public void Sair_Sem_Salvar(){
        int cont = JTB_Add_Itens.getRowCount();
        if(cont > 0 ){
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
                new Controle_Log().Registrar_Log("Adicionou novos itens a entrada id: "+JTF_Cod_Entrada.getText()+" - "+JTF_Descricao_Entrada.getText()
                        +" (Quantidade de itens adicionados: "+JL_Quant_Item_Add.getText()+")", CodLogado);
                Limpar_Tabela_Itens_Entrada();
                Limpar_Tabela();
                JTF_Descricao_Entrada.setText("");
                JTF_Cod_Entrada.setText("");
                JTF_Descricao_Entrada.setText("");
                ConfirmaEntrada = false;
            }
            else{
                Mostrar_Dados_Nao_Salvos();
                new Controle_Log().Registrar_Log("erro ao adicionar novos itens a entrada id: "+JTF_Cod_Entrada.getText()+" - "+JTF_Descricao_Entrada.getText(), CodLogado);
                ConfirmaEntrada = false;
            }
        }
      
    public void Setar_Campo_Cod_Desc(String Desc,int id, String un){
        JTF_Cod.setText(String.valueOf(id));
        JTF_Descricao_Prod.setText(Desc);
        JTF_Un.setText(un);
    }
  
    public void Limpar_Campos(){
      JTF_Cod.setText("");
      JTF_Descricao_Prod.setText("");
      JTF_Un.setText("");
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
        c.add(Calendar.DAY_OF_MONTH, +Integer.parseInt(JTF_Quant_Dias.getText())); //calculo das datas
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
                        Setar_Dias();
                    }
                }
            }         
        if(JRB_Quant_Dias.isSelected()){
            if(!JTF_Quant_Dias.getText().equalsIgnoreCase("") && JTF_Data_Fabricado.getDate()!=null){
                Setar_Data();
            }
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
    
    public final void Limpar_Tabela_Itens_Entrada() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{};//Seta os indices da tabela
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens_Entrada.setModel(tabela);
        JL_Quant_Item.setText("0");
    }
    public final void Limpar_Tabela() {
        (( DefaultTableModel)JTB_Add_Itens.getModel()).setNumRows(0);
        int cont = JTB_Add_Itens.getRowCount();
        JL_Quant_Item_Add.setText(String.valueOf(cont));
    }
    
    public void Habilita_Lote(){
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
    
    public void Setar_Campo_Descricao_Entrada(String descricao, String cod){//seta os campos o s itens da entrada pesquisada
        JTF_Descricao_Entrada.setText(descricao);
        JTF_Cod_Entrada.setText(cod);
        Preencher_Tabela_Itens_Entrada("select * from entrada inner join entrada_itens "
                        + "on entrada.id_entrada=entrada_itens.entrada_id_entrada inner join produto "
                        + "on produto.id_produto=entrada_itens.produto_id_produto where entrada_itens.entrada_id_entrada="+cod+"");
        JTF_Pesquisa.setText("");
        JL_Quant_Item.setText(String.valueOf(JTB_Itens_Entrada.getRowCount()));
        BT_Remove_Item.setEnabled(false);
    }
    
    void Pesquisa_Automatica(){//verifica se foi digitado texto ou numero e faz a consulta
        boolean ehNumero = true;
        try{
            Integer.parseInt(JTF_Pesquisa.getText());
        }catch(Exception e){
            ehNumero = false;
        }
        if(ehNumero == false){
            Pesquisa_Entrada = JTF_Pesquisa.getText();
            Mostrar_Consulta_Entrada();            
        }
        if(ehNumero == true){
            Testar_Campos_Pesquisa_Entrada();
        }
    }
    
    void Excluir_Item_Entrada(){//excluir item de entrada  ja efetivada
        int cont = JTB_Itens_Entrada.getRowCount();
        if(cont<=1){//se tiver apenas um item
            Mostrar_Impossivel_Excluir();
        }else{//se tiver mais de um item
            int Sel_Linha = JTB_Itens_Entrada.getSelectedRow();
            if (Sel_Linha >= 0){
                Mostrar_Excluir_Linha_Entrada();
            }
            else{
                Mostrar_Selecione_Linha();
            }
        }
    
    }
    
    public void Conf_Excluir_Iten_Entrada() {
        String Id_Produto = String.valueOf(JTB_Itens_Entrada.getValueAt(JTB_Itens_Entrada.getSelectedRow(), 0));//pega o id do produto na tabela
        String Lote_Produto = String.valueOf(JTB_Itens_Entrada.getValueAt(JTB_Itens_Entrada.getSelectedRow(), 5));//pega o lote do produto na tabela
        String Produto = String.valueOf(JTB_Itens_Entrada.getValueAt(JTB_Itens_Entrada.getSelectedRow(), 1));//pega o id do produto na tabela
        if (!Lote_Produto.equalsIgnoreCase("")) {//Com lote
            try {
                double Quant = Double.valueOf(String.valueOf(JTB_Itens_Entrada.getValueAt(JTB_Itens_Entrada.getSelectedRow(), 2)));//pega a quantidade do produto na tabela
                String Lote = String.valueOf(JTB_Itens_Entrada.getValueAt(JTB_Itens_Entrada.getSelectedRow(), 5));//pega o lote do produto na tabela
                String Validade = (String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MM-yyyy").parse((String) (JTB_Itens_Entrada.getValueAt(JTB_Itens_Entrada.getSelectedRow(), 4))))));//pega e trata a data de validade

                ObjControlLote.Quantidade_Estoque_Lote(ObjModLote, Integer.valueOf(Id_Produto), Lote, Validade);//buscar a quantidade existente do estoque com lote
                if (ObjModLote.getQuantidade_estoque() < Quant) {
                    Mostrar_Impossivel_Excluir_Estoque_Baixo();
                } else {
                    ObjControlEnt.Excluir_Item_Entrada_Efetivada_Lote_Atualiza_Estoque(ObjModLote, Id_Produto, JTF_Cod_Entrada.getText(), Lote, Validade, Quant);
                    if (ObjControlEnt.Confirma_Excluir_Item == true) {
                        //atualiza a tabela
                        Preencher_Tabela_Itens_Entrada("select * from entrada inner join entrada_itens "
                                + "on entrada.id_entrada=entrada_itens.entrada_id_entrada inner join produto "
                                + "on produto.id_produto=entrada_itens.produto_id_produto where entrada_itens.entrada_id_entrada=" + JTF_Cod_Entrada.getText() + "");
                        //log
                        new Controle_Log().Registrar_Log("Exclui um item da entrada id: "+JTF_Cod_Entrada.getText()+" - "+JTF_Descricao_Entrada.getText()
                        +" (id: "+Id_Produto+" - '"+Produto+"' - Quantidade: "+Quant+" - Lote: "+Lote+" - Validade: "+Validade+" )", CodLogado);
                        ObjControlEnt.Confirma_Excluir_Item = false;
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(Tela_Entrada_Produto_Cont.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {//não tem lote
            double Quant = Double.valueOf(String.valueOf(JTB_Itens_Entrada.getValueAt(JTB_Itens_Entrada.getSelectedRow(), 2)));//pega a quantidade do produto na tabela

            ObjControlLote.Quantidade_Estoque(ObjModLote, Integer.valueOf(Id_Produto));//buscar a quantidade existente do estoque sem lote
            if (ObjModLote.getQuantidade_estoque() < Quant) {
                Mostrar_Impossivel_Excluir_Estoque_Baixo();
            } else {
                ObjControlEnt.Excluir_Item_Entrada_Efetivada_Atualiza_Estoque(ObjModLote, Id_Produto, JTF_Cod_Entrada.getText(), Quant);
                if (ObjControlEnt.Confirma_Excluir_Item == true) {
                    //atualiza a tabela
                    Preencher_Tabela_Itens_Entrada("select * from entrada inner join entrada_itens "
                            + "on entrada.id_entrada=entrada_itens.entrada_id_entrada inner join produto "
                            + "on produto.id_produto=entrada_itens.produto_id_produto where entrada_itens.entrada_id_entrada=" + JTF_Cod_Entrada.getText() + "");
                    new Controle_Log().Registrar_Log("Exclui um item da entrada id: "+JTF_Cod_Entrada.getText()+" - "+JTF_Descricao_Entrada.getText()
                        +" (id: "+Id_Produto+" - '"+Produto+"' - Quantidade: "+Quant+" )", CodLogado);
                    ObjControlEnt.Confirma_Excluir_Item = false;
                }
            }
        }
    }
    
    void Testar_Campos_Pesquisa_Entrada(){//verifica a pesquisa de entrada atraves do id
        ObjControlEnt.Consulta_Entrada_Id_Ativo(Integer.parseInt(JTF_Pesquisa.getText().trim()));
        if(ObjControlEnt.Controle_Entrada == true){
            ObjControlEnt.Consulta_Entrada(ObjModeloEntrada, JTF_Pesquisa.getText());
            Setar_Campo_Descricao_Entrada(ObjModeloEntrada.getDescricao(), String.valueOf(ObjModeloEntrada.getId_entrada()));
            JTF_Descricao_Prod.requestFocus();
            ObjControlEnt.Controle_Entrada = false;
        }else{
            Mostrar_Entrada_Nao_Encontrada();
            JTF_Cod_Entrada.setText("");
            JTF_Descricao_Entrada.setText("");
            JTF_Pesquisa.setText("");
            Limpar_Tabela_Itens_Entrada();
            BT_Remove_Item.setEnabled(false);
        }
    }
    //Dialogs
    public void Mostrar_Consulta_Prod(){        
        ObjConsultaProdDl = new Tela_Consulta_Produto_Entrada_Cont_DL(this, true);
        ObjConsultaProdDl.setVisible(true); 
    }
    void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Ent_Cont(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    void Mostrar_Preencher_Campos_Id(){
        ObjPreencherCamposId = new Inf_Preencher_Campos_Id_Ent_Cont(this, true);
        ObjPreencherCamposId.setVisible(true);
    }
    void Mostrar_Preencher_Lote_Validade(){
        ObjPreencherLote = new Inf_Preencher_Lote_Validade_Ent_Cont(this, true);
        ObjPreencherLote.setVisible(true);
    }
    void Mostrar_Conf_Salvar(){
        ObjConfSalvar = new Conf_Salvar_Ent_Cont(this, true);
        ObjConfSalvar.setVisible(true);        
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Ent_Cont(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Ent_Cont(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Ent_Cont(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    void Mostrar_Produto_Existente(){
        ObjProdExistente = new Inf_Produto_Existente_Ent_Cont(this, true);
        ObjProdExistente.setVisible(true);
    }
    void Mostrar_Produto_Existente_Lote(){
        ObjProdExistenteLote = new Inf_Produto_Existente_Lote_Ent_Cont(this, true);
        ObjProdExistenteLote.setVisible(true);
    }
    void Mostrar_Quantidade_Invalida(){
        ObjQuantInvalida = new Inf_Quant_Invalida_Ent_Cont(this, true);
        ObjQuantInvalida.setVisible(true);
    }
    void Mostrar_Selecione_Linha(){
        ObjSelecioneLinha = new Inf_Selecione_Linha_Ent_Cont(this, true);
        ObjSelecioneLinha.setVisible(true);
    }
    void Mostrar_Nao_Existe_Linha(){
        ObjNaoExisteLinha = new Inf_Nao_Existe_Linha_Ent_Cont(this, true);
        ObjNaoExisteLinha.setVisible(true);
    }
    void Mostrar_Nao_Ha_Itens_Salvar(){
        ObjNaoHaItensSalvar = new Inf_Nao_Ha_Itens_Salvar_Ent_Cont(this, true);
        ObjNaoHaItensSalvar.setVisible(true);
    }
    void Mostrar_Excluir_Linha(){
        ObjExcluir = new Conf_Excluir_Ent_Cont(this, true);
        ObjExcluir.setVisible(true);
    }
    void Mostrar_Add_Na_Tabela(){
        ObjAddTabela = new Conf_Add_Tabela_Ent_Cont(this, true);
        ObjAddTabela.setVisible(true);
    }
    void Mostrar_Produto_Vencido(){
        ObjProdVencido = new Inf_Prod_Vencido_Ent_Cont(this, true);
        ObjProdVencido.setVisible(true);
    }
    void Mostrar_Data_Fabricacao_Maior(){
        ObjDataFabMaior = new Inf_Data_Fabricacao_Maior_Ent_Cont(this, true);
        ObjDataFabMaior.setVisible(true);
    }
    void Mostrar_Preencher_Data_Fabricacao(){
        ObjPreencherFabricacao = new Inf_Preencher_Fabricacao_Ent_Cont(this, true);
        ObjPreencherFabricacao.setVisible(true);
    }
    void Mostrar_Consulta_Entrada(){
        DLConsultaEntradaDL = new Tela_Consulta_Entrada_Cont_DL(this, true);
        DLConsultaEntradaDL.setVisible(true);
    }
    void Mostrar_Impossivel_Alterar_Entrada(){
        ObjImpossivelAlterarEntrada = new Inf_Impossivel_Alterar_Ent_Cont(this, true);
        ObjImpossivelAlterarEntrada.setVisible(true);
    }
    void Mostrar_Entrada_Nao_Encontrada(){
        ObjEntradaNaoEncontrada = new Inf_Entrada_Nao_Encontrada_Ent_Cont(this, true);
        ObjEntradaNaoEncontrada.setVisible(true);
    }
    void Mostrar_Excluir_Linha_Entrada(){
        ObjConfExcluir = new Conf_Excluir_Ent_Cont_Iten(this, true);
        ObjConfExcluir.setVisible(true);
    }
    void Mostrar_Impossivel_Excluir(){
        ObjImpossivelExcluir = new Inf_Impossivel_Excluir_Ent_Cont(this, true);
        ObjImpossivelExcluir.setVisible(true);
    }
    
    void Mostrar_Impossivel_Excluir_Estoque_Baixo(){
        ObjImpossivelEstoque = new Inf_Impossivel_Excluir_Estoque_Ent_Cont(this, true);
        ObjImpossivelEstoque.setVisible(true);
    }
    
    public final void Preencher_Tabela_Itens_Entrada(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Descrição","Quantidade","Un","Validade", "Lote", "Preço"};//Seta os indices da tabela
        ObjConecta_2.Conectar();
        ObjConecta_2.ExecutaSQL(SQL);
        try {
            ObjConecta_2.rs.first();
           
            do {
                String lote = ObjConecta_2.rs.getString("lote");
                Date validade = ObjConecta_2.rs.getDate("data_validade");
                String data_val= "";
                if((lote == null)||(lote.equalsIgnoreCase("null"))) {lote = "";}
                if(validade != null){data_val = String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta_2.rs.getDate("data_validade")));}
                
                dados.add(new Object[]{ObjConecta_2.rs.getInt("produto_id_produto"),ObjConecta_2.rs.getString("produto.descricao"),
                ObjConecta_2.rs.getDouble("quantidade"),ObjConecta_2.rs.getString("unidade"),data_val, lote, ObjConecta_2.rs.getDouble("preco")});
            } while (ObjConecta_2.rs.next());
            ObjConecta_2.Desconecta();
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens_Entrada.setModel(tabela);
        JTB_Itens_Entrada.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Itens_Entrada.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Itens_Entrada.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Itens_Entrada.getColumnModel().getColumn(1).setPreferredWidth(500);
        JTB_Itens_Entrada.getColumnModel().getColumn(1).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(2).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(3).setPreferredWidth(50);
        JTB_Itens_Entrada.getColumnModel().getColumn(3).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(4).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(5).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(6).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(6).setResizable(false);
        JTB_Itens_Entrada.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Itens_Entrada.setAutoResizeMode(JTB_Itens_Entrada.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(todas colunas)
        JTB_Itens_Entrada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela     
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
        BT_Remove_Item_Novo.doClick();
        }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Adicionar;
    private javax.swing.JButton BT_Confirmar;
    private javax.swing.JButton BT_Procurar;
    private javax.swing.JButton BT_Procurar_Entrada;
    private javax.swing.JButton BT_Remove_Item;
    private javax.swing.JButton BT_Remove_Item_Novo;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.ButtonGroup JBG_Validade;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Informacao;
    private javax.swing.JLabel JL_Quant_Item;
    private javax.swing.JLabel JL_Quant_Item_Add;
    private javax.swing.JPanel JP_Dados_Entrada;
    private javax.swing.JPanel JP_Descricao_Entrada;
    private javax.swing.JRadioButton JRB_Data;
    private javax.swing.JRadioButton JRB_Quant_Dias;
    private javax.swing.JTable JTB_Add_Itens;
    private javax.swing.JTable JTB_Itens_Entrada;
    private javax.swing.JTextField JTF_Cod;
    private javax.swing.JTextField JTF_Cod_Entrada;
    private com.toedter.calendar.JDateChooser JTF_Data_Fabricado;
    private com.toedter.calendar.JDateChooser JTF_Data_Validade;
    private javax.swing.JTextField JTF_Descricao_Entrada;
    private javax.swing.JTextField JTF_Descricao_Prod;
    private javax.swing.JTextField JTF_Lote;
    private javax.swing.JTextField JTF_Pesquisa;
    private javax.swing.JFormattedTextField JTF_Preco;
    private javax.swing.JTextField JTF_Quant;
    private javax.swing.JTextField JTF_Quant_Dias;
    private javax.swing.JTextField JTF_Un;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

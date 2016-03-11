package GUI_Frames;

import Classes.Modelo_Lote_Estoque;
import Classes.Modelo_Produto;
import Classes.Modelo_Saida_Produto;
import Conexao.Conecta_Banco;
import Conexao.Controle_Produto;
import Classes.Modelo_Tabela;
import Conexao.Controle_Entrada_Produto;
import Conexao.Controle_Lote_Estoque;
import Conexao.Controle_Saida_Produto;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// @author Márison Tamiarana
 
public class Tela_Consulta_Produto_Saida_DL extends javax.swing.JDialog {

    Conecta_Banco ObjConecta = new Conecta_Banco();
    Modelo_Produto ObjModeloProd = new Modelo_Produto();
    Controle_Produto ObjControlProd = new Controle_Produto();
    Tela_Saida_Produto ObjSaida = new Tela_Saida_Produto();
    Controle_Lote_Estoque ObjControlLote = new Controle_Lote_Estoque();
    Modelo_Lote_Estoque ObjModeloLote = new Modelo_Lote_Estoque();
    Formatacao ObjFormat = new Formatacao();
    Controle_Entrada_Produto ObjControlEnt = new Controle_Entrada_Produto();
    Modelo_Saida_Produto ObjModeloSaida = new Modelo_Saida_Produto();
    Controle_Saida_Produto ObjControlSaida = new Controle_Saida_Produto();
       
    int Cod;
    String data;//variavel para receber a data atual para comparar a validade
    
    public Tela_Consulta_Produto_Saida_DL(Tela_Saida_Produto parent, boolean modal) {
        this.ObjSaida = parent;
        this.setModal(modal);
        
        initComponents();
        setResizable(false);
        setSize(815,530);
        setLocationRelativeTo(ObjSaida);
        JTF_Pesquisa.setDocument(ObjFormat.new Format_Geral(50));
        JTF_Pesquisa.setText(ObjSaida.Pesquisa);
        Contar_Prod_Estoque();
        
      
         Preencher_Tabela("select distinct produto.id_produto, produto.descricao, categoria,  unidade, quantidade_minima "
        + "from produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
        + "inner join lote_estoque on produto.id_produto=lote_estoque.produto_id_produto where quantidade_estoque>0 "
        + "and produto.descricao like '%" + JTF_Pesquisa.getText().toUpperCase() + "%' "
        + "and produto.situacao='ATIVO' order by produto.descricao"); 
        
        ObjControlProd.Contar_Produtos_Ativos(JL_ItensCad);
        Setar_Atalho_BT();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Consulta_Prod = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        JTF_Pesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BT_Limpar = new javax.swing.JButton();
        BT_Sair = new javax.swing.JButton();
        BT_Adicionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JL_ItensCad = new javax.swing.JLabel();
        JTF_ItensEstoque = new javax.swing.JLabel();
        JL_Quant_Itens1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Produto");
        setName("Consulta Produto"); // NOI18N

        JTB_Consulta_Prod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Consulta_Prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Consulta_Prod.setToolTipText("Clique Duas Vezes Em Uma Linha Para Adicionar  Ou Selecione Uma Linha E Clique No Botão Adicionar (Alt+O)");
        JTB_Consulta_Prod.getTableHeader().setReorderingAllowed(false);
        JTB_Consulta_Prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_Consulta_ProdMouseClicked(evt);
            }
        });
        JTB_Consulta_Prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTB_Consulta_ProdKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Consulta_Prod);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Descrição:");

        BT_Limpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Remove_24x24.png"))); // NOI18N
        BT_Limpar.setText("(F8)");
        BT_Limpar.setToolTipText("Clique Para Limpar O Campo e Pesquisa");
        BT_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_LimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(JTF_Pesquisa)
                .addGap(18, 18, 18)
                .addComponent(BT_Limpar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BT_Limpar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
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

        BT_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Adicionar.png"))); // NOI18N
        BT_Adicionar.setMnemonic('o');
        BT_Adicionar.setToolTipText("Selecione Uma Linha E Clique Para Adicionar Ou Pressione Alt + O");
        BT_Adicionar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Adicionar Press.png"))); // NOI18N
        BT_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AdicionarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastrados:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Com Estoque:");

        JL_ItensCad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        JTF_ItensEstoque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Sair | F4/Enter - Adicionar | F8 - Limpar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JL_ItensCad, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTF_ItensEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                            .addComponent(JL_Quant_Itens1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BT_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JL_Quant_Itens1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JTF_ItensEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1))
                                    .addComponent(JL_ItensCad, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(BT_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(435, 435, 435))
        );

        setSize(new java.awt.Dimension(821, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTB_Consulta_ProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Consulta_ProdMouseClicked
        try {
            if (evt.getClickCount() == 2) {
                Object id_prod = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));  
                ObjSaida.unidade = String.valueOf(JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 3));
                ObjControlSaida.Controla_Lote(id_prod);
                if(ObjControlSaida.Controla_Lote==true){
                    Carregar_Dados_Produtos(id_prod);
                    dispose();
                    
                    ObjSaida.Mostrar_Escolha_Lote(id_prod);
                    ObjControlSaida.Controla_Lote=false;
                }else{
                    Carregar_Dados_Produtos(id_prod);
                    ObjSaida.Id_Prod = Integer.valueOf(String.valueOf(id_prod));
                    ObjSaida.Verifica_Se_Existe(id_prod);
                    dispose();
                    ObjSaida.Mostrar_Quantidade_Saida();
                }
            }
        } catch (SQLException ex) {
            
        }

    }//GEN-LAST:event_JTB_Consulta_ProdMouseClicked

    private void JTF_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PesquisaActionPerformed
        int quant_itens = JTB_Consulta_Prod.getRowCount();
            if(quant_itens>0){
                JTB_Consulta_Prod.setRowSelectionInterval(0, 0);
                JTB_Consulta_Prod.requestFocus();
            }
       
    }//GEN-LAST:event_JTF_PesquisaActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
        //Sair_Sem_Salvar();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AdicionarActionPerformed
        try {
        int linha_selecionada = JTB_Consulta_Prod.getSelectedRow();
            if (linha_selecionada >= 0)
                {
                Object resultado = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));
                ObjControlSaida.Controla_Lote(resultado);
                if(ObjControlSaida.Controla_Lote==true){
                    Carregar_Dados_Produtos(resultado);
                    dispose();
                    ObjSaida.Mostrar_Escolha_Lote(resultado);
                    ObjControlSaida.Controla_Lote=false;
                }else{
                    Carregar_Dados_Produtos(resultado);
                    ObjSaida.Id_Prod = Integer.valueOf(String.valueOf(resultado));
                    ObjSaida.Verifica_Se_Existe(resultado);
                    dispose();
                    ObjSaida.Mostrar_Quantidade_Saida();
                }
            }
            }catch (SQLException ex) {
                
            }
        
    }//GEN-LAST:event_BT_AdicionarActionPerformed

    private void BT_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_LimparActionPerformed
       JTF_Pesquisa.setText("");
       Preencher_Tabela("select distinct produto.id_produto, produto.descricao, categoria,  unidade, quantidade_minima "
        + "from produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
        + "inner join lote_estoque on produto.id_produto=lote_estoque.produto_id_produto where quantidade_estoque>0 "
        + "and produto.descricao like '%" + JTF_Pesquisa.getText().toUpperCase() + "%' "
        + "and produto.situacao='ATIVO' order by produto.descricao"); 
    }//GEN-LAST:event_BT_LimparActionPerformed

    private void JTF_PesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_PesquisaFocusGained
        PesquisarNome();
    }//GEN-LAST:event_JTF_PesquisaFocusGained

    private void JTB_Consulta_ProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTB_Consulta_ProdKeyPressed
         try {
            int linha_selecionada = JTB_Consulta_Prod.getSelectedRow();
            if (linha_selecionada >= 0)
                {
                if(evt.getKeyChar()==KeyEvent.VK_ENTER){
                    Object resultado = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));
                    ObjControlSaida.Controla_Lote(resultado);
                    if(ObjControlSaida.Controla_Lote==true){
                        Carregar_Dados_Produtos(resultado);
                        dispose();
                        ObjSaida.Mostrar_Escolha_Lote(resultado);
                        ObjControlSaida.Controla_Lote=false;
                    }else{
                        Carregar_Dados_Produtos(resultado);
                        ObjSaida.Id_Prod = Integer.valueOf(String.valueOf(resultado));
                        ObjSaida.Verifica_Se_Existe(resultado);
                        dispose();
                        ObjSaida.Mostrar_Quantidade_Saida();
                    }
                }
            }
            }catch (SQLException ex) {
                
            }   
         
    }//GEN-LAST:event_JTB_Consulta_ProdKeyPressed
 
    public void Carregar_Dados_Produtos(Object LinhaSelecionada) throws SQLException { 
              
       ObjModeloProd.setPesquisa(String.valueOf(LinhaSelecionada));
       ObjControlProd.Consulta_Produto(ObjModeloProd);
       ObjSaida.Setar_Campo_Cod_Desc(ObjModeloProd.getDescricao(),ObjModeloProd.getId_produto(), ObjModeloProd.getUnidade());
       
            
} 
 public void PesquisarNome() {

        JTF_Pesquisa.getDocument().addDocumentListener(new DocumentListener() {
            //ATUALIZA A CADA LETRA REMOVIDA================================================
            @Override
            public void removeUpdate(DocumentEvent e) {
                FiltrarNome();
            }
            //ATUALIZA A CADA LETRA INSERIDA================================================
            @Override
            public void insertUpdate(DocumentEvent e) {
                FiltrarNome();
            }
            //ATUALIZA A CADA LETRA ATUALIZADA OU TROCADA===================================
            @Override
            public void changedUpdate(DocumentEvent e) {
                FiltrarNome();
            }
        });
    }
    
    public void FiltrarNome() {
         Preencher_Tabela("select distinct produto.id_produto, produto.descricao, categoria,  unidade, quantidade_minima "
        + "from produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
        + "inner join lote_estoque on produto.id_produto=lote_estoque.produto_id_produto where quantidade_estoque>0 "
        + "and produto.descricao like '%" + JTF_Pesquisa.getText().toUpperCase() + "%' "
        + "and produto.situacao='ATIVO' order by produto.descricao"); 
    }
 
  
 public final void Preencher_Tabela(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Descrição","Categoria", "Unidade","Minimo"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();           
            do {
                //metodo para trazer o estoque de cada produto
                ObjControlLote.Consulta_Estoque_Produto(ObjModeloLote,ObjConecta.rs.getInt("id_produto"));
                
                //adicionando na tabela
                dados.add(new Object[]{ObjConecta.rs.getInt("id_produto"),ObjConecta.rs.getString("descricao"),
                ObjConecta.rs.getString("categoria"),ObjConecta.rs.getString("unidade"),ObjConecta.rs.getString("quantidade_minima")});
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Consulta_Prod.setModel(tabela);
        JTB_Consulta_Prod.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());//Pintar tabela
        JTB_Consulta_Prod.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Consulta_Prod.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Consulta_Prod.getColumnModel().getColumn(1).setPreferredWidth(300);
        JTB_Consulta_Prod.getColumnModel().getColumn(1).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(2).setPreferredWidth(160);
        JTB_Consulta_Prod.getColumnModel().getColumn(2).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(3).setPreferredWidth(80);
        JTB_Consulta_Prod.getColumnModel().getColumn(3).setResizable(false);
        JTB_Consulta_Prod.getColumnModel().getColumn(4).setPreferredWidth(80);
        JTB_Consulta_Prod.getColumnModel().getColumn(4).setResizable(false);
        JTB_Consulta_Prod.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Consulta_Prod.setAutoResizeMode(JTB_Consulta_Prod.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Todas colunas)
        JTB_Consulta_Prod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
        
        
    }
 public final void Contar_Prod_Estoque(){
     int cont=0;   
     try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select distinct produto.id_produto, produto.descricao, categoria,  unidade, quantidade_minima "
                    + "from produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                    + "inner join lote_estoque on produto.id_produto=lote_estoque.produto_id_produto where quantidade_estoque>0 "
                    + "and produto.situacao='ATIVO' order by produto.descricao");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_produto");           
            
            do{
                cont++;
            }while(ObjConecta.rs.next());
            JTF_ItensEstoque.setText(String.valueOf(cont));
        } catch (SQLException ex) {
           cont = 0;
           JTF_ItensEstoque.setText(String.valueOf(cont));
        }
    }
 
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0),"Adicionar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
        
        InputMap inputMap3 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0),"Limpar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);        
                      
        //método para executar
         this.getRootPane().getActionMap().put("Limpar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Limpar.doClick();
        JTF_Pesquisa.requestFocus();
        }
        });
        this.getRootPane().getActionMap().put("Adicionar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Adicionar.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Sair.doClick();
        }
        });        
    }

 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Consulta_Produto_Saida_DL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Consulta_Produto_Saida_DL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Consulta_Produto_Saida_DL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Consulta_Produto_Saida_DL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_Consulta_Produto_Saida_DL dialog = new Tela_Consulta_Produto_Saida_DL(new Tela_Saida_Produto(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Adicionar;
    private javax.swing.JButton BT_Limpar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JLabel JL_ItensCad;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JTable JTB_Consulta_Prod;
    private javax.swing.JLabel JTF_ItensEstoque;
    private javax.swing.JTextField JTF_Pesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

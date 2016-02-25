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
import Metodos.Pintar_Tabela;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// @author Márison Tamiarana
 
public class Tela_Consulta_Produto_Ajuste_DL extends javax.swing.JDialog {

    Conecta_Banco ObjConecta = new Conecta_Banco();
    Modelo_Produto ObjModeloProd = new Modelo_Produto();
    Controle_Produto ObjControlProd = new Controle_Produto();
    Tela_Ajuste_Estoque ObjAjuste = new Tela_Ajuste_Estoque();
    Tela_Saida_Produto ObjSaida = new Tela_Saida_Produto();
    Controle_Lote_Estoque ObjControlLote = new Controle_Lote_Estoque();
    Modelo_Lote_Estoque ObjModeloLote = new Modelo_Lote_Estoque();
    Formatacao ObjFormat = new Formatacao();
    Controle_Entrada_Produto ObjControlEnt = new Controle_Entrada_Produto();
    Modelo_Saida_Produto ObjModeloSaida = new Modelo_Saida_Produto();
    Controle_Saida_Produto ObjControlSaida = new Controle_Saida_Produto();
       
    int Cod;
    String data;//variavel para receber a data atual para comparar a validade
    
    public Tela_Consulta_Produto_Ajuste_DL(Tela_Ajuste_Estoque parent, boolean modal) {
        this.ObjAjuste = parent;
        this.setModal(modal);
        
        initComponents();
        setResizable(false);
        setSize(805,520);
        setLocationRelativeTo(ObjAjuste);
        JTF_Pesquisa.setDocument(ObjFormat.new Format_Geral(50));
        Contar_Prod_Estoque();
        
      
         Preencher_Tabela("select distinct produto.id_produto, produto.descricao, categoria,  unidade, quantidade_minima "
        + "from produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
        + "inner join lote_estoque on produto.id_produto=lote_estoque.produto_id_produto where quantidade_estoque>=0 "
        + "and produto.descricao like '%" + JTF_Pesquisa.getText().toUpperCase() + "%' "
        + "and produto.situacao='ATIVO' order by produto.descricao"); 
        
        ObjControlProd.Contar_Produtos_Ativos(JL_ItensCad); 
        
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

        BT_Limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Remove_24x24.png"))); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Itens Cadastrados:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Itens Com Estoque:");

        JL_ItensCad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_ItensEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_ItensCad, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_ItensEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(JL_ItensCad, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(JTF_ItensEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BT_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BT_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(435, 435, 435))
        );

        setSize(new java.awt.Dimension(821, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTB_Consulta_ProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Consulta_ProdMouseClicked
        try {
            if (evt.getClickCount() == 2) {
                ObjAjuste.Limpar_Campos_Produto();
                Object resultado = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));  
                ObjControlSaida.Controla_Lote(resultado);
                if(ObjControlSaida.Controla_Lote==true){
                    Carregar_Dados_Produtos(resultado);
                    dispose();
                    ObjAjuste.Mostrar_Escolha_Lote(resultado);
                    ObjControlSaida.Controla_Lote=false;
                }else{
                    Carregar_Dados_Produtos(resultado);
                    dispose();
                    ObjControlLote.Consulta_Estoque_Produto(ObjModeloLote, resultado);
                    ObjAjuste.Setar_Campo_Quantidade(ObjModeloLote.getQuantidade_estoque());
                }
            }
        } catch (SQLException ex) {
            
        }

    }//GEN-LAST:event_JTB_Consulta_ProdMouseClicked

    private void JTF_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PesquisaActionPerformed
//        Preencher_Tabela("select distinct produto.id_produto, produto.descricao, categoria,  unidade, quantidade_minima "
//        + "from produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
//        + "inner join lote_estoque on produto.id_produto=lote_estoque.produto_id_produto where quantidade_estoque>0 "
//        + "and produto.descricao like '%" + JTF_Pesquisa.getText().toUpperCase() + "%' "
//        + "and produto.situacao='ATIVO' order by produto.descricao"); 
        JTB_Consulta_Prod.requestFocus();
       
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
                ObjAjuste.Limpar_Campos_Produto();
                Object resultado = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));  
                ObjControlSaida.Controla_Lote(resultado);
                if(ObjControlSaida.Controla_Lote==true){
                    Carregar_Dados_Produtos(resultado);
                    dispose();
                    ObjAjuste.Mostrar_Escolha_Lote(resultado);
                    ObjControlSaida.Controla_Lote=false;
                }else{
                    Carregar_Dados_Produtos(resultado);
                    dispose();
                    ObjControlLote.Consulta_Estoque_Produto(ObjModeloLote, resultado);
                    ObjAjuste.Setar_Campo_Quantidade(ObjModeloLote.getQuantidade_estoque());
                }
            }
            }catch (SQLException ex) {
                
            }
        
    }//GEN-LAST:event_BT_AdicionarActionPerformed

    private void BT_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_LimparActionPerformed
       JTF_Pesquisa.setText("");
       Preencher_Tabela("select distinct produto.id_produto, produto.descricao, categoria,  unidade, quantidade_minima "
        + "from produto inner join categoria_produto on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
        + "inner join lote_estoque on produto.id_produto=lote_estoque.produto_id_produto where quantidade_estoque>=0 "
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
                    ObjAjuste.Limpar_Campos_Produto();
                    Object resultado = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));  
                    ObjControlSaida.Controla_Lote(resultado);
                    if(ObjControlSaida.Controla_Lote==true){
                        Carregar_Dados_Produtos(resultado);
                        dispose();
                        ObjAjuste.Mostrar_Escolha_Lote(resultado);
                        ObjControlSaida.Controla_Lote=false;
                    }else{
                        Carregar_Dados_Produtos(resultado);
                        dispose();
                        ObjControlLote.Consulta_Estoque_Produto(ObjModeloLote, resultado);
                        ObjAjuste.Setar_Campo_Quantidade(ObjModeloLote.getQuantidade_estoque());
                    }
                }
            }
            }catch (SQLException ex) {
                
            }
         
    }//GEN-LAST:event_JTB_Consulta_ProdKeyPressed
 
    public void Carregar_Dados_Produtos(Object LinhaSelecionada) throws SQLException { 
       ObjModeloProd.setPesquisa(String.valueOf(LinhaSelecionada));
       ObjControlProd.Consulta_Produto(ObjModeloProd);
       ObjAjuste.Setar_Campos_Produto(ObjModeloProd.getId_produto(),ObjModeloProd.getDescricao());
       ObjAjuste.Setar_Un_Prod(ObjModeloProd.getUnidade());            
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
        + "inner join lote_estoque on produto.id_produto=lote_estoque.produto_id_produto where quantidade_estoque>=0 "
        + "and produto.descricao like '%" + JTF_Pesquisa.getText().toUpperCase() + "%' "
        + "and produto.situacao='ATIVO' order by produto.descricao"); 
    }
 
  
 public final void Preencher_Tabela(String SQL) {
       ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Descrição","Categoria", "Unidade","Minimo","Estoque"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();           
            do {           
                //metodo para trazer o estoque de cada produto
                ObjControlLote.Consulta_Estoque_Produto(ObjModeloLote,ObjConecta.rs.getInt("id_produto"));                
                //adicionando na tabela
                dados.add(new Object[]{ObjConecta.rs.getInt("id_produto"),ObjConecta.rs.getString("descricao"),
                ObjConecta.rs.getString("categoria"),ObjConecta.rs.getString("unidade"),ObjConecta.rs.getString("quantidade_minima"),
                ObjModeloLote.getQuantidade_estoque()});
            } while (ObjConecta.rs.next());
            
            ObjConecta.Desconecta();
        } catch (SQLException ex) {}
        
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Consulta_Prod.setModel(tabela);
        JTB_Consulta_Prod.setDefaultRenderer(Object.class, new Pintar_Tabela());//Pintar tabela
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
        JTB_Consulta_Prod.getColumnModel().getColumn(5).setPreferredWidth(73);
        JTB_Consulta_Prod.getColumnModel().getColumn(5).setResizable(false);
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
            java.util.logging.Logger.getLogger(Tela_Consulta_Produto_Ajuste_DL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Consulta_Produto_Ajuste_DL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Consulta_Produto_Ajuste_DL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Consulta_Produto_Ajuste_DL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Tela_Consulta_Produto_Ajuste_DL dialog = new Tela_Consulta_Produto_Ajuste_DL(new Tela_Ajuste_Estoque(), true);
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

package GUI_Frames;

import Classes.Modelo_Lote_Estoque;
import Classes.Modelo_Produto;
import Conexao.Conecta_Banco;
import Conexao.Controle_Produto;
import Classes.Modelo_Tabela;
import Conexao.Controle_Lote_Estoque;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// @author Márison Tamiarana

public class Tela_Consulta_Produto extends javax.swing.JInternalFrame {
    
    public static Tela_Consulta_Produto Obj;
    Tela_Principal tp = new Tela_Principal();
    
    public void Open_Tela(){
        if(Obj==null){
            
            Obj = new Tela_Consulta_Produto();
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
    Conecta_Banco ObjConecta2 = new Conecta_Banco();
    Modelo_Produto ObjModeloProd = new Modelo_Produto();
    Controle_Produto ObjControlProd = new Controle_Produto();
    Tela_Entrada_Produto ObjEntrada = new Tela_Entrada_Produto();
    Controle_Lote_Estoque ObjControlLote = new Controle_Lote_Estoque();
    Modelo_Lote_Estoque ObjModeloLote = new Modelo_Lote_Estoque();
    Formatacao ObjFormat = new Formatacao();
    //objeto para colorir a tabela
       
    
    public Tela_Consulta_Produto() {
        initComponents();
        
        JTF_Pesquisa.setDocument(ObjFormat.new Format_Geral(100));
                
        Preencher_Tabela("select*from produto inner join categoria_produto "
                + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.descricao like '%"    
                + JTF_Pesquisa.getText().toUpperCase() + "%' and produto.situacao='ATIVO' order by produto.descricao"); 
        
        ObjControlProd.Contar_Produtos_Ativos(JL_ItensCad);
        
        
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTF_Pesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Consulta_Prod = new javax.swing.JTable();
        BT_Sair = new javax.swing.JButton();
        BT_Cadastrar = new javax.swing.JButton();
        BT_Consulta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JL_Prod = new javax.swing.JLabel();
        JL_ItensCad = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Consulta De Produto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Prod 24x24.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(JTF_Pesquisa)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTB_Consulta_Prod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Consulta_Prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Consulta_Prod.setToolTipText("Clique Duas Vezes Em Uma Linha Para Editar  Ou Selecione Uma Linha E Clique No Botão Consultar (Alt+N)");
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTB_Consulta_ProdKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Consulta_Prod);

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
        BT_Cadastrar.setToolTipText("Clique Para Cadastrar Novo Produto Ou Pressione Alt + D");
        BT_Cadastrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cadastrar Press.png"))); // NOI18N
        BT_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CadastrarActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Itens Cadastrados:");

        JL_Prod.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Prod.setForeground(new java.awt.Color(102, 102, 102));

        JL_ItensCad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JL_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JL_ItensCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(JL_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(BT_Cadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Consulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(JL_ItensCad, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        setBounds(20, 20, 805, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PesquisaActionPerformed
        JTB_Consulta_Prod.requestFocus();
        JTB_Consulta_Prod.setRowSelectionInterval(0,0);
    }//GEN-LAST:event_JTF_PesquisaActionPerformed

    private void JTB_Consulta_ProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Consulta_ProdMouseClicked
        JL_Prod.setText(String.valueOf(JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1)));
        try {
            if (evt.getClickCount() == 2) {

                Object resultado = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));
                Tela_Cadastro_Prod_Edit obj = new Tela_Cadastro_Prod_Edit();
                Tela_Principal.getPainel().add(obj);
                obj.setVisible(true);
                obj.setPosicao();
                obj.Carregar_Dados_Produtos(resultado);
                obj.Obj = new Tela_Cadastro_Prod_Edit();
                
                Tela_Consulta_Entrada objRelat = new Tela_Consulta_Entrada();
                objRelat.Objteste=null;
               
                dispose();
            }
        } catch (SQLException ex) {
            
        }
    }//GEN-LAST:event_JTB_Consulta_ProdMouseClicked

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CadastrarActionPerformed
        Tela_Cadastro_Prod obj = new Tela_Cadastro_Prod();
        obj.Open_Tela();
        dispose();
    }//GEN-LAST:event_BT_CadastrarActionPerformed

    private void BT_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConsultaActionPerformed
       try {
            int linha_selecionada = JTB_Consulta_Prod.getSelectedRow();
                if (linha_selecionada >= 0)
                {
                    Object resultado = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));
                    Tela_Cadastro_Prod_Edit obj = new Tela_Cadastro_Prod_Edit();
                    Tela_Principal.getPainel().add(obj);
                    obj.setVisible(true);
                    obj.setPosicao();
                    obj.Carregar_Dados_Produtos(resultado);
                    obj.Obj = new Tela_Cadastro_Prod_Edit();
                    
                    Tela_Consulta_Entrada objRelat = new Tela_Consulta_Entrada();
                    objRelat.Objteste=null;
                    dispose();                   
                }
            } catch (SQLException ex) {
            Logger.getLogger(Tela_Consulta_Produto.class.getName()).log(Level.SEVERE, null, ex);
        }                    
    }//GEN-LAST:event_BT_ConsultaActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

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
                        Tela_Cadastro_Prod_Edit obj = new Tela_Cadastro_Prod_Edit();
                        Tela_Principal.getPainel().add(obj);
                        obj.setVisible(true);
                        obj.setPosicao();
                        obj.Carregar_Dados_Produtos(resultado);
                        obj.Obj = new Tela_Cadastro_Prod_Edit();

                        Tela_Consulta_Entrada objRelat = new Tela_Consulta_Entrada();
                        objRelat.Objteste=null;
                        dispose();  
                    }
                }
       }catch(Exception ex){}
    }//GEN-LAST:event_JTB_Consulta_ProdKeyPressed

    private void JTB_Consulta_ProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTB_Consulta_ProdKeyReleased
         JL_Prod.setText(String.valueOf(JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1)));
    }//GEN-LAST:event_JTB_Consulta_ProdKeyReleased
    
    //metodo para pesquisar ao digitar
    public void PesquisarNome() {

        JTF_Pesquisa.getDocument().addDocumentListener(new DocumentListener() {
            //ATUALIZA A CADA LETRA REMOVIDA=============================
            @Override
            public void removeUpdate(DocumentEvent e) {
                FiltrarNome();
            }

            //ATUALIZA A CADA LETRA INSERIDA==============================
            @Override
            public void insertUpdate(DocumentEvent e) {               
                FiltrarNome();
            }
            //ATUALIZA A CADA LETRA ATUALIZADA OU TROCADA=================

            @Override
            public void changedUpdate(DocumentEvent e) {
                FiltrarNome();
            }
        });
    }
    
    public void FiltrarNome() {
        Preencher_Tabela("select*from produto inner join categoria_produto "
                + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.descricao like '%"    
                + JTF_Pesquisa.getText().toUpperCase() + "%' and produto.situacao='ATIVO' order by produto.descricao");    
    }

    public void Iniciar(){
         Preencher_Tabela("select*from produto inner join categoria_produto "
                + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria order by produto.descricao");    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Cadastrar;
    private javax.swing.JButton BT_Consulta;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JLabel JL_ItensCad;
    private javax.swing.JLabel JL_Prod;
    private javax.swing.JTable JTB_Consulta_Prod;
    private javax.swing.JTextField JTF_Pesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables



}

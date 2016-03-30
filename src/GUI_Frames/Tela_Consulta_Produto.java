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
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
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
       
    int intervalo= 0;//intervalo de pesquisa por pagina
    int itens_por_pagina = 14;//itens por páginas
    int itens_filtrados;//quantidade de itens resultantes na busca pelo filtro
    int numero_de_pagina;//variave que vai receber a quantidade de pagina
    int contador=1;//contador para controle da pagina       
    
    public Tela_Consulta_Produto() {
        initComponents();
        
        JTF_Pesquisa.setDocument(ObjFormat.new Format_Geral(100));
                
        Preencher_Tabela("select*from produto inner join categoria_produto "
                + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.descricao like '%"    
                + JTF_Pesquisa.getText().toUpperCase() + "%' and produto.situacao='ATIVO' order by produto.descricao "
                + "limit "+intervalo+","+itens_por_pagina+"");
        
        Setar_Atalho_BT();
        ObjControlProd.Contar_Produtos_Ativos(JL_ItensCad);
        Metodo_Geral();        
        Setar_Linha_Tabela();
        
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTF_Pesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Consulta_Prod = new javax.swing.JTable();
        BT_Sair = new javax.swing.JButton();
        BT_Cadastrar = new javax.swing.JButton();
        BT_Consulta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JL_Prod = new javax.swing.JLabel();
        JL_ItensCad = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BT_Anterior = new javax.swing.JButton();
        BT_Proximo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        JL_Pagina = new javax.swing.JLabel();
        JL_Num_Pagina = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JL_Itens_Filtrados = new javax.swing.JLabel();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTF_Pesquisa)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        JTB_Consulta_Prod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Consulta_Prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Consulta_Prod.setToolTipText("Clique Duas Vezes Em Uma Linha Para Consultar Ou Selecione Uma Linha E Clique No Botão Consultar (Alt+N)");
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
        BT_Consulta.setToolTipText("Selecione Uma Linha E Clique Para Consultar Ou Pressione Alt + N");
        BT_Consulta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar Press.png"))); // NOI18N
        BT_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ConsultaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Itens Cadastrados:");

        JL_Prod.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Prod.setForeground(new java.awt.Color(102, 102, 102));

        JL_ItensCad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ESC - Sair | F3 - Consultar | F5 - Atualizar | F6 - Cadastrar | F7 - Anterior | F8 - Limpar | F9 - Próximo");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Navegação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        BT_Anterior.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Previous_24x24.png"))); // NOI18N
        BT_Anterior.setText("(F7)");
        BT_Anterior.setToolTipText("Página Anterir");
        BT_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AnteriorActionPerformed(evt);
            }
        });

        BT_Proximo.setBackground(new java.awt.Color(255, 255, 255));
        BT_Proximo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Next_24x24.png"))); // NOI18N
        BT_Proximo.setText("(F9)");
        BT_Proximo.setToolTipText("Próximo Página");
        BT_Proximo.setOpaque(false);
        BT_Proximo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BT_ProximoFocusGained(evt);
            }
        });
        BT_Proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ProximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BT_Anterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_Proximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Páginas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JL_Pagina.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JL_Pagina.setForeground(new java.awt.Color(102, 102, 102));
        JL_Pagina.setText("Página");

        JL_Num_Pagina.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JL_Num_Pagina.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JL_Pagina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Num_Pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Num_Pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Itens Encontrados:");

        JL_Itens_Filtrados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_Itens_Filtrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JL_ItensCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(BT_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JL_Prod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(BT_Cadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Consulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_Itens_Filtrados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JL_ItensCad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        setBounds(20, 20, 805, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PesquisaActionPerformed
        int quant_itens = JTB_Consulta_Prod.getRowCount();
            if(quant_itens>0){
            JTB_Consulta_Prod.setRowSelectionInterval(0, 0);
            JTB_Consulta_Prod.requestFocus();
        }
    }//GEN-LAST:event_JTF_PesquisaActionPerformed

    private void JTB_Consulta_ProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Consulta_ProdMouseClicked
        JL_Prod.setText(String.valueOf(JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0))
                                    +" - "+String.valueOf(JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1)));
        try {
            
            if (evt.getClickCount() == 2) {

                Object id_produto = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));
                Object produto = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1));
                Tela_Cadastro_Prod_Edit obj = new Tela_Cadastro_Prod_Edit();
                Tela_Principal.getPainel().add(obj);
                obj.setVisible(true);
                obj.setPosicao();
                obj.Carregar_Dados_Produtos(id_produto);
                obj.Obj = new Tela_Cadastro_Prod_Edit();
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
                    Object id_produto = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));
                    Tela_Cadastro_Prod_Edit obj = new Tela_Cadastro_Prod_Edit();
                    Tela_Principal.getPainel().add(obj);
                    obj.setVisible(true);
                    obj.setPosicao();
                    obj.Carregar_Dados_Produtos(id_produto);
                    obj.Obj = new Tela_Cadastro_Prod_Edit();
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
                    
                    if((evt.getKeyChar()==KeyEvent.VK_ENTER)){
                        Object id_produto = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));
                        Tela_Cadastro_Prod_Edit obj = new Tela_Cadastro_Prod_Edit();
                        Tela_Principal.getPainel().add(obj);
                        obj.setVisible(true);
                        obj.setPosicao();
                        obj.Carregar_Dados_Produtos(id_produto);
                        obj.Obj = new Tela_Cadastro_Prod_Edit();
                        dispose(); 
                    }
                }
       }catch(Exception ex){}
    }//GEN-LAST:event_JTB_Consulta_ProdKeyPressed

    private void JTB_Consulta_ProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTB_Consulta_ProdKeyReleased
        int linha_selecionada = JTB_Consulta_Prod.getSelectedRow();
                if (linha_selecionada >= 0)
                    {
                    JL_Prod.setText(String.valueOf(JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0))
                                    +" - "+String.valueOf(JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1)));
                    }
                else{
                    JL_Prod.setText("");
                }
    }//GEN-LAST:event_JTB_Consulta_ProdKeyReleased

    private void BT_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AnteriorActionPerformed
        intervalo = intervalo - itens_por_pagina;
        contador--;
        Preencher_Tabela("select*from produto inner join categoria_produto "
            + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.descricao like '%"
            + JTF_Pesquisa.getText().toUpperCase() + "%' and produto.situacao='ATIVO' order by produto.descricao "
            + "limit "+intervalo+","+itens_por_pagina+"");
        if(contador==1){
            BT_Anterior.setEnabled(false);
        }
        if(contador<numero_de_pagina){
            BT_Proximo.setEnabled(true);
        }
        Setar_Pagina();
        Setar_Linha_Tabela();
    }//GEN-LAST:event_BT_AnteriorActionPerformed

    private void BT_ProximoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BT_ProximoFocusGained
        Setar_Linha_Tabela();
    }//GEN-LAST:event_BT_ProximoFocusGained

    private void BT_ProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ProximoActionPerformed
        intervalo = intervalo + itens_por_pagina;
        contador++;
        Preencher_Tabela("select*from produto inner join categoria_produto "
            + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.descricao like '%"
            + JTF_Pesquisa.getText().toUpperCase() + "%' and produto.situacao='ATIVO' order by produto.descricao "
            + "limit "+intervalo+","+itens_por_pagina+"");
        if(contador<=numero_de_pagina){
            BT_Anterior.setEnabled(true);
        }
        if(contador==numero_de_pagina){
            BT_Proximo.setEnabled(false);
        }
        Setar_Pagina();
        Setar_Linha_Tabela();

    }//GEN-LAST:event_BT_ProximoActionPerformed
    
    final void Setar_Pagina(){//seta o numero de paginas
        JL_Num_Pagina.setText(String.valueOf(contador)+" de "+String.valueOf(numero_de_pagina));
    }
    
    final void Inicia_Pagina_Botoes(){//inicia o numero de paginas e o botao proximo
        numero_de_pagina = (itens_filtrados / itens_por_pagina);
        if(itens_filtrados % itens_por_pagina != 0){
            numero_de_pagina = numero_de_pagina +1;
        }
        if(itens_filtrados<=itens_por_pagina){
            BT_Proximo.setEnabled(false);
        }else{
            BT_Proximo.setEnabled(true);
        }
    }
    
    final void Setar_Linha_Tabela(){//seta a selecao na primeira linha da tabela
        int cont = JTB_Consulta_Prod.getRowCount();
        if(cont>0){            
            JTB_Consulta_Prod.setRowSelectionInterval(0, 0);
            JL_Prod.setText(String.valueOf(JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0))
                                    +" - "+String.valueOf(JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1)));
            JTB_Consulta_Prod.requestFocus();
            
        }
    }
    
    final void Metodo_Geral(){//aglomerar metodos
        ObjControlProd.Contar_Produtos_Filtrados(JL_Itens_Filtrados,JTF_Pesquisa.getText());
        itens_filtrados = Integer.valueOf(JL_Itens_Filtrados.getText());        
        BT_Anterior.setEnabled(false);
        Inicia_Pagina_Botoes();
        Setar_Pagina();
    }
    
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
        JL_Prod.setText("");
        intervalo = 0;
        contador = 1;
        Preencher_Tabela("select*from produto inner join categoria_produto "
                + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.descricao like '%"    
                + JTF_Pesquisa.getText().toUpperCase() + "%' and produto.situacao='ATIVO' order by produto.descricao "
                 + "limit "+intervalo+","+itens_por_pagina+"");
        Metodo_Geral();
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
    
    
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Tecla Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0),"Tecla F5");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
        //metodo para pegar a tecla pressionada
        InputMap inputMap3 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),"Tecla Consultar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);
        //metodo para pegar a tecla pressionada
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0),"Tecla Cadastrar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap4);
        
        InputMap inputMap5 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap5.put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0),"Anterior");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap5);  
        
        InputMap inputMap6 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap6.put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0),"Proximo");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap6);  
        
        InputMap inputMap7 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap7.put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0),"Limpar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap7);  
                      
        //método para executar
        this.getRootPane().getActionMap().put("Proximo", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Proximo.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Anterior", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Anterior.doClick();
        }
        });
        
        //método para executar
        this.getRootPane().getActionMap().put("Tecla F5", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        Preencher_Tabela("select*from produto inner join categoria_produto "
                + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.descricao like '%"    
                + JTF_Pesquisa.getText().toUpperCase() + "%' and produto.situacao='ATIVO' order by produto.descricao "
                + "limit "+intervalo+","+itens_por_pagina+"");
        JL_Prod.setText("");
        }
        });
        this.getRootPane().getActionMap().put("Tecla Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Sair.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Tecla Cadastrar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
           BT_Cadastrar.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Tecla Consultar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
            BT_Consulta.doClick();
        }
        });
        
        
        this.getRootPane().getActionMap().put("Limpar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
            JTF_Pesquisa.setText("");
        }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Anterior;
    private javax.swing.JButton BT_Cadastrar;
    private javax.swing.JButton BT_Consulta;
    private javax.swing.JButton BT_Proximo;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JLabel JL_ItensCad;
    private javax.swing.JLabel JL_Itens_Filtrados;
    private javax.swing.JLabel JL_Num_Pagina;
    private javax.swing.JLabel JL_Pagina;
    private javax.swing.JLabel JL_Prod;
    private javax.swing.JTable JTB_Consulta_Prod;
    private javax.swing.JTextField JTF_Pesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables



}

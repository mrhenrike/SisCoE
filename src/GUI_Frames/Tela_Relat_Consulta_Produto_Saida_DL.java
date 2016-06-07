package GUI_Frames;

import Classes.Modelo_Lote_Estoque;
import Classes.Modelo_Produto;
import Conexao.Conecta_Banco;
import Conexao.Controle_Produto;
import Classes.Modelo_Tabela;
import Conexao.Controle_Lote_Estoque;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

// @author Márison Tamiarana
 
public class Tela_Relat_Consulta_Produto_Saida_DL extends javax.swing.JDialog {

    Conecta_Banco ObjConecta = new Conecta_Banco();
    Modelo_Produto ObjModeloProd = new Modelo_Produto();
    Controle_Produto ObjControlProd = new Controle_Produto();
    Controle_Lote_Estoque ObjControlLote = new Controle_Lote_Estoque();
    Modelo_Lote_Estoque ObjModeloLote = new Modelo_Lote_Estoque();
    Formatacao ObjFormat = new Formatacao();
    Tela_Relat_Produto_Saida_Periodo Obj = new Tela_Relat_Produto_Saida_Periodo();
       
    String descricao;
    int Cod;
    int intervalo= 0;//intervalo de pesquisa por pagina
    int itens_por_pagina = 16;//itens por páginas
    int itens_filtrados;//quantidade de itens resultantes na busca pelo filtro
    int numero_de_pagina;//variave que vai receber a quantidade de pagina
    int contador=1;//contador para controle da pagina
    
    public Tela_Relat_Consulta_Produto_Saida_DL(Tela_Relat_Produto_Saida_Periodo parent, boolean modal) {
        this.Obj = parent;
        this.setModal(modal);
        
        initComponents();
        setResizable(false);
        setSize(820,540);
        setLocationRelativeTo(Obj);
        Setar_Pesquisa(Obj.pesquisa);
            
        Preencher_Tabela("select*from produto inner join categoria_produto "
                + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.descricao like '%"    
                + JL_Descricao.getText() + "%' and produto.situacao='ATIVO' order by produto.descricao "
                + "limit "+intervalo+","+itens_por_pagina+"");
        
        ObjControlProd.Contar_Produtos_Filtrados(JL_ItensCad,JL_Descricao.getText());
        itens_filtrados = Integer.valueOf(JL_ItensCad.getText());
        Setar_Atalho_BT();        ;
        BT_Anterior.setEnabled(false);
        Inicia_Pagina_Botoes();
        Setar_Linha_Tabela();
        Setar_Pagina();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Consulta_Prod = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        JL_Descricao = new javax.swing.JLabel();
        BT_Sair = new javax.swing.JButton();
        BT_Adicionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JL_ItensCad = new javax.swing.JLabel();
        JL_Quant_Itens1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BT_Anterior = new javax.swing.JButton();
        BT_Proximo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        JL_Pagina = new javax.swing.JLabel();
        JL_Num_Pagina = new javax.swing.JLabel();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Filtro De Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JL_Descricao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JL_Descricao.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jLabel1.setText("Itens Encontrados:");

        JL_ItensCad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Sair | F4/Enter - Adicionar | F7- Anterior | F9 - Próximo");

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

        BT_Proximo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Next_24x24.png"))); // NOI18N
        BT_Proximo.setText("(F9)");
        BT_Proximo.setToolTipText("Próximo Página");
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
                .addContainerGap()
                .addComponent(JL_Pagina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Num_Pagina, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JL_ItensCad, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JL_Quant_Itens1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(BT_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BT_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JL_Quant_Itens1)
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JL_ItensCad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(821, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTB_Consulta_ProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Consulta_ProdMouseClicked
        try {
            if (evt.getClickCount() == 2) {
                Object id_prod = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));
                Object desc_prod = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1));
                Obj.Setar_Campo_Cod_Produto(String.valueOf(id_prod),String.valueOf(desc_prod));
                dispose();
            }
        } catch (Exception ex) {
            Logger.getLogger(Tela_Consulta_Produto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_JTB_Consulta_ProdMouseClicked

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
        //Sair_Sem_Salvar();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AdicionarActionPerformed
        try {
        int linha_selecionada = JTB_Consulta_Prod.getSelectedRow();
            if (linha_selecionada >= 0)
                {
                Object id_prod = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));
                Object desc_prod = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1));
                Obj.Setar_Campo_Cod_Produto(String.valueOf(id_prod),String.valueOf(desc_prod));
                dispose();
                }
            }catch (Exception ex) {
                
            }
        dispose();
    }//GEN-LAST:event_BT_AdicionarActionPerformed

    private void JTB_Consulta_ProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTB_Consulta_ProdKeyPressed
         try {
        int linha_selecionada = JTB_Consulta_Prod.getSelectedRow();
            if (linha_selecionada >= 0)
                {
                if(evt.getKeyChar()==KeyEvent.VK_ENTER){
                    Object id_prod = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 0));
                    Object desc_prod = (JTB_Consulta_Prod.getValueAt(JTB_Consulta_Prod.getSelectedRow(), 1));
                    Obj.Setar_Campo_Cod_Produto(String.valueOf(id_prod),String.valueOf(desc_prod));
                    dispose();
                    }
                }
            }catch (Exception ex) {
        }
        
    }//GEN-LAST:event_JTB_Consulta_ProdKeyPressed

    private void BT_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AnteriorActionPerformed
        intervalo = intervalo - itens_por_pagina;
        contador--;
        Preencher_Tabela("select*from produto inner join categoria_produto "
                + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.descricao like '%"    
                + JL_Descricao.getText() + "%' and produto.situacao='ATIVO' order by produto.descricao "
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

    private void BT_ProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ProximoActionPerformed
        intervalo = intervalo + itens_por_pagina;
        contador++;
        Preencher_Tabela("select*from produto inner join categoria_produto "
                + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where produto.descricao like '%"    
                + JL_Descricao.getText() + "%' and produto.situacao='ATIVO' order by produto.descricao "
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

    private void BT_ProximoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BT_ProximoFocusGained
        JTB_Consulta_Prod.requestFocus();
    }//GEN-LAST:event_BT_ProximoFocusGained
       
    public final void Setar_Pesquisa(String pesquisa){//seta o campo filtro de pesquisa
        JL_Descricao.setText(pesquisa);
    }
    
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
        }
    }
    
    final void Setar_Linha_Tabela(){//seta a selecao na primeira linha da tabela
        int cont = JTB_Consulta_Prod.getRowCount();
        if(cont>0){
            JTB_Consulta_Prod.requestFocus();
            JTB_Consulta_Prod.setRowSelectionInterval(0, 0);            
        }
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
        } catch (SQLException ex) {
           
        }
        
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Consulta_Prod.setModel(tabela); 
        JTB_Consulta_Prod.setDefaultRenderer(Object.class, new Pintar_Tabela());
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
        JTB_Consulta_Prod.setSelectionForeground(Color.lightGray);
        
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
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0),"Anterior");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);  
        
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0),"Proximo");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap4);  
                      
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Relat_Consulta_Produto_Saida_DL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Tela_Relat_Consulta_Produto_Saida_DL dialog = new Tela_Relat_Consulta_Produto_Saida_DL(new Tela_Relat_Produto_Saida_Periodo(), true);
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
    private javax.swing.JButton BT_Anterior;
    private javax.swing.JButton BT_Proximo;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JLabel JL_Descricao;
    private javax.swing.JLabel JL_ItensCad;
    private javax.swing.JLabel JL_Num_Pagina;
    private javax.swing.JLabel JL_Pagina;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JTable JTB_Consulta_Prod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

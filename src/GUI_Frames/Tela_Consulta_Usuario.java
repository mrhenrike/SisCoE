package GUI_Frames;

import Classes.Modelo_Tabela;
import Conexao.Conecta_Banco;
import static GUI_Frames.Tela_Principal.PermissaoLogado;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.Dimension;
import java.awt.HeadlessException;
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
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;

// @author Márison Tamiarana

public class Tela_Consulta_Usuario extends javax.swing.JInternalFrame {
    
    public static Tela_Consulta_Usuario Obj;
        
    public void Open_Tela(){
        if(Obj==null){
            try {
                Obj = new Tela_Consulta_Usuario();
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Consulta_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    Formatacao ObjFormat = new Formatacao();    
    Tela_Principal ObjTP = new Tela_Principal();
    
    public Tela_Consulta_Usuario() throws SQLException {
        initComponents();
        Controle_Acesso();
               
        JTF_Nome.setDocument(ObjFormat.new Format_Geral(50));
        Preencher_Tabela_User("select * from usuario where situacao = 'ATIVO' and permissao != 'SISTEMA' order by nome");
        JRB_Nome.setSelected(true);        
        //getRootPane().setDefaultButton(BT_Consultar);
        Setar_Atalho_BT();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_Organizar = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Consulta = new javax.swing.JTable();
        JP_Dados_Pesquisa = new javax.swing.JPanel();
        JTF_Nome = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        JRB_Cod = new javax.swing.JRadioButton();
        JRB_Nome = new javax.swing.JRadioButton();
        BT_Sair = new javax.swing.JButton();
        BT_Consultar = new javax.swing.JButton();
        BT_Cadastrar = new javax.swing.JButton();
        JL_Quant_Itens1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Consulta De Usuário");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/User 24x24.png"))); // NOI18N
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

        JTB_Consulta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Consulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Consulta.setToolTipText("Clique Duas Vezes No Usuario Para Editar Os Dados");
        JTB_Consulta.getTableHeader().setReorderingAllowed(false);
        JTB_Consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_ConsultaMouseClicked(evt);
            }
        });
        JTB_Consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTB_ConsultaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Consulta);

        JP_Dados_Pesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados A Pesquisar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTF_Nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_NomeFocusGained(evt);
            }
        });
        JTF_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_NomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Dados_PesquisaLayout = new javax.swing.GroupLayout(JP_Dados_Pesquisa);
        JP_Dados_Pesquisa.setLayout(JP_Dados_PesquisaLayout);
        JP_Dados_PesquisaLayout.setHorizontalGroup(
            JP_Dados_PesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Dados_PesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTF_Nome)
                .addContainerGap())
        );
        JP_Dados_PesquisaLayout.setVerticalGroup(
            JP_Dados_PesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_PesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTF_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(JRB_Cod)
                .addGap(0, 0, 0)
                .addComponent(JRB_Nome))
        );

        BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sair.png"))); // NOI18N
        BT_Sair.setMnemonic('r');
        BT_Sair.setToolTipText("Clique Para Sair Ou Pressione Alt + R");
        BT_Sair.setActionCommand("R");
        BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sair press.png"))); // NOI18N
        BT_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SairActionPerformed(evt);
            }
        });

        BT_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar.png"))); // NOI18N
        BT_Consultar.setMnemonic('n');
        BT_Consultar.setToolTipText("Selecione Uma Linha E Clique Para Consultar Ou Pressione Alt + N");
        BT_Consultar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar Press.png"))); // NOI18N
        BT_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ConsultarActionPerformed(evt);
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

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Sair | F3 - Consultar | F6 - Cadastrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BT_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BT_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JP_Dados_Pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JL_Quant_Itens1)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JP_Dados_Pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Quant_Itens1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_Consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_Cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(20, 20, 805, 420);
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_NomeActionPerformed
        JTB_Consulta.requestFocus();
        JTB_Consulta.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_JTF_NomeActionPerformed

    private void JRB_CodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_CodActionPerformed
        Preencher_Tabela_User("select * from usuario where nome like '%"
                + JTF_Nome.getText().toUpperCase() + "%' and situacao = 'ATIVO' and permissao != 'SISTEMA' order by id_usuario");
    

    }//GEN-LAST:event_JRB_CodActionPerformed

    private void JRB_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_NomeActionPerformed
        Preencher_Tabela_User("select * from usuario where nome like '%"
                + JTF_Nome.getText().toUpperCase() + "%' and situacao = 'ATIVO' and permissao != 'SISTEMA' order by nome");
    }//GEN-LAST:event_JRB_NomeActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
       dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConsultarActionPerformed
        try {
            int linha_selecionada = JTB_Consulta.getSelectedRow();
                if (linha_selecionada >= 0)
                {
                    Object resultado = JTB_Consulta.getValueAt(JTB_Consulta.getSelectedRow(), 0);
                    Tela_Cadastro_Usuario_Edit obj = new Tela_Cadastro_Usuario_Edit();
                    Tela_Principal.getPainel().add(obj);
                    obj.setVisible(true);
                    obj.Carregar_Dados_Usuarios(resultado);
                    obj.setPosicao();
                    dispose();
                }
            } catch (SQLException ex) {
            Logger.getLogger(Tela_Consulta_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BT_ConsultarActionPerformed

    private void JTB_ConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_ConsultaMouseClicked
        if(PermissaoLogado.equalsIgnoreCase("USUÁRIO")){             
        }else{
            try {
                if (evt.getClickCount() == 2) {
                    Object resultado = JTB_Consulta.getValueAt(JTB_Consulta.getSelectedRow(), 0);
                    Tela_Cadastro_Usuario_Edit obj = new Tela_Cadastro_Usuario_Edit();
                    Tela_Principal.getPainel().add(obj);
                    obj.setVisible(true);
                    obj.Carregar_Dados_Usuarios(resultado);
                    obj.setPosicao();
                    dispose();
                }
            } catch (HeadlessException | SQLException ex) {
            }
        }
    }//GEN-LAST:event_JTB_ConsultaMouseClicked

    private void BT_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CadastrarActionPerformed
        Tela_Cadastro_Usuario obj = new Tela_Cadastro_Usuario();
        obj.Open_Tela();
        dispose();
    }//GEN-LAST:event_BT_CadastrarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JTF_NomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_NomeFocusGained
        PesquisarNome();
    }//GEN-LAST:event_JTF_NomeFocusGained

    private void JTB_ConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTB_ConsultaKeyPressed
        if(PermissaoLogado.equalsIgnoreCase("USUÁRIO")){             
        }else{
            try {
                int linha_selecionada = JTB_Consulta.getSelectedRow();
                if (linha_selecionada >= 0)
                {
                    if(evt.getKeyChar()==KeyEvent.VK_ENTER){
                        Object resultado = JTB_Consulta.getValueAt(JTB_Consulta.getSelectedRow(), 0);
                        Tela_Cadastro_Usuario_Edit obj = new Tela_Cadastro_Usuario_Edit();
                        Tela_Principal.getPainel().add(obj);
                        obj.setVisible(true);
                        obj.Carregar_Dados_Usuarios(resultado);
                        obj.setPosicao();
                        dispose();
                    }
                }
                }catch(Exception ex){}
            }
    }//GEN-LAST:event_JTB_ConsultaKeyPressed

    final void Controle_Acesso(){
    if(PermissaoLogado.equalsIgnoreCase("USUÁRIO")){
            BT_Cadastrar.setEnabled(false);
            BT_Consultar.setEnabled(false);
        }else{
            BT_Cadastrar.setEnabled(!false);
            BT_Consultar.setEnabled(!false);
        }
    }
    public void PesquisarNome() {

        JTF_Nome.getDocument().addDocumentListener(new DocumentListener() {
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
        boolean ehNumero = true;
        try{
            Integer.parseInt(JTF_Nome.getText());
        }catch(Exception e){
            ehNumero = false;
        }
        if(ehNumero==false){
            Preencher_Tabela_User("select * from usuario where nome like '%"
                    + JTF_Nome.getText().toUpperCase() + "%'and situacao = 'ATIVO' and permissao != 'SISTEMA' order by nome");}
        if(ehNumero == true){
            Preencher_Tabela_User("select * from usuario where id_usuario like '%"
                    + JTF_Nome.getText().toUpperCase() + "%'and situacao = 'ATIVO' and permissao != 'SISTEMA' order by nome");}
        
    }
    
    public final void Preencher_Tabela_User(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Nome","Login", "Permissão","Telefone"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();           
            do {      
                //adicionando na tabela
                dados.add(new Object[]{ObjConecta.rs.getInt("id_usuario"),ObjConecta.rs.getString("nome"),
                ObjConecta.rs.getString("login"),ObjConecta.rs.getString("permissao"),ObjConecta.rs.getString("telefone")});
            } while (ObjConecta.rs.next());
            
            ObjConecta.Desconecta();
        } catch (SQLException ex) {}
        
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Consulta.setModel(tabela); 
        JTB_Consulta.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Consulta.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Consulta.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Consulta.getColumnModel().getColumn(1).setPreferredWidth(350);
        JTB_Consulta.getColumnModel().getColumn(1).setResizable(false);
        JTB_Consulta.getColumnModel().getColumn(2).setPreferredWidth(125);
        JTB_Consulta.getColumnModel().getColumn(2).setResizable(false);
        JTB_Consulta.getColumnModel().getColumn(3).setPreferredWidth(125);
        JTB_Consulta.getColumnModel().getColumn(3).setResizable(false);
        JTB_Consulta.getColumnModel().getColumn(4).setPreferredWidth(125);
        JTB_Consulta.getColumnModel().getColumn(4).setResizable(false);
        JTB_Consulta.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Consulta.setAutoResizeMode(JTB_Consulta.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Todas colunas)
        JTB_Consulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
        
    }
    
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap3 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),"Consultar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);
        
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0),"Cadastrar");
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
        this.getRootPane().getActionMap().put("Consultar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Consultar.doClick();
        }
        });
    }
    
    DefaultTableCellRenderer numeros = new DefaultTableCellRenderer() {

    @Override
    public void setValue(Object value) {
    setHorizontalAlignment(JLabel.CENTER);
    super.setValue(value);
        }
    };
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BG_Organizar;
    private javax.swing.JButton BT_Cadastrar;
    private javax.swing.JButton BT_Consultar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JPanel JP_Dados_Pesquisa;
    private javax.swing.JRadioButton JRB_Cod;
    private javax.swing.JRadioButton JRB_Nome;
    private javax.swing.JTable JTB_Consulta;
    private javax.swing.JTextField JTF_Nome;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}

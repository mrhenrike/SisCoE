package GUI_Frames;

import Classes.Modelo_Tabela;
import Conexao.Conecta_Banco;
import Conexao.Controle_Curso;
import Conexao.Controle_Disciplina;
import Conexao.Controle_Produto;
import Conexao.Controle_Turma;
import Conexao.Controle_Usuario;
import GUI_Dialogs_Ativacao.Conf_Salvar_Ativ_Curso;
import GUI_Dialogs_Ativacao.Conf_Salvar_Ativ_Disciplina;
import GUI_Dialogs_Ativacao.Conf_Salvar_Ativ_Prod;
import GUI_Dialogs_Ativacao.Conf_Salvar_Ativ_Turma;
import GUI_Dialogs_Ativacao.Conf_Salvar_Ativ_User;
import GUI_Dialogs_Ativacao.Inf_Dados_Nao_Salvos_Ativ;
import GUI_Dialogs_Ativacao.Inf_Dados_Salvos_Ativ;
import GUI_Dialogs_Ativacao.Inf_Nao_Ha_Itens_Ativar;
import GUI_Dialogs_Ativacao.Inf_Selecione_Linha_Ativar;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;

//@author Márison Tamiarana

public class Tela_Ativacao extends javax.swing.JInternalFrame {
    //metodo para permitir apenas uma instancia da tela e centralizada
    public static Tela_Ativacao Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Ativacao();
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
    Controle_Curso ObjControlCurso = new Controle_Curso();
    Controle_Usuario ObjControlUser = new Controle_Usuario();
    Controle_Turma ObjControlTurma = new Controle_Turma();
    Controle_Produto ObjControlProd = new Controle_Produto();
    Controle_Disciplina ObjControlDisciplina = new Controle_Disciplina();
    
    //instancia dos dialogs
    private static Inf_Dados_Salvos_Ativ ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_Ativ ObjDadosNaoSalvos;
    private static Conf_Salvar_Ativ_User ObjConfSalvarUser;
    private static Conf_Salvar_Ativ_Prod ObjConfSalvarProd;
    private static Conf_Salvar_Ativ_Turma ObjConfSalvarTurma;
    private static Conf_Salvar_Ativ_Curso ObjConfSalvarCurso;
    private static Conf_Salvar_Ativ_Disciplina ObjConfSalvarDisciplina;
    private static Inf_Selecione_Linha_Ativar ObjSelecioneLinha;
    private static Inf_Nao_Ha_Itens_Ativar ObjNaoHaItenAtivar;
    
    public Tela_Ativacao() {
        initComponents();
        preencher_CB_Itens();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JCB_Tipo_Pesquisa = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Itens = new javax.swing.JTable();
        BT_Sair = new javax.swing.JButton();
        BT_Ativar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Ativar Itens");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Ativar 24x24.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados A Ativar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JCB_Tipo_Pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Tipo_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_Tipo_PesquisaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tipo De Alteração*:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(JCB_Tipo_Pesquisa, 0, 201, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JCB_Tipo_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Itens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTB_Itens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Itens.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTB_Itens);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
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

        BT_Ativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Ativar.png"))); // NOI18N
        BT_Ativar.setMnemonic('v');
        BT_Ativar.setToolTipText("Clique Para Ativar Ou Pressione Alt + V");
        BT_Ativar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Ativar Press.png"))); // NOI18N
        BT_Ativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AtivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BT_Ativar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BT_Ativar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(20, 20, 805, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void JCB_Tipo_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_Tipo_PesquisaActionPerformed
        if(JCB_Tipo_Pesquisa.getSelectedItem()=="USUÁRIO"){
            Preencher_Tabela_Usuario("select * from usuario where situacao = 'INATIVO' order by nome");           
        }
        if(JCB_Tipo_Pesquisa.getSelectedItem()=="CURSO"){
            Preencher_Tabela_Curso("select * from curso where situacao_curso = 'INATIVO' order by nome_curso");           
        }
        if(JCB_Tipo_Pesquisa.getSelectedItem()=="TURMA"){
            Preencher_Tabela_Turma("select* from curso inner join turma on "
                        + "turma.curso_id_curso = curso.id_curso where turma.situacao_turma = 'INATIVO' order by curso.abrev_curso ");
        }
        if(JCB_Tipo_Pesquisa.getSelectedItem()=="DISCIPLINA"){
            Preencher_Tabela_Disciplina("select* from disciplina where situacao_disciplina = 'INATIVO' order by disciplina ");
        }
        if(JCB_Tipo_Pesquisa.getSelectedItem()=="PRODUTO"){
             Preencher_Tabela_Produtos("select*from produto inner join categoria_produto "
                + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where "
                     + "produto.situacao='INATIVO' order by produto.descricao"); 
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==0){
            Limpar_Tabela();
        }
    }//GEN-LAST:event_JCB_Tipo_PesquisaActionPerformed

    private void BT_AtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AtivarActionPerformed
        int sel_tabela = JTB_Itens.getSelectedRow();
        int cont_tabela = JTB_Itens.getRowCount();
        if (cont_tabela <= 0){
            Mostrar_Nao_Ha_Itens();
        }
        else if (sel_tabela < 0) {
            Mostrar_Selecione_Linha();
        }else{
            if(JCB_Tipo_Pesquisa.getSelectedItem()=="CURSO"){
                Mostrar_Conf_Ativar_Curso();
            }
            if(JCB_Tipo_Pesquisa.getSelectedItem()=="DISCIPLINA"){
                Mostrar_Conf_Ativar_Disciplina();
            }
            if(JCB_Tipo_Pesquisa.getSelectedItem()=="USUÁRIO"){
                Mostrar_Conf_Ativar_Usuario();
            }        
            if(JCB_Tipo_Pesquisa.getSelectedItem()=="TURMA"){
                Mostrar_Conf_Ativar_Turma();
            }
            if(JCB_Tipo_Pesquisa.getSelectedItem()=="PRODUTO"){
                Mostrar_Conf_Ativar_Produto();
            }
            if(JCB_Tipo_Pesquisa.getSelectedIndex()==0){
                Limpar_Tabela();
            }}
    }//GEN-LAST:event_BT_AtivarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    public final void preencher_CB_Itens(){
        JCB_Tipo_Pesquisa.removeAllItems();
        JCB_Tipo_Pesquisa.addItem("");
        JCB_Tipo_Pesquisa.addItem("CURSO");
        JCB_Tipo_Pesquisa.addItem("DISCIPLINA");
        JCB_Tipo_Pesquisa.addItem("PRODUTO");
        JCB_Tipo_Pesquisa.addItem("TURMA");
        JCB_Tipo_Pesquisa.addItem("USUÁRIO");
    }
    
    public void Conf_Ativar_Curso(){
       try {
                int Sel_Curso = JTB_Itens.getSelectedRow();
                if (Sel_Curso >= 0) {
                    String resultado = (String.valueOf(JTB_Itens.getValueAt(JTB_Itens.getSelectedRow(), 0)));
                    ObjControlCurso.Ativa_Curso(resultado);
                    Preencher_Tabela_Curso("select * from curso where situacao = 'INATIVO' order by nome_curso");    
                        if(ObjControlCurso.Confirma_Ativar == true){
                           Mostrar_Dados_Salvos();
                           ObjControlCurso.Confirma_Ativar = false;
                        }else{
                            Mostrar_Dados_Nao_Salvos();
                            ObjControlCurso.Confirma_Ativar = false;
                        }       
                } 
        } catch (HeadlessException ex) {   } 
    }
    public void Conf_Ativar_Usuario(){
        try {
                int Sel_Usuario = JTB_Itens.getSelectedRow();
                if (Sel_Usuario >= 0) {
                    String resultado = (String.valueOf(JTB_Itens.getValueAt(JTB_Itens.getSelectedRow(), 0)));
                    ObjControlUser.Ativar_Usuario(resultado);
                    Preencher_Tabela_Usuario("select * from usuario where situacao = 'INATIVO' order by nome");  
                        if(ObjControlUser.Confirma_Ativo == true){
                            Mostrar_Dados_Salvos();
                            ObjControlUser.Confirma_Ativo = false;
                        }else{
                            Mostrar_Dados_Nao_Salvos();
                            ObjControlUser.Confirma_Ativo = false;
                        }
                } 
        } catch (HeadlessException ex) {   }
    }
    
    public void Conf_Ativar_Turma(){
        try {
                int Sel_Turma = JTB_Itens.getSelectedRow();
                if (Sel_Turma >= 0) {
                    String resultado = (String.valueOf(JTB_Itens.getValueAt(JTB_Itens.getSelectedRow(), 0)));                    
                    ObjControlTurma.Ativa_Turma(resultado);
                    Preencher_Tabela_Turma("select* from curso inner join turma on "
                        + "turma.curso_id_curso = curso.id_curso where turma.situacao = 'INATIVO' order by curso.abrev_curso ");
                    if(ObjControlTurma.Confirma_Ativar_Turma == true){
                            Mostrar_Dados_Salvos();
                            ObjControlTurma.Confirma_Ativar_Turma = false;
                        }else{
                            Mostrar_Dados_Nao_Salvos();
                            ObjControlTurma.Confirma_Ativar_Turma = false;
                        }
                } 
        } catch (HeadlessException ex) {   }
    }
    
    public void Conf_Ativar_Disciplina(){
        try {
                int Sel_Disciplina = JTB_Itens.getSelectedRow();
                if (Sel_Disciplina >= 0) {
                    String resultado = (String.valueOf(JTB_Itens.getValueAt(JTB_Itens.getSelectedRow(), 0)));                    
                    ObjControlDisciplina.Ativa_Disciplina(resultado);
                    Preencher_Tabela_Disciplina("select* from disciplina where situacao_disciplina = 'INATIVO' order by disciplina ");
                    if(ObjControlDisciplina.Confirma_Ativar_Disciplina == true){
                            Mostrar_Dados_Salvos();
                            ObjControlDisciplina.Confirma_Ativar_Disciplina = false;
                        }else{
                            Mostrar_Dados_Nao_Salvos();
                            ObjControlDisciplina.Confirma_Ativar_Disciplina = false;
                        }
                } 
        } catch (HeadlessException ex) {   }
    }
    
    public void Conf_Ativar_Produto(){
        try {
                int Sel_Usuario = JTB_Itens.getSelectedRow();
                if (Sel_Usuario >= 0) {
                    String resultado = (String.valueOf(JTB_Itens.getValueAt(JTB_Itens.getSelectedRow(), 0)));
                    ObjControlProd.Ativar_Produto(resultado);
                   Preencher_Tabela_Produtos("select*from produto inner join categoria_produto "
                    + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria where "
                     + "produto.situacao='INATIVO' order by produto.descricao"); 
                        if(ObjControlProd.Confirma_Ativo == true){
                            Mostrar_Dados_Salvos();
                            ObjControlProd.Confirma_Ativo = false;
                        }else{
                            Mostrar_Dados_Nao_Salvos();
                            ObjControlProd.Confirma_Ativo = false;
                        }
                } 
        } catch (HeadlessException ex) {   }
    }
    
    public final void Preencher_Tabela_Usuario(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Nome","Login","Permissão","Telefone","Situação"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();
           
            do {
                dados.add(new Object[]{ObjConecta.rs.getInt("id_usuario"),ObjConecta.rs.getString("nome"),
                ObjConecta.rs.getString("login"),ObjConecta.rs.getString("permissao"),ObjConecta.rs.getString("telefone"),
                ObjConecta.rs.getString("situacao")});
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens.setModel(tabela);
        JTB_Itens.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Itens.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Itens.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Itens.getColumnModel().getColumn(1).setPreferredWidth(232);
        JTB_Itens.getColumnModel().getColumn(1).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(2).setPreferredWidth(90);
        JTB_Itens.getColumnModel().getColumn(2).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(3).setPreferredWidth(120);
        JTB_Itens.getColumnModel().getColumn(3).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(4).setPreferredWidth(120);
        JTB_Itens.getColumnModel().getColumn(4).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(5).setPreferredWidth(90);
        JTB_Itens.getColumnModel().getColumn(5).setResizable(false);
        JTB_Itens.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Itens.setAutoResizeMode(JTB_Itens.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Não)
        JTB_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
      
    }

    public final void Preencher_Tabela_Curso(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Curso","Abreviatura", "Situação"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();
           
            do {
                dados.add(new Object[]{ObjConecta.rs.getInt("id_curso"),ObjConecta.rs.getString("nome_curso"),
                ObjConecta.rs.getString("abrev_curso"), ObjConecta.rs.getString("situacao_curso")});
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens.setModel(tabela);
        JTB_Itens.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Itens.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Itens.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Itens.getColumnModel().getColumn(1).setPreferredWidth(442);
        JTB_Itens.getColumnModel().getColumn(1).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(2).setPreferredWidth(120);
        JTB_Itens.getColumnModel().getColumn(2).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(3).setPreferredWidth(90);
        JTB_Itens.getColumnModel().getColumn(3).setResizable(false);
        JTB_Itens.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Itens.setAutoResizeMode(JTB_Itens.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Não)
        JTB_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
    }
    
    public final void Preencher_Tabela_Turma(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Semestre","Turma","Turno","Ano","Vestibular","Situação"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();
           
            do {
                dados.add(new Object[]{ObjConecta.rs.getInt("id_turma"),ObjConecta.rs.getInt("semestre"),
                ObjConecta.rs.getString("abrev_curso"),ObjConecta.rs.getString("turno"),ObjConecta.rs.getString("ano_turma"),
                ObjConecta.rs.getString("semestre_vestibular"),ObjConecta.rs.getString("situacao_turma")});
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens.setModel(tabela);
        JTB_Itens.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Itens.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Itens.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Itens.getColumnModel().getColumn(1).setPreferredWidth(100);
        JTB_Itens.getColumnModel().getColumn(1).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(2).setPreferredWidth(130);
        JTB_Itens.getColumnModel().getColumn(2).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(3).setPreferredWidth(132);
        JTB_Itens.getColumnModel().getColumn(3).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTB_Itens.getColumnModel().getColumn(4).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTB_Itens.getColumnModel().getColumn(5).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(6).setPreferredWidth(90);
        JTB_Itens.getColumnModel().getColumn(6).setResizable(false);
        JTB_Itens.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Itens.setAutoResizeMode(JTB_Itens.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Não)
        JTB_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
    }
    
    public final void Preencher_Tabela_Disciplina(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Disciplina","Semestre", "Situação"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();
           
            do {
                dados.add(new Object[]{ObjConecta.rs.getInt("id_disciplina"),ObjConecta.rs.getString("disciplina"),
                ObjConecta.rs.getString("semestre"), ObjConecta.rs.getString("situacao_disciplina")});
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens.setModel(tabela);
        JTB_Itens.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Itens.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Itens.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Itens.getColumnModel().getColumn(1).setPreferredWidth(450);
        JTB_Itens.getColumnModel().getColumn(1).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(2).setPreferredWidth(120);
        JTB_Itens.getColumnModel().getColumn(2).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(3).setPreferredWidth(90);
        JTB_Itens.getColumnModel().getColumn(3).setResizable(false);
        JTB_Itens.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Itens.setAutoResizeMode(JTB_Itens.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Não)
        JTB_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
    }
    
   public final void Preencher_Tabela_Produtos(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Descrição","Categoria", "Unidade","Minimo","Situação"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();           
            do {           
                         
                //adicionando na tabela
                dados.add(new Object[]{ObjConecta.rs.getInt("id_produto"),ObjConecta.rs.getString("descricao"),
                ObjConecta.rs.getString("categoria"),ObjConecta.rs.getString("unidade"),ObjConecta.rs.getString("quantidade_minima"),
                ObjConecta.rs.getString("situacao")});
            } while (ObjConecta.rs.next());
            
            ObjConecta.Desconecta();
        } catch (SQLException ex) {}
        
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens.setModel(tabela);
        JTB_Itens.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Itens.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Itens.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Itens.getColumnModel().getColumn(1).setPreferredWidth(300);
        JTB_Itens.getColumnModel().getColumn(1).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(2).setPreferredWidth(160);
        JTB_Itens.getColumnModel().getColumn(2).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(3).setPreferredWidth(80);
        JTB_Itens.getColumnModel().getColumn(3).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(4).setPreferredWidth(80);
        JTB_Itens.getColumnModel().getColumn(4).setResizable(false);
        JTB_Itens.getColumnModel().getColumn(5).setPreferredWidth(73);
        JTB_Itens.getColumnModel().getColumn(5).setResizable(false);
        JTB_Itens.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Itens.setAutoResizeMode(JTB_Itens.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Todas colunas)
        JTB_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
    }
    public final void Limpar_Tabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{};//Seta os indices da tabela
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens.setModel(tabela);
    }
    //metodos para visualizar os dialogs
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Ativ(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Ativ(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    public void Mostrar_Conf_Ativar_Usuario(){
        ObjConfSalvarUser = new Conf_Salvar_Ativ_User(this, true);
        ObjConfSalvarUser.setVisible(true);
    }
    public void Mostrar_Conf_Ativar_Produto(){
        ObjConfSalvarProd = new Conf_Salvar_Ativ_Prod(this, true);
        ObjConfSalvarProd.setVisible(true);
    }
    public void Mostrar_Conf_Ativar_Turma(){
        ObjConfSalvarTurma = new Conf_Salvar_Ativ_Turma(this, true);
        ObjConfSalvarTurma.setVisible(true);
    }
    public void Mostrar_Conf_Ativar_Curso(){
        ObjConfSalvarCurso = new Conf_Salvar_Ativ_Curso(this, true);
        ObjConfSalvarCurso.setVisible(true);
    }
    public void Mostrar_Conf_Ativar_Disciplina(){
        ObjConfSalvarDisciplina = new Conf_Salvar_Ativ_Disciplina(this, true);
        ObjConfSalvarDisciplina.setVisible(true);
    }
    public void Mostrar_Selecione_Linha(){
        ObjSelecioneLinha = new Inf_Selecione_Linha_Ativar(this, true);
        ObjSelecioneLinha.setVisible(true);
    }
    void Mostrar_Nao_Ha_Itens(){
        ObjNaoHaItenAtivar = new Inf_Nao_Ha_Itens_Ativar(this, true);
        ObjNaoHaItenAtivar.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Ativar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JComboBox JCB_Tipo_Pesquisa;
    private javax.swing.JTable JTB_Itens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

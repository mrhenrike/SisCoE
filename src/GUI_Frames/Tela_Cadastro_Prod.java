package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Produto;
import Conexao.Conecta_Banco;
import Conexao.Controle_Categoria;
import Conexao.Controle_Entrada_Produto;
import Conexao.Controle_Log;
import Conexao.Controle_Produto;
import GUI_Dialogs_Produto.Conf_Sair_Sem_Salvar_Prod;
import GUI_Dialogs_Produto.Conf_Salvar_Prod;
import GUI_Dialogs_Produto.Inf_Cadastro_Existente_Prod;
import GUI_Dialogs_Produto.Inf_Dados_Nao_Salvos_Prod;
import GUI_Dialogs_Produto.Inf_Dados_Salvos_Prod;
import GUI_Dialogs_Produto.Inf_Preencher_Campos_Prod;
import static GUI_Frames.Tela_Principal.CodLogado;
import Metodos.Formatacao;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;


public class Tela_Cadastro_Prod extends javax.swing.JInternalFrame {
    
    public static Tela_Cadastro_Categoria_DL ObjCadCategoria;
    
    public static Tela_Cadastro_Prod Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Cadastro_Prod();
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
    
    private static Inf_Preencher_Campos_Prod ObjPreencherCampos;
    private static Inf_Dados_Salvos_Prod ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_Prod ObjDadosNaoSalvos;
    private static Conf_Salvar_Prod ObjConfSalvar;
    private static Conf_Sair_Sem_Salvar_Prod ObjSairSemSalvar;
    private static Inf_Cadastro_Existente_Prod ObjCadExistente;
    
    Controle_Categoria ObjControlCat = new Controle_Categoria();
    Modelo_Produto ObjModeloProd = new Modelo_Produto();
    Controle_Produto ObjControlProd = new Controle_Produto();
    Formatacao ObjFormat = new Formatacao();
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Controle_Entrada_Produto ObjControlEntrada = new Controle_Entrada_Produto();
    

    public Tela_Cadastro_Prod() {
        initComponents();  
        
        JTF_Data_Cad.setDate(new Date(System.currentTimeMillis()));
        JTF_Data_Cad.setEnabled(false);
        
        JTF_Descricao.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Quant_Min.setDocument(ObjFormat.new Format_Apenas_Numero(10));
        JTF_Preco.setDocument(ObjFormat.new Format_Valor(50));
        JTF_Quant_Macro.setDocument(ObjFormat.new Format_Apenas_Numero(10));
        JTF_Id.setDocument(ObjFormat.new Format_Geral(50));
        
        Preencher_CB_Categoria();
        ObjControlProd.Preencher_CB_Macro(JCB_Macro);
        ObjControlProd.Preencher_CB_Unidade(JCB_Unidade);
        
        Setar_Atalho_BT();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JP_Descricao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTF_Descricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JCB_Categoria = new javax.swing.JComboBox();
        JCB_Unidade = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        JTF_Quant_Min = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JTF_Data_Cad = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        JTF_Quant_Macro = new javax.swing.JTextField();
        JCB_Macro = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JTF_Preco = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        JTF_Id = new javax.swing.JTextField();
        JP_Controle = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JCB_Solicita_Lote = new javax.swing.JComboBox();
        JCB_Solicita_Dev = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        BT_Sair = new javax.swing.JButton();
        BT_Salvar = new javax.swing.JButton();
        BT_Consulta = new javax.swing.JButton();
        JL_Campos = new javax.swing.JLabel();
        JL_Quant_Itens1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("1 - Cadastro De Produto");
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
        jLabel1.setText("Descrição*:");

        JTF_Descricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Data Cadastro:");

        JTF_Data_Cad.setDateFormatString("dd-MM-yyyy");
        JTF_Data_Cad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
        JTF_Preco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTF_PrecoFocusLost(evt);
            }
        });
        JTF_Preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_PrecoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Identificador:");

        JTF_Id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JP_DescricaoLayout = new javax.swing.GroupLayout(JP_Descricao);
        JP_Descricao.setLayout(JP_DescricaoLayout);
        JP_DescricaoLayout.setHorizontalGroup(
            JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_DescricaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_DescricaoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_DescricaoLayout.createSequentialGroup()
                        .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JP_DescricaoLayout.createSequentialGroup()
                                .addComponent(JTF_Quant_Min, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(JCB_Macro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(JCB_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_DescricaoLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(JTF_Quant_Macro))
                            .addGroup(JP_DescricaoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(JCB_Unidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_Data_Cad, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(JTF_Preco)
                    .addComponent(JTF_Id))
                .addContainerGap())
        );
        JP_DescricaoLayout.setVerticalGroup(
            JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_DescricaoLayout.createSequentialGroup()
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTF_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(JTF_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JP_DescricaoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JCB_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(JCB_Unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_DescricaoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JTF_Data_Cad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTF_Quant_Min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel12)
                        .addComponent(jLabel9)
                        .addComponent(JCB_Macro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_DescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTF_Quant_Macro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(JTF_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout JP_ControleLayout = new javax.swing.GroupLayout(JP_Controle);
        JP_Controle.setLayout(JP_ControleLayout);
        JP_ControleLayout.setHorizontalGroup(
            JP_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ControleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(JCB_Solicita_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(JCB_Solicita_Dev, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_ControleLayout.setVerticalGroup(
            JP_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_ControleLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(JP_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JCB_Solicita_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Solicita_Dev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
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

        BT_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar.png"))); // NOI18N
        BT_Salvar.setMnemonic('s');
        BT_Salvar.setToolTipText("Clique Para Salvar Ou Pressione Alt + S");
        BT_Salvar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar Press.png"))); // NOI18N
        BT_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SalvarActionPerformed(evt);
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

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Sair | F3 - Consultar | F10 - Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_Descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JP_Controle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JL_Campos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Quant_Itens1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JP_Controle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Quant_Itens1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Consulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JL_Campos))
                .addContainerGap())
        );

        setBounds(20, 20, 805, 355);
    }// </editor-fold>//GEN-END:initComponents

    private void JCB_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_CategoriaActionPerformed
       if(JCB_Categoria.getSelectedItem().equals("+ ADICIONAR NOVO")){
           Inicio_CB_Categoria();
           Mostrar_Cadastro_Categoria();           
       }
    }//GEN-LAST:event_JCB_CategoriaActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Sair_Sem_Salvar(); 
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        Testar_Campos();
        
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void BT_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConsultaActionPerformed
        Tela_Consulta_Produto obj = new Tela_Consulta_Produto();
        obj.Open_Tela();
        dispose();  
    }//GEN-LAST:event_BT_ConsultaActionPerformed

    private void JTF_PrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PrecoActionPerformed
        JCB_Solicita_Lote.requestFocus();
    }//GEN-LAST:event_JTF_PrecoActionPerformed

    private void JTF_PrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_PrecoFocusLost
        if(JTF_Preco.getText().equalsIgnoreCase("")){
            JTF_Preco.setValue(null);}           
        else{
            JCB_Solicita_Lote.requestFocus();
        }
    }//GEN-LAST:event_JTF_PrecoFocusLost

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed
        
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
        JTF_Data_Cad.setDate(null);
        JTF_Data_Cad.setDate(new Date(System.currentTimeMillis()));
    }
    
    public void Testar_Campos(){
        if((JTF_Descricao.getText().equalsIgnoreCase(""))
        ||(JTF_Quant_Min.getText().equalsIgnoreCase(""))
        ||(JCB_Categoria.getSelectedIndex()==0)
        ||(JCB_Solicita_Dev.getSelectedIndex()==0)
        ||(JCB_Solicita_Lote.getSelectedIndex()==0)
        ||(JCB_Unidade.getSelectedIndex()==0))
        {
            Mostrar_Preencher_Campos(); 
        }else{
            ObjControlProd.Testar_Existente(JTF_Descricao);
            if(ObjControlProd.Controle_Existente == true){
                Mostrar_Cadastro_Existente();
                ObjControlProd.Controle_Existente = false;
            }else{
                Mostrar_Conf_Salvar();
            }
        }
    }
    
     public void Sair_Sem_Salvar(){
        if((!JTF_Descricao.getText().equalsIgnoreCase(""))
        ||(!JTF_Quant_Min.getText().equalsIgnoreCase(""))
        ||(!JTF_Id.getText().equalsIgnoreCase(""))
        ||(!JTF_Preco.getText().equalsIgnoreCase(""))
        ||(!JTF_Quant_Macro.getText().equalsIgnoreCase(""))
        ||(JCB_Macro.getSelectedIndex()!=0)
        ||(JCB_Categoria.getSelectedIndex()!=0)
        ||(JCB_Solicita_Dev.getSelectedIndex()!=0)
        ||(JCB_Solicita_Lote.getSelectedIndex()!=0)
        ||(JCB_Unidade.getSelectedIndex()!=0))
        {
            Mostrar_Sair_Sem_Salvar();
        }else{
            dispose();
        }
    }
    
    public void Preencher_Objetos_Produtos(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ObjModeloProd.setData_cad(String.valueOf(df.format(JTF_Data_Cad.getDate())));
        ObjModeloProd.setDescricao(JTF_Descricao.getText().trim());
        ObjModeloProd.setIdentificacao(JTF_Id.getText().trim());
        //teste para setar sem valores no banco;
        if(!JTF_Quant_Min.getText().equalsIgnoreCase(""))
        { ObjModeloProd.setQuant_minima(Integer.parseInt(JTF_Quant_Min.getText().trim())); }
        else
        { ObjModeloProd.setQuant_minima(0); }
        if(!JTF_Quant_Macro.getText().equalsIgnoreCase(""))
        { ObjModeloProd.setQuant_macro(Integer.parseInt(JTF_Quant_Macro.getText().trim())); }
        else
        { ObjModeloProd.setQuant_macro(0); }
        if(!JTF_Preco.getText().equalsIgnoreCase(""))
        { ObjModeloProd.setPreco(Double.valueOf(JTF_Preco.getText().trim().replace(",", "."))); }
        else
        { ObjModeloProd.setPreco(0); }

        ObjModeloProd.setMacro(JCB_Macro.getSelectedItem().toString().toUpperCase().trim());
        ObjModeloProd.setUnidade(JCB_Unidade.getSelectedItem().toString().toUpperCase().trim());
        ObjModeloProd.setSolicita_lote(JCB_Solicita_Lote.getSelectedItem().toString().toUpperCase().trim());
        ObjModeloProd.setSolicita_devolucao(JCB_Solicita_Dev.getSelectedItem().toString().trim());
        
        
    }
    public void Procura_Id_Categoria(){
        if(JCB_Categoria.getSelectedIndex()!=0){
            try {
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("Select * from categoria_produto where categoria=" + "'" + JCB_Categoria.getSelectedItem().toString() + "'" + "");
                ObjConecta.rs.first();
                ObjModeloProd.setCategoria_id_produto(ObjConecta.rs.getInt("id_categoria"));
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Logger.getLogger(Tela_Cadastro_Prod.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void Conf_Inserir_Produto(){
        Procura_Id_Categoria();
        Preencher_Objetos_Produtos();
        ObjControlProd.Inserir_Produto(ObjModeloProd);
            if (ObjControlProd.Confirma_Inserir == true) {
                Mostrar_Dados_Salvos();
                //log
                new Controle_Log().Registrar_Log("Cadastrou novo produto id: "+ObjModeloProd.getId_produto()+" - "+ObjModeloProd.getDescricao(), CodLogado);
                Limpar_Campos();
                ObjControlProd.Confirma_Inserir = false;
            } else {
                Mostrar_Dados_Nao_Salvos();
                //log
                new Controle_Log().Registrar_Log("Erro ao cadastrar um novo produto", CodLogado);
                ObjControlProd.Confirma_Inserir = false;
            }
            //metodo para inserir o novo estoque
            ObjControlEntrada.Controla_Lote(ObjModeloProd.getId_produto());
            if(ObjControlEntrada.ControlaLote == false){
                ObjControlEntrada.Inserir_Estoque(ObjModeloProd.getId_produto(), 0);
            }else{
                ObjControlEntrada.Inserir_Estoque_Lote(ObjModeloProd.getId_produto(),0,"NOVO",null);
            }
    }
    
    public final void Preencher_CB_Categoria(){
        ObjControlCat.Preencher_CB_Categoria(JCB_Categoria);
    }
    
    public void Inicio_CB_Categoria(){
        JCB_Categoria.setSelectedIndex(0);
    } 
     void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Prod(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Prod(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Prod(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    void Mostrar_Conf_Salvar(){
        ObjConfSalvar = new Conf_Salvar_Prod(this, true);
        ObjConfSalvar.setVisible(true);        
    }
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Prod(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    public void Mostrar_Cadastro_Categoria(){
        ObjCadCategoria = new Tela_Cadastro_Categoria_DL(this, true);
        ObjCadCategoria.setVisible(true);
    }
    void Mostrar_Cadastro_Existente(){
        ObjCadExistente = new Inf_Cadastro_Existente_Prod(this, true);
        ObjCadExistente.setVisible(true);
    }
    
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0),"Salvar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap4);
        
        InputMap inputMap3 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),"Consultar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);
                
        //método para executar
         this.getRootPane().getActionMap().put("Salvar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Salvar.doClick();
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
        BT_Consulta.doClick();
        }
        }); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Consulta;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JComboBox JCB_Categoria;
    private javax.swing.JComboBox JCB_Macro;
    private javax.swing.JComboBox JCB_Solicita_Dev;
    private javax.swing.JComboBox JCB_Solicita_Lote;
    private javax.swing.JComboBox JCB_Unidade;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JPanel JP_Controle;
    private javax.swing.JPanel JP_Descricao;
    private com.toedter.calendar.JDateChooser JTF_Data_Cad;
    private javax.swing.JTextField JTF_Descricao;
    private javax.swing.JTextField JTF_Id;
    private javax.swing.JFormattedTextField JTF_Preco;
    private javax.swing.JTextField JTF_Quant_Macro;
    private javax.swing.JTextField JTF_Quant_Min;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}

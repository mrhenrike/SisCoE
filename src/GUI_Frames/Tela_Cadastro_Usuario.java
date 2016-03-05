package GUI_Frames;

//@author Márison Tamiarana

import GUI_Dialogs_Usuario.Conf_Cancelar_Cadastro;
import Classes.Modelo_Usuario;
import Conexao.Controle_Usuario;
import GUI_Dialogs_Usuario.Conf_Salvar;
import GUI_Dialogs_Usuario.Inf_Dados_Nao_Salvos;
import GUI_Dialogs_Usuario.Inf_Dados_Salvos;
import GUI_Dialogs_Usuario.Inf_Preencher_Campos;
import GUI_Dialogs_Usuario.Inf_Senhas_Diferentes;
import GUI_Dialogs_Usuario.Inf_Senhas_Minima;
import GUI_Dialogs_Usuario.Conf_Limpar_Campos_Usuario;
import GUI_Dialogs_Usuario.Conf_Sair_Sem_Salvar;
import GUI_Dialogs_Usuario.Inf_Cadastro_Existente_User;
import Metodos.Formatacao;
import Metodos.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.KeyStroke;


public class Tela_Cadastro_Usuario extends javax.swing.JInternalFrame {
    //Metodo Para instaciar apenas um Internal e centralizado
    public static Tela_Cadastro_Usuario Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Cadastro_Usuario();
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

    //Instanciando objetos de outras classes para usar os metodos dessa classe
    Metodos ObjMetodo = new Metodos();
    Modelo_Usuario ObjModeloUser = new Modelo_Usuario();
    Controle_Usuario ObjControlUser = new Controle_Usuario();
    Formatacao ObjFormat = new Formatacao();
      
    //Instância de objetos do tipo dialog
    private static Conf_Limpar_Campos_Usuario objLimparCampos;
    private static Inf_Preencher_Campos ObjPreencherCampos;
    private static Inf_Dados_Salvos ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos ObjDadosNaoSalvos;
    private static Inf_Senhas_Diferentes ObjSenhasDiferentes;
    private static Conf_Salvar ObjConfSalvar;
    private static Conf_Sair_Sem_Salvar ObjSairSemSalvar;
    private static Conf_Cancelar_Cadastro ObjCancelUser;
    private static Inf_Senhas_Minima ObjSenhaMinima;
    private static Inf_Cadastro_Existente_User ObjCadastroExiste;
    
    public boolean Confirma_Inserir2;
    
        
    public Tela_Cadastro_Usuario() {
        initComponents();
        
        //Setando a data de cadastro
        JTF_Data_Cad.setDate(new Date(System.currentTimeMillis()));
        JTF_Data_Cad.setEnabled(false);
        
        //Formatação dos campos
        JTF_Senha.setDocument(ObjFormat.new Format_Campo_Senha(50));
        JTF_Senha_Conf.setDocument(ObjFormat.new Format_Campo_Senha(50));
        JTF_Nome.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Nome_Us.setDocument(ObjFormat.new Format_Geral(50));
        Setar_Atalho_BT();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JP_Dados_Pess = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTF_Nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JCB_Sexo = new javax.swing.JComboBox();
        JCB_Permissão = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JTF_Celular = new javax.swing.JFormattedTextField();
        JTF_Data_Cad = new com.toedter.calendar.JDateChooser();
        JP_Dados_Us = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JL_Senha = new javax.swing.JLabel();
        JTF_Nome_Us = new javax.swing.JTextField();
        JTF_Senha = new javax.swing.JPasswordField();
        JTF_Senha_Conf = new javax.swing.JPasswordField();
        JL_Senha_Conf = new javax.swing.JLabel();
        BT_Salvar = new javax.swing.JButton();
        BT_Sair = new javax.swing.JButton();
        BT_Consulta = new javax.swing.JButton();
        BT_Limpar = new javax.swing.JButton();
        JL_Caracteres = new javax.swing.JLabel();
        JL_Campos = new javax.swing.JLabel();
        JL_Quant_Itens1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Cadastro De Usuário");
        setToolTipText("");
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

        JP_Dados_Pess.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome*:");

        JTF_Nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Sexo*:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Data Cadastro:");

        JCB_Sexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "MASCULINO", "FEMININO", "OUTRO" }));
        JCB_Sexo.setToolTipText("Selecione O Sexo");
        JCB_Sexo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JCB_SexoFocusGained(evt);
            }
        });

        JCB_Permissão.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Permissão.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ADMINISTRADOR", "USUÁRIO" }));
        JCB_Permissão.setToolTipText("Selecione O Tipo De Permissão Ao Sistema");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Permissão*:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Celular:");

        JTF_Celular.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        JTF_Celular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Celular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_CelularFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTF_CelularFocusLost(evt);
            }
        });

        JTF_Data_Cad.setDateFormatString("dd-MM-yyyy");
        JTF_Data_Cad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JP_Dados_PessLayout = new javax.swing.GroupLayout(JP_Dados_Pess);
        JP_Dados_Pess.setLayout(JP_Dados_PessLayout);
        JP_Dados_PessLayout.setHorizontalGroup(
            JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_PessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Dados_PessLayout.createSequentialGroup()
                        .addComponent(JCB_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(JCB_Permissão, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(JP_Dados_PessLayout.createSequentialGroup()
                        .addComponent(JTF_Nome)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTF_Celular)
                    .addComponent(JTF_Data_Cad, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addContainerGap())
        );
        JP_Dados_PessLayout.setVerticalGroup(
            JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_PessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTF_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(JTF_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(JCB_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(JCB_Permissão, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(JTF_Data_Cad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JP_Dados_Us.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados De Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nome De Usuário*:");

        JL_Senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Senha.setText("Senha**:");

        JTF_Nome_Us.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Senha_Conf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JL_Senha_Conf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Senha_Conf.setText("Repita A Senha**:");

        javax.swing.GroupLayout JP_Dados_UsLayout = new javax.swing.GroupLayout(JP_Dados_Us);
        JP_Dados_Us.setLayout(JP_Dados_UsLayout);
        JP_Dados_UsLayout.setHorizontalGroup(
            JP_Dados_UsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_UsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Dados_UsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(JL_Senha)
                    .addComponent(JL_Senha_Conf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Dados_UsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_Nome_Us, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addGroup(JP_Dados_UsLayout.createSequentialGroup()
                        .addGroup(JP_Dados_UsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTF_Senha_Conf, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(JTF_Senha))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_Dados_UsLayout.setVerticalGroup(
            JP_Dados_UsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_UsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Dados_UsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(JTF_Nome_Us, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JP_Dados_UsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Senha))
                .addGap(18, 18, 18)
                .addGroup(JP_Dados_UsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Senha_Conf)
                    .addComponent(JTF_Senha_Conf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        BT_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar.png"))); // NOI18N
        BT_Salvar.setMnemonic('s');
        BT_Salvar.setToolTipText("Clique Para Salvar Ou Pressione Alt + S");
        BT_Salvar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar Press.png"))); // NOI18N
        BT_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SalvarActionPerformed(evt);
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

        BT_Consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar.png"))); // NOI18N
        BT_Consulta.setMnemonic('n');
        BT_Consulta.setToolTipText("Clique Para Consultar Ou Pressione Alt + N");
        BT_Consulta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar Press.png"))); // NOI18N
        BT_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ConsultaActionPerformed(evt);
            }
        });

        BT_Limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Limpar.png"))); // NOI18N
        BT_Limpar.setMnemonic('l');
        BT_Limpar.setToolTipText("Clique Para Limpar Os Campos Ou Pressione Alt + L");
        BT_Limpar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Limpar Pess.png"))); // NOI18N
        BT_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_LimparActionPerformed(evt);
            }
        });

        JL_Caracteres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Caracteres.setText("**Caracteres Permitidos (A-Z, 0-9)");

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Sair | F3 - Consultar | F8 - Limpar | F10 - Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_Dados_Pess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 81, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JP_Dados_Us, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(JL_Caracteres))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JL_Campos))))
                            .addComponent(JL_Quant_Itens1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Dados_Pess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(JL_Campos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JL_Caracteres))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JP_Dados_Us, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Quant_Itens1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BT_Salvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_Consulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_Limpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setBounds(20, 20, 805, 413);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_LimparActionPerformed
        Mostrar_Limpar_Campos();
    }//GEN-LAST:event_BT_LimparActionPerformed

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        Testar_Campos();
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void BT_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConsultaActionPerformed
       try {
            Tela_Consulta_Usuario obj = new Tela_Consulta_Usuario();
            obj.Open_Tela();
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Cadastro_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BT_ConsultaActionPerformed

    private void JTF_CelularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_CelularFocusGained
        Mascara_Celular(JTF_Celular,"(##) #####-####");
    }//GEN-LAST:event_JTF_CelularFocusGained

    private void JTF_CelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_CelularFocusLost
        if(JTF_Celular.getText().equalsIgnoreCase("(  )      -    ")){
            Mascara_Celular(JTF_Celular,"");
            JTF_Celular.setValue(null);
        }
        else{  }
    }//GEN-LAST:event_JTF_CelularFocusLost

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Sair_Sem_Salvar();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void JCB_SexoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JCB_SexoFocusGained
         if(JTF_Celular.getText().equalsIgnoreCase("(  )      -    ")){
            Mascara_Celular(JTF_Celular,"");
            JTF_Celular.setValue(null);
        }
        else{  }
    }//GEN-LAST:event_JCB_SexoFocusGained

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    //Metodos
    
    public void Limpar_Campos(){
        JTF_Nome.setText("");
        JTF_Nome_Us.setText("");
        JTF_Senha.setText("");
        JTF_Senha_Conf.setText("");
        JCB_Permissão.setSelectedIndex(0);
        JCB_Sexo.setSelectedIndex(0);
        Mascara_Celular(JTF_Celular,"");
        JTF_Celular.setValue(null);
    }
    
    static void Mascara_Celular(JFormattedTextField jt, String mascara){
        try {
            jt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter(mascara)));
        } catch (ParseException ex) {
            Logger.getLogger(Tela_Cadastro_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Testar_Campos() {
        if (   (JTF_Nome.getText().equalsIgnoreCase(""))
             ||(JCB_Permissão.getSelectedItem().equals(""))
             ||(JCB_Sexo.getSelectedItem().equals(""))
             ||(JTF_Nome_Us.getText().equalsIgnoreCase(""))
             ||(new String (JTF_Senha.getPassword()).equalsIgnoreCase(""))
             ||(new String (JTF_Senha_Conf.getPassword()).equalsIgnoreCase("")))//Campos obrigatórios em brancos
        {
            Mostrar_Preencher_Campos();
        }
        else if (!(new String (JTF_Senha.getPassword())).equals(new String(JTF_Senha_Conf.getPassword()))) //Senhas diferentes
        {
            JL_Senha.setForeground(Color.red);
            JL_Senha_Conf.setForeground(Color.red);
            Mostrar_Senhas_Diferentes();
        }
        else if ((new String (JTF_Senha.getPassword()).length()<4)&&(new String(JTF_Senha_Conf.getPassword())).length()<4) //senha menor que 4 digitos
        {
            Mostrar_Senha_Minima();
        }
        else{
            ObjControlUser.Testar_Existente(JTF_Nome_Us);
            if(ObjControlUser.ControleExistente==true){
                Mostrar_Cadastro_Existente();
                ObjControlUser.ControleExistente=false;
            }
            else{
                JL_Senha.setForeground(Color.black);
                JL_Senha_Conf.setForeground(Color.black);
                Mostrar_Conf_Salvar();
            }
        }
    }
    
    public void Sair_Sem_Salvar() {
         if (   (!JTF_Nome.getText().equalsIgnoreCase(""))
             ||(!JCB_Permissão.getSelectedItem().equals(" "))
             ||(!JCB_Sexo.getSelectedItem().equals(" "))
             ||(!JTF_Nome_Us.getText().equalsIgnoreCase(""))
             ||(!new String (JTF_Senha.getPassword()).equalsIgnoreCase(""))
             ||(!new String (JTF_Senha_Conf.getPassword()).equalsIgnoreCase("")))
            {
                Mostrar_Sair_Sem_Salvar();
            }
        
        else{
            
            dispose();
            }
    }
    public void Preencher_Obj_Usuario(){
        ObjModeloUser.setNome(JTF_Nome.getText().trim());
        ObjModeloUser.setLogin(JTF_Nome_Us.getText().trim());
        ObjModeloUser.setSenha(new String(JTF_Senha.getPassword()));
        ObjModeloUser.setSexo((String) JCB_Sexo.getSelectedItem());
        ObjModeloUser.setPermissao((String) JCB_Permissão.getSelectedItem());
        ObjModeloUser.setTelefone(JTF_Celular.getText().trim());
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ObjModeloUser.setData_cad(String.valueOf(df.format(JTF_Data_Cad.getDate())));
               
    }
    
         
    public void Mostrar_Limpar_Campos(){
        objLimparCampos = new Conf_Limpar_Campos_Usuario(this, true);
        objLimparCampos.setVisible(true);   
    }
    void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    void Mostrar_Senhas_Diferentes(){
        ObjSenhasDiferentes = new Inf_Senhas_Diferentes(this, true);
        ObjSenhasDiferentes.setVisible(true);
    }
    void Mostrar_Conf_Salvar(){
        ObjConfSalvar = new Conf_Salvar(this, true);
        ObjConfSalvar.setVisible(true);        
    }
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    void Mostrar_Cancelar_Cadastro(){
        ObjCancelUser = new Conf_Cancelar_Cadastro(this, true);
        ObjCancelUser.setVisible(true);
    }
    void Mostrar_Senha_Minima(){
        ObjSenhaMinima = new Inf_Senhas_Minima(this, true);
        ObjSenhaMinima.setVisible(true);
    }
    public void Mostrar_Cadastro_Existente(){
        ObjCadastroExiste = new Inf_Cadastro_Existente_User(this, true);
        ObjCadastroExiste.setVisible(true);
    }
    public void Conf_Inserir_Usario(){
        Preencher_Obj_Usuario();
        ObjControlUser.Inserir_Usuario(ObjModeloUser);
        if (ObjControlUser.Confirma_Inserir == true) 
            {
                Mostrar_Dados_Salvos();
                Limpar_Campos();
                ObjControlUser.Confirma_Inserir = false;
            }
            else{
                Mostrar_Dados_Nao_Salvos();
                ObjControlUser.Confirma_Inserir = false;
                }
        }
    
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),"Consultar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
        
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0),"Salvar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap4);
                
        InputMap inputMap5 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap5.put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0),"Limpar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap5);
        //método para executar
         this.getRootPane().getActionMap().put("Salvar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Salvar.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Consultar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Consulta.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Sair.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Limpar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Limpar.doClick();
        }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Consulta;
    private javax.swing.JButton BT_Limpar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JComboBox JCB_Permissão;
    private javax.swing.JComboBox JCB_Sexo;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Caracteres;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JLabel JL_Senha;
    private javax.swing.JLabel JL_Senha_Conf;
    private javax.swing.JPanel JP_Dados_Pess;
    private javax.swing.JPanel JP_Dados_Us;
    private javax.swing.JFormattedTextField JTF_Celular;
    private com.toedter.calendar.JDateChooser JTF_Data_Cad;
    private javax.swing.JTextField JTF_Nome;
    private javax.swing.JTextField JTF_Nome_Us;
    private javax.swing.JPasswordField JTF_Senha;
    private javax.swing.JPasswordField JTF_Senha_Conf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables


}

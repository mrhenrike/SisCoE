package GUI_Frames;

//@author Márison Tamiarana

import Classes.Modelo_Usuario;
import Conexao.Controle_Usuario;
import GUI_Dialogs_Usuario.Conf_Excluir_Edit;
import GUI_Dialogs_Usuario.Conf_Sair_Sem_Salvar_Edit;
import GUI_Dialogs_Usuario.Conf_Salvar_Edit;
import GUI_Dialogs_Usuario.Inf_Cadastro_Existente_User_Edit;
import GUI_Dialogs_Usuario.Inf_Dados_Excluidos_Edit;
import GUI_Dialogs_Usuario.Inf_Dados_Nao_Excluidos_Edit;
import GUI_Dialogs_Usuario.Inf_Dados_Nao_Salvos_Edit;
import GUI_Dialogs_Usuario.Inf_Dados_Salvos_Edit;
import GUI_Dialogs_Usuario.Inf_Preencher_Campos_Edit;
import GUI_Dialogs_Usuario.Inf_Senhas_Diferentes_Edit;
import GUI_Dialogs_Usuario.Inf_Senhas_Minima_Edit;
import static GUI_Frames.Tela_Principal.PermissaoLogado;
import Metodos.Formatacao;
import Metodos.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


public class Tela_Cadastro_Usuario_Edit extends javax.swing.JInternalFrame {
    
    public static Tela_Cadastro_Usuario_Edit Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Cadastro_Usuario_Edit();
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
    
        private static Inf_Preencher_Campos_Edit ObjPreencherCampos;
        private static Inf_Dados_Salvos_Edit ObjDadosSalvos;
        private static Inf_Dados_Nao_Salvos_Edit ObjDadosNaoSalvos;
        private static Inf_Senhas_Diferentes_Edit ObjSenhasDiferentes;
        private static Conf_Salvar_Edit ObjConfSalvar;
        private static Conf_Sair_Sem_Salvar_Edit ObjSairSemSalvar;
        private static Inf_Senhas_Minima_Edit ObjSenhaMinima;
        private static Conf_Excluir_Edit ObjConfExcluir;
        private static Inf_Dados_Excluidos_Edit ObjExcluido;
        private static Inf_Dados_Nao_Excluidos_Edit ObjNaoExcluido;
        private static Inf_Cadastro_Existente_User_Edit ObjCadastroExiste;
    
        public boolean Confirma_Inserir2;
        public boolean Habilita;//Variavel usada para testar o botao sair
        String Usuario;
    
    public Tela_Cadastro_Usuario_Edit() {
        initComponents();
        Controle_Acesso();
       
        Habilita_Campos(false);        
        JTF_Cod.setEnabled(false);
        BT_Salvar.setEnabled(false);
        
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
        JCB_Sexo = new javax.swing.JComboBox();
        JCB_Permissão = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JTF_Celular = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        JTF_Cod = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        JCB_Situacao = new javax.swing.JComboBox();
        JP_Dados_Us = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JL_Senha = new javax.swing.JLabel();
        JTF_Nome_Us = new javax.swing.JTextField();
        JTF_Senha = new javax.swing.JPasswordField();
        JTF_Senha_Conf = new javax.swing.JPasswordField();
        JL_Senha_Conf = new javax.swing.JLabel();
        BT_Salvar = new javax.swing.JButton();
        BT_Sair = new javax.swing.JButton();
        BT_Editar = new javax.swing.JButton();
        JL_Caracteres = new javax.swing.JLabel();
        JL_Campos = new javax.swing.JLabel();
        JL_Quant_Itens1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Cadastro De Usuário");
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

        JCB_Sexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "MASCULINO", "FEMININO", "OUTRO" }));
        JCB_Sexo.setToolTipText("Selecione O Sexo");

        JCB_Permissão.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Permissão.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "ADMINISTRADOR", "USUÁRIO" }));
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Código:");

        JTF_Cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Cod.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Situação*:");

        JCB_Situacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Situacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "ATIVO", "INATIVO" }));

        javax.swing.GroupLayout JP_Dados_PessLayout = new javax.swing.GroupLayout(JP_Dados_Pess);
        JP_Dados_Pess.setLayout(JP_Dados_PessLayout);
        JP_Dados_PessLayout.setHorizontalGroup(
            JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_PessLayout.createSequentialGroup()
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Dados_PessLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addGroup(JP_Dados_PessLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JCB_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Cod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_Nome)
                    .addComponent(JCB_Permissão, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTF_Celular)
                    .addComponent(JCB_Situacao, 0, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        JP_Dados_PessLayout.setVerticalGroup(
            JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Dados_PessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(JTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(JCB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Dados_PessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCB_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(JCB_Permissão, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(JTF_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(JTF_Nome_Us, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGroup(JP_Dados_UsLayout.createSequentialGroup()
                        .addGroup(JP_Dados_UsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JTF_Senha_Conf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(JTF_Senha, javax.swing.GroupLayout.Alignment.LEADING))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Voltar.png"))); // NOI18N
        BT_Sair.setMnemonic('l');
        BT_Sair.setToolTipText("Clique Para Voltar Ou Pressione Alt + L");
        BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Voltar Press.png"))); // NOI18N
        BT_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SairActionPerformed(evt);
            }
        });

        BT_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar.png"))); // NOI18N
        BT_Editar.setMnemonic('e');
        BT_Editar.setToolTipText("Clique Para Editar Os Dados Ou Pressione Alt + E");
        BT_Editar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Editar press.png"))); // NOI18N
        BT_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_EditarActionPerformed(evt);
            }
        });

        JL_Caracteres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Caracteres.setText("**Caracteres Permitidos (A-Z, 0-9)");

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Voltar | F7 - Editar | F10 - Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JP_Dados_Pess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JP_Dados_Us, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JL_Caracteres)
                                    .addComponent(JL_Campos)))
                            .addComponent(JL_Quant_Itens1))
                        .addGap(0, 104, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JP_Dados_Pess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JL_Campos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JL_Caracteres))
                    .addComponent(JP_Dados_Us, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Quant_Itens1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BT_Salvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_Editar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setBounds(20, 20, 805, 413);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_EditarActionPerformed
        Usuario = JTF_Nome_Us.getText();
        Habilita_Campos(true);
        Habilita = true;
        BT_Salvar.setEnabled(true);
        BT_Editar.setEnabled(false);
        Virar_BT_Cancelar();
    }//GEN-LAST:event_BT_EditarActionPerformed

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        Testar_Campos();
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void JTF_CelularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_CelularFocusGained
        Mascara_Celular(JTF_Celular,"(##) #####-####");        
    }//GEN-LAST:event_JTF_CelularFocusGained

    private void JTF_CelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_CelularFocusLost
        if(JTF_Celular.getText().equalsIgnoreCase("(  )      -    ")){
            Mascara_Celular(JTF_Celular,"");        
        }
    }//GEN-LAST:event_JTF_CelularFocusLost

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        if(Habilita ==true)
            {
                Sair_Sem_Salvar();
            }
        else{
            try {
                Tela_Consulta_Usuario obj = new Tela_Consulta_Usuario();
                obj.Open_Tela();
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Cadastro_Usuario_Edit.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }//GEN-LAST:event_BT_SairActionPerformed

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
            Logger.getLogger(Tela_Cadastro_Usuario_Edit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Testar_Campos() {
        if (   (JTF_Nome.getText().equalsIgnoreCase(""))
             ||(JCB_Permissão.getSelectedItem().equals(""))
             ||(JCB_Sexo.getSelectedItem().equals(""))
             ||(JTF_Nome_Us.getText().equalsIgnoreCase(""))
             ||(new String (JTF_Senha.getPassword()).equalsIgnoreCase(""))
             ||(new String (JTF_Senha_Conf.getPassword()).equalsIgnoreCase("")))
        {
            Mostrar_Preencher_Campos();
            JL_Campos.setVisible(true);
        }
        else if (!(new String (JTF_Senha.getPassword())).equals(new String(JTF_Senha_Conf.getPassword()))) 
        {
            JL_Senha.setForeground(Color.red);
            JL_Senha_Conf.setForeground(Color.red);
            Mostrar_Senhas_Diferentes();
        }
        else if ((new String (JTF_Senha.getPassword()).length()<=4)&&(new String(JTF_Senha_Conf.getPassword())).length()<4) 
        {
            Mostrar_Senha_Minima();
        }
        else if(JTF_Nome_Us.getText().equalsIgnoreCase(Usuario))
        {
            Mostrar_Conf_Salvar();
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
             ||(!JCB_Permissão.getSelectedItem().equals(""))
             ||(!JCB_Sexo.getSelectedItem().equals(""))
             ||(!JTF_Nome_Us.getText().equalsIgnoreCase(""))
             ||(!new String (JTF_Senha.getPassword()).equalsIgnoreCase(""))
             ||(!new String (JTF_Senha_Conf.getPassword()).equalsIgnoreCase("")))
            {
                Mostrar_Sair_Sem_Salvar();
            }
        else{
             try {
                Tela_Consulta_Usuario obj = new Tela_Consulta_Usuario();
                obj.Open_Tela();
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Cadastro_Usuario_Edit.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
    
    public void Preencher_Obj_Usuario(){
        ObjModeloUser.setNome(JTF_Nome.getText().trim());
        ObjModeloUser.setLogin(JTF_Nome_Us.getText().trim());
        ObjModeloUser.setSenha(new String(JTF_Senha.getPassword()));
        ObjModeloUser.setSexo((String) JCB_Sexo.getSelectedItem());
        ObjModeloUser.setPermissao((String) JCB_Permissão.getSelectedItem());
        ObjModeloUser.setTelefone(JTF_Celular.getText().trim());
        ObjModeloUser.setSituacao((String) JCB_Situacao.getSelectedItem());
             
    }
    
      
    private void Habilita_Campos(boolean Condicao){
        JTF_Nome.setEnabled(Condicao);
        JTF_Celular.setEnabled(Condicao);
        JTF_Nome_Us.setEnabled(Condicao);
        JTF_Senha.setEnabled(Condicao);
        JTF_Senha_Conf.setEnabled(Condicao);
        JCB_Permissão.setEnabled(Condicao);
        JCB_Sexo.setEnabled(Condicao);
        JCB_Situacao.setEnabled(Condicao);
    }
     
    void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Edit(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Edit(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Edit(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    void Mostrar_Senhas_Diferentes(){
        ObjSenhasDiferentes = new Inf_Senhas_Diferentes_Edit(this, true);
        ObjSenhasDiferentes.setVisible(true);
    }
    void Mostrar_Conf_Salvar(){
        ObjConfSalvar = new Conf_Salvar_Edit(this, true);
        ObjConfSalvar.setVisible(true);        
    }
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Edit(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    void Mostrar_Senha_Minima(){
        ObjSenhaMinima = new Inf_Senhas_Minima_Edit(this, true);
        ObjSenhaMinima.setVisible(true);
    }
    void Mostrar_Conf_Excluir_Dados(){
        ObjConfExcluir = new Conf_Excluir_Edit(this, true);
        ObjConfExcluir.setVisible(true);
    }
    void Mostrar_Dados_Excluidos_Edit(){
        ObjExcluido = new Inf_Dados_Excluidos_Edit(this, true);
        ObjExcluido.setVisible(true);
    }
    void Mostrar_Dados_Nao_Excluidos_Edit(){
        ObjNaoExcluido = new Inf_Dados_Nao_Excluidos_Edit(this, true);
        ObjNaoExcluido.setVisible(true);
    }
     public void Mostrar_Cadastro_Existente(){
        ObjCadastroExiste = new Inf_Cadastro_Existente_User_Edit(this, true);
        ObjCadastroExiste.setVisible(true);
    }
    public void teste(){
    Mostrar_Dados_Nao_Excluidos_Edit();
    }

public void Carregar_Dados_Usuarios(Object LinhaSelecionada) throws SQLException { 
        try {    
            
            Modelo_Usuario ObjModeloUsuario = new Modelo_Usuario();
            
            ObjModeloUsuario.setPesquisa(String.valueOf(LinhaSelecionada));
               
            ObjControlUser.Consulta_Usuario(ObjModeloUsuario);
            
            JTF_Cod.setText(String.valueOf(ObjModeloUsuario.getId_usuario()));
            JTF_Nome.setText(String.valueOf(ObjModeloUsuario.getNome()));
            JTF_Celular.setText(String.valueOf(ObjModeloUsuario.getTelefone()));
            JCB_Permissão.setSelectedItem(String.valueOf(ObjModeloUsuario.getPermissao()));
            JCB_Sexo.setSelectedItem(String.valueOf(ObjModeloUsuario.getSexo()));
            JTF_Nome_Us.setText(String.valueOf(ObjModeloUsuario.getLogin()));
            JTF_Senha.setText(String.valueOf(ObjModeloUsuario.getSenha()));
            JTF_Senha_Conf.setText(String.valueOf(ObjModeloUsuario.getSenha()));
            JCB_Situacao.setSelectedItem(String.valueOf(ObjModeloUsuario.getSituacao()));
        } catch (SQLException ex) {
        }
    }

public void Conf_Alterar_Usario(){
        Preencher_Obj_Usuario();
        ObjControlUser.Alterar_Usuario(ObjModeloUser,JTF_Cod.getText().trim());
        if (ObjControlUser.Confirma_Alterar == true) 
            {
                Mostrar_Dados_Salvos();
                Limpar_Campos();
                ObjControlUser.Confirma_Alterar=false;
                try {
                    Tela_Consulta_Usuario obj = new Tela_Consulta_Usuario();
                    obj.Open_Tela();
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_Cadastro_Usuario_Edit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                Mostrar_Dados_Nao_Salvos();
                ObjControlUser.Confirma_Alterar=false;
                }
    }



public void Conf_Inativar_Usuario(){
    ObjControlUser.Desativar_Usuario(JTF_Cod.getText().trim());
    
        if(ObjControlUser.Confirma_Inativo == true)
        {
            Mostrar_Dados_Excluidos_Edit();
            ObjControlUser.Confirma_Inativo = false;
            try {
                    Tela_Consulta_Usuario obj = new Tela_Consulta_Usuario();
                    Tela_Principal.getPainel().add(obj);
                    obj.setVisible(true);
                    dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_Cadastro_Usuario_Edit.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else
        {
            Mostrar_Dados_Nao_Excluidos_Edit();
            ObjControlUser.Confirma_Inativo = false;
        }
}

public void Virar_BT_Cancelar(){
    BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar.png")));
    BT_Sair.setMnemonic('c');
    BT_Sair.setToolTipText("Clique Para Cancelar Ou Pressione Alt + C");
    BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar Press.png"))); 
}
 final void Controle_Acesso(){
    if(PermissaoLogado.equalsIgnoreCase("USUÁRIO")){
            BT_Editar.setEnabled(false);
        }else{
            BT_Editar.setEnabled(!false);
        }
    }
 
 public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0),"Editar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
        
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0),"Salvar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap4);
        //método para executar
         this.getRootPane().getActionMap().put("Salvar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Salvar.doClick();
        }
        });
        this.getRootPane().getActionMap().put("Editar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Editar.doClick();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Editar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JComboBox JCB_Permissão;
    private javax.swing.JComboBox JCB_Sexo;
    private javax.swing.JComboBox JCB_Situacao;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Caracteres;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JLabel JL_Senha;
    private javax.swing.JLabel JL_Senha_Conf;
    private javax.swing.JPanel JP_Dados_Pess;
    private javax.swing.JPanel JP_Dados_Us;
    private javax.swing.JFormattedTextField JTF_Celular;
    private javax.swing.JTextField JTF_Cod;
    private javax.swing.JTextField JTF_Nome;
    private javax.swing.JTextField JTF_Nome_Us;
    private javax.swing.JPasswordField JTF_Senha;
    private javax.swing.JPasswordField JTF_Senha_Conf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables


}

package GUI_Frames;

//@author Márison Tamiarana

import Classes.Modelo_Usuario;
import Conexao.Controle_Usuario;
import GUI_Dialogs_Altera_Senha.Conf_Sair_Sem_Salvar_AltSenha;
import GUI_Dialogs_Altera_Senha.Conf_Salvar_AltSenha;
import GUI_Dialogs_Altera_Senha.Inf_Dados_Nao_Salvos_AltSenha;
import GUI_Dialogs_Altera_Senha.Inf_Dados_Salvos_AltSenha;
import GUI_Dialogs_Altera_Senha.Inf_Preencher_Campos_AltSenha;
import GUI_Dialogs_Altera_Senha.Inf_Senha_Atual_Invalida_AltSenha;
import GUI_Dialogs_Altera_Senha.Inf_Senhas_Diferentes_AltSenha;
import GUI_Dialogs_Altera_Senha.Inf_Senhas_Minima_AltSenha;
import GUI_Dialogs_Altera_Senha.Inf_Usuario_Nao_Encontrado_AltSenha;
import Metodos.Formatacao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;


public class Tela_Alterar_Senha extends javax.swing.JInternalFrame {
    
    public static Tela_Alterar_Senha Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Alterar_Senha();
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
    
    Modelo_Usuario ObjModeloUserConsult = new Modelo_Usuario();
    Modelo_Usuario ObjModeloUserInserir = new Modelo_Usuario();
    Controle_Usuario ObjControlUser = new Controle_Usuario();
    Formatacao ObjFormat = new Formatacao();
    
     //Instância de objetos do tipo dialog
    private static Inf_Preencher_Campos_AltSenha ObjPreencherCampos;
    private static Inf_Dados_Salvos_AltSenha ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_AltSenha ObjDadosNaoSalvos;
    private static Inf_Senhas_Diferentes_AltSenha ObjSenhasDiferentes;
    private static Conf_Salvar_AltSenha ObjConfSalvar;
    private static Conf_Sair_Sem_Salvar_AltSenha ObjSairSemSalvar;
    private static Inf_Senhas_Minima_AltSenha ObjSenhaMinima;
    private static Inf_Usuario_Nao_Encontrado_AltSenha ObjUsuarioNaoEncontrado;
    private static Inf_Senha_Atual_Invalida_AltSenha ObjSenhaAtualInvalida;

    public Tela_Alterar_Senha() {
        initComponents();
        
        JTF_Nome_Us.setDocument(ObjFormat.new Format_Geral(50));
        JTF_Senha_Atual.setDocument(ObjFormat.new Format_Campo_Senha(50));
        JTF_Senha.setDocument(ObjFormat.new Format_Campo_Senha(50));
        JTF_Senha_Conf.setDocument(ObjFormat.new Format_Campo_Senha(50));
        Setar_Atalho_BT();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JTF_Nome_Us = new javax.swing.JTextField();
        JL_Senha = new javax.swing.JLabel();
        JTF_Senha = new javax.swing.JPasswordField();
        JL_Senha_Conf = new javax.swing.JLabel();
        JTF_Senha_Conf = new javax.swing.JPasswordField();
        JL_Senha_Atual = new javax.swing.JLabel();
        JTF_Senha_Atual = new javax.swing.JPasswordField();
        BT_Sair = new javax.swing.JButton();
        BT_Salvar = new javax.swing.JButton();
        JL_Campos = new javax.swing.JLabel();
        JL_Caracteres = new javax.swing.JLabel();
        JL_Quant_Itens1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Alterar Senha");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Cadeado 24x24.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nome De Usuário*:");

        JTF_Nome_Us.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Nome_Us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Nome_UsActionPerformed(evt);
            }
        });

        JL_Senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Senha.setText("Nova Senha**:");

        JTF_Senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_SenhaActionPerformed(evt);
            }
        });

        JL_Senha_Conf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Senha_Conf.setText("Repita A Senha**:");

        JTF_Senha_Conf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Senha_Conf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Senha_ConfActionPerformed(evt);
            }
        });

        JL_Senha_Atual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Senha_Atual.setText("Senha Atual**:");

        JTF_Senha_Atual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Senha_Atual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Senha_AtualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(JL_Senha)
                    .addComponent(JL_Senha_Conf)
                    .addComponent(JL_Senha_Atual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_Nome_Us)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTF_Senha_Atual, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(JTF_Senha)
                            .addComponent(JTF_Senha_Conf))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(JTF_Nome_Us, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Senha_Atual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Senha_Atual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Senha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Senha_Conf)
                    .addComponent(JTF_Senha_Conf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        BT_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar.png"))); // NOI18N
        BT_Salvar.setMnemonic('s');
        BT_Salvar.setToolTipText("Clique Para Salvar Ou Pressione Alt + S");
        BT_Salvar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar Press.png"))); // NOI18N
        BT_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SalvarActionPerformed(evt);
            }
        });

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        JL_Caracteres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Caracteres.setText("**Caracteres Permitidos (A-Z, 0-9)");

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Sair | F10 - Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Quant_Itens1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 138, Short.MAX_VALUE)
                                .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JL_Campos)
                                .addGap(18, 18, 18)
                                .addComponent(JL_Caracteres)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Campos)
                    .addComponent(JL_Caracteres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Quant_Itens1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setBounds(20, 20, 504, 306);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Sair_Sem_Salvar();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        Testar_Campos();
        JTF_Nome_Us.requestFocus();
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void JTF_Nome_UsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Nome_UsActionPerformed
        JTF_Senha_Atual.requestFocus();
    }//GEN-LAST:event_JTF_Nome_UsActionPerformed

    private void JTF_Senha_AtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Senha_AtualActionPerformed
        JTF_Senha.requestFocus();
    }//GEN-LAST:event_JTF_Senha_AtualActionPerformed

    private void JTF_SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_SenhaActionPerformed
        JTF_Senha_Conf.requestFocus();
    }//GEN-LAST:event_JTF_SenhaActionPerformed

    private void JTF_Senha_ConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Senha_ConfActionPerformed
        BT_SalvarActionPerformed(evt);
    }//GEN-LAST:event_JTF_Senha_ConfActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    public void Limpar_Campos(){
        JTF_Senha_Atual.setText("");
        JTF_Nome_Us.setText("");
        JTF_Senha.setText("");
        JTF_Senha_Conf.setText("");
    }
    public void Sair_Sem_Salvar() {
        if (   (!JTF_Nome_Us.getText().equalsIgnoreCase(""))
             ||(!new String (JTF_Senha_Atual.getPassword()).equalsIgnoreCase(""))
             ||(!new String (JTF_Senha.getPassword()).equalsIgnoreCase(""))
             ||(!new String (JTF_Senha_Conf.getPassword()).equalsIgnoreCase("")))
        {
            Mostrar_Sair_Sem_Salvar();
        }
        else
        {
            dispose();
        }
    }
    
    public void Testar_Campos() {
        if (   (JTF_Nome_Us.getText().equalsIgnoreCase(""))
             ||(new String (JTF_Senha_Atual.getPassword()).equalsIgnoreCase(""))
             ||(new String (JTF_Senha.getPassword()).equalsIgnoreCase(""))
             ||(new String (JTF_Senha_Conf.getPassword()).equalsIgnoreCase("")))
        {
            Mostrar_Preencher_Campos();
            
        }
        else if (!(new String (JTF_Senha.getPassword())).equals(new String(JTF_Senha_Conf.getPassword()))) 
        {
            JL_Senha.setForeground(Color.red);
            JL_Senha_Conf.setForeground(Color.red);
            Mostrar_Senhas_Diferentes();
        }
        else if ((new String (JTF_Senha.getPassword()).length()<4)&&(new String(JTF_Senha_Conf.getPassword())).length()<4) 
        {
            Mostrar_Senha_Minima();
        }
        else{
            JL_Senha.setForeground(Color.black);
            JL_Senha_Conf.setForeground(Color.black);
            Mostrar_Conf_Salvar();
        }
    }
    
    public void Confirma_Alterar_Senha_Usario(){
        try {
            ObjControlUser.Consulta_Usuario_Senha(ObjModeloUserConsult,JTF_Nome_Us.getText());
            
            if(ObjControlUser.Confirma_Busca == true)
            {                  
                if (ObjModeloUserConsult.getSenha().equals(new String(JTF_Senha_Atual.getPassword()))) 
                    {
                        ObjModeloUserInserir.setSenha(new String(JTF_Senha_Conf.getPassword()));
                        ObjControlUser.Alterar_Senha_Usuario(ObjModeloUserConsult, ObjModeloUserInserir);
                        Mostrar_Dados_Salvos();
                        Limpar_Campos();
                        ObjControlUser.Confirma_Alterar_Senha = false;
                    }
                else{
                    ObjControlUser.Confirma_Alterar_Senha = false;
                    Mostrar_Senha_Atual_Invalida();
                    }
            }
            else
            {
                Mostrar_Usuario_Nao_Encontrado();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Alterar_Senha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_AltSenha(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_AltSenha(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_AltSenha(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    void Mostrar_Senhas_Diferentes(){
        ObjSenhasDiferentes = new Inf_Senhas_Diferentes_AltSenha(this, true);
        ObjSenhasDiferentes.setVisible(true);
    }
    void Mostrar_Conf_Salvar(){
        ObjConfSalvar = new Conf_Salvar_AltSenha(this, true);
        ObjConfSalvar.setVisible(true);        
    }
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_AltSenha(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    void Mostrar_Senha_Minima(){
        ObjSenhaMinima = new Inf_Senhas_Minima_AltSenha(this, true);
        ObjSenhaMinima.setVisible(true);
    }     
    void Mostrar_Senha_Atual_Invalida(){
        ObjSenhaAtualInvalida = new Inf_Senha_Atual_Invalida_AltSenha(this, true);
        ObjSenhaAtualInvalida.setVisible(true);
    } 
    void Mostrar_Usuario_Nao_Encontrado(){
        ObjUsuarioNaoEncontrado = new Inf_Usuario_Nao_Encontrado_AltSenha(this, true);
        ObjUsuarioNaoEncontrado.setVisible(true);
    } 
    
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
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
        this.getRootPane().getActionMap().put("Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Sair.doClick();
        }
        });               
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Caracteres;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JLabel JL_Senha;
    private javax.swing.JLabel JL_Senha_Atual;
    private javax.swing.JLabel JL_Senha_Conf;
    private javax.swing.JTextField JTF_Nome_Us;
    private javax.swing.JPasswordField JTF_Senha;
    private javax.swing.JPasswordField JTF_Senha_Atual;
    private javax.swing.JPasswordField JTF_Senha_Conf;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

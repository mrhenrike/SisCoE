package GUI_Frames;

import Classes.Modelo_Tabela;
import Classes.Modelo_Usuario;
import Conexao.Conecta_Banco;
import Conexao.Controle_Log;
import Conexao.Controle_Usuario;
import GUI_Dialogs_Log.Inf_Data_Final_Inferior_Cons_Log;
import GUI_Dialogs_Log.Inf_Log_Nao_Encontrado;
import GUI_Dialogs_Log.Inf_Preencher_Datas_Cons_Log;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.FontUIResource;


// @author Márison Tamiarana

public class Tela_Consulta_Log extends javax.swing.JInternalFrame {
    
     public static Tela_Consulta_Log Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            
            Obj = new Tela_Consulta_Log();
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
    Modelo_Usuario ObjModUsuario = new Modelo_Usuario();
    Controle_Usuario ObjControleUsuario = new Controle_Usuario();
    Controle_Log ObjControleLog = new Controle_Log();
    Formatacao ObjFormat = new Formatacao();
    //Dialogs
    private static Inf_Log_Nao_Encontrado DLLogNaoEncontrado;
    private static Inf_Data_Final_Inferior_Cons_Log DLDataFinalInferior;
    private static Inf_Preencher_Datas_Cons_Log DLPreencherDatas;
    
    boolean DataMenor;//comparar datas
    
    public Tela_Consulta_Log() {
        initComponents();
        Preencher_CB_Tipo();
        Desabilita_Filtro();
        Desabilita_Periodo();
        BT_Consultar.setEnabled(false);
        Setar_Atalho_BT();
        JTF_Pesquisa.setDocument(ObjFormat.new Format_Geral(50));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JCB_Tipo_Pesquisa = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Consulta_Log = new javax.swing.JTable();
        BT_Sair = new javax.swing.JButton();
        JL_Periodo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JD_Inicial = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        JD_Final = new com.toedter.calendar.JDateChooser();
        BT_Consultar = new javax.swing.JButton();
        JL_Filtro = new javax.swing.JPanel();
        JTF_Pesquisa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JL_Registros = new javax.swing.JLabel();
        JL_Quant_Itens1 = new javax.swing.JLabel();
        BT_Relatorio = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Consulta Log");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Log 24x24.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Tipo De Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JCB_Tipo_Pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Tipo_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_Tipo_PesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCB_Tipo_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(JCB_Tipo_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTB_Consulta_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Consulta_Log.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Consulta_Log.setToolTipText("Clique Duas Vezes Em Uma Linha Para Mais Informações");
        JTB_Consulta_Log.getTableHeader().setReorderingAllowed(false);
        JTB_Consulta_Log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_Consulta_LogMouseClicked(evt);
            }
        });
        JTB_Consulta_Log.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTB_Consulta_LogKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Consulta_Log);

        BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sair.png"))); // NOI18N
        BT_Sair.setMnemonic('r');
        BT_Sair.setToolTipText("Clique Para Sair Ou Pressione Alt + R");
        BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Sair press.png"))); // NOI18N
        BT_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SairActionPerformed(evt);
            }
        });

        JL_Periodo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Período", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("De:");

        JD_Inicial.setToolTipText("Selecione A Data Inicial");
        JD_Inicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Até:");

        JD_Final.setToolTipText("Selecione A Data Final");
        JD_Final.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout JL_PeriodoLayout = new javax.swing.GroupLayout(JL_Periodo);
        JL_Periodo.setLayout(JL_PeriodoLayout);
        JL_PeriodoLayout.setHorizontalGroup(
            JL_PeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JL_PeriodoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(JD_Inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JD_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JL_PeriodoLayout.setVerticalGroup(
            JL_PeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JL_PeriodoLayout.createSequentialGroup()
                .addGroup(JL_PeriodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JD_Inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(JD_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BT_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar.png"))); // NOI18N
        BT_Consultar.setToolTipText("Clique Para Pesquisar O Tipo Da Saída");
        BT_Consultar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Consultar Press.png"))); // NOI18N
        BT_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ConsultarActionPerformed(evt);
            }
        });

        JL_Filtro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTF_Pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Pesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_PesquisaFocusGained(evt);
            }
        });

        javax.swing.GroupLayout JL_FiltroLayout = new javax.swing.GroupLayout(JL_Filtro);
        JL_Filtro.setLayout(JL_FiltroLayout);
        JL_FiltroLayout.setHorizontalGroup(
            JL_FiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JL_FiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTF_Pesquisa)
                .addContainerGap())
        );
        JL_FiltroLayout.setVerticalGroup(
            JL_FiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JL_FiltroLayout.createSequentialGroup()
                .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Registros:");

        JL_Registros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Sair | F3 - Consultar | F11 - Relatório");

        BT_Relatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Relatorio.png"))); // NOI18N
        BT_Relatorio.setMnemonic('t');
        BT_Relatorio.setToolTipText("Clique Para Exibir O Relatório Ou Pressione Alt + T");
        BT_Relatorio.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Relatorio Press.png"))); // NOI18N
        BT_Relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_RelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JL_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JL_Filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BT_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JL_Registros, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JL_Quant_Itens1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JL_Periodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(JL_Filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(BT_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BT_Sair)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Quant_Itens1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_Registros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(BT_Relatorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(0, 0, 1090, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void JTB_Consulta_LogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Consulta_LogMouseClicked
         try {
            if (evt.getClickCount() == 2) {
                Object data = (JTB_Consulta_Log.getValueAt(JTB_Consulta_Log.getSelectedRow(), 0));
                Object hora = (JTB_Consulta_Log.getValueAt(JTB_Consulta_Log.getSelectedRow(), 1));
                Object acao = (JTB_Consulta_Log.getValueAt(JTB_Consulta_Log.getSelectedRow(), 2));
                Object usuario = (JTB_Consulta_Log.getValueAt(JTB_Consulta_Log.getSelectedRow(), 3));
                //formatando o JOptionPane
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", Font.TRUETYPE_FONT, 14)));
                JOptionPane.showMessageDialog(rootPane, "Data: "+data +"    Hora: "+hora
                +"\n\nDescrição: "+acao
                +"\n\nUsuário Logado: "+usuario,"Descrição Do Log",JOptionPane.INFORMATION_MESSAGE);                
            }
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_JTB_Consulta_LogMouseClicked

    private void JTB_Consulta_LogKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTB_Consulta_LogKeyPressed
        try {
            int linha_selecionada = JTB_Consulta_Log.getSelectedRow();
            if (linha_selecionada >= 0)
            {
                if((evt.getKeyChar()==KeyEvent.VK_ENTER)){
                    Object data = (JTB_Consulta_Log.getValueAt(JTB_Consulta_Log.getSelectedRow(), 0));
                    Object hora = (JTB_Consulta_Log.getValueAt(JTB_Consulta_Log.getSelectedRow(), 1));
                    Object acao = (JTB_Consulta_Log.getValueAt(JTB_Consulta_Log.getSelectedRow(), 2));
                    Object usuario = (JTB_Consulta_Log.getValueAt(JTB_Consulta_Log.getSelectedRow(), 3));
                    //formatando o JOptionPane
                    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", Font.TRUETYPE_FONT, 14)));
                    JOptionPane.showMessageDialog(rootPane, "Data: "+data +"    Hora: "+hora
                    +"\nDescrição: "+acao
                    +"\nUsuário Logado: "+usuario,"Descrição Do Log",JOptionPane.INFORMATION_MESSAGE);  
                }
            }
        }catch(Exception ex){}
    }//GEN-LAST:event_JTB_Consulta_LogKeyPressed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConsultarActionPerformed
        Testar_Campos();
    }//GEN-LAST:event_BT_ConsultarActionPerformed

    private void JTF_PesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_PesquisaFocusGained
        Pesquisar();
    }//GEN-LAST:event_JTF_PesquisaFocusGained

    private void JCB_Tipo_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_Tipo_PesquisaActionPerformed
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==0){
            Limpar_Tabela();
            Desabilita_Filtro();
            Desabilita_Periodo();
            BT_Consultar.setEnabled(false);
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==1){
            Limpar_Tabela();
            Habilita_Filtro();
            Desabilita_Periodo();
            BT_Consultar.setEnabled(true);            
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==2){
            Limpar_Tabela();
            Habilita_Filtro();
            Habilita_Periodo();
            BT_Consultar.setEnabled(true);            
        }

    
    }//GEN-LAST:event_JCB_Tipo_PesquisaActionPerformed

    private void BT_RelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_RelatorioActionPerformed
        
    }//GEN-LAST:event_BT_RelatorioActionPerformed
      
    public void Pesquisar() {

        JTF_Pesquisa.getDocument().addDocumentListener(new DocumentListener() {
            //ATUALIZA A CADA LETRA REMOVIDA=============================
            @Override
            public void removeUpdate(DocumentEvent e) {
                Filtrar();                
            }
            //ATUALIZA A CADA LETRA INSERIDA==============================
            @Override
            public void insertUpdate(DocumentEvent e) {               
                Filtrar();
            }
            //ATUALIZA A CADA LETRA ATUALIZADA OU TROCADA=================
            @Override
            public void changedUpdate(DocumentEvent e) {
                Filtrar();
            }
        });
    }
    
    public void Filtrar() {
        if(JCB_Tipo_Pesquisa.getSelectedIndex()== 1){
            String hoje = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
            Preencher_Tabela("select * from log_sistema where acao like '%"    
                + JTF_Pesquisa.getText().toUpperCase() + "%' and data ='"+hoje+"'");
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()== 2){
            String di = new SimpleDateFormat("yyyy-MM-dd").format(JD_Inicial.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(JD_Final.getDate());
            Preencher_Tabela("select * from log_sistema where acao like '%"    
                + JTF_Pesquisa.getText().toUpperCase() + "%' and data between '"+di+"' and '"+df+"'");
        }
    }
    public void Verifica_Datas(){//verifica se a data inicial é inferior a inicial
        long dt1 = JD_Inicial.getDate().getTime();
        long dt2 = JD_Final.getDate().getTime();
        if (dt2==dt1) {
            DataMenor=!true;
        } else {    
            if (dt2 > dt1) {
                DataMenor=!true;
            } else {
                DataMenor=true;
            }
        }  
    }
    
    final void Preencher_CB_Tipo(){
        JCB_Tipo_Pesquisa.removeAllItems();
        JCB_Tipo_Pesquisa.addItem("");
        JCB_Tipo_Pesquisa.addItem("HOJE");
        JCB_Tipo_Pesquisa.addItem("PERÍODO");
    }
    void Habilita_Periodo(){
        jLabel1.setEnabled(true);
        jLabel2.setEnabled(true);
        JL_Periodo.setEnabled(true);
        JD_Final.setEnabled(true);
        JD_Inicial.setEnabled(true);
        JD_Final.setDate(null);
        JD_Inicial.setDate(null);
    }
    final void Desabilita_Periodo(){
        jLabel1.setEnabled(!true);
        jLabel2.setEnabled(!true);
        JL_Periodo.setEnabled(!true);
        JD_Final.setEnabled(!true);
        JD_Inicial.setEnabled(!true);
        JD_Final.setDate(null);
        JD_Inicial.setDate(null);
    }
    void Habilita_Filtro(){
        JL_Filtro.setEnabled(true);
        JTF_Pesquisa.setEnabled(true);
        JTF_Pesquisa.setText("");
    }
    final void Desabilita_Filtro(){
        JL_Filtro.setEnabled(!true);
        JTF_Pesquisa.setEnabled(!true);
        JTF_Pesquisa.setText("");
    }
    
    void Testar_Campos(){
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==0){
            BT_Consultar.setEnabled(false);
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==1){
            String hoje = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
            Preencher_Tabela("select * from log_sistema where acao like '%"    
                    + JTF_Pesquisa.getText().toUpperCase() + "%' and data ='"+hoje+"'");
            JL_Registros.setText(String.valueOf(JTB_Consulta_Log.getRowCount()));
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==2){
            BT_Consultar.setEnabled(true);
            if(JD_Inicial.getDate()==null || JD_Final.getDate()==null){
                    Mostrar_Preencher_Data();
            }else{
                Verifica_Datas();
                if (DataMenor == true) {
                    Mostrar_Data_Inferior();
                    DataMenor = false;
                } else {
                    try {
                        ObjControleLog.Consulta_Log_Intervalo(JD_Inicial, JD_Final);
                        if (ObjControleLog.controla_log == true) {
                            String di = new SimpleDateFormat("yyyy-MM-dd").format(JD_Inicial.getDate());
                            String df = new SimpleDateFormat("yyyy-MM-dd").format(JD_Final.getDate());
                            Preencher_Tabela("select * from log_sistema where data between '" + di + "' and '" + df + "'");
                            ObjControleLog.controla_log = false;
                            JL_Registros.setText(String.valueOf(JTB_Consulta_Log.getRowCount()));
                        } else {
                            Mostrar_Log_Nao_Encontrado();
                        }
                    } catch (Exception ex) {
                    }
                }
            }
        }

    }
    
    public final void Preencher_Tabela(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Data","Hora","Descrição","Usuário","Registro"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();           
            do {           
                
                ObjControleUsuario.Consulta_Usuario_Nome(ObjModUsuario, ObjConecta.rs.getInt("usuario_id_usuario"));
                Date validade = ObjConecta.rs.getDate("data");
                String data= "";
                if(validade != null){data = String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta.rs.getDate("data")));}
                
                dados.add(new Object[]{data,ObjConecta.rs.getString("hora"),
                ObjConecta.rs.getString("acao"),ObjModUsuario.getNome(),ObjConecta.rs.getInt("id_log_sistema")});
            } while (ObjConecta.rs.next());
            
            ObjConecta.Desconecta();
        } catch (SQLException ex) {}
        
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Consulta_Log.setModel(tabela);
        JTB_Consulta_Log.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());//Pintar tabela
        JTB_Consulta_Log.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Consulta_Log.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Consulta_Log.getColumnModel().getColumn(1).setPreferredWidth(80);
        JTB_Consulta_Log.getColumnModel().getColumn(1).setResizable(false);
        JTB_Consulta_Log.getColumnModel().getColumn(2).setPreferredWidth(800);
        JTB_Consulta_Log.getColumnModel().getColumn(2).setResizable(false);
        JTB_Consulta_Log.getColumnModel().getColumn(3).setPreferredWidth(300);
        JTB_Consulta_Log.getColumnModel().getColumn(3).setResizable(false);
        JTB_Consulta_Log.getColumnModel().getColumn(4).setPreferredWidth(80);
        JTB_Consulta_Log.getColumnModel().getColumn(4).setResizable(false);
        JTB_Consulta_Log.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Consulta_Log.setAutoResizeMode(JTB_Consulta_Log.AUTO_RESIZE_OFF);//Tabela Redimensionavel(Todas colunas)
        JTB_Consulta_Log.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
    }
    public final void Limpar_Tabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{};//Seta os indices da tabela
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Consulta_Log.setModel(tabela);
    }
    
    void Mostrar_Data_Inferior(){
        DLDataFinalInferior = new Inf_Data_Final_Inferior_Cons_Log(this, true);
        DLDataFinalInferior.setVisible(true);
    }
    void Mostrar_Log_Nao_Encontrado(){
        DLLogNaoEncontrado = new Inf_Log_Nao_Encontrado(this, true);
        DLLogNaoEncontrado.setVisible(true);
    }
    void Mostrar_Preencher_Data(){
        DLPreencherDatas = new Inf_Preencher_Datas_Cons_Log(this, true);
        DLPreencherDatas.setVisible(true);
    }
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap3 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0),"Relatorio");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);
        
        InputMap inputMap4 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap4.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),"Consultar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap4);
                
        //método para executar
         this.getRootPane().getActionMap().put("Consultar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Consultar.doClick();
        }
        });        
        this.getRootPane().getActionMap().put("Esc", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Sair.doClick();
        }
        }); 
        this.getRootPane().getActionMap().put("Relatorio", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Relatorio.doClick();
        }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Consultar;
    private javax.swing.JButton BT_Relatorio;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JComboBox JCB_Tipo_Pesquisa;
    private com.toedter.calendar.JDateChooser JD_Final;
    private com.toedter.calendar.JDateChooser JD_Inicial;
    private javax.swing.JPanel JL_Filtro;
    private javax.swing.JPanel JL_Periodo;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JLabel JL_Registros;
    private javax.swing.JTable JTB_Consulta_Log;
    private javax.swing.JTextField JTF_Pesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

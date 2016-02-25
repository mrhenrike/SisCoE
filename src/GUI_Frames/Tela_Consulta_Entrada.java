package GUI_Frames;

import Classes.Modelo_Tabela;
import Conexao.Conecta_Banco;
import Conexao.Controle_Entrada_Produto;
import Conexao.Controle_Relatorio_Entradas;
import GUI_Dialogs_Consulta_Ent_Saida.Inf_Data_Final_Inferior_Cons_Ent;
import GUI_Dialogs_Consulta_Ent_Saida.Inf_Entrada_Nao_Encontrada;
import GUI_Dialogs_Consulta_Ent_Saida.Inf_Nao_Existe_Entrada;
import GUI_Dialogs_Consulta_Ent_Saida.Inf_Preencher_Datas_Cons_Ent;
import GUI_Dialogs_Consulta_Ent_Saida.Inf_Preencher_N_Entrada_Cons_Ent;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

// @author Márison Tamiarana

public class Tela_Consulta_Entrada extends javax.swing.JInternalFrame {
    
    public static Tela_Consulta_Entrada Obj;
          
    
    Tela_Principal ObjTP = new Tela_Principal();
   
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Consulta_Entrada();
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
    
    public static Tela_Consulta_Entrada Objteste;
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Conecta_Banco ObjConecta_2 = new Conecta_Banco();
    Controle_Relatorio_Entradas ObjRelatEntrada = new Controle_Relatorio_Entradas();
    Controle_Entrada_Produto ObjControleEntrada = new Controle_Entrada_Produto();
    Formatacao ObjFormat = new Formatacao();
    
    boolean teste;
    boolean DataMenor=false;
    int Controle=0;
    
    private static Inf_Data_Final_Inferior_Cons_Ent ObjDataInferior;
    private static Inf_Preencher_N_Entrada_Cons_Ent ObjPreencherEntrada;
    private static Inf_Preencher_Datas_Cons_Ent ObjPreencherDatas;
    private static Inf_Entrada_Nao_Encontrada ObjEntNaoEncontrada;
    private static Inf_Nao_Existe_Entrada ObjNaoExisteEnt;
    
    
    public Tela_Consulta_Entrada() {
        initComponents();
        JTF_Num_Entrada.setDocument(ObjFormat.new Format_Apenas_Numero(50));
        Preencher_CB_Pesquisa();    
        BT_Relatorio.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JD_Inicial = new com.toedter.calendar.JDateChooser();
        JD_Final = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JCB_Tipo_Pesquisa = new javax.swing.JComboBox();
        BT_Consultar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JTF_Num_Entrada = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Itens_Entrada = new javax.swing.JTable();
        BT_Sair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTB_Entradas = new javax.swing.JTable();
        BT_Relatorio = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Consulta De Entrada");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Relatorio - Entrada 24x24.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1000, 560));
        setMinimumSize(new java.awt.Dimension(1000, 560));
        setPreferredSize(new java.awt.Dimension(1000, 560));
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

        JD_Inicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JD_Final.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("De:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Até:");

        JCB_Tipo_Pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Tipo_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_Tipo_PesquisaActionPerformed(evt);
            }
        });

        BT_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Search_24x24.png"))); // NOI18N
        BT_Consultar.setToolTipText("Clique Para Pesquisar Um Produto");
        BT_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ConsultarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nº Entrada:");

        JTF_Num_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Num_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_Num_EntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JCB_Tipo_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JD_Final, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JD_Inicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTF_Num_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BT_Consultar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JCB_Tipo_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JD_Inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(JD_Final, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(JTF_Num_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BT_Consultar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Itens Da Entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTB_Itens_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Itens_Entrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Itens_Entrada.getTableHeader().setReorderingAllowed(false);
        JTB_Itens_Entrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_Itens_EntradaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Itens_Entrada);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Entradas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTB_Entradas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Entradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Entradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_EntradasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTB_Entradas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2)
                .addGap(1, 1, 1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BT_Relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(BT_Relatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(0, 0, 1000, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void JTB_EntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_EntradasMouseClicked
         try {
             int Sel_Curso = JTB_Entradas.getSelectedRow();
                if (Sel_Curso >= 0) {
                Object resultado = JTB_Entradas.getValueAt(JTB_Entradas.getSelectedRow(), 0);
                Preencher_Tabela_Itens_Entrada("select * from entrada inner join entrada_itens "
                        + "on entrada.id_entrada=entrada_itens.entrada_id_entrada inner join produto "
                        + "on produto.id_produto=entrada_itens.produto_id_produto where entrada_itens.entrada_id_entrada="+resultado+"");
                } 
        } catch (HeadlessException ex) {

        }
         try {
            if (evt.getClickCount() == 2) {
                Object Descricao = JTB_Entradas.getValueAt(JTB_Entradas.getSelectedRow(), 2);
                Object Data = JTB_Entradas.getValueAt(JTB_Entradas.getSelectedRow(), 1);
                Object Num_Entrada = JTB_Entradas.getValueAt(JTB_Entradas.getSelectedRow(), 0);
                JOptionPane.showMessageDialog(rootPane,"Entrada: "+ Num_Entrada+"   Data:"+Data+
                        "\nDescrição: "+Descricao,"Descrição Da Entrada",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException ex) {
    }
    }//GEN-LAST:event_JTB_EntradasMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JTB_Itens_EntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_Itens_EntradaMouseClicked
//        try {
//            if (evt.getClickCount() == 2) {
//
//                Object resultado = (JTB_Itens_Entrada.getValueAt(JTB_Itens_Entrada.getSelectedRow(), 0));
//                Tela_Cadastro_Prod_Edit obj = new Tela_Cadastro_Prod_Edit();
//                Tela_Principal.getPainel().add(obj);
//                obj.setVisible(true);
//                obj.setPosicao();
//                obj.Carregar_Dados_Produtos(resultado);
//                obj.Obj = new Tela_Cadastro_Prod_Edit();
//                Objteste = new Tela_Consulta_Entrada();
//                dispose();
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Tela_Consulta_Produto.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_JTB_Itens_EntradaMouseClicked

    private void BT_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConsultarActionPerformed
        Testar_Campos();
    }//GEN-LAST:event_BT_ConsultarActionPerformed

    private void JCB_Tipo_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_Tipo_PesquisaActionPerformed
       if(JCB_Tipo_Pesquisa.getSelectedIndex()==0){
            BT_Consultar.setEnabled(false);
            JD_Final.setEnabled(false);
            JD_Inicial.setEnabled(false);
            JD_Final.setDate(null);
            JD_Inicial.setDate(null);
            Limpar_Tabela_Entrada();
            Limpar_Tabela_Entrada_Itens();
            JTF_Num_Entrada.setEnabled(false);
            JTF_Num_Entrada.setText("");
            Controle=0;
            BT_Relatorio.setEnabled(false);
        }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==1){
            BT_Consultar.setEnabled(!false);
            JD_Final.setEnabled(false);
            JD_Inicial.setEnabled(false);
            JD_Final.setDate(null);
            JD_Inicial.setDate(null);
            Limpar_Tabela_Entrada();
            Limpar_Tabela_Entrada_Itens();
            JTF_Num_Entrada.setEnabled(false);
            JTF_Num_Entrada.setText("");
            Controle=0;
            BT_Relatorio.setEnabled(false);
         }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==2){
            BT_Consultar.setEnabled(!false);
            JD_Final.setEnabled(false);
            JD_Inicial.setEnabled(false);
            JD_Final.setDate(null);
            JD_Inicial.setDate(null);
            Limpar_Tabela_Entrada();
            Limpar_Tabela_Entrada_Itens();
            JTF_Num_Entrada.setEnabled(false);
            JTF_Num_Entrada.setText("");
            Controle=0;
            BT_Relatorio.setEnabled(false);
         }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==3){
            BT_Consultar.setEnabled(!false);
            JD_Final.setEnabled(!false);
            JD_Inicial.setEnabled(!false);
            JD_Final.setDate(null);
            JD_Inicial.setDate(null);
            Limpar_Tabela_Entrada();
            Limpar_Tabela_Entrada_Itens();
            JTF_Num_Entrada.setEnabled(false);
            JTF_Num_Entrada.setText("");
            Controle=0;
            BT_Relatorio.setEnabled(false);
         }
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==4){
            BT_Consultar.setEnabled(!false);
            JD_Final.setEnabled(false);
            JD_Inicial.setEnabled(false);
            JD_Final.setDate(null);
            JD_Inicial.setDate(null);
            Limpar_Tabela_Entrada();
            Limpar_Tabela_Entrada_Itens();
            JTF_Num_Entrada.setEnabled(!false);
            JTF_Num_Entrada.setText("");
            Controle=0;
            BT_Relatorio.setEnabled(false);
         }
    }//GEN-LAST:event_JCB_Tipo_PesquisaActionPerformed

    private void JTF_Num_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_Num_EntradaActionPerformed
        Testar_Campos();
    }//GEN-LAST:event_JTF_Num_EntradaActionPerformed

    private void BT_RelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_RelatorioActionPerformed
        if(Controle==0){}
        if(Controle==1){ObjRelatEntrada.Relatorio_Entrada_Prod_Todos();}
        if(Controle==2){ObjRelatEntrada.Relatorio_Entrada_Prod_Ultimos_30_Dias();}
        if(Controle==3){ObjRelatEntrada.Relatorio_Entrada_Periodo(JD_Inicial, JD_Final);}
        if(Controle==4){ObjRelatEntrada.Relatorio_Entrada_N_Entrada(JTF_Num_Entrada);}
    }//GEN-LAST:event_BT_RelatorioActionPerformed

    public void Testar_Campos(){
        Limpar_Tabela_Entrada();
        Limpar_Tabela_Entrada_Itens();
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==1){
            ObjControleEntrada.Consulta_Entrada_Todas();
            if(ObjControleEntrada.Controle_Entrada == true){
                Preencher_Tabela_Entrada("select * from entrada");
                Controle=1;
                BT_Relatorio.setEnabled(!false);
                    ObjControleEntrada.Controle_Entrada=false;
                }else{
                    Mostra_Nao_Existe_Entrada();
                    Limpar_Tabela_Entrada();
                    Limpar_Tabela_Entrada_Itens();
                    Controle=0;
                    BT_Relatorio.setEnabled(false);
                }
        }

        if(JCB_Tipo_Pesquisa.getSelectedIndex()==2){
            
            ObjControleEntrada.Consulta_Entrada_Todas();
            if(ObjControleEntrada.Controle_Entrada == true){
                try{
                    Calendar c = Calendar.getInstance();
                    c.add(Calendar.MONTH, -1); //diminuir datas - inicio para 30 dias;
                    String df = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                    String di = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
                    Preencher_Tabela_Entrada("select * from entrada where data_entrada between '"+di+"' and '"+df+"'");
                    Controle = 2;
                    BT_Relatorio.setEnabled(!false);
                }catch(Exception  ex){}
                
                    ObjControleEntrada.Controle_Entrada=false;
            }else{
                Mostra_Nao_Existe_Entrada();
                Limpar_Tabela_Entrada();
                Limpar_Tabela_Entrada_Itens();
                Controle=0;
                BT_Relatorio.setEnabled(false);
            }
        }
        
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==3){
            if(JD_Inicial.getDate()==null || JD_Final.getDate()==null){
                Mostrar_Preencher_Datas();
            }else{
                Verifica_Datas();
                if(DataMenor == true){
                    Mostrar_Data_Inferior();
                    DataMenor = false;
                }else{
                    ObjControleEntrada.Consulta_Entrada_Todas();
                    if (ObjControleEntrada.Controle_Entrada == true) {
                        try{
                            String di = new SimpleDateFormat("yyyy-MM-dd").format(JD_Inicial.getDate());
                            String df = new SimpleDateFormat("yyyy-MM-dd").format(JD_Final.getDate());
                            Preencher_Tabela_Entrada("select * from entrada where data_entrada between '"+di+"' and '"+df+"'");
                            Controle = 3;
                            BT_Relatorio.setEnabled(!false);
                            }catch(Exception ex){}
                            ObjControleEntrada.Controle_Entrada = false;
                    } else {
                        Mostra_Nao_Existe_Entrada();
                        Limpar_Tabela_Entrada();
                        Limpar_Tabela_Entrada_Itens();
                        Controle = 0;
                        BT_Relatorio.setEnabled(false);
                    }
                }
            }
        }
        
        if(JCB_Tipo_Pesquisa.getSelectedIndex()==4){
             if(JTF_Num_Entrada.getText().equalsIgnoreCase("")){
                Mostrar_Preencher_N_Entrada();
                Controle=0;
                BT_Relatorio.setEnabled(false);
             }else{
                ObjControleEntrada.Consulta_Entrada_Id(Integer.parseInt(JTF_Num_Entrada.getText()));
                if(ObjControleEntrada.Controle_Entrada == true){
                    Preencher_Tabela_Entrada("select * from entrada where id_entrada="+JTF_Num_Entrada.getText().trim()+"");
                 Controle=4;
                 BT_Relatorio.setEnabled(!false);
                    ObjControleEntrada.Controle_Entrada=false;
                }else{
                    Mostrar_Entrada_Nao_Encontrada();
                    Limpar_Tabela_Entrada();
                    Limpar_Tabela_Entrada_Itens();
                    Controle = 0;
                    BT_Relatorio.setEnabled(false);
                }
            }
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
    
    public final void Preencher_CB_Pesquisa(){
        JCB_Tipo_Pesquisa.removeAllItems();
        JCB_Tipo_Pesquisa.addItem(" ");
        JCB_Tipo_Pesquisa.addItem("TODOS");
        JCB_Tipo_Pesquisa.addItem("ÚLTIMOS 30 DIAS");
        JCB_Tipo_Pesquisa.addItem("POR PERÍODO");
        JCB_Tipo_Pesquisa.addItem("NÚMERO DA ENTRADA");
    }
    
    public final void Preencher_Tabela_Entrada(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Nº Entrada", "Data Entrada", "Descrição"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        try {
            ObjConecta.rs.first();           
            do {                
               String data_Entrada = String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta.rs.getDate("data_entrada")));
                
                dados.add(new Object[]{ObjConecta.rs.getInt("id_entrada"), data_Entrada, ObjConecta.rs.getString("descricao_entrada") });
            
            } while (ObjConecta.rs.next());
            
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Entradas.setModel(tabela);
        JTB_Entradas.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Entradas.getColumnModel().getColumn(0).setPreferredWidth(100);//Tamanho da coluna
        JTB_Entradas.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel        
        JTB_Entradas.getColumnModel().getColumn(1).setPreferredWidth(100);
        JTB_Entradas.getColumnModel().getColumn(1).setResizable(false);
        JTB_Entradas.getColumnModel().getColumn(2).setPreferredWidth(500);
        JTB_Entradas.getColumnModel().getColumn(2).setResizable(false);
        JTB_Entradas.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Entradas.setAutoResizeMode(JTB_Entradas.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Todas colunas)
        JTB_Entradas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
    }
    
    public final void Preencher_Tabela_Itens_Entrada(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Descrição","Quantidade","Lote","Validade", "Preço"};//Seta os indices da tabela
        ObjConecta_2.Conectar();
        ObjConecta_2.ExecutaSQL(SQL);
        try {
            ObjConecta_2.rs.first();
           
            do {
                String lote = ObjConecta_2.rs.getString("lote");
                Date validade = ObjConecta_2.rs.getDate("data_validade");
                String data_val= "";
                if((lote == null)||(lote.equalsIgnoreCase("null"))) {lote = "";}
                if(validade != null){data_val = String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta_2.rs.getDate("data_validade")));}
                
                dados.add(new Object[]{ObjConecta_2.rs.getInt("produto_id_produto"),ObjConecta_2.rs.getString("produto.descricao"),
                ObjConecta_2.rs.getDouble("quantidade"), lote, data_val, ObjConecta_2.rs.getDouble("preco")});
            } while (ObjConecta_2.rs.next());
            ObjConecta_2.Desconecta();
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens_Entrada.setModel(tabela);
        JTB_Itens_Entrada.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Itens_Entrada.getColumnModel().getColumn(0).setPreferredWidth(100);//Tamanho da coluna
        JTB_Itens_Entrada.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Itens_Entrada.getColumnModel().getColumn(1).setPreferredWidth(300);
        JTB_Itens_Entrada.getColumnModel().getColumn(1).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(2).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(3).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(3).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(4).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(5).setResizable(false);
        JTB_Itens_Entrada.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Itens_Entrada.setAutoResizeMode(JTB_Itens_Entrada.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(todas colunas)
        JTB_Itens_Entrada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
      
    }
    
    public final void Limpar_Tabela_Entrada() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{};//Seta os indices da tabela
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Entradas.setModel(tabela);
    }
     public final void Limpar_Tabela_Entrada_Itens() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{};//Seta os indices da tabela
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens_Entrada.setModel(tabela);
    }
     
    public void Mostrar_Preencher_Datas(){
        ObjPreencherDatas = new Inf_Preencher_Datas_Cons_Ent(this, true);
        ObjPreencherDatas.setVisible(true);
    }
    public void Mostrar_Data_Inferior(){
        ObjDataInferior = new Inf_Data_Final_Inferior_Cons_Ent(this, true);
        ObjDataInferior.setVisible(true);
    }
    public void Mostrar_Preencher_N_Entrada(){
        ObjPreencherEntrada = new Inf_Preencher_N_Entrada_Cons_Ent(this, true);
        ObjPreencherEntrada.setVisible(true);
    }
    void Mostra_Nao_Existe_Entrada(){
        ObjNaoExisteEnt = new Inf_Nao_Existe_Entrada(this, true);
        ObjNaoExisteEnt.setVisible(true);
    }
    void Mostrar_Entrada_Nao_Encontrada(){
        ObjEntNaoEncontrada = new Inf_Entrada_Nao_Encontrada(this, true);
        ObjEntNaoEncontrada.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Consultar;
    private javax.swing.JButton BT_Relatorio;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JComboBox JCB_Tipo_Pesquisa;
    private com.toedter.calendar.JDateChooser JD_Final;
    private com.toedter.calendar.JDateChooser JD_Inicial;
    private javax.swing.JTable JTB_Entradas;
    private javax.swing.JTable JTB_Itens_Entrada;
    private javax.swing.JTextField JTF_Num_Entrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
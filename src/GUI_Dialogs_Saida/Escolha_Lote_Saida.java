package GUI_Dialogs_Saida;

// @author Márison Tamiarana

import Classes.Modelo_Lote_Estoque;
import Classes.Modelo_Produto;
import Classes.Modelo_Tabela;
import Conexao.Conecta_Banco;
import Conexao.Controle_Saida_Produto;
import GUI_Frames.Tela_Saida_Produto;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;


public class Escolha_Lote_Saida extends javax.swing.JDialog {
    
    public static Tela_Saida_Produto ObjSaida;
    public static Conf_Alterar_Quant_Lote_Saida ObjAlterarQuant;
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Modelo_Lote_Estoque ObjModeloLote = new Modelo_Lote_Estoque();
    Modelo_Produto ObjModeloProd = new Modelo_Produto();
    Controle_Saida_Produto ObjControlSaida = new Controle_Saida_Produto();
    Formatacao ObjFormat = new Formatacao();
    Object IdProd;
    
    public double QuantDisponivel= 0;
    String data;//variavel para receber a data atual para comparar a validade
        
    public Escolha_Lote_Saida(Tela_Saida_Produto parent, boolean modal, Object id) {
        this.ObjSaida = parent;
        this.setModal(modal);
        this.IdProd = id;
        initComponents();
        setResizable(false);
        setSize(330,310);
        setLocationRelativeTo(ObjSaida);
        JTF_Quantidade.setDocument(ObjFormat.new Format_Apenas_Numero(10));
        
        data = new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis()));
        Preencher_Tabela_Lote_Estoque("select * from lote_estoque where quantidade_estoque > 0 "
                + " and data_validade_lote>='"+data+"' and produto_id_produto="+id+"");
       
    }

    private Escolha_Lote_Saida(Tela_Saida_Produto ObjSaida, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JB_Ok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BT_Sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Lote = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        JTF_Quantidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informação!");
        setMinimumSize(new java.awt.Dimension(280, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Selecione o lote e a quantidade");

        JB_Ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Ok.png"))); // NOI18N
        JB_Ok.setMnemonic('o');
        JB_Ok.setToolTipText("Ok (Alt+O)");
        JB_Ok.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Ok Press.png"))); // NOI18N
        JB_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_OkActionPerformed(evt);
            }
        });

        BT_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar.png"))); // NOI18N
        BT_Sair.setMnemonic('c');
        BT_Sair.setToolTipText("Clique Para Cancelar Ou Pressione Alt + C");
        BT_Sair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Cancelar Press.png"))); // NOI18N
        BT_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SairActionPerformed(evt);
            }
        });

        JTB_Lote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Lote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTB_Lote.getTableHeader().setReorderingAllowed(false);
        JTB_Lote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTB_LoteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Lote);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Quantidade*:");

        JTF_Quantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Quantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTF_Quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_QuantidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JB_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(JTF_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jLabel2)
                    .addContainerGap(270, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(JTF_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel2)
                    .addContainerGap(238, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JB_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_OkActionPerformed
        Testar_Quantidade();
    }//GEN-LAST:event_JB_OkActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
    ObjSaida.Limpar_Produto();
    dispose();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void JTB_LoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTB_LoteKeyPressed
         try {
            int linha_selecionada = JTB_Lote.getSelectedRow();
            if (linha_selecionada >= 0)
                {
                if(evt.getKeyChar()==KeyEvent.VK_ENTER){
                    JTF_Quantidade.requestFocus();
                    JTB_Lote.setRowSelectionInterval(linha_selecionada, linha_selecionada);
                }
            }
         }catch(Exception ex){}
    }//GEN-LAST:event_JTB_LoteKeyPressed

    private void JTF_QuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_QuantidadeActionPerformed
        JB_Ok.requestFocus();
    }//GEN-LAST:event_JTF_QuantidadeActionPerformed

    
    public void Verifica_Lote(){}
    
    public void Testar_Quantidade(){
        int linha_selecionada = JTB_Lote.getSelectedRow();
        if (linha_selecionada >= 0)
        {
            try {
                if(!JTF_Quantidade.getText().equalsIgnoreCase("")){
                double QuantSoliciatada = (Double.parseDouble(JTF_Quantidade.getText()));
                double QuantEstoque = (Double.parseDouble(String.valueOf(JTB_Lote.getValueAt(JTB_Lote.getSelectedRow(), 2))));
                String lote = (String.valueOf(JTB_Lote.getValueAt(JTB_Lote.getSelectedRow(), 0)));
                    if(QuantSoliciatada<1){
                        ObjSaida.Mostrar_Quantidade_Invalida();
                    }else{
                        if(QuantSoliciatada>QuantEstoque){
                            ObjSaida.Mostrar_Quantidade_Maior();
                        }else{
                            ObjSaida.Verifica_Se_Existe_Lote_Na_Lista(IdProd, lote);
                            if(ObjSaida.Controla_Lote == true){
                                ObjSaida.Controla_Lote = false;
                                //QuantDisponivel = (Double.parseDouble(String.valueOf(JTB_Lote.getValueAt(JTB_Lote.getSelectedRow(), 2))))+ ObjSaida.QuantRetirada;
                                ObjSaida.QuantDisponivel = (Double.parseDouble(String.valueOf(JTB_Lote.getValueAt(JTB_Lote.getSelectedRow(), 2))))+ ObjSaida.QuantRetirada;
                                dispose();
                                ObjSaida.Mostrar_Conf_Alterar_Quantidade_Lote();
                            }else{
                                Adicionar_Produto_Lote();
                            }
                        }    
                    }
                }else{
                    ObjSaida.Mostrar_Preencher_Campos();
                }
               
            } catch (NumberFormatException | HeadlessException ex) {
                Logger.getLogger(Escolha_Lote_Saida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{ObjSaida.Mostrar_Selecione_Linha();}
    }
    
    public void Adicionar_Produto_Lote(){
        try {
                double Quant = (Double.parseDouble(JTF_Quantidade.getText()));
                String Validade = ((String) (JTB_Lote.getValueAt(JTB_Lote.getSelectedRow(), 1)));
                String Lote = (String.valueOf(JTB_Lote.getValueAt(JTB_Lote.getSelectedRow(), 0)));
                ObjSaida.Setar_Campo_Lote_Quant(Validade, Quant, Lote);
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(Escolha_Lote_Saida.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public final void Preencher_Tabela_Lote_Estoque(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Lote", "Validade","Quantidade"};//Seta os indices da tabela
        ObjConecta.Conectar();
        ObjConecta.ExecutaSQL(SQL);
        
        try {
            ObjConecta.rs.first();           
            do {
                double Quantidade;
                String Lote = ObjConecta.rs.getString("numero_lote");  
                double Quant= ObjConecta.rs.getDouble("quantidade_estoque");
                ObjSaida.Verifica_Se_Existe_Lote(IdProd,Lote);
                
                Date validade = ObjConecta.rs.getDate("data_validade_lote");
                String data_val= "";
                if(validade != null){data_val = String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta.rs.getDate("data_validade_lote")));}
                
                if(Lote.equalsIgnoreCase(ObjSaida.NumLote)){
                    Quantidade = Quant - ObjSaida.Quantidade;                    
                }else{
                    Quantidade = Quant;
                }
                //adicionando na tabela
                dados.add(new Object[]{Lote,data_val,Quantidade});
                Quantidade = 0;
            } while (ObjConecta.rs.next());
                ObjConecta.Desconecta();
        } catch (SQLException ex) {
        }
        
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Lote.setModel(tabela);  
        JTB_Lote.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Lote.getColumnModel().getColumn(0).setPreferredWidth(120);//Tamanho da coluna
        JTB_Lote.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Lote.getColumnModel().getColumn(1).setPreferredWidth(300);
        JTB_Lote.getColumnModel().getColumn(1).setResizable(false);
        JTB_Lote.getColumnModel().getColumn(2).setPreferredWidth(120);
        JTB_Lote.getColumnModel().getColumn(2).setResizable(false);
        JTB_Lote.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Lote.setAutoResizeMode(JTB_Lote.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Todas colunas)
        JTB_Lote.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
        
        
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Escolha_Lote_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Escolha_Lote_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Escolha_Lote_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Escolha_Lote_Saida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Escolha_Lote_Saida dialog = new Escolha_Lote_Saida(ObjSaida, true);
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
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton JB_Ok;
    private javax.swing.JTable JTB_Lote;
    private javax.swing.JTextField JTF_Quantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

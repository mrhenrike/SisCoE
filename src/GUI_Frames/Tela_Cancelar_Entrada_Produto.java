package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Entrada_Produto;
import Classes.Modelo_Produto;
import Classes.Modelo_Tabela;
import Conexao.Conecta_Banco;
import Conexao.Controle_Entrada_Produto;
import Conexao.Controle_Log;
import Conexao.Controle_Produto;
import GUI_Dialogs_Entrada.Conf_Sair_Sem_Salvar_Ent_Canc;
import GUI_Dialogs_Entrada.Conf_Salvar_Ent_Canc;
import GUI_Dialogs_Entrada.Inf_Dados_Nao_Salvos_Ent_Canc;
import GUI_Dialogs_Entrada.Inf_Dados_Salvos_Ent_Canc;
import GUI_Dialogs_Entrada.Inf_Entrada_Nao_Encontrada_Ent_Canc;
import GUI_Dialogs_Entrada.Inf_Nao_Ha_Itens_Salvar_Ent_Canc;
import GUI_Dialogs_Entrada.Inf_Preencher_Campos_Ent_Canc;
import GUI_Dialogs_Entrada.Inf_Entrada_Cancelada_Canc;
import static GUI_Frames.Tela_Principal.CodLogado;
import Metodos.Formatacao;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;


public class Tela_Cancelar_Entrada_Produto extends javax.swing.JInternalFrame {
    
    public static Tela_Cancelar_Entrada_Produto Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Cancelar_Entrada_Produto();
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
    Conecta_Banco ObjConecta_2 = new Conecta_Banco();
    Controle_Produto ObjControlProd = new Controle_Produto();
    Controle_Entrada_Produto ObjControlEnt = new Controle_Entrada_Produto();
    Modelo_Entrada_Produto ObjModeloEntrada = new Modelo_Entrada_Produto();
    Modelo_Produto ObjModeloProd = new Modelo_Produto();
    Formatacao ObjFormat = new Formatacao();
       
    private static Inf_Preencher_Campos_Ent_Canc ObjPreencherCampos;    
    private static Inf_Dados_Salvos_Ent_Canc ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_Ent_Canc ObjDadosNaoSalvos;    
    private static Conf_Salvar_Ent_Canc ObjConfSalvar;
    private static Conf_Sair_Sem_Salvar_Ent_Canc ObjSairSemSalvar;   
    private static Inf_Nao_Ha_Itens_Salvar_Ent_Canc ObjNaoHaItensSalvar;
    private static Inf_Entrada_Nao_Encontrada_Ent_Canc ObjEntradaNaoEncontrada;
    private static Inf_Entrada_Cancelada_Canc ObjSaidaCancelada;
    
    public String Pesquisa_Entrada;
    boolean ConfirmaEntrada;
    
    private static Tela_Consulta_Entrada_Cancela_DL DLConsultaEntradaDL;
    
    
    public Tela_Cancelar_Entrada_Produto() {
        initComponents();
       
        JTF_Descricao_Entrada.setDocument(ObjFormat.new Format_Geral(100));
        JTF_Motivo.setDocument(ObjFormat.new Format_Geral(500));
        JTF_Descricao_Entrada.setEnabled(false);
        JTF_Pesquisa.setDocument(ObjFormat.new Format_Geral(50));        
        JTF_Obs.setEnabled(false);
        JTF_Cod_Entrada.setEnabled(false);
        Desabilita_Status();
        Setar_Atalho_BT();        
        JTB_Itens_Entrada.setEnabled(false);
        BT_Salvar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBG_Validade = new javax.swing.ButtonGroup();
        BT_Sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Itens_Entrada = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        BT_Salvar = new javax.swing.JButton();
        JP_Descricao_Entrada = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JTF_Descricao_Entrada = new javax.swing.JTextField();
        JTF_Cod_Entrada = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        JTF_Obs = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        JL_Campos = new javax.swing.JLabel();
        JL_Quant_Item = new javax.swing.JLabel();
        JL_Informacao = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JTF_Pesquisa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BT_Confirmar = new javax.swing.JButton();
        BT_Procurar = new javax.swing.JButton();
        JL_Saida = new javax.swing.JLabel();
        JL_Saida_Numero = new javax.swing.JLabel();
        JL_Status_Msg = new javax.swing.JLabel();
        JL_Status = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JTF_Motivo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Cancelamento De Entrada De Produto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Remove_24x24.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(805, 635));
        setMinimumSize(new java.awt.Dimension(805, 635));
        setPreferredSize(new java.awt.Dimension(805, 635));
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
                formInternalFrameOpened(evt);
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

        JTB_Itens_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTB_Itens_Entrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Itens_Entrada.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTB_Itens_Entrada);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Itens Entrada:");

        BT_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar.png"))); // NOI18N
        BT_Salvar.setMnemonic('s');
        BT_Salvar.setToolTipText("Clique Para Salvar Ou Pressione Alt + S");
        BT_Salvar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Salvar Press.png"))); // NOI18N
        BT_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SalvarActionPerformed(evt);
            }
        });

        JP_Descricao_Entrada.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Descrição Da Entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Descrição:");

        JTF_Descricao_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Cod_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Obs:");

        JTF_Obs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Cod:");

        javax.swing.GroupLayout JP_Descricao_EntradaLayout = new javax.swing.GroupLayout(JP_Descricao_Entrada);
        JP_Descricao_Entrada.setLayout(JP_Descricao_EntradaLayout);
        JP_Descricao_EntradaLayout.setHorizontalGroup(
            JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Descricao_EntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Descricao_EntradaLayout.createSequentialGroup()
                        .addComponent(JTF_Cod_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTF_Descricao_Entrada))
                    .addComponent(JTF_Obs))
                .addContainerGap())
        );
        JP_Descricao_EntradaLayout.setVerticalGroup(
            JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Descricao_EntradaLayout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addGroup(JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JTF_Cod_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Descricao_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Descricao_EntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(JTF_Obs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        JL_Quant_Item.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Item.setText("0");

        JL_Informacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Informacao.setText("Esc - Sair | F3 - Consultar | F4 - Adicionar | F10 - Salvar");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Pesquisa Entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTF_Pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_PesquisaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Número Ou descrição:");

        BT_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Ativar 24x24.png"))); // NOI18N
        BT_Confirmar.setToolTipText("Clique Para Confirmar Um Produto");
        BT_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ConfirmarActionPerformed(evt);
            }
        });

        BT_Procurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Search_24x24.png"))); // NOI18N
        BT_Procurar.setToolTipText("Clique Para Pesquisar Um Produto");
        BT_Procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ProcurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BT_Confirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BT_Procurar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(BT_Confirmar)
                    .addComponent(BT_Procurar))
                .addGap(5, 5, 5))
        );

        JL_Saida.setBackground(new java.awt.Color(153, 153, 153));
        JL_Saida.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Saida.setForeground(new java.awt.Color(102, 102, 102));
        JL_Saida.setText("Entrada:");

        JL_Saida_Numero.setBackground(new java.awt.Color(153, 153, 153));
        JL_Saida_Numero.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Saida_Numero.setForeground(new java.awt.Color(102, 102, 102));

        JL_Status_Msg.setBackground(new java.awt.Color(153, 153, 153));
        JL_Status_Msg.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Status_Msg.setForeground(new java.awt.Color(102, 102, 102));

        JL_Status.setBackground(new java.awt.Color(153, 153, 153));
        JL_Status.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Status.setForeground(new java.awt.Color(102, 102, 102));
        JL_Status.setText("Status:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Cancelamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTF_Motivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Motivo*:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTF_Motivo)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_Descricao_Entrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JL_Quant_Item, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                                .addComponent(JL_Campos))
                            .addComponent(JL_Informacao))
                        .addGap(18, 18, 18)
                        .addComponent(BT_Salvar)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JL_Saida)
                            .addComponent(JL_Status))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_Status_Msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JL_Saida_Numero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Saida_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(JL_Status_Msg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Saida)
                        .addGap(2, 2, 2)
                        .addComponent(JL_Status)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JP_Descricao_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Informacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JL_Quant_Item, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JL_Campos)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        setBounds(0, 0, 840, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Sair_Sem_Salvar();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        JTF_Pesquisa.requestFocus();
    }//GEN-LAST:event_formInternalFrameOpened

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        int linha = JTB_Itens_Entrada.getRowCount();
        if(linha <=0){
            Mostrar_Nao_Ha_Itens_Salvar();
        }else{
            if(JL_Status_Msg.getText().equalsIgnoreCase("CANCELADA")){
                Mostrar_Entrada_Cancelada();
            }else if(JTF_Descricao_Entrada.getText().equalsIgnoreCase("") || JTF_Cod_Entrada.getText().equalsIgnoreCase("") 
                    || JTF_Motivo.getText().equalsIgnoreCase("")){
                Mostrar_Preencher_Campos();
            }else{
                Mostrar_Conf_Salvar();
            }
        }
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj=null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JTF_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PesquisaActionPerformed
        Pesquisa_Automatica(); 
    }//GEN-LAST:event_JTF_PesquisaActionPerformed

    private void BT_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConfirmarActionPerformed
        Pesquisa_Automatica();           
    }//GEN-LAST:event_BT_ConfirmarActionPerformed

    private void BT_ProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ProcurarActionPerformed
        Pesquisa_Entrada = JTF_Pesquisa.getText();
        Mostrar_Consulta_Entrada();
                 
    }//GEN-LAST:event_BT_ProcurarActionPerformed

     public void Cancelar_Entrada(){       
        try {
            ObjConecta.Conectar();//Abre a conexão            
            //seta o id da entrada
            int Id_Entrada = Integer.parseInt(JTF_Cod_Entrada.getText());
            
            //Conta quantas linha tem
            int Quant_Linhas = JTB_Itens_Entrada.getRowCount();                       
            //Laço para fazer todas as alteracoes no banco
            try {
                for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                    JTB_Itens_Entrada.setRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    
                    if(JTB_Itens_Entrada.getValueAt(Linha, 4).equals("")){   //Produto sem validade     
                        try{
                            int Id_Produto = (Integer.parseInt(String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 0))));//Pega o id do produto na linha da tabela
                            double Quantidade =  (Double.parseDouble(String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 2))));//pega a quantidade na linha da tabela
                            String Validade = null;
                            String Lote = (String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 4)));//pega o lote na linha da tabela
                            
                            ObjControlEnt.Inserir_Entrada_Itens_Cancelamento(Id_Produto, Id_Entrada, Quantidade, Lote, Validade);//inseri os itens
                            if(ObjControlEnt.Confirma_Entrada_Item == true){
                                ObjControlEnt.Atualiza_Estoque_Produto_Cancela(Id_Produto, Quantidade);//atualiza o estoque 
                                ObjControlEnt.Confirma_Entrada_Item = false;
                            }
                            
                        }catch(NumberFormatException | Error ex){JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar o estoque iten!\n"+ex);}
                    }
                    else{//Com validade
                        try{
                            int Id_Produto = (Integer.parseInt(String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 0))));//Pega o id do produto na linha da tabela
                            double Quantidade =  (Double.parseDouble(String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 2))));//pega a quantidade na linha da tabela
                            String Validade = (String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format
                            (new SimpleDateFormat("dd-MM-yyyy").parse(String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 5))))));//pega a trata a data de validade
                            String Lote = (String.valueOf(JTB_Itens_Entrada.getValueAt(Linha, 4)));//pega o lote na linha da tabela
                            
                            ObjControlEnt.Inserir_Entrada_Itens_Cancelamento(Id_Produto, Id_Entrada, Quantidade, Lote, Validade);//inseri os itens
                            if(ObjControlEnt.Confirma_Entrada_Item == true){
                                ObjControlEnt.Atualiza_Estoque_Lote_Produto_Cancela(Id_Produto, Quantidade, Lote, Validade);//atualiza o estoque 
                                ObjControlEnt.Confirma_Entrada_Item = false;
                            }                            
                        }catch(NumberFormatException | ParseException | Error ex){JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar o estoque com lote iten!\n"+ex);}
                    }
                }
                ConfirmaEntrada = true;
            } catch (NumberFormatException | Error ex){
                JOptionPane.showMessageDialog(rootPane, "Erro No Laço: "+ex);
                ConfirmaEntrada = false;
            }
            
            if(ConfirmaEntrada == true){
                ObjControlEnt.Atualiza_Situacao_Entrada(Id_Entrada, "CANCELADA");//altera o status da entrada
                ObjControlEnt.Atualiza_Data_Alteracao_Entrada(Id_Entrada);//altera a data de alteração
                ObjControlEnt.Inserir_Motivo_Entrada_Cancelada(Id_Entrada, JTF_Motivo.getText().trim());
            }           
            ObjConecta.Desconecta();
        } catch (HeadlessException ex) {
            ObjConecta.Desconecta();
            ConfirmaEntrada=false;
            JOptionPane.showMessageDialog(rootPane,"Erro no cancelamento da entrada de produtos \n"+ex);
        }
    }
     
    public void Sair_Sem_Salvar(){
        if(!JL_Status_Msg.getText().equalsIgnoreCase("") && !JL_Status_Msg.getText().equalsIgnoreCase("CANCELADA")){
            Mostrar_Sair_Sem_Salvar();
        }else{
            dispose();
        }
    }
    
    public void Conf_Inserir_Entrada(){
        Cancelar_Entrada();
        if (ConfirmaEntrada == true) 
            {
                Mostrar_Dados_Salvos();
                new Controle_Log().Registrar_Log("Cancelou a entrada id: "+JTF_Cod_Entrada.getText()+" - "+JTF_Descricao_Entrada.getText(), CodLogado);
                Limpar_Tabela_Itens_Entrada();
                JTF_Descricao_Entrada.setText("");
                JTF_Cod_Entrada.setText("");
                JTF_Obs.setText("");
                JTF_Motivo.setText("");
                Desabilita_Status();
                ConfirmaEntrada = false;
            }
            else{
                Mostrar_Dados_Nao_Salvos();
                new Controle_Log().Registrar_Log("erro ao cancelar a entrada id: "+JTF_Cod_Entrada.getText()+" - "+JTF_Descricao_Entrada.getText(), CodLogado);
                ConfirmaEntrada = false;
            }
        }
      
    
    public final void Limpar_Tabela_Itens_Entrada() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{};//Seta os indices da tabela
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens_Entrada.setModel(tabela);
        JL_Quant_Item.setText("0");
    }
    
    public void Setar_Campo_Descricao_Entrada(String descricao, String cod, String obs){//seta os campos o s itens da entrada pesquisada
        JTF_Descricao_Entrada.setText(descricao);
        JTF_Cod_Entrada.setText(cod);
        JTF_Obs.setText(obs);
        Preencher_Tabela_Itens_Entrada("select * from entrada inner join entrada_itens "
                        + "on entrada.id_entrada=entrada_itens.entrada_id_entrada inner join produto "
                        + "on produto.id_produto=entrada_itens.produto_id_produto where entrada_itens.entrada_id_entrada="+cod+"");
        JTF_Pesquisa.setText("");
        JL_Quant_Item.setText(String.valueOf(JTB_Itens_Entrada.getRowCount()));
                
    }
    
    void Pesquisa_Automatica(){//verifica se foi digitado texto ou numero e faz a consulta
        boolean ehNumero = true;
        try{
            Integer.parseInt(JTF_Pesquisa.getText());
        }catch(Exception e){
            ehNumero = false;
        }
        if(ehNumero == false){
            Pesquisa_Entrada = JTF_Pesquisa.getText();
            Mostrar_Consulta_Entrada();
            JTF_Motivo.requestFocus();
        }
        if(ehNumero == true){
            Testar_Campos_Pesquisa_Entrada(JTF_Pesquisa.getText());
        }
    }
    
    void Testar_Campos_Pesquisa_Entrada(String id){//verifica a pesquisa de entrada atraves do id
        ObjControlEnt.Consulta_Entrada_Id(Integer.parseInt(id));
        if(ObjControlEnt.Controle_Entrada == true){//se existe entrada
            ObjControlEnt.Controle_Entrada = false;
            ObjControlEnt.Consulta_Entrada_Id_Ativo(Integer.parseInt(id));
            if(ObjControlEnt.Controle_Entrada == true){//se a entrada ainda nao foi cancelada
                ObjControlEnt.Consulta_Entrada(ObjModeloEntrada, id);
                Setar_Campo_Descricao_Entrada(ObjModeloEntrada.getDescricao(), String.valueOf(ObjModeloEntrada.getId_entrada()),ObjModeloEntrada.getObservacao());
                JL_Saida.setVisible(!false);
                JL_Saida_Numero.setText(String.valueOf(ObjModeloEntrada.getId_entrada()));
                JL_Status.setVisible(!false);
                JL_Status_Msg.setText(ObjModeloEntrada.getSituacao());
                JTF_Motivo.requestFocus();
                BT_Salvar.setEnabled(true);
                ObjControlEnt.Controle_Entrada = false;
            }else{
                ObjControlEnt.Consulta_Entrada(ObjModeloEntrada, id);
                Setar_Campo_Descricao_Entrada(ObjModeloEntrada.getDescricao(), String.valueOf(ObjModeloEntrada.getId_entrada()),ObjModeloEntrada.getObservacao());
                JL_Saida.setVisible(!false);
                JL_Saida_Numero.setText(String.valueOf(ObjModeloEntrada.getId_entrada()));
                JL_Status.setVisible(!false);
                JL_Status_Msg.setText(ObjModeloEntrada.getSituacao());
                BT_Salvar.setEnabled(false);   
                JTF_Pesquisa.requestFocus();
                Mostrar_Entrada_Cancelada();
                JTF_Pesquisa.requestFocus();
            }
        }else{
            BT_Salvar.setEnabled(false);
            Limpar_Tabela_Itens_Entrada();
            Limpar_Campos();
            Desabilita_Status();
            JTF_Pesquisa.requestFocus();
            Mostrar_Entrada_Nao_Encontrada();
            JTF_Pesquisa.requestFocus();
        }
    }
    
    void Limpar_Campos(){
        JTF_Cod_Entrada.setText("");
        JTF_Descricao_Entrada.setText("");
        JTF_Motivo.setText("");
        JTF_Obs.setText("");
        JTF_Pesquisa.setText("");
    }
    
    final void Desabilita_Status(){          
        JL_Saida.setVisible(false);
        JL_Saida_Numero.setText("");
        JL_Status.setVisible(false);
        JL_Status_Msg.setText("");
    }
    //Dialogs
    void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Ent_Canc(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    void Mostrar_Conf_Salvar(){
        ObjConfSalvar = new Conf_Salvar_Ent_Canc(this, true);
        ObjConfSalvar.setVisible(true);        
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Ent_Canc(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Ent_Canc(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Ent_Canc(this, true);
        ObjSairSemSalvar.setVisible(true);
    }void Mostrar_Consulta_Entrada(){
        DLConsultaEntradaDL = new Tela_Consulta_Entrada_Cancela_DL(this, true);
        DLConsultaEntradaDL.setVisible(true);
    }    
    void Mostrar_Entrada_Nao_Encontrada(){
        ObjEntradaNaoEncontrada = new Inf_Entrada_Nao_Encontrada_Ent_Canc(this, true);
        ObjEntradaNaoEncontrada.setVisible(true);
    }
    void Mostrar_Nao_Ha_Itens_Salvar(){
        ObjNaoHaItensSalvar = new Inf_Nao_Ha_Itens_Salvar_Ent_Canc(this, true);
        ObjNaoHaItensSalvar.setVisible(true);    
    }
    void Mostrar_Entrada_Cancelada(){
        ObjSaidaCancelada = new Inf_Entrada_Cancelada_Canc(this, true);
        ObjSaidaCancelada.setVisible(true);
    }
    
    public final void Preencher_Tabela_Itens_Entrada(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Descrição","Quantidade","Un","Lote","Validade", "Preço"};//Seta os indices da tabela
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
                ObjConecta_2.rs.getDouble("quantidade"),ObjConecta_2.rs.getString("unidade"), lote, data_val, ObjConecta_2.rs.getDouble("preco")});
            } while (ObjConecta_2.rs.next());
            ObjConecta_2.Desconecta();
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Cliente Não Encontrado!");
        }
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Itens_Entrada.setModel(tabela);
        JTB_Itens_Entrada.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());
        JTB_Itens_Entrada.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Itens_Entrada.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Itens_Entrada.getColumnModel().getColumn(1).setPreferredWidth(500);
        JTB_Itens_Entrada.getColumnModel().getColumn(1).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(2).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(2).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(3).setPreferredWidth(50);
        JTB_Itens_Entrada.getColumnModel().getColumn(3).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(4).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(5).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(5).setResizable(false);
        JTB_Itens_Entrada.getColumnModel().getColumn(6).setPreferredWidth(100);
        JTB_Itens_Entrada.getColumnModel().getColumn(6).setResizable(false);
        JTB_Itens_Entrada.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Itens_Entrada.setAutoResizeMode(JTB_Itens_Entrada.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(todas colunas)
        JTB_Itens_Entrada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela     
    }
    
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),"Procurar");
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
        this.getRootPane().getActionMap().put("Procurar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Procurar.doClick();
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
    private javax.swing.JButton BT_Confirmar;
    private javax.swing.JButton BT_Procurar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.ButtonGroup JBG_Validade;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Informacao;
    private javax.swing.JLabel JL_Quant_Item;
    private javax.swing.JLabel JL_Saida;
    private javax.swing.JLabel JL_Saida_Numero;
    private javax.swing.JLabel JL_Status;
    private javax.swing.JLabel JL_Status_Msg;
    private javax.swing.JPanel JP_Descricao_Entrada;
    private javax.swing.JTable JTB_Itens_Entrada;
    private javax.swing.JTextField JTF_Cod_Entrada;
    private javax.swing.JTextField JTF_Descricao_Entrada;
    private javax.swing.JTextField JTF_Motivo;
    private javax.swing.JTextField JTF_Obs;
    private javax.swing.JTextField JTF_Pesquisa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

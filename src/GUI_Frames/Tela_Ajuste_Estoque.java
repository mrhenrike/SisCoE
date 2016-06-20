package GUI_Frames;

// @author Márison Tamiarana

import Classes.Modelo_Ajuste_Estoque;
import Classes.Modelo_Lote_Estoque;
import Classes.Modelo_Produto;
import Conexao.Controle_Ajuste_Estoque;
import Conexao.Controle_Log;
import Conexao.Controle_Lote_Estoque;
import Conexao.Controle_Produto;
import Conexao.Controle_Saida_Produto;
import GUI_Dialogs_Ajuste.Conf_Sair_Sem_Salvar_Ajuste;
import GUI_Dialogs_Ajuste.Conf_Salvar_Ajuste;
import GUI_Dialogs_Ajuste.Escolha_Lote_Ajuste;
import GUI_Dialogs_Ajuste.Inf_Dados_Nao_Salvos_Ajuste;
import GUI_Dialogs_Ajuste.Inf_Dados_Salvos_Ajuste;
import GUI_Dialogs_Ajuste.Inf_Formato_Quant_Invalida_Ajuste;
import GUI_Dialogs_Ajuste.Inf_Preencher_Campo_Pesquisa_Ajuste;
import GUI_Dialogs_Ajuste.Inf_Preencher_Campos_Ajuste;
import GUI_Dialogs_Ajuste.Inf_Prod_Nao_Encontrado_Ajuste;
import GUI_Dialogs_Ajuste.Inf_Quant_Maior_Ajuste;
import GUI_Dialogs_Ajuste.Inf_Selecione_Linha_Ajuste;
import static GUI_Frames.Tela_Principal.CodLogado;
import Metodos.Formatacao;
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
import javax.swing.KeyStroke;


public class Tela_Ajuste_Estoque extends javax.swing.JInternalFrame {

    //metodo para abrir apenas uma instancia da janela
    public static Tela_Ajuste_Estoque Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Ajuste_Estoque();
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
    
    Formatacao ObjFormat = new Formatacao();
    Modelo_Produto ObjModProd = new Modelo_Produto();
    Modelo_Lote_Estoque ObjModLote = new Modelo_Lote_Estoque();
    Modelo_Ajuste_Estoque ObjModAjuste = new Modelo_Ajuste_Estoque();
    Controle_Produto ObjControleProd = new Controle_Produto();
    Controle_Saida_Produto ObjControleSaida = new Controle_Saida_Produto();
    Controle_Lote_Estoque ObjControleLote = new Controle_Lote_Estoque();
    Controle_Ajuste_Estoque ObjControleAjuste = new Controle_Ajuste_Estoque();
    
    private static Inf_Prod_Nao_Encontrado_Ajuste ObjProdNaoEncontrado;
    private static Inf_Preencher_Campos_Ajuste ObjPreencherCampos;
    private static Inf_Preencher_Campo_Pesquisa_Ajuste ObjPreencherCampoPesquisa;
    private static Inf_Quant_Maior_Ajuste ObjQuantMaior;
    private static Inf_Selecione_Linha_Ajuste ObjSelecioneLinha;
    private static Tela_Consulta_Produto_Ajuste_DL ObjConsultaProd;
    private static Escolha_Lote_Ajuste ObjEscolhaLote;
    private static Conf_Salvar_Ajuste ObjSalvar;
    private static Inf_Dados_Nao_Salvos_Ajuste ObjDadosNaoSalvo;
    private static Inf_Dados_Salvos_Ajuste ObjDadosSalvos;
    private static Inf_Formato_Quant_Invalida_Ajuste ObjFormatoInvalida;
    private static Conf_Sair_Sem_Salvar_Ajuste ObjSairSemSalvar;
    
    //boolean para controle
    public boolean Confirma_inserir;
    
    
    String Un_Prod;//variavel para receber o tipo de unidade do produto
    String Consulta_Produto;//
    
    public Tela_Ajuste_Estoque() {
        initComponents();
        Preencher_CB_Motivo();
        
        JTF_Pesquisa.setDocument(ObjFormat.new Format_Geral(50));
        JTF_Quantidade.setDocument(ObjFormat.new Format_Valor_Negativo(10));
        JTF_Obs.setDocument(ObjFormat.new Format_Geral(100));
        Setar_Atalho_BT();
        BT_Confirmar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JTF_Pesquisa = new javax.swing.JTextField();
        BT_Confirmar = new javax.swing.JButton();
        BT_Procurar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JL_Descricao = new javax.swing.JLabel();
        JL_Estoque = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JL_Validade = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JL_Lote = new javax.swing.JLabel();
        JL_Cod_Produto = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JL_Un = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JCB_Motivo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        JTF_Quantidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        JL_Nova_Quant = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JTF_Obs = new javax.swing.JTextField();
        BT_Sair = new javax.swing.JButton();
        BT_Salvar = new javax.swing.JButton();
        JL_Quant_Itens1 = new javax.swing.JLabel();
        JL_Campos = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Ajuste De Estoque");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Ajuste Estoque 24x24.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código Ou Descrição:");

        JTF_Pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Pesquisa.setToolTipText("Insira O Código Ou A Descrição Do Produto E Pressione A Tecla Enter.");
        JTF_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_PesquisaActionPerformed(evt);
            }
        });
        JTF_Pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTF_PesquisaKeyReleased(evt);
            }
        });

        BT_Confirmar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Ativar 24x24.png"))); // NOI18N
        BT_Confirmar.setText("(F2)");
        BT_Confirmar.setToolTipText("Clique Para Confirmar Um Produto Através Do Código");
        BT_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ConfirmarActionPerformed(evt);
            }
        });

        BT_Procurar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BT_Procurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Search_24x24.png"))); // NOI18N
        BT_Procurar.setText("(F3)");
        BT_Procurar.setToolTipText("Clique Para Pesquisar Um Produto");
        BT_Procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_ProcurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BT_Confirmar)
                .addGap(18, 18, 18)
                .addComponent(BT_Procurar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BT_Procurar)
                        .addComponent(BT_Confirmar)))
                .addGap(10, 10, 10))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Informação Do Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descrição*:");

        JL_Descricao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        JL_Estoque.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Estoque Atual*:");

        JL_Validade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Validade:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Lote:");

        JL_Lote.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        JL_Cod_Produto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Código*:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Unidade:");

        JL_Un.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_Descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JL_Validade, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JL_Cod_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_Lote, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JL_Estoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(JL_Un, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JL_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JL_Estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(JL_Cod_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JL_Un, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Validade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Dados Do Ajuste", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Motivo*:");

        JCB_Motivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCB_Motivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_MotivoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Quantidade*:");

        JTF_Quantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_QuantidadeActionPerformed(evt);
            }
        });
        JTF_Quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTF_QuantidadeKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Nova Quantidade:");

        JL_Nova_Quant.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Obs:");

        JTF_Obs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Obs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_ObsActionPerformed(evt);
            }
        });
        JTF_Obs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTF_ObsKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(JCB_Motivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(JTF_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JTF_Obs)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(JL_Nova_Quant, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JCB_Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_Obs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JL_Nova_Quant, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
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

        JL_Quant_Itens1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JL_Quant_Itens1.setText("Esc - Sair | F10 - Salvar");

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_Quant_Itens1)
                            .addComponent(JL_Campos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Quant_Itens1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Campos))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PesquisaActionPerformed
        Consulta_Produto();
    }//GEN-LAST:event_JTF_PesquisaActionPerformed

    private void BT_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConfirmarActionPerformed
        Testar_Campos_Pesquisa();
    }//GEN-LAST:event_BT_ConfirmarActionPerformed

    private void BT_ProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ProcurarActionPerformed
        Consulta_Produto = JTF_Pesquisa.getText().trim();
        Mostrar_Consulta_Prod();
    }//GEN-LAST:event_BT_ProcurarActionPerformed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Sair_Sem_Salvar();        
    }//GEN-LAST:event_BT_SairActionPerformed

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        Testar_Campos_Salvar();
    }//GEN-LAST:event_BT_SalvarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void JTF_QuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_QuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_QuantidadeActionPerformed

    private void JTF_QuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTF_QuantidadeKeyReleased
        if(!JTF_Quantidade.getText().equalsIgnoreCase("")
                &&(!JTF_Quantidade.getText().equalsIgnoreCase("-"))
                &&(!JL_Estoque.getText().equalsIgnoreCase(""))){
            boolean ehNumero = true;
            try{
                Double.parseDouble(JTF_Quantidade.getText().replace(",", "."));//testa se é um numero válido
            }catch(Exception e){
                ehNumero = false;
                                
            }
            
            if(ehNumero == true){
                double estoque = Double.parseDouble(JL_Estoque.getText().replace(",", "."));
                double ajuste = Double.parseDouble(JTF_Quantidade.getText().replace(",", "."));
                float resultado = (float) (estoque+ajuste);            
                JL_Nova_Quant.setText(String.valueOf(resultado).replace(".", ","));
            }
            if(ehNumero == false){
                Mostrar_Formato_Quant_Invalida();
            }
        }
    }//GEN-LAST:event_JTF_QuantidadeKeyReleased

    private void JTF_ObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_ObsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_ObsActionPerformed

    private void JTF_ObsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTF_ObsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_ObsKeyReleased

    private void JCB_MotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_MotivoActionPerformed
        if(JCB_Motivo.getSelectedIndex()==0){
            JTF_Quantidade.setText("");
            JL_Nova_Quant.setText("");
        }
    }//GEN-LAST:event_JCB_MotivoActionPerformed

    private void JTF_PesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTF_PesquisaKeyReleased
        boolean ehNumero = true;
        try{
            Integer.parseInt(JTF_Pesquisa.getText());
        }catch(Exception e){
            ehNumero = false;
            
        }
        if(ehNumero==false){
            BT_Confirmar.setEnabled(false);}          
        if(ehNumero == true){
            BT_Confirmar.setEnabled(true);}    
    }//GEN-LAST:event_JTF_PesquisaKeyReleased

    final void Preencher_CB_Motivo(){
        JCB_Motivo.removeAllItems();
        JCB_Motivo.addItem("");
        JCB_Motivo.addItem("AVARIA OU PERDA");
        JCB_Motivo.addItem("VENCIDO");
        JCB_Motivo.addItem("AJUSTE DE ESTOQUE");
        JCB_Motivo.addItem("INVENTÁRIO");
    }
    public void Limpar_Campos_Produto(){
        JL_Descricao.setText("");
        JL_Cod_Produto.setText("");
        JL_Validade.setText("");
        JL_Lote.setText("");
        JL_Estoque.setText("");
        JTF_Pesquisa.setText("");
        JTF_Quantidade.setText("");
        JTF_Pesquisa.setText("");
        JL_Nova_Quant.setText("");
        JCB_Motivo.setSelectedIndex(0);
        JTF_Obs.setText("");
        JL_Un.setText("");
    }
    public void Setar_Campos_Produto(int id,String descricao, String unidade){
        JL_Cod_Produto.setText(String.valueOf(id));
        JL_Descricao.setText(descricao);
        JL_Un.setText(unidade);
    }
    public void Setar_Campos_Lote_Estoque(String validade, double quant, String lote){
        JL_Lote.setText(lote);
        JL_Validade.setText(validade);
        JL_Estoque.setText(String.valueOf(quant).replace(".", ","));
        JCB_Motivo.requestFocus();
    }
    public void Setar_Campo_Quantidade(double quant){
        JL_Estoque.setText(String.valueOf(quant).replace(".", ","));
        JCB_Motivo.requestFocus();
    }
    public void Setar_Un_Prod(String un){
        this.Un_Prod = un;
    }

    void Testar_Campos_Pesquisa(){
        if(!JTF_Pesquisa.getText().equalsIgnoreCase("")){
            ObjControleProd.Confirma_Produto_Existe(JTF_Pesquisa.getText().trim());
            if(ObjControleProd.Confirma_Existente==true){
                Object resultado = JTF_Pesquisa.getText().trim();
                Limpar_Campos_Produto();
                ObjControleSaida.Controla_Lote(resultado);
                if(ObjControleSaida.Controla_Lote==true){//com lote
                    ObjModProd.setPesquisa(String.valueOf(resultado));
                    ObjControleProd.Consulta_Produto(ObjModProd);
                    Setar_Campos_Produto(ObjModProd.getId_produto(),ObjModProd.getDescricao(), ObjModProd.getUnidade());                    
                    Mostrar_Escolha_Lote(resultado);
                    ObjControleSaida.Controla_Lote=false;
                    JCB_Motivo.requestFocus();
                    BT_Confirmar.setEnabled(false);
                }else{
                    try {
                        ObjModProd.setPesquisa(String.valueOf(resultado));
                        ObjControleProd.Consulta_Produto(ObjModProd);
                        Setar_Campos_Produto(ObjModProd.getId_produto(),ObjModProd.getDescricao(), ObjModProd.getUnidade());                 
                        ObjControleLote.Consulta_Estoque_Produto_Sem_Lote(ObjModLote, resultado);
                        Setar_Campo_Quantidade(ObjModLote.getQuantidade_estoque());
                        JCB_Motivo.requestFocus();
                        BT_Confirmar.setEnabled(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(Tela_Ajuste_Estoque.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            ObjControleProd.Confirma_Existente = false;
            }else{
                Mostrar_Produto_Nao_Encontrado();
                Limpar_Campos_Produto();
            }
        }else{
            Mostrar_Preencher_Pesquisa();
        }
    }
    
    public void Sair_Sem_Salvar(){
        if(!JL_Cod_Produto.getText().equalsIgnoreCase("") && !JTF_Quantidade.getText().equalsIgnoreCase("")){
            Mostrar_Sair_Sem_Salvar();
        }else{
            dispose();
        }
    }
    
    public void Testar_Campos_Salvar(){
        if(JL_Cod_Produto.getText().equalsIgnoreCase("") || JCB_Motivo.getSelectedItem().equals("")
                || JTF_Quantidade.getText().equalsIgnoreCase("")){
            Mostrar_Preencher_Campos();
        }else{
            boolean ehNumero = true;
            try{
                Double.parseDouble(JTF_Quantidade.getText().replace(",", "."));//testa se é um numero válido
            }catch(Exception e){
                ehNumero = false;
            }
            
            if(ehNumero == true){
                double estoque = Double.valueOf(JL_Estoque.getText().trim().replace(",", "."));
                double nova_quantidade = Double.valueOf(JTF_Quantidade.getText().trim().replace(",", "."));
                double resultado = estoque + nova_quantidade;
                if(resultado<0){
                    Mostrar_Quantidade_Maior();
                }else{
                    Mostrar_Confirma_Salvar();
                }
            }
            if(ehNumero == false){
                Mostrar_Formato_Quant_Invalida();
            }
        }
    
    }
    
    public void Preencher_Objetos(){
        ObjModAjuste.setMotivo(JCB_Motivo.getSelectedItem().toString().trim());
        ObjModAjuste.setObservacao(JTF_Obs.getText().trim());
        ObjModAjuste.setQuantidade(Double.valueOf(JTF_Quantidade.getText().trim().replace(",", ".")));
        ObjModAjuste.setData_ajuste(new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));      
        
    }
    
    public void Consulta_Produto(){
    boolean ehNumero = true;
        try{
            Integer.parseInt(JTF_Pesquisa.getText());
        }catch(Exception e){
            ehNumero = false;
            
        }
        if(ehNumero==false){
            Consulta_Produto = JTF_Pesquisa.getText().trim();
            Mostrar_Consulta_Prod();}
        if(ehNumero == true){
            Testar_Campos_Pesquisa();}    
    }
    
    public void Conf_Inserir_Ajuste(){
        try {
            int id_produto = Integer.parseInt(JL_Cod_Produto.getText());
            int usuario_logado = Integer.parseInt(Tela_Principal.CodLogado);
            double nova_quant = Double.valueOf(JTF_Quantidade.getText().trim().replace(",", "."));                              
            
            if(JL_Lote.getText().equalsIgnoreCase("")){//produto sem lote
                Preencher_Objetos();
                ObjControleLote.Consulta_Id_Estoque(ObjModLote, id_produto);//consulta o id do estoque
                ObjModAjuste.setLote_id_lote(ObjModLote.getId_lote());//seta para o outro modelo
                ObjControleAjuste.Inserir_Ajuste_Estoque(ObjModAjuste, usuario_logado,id_produto);//inseri no banco o ajuste
                
                if(ObjControleAjuste.Confirma_Inserir == true){//caso a inserção for concluida
                    ObjControleLote.Quantidade_Estoque(ObjModLote, id_produto);//pega a quantidade do estoque
                    ObjControleLote.Atualiza_Estoque(ObjModLote, id_produto, nova_quant ); //atualiza a nova quantidade                    
                    if(ObjControleLote.Confirma_Atualiza_Estoque == true){//se a ataulização for efetivavda
                        Mostrar_Dados_Salvos();
                        ObjControleAjuste.Confirma_Inserir = false;
                        ObjControleLote.Confirma_Atualiza_Estoque = false;
                        //Log no sistema
                        new Controle_Log().Registrar_Log("Ajuste de estoque: "+JCB_Motivo.getSelectedItem().toString().trim()
                                +" ( Numero: "+ObjModAjuste.getId_ajuste_estoque()+" - produto: "+JL_Cod_Produto.getText()+" )", CodLogado);                        
                        Limpar_Campos_Produto();
                    }else{
                        ObjControleAjuste.Exclui_Ajuste(ObjModAjuste.getId_ajuste_estoque());//exclui a entrada caso dê erro na atualização de estoque
                        Mostrar_Dados_Nao_Salvos();
                        ObjControleAjuste.Confirma_Inserir = false;
                        ObjControleLote.Confirma_Atualiza_Estoque = false;
                        //Log no sistema
                        new Controle_Log().Registrar_Log("Ajuste de estoque: "+JCB_Motivo.getSelectedItem().toString().trim()
                                +" ( Numero: "+ObjModAjuste.getId_ajuste_estoque()+" - produto: "+JL_Cod_Produto.getText()
                                +" - Erro no ajuste e id excluido )",CodLogado);
                        Limpar_Campos_Produto();
                    }
                }else{
                    Mostrar_Dados_Nao_Salvos();
                }
                
            }else{//produto com lote
                String validade = (String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format
                              (new SimpleDateFormat("dd-MM-yyyy").parse(JL_Validade.getText().trim()))));//pega a trata a data de validade 
                String lote = JL_Lote.getText().trim();
                
                Preencher_Objetos();
                ObjControleLote.Consulta_Id_Lote_Estoque(ObjModLote,id_produto, lote);//consulta o id do estoque
                ObjModAjuste.setLote_id_lote( ObjModLote.getId_lote());//seta para o outro modelo
                ObjControleAjuste.Inserir_Ajuste_Estoque(ObjModAjuste, usuario_logado,id_produto);//inseri no banco o ajuste
                
                if(ObjControleAjuste.Confirma_Inserir == true){//caso a inserção for concluida
                    ObjControleLote.Quantidade_Estoque_Lote(ObjModLote, id_produto,lote, validade);//pega a quantidade do estoque
                    ObjControleLote.Atualiza_Estoque_Lote(ObjModLote, id_produto, nova_quant, lote, validade ); //atualiza a nova quantidade
                    
                    if(ObjControleLote.Confirma_Atualiza_Estoque_Lote == true){//se a ataulização for efetivavda
                        Limpar_Campos_Produto();
                        Mostrar_Dados_Salvos();
                        ObjControleAjuste.Confirma_Inserir = false;
                        ObjControleLote.Confirma_Atualiza_Estoque_Lote = false;
                    }else{
                        ObjControleAjuste.Exclui_Ajuste(ObjModAjuste.getId_ajuste_estoque());//exclui a entrada caso dê erro na atualização de estoque
                        Mostrar_Dados_Nao_Salvos();
                        Limpar_Campos_Produto();
                        ObjControleAjuste.Confirma_Inserir = false;
                        ObjControleLote.Confirma_Atualiza_Estoque_Lote = false;
                    }
                }else{
                    Limpar_Campos_Produto();
                    Mostrar_Dados_Nao_Salvos();
                }
            }
            //JOptionPane.showMessageDialog(rootPane, ObjModAjuste.getId_ajuste_estoque());
        } catch (ParseException ex) {
            Logger.getLogger(Tela_Ajuste_Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Mostrar_Quantidade_Maior(){
        ObjQuantMaior = new Inf_Quant_Maior_Ajuste(this, true);
        ObjQuantMaior.setVisible(true);
    }
    public void Mostrar_Produto_Nao_Encontrado(){
        ObjProdNaoEncontrado = new Inf_Prod_Nao_Encontrado_Ajuste(this, true);
        ObjProdNaoEncontrado.setVisible(true);
    }
    public void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Ajuste(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    public void Mostrar_Selecione_Linha(){
        ObjSelecioneLinha = new Inf_Selecione_Linha_Ajuste(this, true);
        ObjSelecioneLinha.setVisible(true);
    }
    public void Mostrar_Consulta_Prod(){
        ObjConsultaProd = new Tela_Consulta_Produto_Ajuste_DL(this, true);
        ObjConsultaProd.setVisible(true);
    }
    public void Mostrar_Escolha_Lote(Object id){
        ObjEscolhaLote = new Escolha_Lote_Ajuste(this, true, id);
        ObjEscolhaLote.setVisible(true);
    }
    public void Mostrar_Preencher_Pesquisa(){
        ObjPreencherCampoPesquisa = new Inf_Preencher_Campo_Pesquisa_Ajuste(this, true);
        ObjPreencherCampoPesquisa.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvo = new Inf_Dados_Nao_Salvos_Ajuste(this, true);
        ObjDadosNaoSalvo.setVisible(true);
    }
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Ajuste(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Confirma_Salvar(){
        ObjSalvar = new Conf_Salvar_Ajuste(this, true);
        ObjSalvar.setVisible(true);
    }
    void Mostrar_Formato_Quant_Invalida(){
        ObjFormatoInvalida = new Inf_Formato_Quant_Invalida_Ajuste(this, true);
        ObjFormatoInvalida.setVisible(true);
    }
    
    void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Ajuste(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    
     public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),"Procurar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap2);
        
        InputMap inputMap3 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap3.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0),"Confirmar");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap3);
        
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
        this.getRootPane().getActionMap().put("Confirmar", new AbstractAction(){
        private static final long serialVersionUID = 1L;
        @Override
        public void actionPerformed(ActionEvent arg0) {
        BT_Confirmar.doClick();     
        }
        });   
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Confirmar;
    private javax.swing.JButton BT_Procurar;
    private javax.swing.JButton BT_Sair;
    private javax.swing.JButton BT_Salvar;
    private javax.swing.JComboBox JCB_Motivo;
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Cod_Produto;
    private javax.swing.JLabel JL_Descricao;
    private javax.swing.JLabel JL_Estoque;
    private javax.swing.JLabel JL_Lote;
    private javax.swing.JLabel JL_Nova_Quant;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JLabel JL_Un;
    private javax.swing.JLabel JL_Validade;
    private javax.swing.JTextField JTF_Obs;
    private javax.swing.JTextField JTF_Pesquisa;
    private javax.swing.JTextField JTF_Quantidade;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}

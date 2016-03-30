package GUI_Frames;

import Classes.Modelo_Saida_Produto;
import Classes.Modelo_Tabela;
import Conexao.Conecta_Banco;
import Conexao.Controle_Log;
import Conexao.Controle_Saida_Produto;
import GUI_Dialogs_Devolucao.Conf_Sair_Sem_Salvar_Dev;
import GUI_Dialogs_Devolucao.Conf_Salvar_Dev;
import GUI_Dialogs_Devolucao.Inf_Dados_Nao_Salvos_Dev;
import GUI_Dialogs_Devolucao.Inf_Dados_Salvos_Dev;
import GUI_Dialogs_Devolucao.Inf_Dev_Ja_Efetivada_Dev;
import GUI_Dialogs_Devolucao.Inf_Nao_Existe_Prod_Dev;
import GUI_Dialogs_Devolucao.Inf_Preencher_Campos_Dev;
import GUI_Dialogs_Devolucao.Inf_Saida_Nao_Encontrada_Dev;
import static GUI_Frames.Tela_Principal.CodLogado;
import Metodos.Pintar_Tabela_Padrao;
import java.awt.Dimension;
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
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

// @author Márison Tamiarana

public class Tela_Gerar_Devolucao extends javax.swing.JInternalFrame {

    //metodo para abrir apenas uma instancia da janela
    public static Tela_Gerar_Devolucao Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Gerar_Devolucao();
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
    
    //instancia de objetos para dialogs
    private static Inf_Dados_Salvos_Dev ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_Dev ObjDadosNaoSalvos;
    private static Inf_Saida_Nao_Encontrada_Dev ObjSaidaNaoEncontrada;
    private static Inf_Preencher_Campos_Dev ObjPreencherCampos;
    private static Inf_Nao_Existe_Prod_Dev ObjNaoExisteProdDev;
    private static Inf_Dev_Ja_Efetivada_Dev ObjDevJaEfetivada;
    private static Conf_Salvar_Dev ObjSalvar;
    private static Conf_Sair_Sem_Salvar_Dev ObjSairSemSalvar;
    private static Tela_Consulta_Saida_Devolucao_DL ObjConsSaida;
    
    //Instancia das classes
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Conecta_Banco ObjConecta2 = new Conecta_Banco();
    Modelo_Saida_Produto ObjModeloSaida = new Modelo_Saida_Produto();
    Controle_Saida_Produto ObjControlSaida = new Controle_Saida_Produto();
    
    //Boolean para controles;
    public boolean Confirma_Devolucao;
    
    public Tela_Gerar_Devolucao() {
        initComponents();
        Desabilita_Campos();
        JL_Saida.setVisible(false);
        JL_Saida_Numero.setText("");
        JL_Status.setVisible(false);
        JL_Status_Msg.setText("");
        BT_Salvar.setEnabled(false);
        Setar_Atalho_BT();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTF_Observacao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JTF_Curso = new javax.swing.JTextField();
        JTF_Tipo = new javax.swing.JTextField();
        JTF_Turno = new javax.swing.JTextField();
        JTF_Ano = new javax.swing.JTextField();
        JTF_Semestre = new javax.swing.JTextField();
        JTF_Vestibular = new javax.swing.JTextField();
        JTF_Disciplina_Semestre = new javax.swing.JTextField();
        JTF_Disciplina = new javax.swing.JTextField();
        BT_Sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Devolucao_Prod = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        JTF_Pesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BT_Confirmar = new javax.swing.JButton();
        BT_Procurar = new javax.swing.JButton();
        JL_Saida = new javax.swing.JLabel();
        JL_Saida_Numero = new javax.swing.JLabel();
        JL_Status = new javax.swing.JLabel();
        JL_Status_Msg = new javax.swing.JLabel();
        BT_Salvar = new javax.swing.JButton();
        JL_Quant_Itens1 = new javax.swing.JLabel();
        JL_Campos = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Devolução De Produtos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Prod 24x24.png"))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Descrição Da Saída", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Curso*:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Obs:");

        JTF_Observacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tipo*:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Ano*:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Turno*:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Disciplina*:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Semestre*:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Vestibular*:");

        JTF_Curso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Tipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Turno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Ano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Semestre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Vestibular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Disciplina_Semestre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JTF_Disciplina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTF_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTF_Disciplina_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_Turno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTF_Disciplina)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTF_Ano, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTF_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTF_Vestibular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(JTF_Observacao))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(JTF_Curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Vestibular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(JTF_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Disciplina_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Observacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
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

        JTB_Devolucao_Prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Devolucao_Prod.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTB_Devolucao_Prod);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTF_Pesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_Pesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_PesquisaFocusGained(evt);
            }
        });
        JTF_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_PesquisaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Número Da Saída*:");

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
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(JTF_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BT_Confirmar)
                .addGap(18, 18, 18)
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
                            .addComponent(jLabel2)))
                    .addComponent(BT_Confirmar)
                    .addComponent(BT_Procurar))
                .addGap(5, 5, 5))
        );

        JL_Saida.setBackground(new java.awt.Color(153, 153, 153));
        JL_Saida.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Saida.setForeground(new java.awt.Color(102, 102, 102));
        JL_Saida.setText("Saída:");

        JL_Saida_Numero.setBackground(new java.awt.Color(153, 153, 153));
        JL_Saida_Numero.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Saida_Numero.setForeground(new java.awt.Color(102, 102, 102));

        JL_Status.setBackground(new java.awt.Color(153, 153, 153));
        JL_Status.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Status.setForeground(new java.awt.Color(102, 102, 102));
        JL_Status.setText("Status:");

        JL_Status_Msg.setBackground(new java.awt.Color(153, 153, 153));
        JL_Status_Msg.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JL_Status_Msg.setForeground(new java.awt.Color(102, 102, 102));

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
        JL_Quant_Itens1.setText("Esc - Sair | F2 - Confirmar | F3 - Consultar | F10 - Salvar");

        JL_Campos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JL_Campos.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_Campos)
                            .addComponent(JL_Quant_Itens1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JL_Status)
                            .addComponent(JL_Saida))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JL_Saida_Numero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JL_Status_Msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JL_Saida_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)
                            .addComponent(JL_Status_Msg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JL_Saida)
                            .addGap(2, 2, 2)
                            .addComponent(JL_Status))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BT_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JL_Quant_Itens1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Campos)))
                .addContainerGap())
        );

        setBounds(0, 0, 805, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Obj = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void BT_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SairActionPerformed
        Sair_Sem_Salvar();
    }//GEN-LAST:event_BT_SairActionPerformed

    private void JTF_PesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_PesquisaFocusGained
        //PesquisarNome();
    }//GEN-LAST:event_JTF_PesquisaFocusGained

    private void JTF_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PesquisaActionPerformed
        Testar_Campos_Pesquisa();
    }//GEN-LAST:event_JTF_PesquisaActionPerformed

    private void BT_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConfirmarActionPerformed
        Testar_Campos_Pesquisa();
    }//GEN-LAST:event_BT_ConfirmarActionPerformed

    private void BT_ProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ProcurarActionPerformed
        Mostrar_Consulta_Saida();
    }//GEN-LAST:event_BT_ProcurarActionPerformed

    private void BT_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SalvarActionPerformed
        Testar_Campos_Salvar();
       
    }//GEN-LAST:event_BT_SalvarActionPerformed

    public final void Limpar_Campos(){
        JTF_Ano.setText("");
        JTF_Curso.setText("");
        JTF_Disciplina.setText("");
        JTF_Disciplina_Semestre.setText("");
        JTF_Observacao.setText("");
        JTF_Semestre.setText("");
        JTF_Tipo.setText("");
        JTF_Turno.setText("");
        JTF_Vestibular.setText("");
        JL_Saida.setVisible(!true);
        JL_Saida_Numero.setText("");
        JL_Status.setVisible(!true);
        JL_Status_Msg.setText("");
    }
    
    public final void Desabilita_Campos(){
        JTF_Ano.setEnabled(false);
        JTF_Curso.setEnabled(false);
        JTF_Disciplina.setEnabled(false);
        JTF_Disciplina_Semestre.setEnabled(false);
        JTF_Observacao.setEnabled(false);
        JTF_Semestre.setEnabled(false);
        JTF_Tipo.setEnabled(false);
        JTF_Turno.setEnabled(false);
        JTF_Vestibular.setEnabled(false);
    }
    public void Setar_Campos(){
        JTF_Curso.setText(String.valueOf(ObjModeloSaida.getCurso_nome()));
        JTF_Turno.setText(String.valueOf(ObjModeloSaida.getTurma_turno()));
        JTF_Ano.setText(String.valueOf(ObjModeloSaida.getTurma_ano()));
        JTF_Semestre.setText(String.valueOf(ObjModeloSaida.getTurma_semestre()));
        JTF_Vestibular.setText(String.valueOf(ObjModeloSaida.getVestibular()));
        JTF_Tipo.setText(String.valueOf(ObjModeloSaida.getTipo()));
        JTF_Disciplina_Semestre.setText(String.valueOf(ObjModeloSaida.getDisciplina_semestre()));
        JTF_Disciplina.setText(String.valueOf(ObjModeloSaida.getDisciplina_nome()));
        JTF_Observacao.setText(String.valueOf(ObjModeloSaida.getObservacao()));
        JL_Saida.setVisible(true);
        JL_Saida_Numero.setText(String.valueOf(ObjModeloSaida.getId_saida()));
        JL_Status.setVisible(true);
        JL_Status_Msg.setText(String.valueOf(ObjModeloSaida.getSituacao()));
        
        
    }
    //verifica se a saida necessita devolução
    public void Testar_Campos_Pesquisa(){
        if(!JTF_Pesquisa.getText().equalsIgnoreCase("")){//se o campo nao estiver em branco
            ObjControlSaida.Consulta_Saida_Id(Integer.parseInt(JTF_Pesquisa.getText()));//consulta se existe pelo menos uma saída
            if(ObjControlSaida.Controle_Saida == true){//se existir saída
                  ObjControlSaida.Verifica_Saida_Devolucao(JTF_Pesquisa);//verifica se precisa realizar devolução
                  if(ObjControlSaida.Verifica_Devolucao == true){//se precisar devolver 
                    ObjControlSaida.Saida_Em_Aberto(Integer.parseInt(JTF_Pesquisa.getText()));//verifica se esta em aberto
                        if(ObjControlSaida.Controle_Saida_Em_Aberto == true){//se estiver em aberto, so preenche com os produto que ainda nao foram devolvidos
                          Limpar_Tabela(JTB_Devolucao_Prod);
                            Preencher_Tabela("select*from produto inner join categoria_produto "
                            + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                            + "inner join saida_itens on produto.id_produto = saida_itens.produto_id_produto "
                            + " where saida_id_saida="+JTF_Pesquisa.getText()+" and solicita_devolucao = 'SIM' and devolvido = 'NÃO'");
                            Limpar_Campos();
                            ObjControlSaida.Consulta_Saida_Devolucao(ObjModeloSaida, Integer.parseInt(JTF_Pesquisa.getText()));
                            Setar_Campos();
                            BT_Salvar.setEnabled(true);
                            ObjControlSaida.Verifica_Devolucao= false;
                            JTF_Pesquisa.setText("");
                            ObjControlSaida.Controle_Saida_Em_Aberto = false;
                        }else{//se naão estiver em aberto, preenche normal                     
                            Limpar_Tabela(JTB_Devolucao_Prod);
                            Preencher_Tabela("select*from produto inner join categoria_produto "
                            + "on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                            + "inner join saida_itens on produto.id_produto = saida_itens.produto_id_produto "
                            + " where saida_id_saida="+JTF_Pesquisa.getText()+" and solicita_devolucao = 'SIM' ");
                            Limpar_Campos();
                            ObjControlSaida.Consulta_Saida_Devolucao(ObjModeloSaida, Integer.parseInt(JTF_Pesquisa.getText()));
                            Setar_Campos();
                            BT_Salvar.setEnabled(true);
                            ObjControlSaida.Verifica_Devolucao= false;
                            JTF_Pesquisa.setText("");
                        }
                }else{//se naõ precisar devolver
                    Mostrar_Nao_Existe_Prod_Dev();
                    ObjControlSaida.Verifica_Devolucao= false;
                    Limpar_Campos();
                    Limpar_Tabela(JTB_Devolucao_Prod);
                    BT_Salvar.setEnabled(false);
                    ObjControlSaida.Efetivar_Devolucao(JTF_Pesquisa.getText(),"SEM DEVOLUÇÃO");
                    JTF_Pesquisa.setText("");
                }
            }else{//se nao existir saída
                JTF_Pesquisa.setText("");
                Mostrar_Saida_Nao_Encontrada();
                Limpar_Campos();
                Limpar_Tabela(JTB_Devolucao_Prod);
                BT_Salvar.setEnabled(false);
                JTF_Pesquisa.setText("");
            }
        }else{
            Mostrar_Preencher_Campos();
        }
    }
    
    public final void Limpar_Tabela(JTable tb) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{};//Seta os indices da tabela
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        tb.setModel(tabela);
    }
    
    public void Testar_Campos_Salvar(){
        ObjControlSaida.Verifica_Devolucao_Efetivada(JL_Saida_Numero.getText());
        if(ObjControlSaida.Confirma_Devolucao==true){
            Mostrar_Dev_Ja_Efetivada();
            ObjControlSaida.Confirma_Devolucao=false;
        }
        else{
            Mostrar_Confirma_Salvar();                
        }
    }
    
    public void Conf_Inserir_Devolucao(){
        Inserir_Devolucao();
        if(Confirma_Devolucao == true){
            Mostrar_Dados_Salvos();
            new Controle_Log().Registrar_Log("efetivou a devolução referente a saída id: "+JL_Saida_Numero.getText()
                    +" - "+ObjModeloSaida.getTipo(), CodLogado);
            int id = Integer.parseInt(JL_Saida_Numero.getText());
            ObjControlSaida.Consulta_Saida_Devolucao(ObjModeloSaida, id);
            Limpar_Campos();
            Setar_Campos();
            BT_Salvar.setEnabled(false);
            ObjControlSaida.Verifica_Devolucao= false;
            Confirma_Devolucao=false;
        }else{
            Mostrar_Dados_Nao_Salvos();
            new Controle_Log().Registrar_Log("erro ao efetivar a devolução referente a saída id: "+JL_Saida_Numero.getText()
                    +" - "+ObjModeloSaida.getTipo(), CodLogado);
        }
    
    }
    
    public void Inserir_Devolucao(){
    try {
        //Conta quantas linha tem para inserção
        int Quant_Linhas = JTB_Devolucao_Prod.getRowCount();
        //Laço para fazer todas as inserçoes no banco de entrada de itens
            for(int Linha = 0; Linha < Quant_Linhas; Linha++){
                try {
                    JTB_Devolucao_Prod.addRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                                       
                    if(JTB_Devolucao_Prod.getValueAt(Linha, 4).equals("")){   //Produto sem validade 
                        
                        int Id_Produto = (Integer.valueOf(String.valueOf(JTB_Devolucao_Prod.getValueAt(Linha, 0))));//Pega o id do produto na linha da tabela
                        double Quant = Double.parseDouble(String.valueOf(JTB_Devolucao_Prod.getValueAt(Linha, 3)));//pega a quantidade na linha da tabela
                        String Validade = null;
                        String Lote = (String.valueOf(JTB_Devolucao_Prod.getValueAt(Linha, 4)));//pega o lote na linha da tabela
                        ObjControlSaida.Confirma_Devolucao=false;
                        ObjControlSaida.Atualiza_Estoque_Produto_Devolucao(Id_Produto, Quant, Lote,Validade);//atualiza o estoque
                        ObjControlSaida.Atualiza_Produto_Devolvido(Id_Produto, "SIM");//atualiza o produto para devolvido
                    }
                    else{//Com validade
                        int Id_Produto = (Integer.valueOf(String.valueOf(JTB_Devolucao_Prod.getValueAt(Linha, 0))));//Pega o id do produto na linha da tabela
                        double Quant = Double.parseDouble(String.valueOf(JTB_Devolucao_Prod.getValueAt(Linha, 3)));//pega a quantidade na linha da tabela
                        String Validade = (String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format
                        (new SimpleDateFormat("dd-MM-yyyy").parse((String) (JTB_Devolucao_Prod.getValueAt(Linha, 5))))));//pega a trata a data de validade
                        String Lote = (String.valueOf(JTB_Devolucao_Prod.getValueAt(Linha, 4)));//pega o lote na linha da tabela
                        ObjControlSaida.Confirma_Devolucao=false;
                        ObjControlSaida.Atualiza_Estoque_Produto_Devolucao(Id_Produto, Quant, Lote, Validade);
                        ObjControlSaida.Atualiza_Produto_Devolvido_Lote(Id_Produto, Lote, "SIM");
                    }
                } catch (NumberFormatException | ParseException | Error ex){JOptionPane.showMessageDialog(rootPane, "Erro No Laço: "+ex);}
            }
            Confirma_Devolucao=true;
            ObjControlSaida.Efetivar_Devolucao(JL_Saida_Numero.getText(),"EFETIVADA");
        } catch (Exception ex) {
            Confirma_Devolucao = false;
            JOptionPane.showMessageDialog(rootPane,"Erro na devolução de produtos!!!!! \n"+ex);
        }   
    }
    
    void Sair_Sem_Salvar(){
        if(JL_Status_Msg.getText().equalsIgnoreCase("ABERTO")){
            Mostrar_Sair_Sem_Salvar();
        }else{
            dispose();
        }
    }
    public void Setar_Campo_Id_Saida(Object id){
        JTF_Pesquisa.setText(String.valueOf(id));
    }
    
    //Mostrar as dialogs
    public void Mostrar_Dados_Salvos(){
        ObjDadosSalvos = new Inf_Dados_Salvos_Dev(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Dev(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    public void Mostrar_Saida_Nao_Encontrada(){
        ObjSaidaNaoEncontrada = new Inf_Saida_Nao_Encontrada_Dev(this, true);
        ObjSaidaNaoEncontrada.setVisible(true);
    }
    public void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Dev(this, true);
        ObjPreencherCampos.setVisible(true);
    }
    public void Mostrar_Nao_Existe_Prod_Dev(){
        ObjNaoExisteProdDev = new Inf_Nao_Existe_Prod_Dev(this, true);
        ObjNaoExisteProdDev.setVisible(true);
    }
    public void Mostrar_Dev_Ja_Efetivada(){
        ObjDevJaEfetivada = new Inf_Dev_Ja_Efetivada_Dev(this, true);
        ObjDevJaEfetivada.setVisible(true);
    }
    public void Mostrar_Confirma_Salvar(){
        ObjSalvar = new Conf_Salvar_Dev(this, true);
        ObjSalvar.setVisible(true);
    }
    public void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Dev(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    public void Mostrar_Consulta_Saida(){
        ObjConsSaida = new Tela_Consulta_Saida_Devolucao_DL(this, true);
        ObjConsSaida.setVisible(true);
    }
    
    public final void Preencher_Tabela(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Descrição","Categoria", "Quantidade","Lote","Validade"};//Seta os indices da tabela
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL(SQL);
            ObjConecta.rs.first();           
            do {  
                String data_val= "";
                ObjConecta2.Conectar();
                ObjConecta2.ExecutaSQL("select * from produto where id_produto = "+ObjConecta.rs.getInt("id_produto")+"");
                ObjConecta2.rs.first();
                String controle = ObjConecta2.rs.getString("solicita_devolucao");
                if(controle.equalsIgnoreCase("SIM")){
                    Date validade = ObjConecta.rs.getDate("validade");                
                    if(validade != null){data_val = String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta.rs.getDate("validade")));}
                }
                dados.add(new Object[]{ObjConecta.rs.getInt("id_produto"),ObjConecta.rs.getString("descricao"),
                ObjConecta.rs.getString("categoria"),ObjConecta.rs.getString("quantidade"),ObjConecta.rs.getString("lote"),
                data_val});
            } while (ObjConecta.rs.next());
            
            ObjConecta.Desconecta();
            ObjConecta2.Desconecta();
        } catch (SQLException ex) {ObjConecta.Desconecta();ObjConecta2.Desconecta();}
        
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Devolucao_Prod.setModel(tabela);
        JTB_Devolucao_Prod.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());//Colorir tabela
        JTB_Devolucao_Prod.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Devolucao_Prod.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Devolucao_Prod.getColumnModel().getColumn(1).setPreferredWidth(300);
        JTB_Devolucao_Prod.getColumnModel().getColumn(1).setResizable(false);
        JTB_Devolucao_Prod.getColumnModel().getColumn(2).setPreferredWidth(160);
        JTB_Devolucao_Prod.getColumnModel().getColumn(2).setResizable(false);
        JTB_Devolucao_Prod.getColumnModel().getColumn(3).setPreferredWidth(80);
        JTB_Devolucao_Prod.getColumnModel().getColumn(3).setResizable(false);
        JTB_Devolucao_Prod.getColumnModel().getColumn(4).setPreferredWidth(80);
        JTB_Devolucao_Prod.getColumnModel().getColumn(4).setResizable(false);
        JTB_Devolucao_Prod.getColumnModel().getColumn(5).setPreferredWidth(80);
        JTB_Devolucao_Prod.getColumnModel().getColumn(5).setResizable(false);
        JTB_Devolucao_Prod.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Devolucao_Prod.setAutoResizeMode(JTB_Devolucao_Prod.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Todas colunas)
        JTB_Devolucao_Prod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
    }
    
    public final void Setar_Atalho_BT(){
        //metodo para pegar a tecla pressionada
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),"Esc");
        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
        
        InputMap inputMap2 = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),"Consultar");
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
        BT_Procurar.doClick();
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
    private javax.swing.JLabel JL_Campos;
    private javax.swing.JLabel JL_Quant_Itens1;
    private javax.swing.JLabel JL_Saida;
    private javax.swing.JLabel JL_Saida_Numero;
    private javax.swing.JLabel JL_Status;
    private javax.swing.JLabel JL_Status_Msg;
    private javax.swing.JTable JTB_Devolucao_Prod;
    private javax.swing.JTextField JTF_Ano;
    private javax.swing.JTextField JTF_Curso;
    private javax.swing.JTextField JTF_Disciplina;
    private javax.swing.JTextField JTF_Disciplina_Semestre;
    private javax.swing.JTextField JTF_Observacao;
    private javax.swing.JTextField JTF_Pesquisa;
    private javax.swing.JTextField JTF_Semestre;
    private javax.swing.JTextField JTF_Tipo;
    private javax.swing.JTextField JTF_Turno;
    private javax.swing.JTextField JTF_Vestibular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

package GUI_Frames;

import Classes.Modelo_Saida_Produto;
import Classes.Modelo_Tabela;
import Classes.Modelo_Turma;
import Conexao.Conecta_Banco;
import Conexao.Controle_Log;
import Conexao.Controle_Saida_Produto;
import Conexao.Controle_Turma;
import GUI_Dialogs_Saida.Conf_Sair_Sem_Salvar_Saida_Cancel;
import GUI_Dialogs_Saida.Conf_Salvar_Saida_Cancel;
import GUI_Dialogs_Saida.Inf_Dados_Nao_Salvos_Saida_Cancel;
import GUI_Dialogs_Saida.Inf_Dados_Salvos_Saida_Cancel;
import GUI_Dialogs_Saida.Inf_Preencher_Campos_Saida_Cancel;
import GUI_Dialogs_Saida.Inf_Saida_Ja_Cancel;
import GUI_Dialogs_Saida.Inf_Saida_Nao_Encontrada_Cancel;
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
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

// @author Márison Tamiarana

public class Tela_Cancelar_Saida extends javax.swing.JInternalFrame {

    //metodo para abrir apenas uma instancia da janela
    public static Tela_Cancelar_Saida Obj;
    
    public void Open_Tela(){
        if(Obj==null){
            Obj = new Tela_Cancelar_Saida();
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
    private static Inf_Dados_Salvos_Saida_Cancel ObjDadosSalvos;
    private static Inf_Dados_Nao_Salvos_Saida_Cancel ObjDadosNaoSalvos;
    private static Inf_Saida_Nao_Encontrada_Cancel ObjSaidaNaoEncontrada;
    private static Inf_Preencher_Campos_Saida_Cancel ObjPreencherCampos;
    private static Inf_Saida_Ja_Cancel ObjSaidaJaCancel;
    private static Conf_Salvar_Saida_Cancel ObjSalvar;
    private static Conf_Sair_Sem_Salvar_Saida_Cancel ObjSairSemSalvar;
    private static Tela_Consulta_Saida_Cancela_DL ObjConsSaida;
    private static Tela_Consulta_Saida_Cancela_DL2 ObjConsSaida2;
    
    //Instancia das classes
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Conecta_Banco ObjConecta2 = new Conecta_Banco();
    Modelo_Saida_Produto ObjModeloSaida = new Modelo_Saida_Produto();
    Controle_Saida_Produto ObjControlSaida = new Controle_Saida_Produto();
    Formatacao ObjFormat = new Formatacao();
    Modelo_Turma ObjModTurma = new Modelo_Turma();
    Controle_Turma ObjControleTurma = new Controle_Turma();
    
    //Boolean para controles;
    public boolean confirma_cancelamento;
    public String pesquisa_saida;
    
    public Tela_Cancelar_Saida() {
        initComponents();
        Desabilita_Campos();
        JL_Saida.setVisible(false);
        JL_Saida_Numero.setText("");
        JL_Status.setVisible(false);
        JL_Status_Msg.setText("");
        BT_Salvar.setEnabled(false);
        JTF_Motivo.setDocument(ObjFormat.new Format_Geral(500));
        JTB_Saidas_Itens.setEnabled(false);
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
        JTB_Saidas_Itens = new javax.swing.JTable();
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
        jPanel3 = new javax.swing.JPanel();
        JTF_Motivo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        setIconifiable(true);
        setTitle("Cancelamento De Saída De Produto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Remove_24x24.png"))); // NOI18N
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

        JTB_Saidas_Itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Saidas_Itens.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTB_Saidas_Itens);

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)), "Cancelamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        JTF_Motivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Motivo*:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
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
                    .addComponent(jLabel15))
                .addContainerGap())
        );

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
                            .addComponent(JL_Status_Msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        Testar_Campos_Confirmar(JTF_Pesquisa.getText());
    }//GEN-LAST:event_JTF_PesquisaActionPerformed

    private void BT_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ConfirmarActionPerformed
        Testar_Campos_Confirmar(JTF_Pesquisa.getText());
    }//GEN-LAST:event_BT_ConfirmarActionPerformed

    private void BT_ProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_ProcurarActionPerformed
        Mostrar_Consulta_Saida2();
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
        JTF_Motivo.setText("");
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
        
        
    }public void Testar_Campos_Pesquisa(String id_saida){
        ObjControlSaida.Consulta_Saida_Id_Nao_Cancelada(Integer.parseInt(id_saida));//verifica se ja foi cancelada
        if(ObjControlSaida.Controle_Saida == true){//se existir saída
            ObjControlSaida.Controle_Saida = false;
            Limpar_Tabela(JTB_Saidas_Itens);
            Preencher_Tabela("select * from produto inner join categoria_produto "
                    + " on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                    + " inner join saida_itens on produto.id_produto = saida_itens.produto_id_produto "
                    + " where saida_id_saida=" + id_saida + "  ");
            Limpar_Campos();
            ObjControlSaida.Consulta_Saida_Devolucao(ObjModeloSaida, Integer.parseInt(id_saida));
            Setar_Campos();
            BT_Salvar.setEnabled(true);
            JTF_Pesquisa.setText("");
        }else{
            Limpar_Tabela(JTB_Saidas_Itens);
            Preencher_Tabela("select * from produto inner join categoria_produto "
                    + " on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                    + " inner join saida_itens on produto.id_produto = saida_itens.produto_id_produto "
                    + " where saida_id_saida=" + id_saida + "  ");
            Limpar_Campos();
            ObjControlSaida.Consulta_Saida_Devolucao(ObjModeloSaida, Integer.parseInt(id_saida));
            Setar_Campos();
            BT_Salvar.setEnabled(!true);
            JTF_Pesquisa.setText("");
            JTF_Pesquisa.requestFocus();
            Mostrar_Saida_Ja_Cancelada();
        }
    }
    
    public void Testar_Campos_Confirmar(String id_saida){
        if(!JTF_Pesquisa.getText().equalsIgnoreCase("")){//se o campo nao estiver em branco
            ObjControlSaida.Consulta_Saida_Id(Integer.parseInt(id_saida));//consulta se existe pelo menos uma saída
            if(ObjControlSaida.Controle_Saida == true){//se existir saída
                ObjControlSaida.Controle_Saida = false;
                ObjControlSaida.Consulta_Saida_Id_Nao_Cancelada(Integer.parseInt(id_saida));//verifica se ja foi cancelada
                if(ObjControlSaida.Controle_Saida == true){//se existir saída
                    ObjControlSaida.Controle_Saida = false;
                    Limpar_Tabela(JTB_Saidas_Itens);
                    Preencher_Tabela("select * from produto inner join categoria_produto "
                        + " on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                        + " inner join saida_itens on produto.id_produto = saida_itens.produto_id_produto "
                        + " where saida_id_saida="+id_saida+"  ");
                    Limpar_Campos();
                    ObjControlSaida.Consulta_Saida_Devolucao(ObjModeloSaida, Integer.parseInt(id_saida));
                    Setar_Campos();
                    BT_Salvar.setEnabled(true);
                    JTF_Pesquisa.setText("");
                    JTF_Motivo.requestFocus();
                }else{
                    Limpar_Tabela(JTB_Saidas_Itens);
                    Preencher_Tabela("select * from produto inner join categoria_produto "
                        + " on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                        + " inner join saida_itens on produto.id_produto = saida_itens.produto_id_produto "
                        + " where saida_id_saida="+id_saida+"  ");
                    Limpar_Campos();
                    ObjControlSaida.Consulta_Saida_Devolucao(ObjModeloSaida, Integer.parseInt(id_saida));
                    Setar_Campos();
                    BT_Salvar.setEnabled(!true);
                    JTF_Pesquisa.setText("");                   
                    Mostrar_Saida_Ja_Cancelada();
                }
                   
            } else {                               
               BT_Salvar.setEnabled(false);
               Limpar_Campos();
               Limpar_Tabela(JTB_Saidas_Itens);
               JTF_Pesquisa.setText("");
               JTF_Pesquisa.requestFocus();
               Mostrar_Saida_Nao_Encontrada();
               JTF_Pesquisa.requestFocus();               
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
        if(JL_Status_Msg.getText().equalsIgnoreCase("CANCELADA")){
            Mostrar_Saida_Ja_Cancelada();
        }else if(JTF_Tipo.getText().equalsIgnoreCase("") || JL_Saida_Numero.getText().equalsIgnoreCase("") 
                 || JTF_Motivo.getText().equalsIgnoreCase("")){
            Mostrar_Preencher_Campos();
        }else{
            Mostrar_Confirma_Salvar();      
        }
    }
    
    public void Conf_Inserir_Devolucao(){
        Cancelar_Saida();
        if(confirma_cancelamento == true){
            Mostrar_Dados_Salvos();
            try {ObjControleTurma.Consulta_Turma_Concat(ObjModTurma, ObjModeloSaida.getTurma_id_turma());} catch (SQLException ex) {}
            //log
            new Controle_Log().Registrar_Log("cancelou a saída id: "+JL_Saida_Numero.getText()
                    +" - "+JTF_Tipo.getText()+" (curso: "+JTF_Curso.getText()
                    +" - turma: "+ObjModTurma.getPesquisa()
                    +" - Disciplina: "+JTF_Disciplina.getText()+")", CodLogado);
            
            int id_saida = Integer.parseInt(JL_Saida_Numero.getText());
            Limpar_Tabela(JTB_Saidas_Itens);
                    Preencher_Tabela("select * from produto inner join categoria_produto "
                        + " on produto.Categoria_Produto_id_categoria = categoria_produto.id_categoria "
                        + " inner join saida_itens on produto.id_produto = saida_itens.produto_id_produto "
                        + " where saida_id_saida="+id_saida+"  ");
            Limpar_Campos();
            ObjControlSaida.Consulta_Saida_Devolucao(ObjModeloSaida,(id_saida));
            Setar_Campos();
            BT_Salvar.setEnabled(!true);
            JTF_Pesquisa.setText("");   
            confirma_cancelamento=false;
        }else{
            Mostrar_Dados_Nao_Salvos();
            new Controle_Log().Registrar_Log("erro ao cancelar a saída id: "+JL_Saida_Numero.getText()
                    +" - "+JTF_Tipo.getText(), CodLogado);
        }
    
    }
    
    public void Cancelar_Saida(){
        try {
            //Setar o id
            int Id_Saida = Integer.parseInt(JL_Saida_Numero.getText());
            //Conta quantas linha tem para inserção
            int Quant_Linhas = JTB_Saidas_Itens.getRowCount();
            //Laço para fazer todas as inserçoes no banco de entrada de itens
            try {
                for(int Linha = 0; Linha < Quant_Linhas; Linha++){                
                    JTB_Saidas_Itens.setRowSelectionInterval(Linha,Linha); //seta na primeira linha da tabela
                    if(JTB_Saidas_Itens.getValueAt(Linha, 5).equals("")){   //Produto sem validade 
                        try{    
                            int Id_Produto = Integer.valueOf(String.valueOf(JTB_Saidas_Itens.getValueAt(Linha, 0)));//Pega o id do produto na linha da tabela
                            double Quant = Double.parseDouble(String.valueOf(JTB_Saidas_Itens.getValueAt(Linha, 3)));//pega a quantidade na linha da tabela
                            String Validade = null;
                            String Lote = (String.valueOf(JTB_Saidas_Itens.getValueAt(Linha, 5)));//pega o lote na linha da tabela

                            ObjControlSaida.Atualiza_Estoque_Produto_Saida_Cancela(Id_Produto, Quant, Lote,Validade);//atualiza o estoque
                            ObjControlSaida.Inserir_Saida_Itens_Cancelamento(Id_Produto, Id_Saida, Quant, Lote, Validade);//inseri os itens cancelados

                        }catch(NumberFormatException | Error ex){JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar o estoque iten!\n"+ex);}                    
                    }else{//Com validade
                        try {
                            int Id_Produto = (Integer.valueOf(String.valueOf(JTB_Saidas_Itens.getValueAt(Linha, 0))));//Pega o id do produto na linha da tabela
                            double Quant = Double.parseDouble(String.valueOf(JTB_Saidas_Itens.getValueAt(Linha, 3)));//pega a quantidade na linha da tabela
                            String Validade = (String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format
                            (new SimpleDateFormat("dd-MM-yyyy").parse((String) (JTB_Saidas_Itens.getValueAt(Linha, 6))))));//pega a trata a data de validade
                            String Lote = (String.valueOf(JTB_Saidas_Itens.getValueAt(Linha, 5)));//pega o lote na linha da tabela

                            ObjControlSaida.Atualiza_Estoque_Produto_Saida_Cancela(Id_Produto, Quant, Lote,Validade);//atualiza o estoque
                            ObjControlSaida.Inserir_Saida_Itens_Cancelamento(Id_Produto, Id_Saida, Quant, Lote, Validade);//inseri os itens cancelados
                            
                        }catch(NumberFormatException | ParseException | Error ex){JOptionPane.showMessageDialog(rootPane, "Erro ao atualizar o estoque com lote iten!\n"+ex);}              
                    }
                }
                confirma_cancelamento = true;//confirma o cancelamento                
            } catch (NumberFormatException | Error ex){
                JOptionPane.showMessageDialog(rootPane, "Erro No Laço: "+ex);
                confirma_cancelamento = false;
            }            
            if(confirma_cancelamento == true){
                ObjControlSaida.Efetivar_Situacao(JL_Saida_Numero.getText(),"CANCELADA");
                ObjControlSaida.Atualiza_Data_Alteracao_Saida(Id_Saida);//altera a data de alteração
                ObjControlSaida.Inserir_Motivo_Saida_Cancelada(Id_Saida, JTF_Motivo.getText().trim());
            }
        } catch (NumberFormatException | HeadlessException ex) {
            confirma_cancelamento = false;
            JOptionPane.showMessageDialog(rootPane,"Erro na devolução de produtos!!!!! \n"+ex);
        }   
    }
    
    void Sair_Sem_Salvar(){
        if(!JL_Status_Msg.getText().equalsIgnoreCase("")  && !JL_Status_Msg.getText().equalsIgnoreCase("CANCELADA")){
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
        ObjDadosSalvos = new Inf_Dados_Salvos_Saida_Cancel(this, true);
        ObjDadosSalvos.setVisible(true);
    }
    public void Mostrar_Dados_Nao_Salvos(){
        ObjDadosNaoSalvos = new Inf_Dados_Nao_Salvos_Saida_Cancel(this, true);
        ObjDadosNaoSalvos.setVisible(true);
    }
    public void Mostrar_Saida_Nao_Encontrada(){
        ObjSaidaNaoEncontrada = new Inf_Saida_Nao_Encontrada_Cancel(this, true);
        ObjSaidaNaoEncontrada.setVisible(true);
    }
    public void Mostrar_Preencher_Campos(){
        ObjPreencherCampos = new Inf_Preencher_Campos_Saida_Cancel(this, true);
        ObjPreencherCampos.setVisible(true);
    }    
    public void Mostrar_Saida_Ja_Cancelada(){
        ObjSaidaJaCancel = new Inf_Saida_Ja_Cancel(this, true);
        ObjSaidaJaCancel.setVisible(true);
    }
    public void Mostrar_Confirma_Salvar(){
        ObjSalvar = new Conf_Salvar_Saida_Cancel(this, true);
        ObjSalvar.setVisible(true);
    }
    public void Mostrar_Sair_Sem_Salvar(){
        ObjSairSemSalvar = new Conf_Sair_Sem_Salvar_Saida_Cancel(this, true);
        ObjSairSemSalvar.setVisible(true);
    }
    public void Mostrar_Consulta_Saida(){
        ObjConsSaida = new Tela_Consulta_Saida_Cancela_DL(this, true);
        ObjConsSaida.setVisible(true);
    }
    public void Mostrar_Consulta_Saida2(){
        ObjConsSaida2 = new Tela_Consulta_Saida_Cancela_DL2(this, true);
        ObjConsSaida2.setVisible(true);
    }
    
    public final void Preencher_Tabela(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Código", "Descrição","Categoria", "Quantidade","Un","Lote","Validade"};//Seta os indices da tabela
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL(SQL);
            ObjConecta.rs.first();           
            do {  
                String data_val= "";
                Date validade = ObjConecta.rs.getDate("validade");                
                if(validade != null){data_val = String.valueOf(new SimpleDateFormat("dd-MM-yyyy").format(ObjConecta.rs.getDate("validade")));}
                
                dados.add(new Object[]{ObjConecta.rs.getInt("id_produto"),ObjConecta.rs.getString("descricao"),
                ObjConecta.rs.getString("categoria"),ObjConecta.rs.getString("quantidade"),ObjConecta.rs.getString("unidade"),
                ObjConecta.rs.getString("lote"), data_val});
            } while (ObjConecta.rs.next());
            
            ObjConecta.Desconecta();
        } catch (SQLException ex) {ObjConecta.Desconecta();}
        
        Modelo_Tabela tabela = new Modelo_Tabela(dados, Colunas);
        JTB_Saidas_Itens.setModel(tabela);
        JTB_Saidas_Itens.setDefaultRenderer(Object.class, new Pintar_Tabela_Padrao());//Colorir tabela
        JTB_Saidas_Itens.getColumnModel().getColumn(0).setPreferredWidth(80);//Tamanho da coluna
        JTB_Saidas_Itens.getColumnModel().getColumn(0).setResizable(false);//Redimensionavel
        JTB_Saidas_Itens.getColumnModel().getColumn(1).setPreferredWidth(300);
        JTB_Saidas_Itens.getColumnModel().getColumn(1).setResizable(false);
        JTB_Saidas_Itens.getColumnModel().getColumn(2).setPreferredWidth(160);
        JTB_Saidas_Itens.getColumnModel().getColumn(2).setResizable(false);
        JTB_Saidas_Itens.getColumnModel().getColumn(3).setPreferredWidth(80);
        JTB_Saidas_Itens.getColumnModel().getColumn(3).setResizable(false);
        JTB_Saidas_Itens.getColumnModel().getColumn(4).setPreferredWidth(40);
        JTB_Saidas_Itens.getColumnModel().getColumn(4).setResizable(false);
        JTB_Saidas_Itens.getColumnModel().getColumn(5).setPreferredWidth(80);
        JTB_Saidas_Itens.getColumnModel().getColumn(5).setResizable(false);
        JTB_Saidas_Itens.getColumnModel().getColumn(6).setPreferredWidth(100);
        JTB_Saidas_Itens.getColumnModel().getColumn(6).setResizable(false);
        JTB_Saidas_Itens.getTableHeader().setReorderingAllowed(false);//Reordenar alocação
        JTB_Saidas_Itens.setAutoResizeMode(JTB_Saidas_Itens.AUTO_RESIZE_ALL_COLUMNS);//Tabela Redimensionavel(Todas colunas)
        JTB_Saidas_Itens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Seleciona uma unica linha da tabela
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
    private javax.swing.JTable JTB_Saidas_Itens;
    private javax.swing.JTextField JTF_Ano;
    private javax.swing.JTextField JTF_Curso;
    private javax.swing.JTextField JTF_Disciplina;
    private javax.swing.JTextField JTF_Disciplina_Semestre;
    private javax.swing.JTextField JTF_Motivo;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

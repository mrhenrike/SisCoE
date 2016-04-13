package GUI_Frames;

//@author Márison Tamiarana

import Conexao.Conecta_Banco;
import Conexao.Controle_Log;
import Conexao.Controle_Lote_Estoque;
import Conexao.Controle_Relatorio_Curso_Turma_Disciplina;
import Conexao.Controle_Relatorio_Entradas;
import Conexao.Controle_Relatorio_Produto;
import Conexao.Controle_Saida_Produto;
import Conexao.Controle_Usuario;
import GUI_Dialogs_Principal.Inf_Abaixo_Do_Minimo_TP;
import GUI_Dialogs_Principal.Inf_Cad_Usuario_TP;
import GUI_Dialogs_Principal.Inf_Dev_Pendente_TP;
import GUI_Dialogs_Principal.Inf_Escolher_Entrada_TP;
import GUI_Dialogs_Principal.Inf_Mensagens;
import GUI_Dialogs_Principal.Inf_Prod_Vencido_TP;
import GUI_Dialogs_Principal.Inf_Vencimento_TP;
import GUI_Dialogs_Principal.Logoff;
import GUI_Dialogs_Principal.Logout_User_TP;
import GUI_Dialogs_Principal.Sobre;
import Metodos.Metodos;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import java.awt.Font;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import org.jvnet.substance.skin.SubstanceAutumnLookAndFeel;
import org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel;
import org.jvnet.substance.skin.SubstanceMagmaLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel;


public final class Tela_Principal extends javax.swing.JFrame {
   
//Metodo para permitir apenas uma intancia da Tela Principal
public static Tela_Principal TP;

    public static Tela_Principal getInstancia(){
        if(TP==null){
            TP = new Tela_Principal();
        }
    return TP;
    }
    public static JDesktopPane getPainel(){
           return getInstancia().Area_Trabalho_Pricinpal;
    }
    
    //Instacia de objetos do tipo dialog
    private static Logoff DLLogoff;
    private static Sobre DLSobre;
    private static Tela_Finalizando DLFim;
    private static Tela_Finalizando_Iniciando DLFimInicio;
    private static Tela_Login DLLogin;
    private static Inf_Abaixo_Do_Minimo_TP DLAbaixoDoMinimo;
    private static Inf_Prod_Vencido_TP DLProdVencido;
    private static Inf_Vencimento_TP DLVencimento;
    private static Inf_Dev_Pendente_TP DLDevPendente;
    private static Inf_Cad_Usuario_TP DLCadUsuario;
    private static Tela_Bloqueio DLBloqueio;
    private static Logout_User_TP DLLogout;
    private static Inf_Mensagens DLMensagem;
    private static Inf_Escolher_Entrada_TP DLEscolherEntrada;
    
    public static String UserLogado;
    public static String PermissaoLogado;
    public static String CodLogado;
    
    public static boolean Abaixo_30 = false;
    public static boolean Vencido = false;
    public static boolean Abaixo_Minimo = false;
    public static boolean Devolucao_Pendente = false;
        
    //Instanciando objetos de outras classes para usar os metodos dessa classe
    Metodos ObjMetodo = new Metodos(); 
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Controle_Usuario ObjControleUser = new Controle_Usuario();
    Controle_Log ObjControleLog = new Controle_Log();
    
     
    public Tela_Principal() {
        initComponents();
        //Seta imagem na tela principal
        setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Logo - SisCoE 2.png")).getImage());
                 
        this.setExtendedState(this.MAXIMIZED_BOTH);//tela principal maximizada:
        setLocationRelativeTo(null);//Função de abrir a tela no centro
                
        //Metodo para mostrar a hora e a data no sistema
        Metodos.start(JL_Hora,"HH:mm:ss");//Metodo Static nao precisa usar objeto.
        Metodos.start(JL_Data, "EEEE',' dd' de 'MMMM' de 'yyyy");
        
        JL_Cod.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        JRB_Padrao.setSelected(true);
    }
    
    
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BG_Menu = new javax.swing.ButtonGroup();
        JP_Data_Hora_Sistema = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JL_Usuario = new javax.swing.JLabel();
        JL_Data = new javax.swing.JLabel();
        JL_Hora = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JL_Permissao = new javax.swing.JLabel();
        JL_Cod = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Area_Trabalho_Pricinpal = new javax.swing.JDesktopPane();
        JL_Logo_Fcat = new javax.swing.JLabel();
        JL_Logo_Estacio = new javax.swing.JLabel();
        JL_Logo_ADS = new javax.swing.JLabel();
        JL_Logo_Coolab2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JP_Acesso_Rapido = new javax.swing.JPanel();
        BT_CD_Produto = new javax.swing.JButton();
        BT_CD_Usuario = new javax.swing.JButton();
        BT_Ent_Produto = new javax.swing.JButton();
        BT_Saida_Prod = new javax.swing.JButton();
        BT_Cons_Prod = new javax.swing.JButton();
        BT_Encerrar = new javax.swing.JButton();
        BT_Devolucao = new javax.swing.JButton();
        BT_Alertas = new javax.swing.JButton();
        Menu_Principal = new javax.swing.JMenuBar();
        MP_Cadastrar = new javax.swing.JMenu();
        CD_Produto = new javax.swing.JMenuItem();
        CD_Usuário = new javax.swing.JMenuItem();
        CD_Turma = new javax.swing.JMenuItem();
        MP_Consultar = new javax.swing.JMenu();
        CS_Produto = new javax.swing.JMenuItem();
        CS_Turma = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        CS_Usuario = new javax.swing.JMenuItem();
        CS_Log = new javax.swing.JMenuItem();
        MP_Relatorio = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        Relat_Usuario = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        Relat_Log = new javax.swing.JMenuItem();
        MP_Serv = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        Serv_Entrada = new javax.swing.JMenuItem();
        Serv_Entrada1 = new javax.swing.JMenuItem();
        Serv_Cancela_Entrada = new javax.swing.JMenuItem();
        Serv_Saida = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Serv_AjustaEstoque = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Serv_Altera_Senha = new javax.swing.JMenuItem();
        Serv_Ativa = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jRadioButtonMenuItem13 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem14 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem15 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem16 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem17 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem23 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem20 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem21 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem22 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem12 = new javax.swing.JRadioButtonMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jRadioButtonMenuItem5 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem6 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem7 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem8 = new javax.swing.JRadioButtonMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jRadioButtonMenuItem9 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem10 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem11 = new javax.swing.JRadioButtonMenuItem();
        jMenu11 = new javax.swing.JMenu();
        JRB_Padrao = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem18 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem19 = new javax.swing.JRadioButtonMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem4 = new javax.swing.JRadioButtonMenuItem();
        MP_Sair = new javax.swing.JMenu();
        Sair_Logout = new javax.swing.JMenuItem();
        Sair_Bloquear = new javax.swing.JMenuItem();
        Sair_Encerrar = new javax.swing.JMenuItem();
        MP_Ajuda = new javax.swing.JMenu();
        Aj_Sobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COOLAB - Coordenação de Laboratórios da FCAT");
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("Menu Principal"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JP_Data_Hora_Sistema.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/User 22x22.png"))); // NOI18N

        JL_Usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        JL_Data.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JL_Data.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        JL_Hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JL_Hora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Permissao 22 x 22.png"))); // NOI18N

        JL_Permissao.setBackground(new java.awt.Color(255, 255, 255));
        JL_Permissao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        JL_Cod.setBackground(new java.awt.Color(255, 255, 255));
        JL_Cod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JL_Cod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Relogio 22x22.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Calendario 22x22.png"))); // NOI18N

        javax.swing.GroupLayout JP_Data_Hora_SistemaLayout = new javax.swing.GroupLayout(JP_Data_Hora_Sistema);
        JP_Data_Hora_Sistema.setLayout(JP_Data_Hora_SistemaLayout);
        JP_Data_Hora_SistemaLayout.setHorizontalGroup(
            JP_Data_Hora_SistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Data_Hora_SistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Permissao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JL_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        JP_Data_Hora_SistemaLayout.setVerticalGroup(
            JP_Data_Hora_SistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Data_Hora_SistemaLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(JP_Data_Hora_SistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JP_Data_Hora_SistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Data_Hora_SistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(JL_Permissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Cod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Area_Trabalho_Pricinpal.setBackground(new java.awt.Color(255, 255, 255));
        Area_Trabalho_Pricinpal.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        Area_Trabalho_Pricinpal.setForeground(new java.awt.Color(255, 255, 255));
        Area_Trabalho_Pricinpal.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        Area_Trabalho_Pricinpal.setMinimumSize(new java.awt.Dimension(1000, 0));
        Area_Trabalho_Pricinpal.setPreferredSize(new java.awt.Dimension(1000, 610));

        JL_Logo_Fcat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/fcat.png"))); // NOI18N

        JL_Logo_Estacio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_Logo_Estacio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Logo Estacio 250 x 100.png"))); // NOI18N
        JL_Logo_Estacio.setAlignmentY(0.0F);
        JL_Logo_Estacio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        JL_Logo_ADS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_Logo_ADS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/LogoADSN.png"))); // NOI18N
        JL_Logo_ADS.setAlignmentY(0.0F);
        JL_Logo_ADS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        JL_Logo_Coolab2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_Logo_Coolab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Logo Coolab 250 x 100.png"))); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Logo - SisCoE 4.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout Area_Trabalho_PricinpalLayout = new javax.swing.GroupLayout(Area_Trabalho_Pricinpal);
        Area_Trabalho_Pricinpal.setLayout(Area_Trabalho_PricinpalLayout);
        Area_Trabalho_PricinpalLayout.setHorizontalGroup(
            Area_Trabalho_PricinpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Area_Trabalho_PricinpalLayout.createSequentialGroup()
                .addGroup(Area_Trabalho_PricinpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Area_Trabalho_PricinpalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JL_Logo_ADS, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(JL_Logo_Coolab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(JL_Logo_Estacio, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(JL_Logo_Fcat)))
                .addContainerGap())
        );
        Area_Trabalho_PricinpalLayout.setVerticalGroup(
            Area_Trabalho_PricinpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Area_Trabalho_PricinpalLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Area_Trabalho_PricinpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_Logo_Fcat)
                    .addComponent(JL_Logo_Estacio)
                    .addComponent(JL_Logo_ADS)
                    .addComponent(JL_Logo_Coolab2))
                .addGap(36, 36, 36))
        );
        Area_Trabalho_Pricinpal.setLayer(JL_Logo_Fcat, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Area_Trabalho_Pricinpal.setLayer(JL_Logo_Estacio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Area_Trabalho_Pricinpal.setLayer(JL_Logo_ADS, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Area_Trabalho_Pricinpal.setLayer(JL_Logo_Coolab2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Area_Trabalho_Pricinpal.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        JP_Acesso_Rapido.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        BT_CD_Produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Produto.png"))); // NOI18N
        BT_CD_Produto.setToolTipText("Clique Para Cadastrar Novo Produto Ou Pressione Crt + F2");
        BT_CD_Produto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Produto Press.png"))); // NOI18N
        BT_CD_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CD_ProdutoActionPerformed(evt);
            }
        });

        BT_CD_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Usuario.png"))); // NOI18N
        BT_CD_Usuario.setToolTipText("Clique Para Cadastrar Novo Usuario Ou Pressione Crt + F3");
        BT_CD_Usuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Usuario Press.png"))); // NOI18N
        BT_CD_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CD_UsuarioActionPerformed(evt);
            }
        });

        BT_Ent_Produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Entrada.png"))); // NOI18N
        BT_Ent_Produto.setToolTipText("Clique Para Esclher O Tipo De Entrada Ou Pressione Crt + F6 (Nova Entrada) Ou Crt+F10 (Continuar Entrada)");
        BT_Ent_Produto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Entrada Press.png"))); // NOI18N
        BT_Ent_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Ent_ProdutoActionPerformed(evt);
            }
        });

        BT_Saida_Prod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Saida 2.png"))); // NOI18N
        BT_Saida_Prod.setToolTipText("Clique Para Efetuar Nova Saída Ou Pressione Crt + F7");
        BT_Saida_Prod.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Saida Press 2.png"))); // NOI18N
        BT_Saida_Prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Saida_ProdActionPerformed(evt);
            }
        });

        BT_Cons_Prod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/CS Produto.png"))); // NOI18N
        BT_Cons_Prod.setToolTipText("Clique Para Consultar Os Produtos Ou Pressione Crt + F4");
        BT_Cons_Prod.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/CS Produto Press.png"))); // NOI18N
        BT_Cons_Prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Cons_ProdActionPerformed(evt);
            }
        });

        BT_Encerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Sair Encerrar.png"))); // NOI18N
        BT_Encerrar.setToolTipText("Clique Para Encerrar O Sistema Ou Pressione Alt + F4");
        BT_Encerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Sair Encerrar Press.png"))); // NOI18N
        BT_Encerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_EncerrarActionPerformed(evt);
            }
        });

        BT_Devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Devolucao.png"))); // NOI18N
        BT_Devolucao.setToolTipText("Clique Para Efetuar Devolução De Produto Ou Pressione Crt + F8");
        BT_Devolucao.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Devolucao Press.png"))); // NOI18N
        BT_Devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_DevolucaoActionPerformed(evt);
            }
        });

        BT_Alertas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/BT Alertas.png"))); // NOI18N
        BT_Alertas.setToolTipText("Clique Para Verificar Os Alertas Ou Pressione Alt + G");
        BT_Alertas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/BT Alertas Press.png"))); // NOI18N
        BT_Alertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AlertasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Acesso_RapidoLayout = new javax.swing.GroupLayout(JP_Acesso_Rapido);
        JP_Acesso_Rapido.setLayout(JP_Acesso_RapidoLayout);
        JP_Acesso_RapidoLayout.setHorizontalGroup(
            JP_Acesso_RapidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Acesso_RapidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Acesso_RapidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BT_CD_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_CD_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Ent_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Saida_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Cons_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Encerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Alertas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_Acesso_RapidoLayout.setVerticalGroup(
            JP_Acesso_RapidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Acesso_RapidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BT_CD_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_CD_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_Ent_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_Saida_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_Cons_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_Devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_Alertas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_Encerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu_Principal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        Menu_Principal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        MP_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Add_24x24.png"))); // NOI18N
        MP_Cadastrar.setMnemonic('d');
        MP_Cadastrar.setText("Cadastrar");
        MP_Cadastrar.setToolTipText("Módulo De Cadastros (Alt + D)");
        MP_Cadastrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        CD_Produto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        CD_Produto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CD_Produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Prod 24x24.png"))); // NOI18N
        CD_Produto.setText("Produto");
        CD_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CD_ProdutoActionPerformed(evt);
            }
        });
        MP_Cadastrar.add(CD_Produto);

        CD_Usuário.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_MASK));
        CD_Usuário.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CD_Usuário.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/User 24x24.png"))); // NOI18N
        CD_Usuário.setText("Usuário");
        CD_Usuário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CD_UsuárioActionPerformed(evt);
            }
        });
        MP_Cadastrar.add(CD_Usuário);

        CD_Turma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        CD_Turma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CD_Turma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Curso 24x24.png"))); // NOI18N
        CD_Turma.setText("Curso - Turma - Disciplina");
        CD_Turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CD_TurmaActionPerformed(evt);
            }
        });
        MP_Cadastrar.add(CD_Turma);

        Menu_Principal.add(MP_Cadastrar);

        MP_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Search_24x24.png"))); // NOI18N
        MP_Consultar.setMnemonic('t');
        MP_Consultar.setText("Consultar");
        MP_Consultar.setToolTipText("Módulo De Consultas (Alt + T)");
        MP_Consultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        CS_Produto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        CS_Produto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CS_Produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Prod 24x24.png"))); // NOI18N
        CS_Produto.setText("Produto");
        CS_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CS_ProdutoActionPerformed(evt);
            }
        });
        MP_Consultar.add(CS_Produto);

        CS_Turma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        CS_Turma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CS_Turma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Curso 24x24.png"))); // NOI18N
        CS_Turma.setText("Curso - Turma - Disciplina");
        CS_Turma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CS_TurmaActionPerformed(evt);
            }
        });
        MP_Consultar.add(CS_Turma);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Entrada Mercadoria 24x24.png"))); // NOI18N
        jMenuItem3.setText("Entrada");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MP_Consultar.add(jMenuItem3);

        jMenuItem25.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Saida Mercadoria 24x24.png"))); // NOI18N
        jMenuItem25.setText("Saída");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        MP_Consultar.add(jMenuItem25);
        MP_Consultar.add(jSeparator7);

        CS_Usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_MASK));
        CS_Usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CS_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/User 24x24.png"))); // NOI18N
        CS_Usuario.setText("Usuário");
        CS_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CS_UsuarioActionPerformed(evt);
            }
        });
        MP_Consultar.add(CS_Usuario);

        CS_Log.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        CS_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CS_Log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Log 24x24.png"))); // NOI18N
        CS_Log.setText("Log do Sistema");
        CS_Log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CS_LogActionPerformed(evt);
            }
        });
        MP_Consultar.add(CS_Log);

        Menu_Principal.add(MP_Consultar);

        MP_Relatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Relatorios 24x24.png"))); // NOI18N
        MP_Relatorio.setMnemonic('i');
        MP_Relatorio.setText("Relatório");
        MP_Relatorio.setToolTipText("Módulo De Relátorios (Alt + I)");
        MP_Relatorio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Relatorio - Entrada 24x24.png"))); // NOI18N
        jMenu3.setText("Entrada");
        jMenu3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem1.setText("Todas Entradas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem4.setText("Últimos 30 Dias");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem8.setText("Por Período");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem9.setText("Número da Entrada");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        MP_Relatorio.add(jMenu3);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Relatório - Saida 24x24.png"))); // NOI18N
        jMenu5.setText("Saída");
        jMenu5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem6.setText("Todas Saídas");
        jMenu5.add(jMenuItem6);

        jMenuItem14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem14.setText("Últimos 30 Dias");
        jMenu5.add(jMenuItem14);

        jMenuItem18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem18.setText("Por Período");
        jMenu5.add(jMenuItem18);

        jMenuItem19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem19.setText("Número da Saída");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem19);

        jMenuItem20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem20.setText("Por Curso");
        jMenu5.add(jMenuItem20);

        jMenuItem21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem21.setText("Por Turma");
        jMenu5.add(jMenuItem21);

        jMenuItem22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem22.setText("Por Disciplina");
        jMenu5.add(jMenuItem22);

        MP_Relatorio.add(jMenu5);
        MP_Relatorio.add(jSeparator1);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Estoque 24x24.png"))); // NOI18N
        jMenu4.setText("Estoque");
        jMenu4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem7.setText("Analítico");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem13.setText("Sintético");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuItem27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem27.setText("Abaixo Do Mínimo");
        jMenu4.add(jMenuItem27);

        jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem23.setText("Sem Estoque");
        jMenu4.add(jMenuItem23);

        jMenuItem28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem28.setText("Produtos Vencidos");
        jMenu4.add(jMenuItem28);

        jMenuItem29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem29.setText("Vencimento Abaixo 30 Dias");
        jMenu4.add(jMenuItem29);

        MP_Relatorio.add(jMenu4);
        MP_Relatorio.add(jSeparator3);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Prod 24x24.png"))); // NOI18N
        jMenu2.setText("Produto");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenu12.setText("Todos");
        jMenu12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenuItem30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem30.setText("Paisagem");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem30);

        jMenuItem31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem31.setText("Retrato");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem31);

        jMenu2.add(jMenu12);

        jMenu13.setText("Ativos");
        jMenu13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenuItem32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem32.setText("Paisagem");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem32);

        jMenuItem33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem33.setText("Retrato");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem33);

        jMenu2.add(jMenu13);

        jMenu14.setText("Inativos");
        jMenu14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenuItem34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem34.setText("Paisagem");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem34);

        jMenuItem35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem35.setText("Retrato");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem35);

        jMenu2.add(jMenu14);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem12.setText("Entrada Por Período");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem15.setText("Saída Por Período");
        jMenu2.add(jMenuItem15);

        jMenu6.setText("Por Categoria");
        jMenu6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenuItem16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem16.setText("Todas Categorias");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem16);

        jMenuItem17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem17.setText("Selecionar Categoria");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);

        jMenu2.add(jMenu6);

        MP_Relatorio.add(jMenu2);
        MP_Relatorio.add(jSeparator8);

        Relat_Usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Relat_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/User 24x24.png"))); // NOI18N
        Relat_Usuario.setText("Usuário");
        Relat_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Relat_UsuarioActionPerformed(evt);
            }
        });
        MP_Relatorio.add(Relat_Usuario);
        MP_Relatorio.add(jSeparator6);

        jMenu15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Curso 24x24.png"))); // NOI18N
        jMenu15.setText("Acadêmico");
        jMenu15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenuItem10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem10.setText("Curso");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem10);

        jMenuItem38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem38.setText("Disciplina");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem38);

        jMenuItem11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem11.setText("Turma");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem11);

        MP_Relatorio.add(jMenu15);

        Relat_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Relat_Log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Log 24x24.png"))); // NOI18N
        Relat_Log.setText("Log do Sistema");
        Relat_Log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Relat_LogActionPerformed(evt);
            }
        });
        MP_Relatorio.add(Relat_Log);

        Menu_Principal.add(MP_Relatorio);

        MP_Serv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png"))); // NOI18N
        MP_Serv.setMnemonic('v');
        MP_Serv.setText("Serviços");
        MP_Serv.setToolTipText("Módulo De Serviços (Alt + V)");
        MP_Serv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Entrada Mercadoria 24x24.png"))); // NOI18N
        jMenu1.setText("Entrada de Produto");
        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Serv_Entrada.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.CTRL_MASK));
        Serv_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_Entrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Add Prod 24x24.png"))); // NOI18N
        Serv_Entrada.setText("Nova Entrada");
        Serv_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_EntradaActionPerformed(evt);
            }
        });
        jMenu1.add(Serv_Entrada);

        Serv_Entrada1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, java.awt.event.InputEvent.CTRL_MASK));
        Serv_Entrada1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_Entrada1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Edit 22 x 22.png"))); // NOI18N
        Serv_Entrada1.setText("Continuar Entrada");
        Serv_Entrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_Entrada1ActionPerformed(evt);
            }
        });
        jMenu1.add(Serv_Entrada1);

        Serv_Cancela_Entrada.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        Serv_Cancela_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_Cancela_Entrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Remove_24x24.png"))); // NOI18N
        Serv_Cancela_Entrada.setText("Cancelar Entrada");
        Serv_Cancela_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_Cancela_EntradaActionPerformed(evt);
            }
        });
        jMenu1.add(Serv_Cancela_Entrada);

        MP_Serv.add(jMenu1);

        Serv_Saida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, java.awt.event.InputEvent.CTRL_MASK));
        Serv_Saida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_Saida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Saida Mercadoria 24x24.png"))); // NOI18N
        Serv_Saida.setText("Saida de Produto");
        Serv_Saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_SaidaActionPerformed(evt);
            }
        });
        MP_Serv.add(Serv_Saida);

        jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Devoluca 22x22.png"))); // NOI18N
        jMenuItem24.setText("Devolução de Produto");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        MP_Serv.add(jMenuItem24);
        MP_Serv.add(jSeparator2);

        Serv_AjustaEstoque.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, java.awt.event.InputEvent.CTRL_MASK));
        Serv_AjustaEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_AjustaEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Ajuste Estoque 24x24.png"))); // NOI18N
        Serv_AjustaEstoque.setText("Ajuste de Estoque");
        Serv_AjustaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_AjustaEstoqueActionPerformed(evt);
            }
        });
        MP_Serv.add(Serv_AjustaEstoque);
        MP_Serv.add(jSeparator4);

        Serv_Altera_Senha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        Serv_Altera_Senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_Altera_Senha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Cadeado 24x24.png"))); // NOI18N
        Serv_Altera_Senha.setText("Alterar Senha");
        Serv_Altera_Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_Altera_SenhaActionPerformed(evt);
            }
        });
        MP_Serv.add(Serv_Altera_Senha);

        Serv_Ativa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        Serv_Ativa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_Ativa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Ativar 24x24.png"))); // NOI18N
        Serv_Ativa.setText("Ativar Itens");
        Serv_Ativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_AtivaActionPerformed(evt);
            }
        });
        MP_Serv.add(Serv_Ativa);
        MP_Serv.add(jSeparator5);

        jMenuItem26.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Refresh_24x24.png"))); // NOI18N
        jMenuItem26.setText("Verificar Alertas");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        MP_Serv.add(jMenuItem26);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Calculadora 24x24.png"))); // NOI18N
        jMenuItem5.setText("Calculadora do Windows");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MP_Serv.add(jMenuItem5);

        Menu_Principal.add(MP_Serv);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/background.png"))); // NOI18N
        jMenu7.setMnemonic('p');
        jMenu7.setText("Aparência");
        jMenu7.setToolTipText("Módulo De Aparências E Temas (Alt + P)");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        BG_Menu.add(jRadioButtonMenuItem13);
        jRadioButtonMenuItem13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem13.setText("Alumínio");
        jRadioButtonMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem13ActionPerformed(evt);
            }
        });
        jMenu7.add(jRadioButtonMenuItem13);

        BG_Menu.add(jRadioButtonMenuItem14);
        jRadioButtonMenuItem14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem14.setText("Amarelo");
        jRadioButtonMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jRadioButtonMenuItem14);

        BG_Menu.add(jRadioButtonMenuItem15);
        jRadioButtonMenuItem15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem15.setText("Ciano");
        jRadioButtonMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem15ActionPerformed(evt);
            }
        });
        jMenu7.add(jRadioButtonMenuItem15);

        BG_Menu.add(jRadioButtonMenuItem16);
        jRadioButtonMenuItem16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem16.setText("Dark");
        jRadioButtonMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem16ActionPerformed(evt);
            }
        });
        jMenu7.add(jRadioButtonMenuItem16);

        BG_Menu.add(jRadioButtonMenuItem17);
        jRadioButtonMenuItem17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem17.setText("Preto");
        jRadioButtonMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem17ActionPerformed(evt);
            }
        });
        jMenu7.add(jRadioButtonMenuItem17);

        BG_Menu.add(jRadioButtonMenuItem23);
        jRadioButtonMenuItem23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem23.setText("Pink");
        jRadioButtonMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem23ActionPerformed(evt);
            }
        });
        jMenu7.add(jRadioButtonMenuItem23);

        BG_Menu.add(jRadioButtonMenuItem20);
        jRadioButtonMenuItem20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem20.setText("Rosa");
        jRadioButtonMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem20ActionPerformed(evt);
            }
        });
        jMenu7.add(jRadioButtonMenuItem20);

        BG_Menu.add(jRadioButtonMenuItem21);
        jRadioButtonMenuItem21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem21.setText("Verde");
        jRadioButtonMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem21ActionPerformed(evt);
            }
        });
        jMenu7.add(jRadioButtonMenuItem21);

        BG_Menu.add(jRadioButtonMenuItem22);
        jRadioButtonMenuItem22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem22.setText("Vermelho");
        jRadioButtonMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem22ActionPerformed(evt);
            }
        });
        jMenu7.add(jRadioButtonMenuItem22);

        BG_Menu.add(jRadioButtonMenuItem12);
        jRadioButtonMenuItem12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem12.setText("Windows XP");
        jRadioButtonMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jRadioButtonMenuItem12);

        jMenu9.setText("Acrílico");
        jMenu9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        BG_Menu.add(jRadioButtonMenuItem5);
        jRadioButtonMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem5.setText("Preto");
        jRadioButtonMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem5ActionPerformed(evt);
            }
        });
        jMenu9.add(jRadioButtonMenuItem5);

        BG_Menu.add(jRadioButtonMenuItem6);
        jRadioButtonMenuItem6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem6.setText("Verde");
        jRadioButtonMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem6ActionPerformed(evt);
            }
        });
        jMenu9.add(jRadioButtonMenuItem6);

        BG_Menu.add(jRadioButtonMenuItem7);
        jRadioButtonMenuItem7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem7.setText("Limão");
        jRadioButtonMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem7ActionPerformed(evt);
            }
        });
        jMenu9.add(jRadioButtonMenuItem7);

        BG_Menu.add(jRadioButtonMenuItem8);
        jRadioButtonMenuItem8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem8.setText("Vermelho");
        jRadioButtonMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem8ActionPerformed(evt);
            }
        });
        jMenu9.add(jRadioButtonMenuItem8);

        jMenu7.add(jMenu9);

        jMenu10.setText("Grafite");
        jMenu10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        BG_Menu.add(jRadioButtonMenuItem9);
        jRadioButtonMenuItem9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem9.setText("Azul");
        jRadioButtonMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem9ActionPerformed(evt);
            }
        });
        jMenu10.add(jRadioButtonMenuItem9);

        BG_Menu.add(jRadioButtonMenuItem10);
        jRadioButtonMenuItem10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem10.setText("Preto");
        jRadioButtonMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem10ActionPerformed(evt);
            }
        });
        jMenu10.add(jRadioButtonMenuItem10);

        BG_Menu.add(jRadioButtonMenuItem11);
        jRadioButtonMenuItem11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem11.setText("Verde");
        jRadioButtonMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem11ActionPerformed(evt);
            }
        });
        jMenu10.add(jRadioButtonMenuItem11);

        jMenu7.add(jMenu10);

        jMenu11.setText("Padrão");
        jMenu11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        BG_Menu.add(JRB_Padrao);
        JRB_Padrao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRB_Padrao.setText("Azul");
        JRB_Padrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_PadraoActionPerformed(evt);
            }
        });
        jMenu11.add(JRB_Padrao);

        BG_Menu.add(jRadioButtonMenuItem18);
        jRadioButtonMenuItem18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem18.setText("Cinza");
        jRadioButtonMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem18ActionPerformed(evt);
            }
        });
        jMenu11.add(jRadioButtonMenuItem18);

        BG_Menu.add(jRadioButtonMenuItem19);
        jRadioButtonMenuItem19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem19.setText("Lilás");
        jRadioButtonMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem19ActionPerformed(evt);
            }
        });
        jMenu11.add(jRadioButtonMenuItem19);

        jMenu7.add(jMenu11);

        jMenu8.setText("Textura");
        jMenu8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        BG_Menu.add(jRadioButtonMenuItem2);
        jRadioButtonMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem2.setText("Azul");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu8.add(jRadioButtonMenuItem2);

        BG_Menu.add(jRadioButtonMenuItem3);
        jRadioButtonMenuItem3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem3.setText("Neve");
        jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jRadioButtonMenuItem3);

        BG_Menu.add(jRadioButtonMenuItem4);
        jRadioButtonMenuItem4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonMenuItem4.setText("Dark");
        jRadioButtonMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jRadioButtonMenuItem4);

        jMenu7.add(jMenu8);

        Menu_Principal.add(jMenu7);

        MP_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Log Out_24x24.png"))); // NOI18N
        MP_Sair.setMnemonic('r');
        MP_Sair.setText("Sair");
        MP_Sair.setToolTipText("Módulo De Opções Para Sair (Alt + R)");
        MP_Sair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Sair_Logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        Sair_Logout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Sair_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Logout Usuario 24x24.png"))); // NOI18N
        Sair_Logout.setText("Logout Usuário");
        Sair_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sair_LogoutActionPerformed(evt);
            }
        });
        MP_Sair.add(Sair_Logout);

        Sair_Bloquear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
        Sair_Bloquear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Sair_Bloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Cancel_24x24.png"))); // NOI18N
        Sair_Bloquear.setText("Bloquear");
        Sair_Bloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sair_BloquearActionPerformed(evt);
            }
        });
        MP_Sair.add(Sair_Bloquear);

        Sair_Encerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        Sair_Encerrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Sair_Encerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Sair 24X24.png"))); // NOI18N
        Sair_Encerrar.setText("Encerrar");
        Sair_Encerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sair_EncerrarActionPerformed(evt);
            }
        });
        MP_Sair.add(Sair_Encerrar);

        Menu_Principal.add(MP_Sair);

        MP_Ajuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Help_24x24.png"))); // NOI18N
        MP_Ajuda.setMnemonic('a');
        MP_Ajuda.setText("Ajuda");
        MP_Ajuda.setToolTipText("Módulo Ajuda E Informação (Alt + A)");
        MP_Ajuda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Aj_Sobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        Aj_Sobre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Aj_Sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Information_24x24.png"))); // NOI18N
        Aj_Sobre.setText("Sobre");
        Aj_Sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aj_SobreActionPerformed(evt);
            }
        });
        MP_Ajuda.add(Aj_Sobre);

        Menu_Principal.add(MP_Ajuda);

        setJMenuBar(Menu_Principal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JP_Data_Hora_Sistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Area_Trabalho_Pricinpal, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JP_Acesso_Rapido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Area_Trabalho_Pricinpal, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addComponent(JP_Acesso_Rapido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JP_Data_Hora_Sistema, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Area_Trabalho_Pricinpal.getAccessibleContext().setAccessibleName("Area De Trabalho");

        setSize(new java.awt.Dimension(1366, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Mostrar_Login();
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", Font.TRUETYPE_FONT, 14)));//formata os JOptionsPanes
    }//GEN-LAST:event_formWindowOpened

    private void Sair_EncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair_EncerrarActionPerformed
        Mostrar_DL_Logoff();
    }//GEN-LAST:event_Sair_EncerrarActionPerformed

    private void CD_UsuárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_UsuárioActionPerformed
        new Tela_Cadastro_Usuario().Open_Tela();
    }//GEN-LAST:event_CD_UsuárioActionPerformed

    private void BT_CD_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CD_UsuarioActionPerformed
        new Tela_Cadastro_Usuario().Open_Tela();
    }//GEN-LAST:event_BT_CD_UsuarioActionPerformed

    private void CD_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_ProdutoActionPerformed
        new Tela_Cadastro_Prod().Open_Tela();         
    }//GEN-LAST:event_CD_ProdutoActionPerformed

    private void BT_CD_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CD_ProdutoActionPerformed
        new Tela_Cadastro_Prod().Open_Tela();
      
    }//GEN-LAST:event_BT_CD_ProdutoActionPerformed

    private void CS_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CS_UsuarioActionPerformed
        try {
            new Tela_Consulta_Usuario().Open_Tela();
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CS_UsuarioActionPerformed

    private void BT_Cons_ProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Cons_ProdActionPerformed
        new Tela_Consulta_Produto().Open_Tela();
    }//GEN-LAST:event_BT_Cons_ProdActionPerformed

    private void BT_EncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_EncerrarActionPerformed
        Mostrar_DL_Logoff();
    }//GEN-LAST:event_BT_EncerrarActionPerformed

    private void Serv_Altera_SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_Altera_SenhaActionPerformed
        new Tela_Alterar_Senha().Open_Tela();
    }//GEN-LAST:event_Serv_Altera_SenhaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Mostrar_DL_Logoff();
           
    }//GEN-LAST:event_formWindowClosing

    private void BT_Ent_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Ent_ProdutoActionPerformed
        Mostrar_Seleciona_Entrada();
    }//GEN-LAST:event_BT_Ent_ProdutoActionPerformed

    private void BT_DevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_DevolucaoActionPerformed
        new Tela_Gerar_Devolucao().Open_Tela();
    }//GEN-LAST:event_BT_DevolucaoActionPerformed

    private void Serv_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_EntradaActionPerformed
        new Tela_Entrada_Produto().Open_Tela();
    }//GEN-LAST:event_Serv_EntradaActionPerformed

    private void CD_TurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_TurmaActionPerformed
        new Tela_Cadastro_Curso_Turma().Open_Tela();
    }//GEN-LAST:event_CD_TurmaActionPerformed

    private void Aj_SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aj_SobreActionPerformed
       Mostrar_Sobre();
    }//GEN-LAST:event_Aj_SobreActionPerformed

    private void CS_TurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CS_TurmaActionPerformed
       new Tela_Consulta_Curso_Turma().Open_Tela();
    }//GEN-LAST:event_CS_TurmaActionPerformed

    private void Serv_AtivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_AtivaActionPerformed
        new Tela_Ativacao().Open_Tela();
    }//GEN-LAST:event_Serv_AtivaActionPerformed

    private void CS_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CS_ProdutoActionPerformed
        new Tela_Consulta_Produto().Open_Tela();
    }//GEN-LAST:event_CS_ProdutoActionPerformed

    private void BT_Saida_ProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Saida_ProdActionPerformed
        new Tela_Saida_Produto().Open_Tela();
    }//GEN-LAST:event_BT_Saida_ProdActionPerformed

    private void Serv_SaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_SaidaActionPerformed
       new Tela_Saida_Produto().Open_Tela();
    }//GEN-LAST:event_Serv_SaidaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Tela_Consulta_Entrada().Open_Tela();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Controle_Relatorio_Entradas().Relatorio_Entrada_Prod_Todos();
        //Log
        new Controle_Log().Registrar_Log("Gerou o relatório de todas as entradas", CodLogado);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new Controle_Relatorio_Entradas().Relatorio_Entrada_Prod_Ultimos_30_Dias();
        //Log
        new Controle_Log().Registrar_Log("Gerou o relatório de todas as entradas nos últimos 30 dias", CodLogado);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new Tela_Relat_Entrada_Periodo().Open_Tela();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new Tela_Relat_Entrada_Num().Open_Tela();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try{    
            Runtime.getRuntime().exec("calc"); //assim    
            //Runtime.getRuntime().exec("C:\\Windows\\System32\\calc.exe"); //e assim    
            }catch(Exception erro){    
             System.err.println("Deu pau!");    
            }    
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new Tela_Relat_Produto_Ent_Periodo().Open_Tela();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void Sair_BloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair_BloquearActionPerformed
        new Controle_Log().Registrar_Log("BLOQUEIO DO SISTEMA",CodLogado);   
        Mostrar_Bloqueio();
    }//GEN-LAST:event_Sair_BloquearActionPerformed

    private void Sair_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair_LogoutActionPerformed
        Mostrar_Logout();
    }//GEN-LAST:event_Sair_LogoutActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        new Controle_Relatorio_Produto().Relatorio_Produto_Categoria_Todas();
        //Log
        new Controle_Log().Registrar_Log("Gerou o relatório de produto por todas as categorias", CodLogado);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        new Tela_Relat_Produto_Categoria().Open_Tela();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        new Controle_Relatorio_Produto().Relatorio_Produto_Estoque_Sintetico();
        //Log
        new Controle_Log().Registrar_Log("Gerou o relatório de estoque de produto sintético", CodLogado);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new Controle_Relatorio_Produto().Relatorio_Produto_Estoque_Analitico();
        //Log
        new Controle_Log().Registrar_Log("Gerou o relatório de estoque de produto analítico", CodLogado);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        new Tela_Gerar_Devolucao().Open_Tela();
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        new Tela_Consulta_Saida().Open_Tela();
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void Serv_AjustaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_AjustaEstoqueActionPerformed
        new Tela_Ajuste_Estoque().Open_Tela();
    }//GEN-LAST:event_Serv_AjustaEstoqueActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
//        Abaixo_De_30_Dias();
//        Abaixo_Do_Minimo();
//        Devolucao_Pendente();
//        Produto_Vencido();
        Mostrar_Mensagem();
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        LAF_Textura("Textile");
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed
        LAF_Textura("Snow");
    }//GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

    private void jRadioButtonMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem4ActionPerformed
        LAF_Textura("Rock");
    }//GEN-LAST:event_jRadioButtonMenuItem4ActionPerformed

    private void jRadioButtonMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem5ActionPerformed
        LAF_Acryl("Default");
    }//GEN-LAST:event_jRadioButtonMenuItem5ActionPerformed

    private void jRadioButtonMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem6ActionPerformed
        LAF_Acryl("Green");
    }//GEN-LAST:event_jRadioButtonMenuItem6ActionPerformed

    private void jRadioButtonMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem7ActionPerformed
        LAF_Acryl("Lemmon");
    }//GEN-LAST:event_jRadioButtonMenuItem7ActionPerformed

    private void jRadioButtonMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem8ActionPerformed
        LAF_Acryl("Red");
    }//GEN-LAST:event_jRadioButtonMenuItem8ActionPerformed

    private void jRadioButtonMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem9ActionPerformed
        LAF_Graf("Blue");
    }//GEN-LAST:event_jRadioButtonMenuItem9ActionPerformed

    private void jRadioButtonMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem10ActionPerformed
        LAF_Graf("Default");
    }//GEN-LAST:event_jRadioButtonMenuItem10ActionPerformed

    private void jRadioButtonMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem11ActionPerformed
        LAF_Graf("Green");
    }//GEN-LAST:event_jRadioButtonMenuItem11ActionPerformed

    private void jRadioButtonMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem12ActionPerformed
       try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            LunaLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new LunaLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem12ActionPerformed

    private void jRadioButtonMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem13ActionPerformed
       try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            AluminiumLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem13ActionPerformed

    private void jRadioButtonMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem14ActionPerformed
       try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            BernsteinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new BernsteinLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem14ActionPerformed

    private void jRadioButtonMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem15ActionPerformed
       try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            MintLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new MintLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem15ActionPerformed

    private void jRadioButtonMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem16ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            NoireLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new NoireLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem16ActionPerformed

    private void JRB_PadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_PadraoActionPerformed
        LAF_Padrao("Default");
    }//GEN-LAST:event_JRB_PadraoActionPerformed

    private void jRadioButtonMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem18ActionPerformed
        LAF_Padrao("Modern");
    }//GEN-LAST:event_jRadioButtonMenuItem18ActionPerformed

    private void jRadioButtonMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem19ActionPerformed
        LAF_Padrao("Pink");
    }//GEN-LAST:event_jRadioButtonMenuItem19ActionPerformed

    private void jRadioButtonMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem17ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            UIManager.setLookAndFeel(new SubstanceRavenGraphiteGlassLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem17ActionPerformed

    private void jRadioButtonMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem20ActionPerformed
        try {
            UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem20ActionPerformed

    private void jRadioButtonMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem21ActionPerformed
        try {
            UIManager.setLookAndFeel(new SubstanceEmeraldDuskLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem21ActionPerformed

    private void jRadioButtonMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem22ActionPerformed
        //metodo aparencia lookandfeel
        try {
            UIManager.setLookAndFeel(new SubstanceMagmaLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButtonMenuItem22ActionPerformed

    private void jRadioButtonMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem23ActionPerformed
        LAF_Personalizado();
    }//GEN-LAST:event_jRadioButtonMenuItem23ActionPerformed

    private void CS_LogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CS_LogActionPerformed
        new Tela_Consulta_Log().Open_Tela();
    }//GEN-LAST:event_CS_LogActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        new Controle_Relatorio_Produto().Relatorio_Produto_Todos("","Todos os Produtos");
        //Log
        new Controle_Log().Registrar_Log("Gerou o relatório de todos os produtos", CodLogado);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        new Controle_Relatorio_Produto().Relatorio_Produto_Todos_Retrato("","Todos os Produtos");
        //Log
        new Controle_Log().Registrar_Log("Gerou o relatório de todos os produtos", CodLogado);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        new Controle_Relatorio_Produto().Relatorio_Produto_Todos("where produto.situacao='ATIVO'","Produtos Ativos");
        new Controle_Log().Registrar_Log("Gerou o relatório de todos os produtos ativos", CodLogado);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        new Controle_Relatorio_Produto().Relatorio_Produto_Todos_Retrato("where produto.situacao='ATIVO'","Produtos Ativos");
        new Controle_Log().Registrar_Log("Gerou o relatório de todos os produtos ativos", CodLogado);
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        new Controle_Relatorio_Produto().Relatorio_Produto_Todos("where produto.situacao='INATIVO'","Produtos Inativos");
        new Controle_Log().Registrar_Log("Gerou o relatório de todos os produtos inativos", CodLogado);
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        new Controle_Relatorio_Produto().Relatorio_Produto_Todos_Retrato("where produto.situacao='INATIVO'","Produtos Inativos");
        new Controle_Log().Registrar_Log("Gerou o relatório de todos os produtos inativos", CodLogado);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void BT_AlertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AlertasActionPerformed
//        Abaixo_De_30_Dias();
//        Abaixo_Do_Minimo();
//        Devolucao_Pendente();
//        Produto_Vencido();
        Mostrar_Mensagem();
    }//GEN-LAST:event_BT_AlertasActionPerformed

    private void Relat_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Relat_UsuarioActionPerformed
        new Tela_Relat_Usuario().Open_Tela();        
    }//GEN-LAST:event_Relat_UsuarioActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        new Tela_Relat_Disciplina().Open_Tela();
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new Controle_Relatorio_Curso_Turma_Disciplina().Relatorio_Cursos();
        new Controle_Log().Registrar_Log("Gerou o relatório de todos os cursos ativos", CodLogado);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new Tela_Relat_Turma().Open_Tela();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void Relat_LogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Relat_LogActionPerformed
        new Tela_Relat_Log().Open_Tela();
    }//GEN-LAST:event_Relat_LogActionPerformed

    private void Serv_Entrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_Entrada1ActionPerformed
        new Tela_Entrada_Produto_Cont().Open_Tela();
    }//GEN-LAST:event_Serv_Entrada1ActionPerformed

    private void Serv_Cancela_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_Cancela_EntradaActionPerformed
        new Tela_Cancelar_Entrada_Produto().Open_Tela();
    }//GEN-LAST:event_Serv_Cancela_EntradaActionPerformed

    //Metodos Para setar os dialogs

    public void Mostrar_DL_Logoff() {
        DLLogoff = new Logoff(this, true);
        DLLogoff.setVisible(true);
    }
    public void Mostrar_Sobre(){
        DLSobre = new Sobre(this, true);
        DLSobre.setVisible(true);
    }
    public void Mostrar_Finalizando(){
        DLFim = new Tela_Finalizando(this, true);
        DLFim.setVisible(true);
    }
    public void Mostrar_Finalizando_Iniciando(){
        DLFimInicio = new Tela_Finalizando_Iniciando(this, true);
        DLFimInicio.setVisible(true);
    }
    public void Mostrar_Login(){
        DLLogin= new Tela_Login(this, true);
        DLLogin.setVisible(true);
    }
    public void Mostrar_Bloqueio(){
        DLBloqueio = new Tela_Bloqueio(this, true);
        DLBloqueio.setVisible(true);
    }
    public void Mostrar_Logout(){
        DLLogout = new Logout_User_TP(this, true);
        DLLogout.setVisible(true);
    }
    public void Mostrar_Abaixo_Do_Minimo(){
        DLAbaixoDoMinimo = new Inf_Abaixo_Do_Minimo_TP(this, true);
        DLAbaixoDoMinimo.setVisible(true);
    }
    public void Mostrar_Prod_Vencido(){
        DLProdVencido = new Inf_Prod_Vencido_TP(this, true);
        DLProdVencido.setVisible(true);
    }
    public void Mostrar_Validade(){
        DLVencimento = new Inf_Vencimento_TP(this, true);
        DLVencimento.setVisible(true);
    }
    public void Mostrar_Cad_Usuario(){
        DLCadUsuario = new Inf_Cad_Usuario_TP(this, true);
        DLCadUsuario.setVisible(true);
    }
    public void Mostrar_Dev_Pendente(){
        DLDevPendente = new Inf_Dev_Pendente_TP(this, true);
        DLDevPendente.setVisible(true);
    }
    public void Mostrar_Mensagem(){
        DLMensagem = new Inf_Mensagens(this, true);
        DLMensagem.setVisible(true);
    }
    void Mostrar_Seleciona_Entrada(){
        DLEscolherEntrada = new Inf_Escolher_Entrada_TP(this, true);
        DLEscolherEntrada.setVisible(true);
    }
    
    public void Setar_Usuario(String Usuario, String Permissao) {
        ObjControleUser.Acesso_Adm("SISTEMA");
        if(Usuario.equalsIgnoreCase(ObjControleUser.Adm_Login)){
            JL_Permissao.setText(Permissao);
            JL_Usuario.setText("ADMINISTRADOR DO SISTEMA");
            UserLogado = JL_Usuario.getText();
            PermissaoLogado = "ADMINISTRADOR";
            JL_Cod.setText(String.valueOf(ObjControleUser.Adm_Id));
            CodLogado = JL_Cod.getText();
            jLabel1.setVisible(!false);
            jLabel2.setVisible(!false);
        }else{
            ObjControleUser.Procura_Nome_Usuario(JL_Usuario, Usuario, JL_Cod);
            JL_Permissao.setText(Permissao);        
            UserLogado = JL_Usuario.getText();
            PermissaoLogado = Permissao;
            CodLogado = JL_Cod.getText();
            jLabel1.setVisible(!false);
            jLabel2.setVisible(!false);
            
        }
        ObjControleLog.Registrar_Log("Login no sistema",CodLogado);   
    }
    
    public void Reiniciar(){
        try {
        //TP = null;
        Tela_Ajuste_Estoque.Obj = null;
        Tela_Alterar_Senha.Obj = null;
        Tela_Ativacao.Obj=null;
        Tela_Cadastro_Curso_Turma.Obj=null;
        Tela_Cadastro_Curso_Edit.Obj=null;
        Tela_Cadastro_Turma_Edit.Obj=null;
        Tela_Cadastro_Prod.Obj=null;
        Tela_Cadastro_Prod_Edit.Obj=null;
        Tela_Cadastro_Usuario.Obj=null;
        Tela_Cadastro_Usuario_Edit.Obj=null;
        Tela_Consulta_Curso_Turma.Obj=null;
        Tela_Consulta_Entrada.Obj=null;
        Tela_Consulta_Saida.Obj=null;
        Tela_Consulta_Produto.Obj=null;
        Tela_Consulta_Usuario.Obj=null;
        Tela_Entrada_Produto.Obj=null;
        Tela_Entrada_Produto_Cont.Obj=null;
        Tela_Saida_Produto.Obj=null;
        Tela_Gerar_Devolucao.Obj=null;
        Tela_Relat_Entrada_Num.Obj=null;
        Tela_Relat_Entrada_Periodo.Obj=null;
        Tela_Relat_Produto_Ent_Periodo.Obj=null;
        Tela_Relat_Produto_Categoria.Obj=null;
        Tela_Relat_Usuario.Obj=null;
        Tela_Relat_Disciplina.Obj=null;
        Tela_Relat_Turma.Obj=null;
        Tela_Relat_Log.Obj=null;
        Tela_Consulta_Log.Obj=null;
        Tela_Cancelar_Entrada_Produto.Obj=null;
        
        Mostrar_Finalizando_Iniciando();
    } catch (Exception ex) { }    
    }
    
    public void Controle_De_Acesso(){
        if(PermissaoLogado.equalsIgnoreCase("USUÁRIO")){
            CD_Usuário.setEnabled(false);
            Serv_AjustaEstoque.setEnabled(false);
            BT_CD_Usuario.setEnabled(false);
            CS_Log.setEnabled(false);
            Relat_Log.setEnabled(false);
            Relat_Usuario.setEnabled(false);
            Serv_Cancela_Entrada.setEnabled(false);
        }
    
    }
    
    public void Abaixo_Do_Minimo(){
        try {            
            Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
            obj.Verificar_Abaixo_Do_Minimo();
            if(obj.Abaixo_Do_Minimo == true){
                Mostrar_Abaixo_Do_Minimo();
                obj.Abaixo_Do_Minimo=false;
            }
        } catch (Exception ex) {
            Abaixo_Minimo = false;
        }
    }
    
    public void Abaixo_De_30_Dias(){
        try {
            Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
            obj.Verifica_Validade_30_Dias();
            if(obj.Menos_De_30_Dias ==true){
                Mostrar_Validade();
                obj.Menos_De_30_Dias=false;
            }
        } catch (Exception ex) {}
    }
    
    public void Produto_Vencido(){
        try {
            Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
            obj.Verifica_Produto_Vencido();
            if(obj.Produto_Vencido ==true){
                Mostrar_Prod_Vencido();
                obj.Produto_Vencido =false;
            }
        } catch (Exception ex) {}
    }
    
    public void Devolucao_Pendente(){
        Controle_Saida_Produto obj = new Controle_Saida_Produto();
        obj.Devolucao_Pendente();
        if(obj.Controla_Devolucao_Pendente ==true){
            Mostrar_Dev_Pendente();
            obj.Controla_Devolucao_Pendente =false;
        }
    }
    
    public void Verifica_Informacao(){
        //Minimo
        Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
        obj.Verificar_Abaixo_Do_Minimo();
        if(obj.Abaixo_Do_Minimo == true){
            Abaixo_Minimo = true;
            obj.Abaixo_Do_Minimo=false;
        }
        //30 dias
        obj.Verifica_Validade_30_Dias();
        if(obj.Menos_De_30_Dias ==true){
            Abaixo_30 = true;
            obj.Menos_De_30_Dias=false;
            }
        //vencido
        obj.Verifica_Produto_Vencido();
        if(obj.Produto_Vencido ==true){
            Vencido = true;
            obj.Produto_Vencido =false;
        }
        Controle_Saida_Produto obj2 = new Controle_Saida_Produto();
        obj2.Devolucao_Pendente();
        if(obj2.Controla_Devolucao_Pendente ==true){
            Devolucao_Pendente = true;
            obj2.Controla_Devolucao_Pendente =false;
        }
    }
    
    public void Fechar_Tela_bloqueio(){
        DLLogout.setVisible(false);
    }
    public static void Fechar_Tela_Principal(){
        TP.dispose();
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                getInstancia().setVisible(true);
            }
        });
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Aj_Sobre;
    private javax.swing.JDesktopPane Area_Trabalho_Pricinpal;
    private javax.swing.ButtonGroup BG_Menu;
    private javax.swing.JButton BT_Alertas;
    private javax.swing.JButton BT_CD_Produto;
    private javax.swing.JButton BT_CD_Usuario;
    private javax.swing.JButton BT_Cons_Prod;
    private javax.swing.JButton BT_Devolucao;
    private javax.swing.JButton BT_Encerrar;
    private javax.swing.JButton BT_Ent_Produto;
    private javax.swing.JButton BT_Saida_Prod;
    private javax.swing.JMenuItem CD_Produto;
    private javax.swing.JMenuItem CD_Turma;
    private javax.swing.JMenuItem CD_Usuário;
    private javax.swing.JMenuItem CS_Log;
    private javax.swing.JMenuItem CS_Produto;
    private javax.swing.JMenuItem CS_Turma;
    private javax.swing.JMenuItem CS_Usuario;
    public javax.swing.JLabel JL_Cod;
    private javax.swing.JLabel JL_Data;
    private javax.swing.JLabel JL_Hora;
    private javax.swing.JLabel JL_Logo_ADS;
    private javax.swing.JLabel JL_Logo_Coolab2;
    private javax.swing.JLabel JL_Logo_Estacio;
    private javax.swing.JLabel JL_Logo_Fcat;
    public javax.swing.JLabel JL_Permissao;
    public javax.swing.JLabel JL_Usuario;
    private javax.swing.JPanel JP_Acesso_Rapido;
    private javax.swing.JPanel JP_Data_Hora_Sistema;
    private javax.swing.JRadioButtonMenuItem JRB_Padrao;
    private javax.swing.JMenu MP_Ajuda;
    private javax.swing.JMenu MP_Cadastrar;
    private javax.swing.JMenu MP_Consultar;
    private javax.swing.JMenu MP_Relatorio;
    private javax.swing.JMenu MP_Sair;
    private javax.swing.JMenu MP_Serv;
    private javax.swing.JMenuBar Menu_Principal;
    private javax.swing.JMenuItem Relat_Log;
    private javax.swing.JMenuItem Relat_Usuario;
    private javax.swing.JMenuItem Sair_Bloquear;
    private javax.swing.JMenuItem Sair_Encerrar;
    private javax.swing.JMenuItem Sair_Logout;
    private javax.swing.JMenuItem Serv_AjustaEstoque;
    private javax.swing.JMenuItem Serv_Altera_Senha;
    private javax.swing.JMenuItem Serv_Ativa;
    private javax.swing.JMenuItem Serv_Cancela_Entrada;
    private javax.swing.JMenuItem Serv_Entrada;
    private javax.swing.JMenuItem Serv_Entrada1;
    private javax.swing.JMenuItem Serv_Saida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem10;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem11;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem12;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem13;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem14;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem15;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem16;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem17;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem18;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem19;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem20;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem21;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem22;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem23;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem5;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem6;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem8;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    // End of variables declaration//GEN-END:variables

    
public void Encerrar_Tela_Principal() {
        System.exit(WIDTH);//Fecha o programa
    } 

        
 void LAF_Textura(String tipo){
    try {
        TextureLookAndFeel.setTheme(tipo,"", "SisCoE");
        UIManager.setLookAndFeel(new TextureLookAndFeel());
        SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
 }      
 
 void LAF_Acryl(String tipo){
    try {
        AcrylLookAndFeel.setTheme(tipo,"", "SisCoE");
        UIManager.setLookAndFeel(new AcrylLookAndFeel());
        SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
 }  
 void LAF_Graf(String tipo){
    try {
        GraphiteLookAndFeel.setTheme(tipo,"", "SisCoE");
        UIManager.setLookAndFeel(new GraphiteLookAndFeel());
        SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 void LAF_Padrao(String tipo){
    try {
        McWinLookAndFeel.setTheme(tipo,"", "SisCoE");
        UIManager.setLookAndFeel(new McWinLookAndFeel());
        SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
 } 
 
 void LAF_Personalizado(){
        try {
            
            Properties props = new Properties();
            props.put("logoString", "SisCoE");  
            
            props.put("backgroundPattern", "on");//
            
            props.put("foregroundColor", "0 0 0"); //seleção letra
            props.put("backgroundColor", "255 0 153"); //seleção fundo
            props.put("backgroundColorLight", "255 0 153"); //cor dos componentes acima
            props.put("backgroundColorDark", "255 0 153"); //cor dos componentes abaixo
            props.put("inputForegroundColor", "0 0 0"); //cor da letra ao ser digitado
            props.put("inputBackgroundColor", "255 0 255"); //cor do fundo dos campos            
            props.put("selectionBackgroundColor", "0 0 0"); //seleção fundo ao passar o mouse
            props.put("selectionForegroundColor", "255 0 153"); //seleção letra ao passar o mouse
            props.put("frameColor", "0 0 0"); //contorno dos botoes e das textfileds            
            props.put("gridColor", "255 0 153"); //linhas das tabelas  
            props.put("controlColorLight", "0 0 0"); //barra de carregamento acima
            props.put("controlColorDark", "0 0 0"); //barra da carregamento abaixo
            props.put("controlForegroundColor", "255 255 255"); //cor da seta onde escreve piscando e titulos da tabela
            
            //Botoes
            props.put("rolloverColor", "255 255 255"); //cor dos botoes quando clica
            props.put("rolloverColorLight", "255 0 255"); //cor dos botoes ao passar o mouse acima
            props.put("rolloverColorDark", "255 0 255"); //cor dos botoes ao passar o mouse abaixo
            props.put("buttonColorLight", "255 153 204"); //cor dos botoes acima
            props.put("buttonColorDark", "255 0 153"); //cor dos botoes abaixo            
            props.put("buttonForegroundColor", "0 0 0"); //cor da fonte dos botoes 
            props.put("focusColor", "0 0 0");//cor do focus no botao
            
            //Janela
            props.put("windowTitleForegroundColor", "255 255 255");//Titulo da janela
            props.put("windowTitleBackgroundColor", "255 153 204");//contorno do titulo
            props.put("windowTitleColorLight", "255 0 153");//barra da janela cima
            props.put("windowTitleColorDark", "255 51 255"); //barra da janela baixo
            props.put("windowBorderColor", "0 0 0");//bordas da janela    
            props.put("windowInactiveTitleColorLight", "255 153 204");//barra da janela cima inativa
            props.put("windowInactiveTitleColorDark", "255 153 204");//barra da janela baixa inativa     
            props.put("windowInactiveBorderColor", "0 0 0 ");//borda da janela inativa           
            props.put("windowIconColor", "255 255 255"); //icones da janela(fechar, max e mini)
            props.put("windowIconShadowColor", "0 0 0"); //sombra icones da janela(fechar, max e mini)
            props.put("windowIconRolloverColor", "0 0 0"); //icones da janela(fechar, max e mini) ao passar o mouse
            
            //Menus
            props.put("menuForegroundColor", "0 0 0"); //cor das letras dos menus
            props.put("menuBackgroundColor", "255 0 153");//cor do fundo do menu
            props.put("menuColorLight", "255 0 153");//cor do menu acima
            props.put("menuColorDark", "255 0 153");//cor do menu abaixo
            props.put("menuSelectionForegroundColor", "255 255 255");//cor da letra no menu selecionado
            props.put("menuSelectionBackgroundColor", "255 0 255");//cor da linha selecionada no menu            
            props.put("menuSelectionBackgroundColorLight", "255 0 255"); //cor do fundo selecionada no menu acima
            props.put("menuSelectionBackgroundColorDark", "255 0 255"); //cor do fundo selecionada no menu abaixo
            props.put("menuOpaque", "off"); //menu translucido toolbarBackgroundColor
            //Testes 
            props.put("toolbarBackgroundColor", "255 0 0"); //
            props.put("toolbarColorLight", "255 0 0"); //
            props.put("toolbarColorDark", "255 0 0"); //
            
            //Texto de ajuda
            props.put("tooltipForegroundColor", "0 0 0");//cor da letra do texto de ajuda
            props.put("tooltipBackgroundColor", "255 0 255");//cor do fundo do texto de ajuda
            props.put("tooltipBorderSize", "2");//largura da borda do texto de ajuda            
            props.put("tooltipShadowSize", "8");//sombra do texto de ajuda 
            
            props.put("alterBackgroundColor", "240 240 240");//sombra do texto de ajuda //
            props.put("backgroundColorLight", "255 0 153"); //cor dos componentes acima
            props.put("backgroundColorDark", "255 0 153"); //cor dos componentes abaixo
                       
            NoireLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new NoireLookAndFeel());
             SwingUtilities.updateComponentTreeUI(this);
     
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}//Fim Do Codigo

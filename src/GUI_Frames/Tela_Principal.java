package GUI_Frames;

//@author Márison Tamiarana

import Conexao.Conecta_Banco;
import Conexao.Controle_Log;
import Conexao.Controle_Lote_Estoque;
import Conexao.Controle_Relatorio_Entradas;
import Conexao.Controle_Relatorio_Produto;
import Conexao.Controle_Saida_Produto;
import Conexao.Controle_Usuario;
import GUI_Dialogs_Principal.Inf_Abaixo_Do_Minimo_TP;
import GUI_Dialogs_Principal.Inf_Cad_Usuario_TP;
import GUI_Dialogs_Principal.Inf_Dev_Pendente_TP;
import GUI_Dialogs_Principal.Inf_Prod_Vencido_TP;
import GUI_Dialogs_Principal.Inf_Vencimento_TP;
import GUI_Dialogs_Principal.Logoff;
import GUI_Dialogs_Principal.Logout_User_TP;
import GUI_Dialogs_Principal.Sobre;
import GUI_Dialogs_Relatorios.Tela_Num_Entrada;
import GUI_Dialogs_Relatorios.Tela_Periodo_Entrada;
import GUI_Dialogs_Relatorios.Tela_Produto_Entrada_Periodo;
import GUI_Dialogs_Relatorios.Tela_Produto_Relat_Categoria;
import Metodos.Metodos;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jvnet.substance.skin.SubstanceAutumnLookAndFeel;
import org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel;
import org.jvnet.substance.skin.SubstanceGreenMagicLookAndFeel;
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
    private static Logoff ObjLogoff;
    private static Sobre ObjSobre;
    private static Tela_Finalizando ObjFim;
    private static Tela_Finalizando_Iniciando ObjFimInicio;
    private static Tela_Login ObjLogin;
    private static Tela_Periodo_Entrada ObjPeriodo;
    private static Tela_Num_Entrada ObjNumEntrada;
    private static Inf_Abaixo_Do_Minimo_TP ObjAbaixoDoMinimo;
    private static Inf_Prod_Vencido_TP ObjProdVencido;
    private static Inf_Vencimento_TP ObjVencimento;
    private static Inf_Dev_Pendente_TP ObjDevPendente;
    private static Inf_Cad_Usuario_TP ObjCadUsuario;
    private static Tela_Produto_Entrada_Periodo ObjProdEntradaPeriodo;
    private static Tela_Bloqueio ObjBloqueio;
    private static Logout_User_TP ObjLogout;
    private static Tela_Produto_Relat_Categoria ObjProdRelatCat;
    
    public static String UserLogado;
    public static String PermissaoLogado;
    public static String CodLogado;
    
        
    //Instanciando objetos de outras classes para usar os metodos dessa classe
    Metodos Metodo = new Metodos(); 
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Controle_Usuario ObjControlUser = new Controle_Usuario();
    Controle_Log ObjControleLog = new Controle_Log();
    
     
    public Tela_Principal() {
        initComponents();
        //Seta imagem na tela principal
        setIconImage(new ImageIcon(getClass().getResource("/Icones_Gerais/Logo - SisCoE 2.png")).getImage());
                 
       // this.setExtendedState(this.MAXIMIZED_BOTH);//tela principal maximizada:
        setLocationRelativeTo(null);//Função de abrir a tela no centro
                
        //Metodo para mostrar a hora e a data no sistema
        Metodos.start(JL_Hora,"HH:mm:ss");//Metodo Static nao precisa usar objeto.
        Metodos.start(JL_Data, "EEEE',' dd' de 'MMMM' de 'yyyy");
        
        JL_Cod.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        JCH_Padrao.setSelected(true);
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
        uJPanelImagem1 = new componentes.UJPanelImagem();
        jLabel4 = new javax.swing.JLabel();
        JL_Logo_Fcat = new javax.swing.JLabel();
        JL_Logo_Estacio = new javax.swing.JLabel();
        JL_Logo_ADS = new javax.swing.JLabel();
        JL_Logo_Coolab2 = new javax.swing.JLabel();
        JP_Acesso_Rapido = new javax.swing.JPanel();
        BT_CD_Produto = new javax.swing.JButton();
        BT_CD_Usuario = new javax.swing.JButton();
        BT_Ent_Produto = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        BT_Encerrar = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        Menu_Principal = new javax.swing.JMenuBar();
        MP_Cadastrar = new javax.swing.JMenu();
        CD_Produto = new javax.swing.JMenuItem();
        CD_Usuário = new javax.swing.JMenuItem();
        CD_Turma = new javax.swing.JMenuItem();
        MP_Consultar = new javax.swing.JMenu();
        CS_Produto = new javax.swing.JMenuItem();
        CS_Usuario = new javax.swing.JMenuItem();
        CS_Turma = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
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
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Serv_Entrada = new javax.swing.JMenuItem();
        Serv_Saida = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Serv_AjustaEstoque = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        Serv_Altera_Senha = new javax.swing.JMenuItem();
        Serv_Ativa = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        MP_Ajuda = new javax.swing.JMenu();
        Aj_Sobre = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        JCH_Padrao = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem6 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem7 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem8 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem9 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem10 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem11 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem12 = new javax.swing.JCheckBoxMenuItem();
        MP_Sair = new javax.swing.JMenu();
        Sair_Logout = new javax.swing.JMenuItem();
        Sair_Bloquear = new javax.swing.JMenuItem();
        Sair_Encerrar = new javax.swing.JMenuItem();

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

        uJPanelImagem1.setBackground(new java.awt.Color(255, 255, 255));
        uJPanelImagem1.setPreferredSize(new java.awt.Dimension(1135, 564));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Logo - SisCoE 4.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout uJPanelImagem1Layout = new javax.swing.GroupLayout(uJPanelImagem1);
        uJPanelImagem1.setLayout(uJPanelImagem1Layout);
        uJPanelImagem1Layout.setHorizontalGroup(
            uJPanelImagem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uJPanelImagem1Layout.createSequentialGroup()
                .addGap(433, 433, 433)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(379, 379, 379))
        );
        uJPanelImagem1Layout.setVerticalGroup(
            uJPanelImagem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, uJPanelImagem1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(20, 20, 20))
        );

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

        javax.swing.GroupLayout Area_Trabalho_PricinpalLayout = new javax.swing.GroupLayout(Area_Trabalho_Pricinpal);
        Area_Trabalho_Pricinpal.setLayout(Area_Trabalho_PricinpalLayout);
        Area_Trabalho_PricinpalLayout.setHorizontalGroup(
            Area_Trabalho_PricinpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Area_Trabalho_PricinpalLayout.createSequentialGroup()
                .addGroup(Area_Trabalho_PricinpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Area_Trabalho_PricinpalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JL_Logo_ADS, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(JL_Logo_Coolab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(JL_Logo_Estacio, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(JL_Logo_Fcat))
                    .addComponent(uJPanelImagem1, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE))
                .addContainerGap())
        );
        Area_Trabalho_PricinpalLayout.setVerticalGroup(
            Area_Trabalho_PricinpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Area_Trabalho_PricinpalLayout.createSequentialGroup()
                .addComponent(uJPanelImagem1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Area_Trabalho_PricinpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_Logo_Fcat)
                    .addComponent(JL_Logo_Estacio)
                    .addComponent(JL_Logo_ADS)
                    .addComponent(JL_Logo_Coolab2))
                .addGap(36, 36, 36))
        );
        Area_Trabalho_Pricinpal.setLayer(uJPanelImagem1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Area_Trabalho_Pricinpal.setLayer(JL_Logo_Fcat, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Area_Trabalho_Pricinpal.setLayer(JL_Logo_Estacio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Area_Trabalho_Pricinpal.setLayer(JL_Logo_ADS, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Area_Trabalho_Pricinpal.setLayer(JL_Logo_Coolab2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        JP_Acesso_Rapido.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        BT_CD_Produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Produto.png"))); // NOI18N
        BT_CD_Produto.setMnemonic('p');
        BT_CD_Produto.setToolTipText("Clique Para Cadastrar Novo Produto Ou Pressione Alt + P");
        BT_CD_Produto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Produto Press.png"))); // NOI18N
        BT_CD_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CD_ProdutoActionPerformed(evt);
            }
        });

        BT_CD_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Usuario.png"))); // NOI18N
        BT_CD_Usuario.setToolTipText("Clique Para Cadastrar Novo Usuario Ou Pressione F3");
        BT_CD_Usuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Usuario Press.png"))); // NOI18N
        BT_CD_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_CD_UsuarioActionPerformed(evt);
            }
        });

        BT_Ent_Produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Entrada.png"))); // NOI18N
        BT_Ent_Produto.setToolTipText("Clique Para Efetuar Nova Entrada Ou Pressione F6");
        BT_Ent_Produto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Entrada Press.png"))); // NOI18N
        BT_Ent_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Ent_ProdutoActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Saida 2.png"))); // NOI18N
        jButton7.setToolTipText("Clique Para Efetuar Nova Saída Ou Pressione F7");
        jButton7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Add Saida Press 2.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/CS Produto.png"))); // NOI18N
        jButton5.setToolTipText("Clique Para Consultar Os Produtos Ou Pressione F4");
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/CS Produto Press.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        BT_Encerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Sair Encerrar.png"))); // NOI18N
        BT_Encerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Sair Encerrar Press.png"))); // NOI18N
        BT_Encerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_EncerrarActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Devolucao.png"))); // NOI18N
        jButton8.setToolTipText("Clique Para Efetuar Devolução De Produto Ou Pressione F12");
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Bt Devolucao Press.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_Acesso_RapidoLayout = new javax.swing.GroupLayout(JP_Acesso_Rapido);
        JP_Acesso_Rapido.setLayout(JP_Acesso_RapidoLayout);
        JP_Acesso_RapidoLayout.setHorizontalGroup(
            JP_Acesso_RapidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Acesso_RapidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JP_Acesso_RapidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BT_CD_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_CD_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Encerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Ent_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        JP_Acesso_RapidoLayout.setVerticalGroup(
            JP_Acesso_RapidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Acesso_RapidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BT_CD_Produto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_CD_Usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_Ent_Produto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BT_Encerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu_Principal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        Menu_Principal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        MP_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Add_24x24.png"))); // NOI18N
        MP_Cadastrar.setMnemonic('d');
        MP_Cadastrar.setText("Cadastrar");
        MP_Cadastrar.setToolTipText("Módulo De Cadastros (Alt + D)");
        MP_Cadastrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        CD_Produto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        CD_Produto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CD_Produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Prod 24x24.png"))); // NOI18N
        CD_Produto.setText("Produto");
        CD_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CD_ProdutoActionPerformed(evt);
            }
        });
        MP_Cadastrar.add(CD_Produto);

        CD_Usuário.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
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

        CS_Produto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        CS_Produto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CS_Produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Prod 24x24.png"))); // NOI18N
        CS_Produto.setText("Produto");
        CS_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CS_ProdutoActionPerformed(evt);
            }
        });
        MP_Consultar.add(CS_Produto);

        CS_Usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        CS_Usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CS_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/User 24x24.png"))); // NOI18N
        CS_Usuario.setText("Usuário");
        CS_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CS_UsuarioActionPerformed(evt);
            }
        });
        MP_Consultar.add(CS_Usuario);

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

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem8.setText("Período");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
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

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem18.setText("Período");
        jMenu5.add(jMenuItem18);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
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

        MP_Relatorio.add(jMenu4);
        MP_Relatorio.add(jSeparator3);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Prod 24x24.png"))); // NOI18N
        jMenu2.setText("Produto");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem2.setText("Todos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem10.setText("Ativos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem11.setText("Inativos");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem23.setText("Sem Estoque");
        jMenu2.add(jMenuItem23);

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

        Menu_Principal.add(MP_Relatorio);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Serviço 24x24.png"))); // NOI18N
        jMenu1.setMnemonic('v');
        jMenu1.setText("Serviços");
        jMenu1.setToolTipText("Módulo De Serviços (Alt + V)");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Serv_Entrada.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        Serv_Entrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_Entrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Entrada Mercadoria 24x24.png"))); // NOI18N
        Serv_Entrada.setText("Entrada de Produto");
        Serv_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_EntradaActionPerformed(evt);
            }
        });
        jMenu1.add(Serv_Entrada);

        Serv_Saida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        Serv_Saida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_Saida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Saida Mercadoria 24x24.png"))); // NOI18N
        Serv_Saida.setText("Saida de Produto");
        Serv_Saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_SaidaActionPerformed(evt);
            }
        });
        jMenu1.add(Serv_Saida);

        jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Devoluca 22x22.png"))); // NOI18N
        jMenuItem24.setText("Devolução de Produto");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem24);
        jMenu1.add(jSeparator2);

        Serv_AjustaEstoque.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.ALT_MASK));
        Serv_AjustaEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_AjustaEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Ajuste Estoque 24x24.png"))); // NOI18N
        Serv_AjustaEstoque.setText("Ajuste de Estoque");
        Serv_AjustaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_AjustaEstoqueActionPerformed(evt);
            }
        });
        jMenu1.add(Serv_AjustaEstoque);
        jMenu1.add(jSeparator4);

        Serv_Altera_Senha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        Serv_Altera_Senha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_Altera_Senha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Cadeado 24x24.png"))); // NOI18N
        Serv_Altera_Senha.setText("Alterar Senha");
        Serv_Altera_Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_Altera_SenhaActionPerformed(evt);
            }
        });
        jMenu1.add(Serv_Altera_Senha);

        Serv_Ativa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        Serv_Ativa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Serv_Ativa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Ativar 24x24.png"))); // NOI18N
        Serv_Ativa.setText("Ativar Itens");
        Serv_Ativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Serv_AtivaActionPerformed(evt);
            }
        });
        jMenu1.add(Serv_Ativa);
        jMenu1.add(jSeparator5);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Calculadora 24x24.png"))); // NOI18N
        jMenuItem5.setText("Calculadora");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Refresh_24x24.png"))); // NOI18N
        jMenuItem26.setText("Verificar Alertas");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem26);

        Menu_Principal.add(jMenu1);

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

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/background.png"))); // NOI18N
        jMenu7.setMnemonic('p');
        jMenu7.setText("Aparência");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        BG_Menu.add(jCheckBoxMenuItem1);
        jCheckBoxMenuItem1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem1.setText("Acrílico");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem1);

        BG_Menu.add(jCheckBoxMenuItem2);
        jCheckBoxMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem2.setText("Alumínio");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem2);

        BG_Menu.add(jCheckBoxMenuItem3);
        jCheckBoxMenuItem3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem3.setText("Amarelo");
        jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem3ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem3);

        BG_Menu.add(jCheckBoxMenuItem4);
        jCheckBoxMenuItem4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem4.setText("Básico");
        jCheckBoxMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem4);

        BG_Menu.add(jCheckBoxMenuItem5);
        jCheckBoxMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem5.setText("Ciano");
        jCheckBoxMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem5);

        BG_Menu.add(JCH_Padrao);
        JCH_Padrao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JCH_Padrao.setText("Padrão");
        JCH_Padrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCH_PadraoActionPerformed(evt);
            }
        });
        jMenu7.add(JCH_Padrao);

        BG_Menu.add(jCheckBoxMenuItem6);
        jCheckBoxMenuItem6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem6.setText("Preto / Cinza");
        jCheckBoxMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem6ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem6);

        BG_Menu.add(jCheckBoxMenuItem7);
        jCheckBoxMenuItem7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem7.setText("Preto");
        jCheckBoxMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem7ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem7);

        BG_Menu.add(jCheckBoxMenuItem8);
        jCheckBoxMenuItem8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem8.setText("Rosa");
        jCheckBoxMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem8ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem8);

        BG_Menu.add(jCheckBoxMenuItem9);
        jCheckBoxMenuItem9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem9.setText("Textura");
        jCheckBoxMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem9);

        BG_Menu.add(jCheckBoxMenuItem10);
        jCheckBoxMenuItem10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem10.setText("Verde Claro");
        jCheckBoxMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem10);

        BG_Menu.add(jCheckBoxMenuItem11);
        jCheckBoxMenuItem11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem11.setText("Verde Escuro");
        jCheckBoxMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem11);

        BG_Menu.add(jCheckBoxMenuItem12);
        jCheckBoxMenuItem12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxMenuItem12.setText("Vermelho");
        jCheckBoxMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jCheckBoxMenuItem12);

        Menu_Principal.add(jMenu7);

        MP_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones_Gerais/Log Out_24x24.png"))); // NOI18N
        MP_Sair.setMnemonic('s');
        MP_Sair.setText("Sair");
        MP_Sair.setToolTipText("Módulo De Opções Para Sair (Alt + S)");
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
                    .addComponent(Area_Trabalho_Pricinpal, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addComponent(JP_Acesso_Rapido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JP_Data_Hora_Sistema, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Area_Trabalho_Pricinpal.getAccessibleContext().setAccessibleName("Area De Trabalho");

        setSize(new java.awt.Dimension(1366, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Mostrar_Login();         
    }//GEN-LAST:event_formWindowOpened

    private void Sair_EncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair_EncerrarActionPerformed
        Mostrar_DL_Logoff();
    }//GEN-LAST:event_Sair_EncerrarActionPerformed

    private void CD_UsuárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_UsuárioActionPerformed
        Tela_Cadastro_Usuario obj = new Tela_Cadastro_Usuario();
        obj.Open_Tela();
    }//GEN-LAST:event_CD_UsuárioActionPerformed

    private void BT_CD_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CD_UsuarioActionPerformed
        Tela_Cadastro_Usuario obj = new Tela_Cadastro_Usuario();
        obj.Open_Tela();
    }//GEN-LAST:event_BT_CD_UsuarioActionPerformed

    private void CD_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_ProdutoActionPerformed
        Tela_Cadastro_Prod obj = new Tela_Cadastro_Prod();
        obj.Open_Tela();         
    }//GEN-LAST:event_CD_ProdutoActionPerformed

    private void BT_CD_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_CD_ProdutoActionPerformed
      Tela_Cadastro_Prod obj = new Tela_Cadastro_Prod();
      obj.Open_Tela();
      
    }//GEN-LAST:event_BT_CD_ProdutoActionPerformed

    private void CS_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CS_UsuarioActionPerformed
        if(PermissaoLogado.equalsIgnoreCase("ADMINISTRADOR")){
            try {
                Tela_Consulta_Usuario obj = new Tela_Consulta_Usuario();
                obj.Open_Tela();
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Você nao tem permissão para acessar esse módulo");
        }
    }//GEN-LAST:event_CS_UsuarioActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Tela_Consulta_Produto obj = new Tela_Consulta_Produto();
        obj.Open_Tela();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void BT_EncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_EncerrarActionPerformed
        Mostrar_DL_Logoff();
    }//GEN-LAST:event_BT_EncerrarActionPerformed

    private void Serv_Altera_SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_Altera_SenhaActionPerformed
       Tela_Alterar_Senha obj = new Tela_Alterar_Senha();
       obj.Open_Tela();
    }//GEN-LAST:event_Serv_Altera_SenhaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      Mostrar_DL_Logoff();
           
    }//GEN-LAST:event_formWindowClosing

    private void BT_Ent_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Ent_ProdutoActionPerformed
        Tela_Entrada_Produto obj = new Tela_Entrada_Produto();
        obj.Open_Tela();
    }//GEN-LAST:event_BT_Ent_ProdutoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Tela_Gerar_Devolucao obj = new Tela_Gerar_Devolucao();
        obj.Open_Tela();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void Serv_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_EntradaActionPerformed
        Tela_Entrada_Produto obj = new Tela_Entrada_Produto();
        obj.Open_Tela();
    }//GEN-LAST:event_Serv_EntradaActionPerformed

    private void CD_TurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_TurmaActionPerformed
        Tela_Cadastro_Curso_Turma obj = new Tela_Cadastro_Curso_Turma();
        obj.Open_Tela();
    }//GEN-LAST:event_CD_TurmaActionPerformed

    private void Aj_SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aj_SobreActionPerformed
       Mostrar_Sobre();
    }//GEN-LAST:event_Aj_SobreActionPerformed

    private void CS_TurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CS_TurmaActionPerformed
       Tela_Consulta_Curso_Turma obj = new Tela_Consulta_Curso_Turma();
       obj.Open_Tela();
    }//GEN-LAST:event_CS_TurmaActionPerformed

    private void Serv_AtivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_AtivaActionPerformed
        Tela_Ativacao obj = new Tela_Ativacao();
        obj.Open_Tela();
    }//GEN-LAST:event_Serv_AtivaActionPerformed

    private void CS_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CS_ProdutoActionPerformed
        Tela_Consulta_Produto obj = new Tela_Consulta_Produto();
        obj.Open_Tela();
    }//GEN-LAST:event_CS_ProdutoActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Tela_Saida_Produto obj = new Tela_Saida_Produto();
        obj.Open_Tela();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void Serv_SaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_SaidaActionPerformed
       Tela_Saida_Produto obj = new Tela_Saida_Produto();
        obj.Open_Tela();
    }//GEN-LAST:event_Serv_SaidaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Controle_Relatorio_Produto obj = new Controle_Relatorio_Produto();
        obj.Relatorio_Produto_Todos("","Todos os Produtos");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Tela_Consulta_Entrada obj = new Tela_Consulta_Entrada();
        obj.Open_Tela();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Controle_Relatorio_Entradas ObjControlRelat = new Controle_Relatorio_Entradas();
        ObjControlRelat.Relatorio_Entrada_Prod_Todos();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Controle_Relatorio_Entradas ObjControlRelat = new Controle_Relatorio_Entradas();
        ObjControlRelat.Relatorio_Entrada_Prod_Ultimos_30_Dias();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Mostrar_Tela_Periodo();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Mostrar_Tela_Num_Entrada();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try{    
            Runtime.getRuntime().exec("calc"); //assim    
            //Runtime.getRuntime().exec("C:\\Windows\\System32\\calc.exe"); //e assim    
            }catch(Exception erro){    
             System.err.println("Deu pau!");    
            }    
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        Controle_Relatorio_Produto obj = new Controle_Relatorio_Produto();
        obj.Relatorio_Produto_Todos("where produto.situacao='ATIVO'","Produtos Ativos");
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Controle_Relatorio_Produto obj = new Controle_Relatorio_Produto();
        obj.Relatorio_Produto_Todos("where produto.situacao='INATIVO'","Produtos Inativos");
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        Mostrar_Tela_Relat_Prod_Periodo();
        
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void Sair_BloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair_BloquearActionPerformed
        ObjControleLog.Registrar_Log("BLOQUEIO DO SISTEMA",CodLogado);   
        Mostrar_Bloqueio();
    }//GEN-LAST:event_Sair_BloquearActionPerformed

    private void Sair_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair_LogoutActionPerformed
        Mostrar_Logout();
    }//GEN-LAST:event_Sair_LogoutActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        Controle_Relatorio_Produto obj = new Controle_Relatorio_Produto();
        obj.Relatorio_Produto_Categoria_Todas();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        Mostrar_Tela_Realt_Prod_Categoria();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        Controle_Relatorio_Produto obj = new Controle_Relatorio_Produto();
        obj.Relatorio_Produto_Estoque_Sintetico();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Controle_Relatorio_Produto obj = new Controle_Relatorio_Produto();
        obj.Relatorio_Produto_Estoque_Analitico();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        Tela_Gerar_Devolucao obj = new Tela_Gerar_Devolucao();
        obj.Open_Tela();
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        Tela_Consulta_Saida obj = new Tela_Consulta_Saida();
        obj.Open_Tela();
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void Serv_AjustaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Serv_AjustaEstoqueActionPerformed
        Tela_Ajuste_Estoque obj = new Tela_Ajuste_Estoque();
        obj.Open_Tela();
    }//GEN-LAST:event_Serv_AjustaEstoqueActionPerformed

    private void jCheckBoxMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem12ActionPerformed
        //metodo aparencia lookandfeel
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            //AluminiumLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new SubstanceMagmaLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem12ActionPerformed

    private void jCheckBoxMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem11ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            //AluminiumLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new SubstanceEmeraldDuskLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem11ActionPerformed

    private void jCheckBoxMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem10ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            //AluminiumLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new SubstanceGreenMagicLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem10ActionPerformed

    private void jCheckBoxMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem9ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            TextureLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new TextureLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem9ActionPerformed

    private void jCheckBoxMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem8ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            //SubstanceMistAquaLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new SubstanceAutumnLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem8ActionPerformed

    private void jCheckBoxMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem7ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            AluminiumLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new SubstanceRavenGraphiteGlassLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem7ActionPerformed

    private void jCheckBoxMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem6ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            GraphiteLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new GraphiteLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem6ActionPerformed

    private void JCH_PadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCH_PadraoActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            McWinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new McWinLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JCH_PadraoActionPerformed

    private void jCheckBoxMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem5ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            MintLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new MintLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem5ActionPerformed

    private void jCheckBoxMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem4ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            LunaLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new LunaLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem4ActionPerformed

    private void jCheckBoxMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            BernsteinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new BernsteinLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem3ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            AluminiumLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        try {
            Properties props = new Properties();
            props.put("logoString", "SisCoE");
            AcrylLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Tela_Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        Abaixo_De_30_Dias();
        Abaixo_Do_Minimo();
        Devolucao_Pendente();
        Produto_Vencido();
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    //Metodos Para setar os dialogs

    public void Mostrar_DL_Logoff() {
        ObjLogoff = new Logoff(this, true);
        ObjLogoff.setVisible(true);
    }
    public void Mostrar_Sobre(){
        ObjSobre = new Sobre(this, true);
        ObjSobre.setVisible(true);
    }
    public void Mostrar_Finalizando(){
        ObjFim = new Tela_Finalizando(this, true);
        ObjFim.setVisible(true);
    }
    public void Mostrar_Finalizando_Iniciando(){
        ObjFimInicio = new Tela_Finalizando_Iniciando(this, true);
        ObjFimInicio.setVisible(true);
    }
    public void Mostrar_Login(){
        ObjLogin= new Tela_Login(this, true);
        ObjLogin.setVisible(true);
    }
    public void Mostrar_Bloqueio(){
        ObjBloqueio = new Tela_Bloqueio(this, true);
        ObjBloqueio.setVisible(true);
    }
    public void Mostrar_Logout(){
        ObjLogout = new Logout_User_TP(this, true);
        ObjLogout.setVisible(true);
    }
    void Mostrar_Tela_Periodo(){
        ObjPeriodo = new Tela_Periodo_Entrada(this, true);
        ObjPeriodo.setVisible(true);
    }
    void Mostrar_Tela_Num_Entrada(){
        ObjNumEntrada = new Tela_Num_Entrada(this, true);
        ObjNumEntrada.setVisible(true);
    }
    public void Mostrar_Abaixo_Do_Minimo(){
        ObjAbaixoDoMinimo = new Inf_Abaixo_Do_Minimo_TP(this, true);
        ObjAbaixoDoMinimo.setVisible(true);
    }
    public void Mostrar_Prod_Vencido(){
        ObjProdVencido = new Inf_Prod_Vencido_TP(this, true);
        ObjProdVencido.setVisible(true);
    }
    public void Mostrar_Validade(){
        ObjVencimento = new Inf_Vencimento_TP(this, true);
        ObjVencimento.setVisible(true);
    }
    public void Mostrar_Tela_Relat_Prod_Periodo(){
        ObjProdEntradaPeriodo = new Tela_Produto_Entrada_Periodo(this, true);
        ObjProdEntradaPeriodo.setVisible(true);
    }
    public void Mostrar_Tela_Realt_Prod_Categoria(){
        ObjProdRelatCat = new Tela_Produto_Relat_Categoria(this, true);
        ObjProdRelatCat.setVisible(true);
    }
    public void Mostrar_Cad_Usuario(){
        ObjCadUsuario = new Inf_Cad_Usuario_TP(this, true);
        ObjCadUsuario.setVisible(true);
    }
    public void Mostrar_Dev_Pendente(){
        ObjDevPendente = new Inf_Dev_Pendente_TP(this, true);
        ObjDevPendente.setVisible(true);
    }
    
    public void Setar_Usuario(String Usuario, String Permissao) {
        ObjControlUser.Acesso_Adm("SISTEMA");
        if(Usuario.equalsIgnoreCase(ObjControlUser.Adm_Login)){
            JL_Permissao.setText(Permissao);
            JL_Usuario.setText("ADMINISTRADOR DO SISTEMA");
            UserLogado = JL_Usuario.getText();
            PermissaoLogado = "ADMINISTRADOR";
            JL_Cod.setText(String.valueOf(ObjControlUser.Adm_Id));
            CodLogado = JL_Cod.getText();
            jLabel1.setVisible(!false);
            jLabel2.setVisible(!false);
        }else{
            ObjControlUser.Procura_Nome_Usuario(JL_Usuario, Usuario, JL_Cod);
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
        Tela_Saida_Produto.Obj=null;
        Tela_Gerar_Devolucao.Obj=null;
        Mostrar_Finalizando_Iniciando();
    } catch (Exception ex) { }    
    }
    
    public void Controle_De_Acesso(){
        if(PermissaoLogado.equalsIgnoreCase("USUÁRIO")){
            CS_Usuario.setEnabled(false);
            Serv_AjustaEstoque.setEnabled(false);
        }
    
    }
    
    public void Abaixo_Do_Minimo(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_produto");            
            Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
            obj.Verificar_Abaixo_Do_Minimo();
            if(obj.Abaixo_Do_Minimo == true){
                Mostrar_Abaixo_Do_Minimo();
                obj.Abaixo_Do_Minimo=false;
            }
        } catch (SQLException ex) {
            
        }ObjConecta.Desconecta();
    }
    
    public void Abaixo_De_30_Dias(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_produto");
            Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
            obj.Verifica_Validade_30_Dias();
            if(obj.Menos_De_30_Dias ==true){
                TP.Mostrar_Validade();
                obj.Menos_De_30_Dias=false;
            }
        } catch (SQLException ex) {
           
        }ObjConecta.Desconecta();
    }
    
    public void Produto_Vencido(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_produto");
            Controle_Lote_Estoque obj = new Controle_Lote_Estoque();
            obj.Verifica_Produto_Vencido();
            if(obj.Produto_Vencido ==true){
                Mostrar_Prod_Vencido();
                obj.Produto_Vencido =false;
            }
        } catch (SQLException ex) {
           
        }ObjConecta.Desconecta();
    }
    
    public void Devolucao_Pendente(){
        Controle_Saida_Produto obj = new Controle_Saida_Produto();
        obj.Devolucao_Pendente();
        if(obj.Controla_Devolucao_Pendente ==true){
            Mostrar_Dev_Pendente();
            obj.Controla_Devolucao_Pendente =false;
        }
    }
    
    public void Fechar_Tela_bloqueio(){
        ObjLogout.setVisible(false);
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
    private javax.swing.JButton BT_CD_Produto;
    private javax.swing.JButton BT_CD_Usuario;
    private javax.swing.JButton BT_Encerrar;
    private javax.swing.JButton BT_Ent_Produto;
    private javax.swing.JMenuItem CD_Produto;
    private javax.swing.JMenuItem CD_Turma;
    private javax.swing.JMenuItem CD_Usuário;
    private javax.swing.JMenuItem CS_Produto;
    private javax.swing.JMenuItem CS_Turma;
    private javax.swing.JMenuItem CS_Usuario;
    private javax.swing.JCheckBoxMenuItem JCH_Padrao;
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
    private javax.swing.JMenu MP_Ajuda;
    private javax.swing.JMenu MP_Cadastrar;
    private javax.swing.JMenu MP_Consultar;
    private javax.swing.JMenu MP_Relatorio;
    private javax.swing.JMenu MP_Sair;
    private javax.swing.JMenuBar Menu_Principal;
    private javax.swing.JMenuItem Sair_Bloquear;
    private javax.swing.JMenuItem Sair_Encerrar;
    private javax.swing.JMenuItem Sair_Logout;
    private javax.swing.JMenuItem Serv_AjustaEstoque;
    private javax.swing.JMenuItem Serv_Altera_Senha;
    private javax.swing.JMenuItem Serv_Ativa;
    private javax.swing.JMenuItem Serv_Entrada;
    private javax.swing.JMenuItem Serv_Saida;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem10;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem11;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem12;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem7;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem8;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
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
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private componentes.UJPanelImagem uJPanelImagem1;
    // End of variables declaration//GEN-END:variables

    
public void Encerrar_Tela_Principal() {
        System.exit(WIDTH);//Fecha o programa
    } 


//        try{
//        if(JCB_CDASS_Aparencia.getSelectedItem().equals("Aluminio")){
//        this.Seta_Look = ("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//        lookandfeel();
//        }
//        if(JCB_CDASS_Aparencia.getSelectedItem().equals("Mac")){
//        this.Seta_Look = ("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//        lookandfeel();
//        }
//        if(JCB_CDASS_Aparencia.getSelectedItem().equals("Preto")){
//        this.Seta_Look = ( "com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//        lookandfeel();
//        }
//        if(JCB_CDASS_Aparencia.getSelectedItem().equals("Padrão")){
//        this.Seta_Look = ( "com.jtattoo.plaf.texture.TextureLookAndFeel");
//        lookandfeel();
//        }
//        if(JCB_CDASS_Aparencia.getSelectedItem().equals("Acrílico")){
//        this.Seta_Look = ( "com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//        lookandfeel();
//        }
//        if(JCB_CDASS_Aparencia.getSelectedItem().equals("Amarelo")){
//        this.Seta_Look = ( "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//        lookandfeel();
//        }
//        if(JCB_CDASS_Aparencia.getSelectedItem().equals("Grafite")){
//        this.Seta_Look = ( "com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
//        lookandfeel();
//        }
//        if(JCB_CDASS_Aparencia.getSelectedItem().equals("Mint")){
//        this.Seta_Look = ( "com.jtattoo.plaf.mint.MintLookAndFeel");
//        lookandfeel();
//        }
//        if(JCB_CDASS_Aparencia.getSelectedItem().equals("Windows")){
//        this.Seta_Look = ( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//        lookandfeel();
//        }
        
       
    
    
}//Fim Do Codigo

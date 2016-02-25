package Metodos;

// @author Márison Tamiarana

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Metodos {



//Método para setar em um JTextField a data e a hora do sistema
public void Data_E_Hora(JTextField jt){
jt.setText(new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date(System.currentTimeMillis())));  
}

  
//Método para implementar a hora no sistema
    public static void start(final JLabel JLHorario, String mascara){  
        Thread atualizaHora = new Thread(new Runnable() {  
              
            @Override  
            public void run() {  
                try {  
                    while (true) {  
                        Date date = new Date();  
                        StringBuilder data = new StringBuilder();  
                          
                        SimpleDateFormat sdf = new SimpleDateFormat(mascara); // Para Atualizar a DATA so mudar para o formato dd/MM/yyyy  
                        JLHorario.setText(data.toString() + sdf.format(date));  
                        Thread.sleep(1000);  
                        JLHorario.revalidate();  
                    }  
                } catch (InterruptedException ex) {  
                    JOptionPane.showMessageDialog(null, "Erro Na Atualização Da Hora Ou Data!\n "+ex.getMessage(),"Aviso",JOptionPane.INFORMATION_MESSAGE);
                }      
            }  
        });  
        atualizaHora.start();  
    }
    
    
    public static long calcular (String inicio, String fim) throws ParseException {  
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");  
        Date dtInicial = df.parse (inicio);  
        Date dtFinal = df.parse (fim);  
        return   
             (dtFinal.getTime() - dtInicial.getTime() + 3600000L) / 86400000L;  
    }  

    //Metodo para colocar uma tecla como atalho para o botao
//    public final void Setar_Atalho_BT_Procurar(){
//        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0),"Tecla");
//        this.getRootPane().setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, inputMap);
//        this.getRootPane().getActionMap().put("Tecla", new AbstractAction(){
//        private static final long serialVersionUID = 1L;
//        @Override
//        public void actionPerformed(ActionEvent arg0) {
//        BT_Procurar.doClick();
//    }
//    });
//    }
  

}//Fim Da Classe





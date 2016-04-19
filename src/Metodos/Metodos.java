package Metodos;

// @author Márison Tamiarana

import static java.lang.Thread.sleep;
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

  public static final void Cronometro(JLabel JLHorario){    
    new Thread() {            
        
        @Override
        public void run() {
            long cont = 10800000;
            while(true){
            try {
                StringBuilder data = new StringBuilder();                
                Date date = new Date();  
                date.setTime(cont);
                
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // Para Atualizar a DATA so mudar para o formato dd/MM/yyyy  
                JLHorario.setText(data.toString() + sdf.format(date)); 
                JLHorario.revalidate(); 
                sleep(1000);
                cont = cont + 1000;
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar o sistema" + ex);
            }
            
        }
    }
        
    }.start();
}  

}//Fim Da Classe





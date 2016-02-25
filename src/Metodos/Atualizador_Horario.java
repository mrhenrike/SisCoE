package Metodos;

//@author Márison Tamiarana

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

 
public class Atualizador_Horario {

  
    public static void start(final JLabel JLHorario, String Mascara){  
        Thread atualizaHora = new Thread(new Runnable() {  
              
            @Override  
            public void run() {  
                try {  
                    while (true) {  
                        Date date = new Date();  
                        StringBuffer data = new StringBuffer();  
                          
                        SimpleDateFormat sdf = new SimpleDateFormat(Mascara); // Para Atualizar a DATA so mudar para o formato dd/MM/yyyy  
                        JLHorario.setText(data.toString() + sdf.format(date));  
                        Thread.sleep(1000);  
                        JLHorario.revalidate();  
                    }  
                } catch (InterruptedException ex) {  
                     JOptionPane.showMessageDialog(null, "Erro Na Atualização Da Hora!\n "+ex.getMessage(),"Aviso",JOptionPane.INFORMATION_MESSAGE);
                }  
                  
            }  
        });  
        atualizaHora.start();  
    }  
    
}

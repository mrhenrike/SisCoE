package Metodos;

//@author Márison Tamiarana

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class Pintar_Tabela implements TableCellRenderer {
     
    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

   
    //FONTE - TAMANHO E TIPO DE FONTE PARA A LETRA DENTRO DA TABELA
    private final Font fontePadrao = new Font("TAHOMA", 0, 14); 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        ((JLabel) renderer).setOpaque(true);
        
        
        Color foreground, background;
        
        Object estoque = table.getValueAt(row, 5);
        Object minimo = table.getValueAt(row, 4);     
        if(isSelected){//linha selecionada
            foreground = Color.WHITE;
            background = Color.LIGHT_GRAY;
        }else if (row % 2 == 0) {//linha par
            if ((estoque.toString().equals("0.0"))) {//estoque zerado
                foreground = Color.red; //COR DA FONTE
                background = Color.decode("#FFFFFF"); //COR DA CÉLULA
            }else{
                if(Double.parseDouble(String.valueOf(estoque)) < Double.parseDouble(String.valueOf(minimo))){//estoque abaixo do minimo
                    foreground = Color.blue; //COR DA FONTE
                    background = Color.decode("#FFFFFF"); //COR DA CÉLULA
                }
                else{
                    foreground = Color.black; //COR DA FONTE
                    background = Color.decode("#FFFFFF"); //COR DA CÉLULA
                }
            }
        }else {//linha impar
            if ((estoque.toString().equals("0.0"))) {//estoque zerado
                foreground = Color.red; //COR DA FONTE
                background = Color.decode("#E1F2FE");
            }else{
                if(Double.parseDouble(String.valueOf(estoque)) < Double.parseDouble(String.valueOf(minimo))){//estoque abaixo do minimo
                    foreground = Color.green; //COR DA FONTE
                    background = Color.decode("#E1F2FE"); //COR DA CÉLULA
                }
                else{
                    foreground = Color.black; //COR DA FONTE
                    background = Color.decode("#E1F2FE"); //COR DA CÉLULA
                }
            }
        }
        
        renderer.setForeground(foreground);
        renderer.setBackground(background);
        renderer.setFont(this.fontePadrao);
        
          
        return renderer;
    }
}
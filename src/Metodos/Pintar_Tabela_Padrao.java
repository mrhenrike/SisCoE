package Metodos;

//@author Márison Tamiarana

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class Pintar_Tabela_Padrao implements TableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
    
    
    //FONTE - TAMANHO E TIPO DE FONTE PARA A LETRA DENTRO DA TABELA
    private final Font fontePadrao = new Font("TAHOMA", 0, 14); 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        ((JLabel) renderer).setOpaque(true);
        Color foreground, background;
        
        
        if(isSelected){
            foreground = Color.WHITE;
            background = Color.GRAY;
        }else if (row % 2 == 0) {
            foreground = Color.black; //COR DA FONTE
            background = Color.decode("#FFFFFF"); //COR DA CÉLULA
        } else {
            foreground = Color.black;
            background = Color.decode("#DCDCDC");
            
        }
        
    
        renderer.setForeground(foreground);
        renderer.setBackground(background);
        renderer.setFont(this.fontePadrao);
        
        return renderer;
    }
}
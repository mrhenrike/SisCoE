package Metodos;

// @author Márison Tamiarana

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class ComboBoxRenderer extends JLabel implements ListCellRenderer {  
     public ComboBoxRenderer() {  
         setOpaque(true);  
         setHorizontalAlignment(LEADING);  
         setVerticalAlignment(CENTER);  
     }  
     @Override
     public Component getListCellRendererComponent(  
         JList list,  
         Object value,  
         int index,  
         boolean isSelected,  
         boolean cellHasFocus)  
     {  
         if (isSelected) {  
             setBackground(list.getSelectionBackground());  
             setForeground(list.getSelectionForeground());  
         } else {  
             setBackground(list.getBackground());  
             setForeground(list.getForeground());  
         }  
  
         ImageIcon icon = (ImageIcon)value;  
         //nesta linha é possível redimensionar a imagem para o tamanho desejado Ex: 60 largura, 40 altura  
         Image img = icon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT);  
         //setText(icon.getDescription()); 
         setIcon(new ImageIcon(img));  
         return this;  
     }  
}     

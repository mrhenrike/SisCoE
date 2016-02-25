package Metodos;

// @author Márison Tamiarana

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

 
public class Formatacao {
    
//Método para mascarar um textfield.   
public void FormataCampos(JFormattedTextField tf, String mascara){
  try{ 
    MaskFormatter mascarar = new MaskFormatter(mascara);
        mascarar.setPlaceholderCharacter(' '); 
        tf.setFormatterFactory(new DefaultFormatterFactory(mascarar));
        }
    catch(ParseException excp) 
    { System.err.println("Erro na formatação: " + excp.getMessage()); 
     
    }
}

//Métodos para formatção dos campos.

public class Format_Campos_Email extends PlainDocument {

    private int iMaxLength;  
 
    public Format_Campos_Email(int maxlen) {  
        super();  
        iMaxLength = maxlen;  
    }  
  
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if (iMaxLength <= 0) {
            super.insertString(offset, str.toLowerCase().replaceAll("[^a-z|^A-Z|^@|^.|^ -|^0-9]", ""), attr);
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) {
             super.insertString(offset, str.toLowerCase().replaceAll("[^a-z|^A-Z|^@|^.|^ -|^0-9]", ""), attr);
        } else {
            if (getLength() == iMaxLength) {
                return;
            }

            String newStr = str.substring(0, (iMaxLength - getLength()));

            super.insertString(offset, newStr, attr);
        }
    }
  }

public class Format_Campo_Numero extends PlainDocument {

    private int iMaxLength;  
 
    public Format_Campo_Numero(int maxlen) {  
        super();  
        iMaxLength = maxlen;  
    }  
  
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if (iMaxLength <= 0) {
            super.insertString(offset, str.toUpperCase().replaceAll("[^0-9 |^/ |^. |^s |^S |^n |^N ]",""), attr); 
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) {
            super.insertString(offset, str.toUpperCase().replaceAll("[^0-9 |^/ |^. |^s |^S |^n |^N ]",""), attr);
        } else {
            if (getLength() == iMaxLength) {
                return;
            }

            String newStr = str.substring(0, (iMaxLength - getLength()));

            super.insertString(offset, newStr, attr);
        }
    }
  }

public class Format_Apenas_Numero extends PlainDocument {

    private int iMaxLength;  
 
    public Format_Apenas_Numero(int maxlen) {  
        super();  
        iMaxLength = maxlen;  
    }  
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if (iMaxLength <= 0) {
            super.insertString(offset, str.replaceAll("[^0-9]",""), attr); 
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) {
            super.insertString(offset, str.replaceAll("[^0-9]",""), attr);
        } else {
            if (getLength() == iMaxLength) {
                return;
            }

            String newStr = str.substring(0, (iMaxLength - getLength()));

            super.insertString(offset, newStr, attr);
        }
    }
    }
public class Format_Valor extends PlainDocument {

    private int iMaxLength;  
 
    public Format_Valor(int maxlen) {  
        super();  
        iMaxLength = maxlen;  
    }  
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if (iMaxLength <= 0) {
            super.insertString(offset, str.replaceAll("[^0-9|^,]",""), attr); 
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) {
            super.insertString(offset, str.replaceAll("[^0-9|^,]",""), attr);
        } else {
            if (getLength() == iMaxLength) {
                return;
            }

            String newStr = str.substring(0, (iMaxLength - getLength()));

            super.insertString(offset, newStr, attr);
        }
    }
    }
public class Format_Valor_Negativo extends PlainDocument {

    private int iMaxLength;  
 
    public Format_Valor_Negativo(int maxlen) {  
        super();  
        iMaxLength = maxlen;  
    }  
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if (iMaxLength <= 0) {
            super.insertString(offset, str.replaceAll("[^0-9|^,|^-]",""), attr); 
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) {
            super.insertString(offset, str.replaceAll("[^0-9|^,|^-]",""), attr);
        } else {
            if (getLength() == iMaxLength) {
                return;
            }

            String newStr = str.substring(0, (iMaxLength - getLength()));

            super.insertString(offset, newStr, attr);
        }
    }
    }
public class Format_Valor_Inteiro_E_Negativo extends PlainDocument {

    private int iMaxLength;  
 
    public Format_Valor_Inteiro_E_Negativo(int maxlen) {  
        super();  
        iMaxLength = maxlen;  
    }  
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if (iMaxLength <= 0) {
            super.insertString(offset, str.replaceAll("[^0-9|^-]",""), attr); 
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) {
            super.insertString(offset, str.replaceAll("[^0-9|^-]",""), attr);
        } else {
            if (getLength() == iMaxLength) {
                return;
            }

            String newStr = str.substring(0, (iMaxLength - getLength()));

            super.insertString(offset, newStr, attr);
        }
    }
    }

public class Format_Apenas_Letras_Espaco extends PlainDocument {

    private int iMaxLength;

        public Format_Apenas_Letras_Espaco(int maxlen) {
            super();
            iMaxLength = maxlen;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }
            if (iMaxLength <= 0) {
                super.insertString(offset, str.toUpperCase().replaceAll("[^a-z|^A-Z|^ ]", ""), attr);
                return;
            }
            int ilen = (getLength() + str.length());
            if (ilen <= iMaxLength) {
                super.insertString(offset, str.toUpperCase().replaceAll("[^a-z|^A-Z|^ ]", ""), attr);
            } else {
                if (getLength() == iMaxLength) {
                    return;
                }
                String newStr = str.substring(0, (iMaxLength - getLength()));

                super.insertString(offset, newStr, attr);
            }
        }
    }

public class Format_Maisculas_Espaco_Espc extends PlainDocument {

    private int iMaxLength;

    public Format_Maisculas_Espaco_Espc(int maxlen) {
        super();
        iMaxLength = maxlen;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if (iMaxLength <= 0) {
           super.insertString(offset, str.toUpperCase().replaceAll("[^a-z |^A-Z |^ÁÉÍÓÚ |^ÂÊÎÔÛ |^Ç |^ÃÕ]", ""), attr);
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) {
           super.insertString(offset, str.toUpperCase().replaceAll("[^a-z |^A-Z |^ÁÉÍÓÚ |^ÂÊÎÔÛ |^Ç |^ÃÕ]", ""), attr);
        } else {
            if (getLength() == iMaxLength) {
                return;
            }

            String newStr = str.substring(0, (iMaxLength - getLength()));

            super.insertString(offset, newStr, attr);
        }
    }
    }

public class Format_Geral extends PlainDocument {

    private int iMaxLength;

    public Format_Geral(int maxlen) {
        super();
        iMaxLength = maxlen;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if (iMaxLength <= 0) {
            super.insertString(offset, str.toUpperCase().replaceAll("[^a-z |^A-Z |^ÀÁÉÍÓÚÂÊÎÔÛÃÕÇ|^ªº|^.,:;/-|^ -|^0-9]", ""), attr);
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= iMaxLength) {
            super.insertString(offset, str.toUpperCase().replaceAll("[^a-z |^A-Z |^ÀÁÉÍÓÚÂÊÎÔÛÃÕÇ|^ªº|^.,:;/-|^ -|^0-9]", ""), attr);
        } else {
            if (getLength() == iMaxLength) {
                return;
            }

            String newStr = str.substring(0, (iMaxLength - getLength()));

            super.insertString(offset, newStr, attr);
        }
    }
    }

public class Format_Campo_Senha extends PlainDocument {

    private int iMaxLength;

        public Format_Campo_Senha(int maxlen) {
            super();
            iMaxLength = maxlen;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) {
                return;
            }
            if (iMaxLength <= 0) {
                super.insertString(offset, str.toUpperCase().replaceAll("[^a-z|^A-Z|^0-9]", ""), attr);
                return;
            }
            int ilen = (getLength() + str.length());
            if (ilen <= iMaxLength) {
                super.insertString(offset, str.toUpperCase().replaceAll("[^a-z|^A-Z|^0-9]", ""), attr);
            } else {
                if (getLength() == iMaxLength) {
                    return;
                }
                String newStr = str.substring(0, (iMaxLength - getLength()));

                super.insertString(offset, newStr, attr);
            }
        }
    }

public JComponent Cores_Tabela(DefaultTableModel tb){
    JTable tbl = new JTable(tb){
    public Component PrepareRenderer (TableCellRenderer rd, int row, int column){
    Component cp = super.prepareRenderer(rd, row, column);
    //cp.setBackground(Color.red);
    cp.setBackground(row % 2 == 0 ? Color.red: Color.LIGHT_GRAY);
    return cp;
}
};return new JScrollPane(tbl);
}

}

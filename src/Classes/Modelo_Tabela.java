package Classes;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

//@author Márison Tamiarana

public class Modelo_Tabela extends AbstractTableModel{
    private ArrayList linhas = null;
    private String [] colunas = null;
    
    @SuppressWarnings("unchecked")
    
    public Modelo_Tabela(ArrayList lin, String [] col){
        setLinhas(lin);
        setColunas(col);
    }
    public ArrayList getLinhas(){
        return linhas;
    }
    private void setLinhas(ArrayList dados){
        linhas = dados;
    }
    public String[] getColunas(){
        return colunas;
    }
    private void setColunas(String [] nomes){
        colunas = nomes;
    }
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return linhas.size();
    }
    @Override
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    @Override
    public Object getValueAt(int numLin, int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
    
}

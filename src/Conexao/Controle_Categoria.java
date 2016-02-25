package Conexao;

// @author Márison Tamiarana

import Classes.Modelo_Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Controle_Categoria {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    public boolean Confirma_Inserir;
    public boolean Confirma_Alterar;
    public static int Id_Cat;
    
     public void Inserir_Categoria(Modelo_Categoria ObjModeloCategoria){
        try { 
                ObjConecta.Conectar();
                String sql = "insert into categoria_produto (categoria, situacao)values(?,?)";  
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, ObjModeloCategoria.getCategoria());
                        stmt.setString(2, "ATIVO");
                    }
                    stmt.execute();
                    stmt.close();
                    
                }
                Confirma_Inserir = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Inserir = false;
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar a categoria no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
     
    public void Alterar_Categoria(Modelo_Categoria ObjModeloCategoria, String id){
         try { 
                ObjConecta.Conectar();
                String sql = "update categoria_produto set categoria=?, situacao=? where id_categoria="+id+"";
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, ObjModeloCategoria.getCategoria());
                        stmt.setString(2, ObjModeloCategoria.getSituacao());
                    }
                    stmt.execute();
                    stmt.close();
                    
                }
                Confirma_Alterar = true;
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                Confirma_Alterar = false;
                JOptionPane.showMessageDialog(null, "Erro ao alterar a categoria no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    
    }
    
     public void Preencher_CB_Categoria(JComboBox jb) {
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL2("select * from categoria_produto where situacao = 'ATIVO' order by categoria");
            jb.removeAllItems();
            ObjConecta.rs.first();
            jb.addItem(" ");
            do {
                jb.addItem(ObjConecta.rs.getString("categoria"));                
            } while (ObjConecta.rs.next());
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            //JOptionPane.showMessageDialog(null, "Erro Ao Preencher O ComboBox Categoria!");
        }
        jb.addItem("+ ADICIONAR NOVO");
    }
     
    public Modelo_Categoria Consulta_Categoria(Modelo_Categoria ObjModeloCategoria, Object id_categoria) throws SQLException{
      
        ObjConecta.Conectar();
        
        String sql = "select * from categoria_produto where id_categoria=" +id_categoria+"";
     
        try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql); 
             ResultSet rs = stm.executeQuery()) {
             
        rs.first();
      
            ObjModeloCategoria.setId_categoria(rs.getInt("id_categoria"));
            ObjModeloCategoria.setCategoria(rs.getString("categoria"));
            ObjModeloCategoria.setSituacao(rs.getString("situacao"));
                   
        ObjConecta.Desconecta();
   
        return ObjModeloCategoria;
        }
    }   
    
    public void Procura_Id_Categoria(String categoria){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("Select * from categoria_produto where categoria = '"+categoria+"'");
            ObjConecta.rs.first();
            Id_Cat = ObjConecta.rs.getInt("id_categoria");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar o id da categoria!");
        }
    }
}

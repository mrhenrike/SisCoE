package Conexao;

//@author Márison Tamiarana

import Classes.Modelo_Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Controle_Produto {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    
    public boolean Confirma_Inserir = false;//Variavel para testar se o cadastro foi inserido com sucesso
    public boolean Confirma_Alterar= false;//Variavel para testar se o cadastro foi alterado com sucesso
    public boolean Confirma_Busca = false;//Variavel para testar se o cadastro foi encontrado com sucesso
    public boolean Confirma_Inativo = false;//Variavel para testar se o cadastro foi inativado com sucesso
    public boolean Confirma_Ativo = false;//Variavel para testar se o cadastro foi ativado com sucesso
    public boolean Confirma_Existente = false;//Variavel para confirmar se o produto existe
    public boolean Controle_Existente = false;//Variavel para testar se o produto existe
    
    public void Inserir_Produto(Modelo_Produto ObjModeloProd){
        ObjConecta.Conectar();
        String sql = "insert into produto (situacao, quantidade_minima, quantidade_macro, categoria_produto_id_categoria, data_cad, unidade,"
                + "macro, solicita_lote, solicita_devolucao, identificador, valor, descricao) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, "ATIVO");
                    stmt.setInt   (2, ObjModeloProd.getQuant_minima());
                    stmt.setInt   (3, ObjModeloProd.getQuant_macro());
                    stmt.setInt   (4, ObjModeloProd.getCategoria_id_produto());
                    stmt.setString(5, ObjModeloProd.getData_cad());
                    stmt.setString(6, ObjModeloProd.getUnidade());
                    stmt.setString(7, ObjModeloProd.getMacro());
                    stmt.setString(8, ObjModeloProd.getSolicita_lote());
                    stmt.setString(9, ObjModeloProd.getSolicita_devolucao());
                    stmt.setString(10, ObjModeloProd.getIdentificacao());
                    stmt.setDouble(11, ObjModeloProd.getPreco());
                    stmt.setString(12, ObjModeloProd.getDescricao());
                }
                stmt.execute();
                stmt.close();
            }           
                Confirma_Inserir = true;           
        } catch (SQLException ex){
            Confirma_Inserir=false;
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar o produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
        }        
        ObjConecta.Desconecta();
    }
    
    public Modelo_Produto Consulta_Produto(Modelo_Produto ObjModeloProd){
        try {
            ObjConecta.Conectar();

            String sql = "select * from produto where id_produto=" + ObjModeloProd.getPesquisa() + "";

            try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql);
                    ResultSet rs = stm.executeQuery()) {

                rs.first();

                ObjModeloProd.setId_produto(rs.getInt("id_produto"));
                ObjModeloProd.setDescricao(rs.getString("descricao"));
                ObjModeloProd.setQuant_minima(rs.getInt("quantidade_minima"));
                ObjModeloProd.setUnidade(rs.getString("unidade"));

                ObjConecta.Desconecta();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar o produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
        }
        return ObjModeloProd;
    }
    
    public Modelo_Produto Consulta_Produto_Alterar(Modelo_Produto ObjModeloProd) throws SQLException{
        ObjConecta.Conectar();
        
       String sql = "select * from produto where id_produto=" +ObjModeloProd.getPesquisa()+"";
       
       try(PreparedStatement stm = ObjConecta.conn.prepareStatement(sql);
           ResultSet rs = stm.executeQuery()){
           
           rs.first();
           
            ObjModeloProd.setId_produto(rs.getInt("id_produto"));
            ObjModeloProd.setDescricao(rs.getString("descricao"));
            ObjModeloProd.setQuant_minima(rs.getInt("quantidade_minima"));
            ObjModeloProd.setUnidade(rs.getString("unidade"));
            ObjModeloProd.setIdentificacao(rs.getString("identificador"));
            ObjModeloProd.setSolicita_devolucao(rs.getString("solicita_Devolucao"));
            ObjModeloProd.setSolicita_lote(rs.getString("solicita_lote"));
            ObjModeloProd.setQuant_macro(rs.getInt("quantidade_macro"));
            ObjModeloProd.setMacro(rs.getString("macro"));
            ObjModeloProd.setPreco(rs.getDouble("valor"));
            ObjModeloProd.setSituacao(rs.getString("situacao"));
            ObjModeloProd.setCategoria_id_produto(rs.getInt("categoria_produto_id_categoria"));
        
        ObjConecta.Desconecta(); 
        
        return ObjModeloProd;        
       }
       
    }
    
    public void Atualizar_Produto(Modelo_Produto ObjModeloProd, String id){
        ObjConecta.Conectar();
        String sql = "update produto set descricao=?, quantidade_minima=?, unidade=?, macro=?, quantidade_macro=?, "
                + "situacao=?, identificador=?, solicita_lote=?, solicita_devolucao=?, valor=?, categoria_produto_id_categoria=? "
                + "where id_produto="+id+"" ;
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setString(1, ObjModeloProd.getDescricao());
                    stmt.setInt   (2, ObjModeloProd.getQuant_minima());
                    stmt.setString(3, ObjModeloProd.getUnidade());
                    stmt.setString(4, ObjModeloProd.getMacro());
                    stmt.setInt   (5, ObjModeloProd.getQuant_macro());
                    stmt.setString(6, ObjModeloProd.getSituacao());
                    stmt.setString(7, ObjModeloProd.getIdentificacao());
                    stmt.setString(8, ObjModeloProd.getSolicita_lote());
                    stmt.setString(9, ObjModeloProd.getSolicita_devolucao());
                    stmt.setDouble(10, ObjModeloProd.getPreco());
                    stmt.setInt   (11, ObjModeloProd.getCategoria_id_produto());
                }
                stmt.execute();
                stmt.close();                
            }
            Confirma_Alterar = true;
        } catch (SQLException ex) {
            Confirma_Alterar = false;
            JOptionPane.showMessageDialog(null,"Erro ao alterar os dados do produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }
    
    public void Atualiza_Preco_Produto(Modelo_Produto ObjModeloProd,int id){
        ObjConecta.Conectar();
        String sql = "update produto set valor=? where id_produto="+id+"" ;
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                {
                    stmt.setDouble(1, ObjModeloProd.getPreco());
                }
                stmt.execute();
                stmt.close();                
            }
    
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null,"Erro ao atualizar o preco do produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }
    
    public Modelo_Produto Procura_Nome_Categoria(Modelo_Produto ObjModeloProd, int id){
            try {
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("Select * from categoria_produto where id_categoria=" + id + "");
                ObjConecta.rs.first();
                ObjModeloProd.setNome_categoria(ObjConecta.rs.getString("categoria"));
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao procurar o nome da categoria no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }  
        return ObjModeloProd;
            }
    
    public Modelo_Produto Procura_Id_Categoria(Modelo_Produto ObjModeloProd, JComboBox jcb){
        if(jcb.getSelectedIndex()!=0){
            try {
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("Select * from categoria_produto where categoria=" + "'" + jcb.getSelectedItem().toString() + "'" + "");
                ObjConecta.rs.first();
                ObjModeloProd.setCategoria_id_produto(ObjConecta.rs.getInt("id_categoria"));
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao procurar o id da categoria no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return ObjModeloProd;
    }
    
    public void Contar_Produtos_Ativos(JLabel jl){
        try{
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto where situacao='ATIVO'");
            ObjConecta.rs.first();
            jl.setText(String.valueOf(ObjConecta.rs.getInt("cont")));
            ObjConecta.Desconecta();
        
        }catch (SQLException ex){
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null,"Erro ao contar a quantidade de podutos ativos no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);}
        }
    public void Contar_Produtos_Filtrados(JLabel jl, String filtro){
        try{
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select count(id_produto) as cont from produto where situacao = 'ATIVO'  and descricao like '%"+filtro+"%' order by descricao;");
            ObjConecta.rs.first();
            jl.setText(String.valueOf(ObjConecta.rs.getInt("cont")));
            ObjConecta.Desconecta();
        
        }catch (SQLException ex){
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null,"Erro ao contar a quantidade de podutos filtrados ativos no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);}
        }

    public void Buscar_Ultimo_Preco(Modelo_Produto ObjModeloProduto,int id){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto where id_produto="+id+"");
            ObjConecta.rs.first();
            ObjModeloProduto.setPreco(ObjConecta.rs.getDouble("valor"));
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
        }
    } 
    
    public void Buscar_Ultimo_ID(Modelo_Produto ObjModeloProduto){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from produto");
            ObjConecta.rs.last();
            ObjModeloProduto.setId_produto(ObjConecta.rs.getInt("id_produto"));
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
        }
    } 
    
     public void Ativar_Produto(String id){
        ObjConecta.Conectar();
        String sql = "update produto set situacao=? where id_produto="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.setString(1,"ATIVO");
                stmt.execute();
                stmt.close();
                Confirma_Ativo = true;
            }
        } catch (SQLException ex) 
            {
                Confirma_Ativo = false;
                JOptionPane.showMessageDialog(null,"Erro ao Ativar o produto no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }  
        ObjConecta.Desconecta();
        
    }
     
    public void Confirma_Produto_Existe(String id){
        try{
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("Select * from produto where id_produto = "+id+"");
            ObjConecta.rs.first();
            int id_Prod = ObjConecta.rs.getInt("id_produto");
            Confirma_Existente = true;
        
    }catch(SQLException ex){
        Confirma_Existente = false;
        ObjConecta.Desconecta();
    }
        ObjConecta.Desconecta();
    }
    
    public void Testar_Existente(JTextField jt){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("Select * from Produto");        
            ObjConecta.rs.first();            
            do
            {
                String descricao = ObjConecta.rs.getString("descricao");
                if(jt.getText().equalsIgnoreCase(descricao)){
                   Controle_Existente=true;
                }
            }
            while(ObjConecta.rs.next());
            } catch (SQLException ex) {
            Controle_Existente=false;
            ObjConecta.Desconecta();            
        }
        ObjConecta.Desconecta();
    }
}


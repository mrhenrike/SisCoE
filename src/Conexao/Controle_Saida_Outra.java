package Conexao;

// @author Márison Tamiarana

import Classes.Modelo_Saida_Produto;
import com.toedter.calendar.JDateChooser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Controle_Saida_Outra {

    Conecta_Banco ObjConecta = new Conecta_Banco();
    Modelo_Saida_Produto ObjModeloSaida = new Modelo_Saida_Produto();
    
    public boolean Confirma_Saida;
    public boolean Confirma_Iten_Inserido;
    public boolean Atualiza_Devolucao;
    public boolean Controla_Devolucao;
    public boolean efetiva_situacao;
    public boolean Verifica_Saida_Sem_Itens;
    public boolean Confirma_Excluir_Saida;
    public boolean Controle_Saida;
    public boolean Verifica_Devolucao;
    public boolean Controle_Saida_Em_Aberto;
    public boolean Confirma_Devolucao;
    public boolean Controla_Devolucao_Pendente;
    
    public void Inserir_Saida(Modelo_Saida_Produto ObjModeloSaida){
        ObjConecta.Conectar();
        
        String sql = "insert into saida_outra (data_saida_outra, tipo_outra, observacao, situacao, solicita_devolucao_saida_outra) "
                + " values(?,?,?,?,?)";  
            try {                
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())));
                        stmt.setString(2, ObjModeloSaida.getTipo());
                        stmt.setString(3, ObjModeloSaida.getObservacao());
                        stmt.setString(4, "ABERTO");
                        stmt.setString(5, "NÃO");
                    }
                    stmt.execute();
                    stmt.close();
                    //retorna o id inserido
                    ObjConecta.ExecutaSQL("select LAST_INSERT_ID()");
                    ObjConecta.rs.first();
                    ObjModeloSaida.setId_saida(ObjConecta.rs.getInt(1));
                    
                }
                Confirma_Saida = true;
            } catch (SQLException ex) {
                Confirma_Saida = false;
                JOptionPane.showMessageDialog(null, "Erro ao gerar a saida_outra no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
    
    public void Inserir_Saida_Itens(int Id_Prod, int Id_Saida, double Quant, String Lote, String Data_Val){
        ObjConecta.Conectar();
        String sql = "insert into saida_itens_outra (Produto_id_produto, saida_outra_id_saida_outra, quantidade, lote, validade, devolvido)"
                + "values(?,?,?,?,?,?)";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setInt   (1,  Id_Prod);
                        stmt.setInt   (2,  Id_Saida);
                        stmt.setDouble(3,  Quant);
                        stmt.setString(4,  Lote);
                        stmt.setString(5,  Data_Val);
                        stmt.setString(6, "SEM DEVOLUÇÃO");
                    }
                    stmt.execute();
                    stmt.close();
                }
                Confirma_Iten_Inserido = true;
                                
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                Confirma_Iten_Inserido = false;
                JOptionPane.showMessageDialog(null,"Erro ao dar saida de itens no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                    }        
        ObjConecta.Desconecta();
    }
    
    public void Atualiza_Devolucao(int id){
        ObjConecta.Conectar();
        String sql = "update saida_outra set solicita_devolucao_saida_outra = ? where id_saida_outra = "+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.setString(1,"SIM");
                stmt.execute();
                stmt.close();
                Atualiza_Devolucao = true;
            }
        } catch (SQLException ex) 
            {
                ObjConecta.Desconecta();
                Atualiza_Devolucao = false;
                JOptionPane.showMessageDialog(null,"Erro ao verificar se há devolução e atualizar no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();
        
    }
    public void Atualiza_Produto_Devolvido(int id_prod, String situacao){
        ObjConecta.Conectar();        
        String sql = "update saida_itens_outra set devolvido =? where produto_id_produto="+id_prod+"";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setString(1,situacao);
                    }
                    stmt.execute();
                    stmt.close();
                }           
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Erro ao atualizar o produto devolvido no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
    
    public void Atualiza_Produto_Devolvido_Lote(int id_prod, String lote, String situacao){
        ObjConecta.Conectar();        
        String sql = "update saida_itens_outra set devolvido =? where produto_id_produto="+id_prod+" and lote="+"'"+lote+"'"+"";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setString(1,situacao);
                    }
                    stmt.execute();
                    stmt.close();
                }           
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Erro ao atualizar o produto com lote devolvido no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
    
    public void Controla_Devolucao(int id_saida){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select* from saida_outra where id_saida_outra ="+id_saida+"");
            ObjConecta.rs.first();
            String Situacao = ObjConecta.rs.getString("solicita_devolucao_saida_outra");
            
            Controla_Devolucao = Situacao.equalsIgnoreCase("SIM");
            ObjConecta.Desconecta();
                       
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            Controla_Devolucao = false;
        }
        ObjConecta.Desconecta();
    }
    
    public void Efetivar_Situacao(String id, String situacao){
        ObjConecta.Conectar();
        String sql = "update saida_outra set situacao=? where id_saida_outra="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.setString(1,situacao);
                stmt.execute();
                stmt.close();
                efetiva_situacao = true;
            }
        } catch (SQLException ex) 
            {
                ObjConecta.Desconecta();
                efetiva_situacao = false;
                JOptionPane.showMessageDialog(null,"Erro ao atualizar a devolução no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();
        
    }
    
    public void Verifica_Saida_Sem_Itens(int id_saida){    
        try{
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from saida_itens_outra where saida_outra_id_saida_outra = "+id_saida+"");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("produto_id_produto");
            Verifica_Saida_Sem_Itens = true;                
        }catch(SQLException ex){
            ObjConecta.Desconecta();
            Verifica_Saida_Sem_Itens = false;
        }
        ObjConecta.Desconecta();  
    }
    
    public void Excluir_Saida(int id){
        ObjConecta.Conectar();
        String sql = "delete from saida_outra where id_saida_outra ="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.execute();
                stmt.close();
                Confirma_Excluir_Saida = true;
            }
        } catch (SQLException ex) 
            {
                ObjConecta.Desconecta();
                Confirma_Excluir_Saida = false;
                JOptionPane.showMessageDialog(null,"Erro ao excluir a saida do banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();        
    }
    
    public void Consulta_Saida_Todas(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("Select * from saida_outra");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_saida_outra");
            Controle_Saida = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Controle_Saida = false;
            ObjConecta.Desconecta();
        }
    }
     
    public void Consulta_Saida_Intervalo(JDateChooser jdi,JDateChooser jdf){
        try {
            ObjConecta.Conectar();
            String di = new SimpleDateFormat("yyyy-MM-dd").format(jdi.getDate());
            String df = new SimpleDateFormat("yyyy-MM-dd").format(jdf.getDate());
            ObjConecta.ExecutaSQL("select * from saida_outra where data_saida_outra between '"+di+"' and '"+df+"'");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_saida_outra");
            Controle_Saida = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Controle_Saida = false;
            ObjConecta.Desconecta();
        }
    }
    
    public void Consulta_Saida_Id(int id_saida){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("Select * from saida_outra where id_saida_outra = "+id_saida+"");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_saida_outra");
            Controle_Saida = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Controle_Saida = false;
            ObjConecta.Desconecta();
        }
    }
    
    public void Consulta_Saida_Ultimas_30(){
        try {
            ObjConecta.Conectar();
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, -1); //diminuir datas - inicio para 90 dias;
            String df = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String di = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            ObjConecta.ExecutaSQL("select * from saida_outra where data_saida_outra between '"+di+"' and '"+df+"'");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_saida_outra");
            Controle_Saida = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Controle_Saida = false;
            ObjConecta.Desconecta();
        }
    }
    
    public void Consulta_Saida_Alterada(String situacao){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("Select * from saida_outra where situacao = '"+situacao+"'");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_saida_outra");
            Controle_Saida = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Controle_Saida = false;
            ObjConecta.Desconecta();
        }
    }
     
    
    //verifica se a saida necessita devolução
    public void Verifica_Saida_Devolucao(JTextField id_saida){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("select * from saida_outra where id_saida_outra = "+id_saida.getText().trim()+"");        
            ObjConecta.rs.first();            
                String Devolucao = ObjConecta.rs.getString("solicita_devolucao_saida_outra");
                if(Devolucao.equalsIgnoreCase("SIM")){
                   Verifica_Devolucao=true;
                }
            ObjConecta.Desconecta();
            } catch (SQLException ex) {
                Verifica_Devolucao=false;
                ObjConecta.Desconecta();           
        }
    }
    
    public void Saida_Em_Aberto(int id_saida){
        try{
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from saida_outra where situacao = 'ABERTO' and id_saida_outra ="+id_saida);
            ObjConecta.rs.first(); 
            int id = ObjConecta.rs.getInt("id_saida_outra");
            Controle_Saida_Em_Aberto = true;        
        }catch(SQLException ex){
            ObjConecta.Desconecta();
            Controle_Saida_Em_Aberto = false;      
        }
        ObjConecta.Desconecta();  
    }
    
    public Modelo_Saida_Produto Consulta_Saida_Devolucao(Modelo_Saida_Produto ObjModeloSaida, int id_saida){
        try {
            ObjConecta.Conectar();

            String sql = "select * from saida_outra inner join saida_itens_outra on saida_outra.id_saida_outra = saida_itens_outra.saida_outra_id_saida_outra "
                        + " where saida_outra.id_saida_outra = "+id_saida+"";

            try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql);
                    ResultSet rs = stm.executeQuery()) {

                rs.first();
                
                ObjModeloSaida.setTipo(rs.getString("tipo_outra"));
                ObjModeloSaida.setObservacao(rs.getString("observacao"));
                ObjModeloSaida.setSituacao(rs.getString("situacao"));
                ObjModeloSaida.setId_saida(rs.getInt("id_saida_outra"));          

                ObjConecta.Desconecta();
            }
        } catch (SQLException Erro) {
            ObjConecta.Desconecta();
        }
        return ObjModeloSaida;
    }
    
    public void Verifica_Devolucao_Efetivada(String id){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from saida_outra where id_saida_outra = "+id+"");
            ObjConecta.rs.first();
            String Devolucao = ObjConecta.rs.getString("situacao");
            Confirma_Devolucao = Devolucao.equalsIgnoreCase("EFETIVADA DEVOLUÇÃO");
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Confirma_Devolucao = false;
            ObjConecta.Desconecta();
        }
    }    
    
    public void Atualiza_Data_Alteracao_Saida(int id){
        ObjConecta.Conectar();
        String sql = "update saida_outra set data_alteracao_saida_outra =? where id_saida_outra = "+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.setString(1,new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())));
                stmt.execute();
                stmt.close();
            }
        } catch (SQLException ex) 
            {
                ObjConecta.Desconecta();
                JOptionPane.showMessageDialog(null,"Erro ao atualizar a data de alteraca da saida no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();        
    }
    
    public void Devolucao_Pendente(){
        try{
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from saida_outra");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_saida_outra");
            ObjConecta.ExecutaSQL("select * from saida_outra where situacao= 'ABERTO'");
            ObjConecta.rs.first();
            String Situacao = ObjConecta.rs.getString("solicita_devolucao_saida_outra");
            Controla_Devolucao_Pendente = Situacao.equalsIgnoreCase("SIM");
        
        }catch(SQLException ex){
            ObjConecta.Desconecta();
            Controla_Devolucao_Pendente = false;
        }
        ObjConecta.Desconecta();  
    }
}

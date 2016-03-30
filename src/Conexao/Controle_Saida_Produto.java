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


public class Controle_Saida_Produto {
    
    Conecta_Banco ObjConecta = new Conecta_Banco();
    Modelo_Saida_Produto ObjModeloSaida = new Modelo_Saida_Produto();
    
    public boolean Controla_Lote;
    public boolean Controla_Devolucao_Produto;
    public boolean Controle_Saida;
    public boolean Controle_Saida_Em_Aberto;
    public boolean Confirma_Saida;
    public boolean Confirma_Iten_Inserido;
    public boolean Confirma_Atualiza_Estoque;
    public boolean Confirma_Atualiza_Estoque_Lote;
    public boolean Confirma_Excluir_Saida;
    public boolean Verifica_Produto_Devolucao;
    public boolean Verifica_Devolucao;
    public boolean Verifica_Saida_Sem_Itens;
    public boolean Efetiva_Devolucao;
    public boolean Confirma_Devolucao;
    public boolean Atualiza_Devolucao;
    public long dt;
    public boolean Confirma_Atualiza_Estoque_Lote_Dev;
    public boolean Confirma_Atualiza_Estoque_Dev;
    public boolean Controla_Devolucao;
    public boolean Controla_Devolucao_Pendente;
    
    public void Controla_Lote(Object id_prod){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select* from produto where id_produto="+id_prod+"");
            ObjConecta.rs.first();
            String Situacao = ObjConecta.rs.getString("solicita_lote");
            
            Controla_Lote = Situacao.equalsIgnoreCase("SIM");
            ObjConecta.Desconecta();
                       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao procurar o controle de lote do produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            Controla_Lote = false;
            ObjConecta.Desconecta();
        }
        ObjConecta.Desconecta();
    }
    
    public Modelo_Saida_Produto Estoque(Modelo_Saida_Produto ObjModeloSaida, int id){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from lote_estoque where produto_id_produto="+id+"");
            ObjConecta.rs.first();
            ObjModeloSaida.setQuantidade(ObjConecta.rs.getDouble("quantidade_estoque"));
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            JOptionPane.showMessageDialog(null,"Erro ao procurar o estoque do produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
        }
        return ObjModeloSaida;
    }
    
    public void Inserir_Saida(Modelo_Saida_Produto ObjModeloSaida, String Data){
        ObjConecta.Conectar();
        
        String sql = "insert into saida (data_saida,tipo, turma_id_turma, disciplina_id_disciplina, observacao, situacao, solicita_devolucao_saida) "
                + "values(?,?,?,?,?,?,?)";  
            try {                
                try(PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql))
                {
                    {
                        stmt.setString(1, Data);
                        stmt.setString(2, ObjModeloSaida.getTipo());
                        stmt.setInt   (3, ObjModeloSaida.getTurma_id_turma());
                        stmt.setInt   (4, ObjModeloSaida.getDisciplina_id_disciplina());
                        stmt.setString(5, ObjModeloSaida.getObservacao());
                        stmt.setString(6, "ABERTO");
                        stmt.setString(7, "NÃO");
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
                JOptionPane.showMessageDialog(null, "Erro ao gerar a saida no banco! \n"
                        + ex, "Informação Do Banco De Dados", JOptionPane.INFORMATION_MESSAGE);
            }
        ObjConecta.Desconecta();
    }
    
    public void Inserir_Saida_Itens(int Id_Prod, int Id_Saida, double Quant, String Lote, String Data_Val){
        ObjConecta.Conectar();
        String sql = "insert into saida_itens (Produto_id_produto, saida_id_saida, quantidade, lote, validade, devolvido)"
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
    
    public void Atualiza_Estoque(Modelo_Saida_Produto ObjSaidaProd, int id_prod, double quant){
        ObjConecta.Conectar();        
        String sql = "update lote_estoque set quantidade_estoque =? where produto_id_produto="+id_prod+"";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setDouble(1, ObjSaidaProd.getQuantidade()-quant);
                    }
                    stmt.execute();
                    stmt.close();
                }           
                    Confirma_Atualiza_Estoque = true;      
                } catch (SQLException ex) {
                    Confirma_Atualiza_Estoque = false;
                    JOptionPane.showMessageDialog(null,"Erro ao atualzar o estoque no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
    
    public void Atualiza_Estoque_Lote(Modelo_Saida_Produto ObjSaidaProd, int id_prod, double quant, String lote){
        ObjConecta.Conectar();        
        String sql = "update lote_estoque set quantidade_estoque =? where produto_id_produto="+id_prod+" and numero_lote="+"'"+lote+"'"+"";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setDouble(1, ObjSaidaProd.getQuantidade()-quant);
                    }
                    stmt.execute();
                    stmt.close();
                }           
                    Confirma_Atualiza_Estoque_Lote = true;      
                } catch (SQLException ex) {
                    Confirma_Atualiza_Estoque_Lote = false;
                    JOptionPane.showMessageDialog(null,"Erro ao atualzar o estoque no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
    
    public void Atualiza_Estoque_Produto(int id_prod, double quant, String lote, String data_val){
        try {
            Modelo_Saida_Produto ObjModelo_Saida = new Modelo_Saida_Produto();
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select* from lote_estoque where produto_id_produto="+id_prod+"");
            ObjConecta.rs.first();
            String Lote = ObjConecta.rs.getString("numero_lote");
            
                if(Lote == null){//Produto com estoque e sem lote - atualização
                    ObjConecta.ExecutaSQL("select* from lote_estoque where produto_id_produto="+id_prod+"");
                    ObjConecta.rs.first();
                    ObjModelo_Saida.setQuantidade(ObjConecta.rs.getDouble("quantidade_estoque"));
                    //Atualiza o estoque
                    Atualiza_Estoque(ObjModelo_Saida, id_prod, quant);

                }else{//produto com lote - atualizaçao
                    ObjConecta.ExecutaSQL("select* from lote_estoque where produto_id_produto="+id_prod+" and numero_lote= "+"'"+lote+"'"+"");
                    ObjConecta.rs.first();
                    ObjModelo_Saida.setQuantidade(ObjConecta.rs.getDouble("quantidade_estoque"));
                    //Atualiza o estoque 
                    Atualiza_Estoque_Lote(ObjModelo_Saida, id_prod, quant, lote);
                                     
                }
            ObjConecta.Desconecta();
        } catch (SQLException ex) {//inserir estoque de produto sem estoque            
                ObjConecta.Desconecta();
            }
    }
    
    public Modelo_Saida_Produto Media_Prod_Mes_Saida(Modelo_Saida_Produto ObjModeloSaidaProd, int id){
        try {
            Conecta_Banco obj = new Conecta_Banco();
            obj.Conectar();
            
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, -3); //diminuir datas - inicio para 90 dias;
            Date dt_atual = Calendar.getInstance().getTime();
            Date dt_inicio = c.getTime();
            String data_atual = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String data_inicio = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
            
            obj.ExecutaSQL("select * from saida inner join saida_itens on"
              + " saida.id_saida=saida_itens.saida_id_saida where produto_id_produto="+id+"");
            //primeira saida
            obj.rs.first();
            Date dt1 = obj.rs.getDate("data_saida");
            //ultima saida
            obj.rs.last();
            Date dt2 = obj.rs.getDate("data_saida");
            obj.Desconecta();
            
            dt = (((dt_atual.getTime() - dt1.getTime()) + 3600000) / 86400000L);//Quantidade de dias entra as datas
                        
                ObjConecta.Conectar();
                ObjConecta.ExecutaSQL("select sum(quantidade) as media from saida inner join saida_itens on "
                        + "saida.id_saida=saida_itens.saida_id_saida "
                        + "where saida.data_saida between "+"'"+data_inicio+"'"+" and "+"'"+data_atual+"'"+" and produto_id_produto=" + id + "");
                ObjConecta.rs.first();
                int soma = ObjConecta.rs.getInt("media");//recebe o total
                if(dt_inicio.before(dt1)){               
                    if (dt <= 30) {
                        int resultado = soma;
                        ObjModeloSaidaProd.setMedia(resultado); }
                    if (dt > 30 && dt <= 60) {
                        int resultado = soma / 2;
                        ObjModeloSaidaProd.setMedia(resultado); }
                    if (dt > 60) {
                        int resultado = soma / 3;
                        ObjModeloSaidaProd.setMedia(resultado); }           
                }else{
                    int resultado = soma / 3;
                    ObjModeloSaidaProd.setMedia(resultado); }              
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                ObjConecta.Desconecta();
                
                JOptionPane.showMessageDialog(null,"Erro ao procurar a media de saida de 90 dias do produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }
        return ObjModeloSaidaProd;
    }
    
    // Controle para devolução
    
    public Modelo_Saida_Produto Consulta_Saida_Devolucao(Modelo_Saida_Produto ObjModeloSaida, int id_saida){
        try {
            ObjConecta.Conectar();

            String sql = "select * from saida inner join saida_itens on saida.id_saida = saida_itens.saida_id_saida "
                    + "inner join turma on turma.id_turma = saida.turma_id_turma "
                    + "inner join disciplina on disciplina.id_disciplina = saida.disciplina_id_disciplina "
                    + "inner join curso on curso.id_curso = turma.curso_id_curso where saida.id_saida = "+id_saida+"";

            try (PreparedStatement stm = ObjConecta.conn.prepareStatement(sql);
                    ResultSet rs = stm.executeQuery()) {

                rs.first();
                ObjModeloSaida.setCurso_nome(rs.getString("nome_curso"));
                ObjModeloSaida.setTurma_turno(rs.getString("turno"));
                ObjModeloSaida.setTurma_ano(rs.getString("ano_turma"));
                ObjModeloSaida.setTurma_semestre(rs.getInt("turma.semestre"));
                ObjModeloSaida.setVestibular(rs.getInt("semestre_vestibular"));
                ObjModeloSaida.setTipo(rs.getString("tipo"));
                ObjModeloSaida.setDisciplina_semestre(rs.getInt("disciplina.semestre"));
                ObjModeloSaida.setDisciplina_nome(rs.getString("disciplina"));
                ObjModeloSaida.setObservacao(rs.getString("observacao"));
                ObjModeloSaida.setSituacao(rs.getString("situacao"));
                ObjModeloSaida.setId_saida(rs.getInt("id_saida"));

                ObjConecta.Desconecta();
            }
        } catch (SQLException Erro) {
            ObjConecta.Desconecta();
        }

        return ObjModeloSaida;
    }
    
    public void Consulta_Saida_Id(int id_saida){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("Select * from saida where id_saida = "+id_saida+"");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_saida");
            Controle_Saida = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Controle_Saida = false;
            ObjConecta.Desconecta();
        }
    }
    
    public void Consulta_Saida_Todas(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("Select * from saida");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_saida");
            Controle_Saida = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Controle_Saida = false;
            ObjConecta.Desconecta();
        }
    }
    
    public void Consulta_Saida_Aberto(){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("Select * from saida where situacao = 'ABERTO'");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_saida");
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
            ObjConecta.ExecutaSQL("select * from saida where data_saida between '"+di+"' and '"+df+"'");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_saida");
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
            ObjConecta.ExecutaSQL("select * from saida where data_saida between '"+di+"' and '"+df+"'");
            ObjConecta.rs.first();
            int id = ObjConecta.rs.getInt("id_saida");
            Controle_Saida = true;
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Controle_Saida = false;
            ObjConecta.Desconecta();
        }
    }
    
    public void Verifica_Produto_Devolucao(JTextField jt){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("select * from saida inner join saida_itens on saida.id_saida=saida_itens.saida_id_saida inner join produto "
                + "on produto.id_produto=saida_itens.produto_id_produto where saida_itens.saida_id_saida= "+jt.getText().trim()+"");        
            ObjConecta.rs.first();            
            do
            {
                String Devolucao = ObjConecta.rs.getString("solicita_devolucao");
                if(Devolucao.equalsIgnoreCase("SIM")){
                   Verifica_Produto_Devolucao=true;
                }
            }
            while(ObjConecta.rs.next());
                ObjConecta.Desconecta();
            } catch (SQLException ex) {
                Verifica_Produto_Devolucao=false;
                ObjConecta.Desconecta();            
        }
    }
    //verifica se a saida necessita devolução
    public void Verifica_Saida_Devolucao(JTextField id_saida){
        try {
        ObjConecta.Conectar();        
        ObjConecta.ExecutaSQL("select * from saida where id_saida= "+id_saida.getText().trim()+"");        
            ObjConecta.rs.first();            
                String Devolucao = ObjConecta.rs.getString("solicita_devolucao_saida");
                if(Devolucao.equalsIgnoreCase("SIM")){
                   Verifica_Devolucao=true;
                }            
            } catch (SQLException ex) {
                Verifica_Devolucao=false;
                ObjConecta.Desconecta();           
        }
    }
    
    public void Efetivar_Devolucao(String id, String situacao){
        ObjConecta.Conectar();
        String sql = "update saida set situacao=? where id_saida="+id+"";
        
        try {
            try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                stmt.setString(1,situacao);
                stmt.execute();
                stmt.close();
                Efetiva_Devolucao = true;
            }
        } catch (SQLException ex) 
            {
                ObjConecta.Desconecta();
                Efetiva_Devolucao = false;
                JOptionPane.showMessageDialog(null,"Erro ao atualizar a devolução no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            }        
        ObjConecta.Desconecta();
        
    }
    
    public void Verifica_Devolucao_Efetivada(String id){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from saida where id_saida = "+id+"");
            ObjConecta.rs.first();
            String Devolucao = ObjConecta.rs.getString("situacao");
            Confirma_Devolucao = Devolucao.equalsIgnoreCase("EFETIVADA");
            ObjConecta.Desconecta();
        } catch (SQLException ex) {
            Confirma_Devolucao = false;
            ObjConecta.Desconecta();
        }
    }
    
    public void Atualiza_Devolucao(int id){
        ObjConecta.Conectar();
        String sql = "update saida set solicita_devolucao_saida = ? where id_saida = "+id+"";
        
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
    
    public void Controla_Devolucao_Produto(Object id_prod){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select* from produto where id_produto="+id_prod+"");
            ObjConecta.rs.first();
            String Situacao = ObjConecta.rs.getString("solicita_devolucao");
            
            Controla_Devolucao_Produto = Situacao.equalsIgnoreCase("SIM");
            ObjConecta.Desconecta();
                       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao procurar o controle de devolucao do produto no banco! \n"
                    +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            ObjConecta.Desconecta();
            Controla_Devolucao_Produto = false;
        }
    }
    
    //metodo que verifica o tipo de produto e chama o metodo de atualização
    public void Atualiza_Estoque_Produto_Devolucao(int id_prod, double quant, String lote, String data_val){
        try {
            Modelo_Saida_Produto ObjModelo_Saida = new Modelo_Saida_Produto();
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select* from lote_estoque where produto_id_produto="+id_prod+"");
            ObjConecta.rs.first();
            String Lote = ObjConecta.rs.getString("numero_lote");
            
                if(Lote == null){//Produto com estoque e sem lote - atualização
                    ObjConecta.ExecutaSQL("select* from lote_estoque where produto_id_produto="+id_prod+"");
                    ObjConecta.rs.first();
                    ObjModelo_Saida.setQuantidade(ObjConecta.rs.getDouble("quantidade_estoque"));
                    //Atualiza o estoque
                    Atualiza_Estoque_Devolucao(ObjModelo_Saida, id_prod, quant);

                }else{//produto com lote - atualizaçao
                    ObjConecta.ExecutaSQL("select* from lote_estoque where produto_id_produto="+id_prod+" and numero_lote= "+"'"+lote+"'"+"");
                    ObjConecta.rs.first();
                    ObjModelo_Saida.setQuantidade(ObjConecta.rs.getDouble("quantidade_estoque"));
                    //Atualiza o estoque 
                    Atualiza_Estoque_Lote_Devolucao(ObjModelo_Saida, id_prod, quant, lote);
                                     
                }
            ObjConecta.Desconecta();
        } catch (SQLException ex) {//inserir estoque de produto sem estoque
            JOptionPane.showMessageDialog(null,"Erro ao atualzar o estoque dos produtos para devolução no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
            ObjConecta.Desconecta();
        }
    }
    //metodo para atualizar o estoque de produto sem lote
    public void Atualiza_Estoque_Devolucao(Modelo_Saida_Produto ObjSaidaProd, int id_prod, double quant){
        ObjConecta.Conectar();        
        String sql = "update lote_estoque set quantidade_estoque =? where produto_id_produto="+id_prod+"";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setDouble(1, ObjSaidaProd.getQuantidade()+quant);
                    }
                    stmt.execute();
                    stmt.close();
                }           
                    Confirma_Atualiza_Estoque_Dev = true;      
                } catch (SQLException ex) {
                    Confirma_Atualiza_Estoque_Dev = false;
                    JOptionPane.showMessageDialog(null,"Erro ao atualzar o estoque de devolução no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
    //metodo para atualizar o estoque de produto com lote
    public void Atualiza_Estoque_Lote_Devolucao(Modelo_Saida_Produto ObjSaidaProd, int id_prod, double quant, String lote){
        ObjConecta.Conectar();        
        String sql = "update lote_estoque set quantidade_estoque =? where produto_id_produto="+id_prod+" and numero_lote="+"'"+lote+"'"+"";
            try {
                try (PreparedStatement stmt = ObjConecta.conn.prepareStatement(sql)) {
                    {
                        stmt.setDouble(1, ObjSaidaProd.getQuantidade()+quant);
                    }
                    stmt.execute();
                    stmt.close();
                }           
                    Confirma_Atualiza_Estoque_Lote_Dev = true;      
                } catch (SQLException ex) {
                    Confirma_Atualiza_Estoque_Lote_Dev = false;
                    JOptionPane.showMessageDialog(null,"Erro ao atualzar o estoque de devolução no banco! \n"
                        +ex,"Informação Do Banco De Dados",JOptionPane.INFORMATION_MESSAGE);
                        }        
        ObjConecta.Desconecta();
    }
    
    public void Controla_Devolucao(int id_dev){
        try {
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select* from saida where id_saida="+id_dev+"");
            ObjConecta.rs.first();
            String Situacao = ObjConecta.rs.getString("solicita_devolucao_saida");
            
            Controla_Devolucao = Situacao.equalsIgnoreCase("SIM");
            ObjConecta.Desconecta();
                       
        } catch (SQLException ex) {
            ObjConecta.Desconecta();
            Controla_Devolucao = false;
        }
        ObjConecta.Desconecta();
    }
    
    public void Devolucao_Pendente(){
        try{
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from saida");
            ObjConecta.rs.first();
            int cod = ObjConecta.rs.getInt("id_saida");
            ObjConecta.ExecutaSQL("select * from saida where situacao= 'ABERTO'");
            ObjConecta.rs.first();
            String Situacao = ObjConecta.rs.getString("solicita_devolucao_saida");
            Controla_Devolucao_Pendente = Situacao.equalsIgnoreCase("SIM");
        
        }catch(SQLException ex){
            ObjConecta.Desconecta();
            Controla_Devolucao_Pendente = false;
        }
        ObjConecta.Desconecta();  
    }
    //atualiza quando o produto for devolvido
    public void Atualiza_Produto_Devolvido_Lote(int id_prod, String lote, String situacao){
        ObjConecta.Conectar();        
        String sql = "update saida_itens set devolvido =? where produto_id_produto="+id_prod+" and lote="+"'"+lote+"'"+"";
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
    public void Atualiza_Produto_Devolvido(int id_prod, String situacao){
        ObjConecta.Conectar();        
        String sql = "update saida_itens set devolvido =? where produto_id_produto="+id_prod+"";
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
    public void Verifica_Saida_Sem_Itens(int id_saida){    
        try{
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from saida_itens where saida_id_saida = "+id_saida+"");
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
        String sql = "delete from saida where id_saida="+id+"";
        
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
    public void Saida_Em_Aberto(int id_saida){
        try{
            ObjConecta.Conectar();
            ObjConecta.ExecutaSQL("select * from saida where situacao= 'ABERTO' and id_saida ="+id_saida);
            ObjConecta.rs.first(); 
            int id = ObjConecta.rs.getInt("id_saida");
            Controle_Saida_Em_Aberto = true;        
        }catch(SQLException ex){
            ObjConecta.Desconecta();
            Controle_Saida_Em_Aberto = false;      
        }
        ObjConecta.Desconecta();  
    }
}

package Classes;

// @author Márison Tamiarana

public class Modelo_Lote_Estoque {
    
    private int id_lote;
    private int produto_id_produto;
    private String numero_lote;
    private String data_validade_lote;
    private String situacao;
    private double quantidade_estoque;

    public int getId_lote() {
        return id_lote;
    }

    public void setId_lote(int id_lote) {
        this.id_lote = id_lote;
    }

    public int getProduto_id_produto() {
        return produto_id_produto;
    }

    public void setProduto_id_produto(int produto_id_produto) {
        this.produto_id_produto = produto_id_produto;
    }

    public String getNumero_lote() {
        return numero_lote;
    }

    public void setNumero_lote(String numero_lote) {
        this.numero_lote = numero_lote;
    }

    public String getData_validade_lote() {
        return data_validade_lote;
    }

    public void setData_validade_lote(String data_validade_lote) {
        this.data_validade_lote = data_validade_lote;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(double quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
    
}

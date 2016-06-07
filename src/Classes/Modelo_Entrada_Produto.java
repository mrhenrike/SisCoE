package Classes;

//@author Márison Tamiarana

public class Modelo_Entrada_Produto {
    private int id_entrada;
    private int id_entrada_item;
    private int produto_id_produto;
    private int entrada_id_entrada;
    private double quantidade;
    private double preco;
    private String validade;
    private String lote;
    private String pesquisa;
    private String Data_entrada;
    private String Descricao;
    private String Observacao;
    private String Situacao;
    private float media;//armazenar a media das entradas
    private float total;//armazenar a total das entradas

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public int getId_entrada_item() {
        return id_entrada_item;
    }

    public void setId_entrada_item(int id_entrada_item) {
        this.id_entrada_item = id_entrada_item;
    }

    public int getProduto_id_produto() {
        return produto_id_produto;
    }

    public void setProduto_id_produto(int produto_id_produto) {
        this.produto_id_produto = produto_id_produto;
    }

    public int getEntrada_id_entrada() {
        return entrada_id_entrada;
    }

    public void setEntrada_id_entrada(int entrada_id_entrada) {
        this.entrada_id_entrada = entrada_id_entrada;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public String getData_entrada() {
        return Data_entrada;
    }

    public void setData_entrada(String Data_entrada) {
        this.Data_entrada = Data_entrada;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

   

   
}

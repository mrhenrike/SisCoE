package Classes;
 
//@author Márison Tamiarana


public class Modelo_Produto {
    
    private int id_produto;
    private int quant_minima;
    private int quant_macro;
    private int categoria_id_produto;
    private String descricao;
    private String data_cad;
    private String unidade;
    private String macro;
    private String solicita_lote;
    private String solicita_devolucao;
    private String Identificacao;
    private String pesquisa;
    private String situacao;
    private String nome_categoria;
    private double quant_estoque;
    private double preco;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuant_minima() {
        return quant_minima;
    }

    public void setQuant_minima(int quant_minima) {
        this.quant_minima = quant_minima;
    }

    public int getQuant_macro() {
        return quant_macro;
    }

    public void setQuant_macro(int quant_macro) {
        this.quant_macro = quant_macro;
    }

    public int getCategoria_id_produto() {
        return categoria_id_produto;
    }

    public void setCategoria_id_produto(int categoria_id_produto) {
        this.categoria_id_produto = categoria_id_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_cad() {
        return data_cad;
    }

    public void setData_cad(String data_cad) {
        this.data_cad = data_cad;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getMacro() {
        return macro;
    }

    public void setMacro(String macro) {
        this.macro = macro;
    }

    public String getSolicita_lote() {
        return solicita_lote;
    }

    public void setSolicita_lote(String solicita_lote) {
        this.solicita_lote = solicita_lote;
    }

    public String getSolicita_devolucao() {
        return solicita_devolucao;
    }

    public void setSolicita_devolucao(String solicita_devolucao) {
        this.solicita_devolucao = solicita_devolucao;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getQuant_estoque() {
        return quant_estoque;
    }

    public void setQuant_estoque(double quant_estoque) {
        this.quant_estoque = quant_estoque;
    }
    
    public String getIdentificacao() {
        return Identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.Identificacao = identificacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

   
}
    
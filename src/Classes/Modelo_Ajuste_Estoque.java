package Classes;

// @author Márison Tamiarana

public class Modelo_Ajuste_Estoque {

    private int id_ajuste_estoque;
    private int produto_id_produto;
    private int lote_id_lote;
    private int usuario_id_usuario;
    private String motivo;
    private String observacao;
    private String data_ajuste;
    private double quantidade;
    private double media;
    private double total;

    public int getId_ajuste_estoque() {
        return id_ajuste_estoque;
    }

    public void setId_ajuste_estoque(int id_ajuste_estoque) {
        this.id_ajuste_estoque = id_ajuste_estoque;
    }

    public int getProduto_id_produto() {
        return produto_id_produto;
    }

    public void setProduto_id_produto(int produto_id_produto) {
        this.produto_id_produto = produto_id_produto;
    }

    public int getLote_id_lote() {
        return lote_id_lote;
    }

    public void setLote_id_lote(int lote_id_lote) {
        this.lote_id_lote = lote_id_lote;
    }

    public int getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public void setUsuario_id_usuario(int usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the data_ajuste
     */
    public String getData_ajuste() {
        return data_ajuste;
    }

    /**
     * @param data_ajuste the data_ajuste to set
     */
    public void setData_ajuste(String data_ajuste) {
        this.data_ajuste = data_ajuste;
    }

    /**
     * @return the media
     */
    public double getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(double media) {
        this.media = media;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
}

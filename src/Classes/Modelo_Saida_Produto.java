package Classes;

//@author Márison Tamiarana

public class Modelo_Saida_Produto {
    
    private int id_saida;
    private int id_saida_item;
    private int id_produto;
    private int turma_id_turma;
    private int disciplina_id_disciplina;
    private double quantidade;
    private String validade;
    private String lote;
    private String pesquisa;
    private String data_saida;
    private String tipo;
    private String observacao;
    private String curso_nome;
    private String turma_turno;
    private String turma_ano;
    private String disciplina_nome;
    private String situacao;
    private int turma_semestre;
    private int vestibular;
    private int disciplina_semestre;
    private int media;//armazenar a media das entradas

    public int getId_saida() {
        return id_saida;
    }

    public void setId_saida(int id_saida) {
        this.id_saida = id_saida;
    }

    public int getId_saida_item() {
        return id_saida_item;
    }

    public void setId_saida_item(int id_saida_item) {
        this.id_saida_item = id_saida_item;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getTurma_id_turma() {
        return turma_id_turma;
    }

    public void setTurma_id_turma(int turma_id_turma) {
        this.turma_id_turma = turma_id_turma;
    }

    public int getDisciplina_id_disciplina() {
        return disciplina_id_disciplina;
    }

    public void setDisciplina_id_disciplina(int curso_id_curso) {
        this.disciplina_id_disciplina = curso_id_curso;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
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

    public String getData_saida() {
        return data_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public String getCurso_nome() {
        return curso_nome;
    }

    public void setCurso_nome(String curso_nome) {
        this.curso_nome = curso_nome;
    }

    public String getTurma_turno() {
        return turma_turno;
    }

    public void setTurma_turno(String turma_turno) {
        this.turma_turno = turma_turno;
    }

    public String getTurma_ano() {
        return turma_ano;
    }

    public void setTurma_ano(String turma_ano) {
        this.turma_ano = turma_ano;
    }

    public String getDisciplina_nome() {
        return disciplina_nome;
    }

    public void setDisciplina_nome(String disciplina_nome) {
        this.disciplina_nome = disciplina_nome;
    }

    public int getTurma_semestre() {
        return turma_semestre;
    }

    public void setTurma_semestre(int turma_semestre) {
        this.turma_semestre = turma_semestre;
    }

    public int getVestibular() {
        return vestibular;
    }

    public void setVestibular(int vestibular) {
        this.vestibular = vestibular;
    }

    public int getDisciplina_semestre() {
        return disciplina_semestre;
    }

    public void setDisciplina_semestre(int disciplina_semestre) {
        this.disciplina_semestre = disciplina_semestre;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

   }

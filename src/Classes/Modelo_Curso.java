package Classes;

//@author Márison Tamiarana

public class Modelo_Curso {

    private int id_curso;
    private String nome_curso;
    private String abrev_curso;
    private String situacao;

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getAbrev_curso() {
        return abrev_curso;
    }

    public void setAbrev_curso(String abrev_curso) {
        this.abrev_curso = abrev_curso;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}

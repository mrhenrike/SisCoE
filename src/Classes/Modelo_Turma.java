package Classes;

//@author Márison Tamiarana
 
public class Modelo_Turma {
    
    private int id_turma;
    private int semestre;
    private int semestre_vestibular;
    private String turno;
    private String ano_turma;
    private String pesquisa;
    private String situacao;
    private String turma;
    private int id_curso;

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getSemestre_vestibular() {
        return semestre_vestibular;
    }

    public void setSemestre_vestibular(int semestre_vestibular) {
        this.semestre_vestibular = semestre_vestibular;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getAno_turma() {
        return ano_turma;
    }

    public void setAno_turma(String ano_turma) {
        this.ano_turma = ano_turma;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
}

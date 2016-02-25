package Classes;

//@author Márison Tamiarana



public class Modelo_Usuario {
    private int id_usuario;
    private String nome;
    private String login;
    private String senha;
    private String telefone;
    private String sexo;
    private String permissao;
    private String data_cad;
    private String Pesquisa;
    private String situacao;
    private String UserLogado;
    private String PermissaoLogada;
    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public String getData_cad() {
        return data_cad;
    }

    public void setData_cad(String data_cad) {
        this.data_cad = data_cad;
    }

    public String getPesquisa() {
        return Pesquisa;
    }

    public void setPesquisa(String Pesquisa) {
        this.Pesquisa = Pesquisa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getUserLogado() {
        return UserLogado;
    }

    public void setUserLogado(String UserLogado) {
        this.UserLogado = UserLogado;
    }

    public String getPermissaoLogada() {
        return PermissaoLogada;
    }

    public void setPermissaoLogada(String PermissaoLogada) {
        this.PermissaoLogada = PermissaoLogada;
    }
    
}

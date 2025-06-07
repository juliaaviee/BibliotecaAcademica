public abstract class Usuario {
    protected String nome;
    protected String matricula;
    protected String cpf;
    protected String email;

    public Usuario(String nome, String matricula, String cpf, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.email = email;
    }

    public abstract String getTipo();

    public String getMatricula() {
        return matricula;
    }

    public String getInfo() {
        return String.format("%s - Nome: %s | Matrícula: %s", getTipo(), nome, matricula);
    }
}

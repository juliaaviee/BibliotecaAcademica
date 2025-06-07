public class Aluno extends Usuario {
    public Aluno(String nome, String matricula, String cpf, String email) {
        super(nome, matricula, cpf, email);
    }

    public String getTipo() {
        return "Aluno";
    }
}

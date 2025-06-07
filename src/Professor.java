public class Professor extends Usuario {
    public Professor(String nome, String matricula, String cpf, String email) {
        super(nome, matricula, cpf, email);
    }

    public String getTipo() {
        return "Professor";
    }
}

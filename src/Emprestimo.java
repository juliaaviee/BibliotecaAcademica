import java.time.LocalDate;
import java.util.List;

public class Emprestimo {
    private static int contador = 1;
    private int numero;
    private Usuario usuario;
    private List<Livro> livros;
    private LocalDate data;
    private boolean ativo;

    public Emprestimo(Usuario usuario, List<Livro> livros) {
        this.numero = contador++;
        this.usuario = usuario;
        this.livros = livros;
        this.data = LocalDate.now();
        this.ativo = true;
    }

    public void finalizar() {
        this.ativo = false;
        for (Livro livro : livros) {
            livro.setDisponivel(true);
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getResumo() {
        return String.format("Empréstimo #%d | Usuário: %s | Data: %s | Status: %s",
            numero, usuario.getMatricula(), data, ativo ? "Ativo" : "Finalizado");
    }
}

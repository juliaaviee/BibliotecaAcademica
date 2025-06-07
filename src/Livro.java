public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int ano;
    private String editora;
    private boolean disponivel;

    public Livro(String titulo, String autor, String isbn, int ano, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
        this.editora = editora;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getInfo() {
        return String.format("ISBN: %s | Título: %s | Autor: %s | Editora: %s | Status: %s",
            isbn, titulo, autor, editora, disponivel ? "Disponível" : "Emprestado");
    }
}

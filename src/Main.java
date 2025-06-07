import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Livro> livros = new ArrayList<>();
    static HashMap<String, Usuario> usuarios = new HashMap<>();
    static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- MENU BIBLIOTECA ---");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Listar Livros");
            System.out.println("4. Realizar Empréstimo");
            System.out.println("5. Devolver Livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); scanner.nextLine();

            switch (opcao) {
                case 1: cadastrarLivro(); break;
                case 2: cadastrarUsuario(); break;
                case 3: listarLivros(); break;
                case 4: realizarEmprestimo(); break;
                case 5: devolverLivro(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    static void cadastrarLivro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt(); scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();

        livros.add(new Livro(titulo, autor, isbn, ano, editora));
        System.out.println("Livro cadastrado com sucesso.");
    }

    static void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Tipo (1-Aluno, 2-Professor): ");
        int tipo = scanner.nextInt(); scanner.nextLine();

        Usuario u = (tipo == 1) ? new Aluno(nome, matricula, cpf, email)
                                : new Professor(nome, matricula, cpf, email);
        usuarios.put(matricula, u);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    static void listarLivros() {
        System.out.println("\n--- LISTA DE LIVROS ---");
        for (Livro livro : livros) {
            System.out.println(livro.getInfo());
        }
    }

    static void realizarEmprestimo() {
        System.out.print("Matrícula do usuário: ");
        String matricula = scanner.nextLine();
        Usuario u = usuarios.get(matricula);
        if (u == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        ArrayList<Livro> livrosSelecionados = new ArrayList<>();
        while (true) {
            System.out.print("ISBN do livro (ou 'fim' para terminar): ");
            String isbn = scanner.nextLine();
            if (isbn.equalsIgnoreCase("fim")) break;

            Livro livro = buscarLivroPorIsbn(isbn);
            if (livro != null && livro.isDisponivel()) {
                livro.setDisponivel(false);
                livrosSelecionados.add(livro);
            } else {
                System.out.println("Livro não encontrado ou indisponível.");
            }
        }

        if (!livrosSelecionados.isEmpty()) {
            emprestimos.add(new Emprestimo(u, livrosSelecionados));
            System.out.println("Empréstimo realizado com sucesso.");
        } else {
            System.out.println("Nenhum livro selecionado.");
        }
    }

    static void devolverLivro() {
        System.out.println("Lista de empréstimos ativos:");
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo()) System.out.println(e.getResumo());
        }

        System.out.print("Digite o número do empréstimo a devolver: ");
        int numero = scanner.nextInt(); scanner.nextLine();
        for (Emprestimo e : emprestimos) {
            if (e.isAtivo() && e.getResumo().contains("#" + numero)) {
                e.finalizar();
                System.out.println("Devolução concluída.");
                return;
            }
        }
        System.out.println("Empréstimo não encontrado.");
    }

    static Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) return livro;
        }
        return null;
    }
}

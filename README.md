# BibliotecaAcademica

BibliotecaAcademica é um sistema simples de gerenciamento de biblioteca acadêmica, baseado em console e desenvolvido em Java. O objetivo principal é simular as operações essenciais de uma biblioteca, como cadastro de livros e usuários, controle de empréstimos e devoluções. O sistema serve como base didática para o entendimento de fluxos comuns em bibliotecas e conceitos de programação orientada a objetos.

## Funcionalidades

- **Gerenciamento de Livros**
  - Cadastro de novos livros com informações como título, autor, ISBN, ano e editora.
  - Listagem de todos os livros da biblioteca, mostrando o status (disponível ou emprestado).

- **Gerenciamento de Usuários**
  - Cadastro de usuários como Alunos ou Professores, armazenando nome, matrícula, CPF e e-mail.
  - Exibição das informações dos usuários e controle de diferentes tipos de usuário por meio de herança.

- **Empréstimos**
  - Permite que usuários realizem empréstimos de um ou mais livros disponíveis, informando matrícula e ISBNs.
  - Controle de empréstimos ativos, associando usuários, livros e datas de empréstimo.

- **Devoluções**
  - Listagem de todos os empréstimos ativos e devolução de livros, atualizando o status para disponível.

## Como Funciona

O programa principal (`Main.java`) apresenta um menu simples com as seguintes opções:

1. **Cadastrar Livro**: Solicita informações do livro e adiciona ao acervo.
2. **Cadastrar Usuário**: Solicita informações do usuário e tipo (Aluno ou Professor), cadastrando-o no sistema.
3. **Listar Livros**: Exibe todos os livros cadastrados com informações e disponibilidade.
4. **Realizar Empréstimo**: Permite que um usuário empreste um ou mais livros disponíveis.
5. **Devolver Livro**: Exibe os empréstimos ativos e permite a devolução.
0. **Sair**: Encerra o programa.

Cada funcionalidade é implementada utilizando conceitos de orientação a objetos:

- **Classes Principais**:
  - `Livro`: Representa um livro.
  - `Usuario` (abstrata): Classe base para usuários.
    - `Aluno`: Usuário do tipo aluno.
    - `Professor`: Usuário do tipo professor.
  - `Emprestimo`: Representa um evento de empréstimo.

## Exemplo de Uso

- Cadastro de livro:
  - Informe título, autor, ISBN, ano e editora ao ser solicitado.
- Cadastro de usuário:
  - Informe nome, matrícula, CPF, e-mail e tipo de usuário.
- Empréstimo de livros:
  - Informe a matrícula do usuário e os ISBNs dos livros desejados.
- Devolução de livros:
  - Escolha o empréstimo ativo que deseja devolver.

## Estrutura do Projeto

```
src/
├── Aluno.java
├── Emprestimo.java
├── Livro.java
├── Main.java
├── Professor.java
└── Usuario.java
```

## Como Executar

1. Compile todos os arquivos Java no diretório `src`:
   ```sh
   javac src/*.java
   ```
2. Execute o programa principal:
   ```sh
   java -cp src Main
   ```

## Observações

- O sistema é totalmente baseado em console e não persiste dados entre execuções.
- O projeto tem finalidade didática para demonstrar conceitos de POO e lógica básica de bibliotecas.

---

Sinta-se livre para customizar e expandir o sistema, adicionando recursos como persistência de dados, autenticação de usuários ou interface gráfica!

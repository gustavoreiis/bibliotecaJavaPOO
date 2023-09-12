package projetoBiblioteca;

public class Main {
    public static void main(String[] args) {
        Livro[] livros = new Livro[3];
        Cliente[] clientes = new Cliente[3];

        clientes[0] = new Cliente("Gustavo", 18, 1234);
        clientes[1] = new Cliente("Lucas", 30, 1234);
        clientes[2] = new Cliente("Julia", 40, 1234);

        livros[0] = new LivroComum("Java POO", "Ricardo", 2010, 200, true);
        livros[1] = new LivroComum("UML", "Bruno", 1990, 150, false);
        livros[2] = new LivroDigital("Paradigamas de Programação", "João", 2020, 100, "PDF", 200);

        Biblioteca biblioteca = new Biblioteca(livros, clientes);

        livros[0].emprestarLivro(livros[0], clientes[0], biblioteca, "10/10/23");
        livros[0].emprestarLivro(livros[0], clientes[2], biblioteca, "10/10/23");
        livros[2].emprestarLivro(livros[2], clientes[2], biblioteca, "10/10/23");


        biblioteca.getEmprestimos()[0].ler(30);
        biblioteca.getEmprestimos()[0].ler(170);
        biblioteca.getEmprestimos()[0].ler(10);
        biblioteca.getEmprestimos()[1].getLivro().devolverLivro(biblioteca.getEmprestimos()[1]);

        livros[1].emprestarLivro(livros[1], clientes[0], biblioteca, "10/10/23");
        biblioteca.mostrarEmprestimos();
        biblioteca.mostrarMembros();
        biblioteca.mostrarCatalogo();
        clientes[0].mostrarHistorico();



    }
}

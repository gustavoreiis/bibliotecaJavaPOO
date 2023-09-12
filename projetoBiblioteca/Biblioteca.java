package projetoBiblioteca;

public class Biblioteca{
    private Livro [] catalogo;
    private Cliente [] membros;
    private int numeroEmprestimos;
    private Emprestimo [] emprestimos;

    // Cliente[] membros, Emprestimo[] emprestimosAtuais
    public Biblioteca(Livro[] catalogo, Cliente[] membros) {
        this.catalogo = catalogo;
        this.membros = membros;
        this.emprestimos = new Emprestimo[100];
    }

    public Livro[] getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Livro[] catalogo) {
        this.catalogo = catalogo;
    }

    public Cliente[] getMembros() {
        return membros;
    }

    public void setMembros(Cliente[] membros) {
        this.membros = membros;
    }


    public int getNumeroEmprestimos() {
        return numeroEmprestimos;
    }

    public void setNumeroEmprestimos(int numeroEmprestimos) {
        this.numeroEmprestimos = numeroEmprestimos;
    }

    public Emprestimo[] getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(Emprestimo[] emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void emprestarLivro() {
        this.numeroEmprestimos ++;
        System.out.println("A Biblioteca já emprestou " + this.numeroEmprestimos + " livros!");
    }

   public void mostrarMembros() {
       System.out.println("---------- LISTA DE MEMBROS ----------");
       for (int i = 0; i < this.membros.length; i++) {
           System.out.println("============================");
           System.out.println("Nome: " + this.membros[i].getNome());
           System.out.println("Idade: " + this.membros[i].getIdade());
       }
   }

    public void mostrarCatalogo() {
        System.out.println("---------- CATÁLOGO DE LIVROS ----------");
        for (int i = 0; i < this.catalogo.length; i++) {
            System.out.println("============================");
            System.out.println("Nome: " + this.catalogo[i].getNome());
            System.out.println("Autor: " + this.catalogo[i].getAutor());
            System.out.println("Número de páginas: " + this.catalogo[i].getNumeroPaginas());
            System.out.println("Ano: " + this.catalogo[i].getAno());
            if (this.catalogo[i].isDisponivel()) {
                System.out.println("Livro disponível.");
            } else {
                System.out.println("Livro indisponível.");
            }
        }
    }

    public void mostrarEmprestimos() {
        System.out.println("----------- LISTA DE EMPRÉSTIMOS -----------");
        for (int i = 0; i < this.numeroEmprestimos; i++) {
            System.out.println("============================");
            System.out.println("Cliente: " + this.emprestimos[i].getCliente().getNome());
            System.out.println("Livro: " + this.emprestimos[i].getLivro().getNome());
            System.out.println("Devolvido: " + this.emprestimos[i].isDevolvido());
        }
    }
}

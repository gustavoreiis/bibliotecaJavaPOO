package projetoBiblioteca;

public class Emprestimo {
    private Livro livro;
    private Pessoa cliente;
    private String dataEmprestimo;
    private int paginaAtual;
    private boolean devolvido;
    private Biblioteca biblioteca;


    public Emprestimo(Livro livro, Pessoa cliente, String dataEmprestimo, Biblioteca biblioteca) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
        this.biblioteca = biblioteca;
        this.paginaAtual = 1;
        this.devolvido = false;
        livro.setDisponivel(false);
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }


    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public void ler(int paginas) {
        System.out.println("----------- RELATÓRIO DE LEITURA ----------");
        if (!this.isDevolvido()) {
            this.paginaAtual += paginas;
            if (this.paginaAtual >= this.getLivro().getNumeroPaginas()) {
                this.ler(true);
            } else {
                System.out.println("O leitor " + this.cliente.getNome() + " leu " + paginas + " páginas do livro '" + this.livro.getNome() + "'!");
                System.out.println("Atualmente, está na página " + this.paginaAtual + ".");
            }
        } else {
            System.out.println("Não é possível ler mais, pois o livro '" + this.getLivro().getNome() + "' já foi devolvido.");
        }
    }
    
    public void ler(boolean terminou) {
        if (terminou) {
            System.out.println("O leitor " + this.cliente.getNome() + " finalizou o livro '" + this.getLivro().getNome());
            this.getLivro().devolverLivro(this);
        }
    }
}

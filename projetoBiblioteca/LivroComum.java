package projetoBiblioteca;

public final class LivroComum extends Livro implements Emprestimos{
    private boolean capaDura;

    public LivroComum(String nome, String autor, int ano, int numeroPaginas, boolean capaDura) {
        super(nome, autor, ano, numeroPaginas);
        this.capaDura = capaDura;
    }

    public boolean isCapaDura() {
        return capaDura;
    }

    public void setCapaDura(boolean capaDura) {
        this.capaDura = capaDura;
    }

    @Override
    public void emprestarLivro(Livro livro, Cliente cliente, Biblioteca biblioteca, String dataEmprestimo) {
        System.out.println("---------- RELATÓRIO DE EMPRÉSTIMO ----------");
        if (livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(this, cliente, dataEmprestimo, biblioteca);
            System.out.println("O cliente " + cliente.getNome() + " emprestou o livro " + livro.getNome());
            if (this.isCapaDura()) {
                System.out.println("O livro é um livro físico e tem capa dura.");
            } else {
                System.out.println("O livro é um livro físico e não tem capa dura.");
            }
            biblioteca.getEmprestimos()[biblioteca.getNumeroEmprestimos()] = emprestimo;
            biblioteca.emprestarLivro();
            cliente.getHistorico()[cliente.getNumeroEmprestimos()] = emprestimo;
            cliente.setNumeroEmprestimos(cliente.getNumeroEmprestimos() + 1);
        } else {
            System.out.println(cliente.getNome() + " deseja emprestar o livro '" + this.getNome() + "', no entanto, o livro não está disponível.");
        }
    }

    @Override
    public void devolverLivro(Emprestimo emprestimo) {
        System.out.println("---------- RELATÓRIO DE DEVOLUÇÃO ----------");
        System.out.println("O livro '" + emprestimo.getLivro().getNome() + "' foi devolvido.");
        emprestimo.setDevolvido(true);
        emprestimo.getLivro().setDisponivel(true);
    }
}

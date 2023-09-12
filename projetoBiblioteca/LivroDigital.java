package projetoBiblioteca;

public final class LivroDigital extends Livro implements Emprestimos {
    private String formatoArquivo;
    private float tamanho;

    public LivroDigital(String nome, String autor, int ano, int numeroPaginas, String formatoArquivo, float tamanho) {
        super(nome, autor, ano, numeroPaginas);
        this.formatoArquivo = formatoArquivo;
        this.tamanho = tamanho;
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void emprestarLivro(Livro livro, Cliente cliente, Biblioteca biblioteca, String dataEmprestimo) {
        System.out.println("---------- RELATÓRIO DE EMPRÉSTIMO ----------");
        if (livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, cliente, dataEmprestimo, biblioteca);
            System.out.println("O cliente " + cliente.getNome() + " emprestou o livro " + livro.getNome() + ".");
            System.out.println("O livro é um livro digital, no formato " + this.formatoArquivo + " e tem tamanho " + this.tamanho + "MB.");
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
        System.out.println("O acesso ao livro '" + emprestimo.getLivro().getNome() + "' foi bloqueado.");
        emprestimo.setDevolvido(true);
        emprestimo.getLivro().setDisponivel(true);
    }
}

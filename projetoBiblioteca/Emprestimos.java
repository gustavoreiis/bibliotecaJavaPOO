package projetoBiblioteca;

public interface Emprestimos {
    public void emprestarLivro(Livro livro, Cliente cliente, Biblioteca biblioteca, String dataEmprestimo);
    public void devolverLivro(Emprestimo emprestimo);
}

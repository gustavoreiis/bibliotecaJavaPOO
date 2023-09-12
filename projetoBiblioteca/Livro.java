package projetoBiblioteca;

public abstract class Livro implements Emprestimos{
    private String nome;
    private String autor;
    private int ano;
    private int numeroPaginas;
    private boolean disponivel;

    public Livro(String nome, String autor, int ano, int numeroPaginas) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
        this.numeroPaginas = numeroPaginas;
        this.disponivel = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

package projetoBiblioteca;

public class Cliente extends Pessoa{
    private int telefone;
    private int numeroEmprestimos;
    private Emprestimo [] historico;

    public Cliente(String nome, int idade, int telefone) {
        super(nome, idade);
        this.numeroEmprestimos = 0;
        this.telefone = telefone;
        this.historico = new Emprestimo[100];
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Emprestimo[] getHistorico() {
        return historico;
    }

    public void setHistorico(Emprestimo[] historico) {
        this.historico = historico;
    }

    public int getNumeroEmprestimos() {
        return numeroEmprestimos;
    }

    public void setNumeroEmprestimos(int numeroEmprestimos) {
        this.numeroEmprestimos = numeroEmprestimos;
    }

    public void mostrarHistorico() {
        System.out.println("---------- HISTÓRICO DE EMPRESTIMOS DO(A) " + this.getNome().toUpperCase() + "----------");
        for (int i = 0; i < this.numeroEmprestimos; i++) {
            System.out.println("============================");
            System.out.println("Nome do livro: " + this.getHistorico()[i].getLivro().getNome());
            System.out.println("Devolvido: " + this.getHistorico()[i].isDevolvido());
        }
    }
}

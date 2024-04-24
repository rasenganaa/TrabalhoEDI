public class Categoria {
    private String nome;
    private int identificador;
    private Categoria proximo;

    public Categoria(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
        this.proximo = null;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Categoria getProximo() {
        return proximo;
    }

    public void setProximo(Categoria proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Identificador: " + identificador;
    }
}

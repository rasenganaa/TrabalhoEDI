public class Cliente {
    private String nome;
    private String CNH;
    private String telefone;
    private String CPF;
    private Cliente proximo;
    private Cliente anterior;

    public Cliente(String nome, String CNH, String telefone, String CPF) {
        this.nome = nome;
        this.CNH = CNH;
        this.telefone = telefone;
        this.CPF = CPF;
        this.proximo = null;
        this.anterior = null;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Cliente getProximo() {
        return proximo;
    }

    public void setProximo(Cliente proximo) {
        this.proximo = proximo;
    }

    public Cliente getAnterior() {
        return anterior;
    }
    public void setAnterior(Cliente anterior) {
        this.anterior = anterior;
    }
    @Override
    public String toString() {
        return "Nome: " + nome + ", CNH: " + CNH + ", Telefone: " + telefone + ", CPF: " + CPF;
    }
}


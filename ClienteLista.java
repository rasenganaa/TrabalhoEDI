public class ClienteLista {
    private Cliente primeiro;
    private Cliente ultimo;
    private LocacaoLista locacaoLista;

    public ClienteLista(LocacaoLista locacaoLista) {
        this.primeiro = null;
        this.ultimo = null;
        this.locacaoLista = locacaoLista;
    }

    // Método para incluir um cliente
    public void incluirCliente(Cliente cliente) {
        if (primeiro == null) {
            primeiro = cliente;
            ultimo = cliente;
        } else {
            ultimo.setProximo(cliente);
            ultimo = cliente;
        }
    }

    // Método para excluir um cliente
    // Método que exclui um cliente
public void excluirCliente(String cpf) {
    Cliente atual = primeiro;
    Cliente anterior = null;
    while (atual != null) {
        if (atual.getCPF().equals(cpf)) {
            // Verifica se o cliente está em uso antes de tentar excluí-lo
            if (!locacaoLista.clienteEmUso(cpf)) {
                if (atual == primeiro) {
                    primeiro = primeiro.getProximo();
                    if (primeiro == null) {
                        ultimo = null;
                    }
                } else if (atual == ultimo) {
                    anterior.setProximo(null);
                    ultimo = anterior;
                } else {
                    anterior.setProximo(atual.getProximo());
                }
            } else {
                System.out.println("Não é possível excluir o cliente " + cpf + " porque ele está atualmente atrelado a uma locação.");
            }
            break;
        }
        anterior = atual;
        atual = atual.getProximo();
    }
}


    // Método para editar dados de um cliente
    public void editarCliente(String cpf, Cliente novoCliente) {
        Cliente atual = primeiro;
        while (atual != null) {
            if (atual.getCPF().equals(cpf)) {
                atual.setNome(novoCliente.getNome());
                atual.setCNH(novoCliente.getCNH());
                atual.setTelefone(novoCliente.getTelefone());
                break;
            }
            atual = atual.getProximo();
        }
    }

    // Método para listar todos os clientes
    public void listarClientes() {
        Cliente atual = primeiro;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getProximo();
        }
    }
}


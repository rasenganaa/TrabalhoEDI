public class LocacaoLista {
    private Locacao primeiro;
    private Locacao ultimo;

    public LocacaoLista() {
        this.primeiro = null;
        this.ultimo = null;
    }

    // Método para incluir uma locação
    public void locarVeiculo(Locacao locacao) {
        if (primeiro == null) {
            primeiro = locacao;
            ultimo = locacao;
        } else {
            ultimo.setProximo(locacao);
            ultimo = locacao;
        }
    }

    // Método para devolver um veículo (excluir locação)
    public void devolverVeiculo(String placaVeiculo) {
        Locacao atual = primeiro;
        Locacao anterior = null;

        while (atual != null) {
            if (atual.getPlacaVeiculo().equals(placaVeiculo)) {
                if (atual == primeiro) {
                    primeiro = primeiro.getProximo();
                    if (primeiro == null) {
                        ultimo = null;
                    }
                } else if (atual == ultimo) {
                    ultimo = anterior;
                    ultimo.setProximo(null);
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }

    // Método para listar todas as locações ativas
    public void listarLocacoesAtivas() {
        Locacao atual = primeiro;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getProximo();
        }
    }
    
    public boolean verificarLocacao(String placaVeiculo) {
        Locacao atual = primeiro;
        while (atual != null) {
            if (atual.getPlacaVeiculo().equals(placaVeiculo)) {
                return true; // Se a placa do veículo estiver presente em uma locação ativa
            }
            atual = atual.getProximo();
        }
        return false; // Se a placa do veículo não estiver presente em nenhuma locação ativa
    }

    public boolean verificarDisponibilidade(String placaVeiculo, LocacaoLista locacaoLista) {
        return !locacaoLista.verificarLocacao(placaVeiculo);
    }
    // Método para verificar se há uma locação ativa para a placa do veículo
    public boolean verificarLocacaoAtiva(String placaVeiculo) {
        Locacao atual = primeiro;
        while (atual != null) {
            if (atual.getPlacaVeiculo().equals(placaVeiculo)) {
                return true; // Locação ativa encontrada
            }
            atual = atual.getProximo();
        }
        return false; // Nenhuma locação ativa encontrada
    }
    // Método que verifica se um veículo está sendo usado em alguma locação
public boolean veiculoEmUso(String placa) {
    Locacao atual = primeiro;
    while (atual != null) {
        if (atual.getPlacaVeiculo().equals(placa)) {
            return true;
        }
        atual = atual.getProximo();
    }
    return false;
}
// Método que verifica se um cliente está sendo usado em alguma locação
public boolean clienteEmUso(String cpf) {
    Locacao atual = primeiro;
    while (atual != null) {
        if (atual.getCNHCliente().equals(cpf)) {
            return true;
        }
        atual = atual.getProximo();
    }
    return false;
}

}

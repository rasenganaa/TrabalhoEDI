
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoLista {
    private Veiculo primeiro;
    private Veiculo ultimo;
    private LocacaoLista locacaoLista;

    public VeiculoLista(LocacaoLista locacaoLista) {
        this.primeiro = null;
        this.ultimo = null;
        this.locacaoLista = locacaoLista;
    }

    // Método que cadastra um veículo
    public void cadVeiculo(Veiculo veiculo) {
        if (primeiro == null) {
            primeiro = veiculo;
            ultimo = veiculo;
        } else {
            ultimo.setProximo(veiculo);
            veiculo.setAnterior(ultimo);
            ultimo = veiculo;
        }
    }

    // Método que exclui um veículo
    // Método que exclui um veículo
public void excluirVeiculo(String placa) {
    Veiculo atual = primeiro;
    while (atual != null) {
        if (atual.getPlaca().equals(placa)) {
            // Verifica se o veículo está em uso antes de tentar excluí-lo
            if (!locacaoLista.veiculoEmUso(placa)) {
                if (atual == primeiro) {
                    primeiro = primeiro.getProximo();
                    if (primeiro != null) {
                        primeiro.setAnterior(null);
                    } else {
                        ultimo = null;
                    }
                } else if (atual == ultimo) {
                    ultimo = ultimo.getAnterior();
                    ultimo.setProximo(null);
                } else {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                }
            } else {
                System.out.println("Não é possível excluir o veículo " + placa + " porque ele está atualmente atrelado a uma locação.");
            }
            break;
        }
        atual = atual.getProximo();
    }
}


    // Método que edita dados de um veículo
    public void editarVeiculo(String placa, Veiculo novoVeiculo) {
        Veiculo atual = primeiro;
        while (atual != null) {
            if (atual.getPlaca().equals(placa)) {
                atual.setModelo(novoVeiculo.getModelo());
                atual.setMarca(novoVeiculo.getMarca());
                atual.setAno(novoVeiculo.getAno());
                atual.setPotencia(novoVeiculo.getPotencia());
                atual.setLugares(novoVeiculo.getLugares());
                atual.setCategoria(novoVeiculo.getCategoria());
                break;
            }
            atual = atual.getProximo();
        }
    }

    // Método que listar todos os veículos
    public void listarVeiculos() {
        Veiculo atual = primeiro;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getProximo();
        }
    }
    public void listarVeiculosDoFinalParaInicio() {
        Veiculo atual = ultimo;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getAnterior();
        }
    }
    

    // Método que verifica se uma categoria está sendo usada por algum veículo
    public boolean categoriaEmUso(String nomeCategoria) {
        Veiculo atual = primeiro;
        while (atual != null) {
            if (atual.getCategoria().equals(nomeCategoria)) {
            return true;
        }
        atual = atual.getProximo();
    }
    return false;
}
// Método que retorna uma lista de veículos não locados
public List<Veiculo> getVeiculosNaoLocados() {
    List<Veiculo> veiculosNaoLocados = new ArrayList<>();
    Veiculo atual = primeiro;
    while (atual != null) {
        if (!locacaoLista.veiculoEmUso(atual.getPlaca())) {
            veiculosNaoLocados.add(atual);
        }
        atual = atual.getProximo();
    }
    return veiculosNaoLocados;
}

// Método que imprime os veículos não locados em ordem crescente ou decrescente
public void listarVeiculosNaoLocados(boolean ordemCrescente) {
    List<Veiculo> veiculosNaoLocados = getVeiculosNaoLocados();
    veiculosNaoLocados.sort((v1, v2) -> ordemCrescente ? v1.getPlaca().compareTo(v2.getPlaca()) : v2.getPlaca().compareTo(v1.getPlaca()));
    for (Veiculo veiculo : veiculosNaoLocados) {
        System.out.println(veiculo);
    }
}


    
    public void VeiculosCSV(String arquivo) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;
        boolean primeiraLinha = true; // Flag para indicar se é a primeira linha do arquivo
        while ((linha = leitor.readLine()) != null) {
            if (primeiraLinha) {
                primeiraLinha = false; // Marca que a primeira linha foi lida
                continue; // Pula para a próxima iteração do loop para ignorar a primeira linha
            }
            String[] dados = linha.split(";");
            String placa = dados[0];
            String modelo = dados[1];
            String marca = dados[2];
            int ano = Integer.parseInt(dados[3]);
            int potencia = Integer.parseInt(dados[4]);
            int lugares = Integer.parseInt(dados[5]);
            String categoria = dados[6];
            Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, potencia, lugares, categoria);
            cadVeiculo(veiculo); // Adiciona o veículo à estrutura de dados de veículos
        }
        leitor.close();
    }
    
}

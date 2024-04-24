import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CategoriaLista {
    private Categoria primeiro;
    private Categoria ultimo;
    private VeiculoLista veiculoLista;

    public CategoriaLista(VeiculoLista veiculoLista) {
        this.primeiro = null;
        this.ultimo = null;
        this.veiculoLista = veiculoLista;
    }

    // Método para incluir uma categoria
    public void incluirCategoria(Categoria categoria) {
        if (primeiro == null) {
            primeiro = categoria;
            ultimo = categoria;
        } else {
            ultimo.setProximo(categoria);
            ultimo = categoria;
        }
    }

    // Método para excluir uma categoria
    public void excluirCategoria(int identificador) {
        Categoria atual = primeiro;
        Categoria anterior = null;
        while (atual != null) {
            if (atual.getIdentificador() == identificador) {
            // Verifica se a categoria está em uso antes de tentar excluí-la
                if (!veiculoLista.categoriaEmUso(atual.getNome())) {
                    if (atual == primeiro) {
                    primeiro = primeiro.getProximo();
                        if (primeiro == null) {
                        ultimo = null;
                    }
                }  else if (atual == ultimo) {
                    anterior.setProximo(null);
                    ultimo = anterior;
                } else {
                    anterior.setProximo(atual.getProximo());
                }
            } else {
                System.out.println("Não é possível excluir a categoria " + atual.getNome() + " porque ela está sendo usada por um veículo.");
            }
            break;
        }
        anterior = atual;
        atual = atual.getProximo();
    }
}


    // Método para editar dados de uma categoria
    public void editarCategoria(int identificador, Categoria novaCategoria) {
        Categoria atual = primeiro;
        while (atual != null) {
            if (atual.getIdentificador() == identificador) {
                atual.setNome(novaCategoria.getNome());
                atual.setIdentificador(novaCategoria.getIdentificador());
                break;
            }
            atual = atual.getProximo();
        }
    }

    // Método para listar todas as categorias
    public void listarCategorias() {
        Categoria atual = primeiro;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getProximo();
        }
    }

    // Método para carregar categorias a partir de um arquivo CSV
    public void carregarCategoriasCSV(String arquivo) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;
        boolean primeiraLinha = true; // Variável para controlar se é a primeira linha do arquivo
        while ((linha = leitor.readLine()) != null) {
            if (primeiraLinha) {
                primeiraLinha = false; // Marcar que não é mais a primeira linha
                continue; // Pular para a próxima iteração do loop
            }
            String[] dados = linha.split(";");
            String nome = dados[1];
            int identificador = Integer.parseInt(dados[0]);
            Categoria categoria = new Categoria(nome, identificador);
            incluirCategoria(categoria); // Adiciona a categoria à estrutura de dados de categorias
        }
        leitor.close();
    }
    
}

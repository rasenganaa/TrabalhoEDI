import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        LocacaoLista locacaoLista = new LocacaoLista();
        ClienteLista clienteLista = new ClienteLista(locacaoLista);
        VeiculoLista veiculoLista = new VeiculoLista(locacaoLista);
        CategoriaLista categoriaLista = new CategoriaLista(veiculoLista);


            veiculoLista.VeiculosCSV("Veiculos.csv");
            categoriaLista.carregarCategoriasCSV("Categorias.csv");

        int opcao;
        do {
            System.out.println("\nMenu Inicial:");
            System.out.println("1. Veículos");
            System.out.println("2. Clientes");
            System.out.println("3. Locação");
            System.out.println("4. Categorias");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuVeiculos(scanner, veiculoLista);
                    break;
                case 2:
                    menuClientes(scanner, clienteLista);
                    break;
                case 3:
                    menuLocacoes(scanner, clienteLista, veiculoLista, locacaoLista);
                    break;
                case 4:
                    menuCategorias(scanner, categoriaLista);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void menuVeiculos(Scanner scanner, VeiculoLista veiculoLista) {
        int opcao;
        do {
            System.out.println("\nMenu Veículos");
            System.out.println("1. Incluir veículo");
            System.out.println("2. Excluir veículo");
            System.out.println("3. Listar veículos do início para o final");
            System.out.println("4. Listar veículos do final para o início");
            System.out.println("0. Voltar ao Menu Inicial");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    incluirVeiculo(scanner, veiculoLista);
                    break;
                case 2:
                    excluirVeiculo(scanner, veiculoLista);
                    break;
                case 3:
                    veiculoLista.listarVeiculos();
                    break;
                case 4:
                    veiculoLista.listarVeiculosDoFinalParaInicio();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Inicial...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void incluirVeiculo(Scanner scanner, VeiculoLista veiculoLista) {
        System.out.println("\nInclusão de Veículo");
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite a marca do veículo: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o ano do veículo: ");
        int ano = scanner.nextInt();
        System.out.print("Digite a potência do veículo: ");
        int potencia = scanner.nextInt();
        System.out.print("Digite o número de lugares do veículo: ");
        int lugares = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite a categoria do veículo: ");
        String categoria = scanner.nextLine();

        Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, potencia, lugares, categoria);
        veiculoLista.cadVeiculo(veiculo);
        System.out.println("Veículo incluído com sucesso!");
    }

    public static void excluirVeiculo(Scanner scanner, VeiculoLista veiculoLista) {
        System.out.println("\nExclusão de Veículo");
        System.out.print("Digite a placa do veículo a ser excluído: ");
        String placa = scanner.next();
        veiculoLista.excluirVeiculo(placa);
        System.out.println("Veículo excluído com sucesso!");
    }

    public static void listarVeiculos(VeiculoLista veiculoLista) {
        System.out.println("\nLista de Veículos");
        veiculoLista.listarVeiculos();
    }

    public static void menuClientes(Scanner scanner, ClienteLista clienteLista) {
        int opcao;
        do {
            System.out.println("\nMenu Clientes");
            System.out.println("1. Incluir cliente");
            System.out.println("2. Excluir cliente");
            System.out.println("3. Listar clientes");
            System.out.println("4. Listar clientes do final para o início");
            System.out.println("0. Voltar ao Menu Inicial");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    incluirCliente(scanner, clienteLista);
                    break;
                case 2:
                    excluirCliente(scanner, clienteLista);
                    break;
                case 3:
                    listarClientes(clienteLista);
                    break;
                case 4:
                    clienteLista.listarClientesDoFinalParaInicio();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Inicial...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void incluirCliente(Scanner scanner, ClienteLista clienteLista) {
        System.out.println("\nInclusão de Cliente");
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CNH do cliente: ");
        String CNH = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String CPF = scanner.nextLine();

        Cliente cliente = new Cliente(nome, CNH, telefone, CPF);
        clienteLista.incluirCliente(cliente);
        System.out.println("Cliente incluído com sucesso!");
    }

    public static void excluirCliente(Scanner scanner, ClienteLista clienteLista) {
        System.out.println("\nExclusão de Cliente");
        System.out.print("Digite o CPF do cliente a ser excluído: ");
        String CPF = scanner.next();
        clienteLista.excluirCliente(CPF);
        System.out.println("Cliente excluído com sucesso!");
    }

    public static void listarClientes(ClienteLista clienteLista) {
        System.out.println("\nLista de Clientes");
        clienteLista.listarClientes();
    }

    public static void menuLocacoes(Scanner scanner, ClienteLista clienteLista, VeiculoLista veiculoLista, LocacaoLista locacaoLista) {
        int opcao;
        do {
            System.out.println("\n=== Menu Locação ===");
            System.out.println("1. Locar veículo");
            System.out.println("2. Devolver veículo");
            System.out.println("3. Listar locações ativas");
            System.out.println("0. Voltar ao Menu Inicial");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    locarVeiculo(scanner, veiculoLista, locacaoLista);
                    break;
                case 2:
                    devolverVeiculo(scanner, locacaoLista);
                    break;
                case 3:
                    locacaoLista.listarLocacoesAtivas();
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Inicial...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void locarVeiculo(Scanner scanner, VeiculoLista veiculoLista, LocacaoLista locacaoLista) {
        System.out.println("=== Locar Veículo ===");
        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.next();
        System.out.print("Informe a placa do veículo: ");
        String placa = scanner.next();
        System.out.print("Informe a data de retirada (yyyy-MM-dd): ");
        String dataRetiradaStr = scanner.next();
        System.out.print("Informe a data de devolução (yyyy-MM-dd): ");
        String dataDevolucaoStr = scanner.next();
        System.out.print("Informe o valor a ser pago: ");
        double valorPago = scanner.nextDouble();

        // Converter as strings de data para Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataRetirada = null;
        Date dataDevolucao = null;
        try {
            dataRetirada = dateFormat.parse(dataRetiradaStr);
            dataDevolucao = dateFormat.parse(dataDevolucaoStr);
        } catch (ParseException e) {
            System.out.println("Erro ao analisar a data: " + e.getMessage());
            // Ou você pode escolher tratar de outra forma, como pedir para o usuário fornecer a data novamente
        }

        // Verificar se o veículo está disponível para locação
        if (locacaoLista.verificarDisponibilidade(placa, locacaoLista)) {
            // Criar a locação e adicioná-la à lista de locações
            Locacao locacao = new Locacao(cpf, placa, dataRetirada, dataDevolucao, valorPago);
            locacaoLista.locarVeiculo(locacao);
            System.out.println("Veículo locado com sucesso!");
        } else {
            System.out.println("Veículo indisponível para locação.");
        }
    }

    private static void devolverVeiculo(Scanner scanner, LocacaoLista locacaoLista) {
        System.out.println("=== Devolver Veículo ===");
        System.out.print("Informe a placa do veículo a ser devolvido: ");
        String placa = scanner.next();

        // Verificar se o veículo está em uma locação ativa
        if (locacaoLista.verificarLocacaoAtiva(placa)) {
            // Remover a locação da lista de locações
            locacaoLista.devolverVeiculo(placa);
            System.out.println("Veículo devolvido com sucesso!");
        } else {
            System.out.println("Não há locação ativa para o veículo informado.");
        }
    }

    public static void menuCategorias(Scanner scanner, CategoriaLista categoriaLista) {
        int opcao;
        do {
            System.out.println("\nMenu Categorias");
            System.out.println("1. Incluir categoria");
            System.out.println("2. Excluir categoria");
            System.out.println("3. Listar categorias");
            System.out.println("0. Voltar ao Menu Inicial");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    incluirCategoria(scanner, categoriaLista);
                    break;
                case 2:
                    excluirCategoria(scanner, categoriaLista);
                    break;
                case 3:
                    listarCategorias(categoriaLista);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Inicial...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void incluirCategoria(Scanner scanner, CategoriaLista categoriaLista) {
        System.out.println("\nInclusão de Categoria");
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite o nome da categoria: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o identificador da categoria: ");
        int identificador = scanner.nextInt();

        Categoria categoria = new Categoria(nome, identificador);
        categoriaLista.incluirCategoria(categoria);
        System.out.println("Categoria incluída com sucesso!");
    }

    public static void excluirCategoria(Scanner scanner, CategoriaLista categoriaLista) {
        System.out.println("\nExclusão de Categoria");
        System.out.print("Digite o identificador da categoria a ser excluída: ");
        int identificador = scanner.nextInt();
        categoriaLista.excluirCategoria(identificador);
        System.out.println("Categoria excluída com sucesso!");
    }

    public static void listarCategorias(CategoriaLista categoriaLista) {
        System.out.println("\nLista de Categorias");
        categoriaLista.listarCategorias();
    }
}

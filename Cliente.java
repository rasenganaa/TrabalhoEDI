import java.util.*;

class Cliente {
    String nome;
    String CNH;
    String telefone;
    String CPF;

    Cliente(String nome, String CNH, String telefone, String CPF) {
        this.nome = nome;
        this.CNH = CNH;
        this.telefone = telefone;
        this.CPF = CPF;
    }
}

class Sistema {
    Map<String, Cliente> clientes = new HashMap<>();

    void incluirCliente(Cliente cliente) {
        clientes.put(cliente.CPF, cliente);
    }

    void excluirCliente(String CPF) {
        if (clientes.containsKey(CPF)) {
            clientes.remove(CPF);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    void editarDadosCliente(String CPF, String nome, String CNH, String telefone) {
        if (clientes.containsKey(CPF)) {
            Cliente cliente = clientes.get(CPF);
            cliente.nome = nome;
            cliente.CNH = CNH;
            cliente.telefone = telefone;
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    void listarClientes() {
        for (Cliente cliente : clientes.values()) {
            System.out.println("Nome: " + cliente.nome);
            System.out.println("CNH: " + cliente.CNH);
            System.out.println("Telefone: " + cliente.telefone);
            System.out.println("CPF: " + cliente.CPF);
            System.out.println("--------------------");
        }
    }
}

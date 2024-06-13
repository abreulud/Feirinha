import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

class Cliente {
    private String nome;
    private String tipo; // "consumidor" ou "vendedor"
    private String login;
    private String senha;

    public Cliente(String nome, String tipo, String login, String senha) {
        this.nome = nome;
        this.tipo = tipo;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean verificarLogin(String login, String senha) {
        if (this.tipo.equals("vendedor") && this.login.equals(login) && this.senha.equals(senha)) {
            return true;
        } else {
            System.out.println("Apenas vendedores podem inserir produtos");
            return false;
        }
    }
}

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class Avaliacao {
    private String vendedor;
    private int nota;

    public Avaliacao(String vendedor, int nota) {
        this.vendedor = vendedor;
        this.nota = nota;
    }

    public String getVendedor() {
        return vendedor;
    }

    public int getNota() {
        return nota;
    }
}

public class MercadoDOLivreS {
    private LinkedList<Cliente> clientes;
    private Stack<Produto> produtos;
    private TreeSet<String> compras;
    private Queue<Avaliacao> avaliacoes;

    public MercadoDOLivreS() {
        clientes = new LinkedList<>();
        produtos = new Stack<>();
        compras = new TreeSet<>();
        avaliacoes = new LinkedList<>();
    }

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo do cliente (consumidor ou vendedor): ");
        String tipo = scanner.nextLine();
        System.out.print("Digite o login do cliente: ");
        String login = scanner.nextLine();
        System.out.print("Digite a senha do cliente: ");
        String senha = scanner.nextLine();
        Cliente cliente = new Cliente(nome, tipo, login, senha);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        if (cliente.getTipo().equals("consumidor")) {
            System.out.println("Apenas vendedores podem inserir produtos");
            return;
        }
        System.out.print("Digite o login: ");
        String login = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        if (!cliente.verificarLogin(login, senha)) {
            System.out.println("Login ou senha incorretos.");
            return;
        }
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Digite o preco do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha deixada pelo nextDouble()
        Produto produto = new Produto(nomeProduto, preco);
        produtos.push(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void efetivarCompra() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do consumidor: ");
        String consumidor = scanner.nextLine();
        System.out.print("Digite o nome do produto: ");
        String produto = scanner.nextLine();
        compras.add(consumidor + " comprou " + produto);
        System.out.println("Compra efetivada com sucesso!");
    }

    public void avaliarVendedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do vendedor: ");
        String vendedor = scanner.nextLine();
        System.out.print("Digite a nota do vendedor (0-10): ");
        int nota = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()
        Avaliacao avaliacao = new Avaliacao(vendedor, nota);
        avaliacoes.add(avaliacao);
        System.out.println("Avaliação realizada com sucesso!");
    }

    public void imprimirRelatorio() {
        System.out.println("Relatório de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + ", Tipo: " + cliente.getTipo());
        }

        System.out.println("Relatório de produtos:");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome() + ", Preco: " + produto.getPreco());
        }

        System.out.println("Relatório de compras:");
        for (String compra : compras) {
            System.out.println(compra);
        }

        System.out.println("Relatório de avaliações:");
        for (Avaliacao avaliacao : avaliacoes) {
            System.out.println("Vendedor: " + avaliacao.getVendedor() + ", Nota: " + avaliacao.getNota());
        }
    }

    public static void main(String[] args) {
        MercadoDOLivreS mercadoLivre = new MercadoDOLivreS();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar produto");
            System.out.println("3. Efetivar compra");
            System.out.println("4. Avaliar vendedor");
            System.out.println("5. Imprimir relatório");
            System.out.println("6. Sair do sistema");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

            switch (opcao) {
                case 1:
                    mercadoLivre.cadastrarCliente();
                    break;
                case 2:
                    mercadoLivre.cadastrarProduto();
                    break;
                case 3:
                    mercadoLivre.efetivarCompra();
                    break;
                case 4:
                    mercadoLivre.avaliarVendedor();
                    break;
                case 5:
                    mercadoLivre.imprimirRelatorio();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
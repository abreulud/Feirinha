import java.net.PortUnreachableException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

class Cliente{
    private String nomeDoCliente;
    private String nomeDaLoja;
    private String tipoDeCliente;
    private String loginDoCliente;
    private String senhaDoCliente;

    public Cliente(String nomeDoCliente, String nomeDaLoja, String tipoDeCliente, String loginDoCliente, String senhaDoCliente){
        this.nomeDoCliente = nomeDoCliente;
        this.nomeDaLoja = nomeDaLoja;
        this.tipoDeCliente = tipoDeCliente;
        this.loginDoCliente = loginDoCliente;
        this.senhaDoCliente = senhaDoCliente;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }
    
    public String setNomeDoCliente(){
        return nomeDoCliente;
    }

    public String getNomeDaLoja(){
        return nomeDaLoja;
    }

    public String setNomeDaLoja(){
        return nomeDaLoja;
    }

    public String getTipoDeCliente() {
        return tipoDeCliente;
    }

    public String setTipoDeCliente(){
        return tipoDeCliente;
    }

    public String getLoginDoCliente(){
        return loginDoCliente;
    }

    public String setLoginDoCliente(){
        return loginDoCliente;
    }

    public String getSenhaDoCliente(){
        return senhaDoCliente;
    }

    public String setSenhaDoCliente(){
        return senhaDoCliente;
    }
}

class Produto{
    private String nomeDoProduto;
    private double precoDoProduto;

    public Produto(String nome, double preco){
        this.nomeDoProduto = nomeDoProduto;
        this.precoDoProduto = precoDoProduto;
    }

    public String getNomeDoProduto(){
        return nomeDoProduto;
    }

    public String setNomeDoProduto(){
        return nomeDoProduto;
    }

    public double getPrecoDoProduto(){
        return precoDoProduto;
    }

    public double setPrecoDoProduto(){
        return precoDoProduto;
    }
}

class Avaliacao {
    private String nomeDoVendedor;
    private int notaDoVendedor;

    public Avaliacao(String nomeDoVendedor, int notaDoVendedor) {
        this.nomeDoVendedor = nomeDoVendedor;
        this.notaDoVendedor = notaDoVendedor;
    }

    public String getNomeDoVendedor() {
        return nomeDoVendedor;
    }

    public String setNomeDoVendedor() {
        return nomeDoVendedor;
    }

    public int getNotaDoVendedor() {
        return notaDoVendedor;
    }

    public int setNotaDoVendedor() {
        return notaDoVendedor;
    }
}

public class MercadoDOLivreS{
    private LinkedList<Cliente> clientes; //Lista Duplamente Encadeada
    private Stack<Produto> produtos; //Pinha
    private TreeSet<String> compras; //Árvore
    private Queue<Avaliacao> avaliacoes; //Fila

    public MercadoDOLivreS(){
        clientes = new LinkedList<>();
        produtos = new Stack<>();
        compras = new TreeSet<>();
        avaliacoes = new LinkedList<>();
    }

    public void loginAcesso(){
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("Para acessar digite.");
            System.out.print("Login: ");
            String loginDoCliente = scanner.nextLine();
            System.out.print("Senha: ");
            String senhaDoCliente = scanner.nextLine();
            if (loginDoCliente.equals(loginDoCliente) && this.senhaDoCliente.equals(senhaDoCliente)){
                System.out.print("Sejá bem vido de volta, nome da pessoa.");
            }else{
                System.out.print("Seu Login ou senhaDoCliente estão incorretos.");
                System.out.print("1. Para tentar novamente.");
                System.out.print("2. Para redefinir seu acesso.");
                int opcao = scanner.nextInt();
            }
        }while (condition);
        
    }

    public void cadastrarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu:"); //Menu inicial de cadastro
        System.out.println("1. Para Cliente");
        System.out.println("2. Para Vendedor");
        System.out.print("Escolha o tipoDeCliente de usuário: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()
        String tipoDeCliente;
        if (opcao == 1){
            tipoDeCliente = "Cliente";
            System.out.print("Olá prezado Clinte é bom ter você aqui.");
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite um loginDoCliente: ");
            String loginDoCliente = scanner.nextLine();
            System.out.print("Digite uma senhaDoCliente: ");
            String senhaDoCliente = scanner.nextLine();
        } else if (opcao == 2) {
            tipoDeCliente = "Vendedor";
            System.out.print("Olá prezado Vendedor é bom ter você aqui.");
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o nome da sua Loja: ");
            String nomeDaLoja = scanner.nextLine();
            System.out.print("Digite um loginDoCliente: ");
            String loginDoCliente = scanner.nextLine();
            System.out.print("Digite uma senhaDoCliente: ");
            String senhaDoCliente = scanner.nextLine();
        }else{
            System.out.println("Opção inválida!");
            return; // Sai do método se a opção for inválida
        }
        Cliente cliente = new Cliente(nome, tipoDeCliente, loginDoCliente, senhaDoCliente);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void redefinirAcesso(){
        
    }

    public void cadastrarProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Olá Vendedor ");
        String nome = scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getNomeDoCliente().equals(nome)) {
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
        System.out.print("Digite o loginDoCliente: ");
        String loginDoCliente = scanner.nextLine();
        System.out.print("Digite a senhaDoCliente: ");
        String senhaDoCliente = scanner.nextLine();
        if (!cliente.verificarLogin(loginDoCliente, senhaDoCliente)) {
            System.out.println("Login ou senhaDoCliente incorretos.");
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
        System.out.print("Digite o nome do nomeDoVendedor: ");
        String nomeDoVendedor = scanner.nextLine();
        System.out.print("Digite a notaDoVendedor do nomeDoVendedor (0-10): ");
        int notaDoVendedor = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()
        Avaliacao avaliacao = new Avaliacao(nomeDoVendedor, notaDoVendedor);
        avaliacoes.add(avaliacao);
        System.out.println("Avaliação realizada com sucesso!");
    }

    public void imprimirRelatorio() {
        System.out.println("Relatório de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNomeDoCliente() + ", Tipo: " + cliente.getTipo());
        }

        System.out.println("Relatório de produtos:");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNomeDoCliente() + ", Preco: " + produto.getPreco());
        }

        System.out.println("Relatório de compras:");
        for (String compra : compras) {
            System.out.println(compra);
        }

        System.out.println("Relatório de avaliações:");
        for (Avaliacao avaliacao : avaliacoes) {
            System.out.println("Vendedor: " + avaliacao.getNomeDoVendedor() + ", Nota: " + avaliacao.getNotaDoVendedor());
        }
    }

    public static void main(String[] args) {
        MercadoDOLivreS mercadoLivre = new MercadoDOLivreS();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Login");
            System.out.println("2. Cadastro");
            System.out.println("3. Sair do sistema");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

            switch (opcao) {
                case 1:
                    mercadoLivre.loginAcesso();
                    break;
                case 2:
                    mercadoLivre.cadastrarCliente();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
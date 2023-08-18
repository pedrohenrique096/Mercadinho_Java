package main;

import model.Produto;
import utills.Utils;

import java.util.*;

public class Store {
    static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto,Integer> carrinho;

    public static void main (String[]args){

        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }
    private static void menu(){
        Scanner leia = new Scanner(System.in);
        int opcao;

        while (true) {

            System.out.println("****************************************");
            System.out.println("************Pedro's Store***************");
            System.out.println("****************************************");
            System.out.println("**Selecione uma opção para começarmos!**");
            System.out.println("****************************************");
            System.out.println();
            System.out.println("|   1- CADASTRAR           |");
            System.out.println("|   2- LISTAR PRODUTOS     |");
            System.out.println("|   3- COMPRAR             |");
            System.out.println("|   4- CARRINHO            |");
            System.out.println("|   5- SAIR                |");

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e){
                System.out.println("\nOpção inválida! \n\nDidigite novamente");
                leia.nextLine();
                opcao = 0;
            }

            if (opcao == 7){
                System.out.println("\nObrigado pela preferência!!!");
                leia.close();
                System.exit(0);
            }
            switch (opcao){
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProduto();
                    break;
                case 3:
                    comprarProduto();
                    break;
                case 4:
                    verCarrinho();
                    break;
            }
            }
        }
    private static void cadastrarProduto() {
        System.out.println("Nome do produto: ");
        String nome = input.next();

        System.out.println("Preço do produto: ");
        double preco = input.nextDouble();

        Produto produto = new Produto (nome,preco);
        produtos.add(produto);

        System.out.println(produto.getNomeDoProduto() + " cadastrado com sucesso!");
        menu();
    }
    private static void listarProduto(){
        if (produtos.size() > 0){
            System.out.println("Lista de produtos: \n");

            for (Produto p : produtos){
                System.out.println(p);
            }
        }else {
            System.out.println("Nenhum produto cadastrado!");
        }
        menu();
        }
        private static void comprarProduto(){
            if (produtos.size() > 0){
                System.out.println("Código dos produtos: \n");

                System.out.println("---------Produtos disponíveis----------");
                for (Produto p : produtos){
                    System.out.println(p + "\n");
                }
                int id = Integer.parseInt(input.next());
                boolean produtoPresente = false;

                for (Produto p : produtos){
                    if (p.getId() == id){
                        int quantidade = 0;
                        //Checar se o produto já esra no carrinho. Se tiver eu incremento a quantidade.
                        try {
                            quantidade = carrinho.get(p);
                            carrinho.put(p,quantidade +1);
                        }catch (NullPointerException e){
                            //Se o produto for o primeiro do carrinho
                            carrinho.put(p, 1);
                        }
                        System.out.println(p.getNomeDoProduto()+ " adicionado ao carrinho!");
                        produtoPresente = true;

                        if (produtoPresente){
                            System.out.println("Deseja adicionar outro produto ao carrinho? ");
                            System.out.println("1- Sim \n0-Finalizar a compra.");
                            int op = Integer.parseInt(input.next());

                            if (op == 1){
                                comprarProduto();
                            }else {
                                finalizarCompra();
                            }

                        }
                    }else {
                        System.out.println("Produto não encontrado!");
                        menu();
                    }
                }

            }else {
                System.out.println("Não existem produtos cadastrados!");
            }
        }
        private static void verCarrinho(){
            System.out.println("----Produtos no seu carrinho-----");
            if (carrinho.size() > 0){
                for (Produto p : carrinho.keySet()){
                    System.out.println("Produto: "+p+"\nQuantidade: "+carrinho.get(p));
                }
            }else {
                System.out.println("Carrinho está vazio!");
            }
            menu();
        }
        private static void finalizarCompra(){
        double valorTotal = 0.0;
            System.out.println("Seus produtos: ");
            for (Produto p : carrinho.keySet()){
                int qtd = carrinho.get(p);
                valorTotal += p.getPreco()*qtd;
                System.out.println(p);
                System.out.println("Quantidade: "+ qtd);
                System.out.println("------------------");
            }
            System.out.println("O valor da sua compra é: "+ Utils.doulbleToStrinig(valorTotal));
            carrinho.clear();
            System.out.println("Volte sempre");
            menu();
        }


}


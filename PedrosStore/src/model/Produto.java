package model;

import utills.Utils;

public class Produto {
    private static int count = 1;

    private int id;
    private String nomeDoProduto;
    private double preco;

    public Produto( String nomeDoProduto, double preco) {
        this.id = count;
        this.nomeDoProduto = nomeDoProduto;
        this.preco = preco;
        Produto.count += 1;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Produto.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String toString(){
        return "Id "+ this.getId()+"\nNome: "+ getNomeDoProduto()+"\nPreço: "+ Utils.doulbleToStrinig(this.getPreco());
    }
}

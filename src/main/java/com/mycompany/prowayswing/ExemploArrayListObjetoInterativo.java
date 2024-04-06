/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prowayswing;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ExemploArrayListObjetoInterativo {
    private ArrayList<Produto> produtos = new ArrayList<>();// o escopo é a instancia em si, ou seja, a classe
    private int indiceAtual = 1;
    //CRUD (CREATE, READ, UPDATE, DELETE)
    public void apresentarMenu(){
        //Botão criar, editar, apagar, listar todos, ver detalhes escolhe por nome do produto
        var botoes = new String[]{"Cadastrar", "Editar", "Apagar", "Listar todos", "Produto menor preço", "Calcular total", "Sair"};
    
        var menuEscolhido = 0; // escopo da variável é o método apresentarMenu
        var botaoSairIndice = botoes.length - 1;
        while (menuEscolhido != botaoSairIndice && menuEscolhido != JOptionPane.CLOSED_OPTION){
            menuEscolhido = JOptionPane.showOptionDialog(null, "Escolha o menu desejado", "Sistema ProWay",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botoes,
                    "Cadastrar");
             switch(menuEscolhido){
case 0: cadastrar(); break;
case 1: editar(); break;
case 2: apagar(); break;
case 3: listar(); break;
case 4: apresentarProdutoMenorPreco(); break;
case 5: calcularTotal(); break;
            }
              
                    }
        
        
        
    }
public void cadastrar(){
    var produto = new Produto();// escopo objeto é o método cadastrar
    produto.codigo = indiceAtual;
    produto.nome = JOptionPane.showInputDialog("Informe o nome");
    produto.quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade"));
    produto.precoUnitario = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço unitário"));
    indiceAtual = indiceAtual + 1;
    produtos.add(produto);
}
public void editar() {
    var nomeProdutos = new ArrayList<String>();
    for (int i = 0; i < produtos.size(); i++) {
        var produto = produtos.get(i);
        nomeProdutos.add(produto.codigo + " - " + produto.nome);
    }
    var produtoEscolhido = JOptionPane.showInputDialog(null,"Escolha o produto a ser alterado", "Sistema ProWay",
            JOptionPane.WARNING_MESSAGE,null,nomeProdutos.toArray(),"");
    if (produtoEscolhido == null)
        return;
    for (int i = 0; i <produtos.size(); i++) {
        var produto = produtos.get(i);
        if (produtoEscolhido.equals(produto.codigo + " - " + produto.nome)) {
            produto.nome = JOptionPane.showInputDialog(null,"Informe o nome",produto.nome);
            produto.quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a quantidade",produto.quantidade));
            produto.precoUnitario = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço unitário",produto.precoUnitario));
        }
    
        }
    }
public void apagar () {
    var nomeProdutos = new ArrayList<String>();
for (int i = 0; i <produtos.size(); i++) {
        var produto = produtos.get(i);
        nomeProdutos.add(produto.codigo+ " - "+ produto.nome);
}
    var produtoEscolhido = JOptionPane.showInputDialog(null, "Escolha o produto a ser apagado","Sistema ProWay",JOptionPane.WARNING_MESSAGE,null,nomeProdutos.toArray(),"");
    if (produtoEscolhido == null) {
        JOptionPane.showMessageDialog(null, "Seus produtos não foram excluídos");
        return;
    }
    for (var i = 0; i < produtos.size(); i++){
        var produto = produtos.get(i);
        if (produtoEscolhido.equals(produto.codigo + " - "+produto.nome)){
            produtos.remove(produto);
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
            break;
        }
    }
}
public void listar (){
    var texto = "";
    // Percorrendo cada uma das posições do ArrayList de produtos
    for (var i = 0; i < produtos.size();i++){
        var produto = produtos.get(i);
        texto += "Nome: "+ produto.nome
                + "Quantidade: " + produto.quantidade
                + "Preço Unitário: " + produto.quantidade
                + "Preço total: " + produto.calcularPreco()+ "\n";
       
    }
    JOptionPane.showMessageDialog(null, texto);
}
public void calcularTotal(){
    var total = 0.0;
            for (int i = 0; i < produtos.size(); i++) {
            var produto = produtos.get(i);
            total = total + produto.calcularPreco();
            }
            JOptionPane.showMessageDialog(null, "O valor total dos produtos é: "+ total);
}
public void apresentarProdutoMenorPreco() {
   var nomeProdutoMenorPreco = "";
   var menorPreco = Double.MAX_VALUE;
   for (int i = 0; i < produtos.size(); i++) {
       var produto = produtos.get(i);
       if (produto.precoUnitario < menorPreco) {
           menorPreco = produto.precoUnitario;
           nomeProdutoMenorPreco = produto.nome;
       }
   }
   JOptionPane.showMessageDialog(null, "O produto "+ nomeProdutoMenorPreco + " possuí o menor preço unitário " + menorPreco);
}
public static void main(String[] args) {
            new ExemploArrayListObjetoInterativo().apresentarMenu();
        }
}

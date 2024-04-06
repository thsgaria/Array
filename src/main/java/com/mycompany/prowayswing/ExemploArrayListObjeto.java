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
public class ExemploArrayListObjeto {
    public void exemploArrayListProdutos(){
        var produtos = new ArrayList<Produto>();
        //Instanciando um objeto de Produto
        var produtoXbox = new Produto();
        // Definindo valor para os atributos do Produto
        produtoXbox.nome = "Xbox";
        produtoXbox.quantidade = 2;
        produtoXbox.precoUnitario = 2390.20;
        //Adicionado o objeto no ArrayList de produtos
        produtos.add(produtoXbox);
        
        var produtoPs5 = new Produto();
        produtoPs5.nome = "PS5";
        produtoPs5.precoUnitario = 3300.00;
        produtoPs5.quantidade = 1;
        produtos.add(produtoPs5);
        //Obter o primeiro produto da lista de produtos
        var primeiroProduto = produtos.get(0); // Xbox
        JOptionPane.showMessageDialog(null, primeiroProduto.nome);
    }
        public static void main(String[] args) {
            new ExemploArrayListObjeto().exemploArrayListProdutos();
        }
    
}

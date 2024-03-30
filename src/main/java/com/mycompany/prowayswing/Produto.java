/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prowayswing;

/**
 *
 * @author aluno
 */
public class Produto {
    public String nome;
    public double precoUnitario;
    public int quantidade;
    //Método para calcular e retornar o preço do produto
    //Método com retorno do tipo double
    public double calcularPreco(){
        var preco = quantidade * precoUnitario;
        return preco;
    }
}

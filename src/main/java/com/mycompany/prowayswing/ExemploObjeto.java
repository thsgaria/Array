/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prowayswing;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ExemploObjeto {

    public void executar() {
        //Instanciando(new) um objeto chamado xbox da classe produto
        var xbox = new Produto();
        //Definindo valor para os atributos do objeto xbox
        xbox.nome = "Xbox Series X";
        xbox.quantidade = 2;
        xbox.precoUnitario = 3500.00;
        var precoXbox = xbox.calcularPreco();

        var ps5 = new Produto();
        xbox.nome = "PS5";
        xbox.quantidade = 4;
        xbox.precoUnitario = 3300.00;
        var precops5 = ps5.calcularPreco();

        ps5.precoUnitario = 3150.99;

        JOptionPane.showMessageDialog(null,
                "Nome " + xbox.nome
                + "\nQuantidade: " + xbox.quantidade
                + "\nPreço unitário: " + xbox.precoUnitario
                + "\nPreço produto 1: " + precoXbox
                + "\nNome " + ps5.nome
                + "\nQuantidade: " + ps5.quantidade
                + "\nPreço unitário: " + ps5.precoUnitario
                + "\nPreço produto 2: " + precops5);
    }

    public void executarAluno() {
        //Instanciar um objeto do Aluno
        var thiago = new Aluno();
        thiago.nome = "Thiago com H";
        thiago.cpf = "118.899.369-01";
        thiago.nota1 = 5.0;
        thiago.nota2 = 8.0;
        thiago.nota3 = 6.5;
        var mediaThiago = thiago.calcularMedia();
        var statusThiago = thiago.obterStatus();

        var leonardo = new Aluno();
        leonardo.nome = "Leonardo com D";
        leonardo.cpf = "986.213.540-24";
        leonardo.nota1 = 4.0;
        leonardo.nota2 = 0.2;
        leonardo.nota3 = 10.0;
        JOptionPane.showMessageDialog(null,
                "Aluno 1:" + thiago.nome
                + "\nCPF:" + thiago.cpf
                + "\nMédia: " + mediaThiago
                + "\nStatus:" + statusThiago
                + "\n Aluno 2:" + thiago.nome
                + "\nCPF:" + leonardo.cpf
                + "\nMédia: " + leonardo.calcularMedia()
                + "\nStatus:" + leonardo.obterStatus());
    }

    public void executarAlunoComInteracao() {
        //Instanciar um objeto do Aluno
        var aluno1 = new Aluno();
        aluno1.nome = JOptionPane.showInputDialog("Digite um nome: ");
        aluno1.cpf = JOptionPane.showInputDialog("Digite o seu CPF: ");
        aluno1.nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 1"));
        aluno1.nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 2"));
        aluno1.nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 3"));
        var mediaThiago = aluno1.calcularMedia();
        var statusThiago = aluno1.obterStatus();

        var aluno2 = new Aluno();
        aluno2.nome = JOptionPane.showInputDialog("Digite um nome: ");
        aluno2.cpf = JOptionPane.showInputDialog("Digite seu CPF: ");
        aluno2.nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 1"));
        aluno2.nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 2"));
        aluno2.nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 3"));
        JOptionPane.showMessageDialog(null,
                "Aluno 1:" + aluno1.nome
                + "\nCPF:" + aluno1.cpf
                + "\nMédia: " + mediaThiago
                + "\nStatus:" + statusThiago
                + "\n Aluno 2:" + aluno2.nome
                + "\nCPF:" + aluno2.cpf
                + "\nMédia: " + aluno2.calcularMedia()
                + "\nStatus:" + aluno2.obterStatus());
    }

    public void executarAlunoEnsinoMedio() {
        //Instanciar um objeto do Aluno
        var thiago = new AlunoEnsinoMedio();
        thiago.nome = "Thiago com H";
        thiago.cpf = "118.899.369-01";
        thiago.adicionarNota(5.0);
        thiago.adicionarNota(8.0);
        thiago.adicionarNota(6.5);
        var mediaThiago = thiago.calcularMedia();
        var statusThiago = thiago.obterStatus();

        var leonardo = new AlunoEnsinoMedio();
        leonardo.nome = "Leonardo com D";
        leonardo.cpf = "986.213.540-24";
        leonardo.adicionarNota(4.0);
        leonardo.adicionarNota(0.2);
        leonardo.adicionarNota(10.0);
        JOptionPane.showMessageDialog(null,
                "Aluno 1:" + thiago.nome
                + "\nCPF:" + thiago.cpf
                + "\nMédia: " + mediaThiago
                + "\nStatus:" + statusThiago
                + "\n Aluno 2:" + thiago.nome
                + "\nCPF:" + leonardo.cpf
                + "\nMédia: " + leonardo.calcularMedia()
                + "\nStatus:" + leonardo.obterStatus());
    }

    public void executarPaciente() {
        var jose = new Paciente();
        jose.nome = "José";
        jose.sobrenome = "Da Silva Sauro";
        jose.idade = 56;
        jose.peso = 89;
        jose.altura = 1.79;

        JOptionPane.showMessageDialog(null,
                "Nome " + jose.nome
                + "\nSobrenome: " + jose.sobrenome
                + "\nIdade: " + jose.idade
                + "\nPeso: " + jose.peso
                + "\naltura " + jose.altura
                + "\nIMC: " + jose.calcularImc()
                + "\nStatus: " + jose.obterStatus());
    }

    public static void main(String[] args) {
        new ExemploObjeto().executarPaciente();
    }
}

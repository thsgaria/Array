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
public class ExercicioArrayListAlunoIterativo {

    private final ArrayList<Aluno> alunos = new ArrayList<>();// o escopo é a instancia em si, ou seja, a classe
    private int indiceAtual = 1;

    //CRUD (CREATE, READ, UPDATE, DELETE)
    public void apresentarMenu() {
        //Botão criar, editar, apagar, listar todos, ver detalhes escolhe por nome do produto
        var botoes = new String[]{"Cadastrar", "Editar", "Apagar", "Calcular Média", "Listar todos", "Sair"};

        var menuEscolhido = 0; // escopo da variável é o método apresentarMenu
        var botaoSairIndice = botoes.length - 1;
        while (menuEscolhido != botaoSairIndice && menuEscolhido != JOptionPane.CLOSED_OPTION) {
            menuEscolhido = JOptionPane.showOptionDialog(null, "Escolha o menu desejado", "Sistema ProWay",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    botoes,
                    "Cadastrar");
            switch (menuEscolhido) {
                case 0:
                    cadastrar();
                    break;
                case 1:
                    editar();
                    break;
                case 2:
                    apagar();
                    break;
                case 3:
         //           calcularMedia();
                    break;
                case 4:
                   // listar();
                    break;
            }

        }

    }

    public void cadastrar() {
        var aluno = new Aluno();// escopo objeto é o método cadastrar
        aluno.codigo = indiceAtual;
        aluno.nome = JOptionPane.showInputDialog("Informe o nome");
        aluno.nota1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota1"));
        aluno.nota2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota2"));
        aluno.nota3 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota3"));
        indiceAtual = indiceAtual + 1;
        alunos.add(aluno);
    }

    public void editar() {
        var nomeAlunos = new ArrayList<String>();
        for (int i = 0; i < alunos.size(); i++) {
            var produto = alunos.get(i);
            nomeAlunos.add(produto.codigo + " - " + produto.nome);
        }
        var produtoEscolhido = JOptionPane.showInputDialog(null, "Escolha o aluno a ser alterado", "Sistema ProWay",
                JOptionPane.WARNING_MESSAGE, null, nomeAlunos.toArray(), "");
        if (produtoEscolhido == null) {
            return;
        }
        for (int i = 0; i < alunos.size(); i++) {
            var aluno = alunos.get(i);
            if (produtoEscolhido.equals(aluno.codigo + " - " + aluno.nome)) {
                aluno.nome = JOptionPane.showInputDialog(null, "Informe o nome", aluno.nome);
                aluno.nota1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a nota1", aluno.nota1));
                aluno.nota2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota2", aluno.nota2));
                aluno.nota3 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota3"));
            }

        }
    }

    public void apagar() {
        var nomeAlunos = new ArrayList<String>();
        for (int i = 0; i < alunos.size(); i++) {
            var aluno = alunos.get(i);
            nomeAlunos.add(aluno.codigo + " - " + aluno.nome);
        }
        var alunoEscolhido = JOptionPane.showInputDialog(null, "Escolha o aluno a ser apagado", "Sistema ProWay", JOptionPane.WARNING_MESSAGE, null, nomeAlunos.toArray(), "");
        if (alunoEscolhido == null) {
            JOptionPane.showMessageDialog(null, "Seus alunos não foram excluídos");
            return;
        }
        for (var i = 0; i < alunos.size(); i++) {
            var aluno = alunos.get(i);
            if (alunoEscolhido.equals(aluno.codigo + " - " + aluno.nome)) {
                alunos.remove(aluno);
                JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
                break;
            }
        }
    }
//    public double calcularMedia(){
//     var nomeAlunos = new ArrayList<String>();
//    }
//    for (int i = 0; i < alunos.size(); i++) {
//            var produto = alunos.get(i);
//            nomeAlunos.add(produto.codigo + " - " + produto.nome);
//            JOptionPane.showMessageDialog(null, );
//   
//
//    public static void main(String[] args) {
//        new ExercicioArrayListAlunoIterativo().apresentarMenu();
//    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prowayswing;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Turma {

    public String nome;
    public String descricao;
    public ArrayList<String> alunos = new ArrayList();

    public void adicionarAluno(String aluno) {
        alunos.add(aluno);
    }
}

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
public class AlunoEnsinoMedio {

    public String nome;
    public String cpf;
    public ArrayList<Double> notas = new ArrayList();

    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    public double calcularMedia() {
        var soma = 0.0;
        for (int i = 0; i < notas.size(); i++) {
            var nota = notas.get(i);
            soma = soma + nota;
        }
        var media = soma / notas.size();
        return media;
    }

    public String obterStatus() {
        var media = calcularMedia();
        var status = "";

        if (media < 5) {
            status = "Reprovado";
        } else if (media < 7) {
            status = "Em recuperação";
        } else {
            status = "Aprovado";
        }
        return status;
    }

}

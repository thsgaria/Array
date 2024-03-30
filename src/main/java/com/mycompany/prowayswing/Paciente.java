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
public class Paciente {

    public String nome;
    public String sobrenome;
    public double idade;
    public double peso;
    public double altura;

    public double calcularImc() {
        var imc = peso/(altura * altura);
        return imc;
    }

    public String obterStatus() {
        var imc = calcularImc();
        var status = "";

        if (imc < 18.40) {
            status = "Abaixo do peso";
        }
        else if (imc < 29.90) {
            status = "Levemente acima do peso";
        }
        else if (imc < 34.90) {
            status = "Obesidade grau 1";
        }
        else if (imc < 39.90) {
            status = "Obesidade grau 2";
        }
        else if (imc < 24.90) {
            status = "Peso normal";
        } else {
            status = "Obesidade grau 3 ";
        }
        return status;
    }
}

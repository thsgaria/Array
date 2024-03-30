package com.mycompany.prowayswing;

import javax.swing.JOptionPane;

public class ExemploVetores {

    public static void main(String[] args) {
        // exemplo01();
        exemplo03();
    }

    private static void exemplo01() {
        // String nome1 = "Batman";
        // String nome2 = "Robin";
        // String nome3 = "Mulher Maravilha";
        // Vetor é uma forma de armazenar várias variaveis, cada uma em uma posição diferente
        String[] nomes = new String[3]; // Criando um vetor com 3 posições
        nomes[0] = "Batman"; // Armazenando na primeira posição "Batman"
        nomes[1] = "Robin";
        nomes[2] = "Mulher maravilha";

        nomes[2] = "Wonder Woman"; // Atualizando a terceira posição de "Mulher maravilha" para "Wonder Woman"

        // Apresentar o que está armazenado no vetor
        System.out.println("1º nome: " + nomes[0]);
        System.out.println("2º nome: " + nomes[1]);
        System.out.println("3º nome: " + nomes[2]);
    }

    private static void exemplo02() {
        int[] numeros = new int[5];
        numeros[0] = Integer.parseInt(JOptionPane.showInputDialog("Digite o 1º número"));
        numeros[1] = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2º número"));
        numeros[2] = Integer.parseInt(JOptionPane.showInputDialog("Digite o 3º número"));
        numeros[3] = Integer.parseInt(JOptionPane.showInputDialog("Digite o 4º número"));
        numeros[4] = Integer.parseInt(JOptionPane.showInputDialog("Digite o 5º número"));

        int soma = numeros[0] + numeros[1] + numeros[2] + numeros[3] + numeros[4];

        JOptionPane.showMessageDialog(
                null,
                "Número 01: " + numeros[0]
                + "\nNúmero 02: " + numeros[1]
                + "\nNúmero 03: " + numeros[2]
                + "\nNúmero 04: " + numeros[3]
                + "\nNúmero 05: " + numeros[4]
                + "Soma: " + soma
        );
    }

    private static void exemplo03() {
        int[] numeros = new int[5];
        for (int i = 0; i < 5; i = i + 1) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o número"));
        }

        int soma = 0;
        for (int i = 0; i < numeros.length; i = i + 1) {
            soma = soma + numeros[i];
        }
        
        String texto = "";
        for (int i = 0; i < 5; i = i + 1) {
            texto = texto + "Número: " + numeros[i] + "\n";
        }
        texto = texto + "Soma: " + soma;
        JOptionPane.showMessageDialog(null, texto);
    }
}

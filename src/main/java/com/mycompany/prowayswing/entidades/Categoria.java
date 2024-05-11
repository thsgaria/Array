/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prowayswing.entidades;

/**
 *
 * @author aluno
 */
public class Categoria {

    private int id;
    private String nome;

    public void setId(int idCategoria) {
        id = idCategoria;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nomeCategoria) {
        nome = nomeCategoria;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}

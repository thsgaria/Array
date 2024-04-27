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

    public int id;
    public String nome;
//Refaturação
    @Override
    public String toString() {
        return nome;
    }

}

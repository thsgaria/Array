/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prowayswing.repositorios;

import bancoDados.Banco;
import com.mycompany.prowayswing.entidades.Categoria;
import com.mycompany.prowayswing.entidades.Filme;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class FilmeRepositorio {

    public void inserir(Filme filme) {
        try {
            var conexao = Banco.conectar();
            var query = "INSERT INTO filmes (id_categoria, nome) VALUES (?, ?)";
            var prepareStatement = conexao.prepareStatement(query);
            prepareStatement.setInt(1, filme.categoria.id);
            prepareStatement.setString(2, filme.nome);
            prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Filme filme) {
        try {
            var conexao = Banco.conectar();
            var query = "UPDATE filmes SET id_categoria = ?, nome = ? WHERE id = ?";
            var prepareStatement = conexao.prepareStatement(query);
            prepareStatement.setInt(1, filme.categoria.id);
            prepareStatement.setString(2, filme.nome);
            prepareStatement.setInt(3, filme.id);
            prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void apagar(int id) {
        try {
            var conexao = Banco.conectar();
            var query = "DELETE FROM filmes WHERE id = ?";
            var prepareStatement = conexao.prepareCall(query);
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Filme> obterTodos() {
        var filmes = new ArrayList<Filme>();
        try {
            var conexao = Banco.conectar();
            var query = """
                                    SELECT filmes.id,
                                    categorias.nome AS 'categoria',
                                    filmes.nome FROM filmes
                                    INNER JOIN categorias ON (filmes.id_categoria = categorias.id);""";
            var statement = conexao.createStatement();
            var dados = statement.executeQuery(query);//Tipo ResultSet
            while (dados.next()) {
                var id = Integer.parseInt(dados.getString("id"));
                var nome = dados.getString("nome");
                var categoriaNome = dados.getString("categoria");
                var filme = new Filme ();
                filme.id = id;
                filme.nome = nome;
                filme.categoria = new Categoria ();
                filme.categoria.nome = categoriaNome;
                filmes.add(filme);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filmes;
    }

    public Filme obterPorId(int id) {
        try {
            var conexao = Banco.conectar();
            var query = """
                                SELECT filmes.id,
                                filmes.id_categoria,
                                filmes.nome FROM filmes
                                WHERE id = ?""";
            var prepareStatement = conexao.prepareStatement(query);
            prepareStatement.setInt(1, id);
            var dados = prepareStatement.executeQuery();//Tipo ResultSet
            if (dados.next()) {
                var nome = dados.getString("nome");
                var idCategoria = dados.getInt("id_categoria");
                var filme = new Filme();
                filme.id = id;
                filme.nome = nome;
                filme.categoria = new Categoria();
                filme.categoria.id = idCategoria;
                return filme;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}

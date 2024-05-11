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
            var query = """
                        INSERT INTO filmes (id_categoria, nome, orcamento, bilheteria, diretor, classificacao, dataPublicacao, descricao, duracao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)""";
            var prepareStatement = conexao.prepareStatement(query);
            prepareStatement.setInt(1, filme.getCategoria().getId());
            prepareStatement.setString(2, filme.getNome());
            prepareStatement.setDouble(3, filme.getOrcamento());
            prepareStatement.setDouble(4, filme.getBilheteria());
            prepareStatement.setString(5, filme.getDiretor());
            prepareStatement.setByte(6, filme.getClassificacao());
            prepareStatement.setDate(7, java.sql.Date.valueOf(filme.getDataPublicacao()));
            prepareStatement.setString(8, filme.getDescricao());
            prepareStatement.setTime(9, java.sql.Time.valueOf(filme.getDuracao()));
            prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Filme filme) {
        try {
            var conexao = Banco.conectar();
            var query = """
                        UPDATE filmes SET 
                            id_categoria = ?, 
                            nome = ? ,
                            orcamento = ?,
                            bilheteria = ?,
                            diretor = ?,
                            classificacao = ?,
                            dataPublicacao = ?,
                            descricao = ?,
                            duracao = ?
                        WHERE id = ?""";
            var prepareStatement = conexao.prepareStatement(query);
            prepareStatement.setInt(1, filme.getCategoria().getId());
            prepareStatement.setString(2, filme.getNome());
            prepareStatement.setDouble(3, filme.getOrcamento());
            prepareStatement.setDouble(4, filme.getBilheteria());
            prepareStatement.setString(5, filme.getDiretor());
            prepareStatement.setByte(6, filme.getClassificacao());
            prepareStatement.setDate(7, java.sql.Date.valueOf(filme.getDataPublicacao()));
            prepareStatement.setString(8, filme.getDescricao());
            prepareStatement.setTime(9, java.sql.Time.valueOf(filme.getDuracao()));
            prepareStatement.setInt(10, filme.getId());
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
                var filme = new Filme();
                filme.setId(id);
                filme.setNome(nome);
                var categoria = new Categoria();
                categoria.setNome(categoriaNome);
                filme.setCategoria(categoria);
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
                filme.setId(id);
                filme.setNome(nome);
                var categoria = new Categoria();
                categoria.setId(idCategoria);
                filme.setCategoria(categoria);
                return filme;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}

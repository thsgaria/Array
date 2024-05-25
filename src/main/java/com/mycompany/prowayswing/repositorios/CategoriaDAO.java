package com.mycompany.prowayswing.repositorios;

import com.mycompany.prowayswing.entidades.Categoria;

import java.util.List;


public interface CategoriaDAO {
    void salvar(Categoria categoria);

    void atualizar(Categoria categoria);

    Categoria obterPorId(Long id);

    List<Categoria> obterTodos();

    void apagar(Long id);

}

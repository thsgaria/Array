package com.mycompany.prowayswing.repositorios;

import com.mycompany.prowayswing.entidades.Cliente;

import java.util.List;

public interface ClienteDAO {
    void salvar(Cliente cliente);
    void atualizar(Cliente cliente);
    Cliente obterPorId(Long id);
    List<Cliente> obterTodos();
    void apagar(Long id);
}

package com.mycompany.prowayswing;

import bancoDados.HibernateUtil;
import com.mycompany.prowayswing.entidades.Cliente;
import com.mycompany.prowayswing.repositorios.ClienteDAO;
import com.mycompany.prowayswing.repositorios.ClienteDAOImpl;

import java.time.LocalDate;

public class TestClienteMain {
    public static void main(String[] args) {
        var entityManager = HibernateUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAOImpl(entityManager);

        //var cliente = new Cliente();
        //cliente.setNome("Jacinto da Costa");
        //cliente.setCpf("023.293.293-01");
        //cliente.setDataNascimento(LocalDate.of(1989, 3, 23));

        //clienteDAO.salvar(cliente);
        //var cliente = clienteDAO.obterPorId(1L);
        //cliente.setNome(cliente.getNome() + "Irineu");
        //clienteDAO.atualizar(cliente);

        //SELECT
        var cliente = clienteDAO.obterPorId(1L);
        System.out.println(cliente.getNome());

        var clienteGioavana = new Cliente();
        clienteGioavana.setNome("Giovana Antônia Pereira");
        clienteGioavana.setCpf("966.909.137-32");
        clienteGioavana.setDataNascimento(LocalDate.of(1948, 2, 13));
        //clienteDAO.salvar(clienteGioavana);
        var clientes = clienteDAO.obterTodos();
        for (var clienteIterado : clientes) {
            System.out.println(cliente.getId() + " => " + clienteIterado.getNome());
        }
    }
}

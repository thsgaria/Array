package com.mycompany.prowayswing.repositorios;

import com.mycompany.prowayswing.entidades.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    private EntityManager entityManager;
    //Construtor:construir o objeto com os dados necessários
    //public NomeClasse(parametros)
    public ClienteDAOImpl(EntityManager entityManager){
        //Armazenando o parâmetro entityManager no atributo entityManager da classe, utilizando o this para
        //acessar o entityManager externo do construtor.
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Cliente cliente) {
        var transaction = entityManager.getTransaction();
        try {
            //Iniciando a transação
            transaction.begin();
            //Persistir a entidade cliente no banco de dados
            entityManager.persist(cliente);
            //Concretizar o comando de insert na tabela de clientes
            transaction.commit();


        } catch (RuntimeException e) {
            //Caso de algum erro, verificar se a transação está ativa
            if (transaction.isActive()) {
                //Efetuar o desfazer da transação
                transaction.rollback();
            }
            //Relançar o erro para depois ser tratado
            throw e;
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(cliente);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive())
                transaction.rollback();
            throw e;
        }
    }

    @Override
    public Cliente obterPorId(Long id) {
        //SELECT * FROM clientes WHERE id = id;
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> obterTodos() {
        //SELECT * FROM clientes;
        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
    }

    @Override
    public void apagar(Long id) {
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            var cliente = entityManager.find(Cliente.class, id);
            if (cliente != null)
                //Executando o DELETE FROM clientes WHERE id = id;
                entityManager.remove(cliente);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive())
                transaction.rollback();
        }

    }
}

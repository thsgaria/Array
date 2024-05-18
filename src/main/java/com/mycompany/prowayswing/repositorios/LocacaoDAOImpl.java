package com.mycompany.prowayswing.repositorios;

import com.mycompany.prowayswing.entidades.Cliente;
import com.mycompany.prowayswing.entidades.Locacao;
import jakarta.persistence.EntityManager;

public class LocacaoDAOImpl implements LocacaoDAO {
    private EntityManager entityManager;
    //Construtor:construir o objeto com os dados necessários
    //public NomeClasse(parametros)


    public void LocacaoDAOImpl(EntityManager entityManager) {
        //Armazenando o parâmetro entityManager no atributo entityManager da classe, utilizando o this para
        //acessar o entityManager externo do construtor.
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Locacao locacao) {
        EntityManager entityManager = null;
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(locacao);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void atualizar(Locacao locacao) {
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(locacao);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive())
                transaction.rollback();
            throw e;
        }
    }
}

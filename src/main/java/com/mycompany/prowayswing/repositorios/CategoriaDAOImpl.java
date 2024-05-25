package com.mycompany.prowayswing.repositorios;

import com.mycompany.prowayswing.entidades.Categoria;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {
    private EntityManager entityManager;

    public void CategoriaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Categoria categoria) {
        EntityManager entityManager = null;
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(categoria);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void atualizar(Categoria categoria) {
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(categoria);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive())
                transaction.rollback();
            throw e;
        }
    }

    @Override
    public Categoria obterPorId(Long id) {
        return entityManager.find(Categoria.class, id);
    }

    @Override
    public List<Categoria> obterTodos() {
        return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
    }

    @Override
    public void apagar(Long id) {
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            var categoria = entityManager.find(Categoria.class, id);
            if (categoria != null)
                entityManager.remove(categoria);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive())
                transaction.rollback();
        }


    }
}



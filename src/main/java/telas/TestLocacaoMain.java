package telas;

import bancoDados.HibernateUtil;
import com.mycompany.prowayswing.entidades.Locacao;
import com.mycompany.prowayswing.repositorios.ClienteDAOImpl;
import com.mycompany.prowayswing.repositorios.LocacaoDAOImpl;

import java.time.LocalDateTime;

public class TestLocacaoMain {
    public static void main(String[] args) {
        var entityManager = HibernateUtil.getEntityManager();
        var locacaoDao = new LocacaoDAOImpl(entityManager);
        var clienteDao = new ClienteDAOImpl(entityManager);

        var cliente = clienteDao.obterPorId(1L);
        var locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setDataHoraLocacao(LocalDateTime.of(2024, 5, 25, 17, 34, 0));
        locacao.setValor(200.00);
        locacaoDao.salvar(locacao);
        System.out.println("Locação registrada com sucesso");
        //var locacaoDoBanco = locacaoDao.obterTodos();

    }
}

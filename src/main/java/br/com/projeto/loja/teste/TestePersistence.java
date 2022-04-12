package br.com.projeto.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.projeto.dao.CategoriasDao;
import br.com.projeto.dao.ProdutoDao;
import br.com.projeto.loja.modelo.Categoria;
import br.com.projeto.loja.modelo.Produto;
import br.com.projeto.loja.util.JPAUtil;

public class TestePersistence {

	public static void main(String[] args) {
		
		
		
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);
//        Produto produto = dao.buscaPorId(1l);
//        System.out.println(produto.getNome());
//        List<Produto> todos = dao.mostraTodos();
//        todos.forEach(p -> System.out.println(p.getNome()));
//        System.out.println("----------------------------------");
//        List<Produto> procuraPrNome = dao.procuraPrNome("TV-dobravel");
//        procuraPrNome.forEach(p->System.out.println());
//        System.out.println("----------------------------------");
//        List<Produto> procuraPorCategoria = dao.procuraPorCategoria("CELULARES");
//        procuraPorCategoria.forEach(p->System.out.println(p.getNome()));
//        System.out.println("----------------------------------");
//        BigDecimal preco = dao.procuraPrecoProdutoComNome("tv");
//        System.out.println(preco);
        System.out.println("----------------------------------");
        List<Produto> criteria = dao.buscarPorParametrosCriteria("tv", null, null);
        criteria.forEach(s -> System.out.println(s.getNome()));
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("tv", "smartphone-samsung-galaxy20", new BigDecimal("2000"), celulares );
        
		//temos que instanciar uma factory.
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoriasDao categoriasDao = new CategoriasDao(em);
		ProdutoDao dao = new ProdutoDao(em);
		
		//pegar a transação. so asim é possível fazer a persistencia.sem esquecer de commitar
		em.getTransaction().begin();
		categoriasDao.cadastrar(celulares);
		dao.cadastrar(celular);
		//logo depois o commit
		em.getTransaction().commit();
		em.close();
	}

}

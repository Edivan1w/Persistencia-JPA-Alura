package br.com.projeto.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.dao.CategoriasDao;
import br.com.projeto.dao.ClienteDao;
import br.com.projeto.dao.PedidoDao;
import br.com.projeto.dao.ProdutoDao;
import br.com.projeto.loja.modelo.Categoria;
import br.com.projeto.loja.modelo.Cliente;
import br.com.projeto.loja.modelo.ItemPedido;
import br.com.projeto.loja.modelo.Pedido;
import br.com.projeto.loja.modelo.Produto;
import br.com.projeto.loja.util.JPAUtil;
import br.com.projeto.vo.RelatorioDevendasVo;

public class CadastroPedido {
	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto produto = produtoDao.buscaPorId(1l);
		ClienteDao clienteDao = new ClienteDao(em);
		Cliente cliente = clienteDao.buscaPorId(1l);
		
		 em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionaItem(new ItemPedido(2, pedido, produto));
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		
		
		List<RelatorioDevendasVo> relatorioDevendas = pedidoDao.relatorioDevendas();
		relatorioDevendas.forEach(System.out::println);
		
		em.getTransaction().commit();
		
		BigDecimal valorTotal = pedidoDao.valorTotalVendido();
		System.out.println(valorTotal);
		
		
		
		em.close();
		
		
		
		
	}
	
	
	
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("TELEVISORES");
		Produto celular = new Produto("tv", "smartphone-samsung-galaxy20", new BigDecimal("2000"), celulares );
        
		//temos que instanciar uma factory.
		EntityManager em = JPAUtil.getEntityManager();
		
		Cliente cliente = new Cliente("joao", "123456");
		
		CategoriasDao categoriasDao = new CategoriasDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		
		
		//pegar a transação. so asim é possível fazer a persistencia.sem esquecer de commitar
		em.getTransaction().begin();
		categoriasDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		clienteDao.cadastrar(cliente);
		//logo depois o commit
		em.getTransaction().commit();
		em.close();
	}

}

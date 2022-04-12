package br.com.projeto.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.projeto.loja.modelo.Pedido;
import br.com.projeto.vo.RelatorioDevendasVo;

public class PedidoDao {
	
	private EntityManager em;
	
	public PedidoDao() {}

public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return this.em.createQuery(jpql, BigDecimal.class)
				                  .getSingleResult();
	}
	
	public List<RelatorioDevendasVo> relatorioDevendas(){
		String spql = "SELECT new br.com.projeto.vo."
				     + "RelatorioDevendasVo("
				     + "produto.nome, "
				     +"SUM(item.quantidade), "
				     +"MAX(pedido.data)) "
				     +"FROM Pedido pedido " 
				     +"JOIN pedido.itens item "
				     +"JOIN item.produto produto "
				     +"GROUP BY produto.nome "
				     +"ORDER BY item.quantidade DESC ";
		return this.em.createQuery(spql, RelatorioDevendasVo.class).getResultList();
	}
	
	public Pedido buscarPedidoComCliente(Long id) {
		return this.em.createQuery("SELECT p FROM Pedido p JOIN FETH p.cliente WHARE p.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
				
	}
	
	
	
	
	
	
	
	
	
	
	
}

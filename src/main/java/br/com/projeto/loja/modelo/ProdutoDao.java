package br.com.projeto.loja.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
//O unico objetivo dessa classe será fazer a ponte entre a aplicação e o banco de dados.
public class ProdutoDao {
	
	public ProdutoDao() {}

	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}

	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
	
	public Produto buscaPorId(Long id ) {
		return this.em.find(Produto.class, id);
	}
	
	public List<Produto> mostraTodos(){
		String jpql = "SELECT p FROM Produto p";
		return this.em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> procuraPrNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return this.em.createQuery(jpql, Produto.class)
				       .setParameter("nome", nome)
				       .getResultList();
	}
	public List<Produto> procuraPorCategoria(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return this.em.createQuery(jpql, Produto.class)
				       .setParameter("nome", nome)
				       .getResultList();
	}
	
	public BigDecimal procuraPrecoProdutoComNome(String nome){
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
		return this.em.createQuery(jpql, BigDecimal.class)
				       .setParameter("nome", nome)
				       .getSingleResult();
	}
	
	
	
	
	
	
	
	
	
	
}

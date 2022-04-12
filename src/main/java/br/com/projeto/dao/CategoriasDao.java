package br.com.projeto.dao;

import javax.persistence.EntityManager;

import br.com.projeto.loja.modelo.Categoria;

public class CategoriasDao {

	private EntityManager em;

	public CategoriasDao() {
	}

	public CategoriasDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}

	//para atualizar uma entidade é preciso que a mesma esteja no estado de maneged.
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}

	public void remover(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}

}

package br.com.projeto.dao;

import javax.persistence.EntityManager;

import br.com.projeto.loja.modelo.Cliente;

public class ClienteDao {
	
	private EntityManager em;
    
	public ClienteDao() {}

    public ClienteDao(EntityManager em) {
		this.em = em;
	}
    
    public void cadastrar(Cliente cliente) {
    	this.em.persist(cliente);
    }

	public Cliente buscaPorId(Long id) {
		return this.em.find(Cliente.class, id);
	}
	
	

}

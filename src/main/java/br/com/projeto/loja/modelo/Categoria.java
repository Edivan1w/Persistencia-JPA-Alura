package br.com.projeto.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	
	public Categoria() {}
	
	
	public Categoria(String nomme) {
		super();
		this.nome = nomme;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomme() {
		return nome;
	}
	public void setNomme(String nomme) {
		this.nome = nomme;
	}
	
	
	
}

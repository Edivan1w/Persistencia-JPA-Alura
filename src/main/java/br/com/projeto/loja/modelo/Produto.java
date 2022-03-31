package br.com.projeto.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//MAPEAMENTO DE ENTIDADE.	
//@Entity para dizer que existe uma tabela no banco de dados, e que essa classe é um espelho.
//@Table ensina para o jpa que que o nome da tabela é produtos.
@Entity
@Table(name = "produtos")
public class Produto {
//A jpa assume que os atributos da classe são os mesmos da tabela.	
	@Id // ensina que o id é primary key.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ensina qual a forma de geração da primary key.
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();
	//A JPA fica sabendo automaticamente que existe uma relação entre entidades nesse atributo abaixo.
	//devemos informar a cardinalidade. Nesse caso muitos produtos para uma categoria.
	@ManyToOne
	private Categoria categoria;
	
	public Produto() {}
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
	

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	

}

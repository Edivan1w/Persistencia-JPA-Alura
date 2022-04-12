package br.com.projeto.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private LocalDate data = LocalDate.now();
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	//sempre na frente do oneToMany.
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	
	public Pedido() {}


	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public void adicionaItem(ItemPedido item) {
		item.setPedido(this);
		itens.add(item);
		this.valorTotal = valorTotal.add(item.getValor());
	}

	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Long getId() {
		return id;
	}


	public LocalDate getData() {
		return data;
	}



	
}

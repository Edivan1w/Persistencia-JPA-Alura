package br.com.projeto.vo;

import java.time.LocalDate;

public class RelatorioDevendasVo {
 
	private String nomeDoProduto;
	private Long quantidadeVendida;
	private LocalDate dataUltimaVenda;
	
	public RelatorioDevendasVo(String nomeDoProduto, Long quantidadeVendida, LocalDate dataUltimaVenda) {
		this.nomeDoProduto = nomeDoProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioDevendasVo [nomeDoProduto=" + nomeDoProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}
	
	
	
	
}

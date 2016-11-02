package com.stefanini.modelo;

import java.util.Collection;
import java.util.stream.Collectors;

public class Consulta {

	private Collection<Input> data;

	public Consulta(Collection<Input> data) {
		this.data = data;
	}

	public int getAmoutClients() {
		return this.data.size();
	}

	public int getAmountSalesMan() {
		return this.data.stream().filter(i -> i.getTipo() == TipoArquivo.Salesman).collect(Collectors.toList()).size();
	}

	@Override
	public String toString() {
		return String.format("Total Clientes: %d \n" + "Total Salesman: %d \n" + "ID Mais caro \n", getAmoutClients(),
				getAmountSalesMan(), getMostExpensiveId());
	}

	private int getMostExpensiveId() {

		return 10;
	}
}

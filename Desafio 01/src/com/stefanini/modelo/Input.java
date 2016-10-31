package com.stefanini.modelo;

import java.util.Collection;

public class Input {
	
	private String documentoIdentificador;
	private String nome;
	private TipoArquivo tipo;
	private Collection<Item> itens;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoArquivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArquivo tipo) {
		this.tipo = tipo;
	}

	public String getDocumentoIdentificador() {
		return documentoIdentificador;
	}

	public void setDocumentoIdentificador(String documentoIdentificador) {
		this.documentoIdentificador = documentoIdentificador;
	}

	public Collection<Item> getItens() {
		return itens;
	}

	public void setItens(Collection<Item> itens) {
		this.itens = itens;
	}
}

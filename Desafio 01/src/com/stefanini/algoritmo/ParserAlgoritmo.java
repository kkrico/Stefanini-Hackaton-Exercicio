package com.stefanini.algoritmo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.stefanini.modelo.Input;
import com.stefanini.modelo.Item;
import com.stefanini.modelo.TipoArquivo;

public class ParserAlgoritmo implements IAlgoritmo {

	private String SEPARADORGRUPOITENS = "\\[(.*?)\\]";
	@Override
	public Collection<Input> Executar(String conteudo) {
		
		Collection<Input> resultado = new ArrayList<Input>();
		for(String linha : conteudo.split(System.lineSeparator())){
			Input in = new Input();
			TipoArquivo tipo = GerarTipo(linha);
			
			if(tipo == TipoArquivo.Sales) {
				in.setItens(GerarItens(linha));
			}
			
			in.setTipo(GerarTipo(linha));
			in.setDocumentoIdentificador(GerarDocumentoIdentificador(linha));
			in.setNome(GerarNome(linha));
			resultado.add(in);
		}
		
		return resultado;
	}

	private Collection<Item> GerarItens(String linha) {
		
		Collection<Item> resultado = new ArrayList<Item>();
		Pattern p = Pattern.compile(SEPARADORGRUPOITENS);
		Matcher m = p.matcher(linha);
		String itens = m.group(0);
		
		for(String iten : itens.split(",")) {
			
			String[] campos = iten.split("-");
			Item i = new Item();
			i.setId(Integer.parseInt(campos[0].substring(1, campos[0].length())));
			i.setQuantidade(Integer.parseInt(campos[1]));
			i.setPreco(new BigDecimal(campos[2]));
			
			resultado.add(i);
		}
		
		return resultado;
	}

	private TipoArquivo GerarTipo(String linha) {
		int pos = Integer.parseInt(linha.split("ç")[0]);
		return TipoArquivo.values()[pos-1];
	}

	private String GerarNome(String linha) {
		return linha.split("ç")[2];
	}

	private String GerarDocumentoIdentificador(String linha) {
		return linha.split("ç")[1];
	}
}

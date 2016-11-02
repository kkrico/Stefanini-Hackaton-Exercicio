package com.stefanini.main;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.stefanini.algoritmo.IAlgoritmo;
import com.stefanini.algoritmo.ParserAlgoritmo;
import com.stefanini.modelo.Consulta;
import com.stefanini.modelo.Input;
import com.stefanini.modelo.Item;
import com.stefanini.modelo.TipoArquivo;
import com.stefanini.reader.LogReader;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {

		String local = System.getenv("HOMEPATH") + File.separator  + "data"+ File.separator + "in";
		String textoInput = LogReader.LerArquivos(local);

		IAlgoritmo algoritmo = new ParserAlgoritmo();
		Collection<Input> resultado = algoritmo.Executar(textoInput);
		Consulta consulta = new Consulta(resultado);
		
		System.out.println(consulta);
	}
}

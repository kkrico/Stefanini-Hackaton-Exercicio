package com.stefanini.main;

import java.io.IOException;
import java.util.Collection;

import com.stefanini.algoritmo.IAlgoritmo;
import com.stefanini.algoritmo.ParserAlgoritmo;
import com.stefanini.modelo.Input;
import com.stefanini.reader.LogReader;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		String local = System.getenv("JAVA_HOME") + "\\data\\in";
		String input = LogReader.LerArquivos(local);
		
		IAlgoritmo algoritmo = new ParserAlgoritmo();
		Collection<Input> resultado = algoritmo.Executar(input);
	}
}

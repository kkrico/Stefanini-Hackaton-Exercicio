package com.stefanini.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {

	public static String LerArquivos(String local) throws IOException {

		File dir = new File(local);

		StringBuilder sb = new StringBuilder();
		for (File file : dir.listFiles()) {

			if (file.isFile()) {
				String conteudo = LerConteudoArquivo(file);
				sb.append(conteudo);
			}
		}
		return sb.toString();
	}

	private static String LerConteudoArquivo(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
			line = br.readLine();
		}

		br.close();
		return sb.toString();
	}
}

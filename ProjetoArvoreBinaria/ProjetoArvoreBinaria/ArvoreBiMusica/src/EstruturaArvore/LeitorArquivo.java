package EstruturaArvore;
import java.util.*;
import java.io.*;

public class LeitorArquivo {
	public static ArrayList<String> geraLista() throws IOException {
		FileReader arq = new FileReader("Musica.txt");
		BufferedReader linha = new BufferedReader(arq);
		//faz a leitura da primeira linha do txt
		String aux = linha.readLine();		
		// cria ArrayList para armazenar as linhas do TXT
		ArrayList<String> lista = new ArrayList<>();	
		while (aux != null) {
			String[] dados = aux.split("\n");
			for(int i = 0; i < dados.length; i++)
				lista.add(dados[i]);
			aux = linha.readLine();
		}
		linha.close();
		return lista;
	}
}

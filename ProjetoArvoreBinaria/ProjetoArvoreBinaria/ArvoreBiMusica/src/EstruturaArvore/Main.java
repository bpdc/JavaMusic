package EstruturaArvore;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int totalLinhas = 0;
		int totalPalavras = 0;
		int totalPalavrasDist = 0;
		Palavra palavraLonga = new Palavra("", 0);
		int maior = 0;
		ArrayList<String> linhas = new ArrayList<String>();
		int op;
		BinaryTree<Palavra> palavras = new BinaryTree<>();
		ABB palavrasOcorrencia = new ABB();
		ArrayList<String> ocorrencias = new ArrayList<>();
		Scanner entrada = new Scanner(System.in);
		
		 do{
			System.out.println(""" 
					[1] - CARREGAR TEXTO
					[2] - ESTATISTICAS
					[3] - BUSCA POR PALAVRAS
					[4] - EXIBIÇAO DE TEXTO
					[5] - EXIBICAO POR ORDEM DE OCORRENCIA
					[6] - Encerrar
					
					""");
			
			
					System.out.println("Digite a opçao: ");
					op = entrada.nextInt();
					
					switch(op){
					case 1:
						try {
							linhas = LeitorArquivo.geraLista();
							for(String linha : linhas) {
								String[] temp = linha.split(" ");
								for(int i = 0; i < temp.length; i++) {
									Palavra tempP = new Palavra(temp[i], 1);
									//System.out.print(temp[i] + " ");
									totalPalavras += 1;
									Palavra busca = buscarPalavra(palavras, tempP);
									if(busca != null) {
										busca.setOcorrencia(busca.getOcorrencia() + 1);
									}else {
										adicionarPalavra(palavras, tempP);
										ocorrencias.add(tempP.getPalavra());
										totalPalavrasDist += 1;
										if(tempP.getPalavra().length() > maior) {
											maior = tempP.getPalavra().length();
											palavraLonga = tempP;
										}
									}
								}
							}
						}catch(Exception e) {
							e.printStackTrace();
						}
						
						System.out.println("TEXTO CARREGADO");
						
						break;
					case 2:
						totalLinhas = linhas.size();
						
						System.out.printf(""" 
								###########Estatisticas###########
								Total de Linhas: %d
								Total de Palavras: %d
								Total de Palavras Diferentes: %d
								Palavra mais longa: %s
								##################################
								
								""", totalLinhas, totalPalavras, totalPalavrasDist, palavraLonga.getPalavra());
						
						break;
						
					case 3:
						System.out.println("Digite a a palavra que deseja buscar: ");
						entrada.nextLine();
						String busca = entrada.nextLine();
						Palavra pll = new Palavra(busca.toUpperCase(), 0);
						Palavra result = buscarPalavra(palavras, pll);
						if (result != null) {
							System.out.println("Quantiade de ocorrencias: " + result.getOcorrencia());
						}else {
							System.out.println("Palavra não encontrada");
						}
						break;
					case 4:
						palavras.visitaInOrdem(palavras.root);
						break;
					case 5:
						for(String s : ocorrencias) {
							Palavra p = new Palavra(s, 0);
							Palavra temp = buscarPalavra(palavras, p);
							Node temp1 = new Node(temp);	
							if(palavrasOcorrencia.root() == null){
								palavrasOcorrencia.setRoot(temp1);
							}else {
								palavrasOcorrencia.insere(temp1);
							}
						}
						palavrasOcorrencia.executaInOrdem(palavrasOcorrencia.root());
						break;			
					}
		}while(op != 6);
	}
	public static void adicionarPalavra(BinaryTree<Palavra> p, Palavra palavra) throws Exception{
		Node<Palavra> t = new Node(palavra); 
		
		if(p.isEmpty()) {
			p.addRoot(t);
		}else {
			Node<Palavra> e = p.root;
			Node<Palavra> pai = null;
			while(e != null) {
				pai = e;
				if(palavra.getPalavra().compareTo(e.elemento.getPalavra()) < 0){
					e = p.left(e);
				}
				else if(palavra.getPalavra().compareTo(e.elemento.getPalavra()) > 0){
					e = p.right(e);
				}
			}
			if(palavra.getPalavra().compareTo(pai.elemento.getPalavra()) < 0){
				p.addLeft(t, pai);
			}
			if(palavra.getPalavra().compareTo(pai.elemento.getPalavra()) > 0){
				p.addRight(t, pai);
			}
		}
	}
	public static Palavra buscarPalavra(BinaryTree<Palavra> p, Palavra palavra){
		if(p.root == null) {
			return null;
		}
		Node<Palavra> e = p.root;
		while(e != null) {
			if(palavra.getPalavra().compareTo(e.elemento.getPalavra()) < 0){
				e = p.left(e);
			}
			else if(palavra.getPalavra().compareTo(e.elemento.getPalavra()) > 0){
				e = p.right(e);
			}
			else if(palavra.getPalavra().equals(e.elemento.getPalavra())) {
				return e.elemento;
			}
		}
		return null;
	}

}

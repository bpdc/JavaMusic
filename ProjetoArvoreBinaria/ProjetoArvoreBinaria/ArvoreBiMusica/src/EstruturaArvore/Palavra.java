package EstruturaArvore;
public class Palavra {
	private String palavra;
	private int ocorrencia;
	
	Palavra(String palavra, int ocorrencia){
		this.palavra = palavra;
		this.ocorrencia = ocorrencia;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public int getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(int ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
	public String toString() {
		return palavra + " : " + ocorrencia;
	}
	

}

package univel.br.prova;

public class Produto {
	
	private Long id;
	private String nome;
	private String Qualidade;
	private int quantidade;
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQualidade() {
		return Qualidade;
	}
	public void setQualidade(String qualidade) {
		Qualidade = qualidade;
	}
	


}

package b2w.desafio.model;

public class Planeta {
	private Long id_planeta;
	private String nome;
	private String clima;
	private String terreno;
	private Integer qtd_aparicoes;
	
	public Long getId_planeta() {
		return id_planeta;
	}
	public void setId_planeta(Long id_planeta) {
		this.id_planeta = id_planeta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public Integer getQtd_aparicoes() {
		return qtd_aparicoes;
	}
	public void setQtd_aparicoes(Integer qtd_aparicoes) {
		this.qtd_aparicoes = qtd_aparicoes;
	}
	
	

}

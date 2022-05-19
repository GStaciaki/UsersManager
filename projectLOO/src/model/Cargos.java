package model;

public enum Cargos {

	ESTUDANTE("Estudante"),
	PROFESSOR("Professor"),
	TECLAB("TecnicoLab");
	
	private String descricao;
	
	Cargos(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}

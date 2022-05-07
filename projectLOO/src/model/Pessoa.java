package model;

public class Pessoa {

	private static String nome;
	private static int idade;
	private static String cargo;
	private static String cpf;

	public static String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public static void setCargo(String c) {
		cargo = c;
	}

	public static String getCargo() {
		return cargo;
	}

	public static String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}

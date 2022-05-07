package util;

import java.util.ArrayList;
import java.util.Iterator;

import model.Estudante;
import model.Pessoa;

public class Banco {

	private ArrayList<Pessoa> pessoas = new ArrayList<>();

	public void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	public String imprimeEstudantes() {

		String text = "";

		for (Iterator iterator = pessoas.iterator(); iterator.hasNext();) {
			Pessoa pessoa = (Pessoa) iterator.next();
			text += "Nome: " + Pessoa.getNome() + " Idade: " + Pessoa.getIdade() + "CPF:" + 
			Pessoa.getCpf() + "Cargo: " + Pessoa.getCargo() + "\n";
		}
		return text;
	}

}

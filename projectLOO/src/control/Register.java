package control;

import model.Pessoa;
import util.Banco;

public class Register {

	private static Banco banco = new Banco();

	public static void pessoaRegister(Pessoa pessoa) {
		banco.addPessoa(pessoa);
	}

	public static Pessoa getPessoaInstance() {
		return new Pessoa();
	}
	
	public static String getListStudent() {
		return banco.imprimeEstudantes();
	}

}

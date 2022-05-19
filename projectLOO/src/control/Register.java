package control;

import java.sql.SQLException;

import model.Pessoa;
import util.Banco;

public class Register {

	private static Banco banco = new Banco();

	public static void pessoaRegister(Pessoa pessoa) throws SQLException {
		banco.addUsuario(pessoa);
	}

	public static Pessoa getPessoaInstance() {
		return new Pessoa();
	}
	
	public static String getListStudent() throws SQLException {
		return banco.imprimeUsuarios();
	}

}

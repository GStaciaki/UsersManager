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

	public static String getListUsers() throws SQLException {
		return banco.imprimeUsuarios();
	}
	
	public static void removeUser(int id) throws SQLException {
		banco.removeUsuario(id);
	}

}

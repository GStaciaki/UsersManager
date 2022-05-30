package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import model.Pessoa;
import model.SortByAge;
import model.SortByCargo;
import model.SortByName;

public class Register {

	private static Banco banco = new Banco();
	private static ArrayList<Pessoa> pessoas;
	static Pessoa pessoa;

	public static void pessoaRegister(Pessoa pessoa) throws SQLException {
		banco.addUsuario(pessoa);
	}

	public static Pessoa getPessoaInstance() {
		return new Pessoa();
	}

	public static String[][] getListUsers() throws SQLException {
		populateArrayList();

		return iterateArrayList();
	}

	public static String[][] getUsersByAge() throws SQLException {
		populateArrayList();
		Collections.sort(pessoas, new SortByAge());

		return iterateArrayList();

	}

	public static String[][] getUsersByName() throws SQLException {
		populateArrayList();
		Collections.sort(pessoas, new SortByName());

		return iterateArrayList();

	}

	public static String[][] getUsersByCargo() throws SQLException {
		populateArrayList();
		Collections.sort(pessoas, new SortByCargo());

		return iterateArrayList();
	}

	public static void populateArrayList() throws SQLException {
		pessoas = banco.getUsers();
	}

	public static String[][] iterateArrayList() {

		String[][] dados = new String[pessoas.size()][5];

		for (int i = 0; i < pessoas.size(); i++) {

			pessoa = pessoas.get(i);
			dados[i][0] = "" + pessoa.getIdUser();
			dados[i][1] = pessoa.getNome();
			dados[i][2] = "" + pessoa.getIdade();
			dados[i][3] = pessoa.getCargo();
			dados[i][4] = pessoa.getCpf();
		}
		return dados;
	}

	public static void removeUser(int id) throws SQLException {
		banco.removeUsuario(id);
	}

	public static Pessoa getUser(int id) throws SQLException {
		return banco.getUser(id);
	}

	public static void updateUser(Pessoa pessoa, int id) throws SQLException {
		banco.updateUsuario(pessoa, id);
	}

}

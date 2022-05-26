package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import model.Pessoa;
import model.SortByAge;
import model.SortByCargo;
import model.SortByName;

public class Register {

	private static Banco banco = new Banco();
	static ArrayList<Pessoa> pessoas;
	static Pessoa pessoa;

	public Register() throws SQLException {
		pessoas = banco.getUsers();
	}
	

	public static void pessoaRegister(Pessoa pessoa) throws SQLException {
		banco.addUsuario(pessoa);
	}

	public static Pessoa getPessoaInstance() {
		return new Pessoa();
	}

	public static String getListUsers() throws SQLException {
		pessoas = banco.getUsers();

		return iterateArrayList();
	}

	public static String getUsersByAge() throws SQLException {
		pessoas = banco.getUsers();
		Collections.sort(pessoas, new SortByAge());

		return iterateArrayList();

	}

	public static String getUsersByName() throws SQLException {
		pessoas = banco.getUsers();
		Collections.sort(pessoas, new SortByName());

		return iterateArrayList();

	}
	
	public static String getUsersByCargo() throws SQLException {
		pessoas = banco.getUsers();
		Collections.sort(pessoas, new SortByCargo());
		
		return iterateArrayList();
	}

	public static String iterateArrayList() {

		String text = "";

		for (Iterator<Pessoa> iterator = pessoas.iterator(); iterator.hasNext();) {
			Pessoa pessoa = (Pessoa) iterator.next();
			text += " ID: " + pessoa.getIdUser() + " Nome: " + pessoa.getNome() + " Idade: " + pessoa.getIdade()
					+ " Cargo: " + pessoa.getCargo() + " CPF: " + pessoa.getCpf() + "\n";
		}
		return text;
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

package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Pessoa;

public class Banco {

	public void addUsuario(Pessoa pessoa) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		String nome = pessoa.getNome();
		Integer idade = pessoa.getIdade();
		String cargo = pessoa.getCargo();
		String cpf = pessoa.getCpf();

		Statement stm = connection.createStatement();
		String sqlCommand = "INSERT INTO Pessoa (nome, idade, cargo, cpf) VALUES ('" + nome + "', '" + idade + "' , '"
				+ cargo + "', '" + cpf + "')";
		stm.execute(sqlCommand);
	}

	public String imprimeUsuarios() throws SQLException {

		String text = "";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		Statement stm = connection.createStatement();
		stm.execute("SELECT nome, idade, cargo, cpf FROM Pessoa");

		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			String nome = rst.getString("nome");
			Integer idade = rst.getInt("idade");
			String cargo = rst.getString("cargo");
			String cpf = rst.getString("cpf");
			text += "Nome: " + nome + " Idade: " + idade + " Cargo: " + cargo + " CPF: " + cpf + "\n";
		}

		connection.close();

		return text;
	}

}

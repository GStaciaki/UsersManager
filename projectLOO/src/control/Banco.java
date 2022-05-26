package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Estudante;
import model.Pessoa;
import model.Professor;
import model.TecnicoLab;
import util.ConnectionFactory;

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

		connection.close();
	}

	public ArrayList<Pessoa> getUsers() throws SQLException {
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		Statement stm = connection.createStatement();
		stm.execute("SELECT nome, idade, cargo, cpf, idUser FROM Pessoa");

		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Pessoa pessoa;
			String nome = rst.getString("nome");
			Integer idade = rst.getInt("idade");
			String cargo = rst.getString("cargo");
			String cpf = rst.getString("cpf");
			Integer idUser = rst.getInt("idUser");

			switch (cargo) {

			case "Estudante":
				pessoa = new Estudante();
				break;
			case "Professor":
				pessoa = new Professor();
				break;
			case "Tecnico Lab":
				pessoa = new TecnicoLab();
				break;
			default:
				pessoa = new Pessoa();
			}
			
			pessoa.setNome(nome);
			pessoa.setIdade(idade);
			pessoa.setCpf(cpf);
			pessoa.setIdUser(idUser);

			pessoas.add(pessoa);
		}

		connection.close();
		
		return pessoas;
	}

	public void updateUsuario(Pessoa pessoa, int id) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		String nome = pessoa.getNome();
		Integer idade = pessoa.getIdade();
		String cpf = pessoa.getCpf();
		
		Statement stm = connection.createStatement();
		String sqlCommand = "UPDATE Pessoa SET nome = '" + nome + "', idade = " + idade + ", cpf = '" + cpf + "' WHERE idUser = " + id;
		stm.execute(sqlCommand);

		connection.close();
	}
	
	public void removeUsuario(int id) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		Statement stm = connection.createStatement();
		String sqlCommand = "DELETE FROM Pessoa WHERE idUser = " + id;
		stm.execute(sqlCommand);

		connection.close();
	}
	
	public Pessoa getUser(int id) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

		Statement stm = connection.createStatement();
		String sqlCommand = "SELECT nome, idade, cargo, cpf, idUser FROM Pessoa WHERE idUser = " + id;
		stm.execute(sqlCommand);

		ResultSet rst = stm.getResultSet();
		
		Pessoa pessoa = new Pessoa();
		
		while(rst.next()) {
			String nome = rst.getString("nome");
			Integer idade = rst.getInt("idade");
			String cargo = rst.getString("cargo");
			String cpf = rst.getString("cpf");
			Integer idUser = rst.getInt("idUser");
			
			
			pessoa.setNome(nome);
			pessoa.setIdade(idade);
			pessoa.setCpf(cpf);
			pessoa.setIdUser(idUser);
			pessoa.setCargo(cargo);
		}
		
		connection.close();
		
		return pessoa;
	}
}

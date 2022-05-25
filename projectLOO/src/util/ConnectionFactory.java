package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection recuperarConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost/bancoLOO?useTimeZone=true&serverTimezone=UTC", 
						"dev", "1!2@3#4$dev");
	}
}

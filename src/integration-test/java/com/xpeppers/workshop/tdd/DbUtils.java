package com.xpeppers.workshop.tdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {

	private static Connection connection;

	public static void executeUpdate(String sql) throws SQLException {
		Connection connection = getConnection();
		createStatement(connection).executeUpdate(sql);
	}

	public static ResultSet executeQuery(String sql) throws SQLException {
		Connection connection = getConnection();
		return createStatement(connection).executeQuery(sql);
	}

	public static void closeConnection() throws SQLException {
		if (connection != null)
			connection.close();
	}

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed())
			connection = DriverManager.getConnection("jdbc:sqlite::memory:");

		return connection;
	}

	private static Statement createStatement(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		statement.setQueryTimeout(30);
		return statement;
	}
}

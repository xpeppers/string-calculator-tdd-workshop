package com.xpeppers.workshop.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RepositoryTest {

	@BeforeClass
	public static void prepareDbSchema() throws SQLException {
		DbUtils.executeUpdate("drop table if exists StringCalculator");
		DbUtils.executeUpdate("create table StringCalculator (delimiterAndNumbers string, result integer)");
	}

	@AfterClass
	public static void closeDbConnection() throws SQLException {
		DbUtils.closeConnection();
	}

	@Test
	public void savesDataIntoDb() throws Exception {
		new Repository().save("anyDelimiterAndNumbers", 37);

		ResultSet results = DbUtils.executeQuery("select * from StringCalculator");

		assertTrue(results.next());
		String actualDelimitersAndNumbers = results.getString(1);
		assertEquals("anyDelimiterAndNumbers", actualDelimitersAndNumbers);
		int actualResult = results.getInt(2);
		assertEquals(37, actualResult);
	}
}

package com.example.fillmore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FillmoreSpringbootApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
	}

	@Test
	void testDatabaseConnection() throws Exception {
		assertNotNull(dataSource, "DataSource should not be null");
		try (Connection connection = dataSource.getConnection()) {
			assertNotNull(connection, "Connection should not be null");
			assertTrue(connection.isValid(2), "Connection to Supabase should be valid");

			try (Statement statement = connection.createStatement();
				 ResultSet resultSet = statement.executeQuery("SELECT current_database(), version();")) {
				assertTrue(resultSet.next(), "Query should return result");
				System.out.println(">>> Conectado com sucesso ao Supabase! Banco: " + resultSet.getString(1));
				System.out.println(">>> Versao PostgreSQL: " + resultSet.getString(2));
			}
		}
	}

}


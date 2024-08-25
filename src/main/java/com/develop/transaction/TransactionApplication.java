package com.develop.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class TransactionApplication implements CommandLineRunner {

	@Autowired
    private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		InitItemTable();
	}

	// try-with-resources 활용하기
	void InitItemTable(){

		Path initItemSqlFile = Path.of("InsertItem.sql");

		try(Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement()){

			Files.lines(initItemSqlFile).forEach(line -> {
				try{
					stmt.executeUpdate(line);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			});

		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
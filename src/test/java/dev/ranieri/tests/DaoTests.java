package dev.ranieri.tests;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DaoTests {

    @BeforeAll
    static void setUp(){

        try {
            // it really bad practice to directly store credentials in code
            // "jdbc:postgresql://ranieri-sql-server.postgres.database.azure.com:5432/postgres?user=adamGator&password=gatorfan99!!&ssl=false"
            Connection conn = DriverManager.getConnection(System.getenv("AZURE_SQL_DB"));
            Statement statement = conn.createStatement();
            statement.execute("create table player(\n" +
                    "\tid serial primary key, -- dbeaver does not recognize serial as a keyword, serial is used to make an auto incremeting column\n" +
                    "\tfirst_name varchar(40) not null, -- string data type, specify the max length\n" +
                    "\tlast_name varchar(40) not null,\n" +
                    "\tsalary int check (salary > 0 )\n" +
                    ");");
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    void add_player(){

        try {
            // it really bad practice to directly store credentials in code
            // "jdbc:postgresql://ranieri-sql-server.postgres.database.azure.com:5432/postgres?user=adamGator&password=gatorfan99!!&ssl=false"
            Connection conn = DriverManager.getConnection(System.getenv("AZURE_SQL_DB"));
            System.out.println(conn);

            Statement statement = conn.createStatement();
            statement.execute("insert into player values (606,'Billy','bobson',1000)");

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

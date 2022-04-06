package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {

        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE employees (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(255) NOT NULL,last_name  VARCHAR(255) NOT NULL);");

            // create client table
            jdbcTemplate.execute("CREATE TABLE clients (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            //nothing
        }

        //create a list of first and last names
        List<Object[]> splitUpNames = Stream.of("Java Ninja", "Spring Guru", "Java Guru", "Spring Ninja")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // create a list of client names
        List<String> clientNames = List.of("Alpha", "Beta", "Omega");

        //for each first & last name pair insert an Employee into the database
        for (Object[] name : splitUpNames) {
            jdbcTemplate.execute(String.format("INSERT INTO employees(first_name, last_name) VALUES ('%s','%s')", name[0], name[1]));
        }

        // insert clients
        for (String name : clientNames) {
            jdbcTemplate.execute(String.format("INSERT INTO clients(name) VALUES ('%s')", name));
        }


        //query the database for Employees with first name Java
        jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM employees WHERE first_name = 'Java'",
                        (rs, rowNum) -> new Employee(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
                )
                //print each found employee to the console
                .forEach(employee -> System.out.println(employee.toString()));

        //query for all clients
        jdbcTemplate.query(
                        "SELECT id, name FROM clients",
                        (rs, rowNum) -> new Client(rs.getLong("id"), rs.getString("name"))
                )
                //print each found client to the console
                .forEach(client -> System.out.println(client.toString()));


        //truncate the tables
        jdbcTemplate.execute("TRUNCATE TABLE employees;");
        jdbcTemplate.execute("TRUNCATE TABLE clients;");
        //delete the tables
        jdbcTemplate.execute("DROP TABLE employees");
        jdbcTemplate.execute("DROP TABLE clients");
    }
}

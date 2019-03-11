package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception{
        log.info("create tables");

        jdbcTemplate.execute("drop table customers if exists");

        jdbcTemplate.execute("create table customers("+
                "id serial,first_name varchar(255),last_name varchar(255))");


    }
}

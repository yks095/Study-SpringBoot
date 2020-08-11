package com.kiseok.springbootjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class PostgreSQLRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(PostgreSQLRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()) {   // connection을 try블럭에서 사용하고, 문제가 생기든 정의를 해줌
            logger.info(String.valueOf(dataSource.getClass()));
            logger.info(connection.getMetaData().getDriverName());
            logger.info(connection.getMetaData().getURL());
            logger.info(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE account (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.execute(sql);
        }

        jdbcTemplate.execute("INSERT INTO account VALUES (1, 'kiseok')");
    }
}

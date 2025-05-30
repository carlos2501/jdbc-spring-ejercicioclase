package org.cpl_cursos.jdbcspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class JdbcSpringApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        ConfigurableApplicationContext contexto = SpringApplication.run(JdbcSpringApplication.class, args);
        //JdbcTemplate jdbcTemp =  contexto.getBean(JdbcTemplate.class);

        //System.out.println("Implementación del Pool de conexiones -> " + ds.getClass().getSimpleName());
    }

}

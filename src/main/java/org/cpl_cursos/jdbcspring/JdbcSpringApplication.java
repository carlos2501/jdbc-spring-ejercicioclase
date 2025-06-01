package org.cpl_cursos.jdbcspring;

import org.cpl_cursos.jdbcspring.modelos.Oficina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Si utilizamos @Autowired, la variable jdbTemplate no está disponible dentro del método main por ser este estático.
 * Para poder acceder a la variable, implementamos la interfaz ApplicationRunner e implementamos su método <run> dentro
 * de cual, la variable jdbcTemplate es accesible.
 * Este método <run> se ejecuta inmediatamente después de lanzar la ejecución de <JdbcSpringApplication>.
 */
@SpringBootApplication
public class JdbcSpringApplication implements ApplicationRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(JdbcSpringApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String qry = "SELECT * FROM oficina";
        List<Oficina> oficinas = new ArrayList<>();
        List<Map<String,Object>> filas = jdbcTemplate.queryForList(qry);

        for (Map<String,Object> fila : filas) {
            System.out.println(fila);
        }
    }
}

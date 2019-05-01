package com.grupoasd.pruebatecnica;

import com.grupoasd.services.ImplActivoFijoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.grupoasd.entities")
@ComponentScan({"com.grupoasd.api","com.grupoasd.services"})
@EnableJpaRepositories("com.grupoasd.repositories")
@SpringBootApplication
public class PruebaTecnicaApplication {
    public static Logger logger = LogManager.getLogger(PruebaTecnicaApplication.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("========== BIENVENIDO/A A LA REST API DE LA PRUEBA TÉCNICA PARA GRUPO ASD ==========");
            logger.info("Iniciando REST api...");
            SpringApplication.run(PruebaTecnicaApplication.class, args);
            logger.info("REST api iniciada correctamente.");
            logger.info("Esperando peticiones...");
        } catch (Exception ex) {
            logger.error(ex);
        }
    }
}

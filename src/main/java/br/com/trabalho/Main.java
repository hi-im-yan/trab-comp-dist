package br.com.trabalho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
        "br.com.trabalho.banco"
})
@EnableJpaRepositories(basePackages = {
        "br.com.trabalho.repository"
})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

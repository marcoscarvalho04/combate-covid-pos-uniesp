package br.com.covid.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"br.com.covid"})
@EntityScan(basePackages = {"br.com.covid"})
@EnableJpaRepositories(basePackages = {"br.com.covid"})
public class CovidCombateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidCombateApplication.class,args);
    }

}

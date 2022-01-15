package br.com.covid.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"br.com.covid"})
public class CovidCombateApplication {

    public static void main(String[] args) {

        SpringApplication.run(CovidCombateApplication.class,args);
    }

}

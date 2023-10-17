package br.com.admclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.ecommit.azurecommonslib", "br.com.admclient"})
public class AdmClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdmClientApplication.class, args);
    }
}

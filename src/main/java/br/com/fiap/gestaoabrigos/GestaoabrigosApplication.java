package br.com.fiap.gestaoabrigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoabrigosApplication {
	public static void main(String[] args) {
		// Debug das variáveis de ambiente ao iniciar
		System.out.println("DEBUG DB_HOST: " + System.getenv("DB_HOST"));
		System.out.println("DEBUG DB_PORT: " + System.getenv("DB_PORT"));
		System.out.println("DEBUG DB_NAME: " + System.getenv("DB_NAME"));
		System.out.println("DEBUG DB_USER: " + System.getenv("DB_USER"));
		System.out.println("DEBUG DB_PASS: " + System.getenv("DB_PASS"));

		SpringApplication.run(GestaoabrigosApplication.class, args);
	}

}

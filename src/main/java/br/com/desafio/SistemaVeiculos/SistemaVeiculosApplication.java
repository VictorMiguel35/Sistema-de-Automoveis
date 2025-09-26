package br.com.desafio.SistemaVeiculos;

import br.com.desafio.SistemaVeiculos.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaVeiculosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SistemaVeiculosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.exibeMenu();
	}
}

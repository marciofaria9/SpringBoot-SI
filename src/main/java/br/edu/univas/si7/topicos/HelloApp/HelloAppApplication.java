package br.edu.univas.si7.topicos.HelloApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.si7.topicos.HelloApp.Entities.ProductEntity;
import br.edu.univas.si7.topicos.HelloApp.Repository.ProductRepository;

@SpringBootApplication
public class HelloAppApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(HelloAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		ProductEntity p1 = new ProductEntity(1, "Arroz", 7.30f,false);
		repo.save(p1);
		ProductEntity p2 = new ProductEntity(2, "Feijão", 2.45f, false);
		repo.save(p2);

	}

}

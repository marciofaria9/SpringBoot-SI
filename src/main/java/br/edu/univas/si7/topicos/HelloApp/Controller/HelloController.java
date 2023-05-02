package br.edu.univas.si7.topicos.HelloApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.topicos.HelloApp.Entities.ProductEntity;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping("/v1")
	public String hello() {
		return "Hello World V1";
	}

	@GetMapping("/v3")
	public ProductEntity helloProduct() {
		return new ProductEntity(1, "Product v3", 2.45f, true);
	}
}

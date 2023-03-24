package br.edu.univas.si7.topicos.HelloApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.univas.si7.topicos.HelloApp.Controller.HelloController;
import br.edu.univas.si7.topicos.HelloApp.Controller.ProductController;
import br.edu.univas.si7.topicos.HelloApp.Entities.ProductEntity;
import br.edu.univas.si7.topicos.HelloApp.Service.ProductService;

public class ProductAppTests {

	HelloController controller = new HelloController();

	@Test
	public void testHello() {
		String resultado = controller.hello();
		assertEquals("Hello v1!", resultado);
	}

	@Test
	public void testHelloProduct() {
		ProductEntity product = controller.helloProduct();
		assertEquals(1, product.getCode());
		assertEquals("Product v3", product.getName());
		assertEquals(2.45f, product.getPrice());
	}

}

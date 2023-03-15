package br.edu.univas.si7.topicos.HelloApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.univas.si7.topicos.HelloApp.Controller.ProductController;
import br.edu.univas.si7.topicos.HelloApp.Entities.ProductEntity;

public class ProductAppTests {

	ProductController controller = new ProductController();

	@Test
	public void testHello() {
		String resultado = controller.hello();
		assertEquals("FORA VP!", resultado);
	}

	@Test
	public void testV3() {
		ProductEntity product = controller.helloProduct();
		assertEquals(1, product.getCode());
		assertEquals("Product v3", product.getName());
		assertEquals(2.45f, product.getPrice());

	}

}

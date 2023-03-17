package br.edu.univas.si7.topicos.HelloApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.edu.univas.si7.topicos.HelloApp.Controller.HelloController;
import br.edu.univas.si7.topicos.HelloApp.Controller.ProductController;
import br.edu.univas.si7.topicos.HelloApp.Entities.ProductEntity;

public class ProductAppTests {

	HelloController controller = new HelloController();
	ProductController control = new ProductController();
	

	@Test
	public void testHello() {
		String resultado = controller.hello();
		assertEquals("FORA VP!", resultado);
	}

	@Test
	public void testV3() {
		ProductEntity product = control.helloProduct();
		assertEquals(1, product.getCode());
		assertEquals("Product v3", product.getName());
		assertEquals(2.45f, product.getPrice());

	}

}

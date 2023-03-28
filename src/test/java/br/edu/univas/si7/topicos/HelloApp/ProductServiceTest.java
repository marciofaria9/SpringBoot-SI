package br.edu.univas.si7.topicos.HelloApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.edu.univas.si7.topicos.HelloApp.DTO.ProductDTO;
import br.edu.univas.si7.topicos.HelloApp.Entities.ProductEntity;
import br.edu.univas.si7.topicos.HelloApp.Repository.ProductRepository;
import br.edu.univas.si7.topicos.HelloApp.Service.ProductService;

public class ProductServiceTest {

	private static ProductRepository repo = Mockito.mock(ProductRepository.class);

	private ProductService service = new ProductService(repo);

	@BeforeAll
	public static void setup() {
		ProductEntity prod01 = new ProductEntity(1, "test", 0f, false);
		Mockito.when(repo.findById(1)).thenReturn(Optional.of(prod01));

		List<ProductEntity> listProd = new ArrayList<>();
		listProd.add(prod01);
		Mockito.when(repo.findAll()).thenReturn(listProd);
	}

	@Test
	void testGetAllProducts() {
		List<ProductDTO> allProducts = service.findAll();
		assertNotNull(allProducts);
		assertEquals(1, allProducts.size());
		assertEquals(1, allProducts.get(0).getCode());
	}

	@Test
	void testGetProductById() {
		ProductDTO product = service.findById(1);
		assertNotNull(product);
		assertEquals(1, product.getCode());
	}
}
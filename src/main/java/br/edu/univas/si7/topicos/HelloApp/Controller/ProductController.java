package br.edu.univas.si7.topicos.HelloApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.topicos.HelloApp.DTO.ProductDTO;
import br.edu.univas.si7.topicos.HelloApp.Service.ProductService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDTO> getAllProducts() {
		return service.findAll();
	}

	@GetMapping("/{code}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer code) {
		ProductDTO dto = new ProductDTO(service.findById(code));
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping("/active")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDTO> getAllProductsActive() {
		return service.findAllActive();
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody @Valid ProductDTO product) {
		service.createProduct(product);
	}

	@PutMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProduct(@RequestBody @Valid ProductDTO dto, @PathVariable Integer code) {
		service.updateProduct(service.toEntity(dto), code);
	}

	@DeleteMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Integer code) {
		service.deleteProduct(code);
	}
}

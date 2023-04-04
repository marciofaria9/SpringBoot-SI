package br.edu.univas.si7.topicos.HelloApp.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.topicos.HelloApp.DTO.ProductDTO;
import br.edu.univas.si7.topicos.HelloApp.Entities.ProductEntity;
import br.edu.univas.si7.topicos.HelloApp.Repository.ProductRepository;
import br.edu.univas.si7.topicos.HelloApp.Support.ObjectNotFoundException;
import br.edu.univas.si7.topicos.HelloApp.Support.ProductException;

@Service
public class ProductService {

	private ProductRepository repo;

	@Autowired
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}

	public List<ProductDTO> findAll() {
		return repo.findAll().stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}

	public List<ProductDTO> findAllActive() {
		return repo.findByActive(true).stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}

	public ProductEntity findById(Integer code) {
		Optional<ProductEntity> obj = repo.findById(code);
		ProductEntity entity = obj.orElseThrow(() -> new ObjectNotFoundException("Product " + code + " not found"));
		return entity;
	}

	public void createProduct(ProductDTO product) {
		repo.save(toEntity(product));
	}

	public ProductEntity toEntity(ProductDTO prod) {
		return new ProductEntity(prod.getCode(), prod.getName(), prod.getPrice(), true);
	}

	public void updateProduct(ProductEntity product, Integer code) {
		if (code == null || product == null || code.equals(product.getCode())) {
			throw new ProductException("Invalid product code.");
		}
		ProductEntity existingObj = findById(code);
		updateData(existingObj, product);
		repo.save(existingObj);
	}

	private void updateData(ProductEntity existingObj, ProductEntity obj) {
		existingObj.setName(obj.getName());
	}

}
package br.edu.univas.si7.topicos.HelloApp.DTO;

import br.edu.univas.si7.topicos.HelloApp.Entities.ProductEntity;
import lombok.Data;

@Data
public class ProductDTO {
	private Integer code;
	private String name;
	private float price;
//	private boolean active;

	public ProductDTO(ProductEntity product) {
		this.code = product.getCode();
		this.name = product.getName();
		this.price = product.getPrice();
//		this.active = product.isActive();
	}

}

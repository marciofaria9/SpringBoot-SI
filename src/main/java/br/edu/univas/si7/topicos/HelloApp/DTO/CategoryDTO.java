package br.edu.univas.si7.topicos.HelloApp.DTO;

import br.edu.univas.si7.topicos.HelloApp.Entities.CategoryEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {
	private int code;
	private String name;
	
	public CategoryDTO(CategoryEntity category) {
		this.code = category.getCode();
		this.name = category.getName();	
	}
}

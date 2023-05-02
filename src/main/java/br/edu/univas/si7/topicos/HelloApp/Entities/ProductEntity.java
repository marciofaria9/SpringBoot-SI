package br.edu.univas.si7.topicos.HelloApp.Entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@NoArgsConstructor
public class ProductEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	private String name;
	private float price;
	private boolean active;
	
//	@ManyToOne
//	@JoinColumn(name = "FK_CATEGORY")
//	private CategoryEntity category;

	public ProductEntity(int code, String name, float price, boolean active) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.active = active;
		this.createdAt = LocalDateTime.now();
	}

	@Setter(AccessLevel.NONE)
	private LocalDateTime createdAt;
}

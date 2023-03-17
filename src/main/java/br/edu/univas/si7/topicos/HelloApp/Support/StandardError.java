package br.edu.univas.si7.topicos.HelloApp.Support;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StandardError {
	
	private String message;
	private Integer status;
	private Date date;
	
}

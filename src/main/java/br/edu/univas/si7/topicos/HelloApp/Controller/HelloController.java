package br.edu.univas.si7.topicos.HelloApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping("/v1")
	public String hello() {
		return "FORA VP!";
	}
}

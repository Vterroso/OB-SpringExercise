package com.example.OBEj456;

import com.example.OBEj456.entities.Laptop;
import com.example.OBEj456.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObEj456Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObEj456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);


		//Crear laptop

		Laptop laptop1 = new Laptop(null, "HP", "Pavilion 55", 16, 988.5, true);
		Laptop laptop2 = new Laptop(null, "Lenovo", "G500s", 8, 675.9, false);

		System.out.println("Num laptops en base de datos: " + repository.findAll().size());

		//almacenar
		repository.save(laptop1);
		repository.save(laptop2);
		System.out.println("Num laptops en base de datos: " + repository.findAll().size());


	}

}

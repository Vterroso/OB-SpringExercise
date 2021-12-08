package com.example.OBEj456.controllers;

import com.example.OBEj456.entities.Laptop;
import com.example.OBEj456.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //atributos
    private LaptopRepository laptopRepository;

    //contructor
    public LaptopController(LaptopRepository laptopRepository) {
       this.laptopRepository = laptopRepository;
    }

    //Devolver los ordenadores de la lista
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    //Devolver un ordenador de la lista
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Buscar un libro por id")

    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();

    }



    //guardar un ordenador recibido en base de datos
    @PostMapping("/api/laptops")

    public ResponseEntity<Object> create (@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        if(laptop.getId() !=null){ //Existe la id, por lo que no se puede crear
            log.warn("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result); //
    }

    //Actualizar un ordenador existente en la base de datos
    @PutMapping("/api/laptops")

    public ResponseEntity<Object> update(@RequestBody Laptop laptop){

        if (laptop.getId() == null){ //Si no tiene id no se puede crear
            log.warn("Trying to update a no existent book");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to update a no existent book");
            return ResponseEntity.notFound().build();
        }
        //se guarda la modificación
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //Borrar un ordenador de una base de datos
    @DeleteMapping("/api/laptops/{id}")

    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);;

        return ResponseEntity.noContent().build();
    }

    //Borrar todos los libros de la base de datos
    @DeleteMapping("/api/laptops")

    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for deleting all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.notFound().build();
    }

}

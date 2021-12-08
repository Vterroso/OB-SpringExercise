package com.example.OBSpringExercise1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping ("/hola2")
    public String holaMundo(){return "Hola caracola";}

}

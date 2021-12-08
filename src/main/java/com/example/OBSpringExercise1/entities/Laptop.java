package com.example.OBSpringExercise1.entities;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String marca;
    private String modelo;
    private Integer memoriaRam;
    private Double precio;
    private Boolean ssd;



    //constructores


    public Laptop() {
    }

    public Laptop(Long id, String marca, String modelo, Integer memoriaRam, Double precio, Boolean ssd) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.memoriaRam = memoriaRam;
        this.precio = precio;
        this.ssd = ssd;
    }

    //getter y setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Integer memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getSsd() {
        return ssd;
    }

    public void setSsd(Boolean ssd) {
        this.ssd = ssd;
    }
}



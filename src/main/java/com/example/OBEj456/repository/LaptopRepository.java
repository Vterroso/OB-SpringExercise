package com.example.OBEj456.repository;

import com.example.OBEj456.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository <Laptop, Long> {


}

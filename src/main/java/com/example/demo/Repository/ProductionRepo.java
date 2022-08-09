package com.example.demo.Repository;

import com.example.demo.Entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepo extends JpaRepository<Production, Integer> {
}

package com.example.demo.repositories;

import com.example.demo.models.Activite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {

}

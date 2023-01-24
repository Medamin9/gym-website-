package com.example.demo.repositories;

import com.example.demo.models.Coach;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {

}

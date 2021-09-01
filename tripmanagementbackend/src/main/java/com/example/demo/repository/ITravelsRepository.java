package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Travels;

public interface ITravelsRepository extends JpaRepository<Travels,Long> {

}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Travels;

import org.springframework.stereotype.Repository;

@Repository
public interface ITravelsRepository extends JpaRepository<Travels,Long> {

}

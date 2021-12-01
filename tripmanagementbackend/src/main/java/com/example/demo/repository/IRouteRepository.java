package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Route;


import org.springframework.stereotype.Repository;

@Repository
public interface IRouteRepository extends JpaRepository<Route,Long>{

}

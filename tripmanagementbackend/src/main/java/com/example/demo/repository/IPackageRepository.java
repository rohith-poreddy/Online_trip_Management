package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Package;

import org.springframework.stereotype.Repository;

@Repository
public interface IPackageRepository extends JpaRepository<Package,Long>{

	
}

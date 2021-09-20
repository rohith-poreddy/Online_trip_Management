package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PackageDTO;
import com.example.demo.model.Package;
import com.example.demo.service.IPackageService;

@RestController
@RequestMapping("/package")
public class PackageController {
	
	@Autowired
    private IPackageService service;
	
	@PostMapping("/addpackage")
    public ResponseEntity<PackageDTO> add(@Valid @RequestBody PackageDTO ipackage) {
		return new ResponseEntity<PackageDTO>(service.save(ipackage), HttpStatus.CREATED);
        
    }//AddPackage
	
	@GetMapping("viewallpackages")
	public ResponseEntity<List<Package>> list()
	{
		return  new ResponseEntity<List<Package>>(service.listAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/searchpackage/{id}")
	public ResponseEntity<Package> get(@PathVariable Long id) {
		return new ResponseEntity<Package>(service.get(id), HttpStatus.OK);   
	}//Searching for a particular package i.e SearchPackage
	
	
	
	
	@DeleteMapping("/deletepackage/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<String>("Package deleted successfully!.", HttpStatus.OK);
    }//DeletePackage
	
	
}



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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Travels;

import com.example.demo.service.ITravelsService;

@RestController
@RequestMapping("/travel")
public class TravelController {

	@Autowired
    private ITravelsService service;
	
	@PostMapping("/addTravels")
    public ResponseEntity<Travels> add(@Valid @RequestBody Travels travels) {
		return new ResponseEntity<Travels>(service.save(travels), HttpStatus.CREATED);
        
    }//AddPackage
	
	@GetMapping("viewTravels")
	public ResponseEntity<List<Travels>> list()
	{
		return  new ResponseEntity<List<Travels>>(service.listAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/searchTravels/{id}")
	public ResponseEntity<Travels> get(@PathVariable Long id) {
		return new ResponseEntity<Travels>(service.get(id), HttpStatus.OK);   
	}//Searching for a particular package i.e SearchPackage
	
	
	
	
	@DeleteMapping("/removeTravels/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<String>("Package deleted successfully!.", HttpStatus.OK);
    }//DeletePackage
	
	@PutMapping("/updateTravels/{id}")
	public ResponseEntity<Travels> update(@PathVariable Travels travels)
	{
		return new ResponseEntity<Travels>(service.updateTravels(travels),HttpStatus.OK);
	}
	
}

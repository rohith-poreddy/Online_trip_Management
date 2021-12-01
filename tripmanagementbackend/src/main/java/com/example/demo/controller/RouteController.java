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

import com.example.demo.model.Route;

import com.example.demo.service.IRouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	
	@Autowired
    private IRouteService service;
	
	@PostMapping("/addRoute")
    public ResponseEntity<Route> add(@Valid @RequestBody Route route) {
		return new ResponseEntity<Route>(service.save(route), HttpStatus.CREATED);
        
    }
	
	@GetMapping("viewRouteList")
	public ResponseEntity<List<Route>> list()
	{
		return  new ResponseEntity<List<Route>>(service.listAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/searchRoute/{id}")
	public ResponseEntity<Route> get(@PathVariable Long id) {
		return new ResponseEntity<Route>(service.get(id), HttpStatus.OK);   
	}
	
	
	
	
	@DeleteMapping("/removeRoute/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<String>("Route deleted successfully!.", HttpStatus.OK);
    }
	
	@PutMapping("/updateRoute/{id}")
	public ResponseEntity<Route> update(@PathVariable Route route)
	{
		return new ResponseEntity<Route>(service.updateRoute(route),HttpStatus.OK);
	}
	

}

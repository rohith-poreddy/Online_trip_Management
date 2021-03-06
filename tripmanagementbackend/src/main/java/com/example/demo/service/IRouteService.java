package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Route;

import com.example.demo.repository.IRouteRepository;

@Service
@Transactional
public class IRouteService {
	@Autowired
	private IRouteRepository repo;
	
	public  List<Route> listAll() {
	    List<Route> temp= repo.findAll();
	    if(temp.isEmpty())
	    	throw new EmptyListException("No Routes!!!");
		return temp;
	}
	     
	public Route save(Route route) {
		return repo.save(route);
	}
	
	public Route get(Long routeId) {
        return repo.findById(routeId).orElseThrow(()->
                                           new ResourceNotFoundException("Route not found with id :" + routeId));
    	
    }
     
    public void delete(Long routeId) {
        repo.findById(routeId).orElseThrow(()->
        new ResourceNotFoundException("Route not found with id :" + routeId));
        repo.deleteById(routeId);
    }
    
    public Route updateRoute(Route route)  throws ResourceNotFoundException {
    	 Route existingRoute = repo.findById(route.getRouteId()).orElseThrow(()->
        new ResourceNotFoundException("customer not found with email id :" + route.getRouteId()));
    	 existingRoute.setRouteFrom(route.getRouteFrom());
    	 existingRoute.setRouteTo(route.getRouteTo());
    	 existingRoute.setDepartureTime(route.getDepartureTime());
    	 existingRoute.setArrivalTime(route.getArrivalTime());
    	 existingRoute.setDoj(route.getDoj());
    	 existingRoute.setPickupPoint(route.getPickupPoint());
    	 existingRoute.setFare(route.getFare());
        return repo.save(existingRoute);
    }
	
	
}

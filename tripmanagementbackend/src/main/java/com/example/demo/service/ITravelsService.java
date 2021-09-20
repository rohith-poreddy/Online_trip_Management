package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Travels;

import com.example.demo.repository.ITravelsRepository;

public class ITravelsService {
	
	@Autowired
	private ITravelsRepository repo;
	
	public  List<Travels> listAll() {
	    List<Travels> temp= repo.findAll();
	    if(temp.isEmpty())
	    	throw new EmptyListException("No Travels!!!");
		return temp;
	}
	     
	public Travels save(Travels travels) {
		return repo.save(travels);
	}
	
	public Travels get(Long travelsId) {
        return repo.findById(travelsId).orElseThrow(()->
                                           new ResourceNotFoundException("travel not found with id :" + travelsId));
    	
    }
     
    public void delete(Long travelsId) {
        repo.findById(travelsId).orElseThrow(()->
        new ResourceNotFoundException("Travel not found with id :" + travelsId));
        repo.deleteById(travelsId);
    }
    
    public Travels updateTravels(Travels travels)  throws ResourceNotFoundException {
    	Travels existingTravel = repo.findById(travels.getTravelId()).orElseThrow(()->
        new ResourceNotFoundException("Travels not found with  id :" + travels.getTravelId()));
        existingTravel.setTravelName(travels.getTravelName());
        existingTravel.setAgentName(travels.getAgentName());
        existingTravel.setAddress(travels.getAddress());
        existingTravel.setContact(travels.getContact());
        return repo.save(existingTravel);
    }

}

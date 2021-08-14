package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.example.demo.model.Package;
import com.example.demo.service.IPackageService;

@RestController
@RequestMapping("/package")
public class PackageController {
	
	@Autowired
    private IPackageService service;
	
	@GetMapping("/viewallpackages")
    public List<Package> list() {
        return service.listAll();
    }
	
	
	@GetMapping("/searchpackage/{id}")
	public ResponseEntity<Package> get(@PathVariable Long id) {
	    try {
	        Package ipackage = service.get(id);
	        return new ResponseEntity<Package>(ipackage, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Package>(HttpStatus.NOT_FOUND);
	    }      
	}//Searching for a particular package i.e SearchPackage
	
	
	@PostMapping("/addpackage")
    public void add(@RequestBody Package ipackage) {
        service.save(ipackage);
    }//AddPackage
	
	@DeleteMapping("/deletepackage/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }//DeletePackage
	
	

}


/*


@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	IBookingRepository repo;
	@PostMapping(value="/addbooking")
	public boolean makeBooking(@RequestBody Booking b) {
		
		b.setBookingDate(LocalDate.now());
		repo.save(b);
		return true;
	}
	@DeleteMapping("/cancelbooking/{bookingId}")
	public Booking cancelBooking(@PathVariable(value="bookingId") int id) {
		Booking b = repo.findById(id).orElseThrow();
		repo.delete(b);
		return b;
	}
	@GetMapping("/viewbooking/{bookingId}")
	public Booking viewBooking(@PathVariable(value="bookingId")int id) {
		Booking b = repo.findById(id).orElseThrow();
		return b;
	}
	@GetMapping("/")
	public List<Booking> viewAllBookings(){
		return repo.findAll();
	}
}*/

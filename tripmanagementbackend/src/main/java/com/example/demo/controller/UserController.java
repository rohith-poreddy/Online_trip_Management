package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping(value="/addUser")
	public ResponseEntity<User> addNewUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping(value="/signIn")
	public ResponseEntity<User> isValidUser(@RequestBody User user)
	{
		return new ResponseEntity<>(userService.viewUser(user.getUserId()),HttpStatus.OK);
	}
}
/*
 * package com.example.demo.controller;


import java.util.List;

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

import com.example.demo.dto.BookingDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Booking;

import com.example.demo.service.IBookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	IBookingService bookingService;
	
	@PostMapping(value="/addbooking")
	public ResponseEntity<BookingDTO> makeBooking(@RequestBody BookingDTO bookingDTO) {
		return new ResponseEntity<>(bookingService.makeBooking(bookingDTO),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/cancelbooking/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable(value="bookingId") int id)  {
		return new ResponseEntity<>(bookingService.cancelBooking(id),HttpStatus.ACCEPTED);
	}
	@GetMapping("/viewbooking/{bookingId}")
	public ResponseEntity<Booking> viewBooking(@PathVariable(value="bookingId")int id) throws ResourceNotFoundException {
		return new ResponseEntity<>(bookingService.viewBooking(id),HttpStatus.ACCEPTED);
	}
	@GetMapping("/")
	public ResponseEntity<?> viewAllBookings(){
		List<Booking> temp=bookingService.viewAllBookings();
		return (new ResponseEntity<>(temp,HttpStatus.ACCEPTED));
	}

}

 */


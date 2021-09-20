package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;

@Service
@Transactional
public class IUserService {
	
	@Autowired
	IUserRepository userRepo;
	
	public User addUser(User user)
	{
		userRepo.save(user);
		return user;
	}
	
	public User viewUser(long id) throws ResourceNotFoundException {
		return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Id : "+id+" not found!!"));
		
	}

}
/*
 package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookingDTO;
import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Booking;
import com.example.demo.repository.IBookingRepository;


@Service
@Transactional
public class IBookingService {
	
	@Autowired
	IBookingRepository bookingRepo;
	private ModelMapper modelMapper = new ModelMapper();
	public BookingDTO makeBooking(BookingDTO bookingDTO) {
		bookingDTO.setBookingDate(LocalDate.now());
		Booking booking  = mapToEntity(bookingDTO);
		bookingRepo.save(booking);
		return mapToDTO(booking);
	
	}
	public Booking cancelBooking(long id) throws ResourceNotFoundException{
		Booking b = null;
		b = bookingRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Booking Id : "+id+" not found!!"));
		bookingRepo.delete(b);
		return b;
	}
	
	public Booking viewBooking(long id) throws ResourceNotFoundException {
		return bookingRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Booking Id : "+id+" not found!!"));
		
	}
	
	public List<Booking> viewAllBookings()  {
		List<Booking> temp=bookingRepo.findAll();
		if(temp.isEmpty())
			throw new EmptyListException("No Bookings!!!");
		return temp;
	}
	
	private BookingDTO mapToDTO(Booking booking) {
		return modelMapper.map(booking, BookingDTO.class);
	}
	
	private Booking mapToEntity(BookingDTO bookingDTO) {
		return modelMapper.map(bookingDTO, Booking.class);
	}
}

 */
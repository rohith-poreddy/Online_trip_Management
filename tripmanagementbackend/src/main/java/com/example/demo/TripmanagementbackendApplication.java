package com.example.demo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.modelmapper.ModelMapper;


@SpringBootApplication
@EnableSwagger2
public class TripmanagementbackendApplication implements CommandLineRunner{
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(TripmanagementbackendApplication.class, args);
	}
	public void run(String... args) throws Exception{
//		Booking b=new Booking("bty1","des1","bt1",LocalDate.now());
//		List<Booking>lb=new ArrayList<Booking>();
//		lb.add(b);
//		Package pk1=new Package("qw","q11","qwssd","qwer",2000.122);
//		Hotel h1=new Hotel("hn1","ht1","hd1","ha1",2500,"empty");
//		h1.setPackages(p1);
	}
	

}

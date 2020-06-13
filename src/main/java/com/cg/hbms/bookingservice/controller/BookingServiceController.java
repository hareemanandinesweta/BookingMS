package com.cg.hbms.bookingservice.controller;

import java.util.List;
import java.util.Optional;

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

import com.cg.hbms.bookingservice.Exceptions.BookingIdNotFoundException;
import com.cg.hbms.bookingservice.Exceptions.HotelIdNotFoundException;
import com.cg.hbms.bookingservice.Exceptions.RoomNotFoundException;
import com.cg.hbms.bookingservice.Exceptions.UserIdNotFoundException;
import com.cg.hbms.bookingservice.dto.Booking;
import com.cg.hbms.bookingservice.service.BookingServiceImplementation;

@RestController
@RequestMapping("/api")

public class BookingServiceController {

	@Autowired
	BookingServiceImplementation service;

	@GetMapping("/allBookings")
	public List<Booking> getBookings() {
		return service.getBookings();
	}

	@GetMapping("/bookings/{bid}")
	public ResponseEntity getBookingbyId(@PathVariable("bid") long booking_id) throws BookingIdNotFoundException {
		Booking b = service.getBookingbyid(booking_id);
		return new ResponseEntity(b, HttpStatus.OK);
	}

	@GetMapping("/book/{rid}")
	public ResponseEntity<Booking> getRoombyRoomId(@PathVariable("rid") long room_id) throws RoomNotFoundException {
		Booking b = service.getRoombyRoomId(room_id);
		return new ResponseEntity<Booking>(b, HttpStatus.OK);
	}

	@GetMapping("/users/{uid}")
	public ResponseEntity getUserbyUserId(@PathVariable("uid") long user_id) throws UserIdNotFoundException {
		Booking b = service.getUserbyUserId(user_id);
		return new ResponseEntity(b, HttpStatus.OK);
	}

	@GetMapping("/hotel/{hid}")
	public ResponseEntity getHotelbyId(@PathVariable("hid") long hotel_id) throws HotelIdNotFoundException {
		Booking b = service.getHotelbyId(hotel_id);
		return new ResponseEntity(b, HttpStatus.OK);
	}

	@PostMapping("/booking")
	public ResponseEntity<Booking> saveBookings(@Valid @RequestBody Booking b) {
		service.save(b);
		return new ResponseEntity<>(b, HttpStatus.CREATED);

	}

	@DeleteMapping("/bookings/{id}")
	public ResponseEntity<HttpStatus> deleteBooking(@PathVariable("id") long booking_id) {
		try {
			service.deleteById(booking_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/bookings/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") long booking_id,
			@Valid @RequestBody Booking booking) {
		Optional<Booking> bookingData = service.findById(booking_id);

		if (bookingData.isPresent()) {
			Booking _booking = bookingData.get();
			_booking.setRoom_id(booking.getRoom_id());
			_booking.setHotel_id(booking.getHotel_id());
			_booking.setBooking_from(booking.getBooking_from());
			_booking.setAmount(booking.getAmount());

			return new ResponseEntity<>(service.save(_booking), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

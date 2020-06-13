package com.cg.hbms.bookingservice.Exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookingsException {

	@ExceptionHandler(RoomNotFoundException.class)
	public String handleRoomNotFoundException(RoomNotFoundException e) {

		return "Room Not Found";
	}

	@ExceptionHandler(BookingIdNotFoundException.class)
	public String handleBookingIdNotFoundException(BookingIdNotFoundException e) {

		return "BookingId Not Found";
	}

	@ExceptionHandler(UserIdNotFoundException.class)
	public String handleUserIdNotFoundException(UserIdNotFoundException e) {

		return "UserId Not Found";
	}

	@ExceptionHandler(HotelIdNotFoundException.class)
	public String handleHotelIdNotFoundException(HotelIdNotFoundException e) {

		return "HotelId Not Found";
	}

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    return ex.getBindingResult()
	        .getAllErrors().stream()
	        .map(ObjectError::getDefaultMessage)
	        .collect(Collectors.toList());
	}
	
	
}

package com.cg.hbms.bookingservice.service;

import java.util.List;
import java.util.Optional;

import com.cg.hbms.bookingservice.Exceptions.BookingIdNotFoundException;
import com.cg.hbms.bookingservice.Exceptions.HotelIdNotFoundException;
import com.cg.hbms.bookingservice.Exceptions.RoomNotFoundException;
import com.cg.hbms.bookingservice.Exceptions.UserIdNotFoundException;
import com.cg.hbms.bookingservice.dto.Booking;

public interface BookingService {

	List<Booking> getBookings();

	Booking getBookingbyid(long booking_id) throws BookingIdNotFoundException;

	Booking getRoombyRoomId(long room_id) throws RoomNotFoundException;

	Booking save(Booking b);

	void deleteById(long booking_id);

	Optional<Booking> findById(long booking_id);

	Booking getUserbyUserId(long user_id) throws UserIdNotFoundException;

	Booking getHotelbyId(long hotel_id) throws HotelIdNotFoundException;

}

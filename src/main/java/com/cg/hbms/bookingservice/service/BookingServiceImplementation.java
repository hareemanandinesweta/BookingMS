package com.cg.hbms.bookingservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbms.bookingservice.Exceptions.BookingIdNotFoundException;
import com.cg.hbms.bookingservice.Exceptions.HotelIdNotFoundException;
import com.cg.hbms.bookingservice.Exceptions.RoomNotFoundException;
import com.cg.hbms.bookingservice.Exceptions.UserIdNotFoundException;
import com.cg.hbms.bookingservice.dao.BookingServiceDao;
import com.cg.hbms.bookingservice.dto.Booking;

@Service
public class BookingServiceImplementation implements BookingService {

	@Autowired
	BookingServiceDao dao;

	@Override
	public List<Booking> getBookings() {
		List<Booking> blist = dao.findAll();
		
		return blist;
	}

	@Override
	public Booking getBookingbyid(long booking_id) throws BookingIdNotFoundException {
		return dao.findById(booking_id).orElseThrow(() -> new BookingIdNotFoundException());
	}

	@Override
	public Booking getRoombyRoomId(long room_id) throws RoomNotFoundException {
		return dao.findByRoomId(room_id).orElseThrow(() -> new RoomNotFoundException());
	}

	@Override
	public Booking save(Booking b) {
		return dao.saveAndFlush(b);

	}

	@Override
	public void deleteById(long booking_id) {

		dao.deleteById(booking_id);
	}

	@Override
	public Optional<Booking> findById(long booking_id) {

		return dao.findById(booking_id);
	}

	@Override
	public Booking getUserbyUserId(long user_id) throws UserIdNotFoundException {

		return dao.findByUserId(user_id).orElseThrow(() -> new UserIdNotFoundException());
	}
    
	@Override
	public Booking getHotelbyId(long hotel_id) throws HotelIdNotFoundException {

		return dao.findByHotelId(hotel_id).orElseThrow(()->new HotelIdNotFoundException());
	}

}

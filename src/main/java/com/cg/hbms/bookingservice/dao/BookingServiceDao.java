package com.cg.hbms.bookingservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hbms.bookingservice.dto.Booking;


@Repository
public interface BookingServiceDao extends JpaRepository<Booking,Long> {

	@Query(value="select * from booking b where b.room_id = :room_id",nativeQuery = true)
	Optional<Booking> findByRoomId(long room_id);
	
	@Query(value="select * from booking b where b.user_id = :user_id",nativeQuery = true)
	Optional<Booking> findByUserId(long user_id);

	@Query(value="select * from booking b where b.hotel_id= :hotel_id",nativeQuery =true)
	Optional<Booking> findByHotelId(long hotel_id);

}

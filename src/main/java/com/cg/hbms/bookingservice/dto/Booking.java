package com.cg.hbms.bookingservice.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "booking_id")

	private Long booking_id;
	@Column(name = "room_id")
	@NotNull(message = "Room_id is Mandatory")
	
	private Long room_id;
	@Column(name = "user_id")
	@NotNull(message = "User_id is Mandatory")
	private Long user_id;
	
	@Column(name = "booking_from")
	// @Past(message="must be a date in the past")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@JsonDeserialize(using=CustomerDateAndTimeDeserialize.class)
	@NotNull(message = "please provide a date")
	private Date booking_from;
	@Column(name = "booking_to")
	// @PastOrPresent(message="must be a date or time in the past or present")
	@DateTimeFormat(pattern = "yyyy-MM-dd")

	@NotNull(message = "Please provide a date.")
	private Date booking_to;
	@Column(name = "amount")
	@Positive(message = "number should be positive")
	@NotNull(message = "amount is mandatory")
	private double amount;
	@Column(name = "hotel_id")
	@NotNull(message = "Hotel_id is Mandatory")
	private Long hotel_id;

	@Override
	public String toString() {
		return "BookingServiceEntity [booking_id=" + booking_id + ", room_id=" + room_id + ", user_id=" + user_id
				+ ", booking_from=" + booking_from + ", booking_to=" + booking_to + ", amount=" + amount + ", hotel_id="
				+ hotel_id + "]";
	}

	public Long getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}

	public Long getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Long room_id) {
		this.room_id = room_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Date getBooking_from() {
		return booking_from;
	}

	public void setBooking_from(Date booking_from) {
		this.booking_from = booking_from;
	}

	public Date getBooking_to() {
		return booking_to;
	}

	public void setBooking_to(Date booking_to) {
		this.booking_to = booking_to;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Long getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Long hotel_id) {
		this.hotel_id = hotel_id;
	}
}

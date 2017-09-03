package com.inv.dao;

import com.inv.entity.BookingRequest;
import com.inv.entity.Meeting;

import java.util.List;

public interface IMeetingsDao {

    Meeting add(Meeting meeting);
    Meeting add(BookingRequest bookingRequest);
    List<Meeting> addAllBookingRequests();
    List<Meeting> addAllBookingRequests(List<BookingRequest> bookingRequests);
    List<Meeting> getAllOrdered();
}

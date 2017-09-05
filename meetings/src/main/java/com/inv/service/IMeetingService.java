package com.inv.service;

import com.inv.entity.BookingRequest;
import com.inv.entity.Meeting;

import java.util.List;


public interface IMeetingService {

    Meeting add(Meeting meeting);
    Meeting add(BookingRequest bookingRequest);
    List<Meeting> addAllBookingRequests();
    List<Meeting> addAllBookingRequests(List<BookingRequest> bookingRequests, boolean isSorted);
    List<Meeting> getAllOrdered();

}

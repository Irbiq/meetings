package com.inv.dao;

import com.inv.entity.BookingRequest;

import java.util.List;

public interface IBookingRequestDao {

    BookingRequest add(BookingRequest bookingRequest);
    List<BookingRequest> getAllOrderedByRequest();
}

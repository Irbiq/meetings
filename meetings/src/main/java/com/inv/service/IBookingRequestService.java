package com.inv.service;

import com.inv.entity.BookingRequest;

import java.util.List;

public interface IBookingRequestService {

    BookingRequest add(BookingRequest bookingRequest);
    List<BookingRequest> getAllOrderedByRequest();

}

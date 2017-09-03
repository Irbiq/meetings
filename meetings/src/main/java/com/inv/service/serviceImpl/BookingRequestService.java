package com.inv.service.serviceImpl;

import com.inv.dao.IBookingRequestDao;
import com.inv.entity.BookingRequest;
import com.inv.service.IBookingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingRequestService implements IBookingRequestService{

    @Autowired
    IBookingRequestDao bookingRequestDao;

    @Override
    public BookingRequest add(BookingRequest bookingRequest) {

        return bookingRequestDao.add(bookingRequest);
    }

    @Override
    public List<BookingRequest> getAllOrderedByRequest() {

        return bookingRequestDao.getAllOrderedByRequest();
    }
}

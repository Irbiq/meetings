package com.inv.service.serviceImpl;

import com.inv.dao.daoImpl.MeetingDao;
import com.inv.entity.BookingRequest;
import com.inv.entity.Meeting;
import com.inv.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeetingService implements IMeetingService {

    @Autowired
    MeetingDao meetingDao;

    @Override
    @Transactional
    public List<Meeting> getAllOrdered() {

        return meetingDao.getAllOrdered();
    }

    @Override
    @Transactional
    public Meeting add(Meeting meeting) {

        return meetingDao.add(meeting);
    }

    @Override
    @Transactional
    public Meeting add(BookingRequest bookingRequest) {

        return meetingDao.add(bookingRequest);
    }

    @Override
    public List<Meeting> addAllBookingRequests() {

        return meetingDao.addAllBookingRequests();
    }

    @Override
    public List<Meeting> addAllBookingRequests(List<BookingRequest> bookingRequests,boolean isSorted) {

        return meetingDao.addAllBookingRequests(bookingRequests,isSorted);
    }
}

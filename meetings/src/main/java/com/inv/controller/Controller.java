package com.inv.controller;

import com.inv.entity.BookingRequest;
import com.inv.entity.Meeting;
import com.inv.service.IBookingRequestService;
import com.inv.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    IBookingRequestService bookingRequestService;

    @Autowired
    IMeetingService meetingService;

    @RequestMapping(value = "/booking/all", method = RequestMethod.GET)
    public List<BookingRequest> getAllBookingRequestsOrdered() {

        return bookingRequestService.getAllOrderedByRequest();
    }

    @RequestMapping(value = "/booking/add", method = RequestMethod.POST)
    public BookingRequest addBookingRequest(@RequestBody BookingRequest bookingRequest) {

        return bookingRequestService.add(bookingRequest);
    }

    @RequestMapping(value = "/meeting/all", method = RequestMethod.GET)
    public List<Meeting> getAllMeetingsOrdered() {

        return meetingService.getAllOrdered();
    }

    @RequestMapping(value = "/meeting/add/request", method = RequestMethod.POST)
    public Meeting addBookingRequestAndMeeting(@RequestBody BookingRequest bookingRequest) {

        bookingRequestService.add(bookingRequest);

        return meetingService.add(bookingRequest);
    }

    @RequestMapping(value = "/meeting/add/requests/json", method = RequestMethod.POST)
    public List<Meeting> addAllRequestsToMeetingsJson(@RequestBody List<BookingRequest> bookingRequests) {
        boolean isSorted = false;
        return meetingService.addAllBookingRequests(bookingRequests, isSorted);
    }

    @RequestMapping(value = "/meeting/add/requests/db", method = RequestMethod.POST)
    public List<Meeting> addAllRequestsToMeetingsDb() {

        return meetingService.addAllBookingRequests();
    }

}

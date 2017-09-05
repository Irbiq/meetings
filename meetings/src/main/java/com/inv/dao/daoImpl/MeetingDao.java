package com.inv.dao.daoImpl;

import com.inv.dao.IBookingRequestDao;
import com.inv.dao.IMeetingsDao;
import com.inv.dao.IWorkTimeDao;
import com.inv.entity.BookingRequest;
import com.inv.entity.Meeting;
import com.inv.entity.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class MeetingDao implements IMeetingsDao {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private IWorkTimeDao workTimeDao;
    @Autowired
    private IBookingRequestDao bookingRequestDao;

    @Override
    public Meeting add(Meeting meeting) {

        em.persist(meeting);
        return meeting;
    }

    @Override
    @Transactional
    public Meeting add(BookingRequest bookingRequest) {

        Meeting meeting = bookingRequestToMeeting(bookingRequest);
        int day = meeting.getStart().getDayOfWeek().getValue();
        WorkTime workTime = workTimeDao.getById(day);
        List<Meeting> meetings = getAllOrdered();

        if (checkAddingPossibility(meetings, meeting, workTime)) {
            add(meeting);
        }
        return meeting;
    }

    @Override
    @Transactional
    public List<Meeting> addAllBookingRequests() {

        List<BookingRequest> bookingRequests = bookingRequestDao.getAllOrderedByRequest();
        return addAllBookingRequests(bookingRequests,true);
    }

    @Override
    @Transactional
    public List<Meeting> addAllBookingRequests(List<BookingRequest> bookingRequests, boolean isSorted) {

        if(!isSorted) {
            bookingRequests.sort(Comparator.comparing(BookingRequest::getRequestTime));
        }
        Meeting meetingFromRequest;
        int day;
        WorkTime workTime;

        List<Meeting> meetings = getAllOrdered();
        for (BookingRequest br : bookingRequests) {

            meetingFromRequest = bookingRequestToMeeting(br);
            day = meetingFromRequest.getStart().getDayOfWeek().getValue();
            workTime = workTimeDao.getById(day);

            if (checkAddingPossibility(meetings, meetingFromRequest, workTime))
                add(meetingFromRequest);
        }
        return getAllOrdered();
    }

    @Override
    @Transactional
    public List<Meeting> getAllOrdered() {

        List<Meeting> meetings;
        Query query = em.createNamedQuery("Meeting.selectAllOrdered");
        meetings = query.getResultList();

        return meetings;
    }

    private boolean checkAddingPossibility(List<Meeting> meetings, Meeting meeting, WorkTime workTime) {

        if (meeting.getStart().compareTo(meeting.getEnd()) >= 0)
            return false;
        if (meeting.getStart().toLocalTime().compareTo(workTime.getDayBegin()) < 0 ||
                meeting.getEnd().toLocalTime().compareTo(workTime.getDayEnd()) >= 0)
            return false;
        if (meeting.getEnd().toLocalTime().compareTo(workTime.getDayEnd()) > 0)
            return false;
        for (Meeting m : meetings) {
            if (meeting.getStart().compareTo(m.getStart()) >= 0 && meeting.getStart().compareTo(m.getEnd()) <= 0)
                return false;
            if (meeting.getEnd().compareTo(m.getStart()) >= 0 && meeting.getEnd().compareTo(m.getEnd()) <= 0)
                return false;
        }
        return true;
    }

    private Meeting bookingRequestToMeeting(BookingRequest bookingRequest) {

        int duration = bookingRequest.getMeetingDuration();
        LocalDateTime start = bookingRequest.getMeetingTime();
        LocalDateTime end = bookingRequest.getMeetingTime().plusHours(duration);
        String employee = bookingRequest.getEmployee();

        Meeting meeting = new Meeting();
        meeting.setEmployee(employee);
        meeting.setStart(start);
        meeting.setEnd(end);

        return meeting;
    }


}

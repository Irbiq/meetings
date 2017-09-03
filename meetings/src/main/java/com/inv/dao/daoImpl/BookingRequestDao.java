package com.inv.dao.daoImpl;
import com.inv.dao.IBookingRequestDao;
import com.inv.entity.BookingRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookingRequestDao implements IBookingRequestDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public BookingRequest add(BookingRequest bookingRequest) {

        em.persist(bookingRequest);
        return bookingRequest;
    }

    @Override
    @Transactional
    public List<BookingRequest> getAllOrderedByRequest() {

        List<BookingRequest> bookingRequests ;
        Query query = em.createNamedQuery("BookingRequest.selectAllOrderedByRequest");
        bookingRequests = (List<BookingRequest>) query.getResultList();
        return bookingRequests;
    }


}

package com.inv.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = "BookingRequest.selectAllOrderedByRequest", query = "SELECT br FROM booking_requests br ORDER BY br.requestTime "),
        })
@Data
@Entity(name = "booking_requests")
public class BookingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee")
    String employee;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "request_time")
    private LocalDateTime requestTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "meeting_time")
    private LocalDateTime meetingTime;

    @Column(name = "meeting_duration")
    int meetingDuration;

}

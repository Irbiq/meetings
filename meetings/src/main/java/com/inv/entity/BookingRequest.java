package com.inv.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by ASUS on 31.08.2017.
 */
/*0900 1730
2011-03-17 10:17:06 EMP001
2011-03-21 09:00 2
2011-03-16 12:34:56 EMP002
2011-03-21 09:00 2
2011-03-16 09:28:23 EMP003
2011-03-22 14:00 2
2011-03-17 11:23:45 EMP004
2011-03-22 16:00 1
2011-03-15 17:29:12 EMP005
2011-03-21 16:00 3
*/
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

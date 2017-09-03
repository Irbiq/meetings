package com.inv.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@NamedQueries({
        @NamedQuery(name = "WorkTime.findById", query = "SELECT wt FROM work_time wt where wt.id=:id"),
})
@Data
@Entity(name = "work_time")
public class WorkTime {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "start")
    LocalTime dayBegin;

    @Column(name = "end")
    @JsonFormat(pattern = "HH:mm")
    LocalTime dayEnd;

}

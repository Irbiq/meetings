package com.inv.dao;

import com.inv.entity.WorkTime;

import java.time.LocalTime;
import java.util.List;

public interface IWorkTimeDao {

    WorkTime getById(int id);
}

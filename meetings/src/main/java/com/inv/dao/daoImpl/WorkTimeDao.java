package com.inv.dao.daoImpl;

import com.inv.dao.IWorkTimeDao;
import com.inv.entity.WorkTime;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WorkTimeDao implements IWorkTimeDao{


    @Autowired
    private SessionFactory session;

    @Override
    public WorkTime getById(int id){

        return session.openSession().get(WorkTime.class,id);
    }



}

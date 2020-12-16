package com.abc.ssm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Service("personService")
public class PersonService {
    @Autowired
    private PersonDao personDao;
    public void print(){
        personDao.print();
    }
}

package ca.momentum.model.services.impl;

import ca.momentum.model.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Thiago Lima on 2016-05-13.
 */
@Service("myServiceTest")
public class MyService implements Services {

    private String test;


    @Autowired
    public MyService(String test) {
        this.test = test;
    }

    public String getServiceName() {
        System.out.println(test);
        return test;
    }
}
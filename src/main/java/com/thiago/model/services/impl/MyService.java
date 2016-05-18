package com.thiago.model.services.impl;

import com.thiago.model.services.Services;

/**
 * Created by Thiago Lima on 2016-05-13.
 */
//FIXME Thiago
//@Service("myService1")
public class MyService implements Services {

    private String test;

//    @Autowired
    public MyService(String test) {
        this.test = test;
    }

    public String getServiceName() {
        System.out.println(test);
        return test;
    }
}
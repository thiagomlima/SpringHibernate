package ca.momentum.model.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Thiago Lima on 2016-05-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/*-cfg.xml", "file:src/main/webapp/WEB-INF/*-servlet.xml" })
//@ContextConfiguration(locations = {"classpath:services-cfg.xml"})
public class MyServiceTest {

//    @Autowired
//    private MyService service;

    @Autowired
    @Qualifier("myServiceTest")
    private MyService service1;

    @Autowired
    @Qualifier("myServiceTest2")
    private MyService service2;

    @Test
    public void getServiceName() throws Exception {
//        assertThat(service.getServiceName()).isEqualTo("Test");
        assertThat(service1.getServiceName()).isEqualTo("test1");
        assertThat(service2.getServiceName()).isEqualTo("test2");
    }
}
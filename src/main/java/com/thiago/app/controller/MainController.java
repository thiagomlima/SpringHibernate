package com.thiago.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Thiago Lima on 2016-05-10.
 */
@Controller
public class MainController {

    private final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping({ "/", "/home", "/index" })
    public String home(Model model) {
        logger.info("index");
        getIntegers();
        return "indexPage";
    }

    private static void getIntegers(){
        final String uri = "http://secure.smartbearsoftware.com/samples/testcomplete10/webservices/Service.asmx?op=HelloWorld";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

//        for (Integer integer : result) {
//            System.out.println(integer);
//        }
        System.out.println(result);
    }

}

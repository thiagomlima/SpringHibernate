package com.thiago.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Thiago Lima on 2016-05-10.
 */
@Controller
public class MainController {

    private final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping({ "/", "/home", "/index" })
    public String home(Model model) {
        logger.info("index");
        return "indexPage";
    }
}

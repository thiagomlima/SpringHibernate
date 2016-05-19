package com.thiago;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by Thiago Lima on 2016-05-12.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext-test.xml", "file:src/main/webapp/WEB-INF/tiles.xml", "file:src/main/webapp/WEB-INF/*-servlet.xml" })
public abstract class BaseControllerTestConfig {

    protected MockMvc mockMvc;
    protected InternalResourceViewResolver internalResourceViewResolver;
    protected UrlBasedViewResolver urlBasedViewResolver;

    @Before
    public void baseSetUp() {
        MockitoAnnotations.initMocks(this);

        internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/");
        internalResourceViewResolver.setSuffix(".jsp");

        urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(org.springframework.web.servlet.view.tiles3.TilesView.class);
    }
}

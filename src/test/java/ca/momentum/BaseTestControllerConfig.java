package ca.momentum;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Thiago Lima on 2016-05-12.
 */
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContextTest.xml", "file:src/main/webapp/WEB-INF/*-servlet.xml" })
public abstract class BaseTestControllerConfig {

    protected InternalResourceViewResolver viewResolver;

    @Before
    public void baseSetUp() {
        MockitoAnnotations.initMocks(this);

        viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
    }
}

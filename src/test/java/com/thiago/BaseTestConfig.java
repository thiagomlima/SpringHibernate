package com.thiago;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by Thiago Lima on 2016-05-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager")
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext-test.xml"})
public abstract class BaseTestConfig extends AbstractTransactionalJUnit4SpringContextTests {

}

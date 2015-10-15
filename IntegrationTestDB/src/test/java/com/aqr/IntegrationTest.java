package com.aqr;

import com.aqr.com.aqr.configuration.IntegrationTestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by Oleksii_Migunov on 10/14/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        IntegrationTestConfiguration.class
})
public class IntegrationTest {

    @Test
    public void test() {
        assertTrue(true);
    }
}

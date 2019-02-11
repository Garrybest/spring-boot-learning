package com.garrybest;

import com.garrybest.service.MyProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private MyProperties myProperties;

    @Test
    public void getProperties() {
        Assert.assertEquals(myProperties.getName(), "fr");
        Assert.assertEquals(myProperties.getAge(), 24);
    }
}


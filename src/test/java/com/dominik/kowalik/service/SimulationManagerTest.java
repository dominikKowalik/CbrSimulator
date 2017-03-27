package com.dominik.kowalik.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by dominik on 2017-03-27.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimulationManagerTest {

    @Autowired
    SimulationManager simulationManager;

    @Test
    public void ifSourceWithIdNoneExists() throws Exception {
        Assert.assertTrue(simulationManager.ifSourceWithIdNoneExists(1));
        simulationManager.addListener(1, BigDecimal.valueOf(0.3));
        Assert.assertFalse("ifSourceWithIdNoneExists error",simulationManager.ifSourceWithIdNoneExists(1));
    }
}
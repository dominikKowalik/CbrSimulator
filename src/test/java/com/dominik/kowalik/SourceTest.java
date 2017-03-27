package com.dominik.kowalik;

import com.dominik.kowalik.service.Packet;
import com.dominik.kowalik.service.Source;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by dominik on 2017-03-26.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SourceTest {

    @Autowired
    Source source;

    @Test
    public void sourceNotNull(){
        Assert.assertNotNull(source);
    }

    @Test
    public void createPacketTest() {
        source.setInterval(BigDecimal.valueOf(0.2));
        source.createPacket();
        source.createPacket();
        Packet packet = source.createPacket();
        Assert.assertEquals(packet.getGenerationTime(), BigDecimal.valueOf(0.6));
    }


}

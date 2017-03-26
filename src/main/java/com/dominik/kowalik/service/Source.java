package com.dominik.kowalik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by dominik on 2017-03-26.
 */
@Component
public class Source {
    //injecting application context
    @Autowired
    ApplicationContext applicationContext;

    //source id
    private Integer id;

    //specified packet interval
    private Double interval;

    //packet
    private Packet packet;

    // nextPacketGenerationTime = interval + interval + interval itd.
    private Double nextPacketGenerationTime;

    public Source(){ }

    public Source(Double interval){ this.interval = interval; }

    //crating new packet
    public Packet createPacket() {
        Optional.ofNullable(interval).ifPresent( i -> nextPacketGenerationTime += i);
        Packet packet = applicationContext.getBean(Packet.class);
        packet.setGenerationTime(nextPacketGenerationTime);
        return packet;
    }

    public Packet generatePacket() {
        Packet packet = createPacket();
        return packet;
    }
}




package com.dominik.kowalik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by dominik on 2017-03-26.
 */

//Observer/Listener class when it is notified it add new packet to queue
@Service
@Scope("prototype")
public class Source implements Observer{
    //injecting application context
    @Autowired
    ApplicationContext applicationContext;

    //source id
    private Integer id;

    //specified packet interval, "długość odstępu"
    private BigDecimal interval;

    private BigDecimal length;

    // nextPacketGenerationTime = interval + interval + interval itd.
    private BigDecimal nextPacketGenerationTime = BigDecimal.valueOf(0);

    //crating new packet
    public Packet createPacket() {
        Optional.ofNullable(interval).ifPresent(  i -> nextPacketGenerationTime = nextPacketGenerationTime.add(i));
        Packet packet = applicationContext.getBean(Packet.class);
        packet.setGeneration(nextPacketGenerationTime);
        packet.setLength(length);
        packet.setSourceId(getId());
        System.out.println(packet.toString());
        return packet;
    }

    @Override
    public void addPacketToQueue(SimulationManager simulationManager) {
        simulationManager.getCustomQueue().add(createPacket());
    }

    public void setInterval(BigDecimal interval) {
        this.interval = interval;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getInterval() {
        return interval;
    }

    public BigDecimal getNextPacketGenerationTime() {
        return nextPacketGenerationTime;
    }

    public void setNextPacketGenerationTime(BigDecimal nextPacketGenerationTime) {
        this.nextPacketGenerationTime = nextPacketGenerationTime;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }
}
package com.dominik.kowalik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dominik on 2017-03-26.
 */
@Component
@Scope("singleton")
public class CustomQueue {
    @Autowired
    @Qualifier("packetArrayList")
    ArrayList<Packet> list;

    public void add(Packet packet) {
        list.add(packet);
        list.sort((o1, o2) -> o1.compareTo(o2));
    }

    public void calculateTimeOfServiceForEachPacket() {

    }

    public List<Packet> getQueue() {
        return list;
    }


}

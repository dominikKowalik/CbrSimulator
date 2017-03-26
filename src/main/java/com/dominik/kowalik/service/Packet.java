package com.dominik.kowalik.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by dominik on 2017-03-26.
 */

@Component
@Scope(value = "prototype")
public class Packet implements Comparable<Packet> {
    private Double generationTime;

    @Override
    public int compareTo(Packet o) {
        if (this.equals(o)) return 0;
        return generationTime.compareTo(o.getGenerationTime());
    }

    public Double getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(Double generationTime) {
        this.generationTime = generationTime;
    }
}

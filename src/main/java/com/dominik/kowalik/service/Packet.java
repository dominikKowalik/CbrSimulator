package com.dominik.kowalik.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by dominik on 2017-03-26.
 */

@Component
@Scope(value = "prototype")
public class Packet implements Comparable<Packet> {
    private BigDecimal generation;
    private BigDecimal service;
    private BigDecimal length;
    private Integer sourceId;

    @Override
    public int compareTo(Packet o) {
        return getGeneration().compareTo(o.getGeneration());
    }

    @Override
    public String toString() {
        return "Packet{" +
                "generationTime=" + generation +
                '}';
    }

    public BigDecimal getGeneration() {
        return generation;
    }

    public void setGeneration(BigDecimal generationTime) {
        this.generation = generationTime;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getService() {
        return service;
    }

    public void setService(BigDecimal serviceTime) {
        this.service = serviceTime;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Packet packet = (Packet) o;

        if (getGeneration() != null ? !getGeneration().equals(packet.getGeneration()) : packet.getGeneration() != null)
            return false;
        if (getService() != null ? !getService().equals(packet.getService()) : packet.getService() != null)
            return false;
        if (getLength() != null ? !getLength().equals(packet.getLength()) : packet.getLength() != null) return false;
        return getSourceId() != null ? getSourceId().equals(packet.getSourceId()) : packet.getSourceId() == null;

    }

    @Override
    public int hashCode() {
        int result = getGeneration() != null ? getGeneration().hashCode() : 0;
        result = 31 * result + (getService() != null ? getService().hashCode() : 0);
        result = 31 * result + (getLength() != null ? getLength().hashCode() : 0);
        result = 31 * result + (getSourceId() != null ? getSourceId().hashCode() : 0);
        return result;
    }
}

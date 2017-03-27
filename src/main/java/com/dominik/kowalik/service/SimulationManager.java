package com.dominik.kowalik.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by dominik on 2017-03-26.
 */

//Subject/Observable class in observer pattern
@Service
@Scope("singleton")
public class SimulationManager {

    //List of observers, linked list because sources are added only at the end of list.
    @Autowired
    @Qualifier(value = "sourceLinkedList")
    private List<Source> sourceList;

    @Autowired
    @Qualifier(value = "customQueue")
    private CustomQueue customQueue;

    @Autowired
    private ApplicationContext applicationContext;

    public void addListener(Integer id, BigDecimal interval, BigDecimal length){
        Source source = createSource(id,interval, length);
        Optional.ofNullable(source).ifPresent( a -> sourceList.add(source));
    }

    //pull model of observer pattern
    public void forceSourcesToCreatePackets(){
        for( Source s : sourceList ){
            s.addPacketToQueue(this);
        }
    }

    public boolean ifSourceWithIdNoneExists(Integer id){
        return sourceList.stream().noneMatch( a -> Objects.equals(a.getId(), id));
    }

    //creating new source bean with passed parameters
    public Source createSource(Integer id, BigDecimal interval, BigDecimal length){
        Source source = applicationContext.getBean(Source.class);
        source.setId(id);
        source.setInterval(interval);
        source.setLength(length);
        return source;
    }

    public CustomQueue getCustomQueue() {
        return customQueue;
    }

    public List<Source> getSourceList() {
        return sourceList;
    }
}

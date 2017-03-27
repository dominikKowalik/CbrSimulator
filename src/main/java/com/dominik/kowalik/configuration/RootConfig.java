package com.dominik.kowalik.configuration;

import com.dominik.kowalik.service.CustomQueue;
import com.dominik.kowalik.service.Packet;
import com.dominik.kowalik.service.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * Created by dominik on 2017-03-26.
 */

@ComponentScan(basePackages = {"com.kowalik.dominik"})
@Configuration
public class RootConfig {

    @Bean(name = "packetLinkedList")
    public LinkedList<Packet> arrayDeque() {
        return new LinkedList<>();
    }

    @Bean(name = "packetArrayList")
    public ArrayList<Packet> arrayList() {
        return new ArrayList<>();
    }

    @Bean(name = "treeSet")
    public TreeSet<Packet> treeSet() {
        return new TreeSet<>();
    }

    @Bean(name = "hashSet")
    public HashSet<Packet> hashSet() {
        return new HashSet<>();
    }

    @Bean(name = "customQueue")
    public CustomQueue customQueue(){
        return new CustomQueue();
    }

    @Bean(name = "sourceLinkedList")
    public LinkedList<Source> sourceLinkedList(){
        return new LinkedList<>();
    }

    @Bean(name = "packetPriorityQueue")
    public PriorityQueue<Packet> priorytyQueue(){
        return new PriorityQueue<>(new Comparator<Packet>() {
            @Override
            public int compare(Packet o1, Packet o2) {
                if(o1.equals(o2)) return 0;
                return o1.getGeneration().compareTo(o2.getGeneration());
            }
        });
    }

    @Bean(name = "packetTreeSet")
    public TreeSet<Packet> packetsTreeSet(){
        return new TreeSet<>();
    }
}

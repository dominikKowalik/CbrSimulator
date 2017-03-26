package com.dominik.kowalik.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

/**
 * Created by dominik on 2017-03-26.
 */

@ComponentScan(basePackages = { "com.kowalik.dominik" })
public class RootConfig {
    @Bean(name = "hashMapID")
    public HashMap<Integer, Double> getHashMap(){
        return new HashMap<>();
    }


}

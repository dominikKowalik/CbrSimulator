package com.dominik.kowalik.controllers;

import com.dominik.kowalik.service.CustomQueue;
import com.dominik.kowalik.service.Packet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dominik on 2017-03-27.
 */

@RestController
@RequestMapping("/custom_queue")
public class CustomQueueController{
    @Autowired
    CustomQueue customQueue;

    @GetMapping("/get_packets")
    public ResponseEntity<List<Packet>> getAllPacketsInRightOrder(){
        return new ResponseEntity<>(customQueue.getQueue(), HttpStatus.OK);
    }

    @PostMapping("/calculate_time_of_service")
    public ResponseEntity<Void> calculateTimeOfService(){
        customQueue.calculateTimeOfServiceForEachPacket();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

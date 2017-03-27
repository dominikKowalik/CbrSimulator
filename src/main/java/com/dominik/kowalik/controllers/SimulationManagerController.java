package com.dominik.kowalik.controllers;

import com.dominik.kowalik.service.SimulationManager;
import com.dominik.kowalik.service.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by dominik on 2017-03-26.
 */

@RestController
@RequestMapping("/simulation_manager")
public class SimulationManagerController {
    @Autowired
    SimulationManager simulationManager;

    @PostMapping("/create_source/{id}/{interval:.+}/{length:.+}")
    public ResponseEntity<Void> createSource(@PathVariable("id") Integer id,
                                             @PathVariable("interval") BigDecimal interval,
                                             @PathVariable("length") BigDecimal length) {
        if (simulationManager.ifSourceWithIdNoneExists(id)) {
            System.out.println("create_sources " + id.toString() + " " + " " + interval.toString());
            simulationManager.addListener(id, interval, length);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/get_sources")
    public ResponseEntity<List<Source>> getSources() {
        System.out.println("get_sources");
        return new ResponseEntity<>(simulationManager.getSourceList(), HttpStatus.OK);
    }

    @PostMapping("/create_packet")
    public ResponseEntity<Void> forceSourcesToCreatePackets() {
        simulationManager.forceSourcesToCreatePackets();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

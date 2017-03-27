package com.dominik.kowalik.controllers;

import com.dominik.kowalik.service.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dominik on 2017-03-26.
 */

@RestController
@RequestMapping("/source")
public class SourceController {

    @Autowired
    Source source;

}

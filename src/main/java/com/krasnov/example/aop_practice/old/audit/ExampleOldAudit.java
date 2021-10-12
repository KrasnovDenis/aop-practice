package com.krasnov.example.aop_practice.old.audit;


import com.krasnov.example.aop_practice.Loggable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleOldAudit {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleOldAudit.class);

    @GetMapping("/")
    @Loggable
    void benchmark() {
        LOGGER.info("ExampleOldAudit.benchmark");
    }

}

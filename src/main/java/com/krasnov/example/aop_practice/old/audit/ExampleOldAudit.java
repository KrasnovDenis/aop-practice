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
    public int benchmark() throws RuntimeException {
        long start = System.currentTimeMillis();

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += aPlusB(i, i * i);
        }

        long delta = System.currentTimeMillis() - start;
        LOGGER.info("Benchmark result is - " + delta);
        LOGGER.info("Sum is - " + sum);
        return sum;
    }


    @Loggable
    public int aPlusB(int a, int b) {
        return a + b;
    }

}

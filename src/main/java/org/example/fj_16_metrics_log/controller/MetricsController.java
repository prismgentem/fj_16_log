package org.example.fj_16_metrics_log.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class MetricsController {
    private final Counter successCounter;
    private final Counter failureCounter;
    private final Random random = new Random();

    public MetricsController(MeterRegistry registry) {
        successCounter = registry.counter("request_success_total", "status", "success");
        failureCounter = registry.counter("request_failure_total", "status", "failure");
    }

    @GetMapping("/processRequest")
    public ResponseEntity<String> processRequest() {
        if (random.nextBoolean()) {
            successCounter.increment();
            log.info("Request succeeded!");
            return ResponseEntity.ok("Request succeeded!");
        } else {
            failureCounter.increment();
            log.error("Random failure occurred!");
            return ResponseEntity.status(500).body("Random failure occurred!");
        }
    }
}

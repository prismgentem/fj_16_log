package org.example.fj_16_metrics_log.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogService {
    public void logMethod() {
        log.info("logMethod");
    }
}

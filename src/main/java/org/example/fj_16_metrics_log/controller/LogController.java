package org.example.fj_16_metrics_log.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.fj_16_metrics_log.aop.StructuralLog;
import org.example.fj_16_metrics_log.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;
    @GetMapping("/log")
    @StructuralLog
    public void log() {
        log.info("logController start");
        logService.logMethod();
        log.info("logController end");
    }
}

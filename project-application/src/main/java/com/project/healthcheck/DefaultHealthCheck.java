package com.project.healthcheck;

import com.codahale.metrics.health.HealthCheck;
import org.springframework.stereotype.Component;

@Component
public class DefaultHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}

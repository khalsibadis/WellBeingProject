package com.esprit.pidevbackend.Monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class LoggerService implements HealthIndicator
{
    private final String LOGGER_SERVICE = "Logger Service " ;
    @Override
    public Health health() {
        if(isLoggerServiceGood()){
            return Health.up().withDetail(LOGGER_SERVICE , "Service is Running").build();
        }
        return Health.down().withDetail(LOGGER_SERVICE, "Service is not Available").build();
    }


    private Boolean isLoggerServiceGood(){
        return true ;
    }
}

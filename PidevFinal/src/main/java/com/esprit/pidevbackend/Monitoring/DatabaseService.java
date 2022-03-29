package com.esprit.pidevbackend.Monitoring;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService implements HealthIndicator {

    private final String DATABASE_SERVICE = "Database Service" ;
    @Override
    public Health health() {
        if(isDatabaseHealthGood()){
            return Health.up().withDetail(DATABASE_SERVICE , "Service is Running").build();
        }
        return Health.down().withDetail(DATABASE_SERVICE, "Service is not Available").build();
    }


    private Boolean isDatabaseHealthGood(){
        return true ;
    }
}

package com.esprit.pidevbackend.Monitoring;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Endpoint(id = "custom")
@Component
public class CustomEndPoint {

    @ReadOperation
    public Map<String , String>  customEndpoint(String username){
        Map<String,String> map = new HashMap<>();
        map.put("Key","username");
        return  map ;
    }
}

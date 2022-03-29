package com.esprit.pidevbackend.Feign;

import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

import java.beans.Encoder;

public class FeignConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;


}

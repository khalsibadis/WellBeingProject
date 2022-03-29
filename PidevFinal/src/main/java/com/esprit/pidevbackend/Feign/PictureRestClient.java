package com.esprit.pidevbackend.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@FeignClient(name = "PICTURE-SERVICE", configuration = FeignConfig.class)
public interface PictureRestClient {

    @PostMapping(value = "/picture/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
     String uploadFile(@RequestPart("f") MultipartFile f) throws  IOException ;
}

package com.wipro.jobpostingfeign.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.jobpostingfeign.dto.UserDTO;



@FeignClient(name = "spring-hello-project-demo", url = "http://localhost:9192")
public interface UserClient {

    @GetMapping("/{userId}")
    UserDTO getUserById(@PathVariable Long userId);

}
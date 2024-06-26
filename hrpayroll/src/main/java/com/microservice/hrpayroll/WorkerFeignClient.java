package com.microservice.hrpayroll;

import com.microservice.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers" )
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Worker>> findById(@PathVariable("id") final Long id);
}

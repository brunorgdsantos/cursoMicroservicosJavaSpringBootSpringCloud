package com.microservice.hrworker.resources;

import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@EnableEurekaServer
@RestController
@RequestMapping(value="/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> var = repository.findAll();
        return ResponseEntity.ok(var);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Worker>> findById(@PathVariable("id") final Long id){
        Optional<Worker> var = repository.findById(id);
        return ResponseEntity.ok(var);
    }

    @GetMapping("/other/{id}")
    public ResponseEntity<Worker> findByIdAnotherWay(@PathVariable("id") final Long id){
        Worker var = repository.findById(id).get();
        return ResponseEntity.ok(var);
    }
}

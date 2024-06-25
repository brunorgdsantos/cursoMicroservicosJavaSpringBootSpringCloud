package com.microservice.hrpayroll.services;

import com.microservice.hrpayroll.WorkerFeignClient;
import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Optional;


@Service
public class PaymentService {
    //@Autowired
    //private WorkerFeignClient workerFeignClient;
    private final WebClient.Builder loadBalancedWebClientBuilder;

    public PaymentService(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    public Payment getPayment(long workerId, int days){
        return loadBalancedWebClientBuilder.build()
                .get()
                .uri("http://hr-worker/workers/" + workerId)
                .retrieve()
                .bodyToMono(Worker.class)
                .map(worker -> new Payment(worker.getName(), worker.getDailyIncome(), days))
                .block();
        //Optional<Worker> worker = workerFeignClient.findById(workerId).getBody();
        //return new Payment(worker.get().getName(), worker.get().getDailyIncome(), days);
    }
}

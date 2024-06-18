package com.microservice.hrpayroll.services;

import com.microservice.hrpayroll.WorkerFeignClient;
import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){
        Optional<Worker> worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.get().getName(), worker.get().getDailyIncome(), days);
    }
}

package com.microservice.hrpayroll.services;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class SayHelloConfiguration {
    @Bean
    @Primary
    ServiceInstanceListSupplier serviceIstanceListSupplier() {
        return new DemoServiceInstanceListSuppler("say-hello");
    }
}

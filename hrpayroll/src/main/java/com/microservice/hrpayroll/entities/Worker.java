package com.microservice.hrpayroll.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Worker {
    private Long id;
    private String name;
    private Double dailyIncome; //Renda diaria
}

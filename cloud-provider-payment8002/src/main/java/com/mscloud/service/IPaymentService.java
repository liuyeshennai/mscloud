package com.mscloud.service;

import com.mscloud.entities.Payment;

public interface IPaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}

package com.mscloud.service;

import com.mscloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface IPaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}

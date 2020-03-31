package com.poplar.service;

import com.poplar.dao.PaymentDao;
import com.poplar.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create BY poplar ON 2020/3/28
 */
@Service
public class PaymentServiceImpl {

    @Autowired
    private PaymentDao paymentDao;

    public Integer create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

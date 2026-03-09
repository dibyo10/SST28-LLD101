package com.example.payments.gateway;

public interface PaymentGateway {
    String charge(String customerId, int amountCents);
}
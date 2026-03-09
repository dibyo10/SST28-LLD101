package com.example.payments.gateway.impl;

import com.example.payments.client.FastPayClient;
import com.example.payments.gateway.PaymentGateway;

public class FastPayClientAdapter implements PaymentGateway {

    private final FastPayClient fastPayClient;

    public FastPayClientAdapter(FastPayClient fastPayClient) {
        this.fastPayClient = fastPayClient;
    }

    @Override
    public String charge(String customerId, int amountCents) {
        return fastPayClient.payNow(customerId, amountCents);
    }
}

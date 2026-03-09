package com.example.payments.gateway.impl;

import com.example.payments.client.SafeCashClient;
import com.example.payments.gateway.PaymentGateway;
import com.example.payments.model.SafeCashPayment;

public class SafeCashClientAdapter implements PaymentGateway {
    private final SafeCashClient safeCashClient;

    public SafeCashClientAdapter(SafeCashClient safeCashClient) {
        this.safeCashClient = safeCashClient;
    }

    @Override
    public String charge(String customerId, int amountCents) {
        SafeCashPayment payment = safeCashClient.createPayment(amountCents, customerId);
        return payment.confirm();
    }
}

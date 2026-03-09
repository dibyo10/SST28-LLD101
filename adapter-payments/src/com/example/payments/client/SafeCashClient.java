package com.example.payments.client;

import com.example.payments.model.SafeCashPayment;

public class SafeCashClient {
    public SafeCashPayment createPayment(int amount, String user) {
        return new SafeCashPayment(amount, user);
    }
}
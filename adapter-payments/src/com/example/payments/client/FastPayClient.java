package com.example.payments.client;

public class FastPayClient {

    public String payNow(String custId, int amountCents) {
        return "FP#" + custId + ":" + amountCents;
    }
}
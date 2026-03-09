package com.example.payments;

import com.example.payments.client.FastPayClient;
import com.example.payments.client.SafeCashClient;
import com.example.payments.gateway.PaymentGateway;
import com.example.payments.gateway.impl.FastPayClientAdapter;
import com.example.payments.gateway.impl.SafeCashClientAdapter;
import com.example.payments.service.OrderService;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, PaymentGateway> gateways = new HashMap<>();
        gateways.put("fastpay", new FastPayClientAdapter(new FastPayClient()));
        gateways.put("safecash", new SafeCashClientAdapter(new SafeCashClient()));
        OrderService svc = new OrderService(gateways);

        String id1 = svc.charge("fastpay", "cust-1", 1299);
        String id2 = svc.charge("safecash", "cust-2", 1299);
        System.out.println(id1);
        System.out.println(id2);
    }
}
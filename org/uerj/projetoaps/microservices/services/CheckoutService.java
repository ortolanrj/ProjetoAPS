package org.uerj.projetoaps.microservices.services;

import org.uerj.projetoaps.microservices.Microservice;

public class CheckoutService extends Microservice {
    public CheckoutService() {
        super("CheckoutService");
    }

    @Override
    public void handleRequest(String fromService, String fromServiceId, String message) {}
}

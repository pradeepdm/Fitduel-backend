package com.fitness.fitduel.demo.service;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import com.stripe.model.Payout;
import com.stripe.model.Refund;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class StripeService {

    private final String STRIPE_SECRET_KEY = "sk_test_x69URH6QZbttIzSqmVeqowC5";

    @PostConstruct
    public void init() {
        Stripe.apiKey = STRIPE_SECRET_KEY;
    }

    public Charge charge(Map<String, Object>  chargeParams)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, CardException, APIException {
        return Charge.create(chargeParams);
    }

    public Refund refund(Map<String, Object> params)
            throws CardException, APIException, AuthenticationException,
            InvalidRequestException, APIConnectionException {
        return Refund.create(params);
    }
}

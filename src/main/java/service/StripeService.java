package service;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = "sk_test_x69URH6QZbttIzSqmVeqowC5";
    }
    public Charge charge(Map<String, Object>  chargeParams)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, CardException, APIException {
        return Charge.create(chargeParams);
    }
}

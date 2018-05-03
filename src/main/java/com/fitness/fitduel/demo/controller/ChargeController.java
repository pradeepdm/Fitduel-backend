package com.fitness.fitduel.demo.controller;

import com.stripe.exception.*;
import com.stripe.model.Charge;
import com.stripe.model.Payout;
import com.stripe.model.Refund;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.fitness.fitduel.demo.service.StripeService;

import java.util.Map;

@RestController
public class ChargeController {

    @Autowired
    private StripeService paymentsService;

    @RequestMapping(method = RequestMethod.POST, value = "/charge")
    @ResponseBody
    public String createQueryCharge(@RequestBody Map<String, Object> params) throws StripeException {

        Charge charge = paymentsService.charge(params);
        return charge.toJson();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/refund")
    @ResponseBody
    public Refund createRefundRequest(@RequestBody Map<String, Object> params) {

        Refund refund = null;
        try {
            refund = paymentsService.refund(params);
        } catch (CardException |
                APIException |
                AuthenticationException |
                InvalidRequestException |
                APIConnectionException e) {
            e.printStackTrace();
        }
        return refund;
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {

        model.addAttribute("error", ex.getMessage());
        return "error";
    }
}
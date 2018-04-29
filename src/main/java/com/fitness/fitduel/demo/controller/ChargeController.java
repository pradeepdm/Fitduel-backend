package com.fitness.fitduel.demo.controller;

import com.google.gson.Gson;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.json.JSONException;
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

    @PostMapping("/charge")
    public JSONObject charge(Map<String, Object> chargeParams)
            throws StripeException {

        JSONObject result = null;
        Charge charge = paymentsService.charge(chargeParams);
        String jsonRes = new Gson().toJson(charge);
        try {
            result = new JSONObject(jsonRes);
        } catch (JSONException e) {
            e.printStackTrace();
        };
        return  result;
    }


    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "error";
    }
}
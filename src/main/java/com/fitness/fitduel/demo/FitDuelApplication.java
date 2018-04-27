package com.fitness.fitduel.demo;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Map;

@RestController
@SpringBootApplication
public class FitDuelApplication {


	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello! This is a demo application from FitDuel";
	}

	@RequestMapping("/hello")
	@ResponseBody
	String hello() {
		return "Hello from Heroku!!!!!!";
	}


	@RequestMapping(method = RequestMethod.POST, value = "/charge")
	@ResponseBody
	public String createQueryCharge(@RequestBody Map<String, Object> params) {

        Charge charge = null;
		try {
			charge = Charge.create(params);
		} catch (com.stripe.exception.AuthenticationException e) {
			e.printStackTrace();
		} catch (InvalidRequestException e) {
			e.printStackTrace();
		} catch (APIConnectionException e) {
			e.printStackTrace();
		} catch (CardException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
		return new Gson().toJson(charge);
    }


	public static void main(String[] args) {
		SpringApplication.run(FitDuelApplication.class, args);
	}
}

package com.ss.utopia.controller;

import java.util.Enumeration;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.service.PaymentService;
import com.stripe.model.Charge;

@RestController
public class PaymentController {

	private PaymentService stripeClient;

	@Autowired
	PaymentController(PaymentService stripeClient) {
		this.stripeClient = stripeClient;
	}

	@PostMapping("/charge")
	@CrossOrigin
	public Charge chargeCard(HttpServletRequest request) throws Exception {
		System.out.println(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
//		System.out.println(request.getHeader("application/json"));
//		// System.out.println(request.getHeader("email"));
		String token = request.getHeader("token").toString();
		System.out.println(token);
		Double amount = Double.parseDouble(request.getHeader("amount"));
		System.out.println();
		System.out.println();
		System.out.println(amount);
		return this.stripeClient.chargeNewCard(token, amount);
	}
}
//    @RequestMapping(value = "/charge", method = RequestMethod.POST)
//    @CrossOrigin(origins = "http://localhost:3000")
//    public String chargeCard(HttpServletRequest request) throws Exception {
//    	System.out.println("TEST===========================================================================================");
//    	System.out.println(request.);
//        String token = request.getParameter("stripeToken");
//        String email = request.getParameter("email");
//        System.out.println(token);
//        Double amount = Double.parseDouble(request.getParameter("amount"));
//        paymentsService.createCharge(email, token, amount);
//        return "result";
//    }
// 
//    @ExceptionHandler(StripeException.class)
//    public String handleError(Model model, StripeException ex) {
//        model.addAttribute("error", ex.getMessage());
//        return "result";
//    }

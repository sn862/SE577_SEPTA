package edu.drexel.TrainDemo.controllers.payments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.drexel.TrainDemo.entities.payment.PaymentMethod;
import edu.drexel.TrainDemo.service.payment.PaymentService;

@Controller
@RequestMapping("/admin/*")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping("/paymentMethods")
	public String getPaymentMethods(Model model) {
		
		List<PaymentMethod> methods= new ArrayList<PaymentMethod>();
		
		methods.add(new PaymentMethod("MO", true, "MoneyOrder"));
		methods.add(new PaymentMethod("PP", false, "Paypal"));
		methods.add(new PaymentMethod("BS", false, "BeanStream"));
		methods.add(new PaymentMethod("Stripe", false, "Stripe"));
		methods.add(new PaymentMethod("Braintree", true, "Braintree"));
		paymentService.savePaymentMethods(methods);
		
		model.addAttribute("paymentMethods", paymentService.getPaymentMethods());
		return "PaymentMethods";
		
	}
	
	@PostMapping("/paymentMethods/save")
	public String getPaymentMethods(ArrayList<PaymentMethod> list, Model model) {
		
		
		paymentService.savePaymentMethods(list);
		model.addAttribute("paymentMethods", paymentService.getPaymentMethods());
		return "PaymentMethods";
		
	}
	
	@RequestMapping("/paymentMethod/{code}")
	public String invokePaymentMethod(@PathVariable("code") String code, Model model) {
		System.out.println(code);
		PaymentMethod method= paymentService.getPaymentMethod(code);
		model.addAttribute("paymentMethod", method);
		return method.getPaymentName();
	    }
}

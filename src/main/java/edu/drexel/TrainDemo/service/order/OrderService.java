package edu.drexel.TrainDemo.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.model.checkout.OrderSummary;
import edu.drexel.TrainDemo.model.order.Order;

@Service
public interface OrderService {

	List<Order> commitOrder();

	Order submitOrder(Order order);

	OrderSummary getOrderSummary(Order order);

}

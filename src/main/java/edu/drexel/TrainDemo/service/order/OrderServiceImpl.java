package edu.drexel.TrainDemo.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.model.checkout.OrderSummary;
import edu.drexel.TrainDemo.model.order.Order;
import edu.drexel.TrainDemo.repositories.order.OrderRepository;;
@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepo;

	

	@Override
	public List<Order> commitOrder() {
		return null;
	}

	@Override
	public Order submitOrder(Order order) {
		return null;
	}

	@Override
	public OrderSummary getOrderSummary(Order order) {
		return null;
	}

}

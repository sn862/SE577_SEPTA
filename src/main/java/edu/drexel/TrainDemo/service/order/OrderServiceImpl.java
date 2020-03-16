package edu.drexel.TrainDemo.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.order.Orders;
import edu.drexel.TrainDemo.model.order.Order;
import edu.drexel.TrainDemo.model.order.OrderSummary;
import edu.drexel.TrainDemo.repositories.order.OrderRepository;;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepo;

	public OrderServiceImpl(OrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;

	}

	@Override
	public List<Order> commitOrder() {
		return null;
	}

	@Override
	public Orders submitOrder(Orders order) {
		return orderRepo.save(order);
	}

	@Override
	public OrderSummary getOrderSummary(Order order) {
		return null;
	}

}

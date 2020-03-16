package edu.drexel.TrainDemo.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.entities.order.Orders;
import edu.drexel.TrainDemo.model.order.Order;
import edu.drexel.TrainDemo.model.order.OrderSummary;;

@Service
public interface OrderService {

	List<Order> commitOrder();

	Orders submitOrder(Orders order);

	OrderSummary getOrderSummary(Order order);

}

package org.iblog;

import org.iblog.observer.OrderUpdateObservable;
import org.iblog.observer.PayingObserver;
import org.iblog.observer.ShippingObserver;
import org.iblog.order.Order;
import org.iblog.order.OrderStatus;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Order order = new Order();
        order.setId("1000000");
        order.setStatus(OrderStatus.AWAIT_PAYMENT);

        OrderUpdateObservable observable = new OrderUpdateObservable(order);
        PayingObserver payingObserver = new PayingObserver();
        observable.addObserver(payingObserver);
        ShippingObserver shippingObserver = new ShippingObserver();
        observable.addObserver(shippingObserver);

        observable.observe(OrderStatus.PAYMENT_RECEIVED);
        observable.observe(OrderStatus.DELIVERED);
        observable.observe(OrderStatus.SHIPPED);
        observable.observe(OrderStatus.SHIPPED);
    }
}

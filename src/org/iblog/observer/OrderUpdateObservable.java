package org.iblog.observer;

import org.iblog.order.Order;
import org.iblog.support.Observable;
import org.iblog.order.OrderStatus;

public class OrderUpdateObservable extends Observable<OrderUpdateObservable, TopObserver, OrderStatus> {

    private Order order;

    public OrderUpdateObservable(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void observe(OrderStatus status) {
        notify(status);
    }

}

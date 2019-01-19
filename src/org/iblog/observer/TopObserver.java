package org.iblog.observer;

import org.iblog.support.Observer;
import org.iblog.order.OrderStatus;

public interface TopObserver extends Observer<OrderUpdateObservable, TopObserver, OrderStatus> {
}

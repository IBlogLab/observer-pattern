package org.iblog.observer;

import org.iblog.order.OrderStatus;

public class PayingObserver implements TopObserver {
    @Override
    public void update(OrderUpdateObservable subject, OrderStatus type) {
        if (type != OrderStatus.PAYMENT_RECEIVED) {
            System.out.println("it's not my business " + subject.getOrder().getId());
            return;
        }
        if (subject.getOrder().getStatus() != OrderStatus.AWAIT_PAYMENT) {
            System.out.println("pre status is error " + subject.getOrder().getStatus());
            return;
        }
        subject.getOrder().setStatus(type);
        System.out.println("updated successfully: " + subject.getOrder().getStatus() + " to " + type);
    }
}

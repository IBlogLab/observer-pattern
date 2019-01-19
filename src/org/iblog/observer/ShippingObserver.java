package org.iblog.observer;

import org.iblog.order.OrderStatus;

public class ShippingObserver implements TopObserver {

    @Override
    public void update(OrderUpdateObservable subject, OrderStatus type) {
        if (type != OrderStatus.SHIPPED) {
            System.out.println("it's not my business " + subject.getOrder().getId());
            return;
        }
        if (subject.getOrder().getStatus() != OrderStatus.PAYMENT_RECEIVED) {
            System.out.println("pre status is error " + subject.getOrder().getStatus());
            return;
        }
        subject.getOrder().setStatus(type);
        System.out.println("updated successfully: " + subject.getOrder().getStatus() + " to " + type);
    }
}

package org.iblog.order;

public enum OrderStatus {
    UNKNOWN,
    RECEIVED,
    AWAIT_PAYMENT,
    PAYMENT_RECEIVED,
    SHIPPED,
    DELIVERED
}

package com.DocMate.util;

import com.DocMate.model.Order;

public class OrderValidationUtil {

    public static void validateOrder(Order order) {
        if (order.getCustomerContact() == null || order.getCustomerContact().length() != 10) {
            throw new IllegalArgumentException("Invalid customer contact");
        }

        if (order.getServiceName() == null || order.getServiceName().isEmpty()) {
            throw new IllegalArgumentException("Service name is required");
        }
    }
}

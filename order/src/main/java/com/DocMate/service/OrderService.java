package com.DocMate.service;

import com.DocMate.dao.OrderDao;
import com.DocMate.model.Order;
import com.DocMate.util.OrderValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderDao orderDao;
    private final TwilioService twilioService;

    public OrderService(OrderDao orderDao, TwilioService twilioService) {
        this.orderDao = orderDao;
        this.twilioService = twilioService;
    }

    public void placeOrder(Order order) {
        try {
            OrderValidationUtil.validateOrder(order);
            orderDao.saveOrder(order);

            String message = "Order placed successfully for service: " + order.getServiceName();
            //twilioService.sendMessage(order.getCustomerContact(), message);

            logger.info("Order placed successfully for customer contact: {}", order.getCustomerContact());
        } catch (Exception e) {
            logger.error("Error placing order", e);
            throw new RuntimeException("Order placement failed");
        }
    }
}

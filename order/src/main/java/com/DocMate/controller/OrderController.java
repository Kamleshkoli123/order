package com.DocMate.controller;

import com.DocMate.model.Order;
import com.DocMate.service.JwtService;
import com.DocMate.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;
    private final JwtService jwtService;

    public OrderController(OrderService orderService, JwtService jwtService) {
        this.orderService = orderService;
        this.jwtService = jwtService;
    }

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestHeader("Authorization") String token,
                                             @RequestBody Order order) {
        logger.info("Received request to place order");

        if (!jwtService.validateToken(token)) {
            logger.warn("Invalid JWT token");
            return ResponseEntity.status(401).body("Unauthorized");
        }

        try {
            orderService.placeOrder(order);
            return ResponseEntity.ok("Order placed successfully");
        } catch (Exception e) {
            logger.error("Error placing order", e);
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}

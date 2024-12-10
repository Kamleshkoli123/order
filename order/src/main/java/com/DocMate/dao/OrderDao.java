package com.DocMate.dao;

import com.DocMate.model.Order;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

    private final MongoDatabase mongoDatabase;

    public OrderDao(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public void saveOrder(Order order) {
        MongoCollection<Document> collection = mongoDatabase.getCollection("orders");
        Document doc = new Document()
                .append("serviceName", order.getServiceName())
                .append("paymentStatus", order.getPaymentStatus())
                .append("customerContact", order.getCustomerContact())
                .append("agentContact", order.getAgentContact())
                .append("orderStatus", order.getOrderStatus())
                .append("orderId", order.getOrderId())
                .append("payload", order.getPayload())
                .append("executiveId", order.getExecutiveId());
        collection.insertOne(doc);
    }
}

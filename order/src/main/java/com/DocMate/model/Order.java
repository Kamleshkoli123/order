package com.DocMate.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
public class Order {
    @Id
    private String id;
    private String serviceName;
    private String paymentStatus = "unpaid";
    private String customerContact;
    private String agentContact;
    private String orderStatus = "pending";
    private String orderId;
    private Map<String, String> payload;
    private String executiveId = "not_assigned";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getAgentContact() {
		return agentContact;
	}
	public void setAgentContact(String agentContact) {
		this.agentContact = agentContact;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Map<String, String> getPayload() {
		return payload;
	}
	public void setPayload(Map<String, String> payload) {
		this.payload = payload;
	}
	public String getExecutiveId() {
		return executiveId;
	}
	public void setExecutiveId(String executiveId) {
		this.executiveId = executiveId;
	}
    
    
}

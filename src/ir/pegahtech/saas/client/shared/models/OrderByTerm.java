package ir.pegahtech.saas.client.shared.models;

import java.util.List;
import java.util.Date;
import ir.pegahtech.saas.client.shared.models.*;

public class OrderByTerm {

	public static final String FIELD = "field";
	public static final String ORDERTERM = "orderTerm";

	private String field;
	private OrderTerm orderTerm;
	
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public OrderTerm getOrderTerm() {
		return orderTerm;
	}
	public void setOrderTerm(OrderTerm orderTerm) {
		this.orderTerm = orderTerm;
	}

}

package ir.pegahtech.saas.client.shared.models;

public enum OrderTerm {
	ASC(1),DESC(2);

	private final int val;
	private OrderTerm(int val){ this.val = val; }
	public int getVal(){ return val; }
}
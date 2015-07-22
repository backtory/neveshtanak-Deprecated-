package ir.pegahtech.saas.client.shared.enums;

public enum UserDirection {
	From(1),To(2),Both(3);

	private final int val;
	private UserDirection(int val){ this.val = val; }
	public int getVal(){ return val; }
}
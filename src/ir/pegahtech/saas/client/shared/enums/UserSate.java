package ir.pegahtech.saas.client.shared.enums;

public enum UserSate {
	Requested(1),Rejected(2),Accepted(3),Deleted(4);

	private final int val;
	private UserSate(int val){ this.val = val; }
	public int getVal(){ return val; }
}
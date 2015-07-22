package ir.pegahtech.saas.client.shared.http;

public class NetworkFailureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3913163106305989043L;

	public NetworkFailureException() {
		super();
	}
	
	public NetworkFailureException(String msg) {
		super(msg);
	}
	
	public NetworkFailureException(Throwable t) {
		super(t);
	}
}

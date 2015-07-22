package ir.pegahtech.saas.client.shared.http;

public interface ServiceCallback<T> {
	public static final int RESULT_CODE_NETWORK_FAILURE = 1;
	public static final int RESULT_CODE_GENERAL_FAILURE = 2;
	
	void success(T result);
	void fail(int resultCode);
}

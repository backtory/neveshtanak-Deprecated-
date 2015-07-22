package ir.pegahtech.saas.client.shared.http;

public enum HttpMethods {
	GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE");
	
	private String method;
	private HttpMethods(String method) {
		setMethod(method);
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
}

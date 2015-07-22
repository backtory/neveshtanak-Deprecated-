package ir.pegahtech.saas.client.shared.models;

import java.util.List;
import java.util.Date;
import ir.pegahtech.saas.client.shared.models.*;

public class StringPair {

	public static final String KEY = "key";
	public static final String VALUE = "value";

	private String key;
	private String value;
	
	public StringPair (){

	}

	public StringPair (String key,String value){
		this.key = key;
		this.value = value;

	}

	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}

package ir.pegahtech.saas.client.shared.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import ir.pegahtech.saas.client.shared.models.*;

public class ContentCreateModel {

	public static final String FIELDMAP = "fieldMap";

	private List<StringPair> fieldMap;
	
	
	public List<StringPair> getFieldMap() {
        if(fieldMap == null) fieldMap = new ArrayList<StringPair>();
		return fieldMap;
	}
	public void setFieldMap(List<StringPair> fieldMap) {
		this.fieldMap = fieldMap;
	}

}

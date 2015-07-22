package ir.pegahtech.saas.client.shared.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import ir.pegahtech.saas.client.shared.models.*;

public class ContentUpdateModel {

	public static final String FIELDMAP = "fieldMap";
	public static final String ENTITYID = "entityId";

	private List<StringPair> fieldMap;
	private String entityId;
	
	
	public List<StringPair> getFieldMap() {
        if(fieldMap == null)
            fieldMap = new ArrayList<StringPair>();
		return fieldMap;
	}
	public void setFieldMap(List<StringPair> fieldMap) {
		this.fieldMap = fieldMap;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

}

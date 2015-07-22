package ir.pegahtech.saas.client.shared.models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 4/26/15.
 */
public class BaseModel {
    private Map<String, String> fieldsMap = new HashMap<String, String>();

    protected void notifyChange(String property, Object value) {
        if (fieldsMap.containsKey(property))
            fieldsMap.remove(property);

        fieldsMap.put(property, value == null ? null : value.toString());
    }

    public Map<String, String> __changes() {
        return fieldsMap;
    }
}

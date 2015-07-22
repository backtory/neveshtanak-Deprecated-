package ir.pegahtech.saas.client.shared.conf;

/**
 * Created by root on 7/20/15.
 */
public class SaaSServiceInfo {
    private Boolean isAsync;
    private String className;
    private String methodName;
    private String url;
    private String tableId;
    private String schemaId;

    public SaaSServiceInfo() { }
    public SaaSServiceInfo(Boolean isAsync, String className, String methodName, String url, String tableId, String schemaId) {
        setIsAsync(isAsync);
        setClassName(className);
        setMethodName(methodName);
        setUrl(url);
        setTableId(tableId);
        setSchemaId(schemaId);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    public Boolean getIsAsync() {
        return isAsync;
    }

    public void setIsAsync(Boolean isAsync) {
        this.isAsync = isAsync;
    }
}

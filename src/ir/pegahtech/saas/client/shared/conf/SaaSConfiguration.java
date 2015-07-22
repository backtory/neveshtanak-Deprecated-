package ir.pegahtech.saas.client.shared.conf;

import com.squareup.okhttp.OkHttpClient;

import java.util.UUID;

/**
 * Created by root on 4/26/15.
 */
public interface SaaSConfiguration {
    public String getSecretKey();
    public UUID getFileTableId();
    public String getApiBaseUrl();
    public SaaSDataProvider getDataProvider();
    public OkHttpClient getHttpClient();
    public UUID getSchemaId();
    public String getLoggedInUsername();
    public String getLoggedInUserId();
    public void addPostProcess(SaaSPostProcess postProcess);
    public void removePostProcess(String processId);
}

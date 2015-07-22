package ir.pegahtech.saas.client.neveshtanak;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import ir.pegahtech.saas.client.shared.conf.SaaSConfiguration;
import ir.pegahtech.saas.client.shared.conf.SaaSDataProvider;
import ir.pegahtech.saas.client.shared.conf.SaaSPostProcess;
import ir.pegahtech.saas.client.shared.conf.SaaSServiceInfo;
import ir.pegahtech.saas.client.shared.security.RefreshTokenInterceptor;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class NeveshtanakConfiguration implements SaaSConfiguration {
	public static final String serviceRootUrl = "http://185.4.29.138:48000/ContentServices_WAR/";
	public static final String fileTableId = "c6837b76-9f79-4249-b278-5f0ed6c8bc4c";

	private static NeveshtanakConfiguration _instance = new NeveshtanakConfiguration();
	private NeveshtanakConfiguration() { }

	private static SaaSDataProvider dataProvider;
	private static OkHttpClient httpClient;
	private List<SaaSPostProcess> postProcesses = new ArrayList<SaaSPostProcess>();

    @Override
    public SaaSDataProvider getDataProvider() {
        return dataProvider;
    }

	public static void initialize(File cacheDirectory, SaaSDataProvider dp) {
        dataProvider = dp;
        httpClient = new OkHttpClient();
        httpClient.getDispatcher().setMaxRequests(15);
        httpClient.setCache(new Cache(cacheDirectory, 1024 * 1024 * 10));
        httpClient.interceptors().add(new RefreshTokenInterceptor(instance()));	}

	@Override
	public UUID getFileTableId() {
		return fileTableId == null || fileTableId.trim().equals("") ? null : UUID.fromString(fileTableId);
	}

	@Override
	public String getApiBaseUrl() {
		return serviceRootUrl;
	}

    @Override
    public String getSecretKey() {
        return "";
    }
    @Override
    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    public static NeveshtanakConfiguration instance() { return _instance; }

    @Override
    public UUID getSchemaId() {
        return UUID.fromString("0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
    }
    @Override
    public String getLoggedInUsername() {
        return dataProvider.keyExists("SAAS_user_name")
                ? dataProvider.load("SAAS_user_name")
                : null;
    }


    @Override
    public String getLoggedInUserId() {
        return dataProvider.keyExists("SAAS_user_id")
                ? dataProvider.load("SAAS_user_id")
                : null;
    }
    @Override
    public void addPostProcess(SaaSPostProcess postProcess) {
        for (SaaSPostProcess process: postProcesses)
            if (process.getProcessId().equals(postProcess.getProcessId()))
                throw new RuntimeException("Duplicate process with same id: " + postProcess.getProcessId());

        postProcesses.add(postProcess);
    }

    @Override
    public void removePostProcess(String processId) {
        Iterator<SaaSPostProcess> iterator = postProcesses.iterator();
        while (iterator.hasNext()) {
            SaaSPostProcess next = iterator.next();
            if (next.getProcessId().equals(processId))
                iterator.remove();
        }
    }

    public void serviceStarted(Boolean isAsync, String className, String methodName, String url, String tableId, String schemaId) {
        for (SaaSPostProcess process: postProcesses)
            process.serviceStarted(new SaaSServiceInfo(isAsync, className, methodName, url, tableId, schemaId));
    }

    public void serviceFailed(Boolean isAsync, String className, String methodName, String url, String tableId, String schemaId) {
        for (SaaSPostProcess process: postProcesses)
            process.serviceFailed(new SaaSServiceInfo(isAsync, className, methodName, url, tableId, schemaId));
    }

    public void serviceSucceed(Boolean isAsync, String className, String methodName, String url, String tableId, String schemaId) {
        for (SaaSPostProcess process: postProcesses)
            process.serviceSucceed(new SaaSServiceInfo(isAsync, className, methodName, url, tableId, schemaId));
    }
}
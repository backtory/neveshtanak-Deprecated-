package ir.pegahtech.saas.client.shared.security;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import ir.pegahtech.saas.client.shared.conf.SaaSConfiguration;
import ir.pegahtech.saas.client.shared.conf.SaaSDataProvider;
import ir.pegahtech.saas.client.shared.http.GsonHelper;
import ir.pegahtech.saas.client.shared.http.HttpConnectionUtility;
import ir.pegahtech.saas.client.shared.http.HttpMethods;
import ir.pegahtech.saas.client.shared.models.DateUtility;
import ir.pegahtech.saas.client.shared.models.TokenObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 7/11/15.
 */
public class RefreshTokenInterceptor implements Interceptor {
    private SaaSConfiguration saaSConfiguration;
    private String Username_KEY = "SAAS_user_name";
    private String Password_KEY = "SAAS_password";
    private String AccessToken_KEY = "SAAS_access_token";

    public RefreshTokenInterceptor(SaaSConfiguration configuration) {
        this.saaSConfiguration = configuration;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        SaaSDataProvider map = saaSConfiguration
                .getDataProvider();

        Request request = addAuthToRequest(chain.request(), map);

        // try the request
        Response response = chain.proceed(request);

        if ((response.code() == 401 || response.code() == 403)
                && !request.url().toString().contains("oauth/token?")) { // Unauthorized

            String url = saaSConfiguration.getApiBaseUrl()
                    + "oauth/token?tp=refreshing&grant_type=password&client_id=saas-trusted-client&"
                    + "username={username}&password={password}&schema_id=" + saaSConfiguration.getSchemaId();

            String username = map.load("SAAS_user_name");
            String password = map.load("SAAS_password");

            Map<String, Object> pathParams = new HashMap<String, Object>();
            Object postData = null;

            pathParams.put("username", username);
            pathParams.put("password", password);

            // create a new request and modify it accordingly using the new token
            OkHttpClient httpClient = saaSConfiguration.getHttpClient();
            Request newRequest = HttpConnectionUtility.createOkRequest(saaSConfiguration, url, HttpMethods.GET,
                    pathParams, postData, null);

            // retry the request
            if (username != null && !("".equals(username)) && password != null && !("".equals(password))) {
                Response authResponse = chain.proceed(newRequest);
                if (authResponse.code() >= 200 && authResponse.code() <= 299) {
                    String body = authResponse.body().string();
                    TokenObject object = GsonHelper.getCustomGson()
                            .fromJson(body, TokenObject.class);
                    map.save("SAAS_access_token", object.getAccess_token());
                    map.save("SAAS_refresh_token", object.getRefresh_token());
                    map.save("SAAS_token_type", object.getToken_type());
                    map.save("SAAS_expires_in", object.getExpires_in());
                    map.save("SAAS_scope", object.getScope());
                    map.save("SAAS_token_time", DateUtility.getCurrentTime());

                    // Retry request with new authentication header
                    request = addAuthToRequest(chain.request(), map);
                    return chain.proceed(request);
                }
                return authResponse;
            }

        }

        // otherwise just pass the original response on
        return response;
    }

    protected Request addAuthToRequest(Request rawRequest, SaaSDataProvider map) {
        Request.Builder requestBuilder = rawRequest.newBuilder();

        if (map.keyExists(AccessToken_KEY))
            requestBuilder.header("Authorization", "bearer " + map.load(AccessToken_KEY));

        Request request = requestBuilder.build();
        return request;
    }

}
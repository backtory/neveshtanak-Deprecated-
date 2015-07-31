package ir.pegahtech.saas.client.Neveshtanak.services;

import ir.pegahtech.saas.client.Neveshtanak.NeveshtanakConfiguration;
import ir.pegahtech.saas.client.Neveshtanak.models.mobileusers.*;
import ir.pegahtech.saas.client.shared.http.CacheControlBuilder;
import ir.pegahtech.saas.client.shared.enums.*;
import ir.pegahtech.saas.client.shared.security.*;
import ir.pegahtech.saas.client.shared.models.*;
import ir.pegahtech.saas.client.shared.builder.*;
import ir.pegahtech.saas.client.shared.file.*;
import ir.pegahtech.saas.client.shared.http.HttpConnectionUtility;
import ir.pegahtech.saas.client.shared.http.HttpMethods;
import ir.pegahtech.saas.client.shared.http.NetworkFailureException;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.threading.AndroidRunnable;

import java.io.IOException;
import java.util.*;

//import com.google.gson.reflect.TypeToken;

/**
 * Class MobileUsersService helps you access the user functionalities. 
 * You'll be able to access some utilities for them in this service
 */

public class MobileUsersService {

    public  void list(final ListRequest request,  final ServiceCallback<MobileUserListResponse> callback) {
        list(request, callback, null);
    }
   public  void list(final ListRequest request,  final ServiceCallback<MobileUserListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/468dfb37-32d3-4d2b-a203-608600b52959/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "list", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


        ServiceCallback<MobileUserListResponse> callBackTemp = new ServiceCallback<MobileUserListResponse>() {
            @Override
            public void success(final MobileUserListResponse object) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "list", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "list", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    MobileUserListResponse.class,
                    callBackTemp
                );
	}
    public  MobileUserListResponse listSync(final ListRequest request) throws NetworkFailureException {
        return listSync(request, null);
    }

   public  MobileUserListResponse listSync(final ListRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/468dfb37-32d3-4d2b-a203-608600b52959/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "list", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


       MobileUserListResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    MobileUserListResponse.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "list", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "list", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void deleteMobileUser(final DeleteRequest request,  final ServiceCallback<DeleteResponse> callback) {
        deleteMobileUser(request, callback, null);
    }
   public  void deleteMobileUser(final DeleteRequest request,  final ServiceCallback<DeleteResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/468dfb37-32d3-4d2b-a203-608600b52959/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "deleteMobileUser", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = request.getContentIds();


        ServiceCallback<DeleteResponse> callBackTemp = new ServiceCallback<DeleteResponse>() {
            @Override
            public void success(final DeleteResponse object) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "deleteMobileUser", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "deleteMobileUser", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.DELETE,
                    pathParams,
                    postData,
                    cacheBuilder,
                    DeleteResponse.class,
                    callBackTemp
                );
	}
    public  DeleteResponse deleteMobileUserSync(final DeleteRequest request) throws NetworkFailureException {
        return deleteMobileUserSync(request, null);
    }

   public  DeleteResponse deleteMobileUserSync(final DeleteRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/468dfb37-32d3-4d2b-a203-608600b52959/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "deleteMobileUser", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = request.getContentIds();


       DeleteResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.DELETE,
                    pathParams,
                    postData,
                    cacheBuilder,
                    DeleteResponse.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "deleteMobileUser", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "deleteMobileUser", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void update(final MobileUserEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        update(request, callback, null);
    }
   public  void update(final MobileUserEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/468dfb37-32d3-4d2b-a203-608600b52959/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "update", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = new ContentUpdateBuilder().build(request);


        ServiceCallback<InsertUpdateResponse> callBackTemp = new ServiceCallback<InsertUpdateResponse>() {
            @Override
            public void success(final InsertUpdateResponse object) {
			new ContentUpdateBuilder().update(request,object);
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "update", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "update", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateResponse.class,
                    callBackTemp
                );
	}
    public  InsertUpdateResponse updateSync(final MobileUserEntity request) throws NetworkFailureException {
        return updateSync(request, null);
    }

   public  InsertUpdateResponse updateSync(final MobileUserEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/468dfb37-32d3-4d2b-a203-608600b52959/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "update", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = new ContentUpdateBuilder().build(request);


       InsertUpdateResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateResponse.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "update", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }

			new ContentUpdateBuilder().update(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "update", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void signUp(final MobileUserEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        signUp(request, callback, null);
    }
   public  void signUp(final MobileUserEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/user/468dfb37-32d3-4d2b-a203-608600b52959/register";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "signUp", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = new ContentCreateBuilder().build(request);


        ServiceCallback<InsertUpdateResponse> callBackTemp = new ServiceCallback<InsertUpdateResponse>() {
            @Override
            public void success(final InsertUpdateResponse object) {
			new ContentCreateBuilder().update(request,object);
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "signUp", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "signUp", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateResponse.class,
                    callBackTemp
                );
	}
    public  InsertUpdateResponse signUpSync(final MobileUserEntity request) throws NetworkFailureException {
        return signUpSync(request, null);
    }

   public  InsertUpdateResponse signUpSync(final MobileUserEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/user/468dfb37-32d3-4d2b-a203-608600b52959/register";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "signUp", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = new ContentCreateBuilder().build(request);


       InsertUpdateResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateResponse.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "signUp", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }

			new ContentCreateBuilder().update(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "signUp", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void logIn(final LogInRequest request,  final ServiceCallback<TokenObject> callback) {
        logIn(request, callback, null);
    }
   public  void logIn(final LogInRequest request,  final ServiceCallback<TokenObject> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "oauth/token?grant_type=password&client_id=saas-trusted-client&username={username}&password={password}&schema_id=5a0ddb42-c081-4f70-a83a-0e4314da452e";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "logIn", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;

			pathParams.put("username", request.getUsername());
			pathParams.put("password", request.getPassword());



        ServiceCallback<TokenObject> callBackTemp = new ServiceCallback<TokenObject>() {
            @Override
            public void success(final TokenObject object) {
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_access_token",object.getAccess_token());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_refresh_token",object.getRefresh_token());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_token_type",object.getToken_type());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_expires_in",object.getExpires_in());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_scope",object.getScope());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_user_id",object.getUserId());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_token_time",DateUtility.getCurrentTime());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_user_name",request.getUsername());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_password",request.getPassword());
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "logIn", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "logIn", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.GET,
                    pathParams,
                    postData,
                    cacheBuilder,
                    TokenObject.class,
                    callBackTemp
                );
	}
    public  TokenObject logInSync(final LogInRequest request) throws NetworkFailureException {
        return logInSync(request, null);
    }

   public  TokenObject logInSync(final LogInRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "oauth/token?grant_type=password&client_id=saas-trusted-client&username={username}&password={password}&schema_id=5a0ddb42-c081-4f70-a83a-0e4314da452e";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "logIn", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;

			pathParams.put("username", request.getUsername());
			pathParams.put("password", request.getPassword());



       TokenObject object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.GET,
                    pathParams,
                    postData,
                    cacheBuilder,
                    TokenObject.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "logIn", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }

			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_access_token",object.getAccess_token());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_refresh_token",object.getRefresh_token());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_token_type",object.getToken_type());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_expires_in",object.getExpires_in());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_scope",object.getScope());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_user_id",object.getUserId());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_token_time",DateUtility.getCurrentTime());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_user_name",request.getUsername());
			NeveshtanakConfiguration.instance().getDataProvider().save("SAAS_password",request.getPassword());

       NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "logIn", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void userInfo(final UserInfo request,  final ServiceCallback<MobileUserEntity> callback) {
        userInfo(request, callback, null);
    }
   public  void userInfo(final UserInfo request,  final ServiceCallback<MobileUserEntity> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/user/468dfb37-32d3-4d2b-a203-608600b52959/userInfo?username={username}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "userInfo", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;




        ServiceCallback<MobileUserEntity> callBackTemp = new ServiceCallback<MobileUserEntity>() {
            @Override
            public void success(final MobileUserEntity object) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "userInfo", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "userInfo", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }
        };

        HttpConnectionUtility.getParsedDataFromUrlAsync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.GET,
                    pathParams,
                    postData,
                    cacheBuilder,
                    MobileUserEntity.class,
                    callBackTemp
                );
	}
    public  MobileUserEntity userInfoSync(final UserInfo request) throws NetworkFailureException {
        return userInfoSync(request, null);
    }

   public  MobileUserEntity userInfoSync(final UserInfo request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/user/468dfb37-32d3-4d2b-a203-608600b52959/userInfo?username={username}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "MobileUser", "userInfo", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;




       MobileUserEntity object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.GET,
                    pathParams,
                    postData,
                    cacheBuilder,
                    MobileUserEntity.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "MobileUser", "userInfo", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "MobileUser", "userInfo", url, "468dfb37-32d3-4d2b-a203-608600b52959", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
}

package ir.pegahtech.saas.client.neveshtanak.services;

import ir.pegahtech.saas.client.neveshtanak.NeveshtanakConfiguration;
import ir.pegahtech.saas.client.neveshtanak.models.jomles.*;
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
 * Class JomlesService helps you retrieve list of Jomles, 
 * Create new Jomle, 
 * Change Info of a(n) Jomle 
 * or Delete one of them. If you enable tag or category support for this class, 
 * You'll be able to access some utilities for them in this service
 */

public class JomlesService {

    public <T> void customList(final ListRequest request,  final ServiceCallback<T> callback, Class<T> cls) {
        customList(request, callback, null, cls);
    }
   public <T> void customList(final ListRequest request,  final ServiceCallback<T> callback, CacheControlBuilder cacheBuilder , Class<T> cls) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "customList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


        ServiceCallback<T> callBackTemp = new ServiceCallback<T>() {
            @Override
            public void success(final T object) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "customList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "customList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                    cls,
                    callBackTemp
                );
	}
    public <T> T customListSync(final ListRequest request, Class<T> cls) throws NetworkFailureException {
        return customListSync(request, null, cls);
    }

   public <T> T customListSync(final ListRequest request,  CacheControlBuilder cacheBuilder, Class<T> cls)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "customList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


       T object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    cls
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "customList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "customList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void list(final ListRequest request,  final ServiceCallback<JomleListResponse> callback) {
        list(request, callback, null);
    }
   public  void list(final ListRequest request,  final ServiceCallback<JomleListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "list", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


        ServiceCallback<JomleListResponse> callBackTemp = new ServiceCallback<JomleListResponse>() {
            @Override
            public void success(final JomleListResponse object) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "list", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "list", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                    JomleListResponse.class,
                    callBackTemp
                );
	}
    public  JomleListResponse listSync(final ListRequest request) throws NetworkFailureException {
        return listSync(request, null);
    }

   public  JomleListResponse listSync(final ListRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "list", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


       JomleListResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    JomleListResponse.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "list", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "list", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void create(final JomleEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        create(request, callback, null);
    }
   public  void create(final JomleEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/create_and_get";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "create", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "create", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "create", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
    public  InsertUpdateResponse createSync(final JomleEntity request) throws NetworkFailureException {
        return createSync(request, null);
    }

   public  InsertUpdateResponse createSync(final JomleEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/create_and_get";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "create", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "create", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }

			new ContentCreateBuilder().update(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "create", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void createList(final List<JomleEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback) {
        createList(request, callback, null);
    }
   public  void createList(final List<JomleEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/create_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "createList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = new ContentCreateBuilder().buildList(request);


        ServiceCallback<InsertUpdateListResponse> callBackTemp = new ServiceCallback<InsertUpdateListResponse>() {
            @Override
            public void success(final InsertUpdateListResponse object) {
			new ContentCreateBuilder().updateAll(request,object);
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "createList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "createList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                    InsertUpdateListResponse.class,
                    callBackTemp
                );
	}
    public  InsertUpdateListResponse createListSync(final List<JomleEntity> request) throws NetworkFailureException {
        return createListSync(request, null);
    }

   public  InsertUpdateListResponse createListSync(final List<JomleEntity> request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/create_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "createList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = new ContentCreateBuilder().buildList(request);


       InsertUpdateListResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateListResponse.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "createList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }

			new ContentCreateBuilder().updateAll(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "createList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void updateList(final List<JomleEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback) {
        updateList(request, callback, null);
    }
   public  void updateList(final List<JomleEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/update_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "updateList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = new ContentUpdateBuilder().buildList(request);


        ServiceCallback<InsertUpdateListResponse> callBackTemp = new ServiceCallback<InsertUpdateListResponse>() {
            @Override
            public void success(final InsertUpdateListResponse object) {
			new ContentUpdateBuilder().updateAll(request,object);
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "updateList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "updateList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                    InsertUpdateListResponse.class,
                    callBackTemp
                );
	}
    public  InsertUpdateListResponse updateListSync(final List<JomleEntity> request) throws NetworkFailureException {
        return updateListSync(request, null);
    }

   public  InsertUpdateListResponse updateListSync(final List<JomleEntity> request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/update_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "updateList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = new ContentUpdateBuilder().buildList(request);


       InsertUpdateListResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    InsertUpdateListResponse.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "updateList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }

			new ContentUpdateBuilder().updateAll(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "updateList", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void update(final JomleEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        update(request, callback, null);
    }
   public  void update(final JomleEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "update", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "update", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "update", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
    public  InsertUpdateResponse updateSync(final JomleEntity request) throws NetworkFailureException {
        return updateSync(request, null);
    }

   public  InsertUpdateResponse updateSync(final JomleEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "update", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "update", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }

			new ContentUpdateBuilder().update(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "update", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void deleteJomle(final DeleteRequest request,  final ServiceCallback<QueryOutputNumber> callback) {
        deleteJomle(request, callback, null);
    }
   public  void deleteJomle(final DeleteRequest request,  final ServiceCallback<QueryOutputNumber> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "deleteJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = request.getContentIds();


        ServiceCallback<QueryOutputNumber> callBackTemp = new ServiceCallback<QueryOutputNumber>() {
            @Override
            public void success(final QueryOutputNumber object) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "deleteJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "deleteJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                    QueryOutputNumber.class,
                    callBackTemp
                );
	}
    public  QueryOutputNumber deleteJomleSync(final DeleteRequest request) throws NetworkFailureException {
        return deleteJomleSync(request, null);
    }

   public  QueryOutputNumber deleteJomleSync(final DeleteRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "deleteJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = request.getContentIds();


       QueryOutputNumber object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    QueryOutputNumber.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "deleteJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "deleteJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void restoreJomle(final RestoreRequest request,  final ServiceCallback<QueryOutputNumber> callback) {
        restoreJomle(request, callback, null);
    }
   public  void restoreJomle(final RestoreRequest request,  final ServiceCallback<QueryOutputNumber> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/restore";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "restoreJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;


			postData = request.getContentIds();


        ServiceCallback<QueryOutputNumber> callBackTemp = new ServiceCallback<QueryOutputNumber>() {
            @Override
            public void success(final QueryOutputNumber object) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "restoreJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "restoreJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                    QueryOutputNumber.class,
                    callBackTemp
                );
	}
    public  QueryOutputNumber restoreJomleSync(final RestoreRequest request) throws NetworkFailureException {
        return restoreJomleSync(request, null);
    }

   public  QueryOutputNumber restoreJomleSync(final RestoreRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/29f589ad-5a47-4d81-b2bf-f35b72a048ec/restore";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Jomle", "restoreJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;


			postData = request.getContentIds();


       QueryOutputNumber object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    QueryOutputNumber.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "Jomle", "restoreJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "Jomle", "restoreJomle", url, "29f589ad-5a47-4d81-b2bf-f35b72a048ec", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
}

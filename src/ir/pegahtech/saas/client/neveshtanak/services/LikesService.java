package ir.pegahtech.saas.client.neveshtanak.services;

import ir.pegahtech.saas.client.neveshtanak.NeveshtanakConfiguration;
import ir.pegahtech.saas.client.neveshtanak.models.likes.*;
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
 * Class LikesService helps you retrieve list of Likes, 
 * Create new Like, 
 * Change Info of a(n) Like 
 * or Delete one of them. If you enable tag or category support for this class, 
 * You'll be able to access some utilities for them in this service
 */

public class LikesService {

    public <T> void customList(final ListRequest request,  final ServiceCallback<T> callback, Class<T> cls) {
        customList(request, callback, null, cls);
    }
   public <T> void customList(final ListRequest request,  final ServiceCallback<T> callback, CacheControlBuilder cacheBuilder , Class<T> cls) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "customList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "customList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "customList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "customList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "customList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "customList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void list(final ListRequest request,  final ServiceCallback<LikeListResponse> callback) {
        list(request, callback, null);
    }
   public  void list(final ListRequest request,  final ServiceCallback<LikeListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "list", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


        ServiceCallback<LikeListResponse> callBackTemp = new ServiceCallback<LikeListResponse>() {
            @Override
            public void success(final LikeListResponse object) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "list", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "list", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                    LikeListResponse.class,
                    callBackTemp
                );
	}
    public  LikeListResponse listSync(final ListRequest request) throws NetworkFailureException {
        return listSync(request, null);
    }

   public  LikeListResponse listSync(final ListRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "list", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


       LikeListResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    LikeListResponse.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "list", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "list", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void create(final LikeEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        create(request, callback, null);
    }
   public  void create(final LikeEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/create_and_get";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "create", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "create", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "create", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
    public  InsertUpdateResponse createSync(final LikeEntity request) throws NetworkFailureException {
        return createSync(request, null);
    }

   public  InsertUpdateResponse createSync(final LikeEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/create_and_get";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "create", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "create", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }

			new ContentCreateBuilder().update(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "create", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void createList(final List<LikeEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback) {
        createList(request, callback, null);
    }
   public  void createList(final List<LikeEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/create_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "createList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "createList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "createList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
    public  InsertUpdateListResponse createListSync(final List<LikeEntity> request) throws NetworkFailureException {
        return createListSync(request, null);
    }

   public  InsertUpdateListResponse createListSync(final List<LikeEntity> request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/create_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "createList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "createList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }

			new ContentCreateBuilder().updateAll(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "createList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void updateList(final List<LikeEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback) {
        updateList(request, callback, null);
    }
   public  void updateList(final List<LikeEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/update_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "updateList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "updateList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "updateList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
    public  InsertUpdateListResponse updateListSync(final List<LikeEntity> request) throws NetworkFailureException {
        return updateListSync(request, null);
    }

   public  InsertUpdateListResponse updateListSync(final List<LikeEntity> request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/update_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "updateList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "updateList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }

			new ContentUpdateBuilder().updateAll(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "updateList", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void update(final LikeEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        update(request, callback, null);
    }
   public  void update(final LikeEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "update", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "update", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "update", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
    public  InsertUpdateResponse updateSync(final LikeEntity request) throws NetworkFailureException {
        return updateSync(request, null);
    }

   public  InsertUpdateResponse updateSync(final LikeEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "update", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "update", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }

			new ContentUpdateBuilder().update(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "update", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void deleteLike(final DeleteRequest request,  final ServiceCallback<QueryOutputNumber> callback) {
        deleteLike(request, callback, null);
    }
   public  void deleteLike(final DeleteRequest request,  final ServiceCallback<QueryOutputNumber> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "deleteLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "deleteLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "deleteLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
    public  QueryOutputNumber deleteLikeSync(final DeleteRequest request) throws NetworkFailureException {
        return deleteLikeSync(request, null);
    }

   public  QueryOutputNumber deleteLikeSync(final DeleteRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "deleteLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "deleteLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "deleteLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
    public  void restoreLike(final RestoreRequest request,  final ServiceCallback<QueryOutputNumber> callback) {
        restoreLike(request, callback, null);
    }
   public  void restoreLike(final RestoreRequest request,  final ServiceCallback<QueryOutputNumber> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/restore";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "restoreLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "restoreLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "restoreLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
    public  QueryOutputNumber restoreLikeSync(final RestoreRequest request) throws NetworkFailureException {
        return restoreLikeSync(request, null);
    }

   public  QueryOutputNumber restoreLikeSync(final RestoreRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/ab92bc6c-408e-4fda-bc29-5791d6fcafe1/restore";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "Like", "restoreLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "Like", "restoreLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "Like", "restoreLike", url, "ab92bc6c-408e-4fda-bc29-5791d6fcafe1", "0fb9e8a8-2563-41c6-86c8-136b6ac52cc2");
       return object;
    }
}

package ir.pegahtech.saas.client.Neveshtanak.services;

import ir.pegahtech.saas.client.Neveshtanak.NeveshtanakConfiguration;
import ir.pegahtech.saas.client.Neveshtanak.models.jomlelikes.*;
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
 * Class JomleLikesService helps you retrieve list of JomleLikes, 
 * Create new JomleLike, 
 * Change Info of a(n) JomleLike 
 * or Delete one of them. If you enable tag or category support for this class, 
 * You'll be able to access some utilities for them in this service
 */

public class JomleLikesService {

    public <T> void customList(final ListRequest request,  final ServiceCallback<T> callback, Class<T> cls) {
        customList(request, callback, null, cls);
    }
   public <T> void customList(final ListRequest request,  final ServiceCallback<T> callback, CacheControlBuilder cacheBuilder , Class<T> cls) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "customList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "customList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "customList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "customList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "customList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "customList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void list(final ListRequest request,  final ServiceCallback<JomleLikeListResponse> callback) {
        list(request, callback, null);
    }
   public  void list(final ListRequest request,  final ServiceCallback<JomleLikeListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "list", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
        Map<String, Object> pathParams = new HashMap<String, Object>();
        Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


        ServiceCallback<JomleLikeListResponse> callBackTemp = new ServiceCallback<JomleLikeListResponse>() {
            @Override
            public void success(final JomleLikeListResponse object) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(object);
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "list", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "list", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
                    JomleLikeListResponse.class,
                    callBackTemp
                );
	}
    public  JomleLikeListResponse listSync(final ListRequest request) throws NetworkFailureException {
        return listSync(request, null);
    }

   public  JomleLikeListResponse listSync(final ListRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/list?start={start}&pageSize={pageSize}&includeDeleted={includeDeleted}&includeUndeleted={includeUndeleted}";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "list", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       Map<String, Object> pathParams = new HashMap<String, Object>();
       Object postData = null;

			pathParams.put("start", request.getStart());
			pathParams.put("pageSize", request.getPageSize());
			pathParams.put("includeDeleted", request.getIncludeDeleted());
			pathParams.put("includeUndeleted", request.getIncludeUndeleted());

			postData = request.getQueryObject();


       JomleLikeListResponse object = null;
       try {
            object = HttpConnectionUtility.getParsedDataFromUrlSync(
                    NeveshtanakConfiguration.instance(),
                    url,
                    HttpMethods.POST,
                    pathParams,
                    postData,
                    cacheBuilder,
                    JomleLikeListResponse.class
            );
        } catch (IOException e) {
           NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "list", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "list", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void create(final JomleLikeEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        create(request, callback, null);
    }
   public  void create(final JomleLikeEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/create_and_get";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "create", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "create", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "create", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
    public  InsertUpdateResponse createSync(final JomleLikeEntity request) throws NetworkFailureException {
        return createSync(request, null);
    }

   public  InsertUpdateResponse createSync(final JomleLikeEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/create_and_get";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "create", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "create", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }

			new ContentCreateBuilder().update(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "create", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void createList(final List<JomleLikeEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback) {
        createList(request, callback, null);
    }
   public  void createList(final List<JomleLikeEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/create_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "createList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "createList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "createList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
    public  InsertUpdateListResponse createListSync(final List<JomleLikeEntity> request) throws NetworkFailureException {
        return createListSync(request, null);
    }

   public  InsertUpdateListResponse createListSync(final List<JomleLikeEntity> request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/create_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "createList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "createList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }

			new ContentCreateBuilder().updateAll(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "createList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void updateList(final List<JomleLikeEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback) {
        updateList(request, callback, null);
    }
   public  void updateList(final List<JomleLikeEntity> request,  final ServiceCallback<InsertUpdateListResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/update_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "updateList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "updateList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "updateList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
    public  InsertUpdateListResponse updateListSync(final List<JomleLikeEntity> request) throws NetworkFailureException {
        return updateListSync(request, null);
    }

   public  InsertUpdateListResponse updateListSync(final List<JomleLikeEntity> request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/update_all";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "updateList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "updateList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }

			new ContentUpdateBuilder().updateAll(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "updateList", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void update(final JomleLikeEntity request,  final ServiceCallback<InsertUpdateResponse> callback) {
        update(request, callback, null);
    }
   public  void update(final JomleLikeEntity request,  final ServiceCallback<InsertUpdateResponse> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "update", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "update", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "update", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
    public  InsertUpdateResponse updateSync(final JomleLikeEntity request) throws NetworkFailureException {
        return updateSync(request, null);
    }

   public  InsertUpdateResponse updateSync(final JomleLikeEntity request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/update_single";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "update", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "update", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }

			new ContentUpdateBuilder().update(request,object);

       NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "update", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void deleteJomleLike(final DeleteRequest request,  final ServiceCallback<QueryOutputNumber> callback) {
        deleteJomleLike(request, callback, null);
    }
   public  void deleteJomleLike(final DeleteRequest request,  final ServiceCallback<QueryOutputNumber> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "deleteJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "deleteJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "deleteJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
    public  QueryOutputNumber deleteJomleLikeSync(final DeleteRequest request) throws NetworkFailureException {
        return deleteJomleLikeSync(request, null);
    }

   public  QueryOutputNumber deleteJomleLikeSync(final DeleteRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/delete";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "deleteJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "deleteJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "deleteJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
    public  void restoreJomleLike(final RestoreRequest request,  final ServiceCallback<QueryOutputNumber> callback) {
        restoreJomleLike(request, callback, null);
    }
   public  void restoreJomleLike(final RestoreRequest request,  final ServiceCallback<QueryOutputNumber> callback, CacheControlBuilder cacheBuilder ) {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/restore";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "restoreJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
                        NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "restoreJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
                    }
                });
            }

            @Override
            public void fail(final int resultCode) {
                NeveshtanakConfiguration.instance().getDataProvider().runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(resultCode);
                       NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "restoreJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
    public  QueryOutputNumber restoreJomleLikeSync(final RestoreRequest request) throws NetworkFailureException {
        return restoreJomleLikeSync(request, null);
    }

   public  QueryOutputNumber restoreJomleLikeSync(final RestoreRequest request,  CacheControlBuilder cacheBuilder)
       throws NetworkFailureException {
       String accessToken = NeveshtanakConfiguration.instance().getDataProvider().load("SAAS_access_token");
       final String url = NeveshtanakConfiguration.serviceRootUrl + "api/content/e7bf52e6-a25f-40a4-b849-571ab6810439/restore";
       //url = url + (accessToken == null ? "" : ((url.contains("?") ? "&" : "?") + "access_token=" + accessToken));

       NeveshtanakConfiguration.instance().serviceStarted(true, "JomleLike", "restoreJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
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
           NeveshtanakConfiguration.instance().serviceFailed(true, "JomleLike", "restoreJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
            throw new NetworkFailureException(e);
        }


       NeveshtanakConfiguration.instance().serviceSucceed(true, "JomleLike", "restoreJomleLike", url, "e7bf52e6-a25f-40a4-b849-571ab6810439", "5a0ddb42-c081-4f70-a83a-0e4314da452e");
       return object;
    }
}

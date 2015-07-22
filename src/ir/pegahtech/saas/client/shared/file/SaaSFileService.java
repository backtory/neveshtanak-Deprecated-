package ir.pegahtech.saas.client.shared.file;

import ir.pegahtech.saas.client.shared.conf.SaaSConfiguration;
import ir.pegahtech.saas.client.shared.http.NetworkFailureException;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.threading.AndroidRunnable;

import java.io.IOException;

/**
 * Created by hamidreza on 3/9/2015.
 */
public class SaaSFileService {
    public static String uploadSync(final SaaSConfiguration configuration, final String filename, final byte[] bytes)
            throws IOException, NetworkFailureException {
        try {
            String serviceRelativeUrl = configuration.getApiBaseUrl() + "api/content/{tableId}/upload"
                    .replace("{tableId}", configuration.getFileTableId() + "");

            MultipartUtility multipartUtility = new MultipartUtility(serviceRelativeUrl, "UTF-8");
            multipartUtility.addFilePart("multipartFile", filename, bytes);
            return multipartUtility.finish();
        } catch (IOException ex) {
            throw new NetworkFailureException(ex);
        }

    }


    public static void upload(final SaaSConfiguration configuration, final String filename, final byte[] bytes
            , final ServiceCallback<String> callback)
            throws IOException{

        new AndroidRunnable<String>() {
            @Override
            public String fetchResult() throws NetworkFailureException {
                try {
                    return uploadSync(configuration, filename, bytes);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void handleResult(String result) {
                callback.success(result);
            }

            @Override
            public void networkFailure() {
                callback.fail(ServiceCallback.RESULT_CODE_NETWORK_FAILURE);
            }

            @Override
            public void generalFailure() {
                callback.fail(ServiceCallback.RESULT_CODE_GENERAL_FAILURE);
            }
        }.execute();
    }
}
package ir.pegahtech.saas.client.shared.conf;

/**
 * Created by root on 7/20/15.
 */
public interface SaaSPostProcess {
    String getProcessId();
    void serviceStarted(SaaSServiceInfo serviceInfo);
    void serviceFailed(SaaSServiceInfo serviceInfo);
    void serviceSucceed(SaaSServiceInfo serviceInfo);
}

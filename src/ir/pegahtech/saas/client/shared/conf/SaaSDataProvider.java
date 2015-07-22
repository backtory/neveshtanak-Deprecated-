package ir.pegahtech.saas.client.shared.conf;

/**
 * Created by root on 5/26/15.
 */
public interface SaaSDataProvider {
    public void save(String key, String value);
    public String load(String key);
    public boolean keyExists(String key);
    public void remove(String key);
    public void runOnMainThread(Runnable runnable);
}

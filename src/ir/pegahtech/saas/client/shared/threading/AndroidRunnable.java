package ir.pegahtech.saas.client.shared.threading;

import ir.pegahtech.saas.client.shared.http.NetworkFailureException;

public abstract class AndroidRunnable<T> implements Runnable {

    @Override
    public void run() {
        try {
            T result = fetchResult();
            handleResult(result);
        } catch (NetworkFailureException e) {
            networkFailure();
        } catch (Exception e) {
            generalFailure();
        }
    }

    public void execute() {
        ThreadManager.exec(this);
    }

    public abstract T fetchResult() throws NetworkFailureException;
    public abstract void handleResult(T result);
    public abstract void networkFailure();
    public abstract void generalFailure();
}

package ir.pegahtech.saas.client.shared.http;

import java.util.concurrent.TimeUnit;

/**
 * Created by moh on 5/19/15.
 */
public class CacheControlBuilder {
    boolean noCache;
    boolean noStore;
    int maxAgeSeconds = -1;
    int maxStaleSeconds = -1;
    int minFreshSeconds = -1;
    boolean onlyIfCached;
    boolean noTransform;

    /** Don't accept an unvalidated cached response. */
    public CacheControlBuilder noCache() {
        this.noCache = true;
        return this;
    }

    /** Don't store the server's response in any cache. */
    public CacheControlBuilder noStore() {
        this.noStore = true;
        return this;
    }

    /**
     * Sets the maximum age of a cached response. If the cache response's age
     * exceeds {@code maxAge}, it will not be used and a network request will
     * be made.
     *
     * @param maxAge a non-negative integer. This is stored and transmitted with
     *     {@link java.util.concurrent.TimeUnit#SECONDS} precision; finer precision will be lost.
     */
    public CacheControlBuilder maxAge(int maxAge, TimeUnit timeUnit) {
        if (maxAge < 0) throw new IllegalArgumentException("maxAge < 0: " + maxAge);
        long maxAgeSecondsLong = timeUnit.toSeconds(maxAge);
        this.maxAgeSeconds = maxAgeSecondsLong > Integer.MAX_VALUE
                ? Integer.MAX_VALUE
                : (int) maxAgeSecondsLong;
        return this;
    }

    /**
     * Accept cached responses that have exceeded their freshness lifetime by
     * up to {@code maxStale}. If unspecified, stale cache responses will not be
     * used.
     *
     * @param maxStale a non-negative integer. This is stored and transmitted
     *     with {@link java.util.concurrent.TimeUnit#SECONDS} precision; finer precision will be
     *     lost.
     */
    public CacheControlBuilder maxStale(int maxStale, TimeUnit timeUnit) {
        if (maxStale < 0) throw new IllegalArgumentException("maxStale < 0: " + maxStale);
        long maxStaleSecondsLong = timeUnit.toSeconds(maxStale);
        this.maxStaleSeconds = maxStaleSecondsLong > Integer.MAX_VALUE
                ? Integer.MAX_VALUE
                : (int) maxStaleSecondsLong;
        return this;
    }

    /**
     * Sets the minimum number of seconds that a response will continue to be
     * fresh for. If the response will be stale when {@code minFresh} have
     * elapsed, the cached response will not be used and a network request will
     * be made.
     *
     * @param minFresh a non-negative integer. This is stored and transmitted
     *     with {@link java.util.concurrent.TimeUnit#SECONDS} precision; finer precision will be
     *     lost.
     */
    public CacheControlBuilder minFresh(int minFresh, TimeUnit timeUnit) {
        if (minFresh < 0) throw new IllegalArgumentException("minFresh < 0: " + minFresh);
        long minFreshSecondsLong = timeUnit.toSeconds(minFresh);
        this.minFreshSeconds = minFreshSecondsLong > Integer.MAX_VALUE
                ? Integer.MAX_VALUE
                : (int) minFreshSecondsLong;
        return this;
    }

    /**
     * Only accept the response if it is in the cache. If the response isn't
     * cached, a {@code 504 Unsatisfiable Request} response will be returned.
     */
    public CacheControlBuilder onlyIfCached() {
        this.onlyIfCached = true;
        return this;
    }

    /** Don't accept a transformed response. */
    public CacheControlBuilder noTransform() {
        this.noTransform = true;
        return this;
    }
}

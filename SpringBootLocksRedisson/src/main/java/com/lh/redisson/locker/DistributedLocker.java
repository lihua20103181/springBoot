package com.lh.redisson.locker;

import java.util.concurrent.TimeUnit;

/**
 * @author T-lih
 */
public interface DistributedLocker {
    void lock(String lockKey);

    void unlock(String lockKey);

    void lock(String lockKey, int timeout);

    void lock(String lockKey, TimeUnit unit , int timeout);
}

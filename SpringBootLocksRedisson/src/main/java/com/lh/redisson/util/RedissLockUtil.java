package com.lh.redisson.util;

import com.lh.redisson.locker.DistributedLocker;

import java.util.concurrent.TimeUnit;

/**
 * @author T-lih
 */
public class RedissLockUtil {
    private static DistributedLocker redissLock;

    public static void setLocker(DistributedLocker locker) {
        redissLock = locker;
    }

    public static void lock(String lockKey) {
        redissLock.lock(lockKey);
    }

    public static void unlock(String lockKey) {
        redissLock.unlock(lockKey);
    }

    /**
     * 带超时的锁
     * @param lockKey
     * @param timeout 超时时间   单位：秒
     */
    public static void lock(String lockKey, int timeout) {
        redissLock.lock(lockKey, timeout);
    }

    /**
     * 带超时的锁
     * @param lockKey
     * @param unit 时间单位
     * @param timeout 超时时间
     */
    public static void lock(String lockKey, TimeUnit unit , int timeout) {
        redissLock.lock(lockKey, unit, timeout);
    }
}

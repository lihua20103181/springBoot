package com.lh.redisson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppApplacation.class)
public class AppApplacationTest {

    @Autowired
    private RedissonClient redisson;

    @Test
    public void testRedisson() throws InterruptedException {
        RLock lock = redisson.getLock("lock");
        lock.lock(2, TimeUnit.SECONDS);

        Thread t = new Thread() {
            public void run() {
                RLock lock1 = redisson.getLock("lock");
                lock1.lock();
                lock1.unlock();
            };
        };

        t.start();
        t.join();

        lock.unlock();

        redisson.shutdown();
    }

    @Test
    public void test() {
        RBlockingQueue blockingQueue= redisson.getBlockingQueue(this.getClass().getCanonicalName());
        blockingQueue.addAsync("123654");
    }
}
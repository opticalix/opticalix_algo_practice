package com.opticalix.problem;

import com.opticalix.lib.Utils;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用synchronized配wait/notify
 * 用lock配await/signal
 * https://blog.csdn.net/chenchaofuck1/article/details/51592429
 *
 * @author Felix
 * @date 07/08/2019 9:56 AM
 * @email opticalix@gmail.com
 */
public class PrdrCsmrProblem {
    public static void main(String[] args) {
        Buffer<Integer> buffer = new Buffer<>();
        IdGenerator idGenerator = new IdGenerator();
        new Thread(new Producer("p1", buffer, idGenerator)).start();
        new Thread(new Producer("p2", buffer, idGenerator)).start();
        new Thread(new Producer("p3", buffer, idGenerator)).start();
        new Thread(new Consumer("c1", buffer, idGenerator)).start();
        new Thread(new Consumer("c2", buffer, idGenerator)).start();
    }

    static class Buffer<T> {
        int bufSize = 16;
        LinkedList<T> buf;
        Lock lock = new ReentrantLock();
        Condition empty = lock.newCondition();
        Condition full = lock.newCondition();

        public Buffer(int bufSize) {
            this.bufSize = bufSize;
            this.buf = new LinkedList<>();
        }

        public Buffer() {
            this.buf = new LinkedList<>();
        }

        public void consume() {
            lock.lock();
            try {
                while (buf.size() == 0) {
                    empty.await();
                }
                T head = buf.poll();
                Utils.p("consume, obj=" + head + ", buf.size=" + buf.size() + ", thread=" + Thread.currentThread().getName());
                full.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void produce(T t) {
            lock.lock();
            try {
                while (buf.size() == bufSize) {
                    full.await();
                }
                buf.add(t);
                Utils.p("produce, obj=" + t + ", buf.size=" + buf.size() + ", thread=" + Thread.currentThread().getName());
                empty.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Producer implements Runnable {
        IdGenerator idGenerator;
        String name;
        Buffer<Integer> buf;

        public Producer(String name, Buffer<Integer> buf, IdGenerator idGenerator) {
            this.name = name;
            this.buf = buf;
            this.idGenerator = idGenerator;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(new Random().nextInt(500) + 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buf.produce(idGenerator.genId());
            }
        }
    }

    static class Consumer implements Runnable {
        IdGenerator idGenerator;
        String name;
        Buffer<Integer> buf;

        public Consumer(String name, Buffer<Integer> buf, IdGenerator idGenerator) {
            this.name = name;
            this.buf = buf;
            this.idGenerator = idGenerator;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(new Random().nextInt(500) + 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buf.consume();
            }
        }
    }

    static class IdGenerator {
        AtomicInteger id = new AtomicInteger(0);

        int genId() {
            return id.getAndIncrement();
        }
    }
}

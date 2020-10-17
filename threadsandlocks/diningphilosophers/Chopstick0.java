package threadsandlocks.diningphilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Chopstick0 {
    private Lock lock;


    public Chopstick0() {
        lock = new ReentrantLock();
    }

    public void pickUp() {
        /*
         *  if the lock is not available then the current thread becomes
         * disabled for thread scheduling purposes and lies inactive until the
         * lock has been acquired.
         */
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}
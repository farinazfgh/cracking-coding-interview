package threadsandlocks.diningphilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//put back your left chopstick if the rightone is not available
public class ChopStick1 {
    private Lock lock;

    public ChopStick1() {
        lock = new ReentrantLock();
    }

    public void putDown() {
        lock.unlock();
    }

    boolean pickUp() {
        /*
         * This usage ensures that the lock is unlocked if it was acquired, and
         * doesn't try to unlock if the lock was not acquired.
         */
        return lock.tryLock();
    }
}

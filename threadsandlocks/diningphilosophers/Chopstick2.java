package threadsandlocks.diningphilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick2 {
    // monitor+scheduler
    //lock+priority
    Lock lock;
    int priority;

    public Chopstick2(int priority) {
        this.priority = priority;
        lock = new ReentrantLock();
    }

    void pickUp() {
        lock.lock();
    }

    void putDown() {
        lock.unlock();
    }

    public int getPriority() {
        return priority;
    }
}

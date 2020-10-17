package threadsandlocks.diningphilosophers;

public class Philosopher1 extends Thread {
    private int bites = 10;
    private ChopStick1 left, right;

    public Philosopher1(ChopStick1 left, ChopStick1 right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        if (pickUp()) {
            chew();
            putDown();
        }
    }

    public boolean pickUp() {
        if (!left.pickUp()) return false;
        if (!right.pickUp()) {
            left.putDown();
            return false;
        }
        return true;
    }

    public void chew() {
    }

    public void putDown() {
        right.putDown();
        left.putDown();
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}

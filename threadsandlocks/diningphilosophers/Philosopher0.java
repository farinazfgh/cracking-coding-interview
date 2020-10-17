package threadsandlocks.diningphilosophers;
//we don't concern
//ourselves with deadlocks.
class Philosopher0 extends Thread {
    private int bites = 10;
    private Chopstick0 left, right;

    public Philosopher0(Chopstick0 left, Chopstick0 right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        pickUp();
        chew();
        putDown();
    }

    public void pickUp() {
        left.pickUp();
        right.pickUp();
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

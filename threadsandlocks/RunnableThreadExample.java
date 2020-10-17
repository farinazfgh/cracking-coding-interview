package threadsandlocks;

public class RunnableThreadExample implements Runnable {
    int count = 0;
    static int calls1 = 1;
    static int calls2 = 1;

    @Override
    public void run() {
        System.out.println("RunnableThread starting." );
        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("sleeping 500 " + calls1++);
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("RunnableThread interrupted." );
        }
        System.out.println("RunnableThread terminating." );
    }

    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread t = new Thread(instance);
        t.start();
        while (instance.count != 5) {
            try {
                Thread.sleep(250);
                System.out.println("sleeping 250 " + calls2++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package threadsandlocks;

public class MyClass extends Thread {
    static class MyObject {
        public synchronized void foo(String name) {
            try {
                System.out.println("Thread " + name + ". foo(): starting" );
                Thread.sleep(3000);
                System.out.println("Thread " + name + ". foo(): ending" );

            } catch (InterruptedException e) {
                System.out.println("Thread " + name + ": interrupted." );
            }
        }
    }

    private String name;
    private MyObject myObject;

    MyClass(MyObject myObject, String name) {
        this.name = name;
        this.myObject = myObject;
    }

    public void run() {
        myObject.foo(name);
    }

    public static void main(String[] args) {
        seperateObjects();
        sharedObject();
    }

    private static void seperateObjects() {
        /* Difference references - both threads can call MyObject.foo() */
/*
        Start in parallel
        Thread 2. foo(): starting
        Thread 1. foo(): starting
        Thread 2. foo(): ending
        Thread 1. foo(): ending
*/


        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
        MyClass thread1 = new MyClass(obj1, "1" );
        MyClass thread2 = new MyClass(obj2, "2" );
        thread1.start();
        thread2.start();
    }

    private static void sharedObject() {
    /* Same reference to obj. Only one will be allowed to call foo, and the other will be forced to wait.
    output:
        start sequentially one after the other
        Thread 1. foo(): starting
        Thread 1. foo(): ending
        Thread 2. foo(): starting
        Thread 2. foo(): ending
    */
        MyObject obj = new MyObject();
        MyClass thread1 = new MyClass(obj, "1" );
        MyClass thread2 = new MyClass(obj, "2" );
        thread1.start();
        thread2.start();
    }
}

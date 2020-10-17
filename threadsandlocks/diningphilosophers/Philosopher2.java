package threadsandlocks.diningphilosophers;

public class Philosopher2 {
    private final int bites = 10;
    Chopstick2 left, right;

    public Philosopher2(Chopstick2 left, Chopstick2 right) {
        if(left.getPriority()<right.getPriority()){
            this.left=left;
            this.right=right;
        }else{
            this.left=right;
            this.right=left;
        }
    }
    void pickUp(){
        left.pickUp();
        right.pickUp();
    }
    void chew(){

    }
    void putDown(){
        right.putDown();
        left.putDown();
    }
    void eat(){
        pickUp();
        chew();
        putDown();
    }
    public void run() {
        for (int i = 0; i < bites; i++) {
            eat() ;
        }
    }
}

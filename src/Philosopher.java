import javax.swing.plaf.TableHeaderUI;
import java.util.Timer;

public class Philosopher extends Thread{
    public int philosopher_number;
    public final Fork leftFork;
    public final Fork rightFork;

    public Philosopher(int philosopher_number,Fork leftFork, Fork rightFork) {
        this.philosopher_number = philosopher_number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void think() throws InterruptedException {
        System.out.println("Philosopher " + philosopher_number + "is thinking");
        Thread.sleep(100);
    }

    public void eat() throws InterruptedException {
        System.out.println("Philosopher  " + philosopher_number + "is eating");
        Thread.sleep(20000);
    }

    public void run() {
        try {
            while (true) {
                think();
                synchronized (leftFork) {
                    leftFork.pickUp();
                    System.out.println("Philosopher " + philosopher_number + " picked up left fork.");
                    synchronized (rightFork) {
                        rightFork.pickUp();
                        System.out.println("Philosopher " + philosopher_number + " picked up right fork.");
                        eat();
                        rightFork.putDown();
                        System.out.println("Philosopher " + philosopher_number + " put down right fork.");
                    }
                    leftFork.putDown();
                    System.out.println("Philosopher " + philosopher_number + " put down left fork.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Philosopher " + philosopher_number + " was interrupted.");
        }
    }
}

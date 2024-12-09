import javax.swing.plaf.TableHeaderUI;
import java.util.Timer;

public class Philosopher extends Thread{
    public int philosopher_number;
    public Fork leftFork;
    public Fork rightFork;

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public static void main() {

    }

    public static void think() throws InterruptedException {
        Thread.sleep(10);
    }

    public void eat() throws InterruptedException {
        System.out.println("Philosopher" + this.philosopher_number + "picks up the forks");
        this.leftFork.picked_up=true;
        this.rightFork.picked_up=true;
        Thread.sleep(100);
        System.out.println("Philosopher " + this.philosopher_number + "");
        this.leftFork.picked_up=false;
        this.rightFork.picked_up=false;
    }

    public void run() {
        synchronized (leftFork) {
            synchronized (rightFork) {
                if (this.leftFork.picked_up == false && this.rightFork.picked_up == false) {
                    try {
                        this.eat();
                    } catch (InterruptedException e) {
                        System.out.println("Runtime exception");
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
 }

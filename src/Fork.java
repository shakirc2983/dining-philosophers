public class Fork {
    public int fork_number;
    public boolean picked_up;
    public Fork(int fork_number, Boolean picked_up) {
        this.fork_number = fork_number;
        this.picked_up = false;
    }

    public synchronized void pickUp() throws InterruptedException {
        while (this.picked_up) {
            wait();
        }
        this.picked_up = true;
    }

    public synchronized void putDown() {
        this.picked_up = false;
        notifyAll();
    }

}

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        ArrayList<Philosopher> philosopher_list = new ArrayList<Philosopher>();
        ArrayList<Fork> fork_list = new ArrayList<Fork>();

        for (int i= 0; i<5; i++) {
            Fork fork_object = new Fork(i,false);
            fork_list.add(fork_object);
        }

        for (int i=0; i<5; i++) {
            Fork leftFork = fork_list.get(i);
            Fork rightFork = null;
            try {
                rightFork = fork_list.get(i-1);
            }
            catch (Exception e) {
                rightFork = fork_list.get(fork_list.size()-1);
            }
            finally {
                Philosopher philosopher_object = new Philosopher(i,leftFork,rightFork);
                philosopher_list.add(philosopher_object);
            }
        }

        for (int i=0; i<philosopher_list.size(); i++) {
            philosopher_list.get(i).start();
        }
    }

}
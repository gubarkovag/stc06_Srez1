package stc06.gubarkov;

import java.util.*;

public class GenerateRandomNumber implements Runnable {
    private boolean isToBeStopped;
    private int secondsCount;
    private SortedSet<Integer> uniqueNumbers = Collections.synchronizedSortedSet(new TreeSet<>());
    private Random r = new Random();

    void setToBeStopped(boolean toBeStopped) {
        isToBeStopped = toBeStopped;
    }

    boolean isToBeStopped() {
        return isToBeStopped;
    }

    int getSecondsCount() {
        return secondsCount;
    }

    SortedSet<Integer> getUniqueNumbers() {
        return uniqueNumbers;
    }

    @Override
    public void run() {
        try {
            while (!isToBeStopped) {
                Thread.sleep(1000);
                secondsCount++;
                uniqueNumbers.add(r.nextInt(100));
                synchronized(this) {
                    notifyAll();
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

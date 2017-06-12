package stc06.gubarkov;

public class CountUniqueNumbers implements Runnable {
    private final GenerateRandomNumber generateRandomNumber;
    private int uniqueNumbersCount;
    private int neededSecsNumber;

    CountUniqueNumbers(GenerateRandomNumber generateRandomNumber, int uniqueNumbersCount, int neededSecsNumber) {
        this.generateRandomNumber = generateRandomNumber;
        this.uniqueNumbersCount = uniqueNumbersCount;
        this.neededSecsNumber = neededSecsNumber;
    }

    @Override
    public void run() {
        try {
            while (!generateRandomNumber.isToBeStopped()) {
                synchronized(generateRandomNumber) {
                    generateRandomNumber.wait();
                    if (generateRandomNumber.getSecondsCount() % neededSecsNumber == 0) {
                        int curSize = generateRandomNumber.getUniqueNumbers().size();
                        if (curSize < uniqueNumbersCount) {
                            System.out.println("Текущее кол-во уникальных чисел: " + curSize);
                        } else {
                            System.out.println("Итоговое кол-во уникальных чисел: " + curSize);
                            generateRandomNumber.setToBeStopped(true);
                        }
                    }
                }
            }
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
    }
}

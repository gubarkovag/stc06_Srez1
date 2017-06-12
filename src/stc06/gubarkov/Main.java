package stc06.gubarkov;

public class Main {

    public static void main(String[] args) {
	    GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
	    Thread th1 = new Thread(generateRandomNumber);
	    CountUniqueNumbers countUniqueNumbers = new CountUniqueNumbers(generateRandomNumber,100, 5);
	    Thread th2 = new Thread(countUniqueNumbers);
	    th2.start();
	    th1.start();
    }
}

package EXE2;

public class RandomizedNumberDemoT2 {
    public static void main(String args[]) throws InterruptedException {
        NumGenThreadT2T3 n1 = new NumGenThreadT2T3 ("A");

        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);
        Thread t3 = new Thread(n1);
        Thread t4 = new Thread(n1);
        Thread t5 = new Thread(n1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        Calculator sum = new Calculator();

        sum.calcSum(n1.getNumGenerated());

    }
}

package EXE2;

public class RandomizedNumberDemoT1 {
    public static void main(String args[]) throws InterruptedException {

        NumGenThreadT1 n1 = new NumGenThreadT1 ("A");
        NumGenThreadT1 n2 = new NumGenThreadT1 ("B");
        NumGenThreadT1 n3 = new NumGenThreadT1 ("C");
        NumGenThreadT1 n4 = new NumGenThreadT1 ("D");
        NumGenThreadT1 n5 = new NumGenThreadT1 ("E");

        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n2);
        Thread t3 = new Thread(n3);
        Thread t4 = new Thread(n4);
        Thread t5 = new Thread(n5);

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

        int sum = n1.getNumGen() + n2.getNumGen()
                + n3.getNumGen() + n4.getNumGen() + n5.getNumGen();
        System.out.println("Sum is: " + sum);

    }
}

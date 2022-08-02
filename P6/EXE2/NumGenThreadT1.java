package EXE2;

import java.util.Random;
import java.lang.Runnable;

public class NumGenThreadT1 implements Runnable {

    private int numGen;
    String name;

    public NumGenThreadT1(String name){
        this.name = name;
    }

    public int getNumGen() {
        return numGen;
    }

    public synchronized int generate(){
        Random gen = new Random();
        int numGen = gen.nextInt(100);

        while (true) {
            if (numGen == 0) {
                numGen = gen.nextInt(100);
            } else {
                break;
            }
        }
        return numGen;
    }

    @Override
    public synchronized void run() {
        numGen = generate();

        System.out.println(name + " " + numGen);

    }
}

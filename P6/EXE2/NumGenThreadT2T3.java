package EXE2;

import java.lang.Runnable;
import java.util.Random;

public class NumGenThreadT2T3 implements Runnable {

    private String name;
    private int pos = 0;
    private int numGenerated[];

    public int[] getNumGenerated() {
        return numGenerated;
    }

    public int getPos() {
        return pos;
    }

    public NumGenThreadT2T3(String name){
        numGenerated = new int[5];
        this.name = name;
    }

    public void incrementPos() throws InterruptedException {
        Thread.sleep(10);
        pos++;
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

        numGenerated[pos] = generate();

        System.out.println(name + " " + numGenerated[pos] +  " " + pos);

        try {
            Thread.sleep(10);
            incrementPos();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}





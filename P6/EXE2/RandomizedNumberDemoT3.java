package EXE2;


public class RandomizedNumberDemoT3{

    public static void main (String args[]){

        ThreadPool p = new ThreadPool(5);
        Calculator c = new Calculator();
        NumGenThreadT2T3 n1 = new NumGenThreadT2T3 ("A");

        p.getPool().execute(n1);
        p.getPool().execute(n1);
        p.getPool().execute(n1);
        p.getPool().execute(n1);
        p.getPool().execute(n1);

        p.shutDown();

        p.awaitTermination();

        c.calcSum(n1.getNumGenerated());

    }
}

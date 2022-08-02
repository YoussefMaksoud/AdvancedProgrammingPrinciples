package EXE2;

public class Calculator{

    public void calcSum(int arr[]) {

        int sum = 0;

            for (int i = 0; i < 5; i++) {
                sum += arr[i];
            }

        System.out.println("Sum is: " + sum);
    }
}

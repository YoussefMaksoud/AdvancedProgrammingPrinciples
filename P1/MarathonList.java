import java.util.ArrayList;
import java.util.Scanner;

class MarathonList{

    public int findFastestRunner(ArrayList<String> times){
        int fastIndex = 0;
        Integer fast = Integer.parseInt(times.get(0));
         for(int i = 1; i < times.size(); i++){
             if(Integer.parseInt(times.get(i)) < fast){
                 fast = Integer.parseInt(times.get(i));
                 fastIndex = i;
             }
         }
         return fastIndex;
    }
    public void printResults(ArrayList<String> names, ArrayList<String> times, int index){
        System.out.println("The fastest runner was: " + " " + names.get(index));
        System.out.println("The fastest time was: " + " " + times.get(index));
    }

    public static void main(String[] args) {
        MarathonList list = new MarathonList();
        ArrayList<String> partic = new ArrayList<String>();
        ArrayList<String> times = new ArrayList<String>();

        // Read user input
        String sin;
        Scanner scan = new Scanner(System.in);
        
        while (true)
        {
            System.out.println("Please enter the name of the participant");
            sin = scan.nextLine();
            partic.add(sin);
            if(sin.toUpperCase().equals("QUIT"))
                break;
        
            // Add the name to your ArrayList
            System.out.println("Please enter the running time of the participant");
            sin = scan.nextLine();
            times.add(sin);
            // Add the running time to your array list
        }
        int fastest = list.findFastestRunner(times);
        list.printResults(partic, times, fastest);
        
        // Call the function findFastestRunner and pass the running times array list to it
        // Print the name of the fastestrunner to the console
        }
}
import java.util.Scanner;

class MultiDimArr{

    private char [][] multiArr;

    MultiDimArr(){
       this.multiArr = new char[3][60];
    }
    // class default constructor

    public void reverse(String str){
        
        for(int i = 0, j = (str.length() - 1); i < str.length(); i++){
            this.multiArr[0][i] = str.charAt(j);
            j--;
        }
        System.out.println(this.multiArr[0]);
    }
    //reverses all letters of the first input sentence

    public void wordReverse(String str){
        int count = 0;
        String temp[] = str.split(" ");
       
        for (int i = temp.length - 1; i >= 0; i--){
            
            for(int k = 0; k < temp[i].length(); k++){
                this.multiArr[1][count] = temp[i].charAt(k);
                count ++;
            }
            
            this.multiArr[1][count] = ' ';
            count++;
        }
        System.out.println(this.multiArr[1]);
    }
    // reverses the order of the words of the second input sentence

    public void capFifth(String str){
        for(int i = 0; i < str.length(); i++){
            if((i+1)%5 == 0)
                this.multiArr[2][i] = Character.toUpperCase(str.charAt(i));
            else
                this.multiArr[2][i] = str.charAt(i);
        }
        System.out.println(this.multiArr[2]);
    }
    //makes every fifth character of the sentence a capital
    
    public void printPrompt(int n){
        System.out.println("Please enter sentence" + " " + (n+1) + ':');
    }

    public static void main(String[] args){

        MultiDimArr arr = new MultiDimArr();

        String [] sents = new String[3];

        Scanner scan = new Scanner(System.in);
        
        for(int i = 0; i < 3; i++){
            arr.printPrompt(i);
            sents[i] = scan.nextLine(); 
        }

        arr.reverse(sents[0]);
        arr.wordReverse(sents[1]);
        arr.capFifth(sents[2]);
    }    
}

        

    

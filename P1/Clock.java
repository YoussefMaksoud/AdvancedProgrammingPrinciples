class Clock{

    private int days;
    private int hours;
    private int minutes;
    private int seconds;

    Clock(){
        this(0, 0, 0, 0);
    }

    Clock(int d, int h, int m, int s){
        this.days = d;
        this.hours = h;
        this.minutes = m;
        this.seconds = s;
    }

    public int getDay(){
        return this.days;
    }
    public int getHour(){
        return this.hours;
    }
    public int getMinute(){
        return this.minutes;
    }
    public int getSecond(){
        return this.seconds;
    }
    public void setDay(int d){
        this.days = d;
    }
    public void setHour(int h){
        if(h > 23 || h < 0){
            System.out.println("invalid input for hours");
        }
        else
            this.hours = h;
    }
    public void setMinute(int m){
        if(m > 59 || m < 0){
            System.out.println("invalid input for minutes");
        }
        else
            this.minutes = m;
    }
    public void setSecond(int s){
        if(s > 59 || s < 0){
            System.out.println("invalid input for seconds");
        }
        else
            this.seconds = s;
    }
    public void increment(int s){
        this.seconds = (this.seconds + s);
        if(this.seconds >= 60){
            this.minutes += this.seconds/60;
            this.seconds = this.seconds%60;
        }
        if(this.minutes >= 60){
            this.hours += this.minutes/60;
            this.minutes = this.minutes%60;
        }
        if(this.hours >= 24){
            this.days += this.hours/24;;
            this.hours = this.hours%24;
        }
        
    }
    public int calculateTotalSeconds(){
        int total = (this.seconds + (this.minutes*60) + (this.hours*3600) + (this.days*86400));
        return total;
    }

    public static void main(String args[]){
        
        System.out.println(" ");
        System.out.println("Tests for t1: ");
        
        // Create elapsed time with the default values of zeros for day, hour,
        // minute and second.
        Clock t1 = new Clock(); // Default constructor
        // sets hour to 23
        t1.setHour(23);
        // sets day to 1
        t1.setDay(1);
        // sets minute to 59
        t1.setMinute(59);
        // sets seconds to 16
        t1.setSecond(16);
        // prints: 1:23:59:16
        System.out.println(t1.getDay() + ":" + t1.getHour() +":" + t1.getMinute() + ":" + t1.getSecond());
        // increments time t1 by 44 seconds:
        t1.increment(44);
        // prints: 2:0:0:0
        System.out.println(t1.getDay() + ":" + t1.getHour() +":" +t1.getMinute() + ":" + t1.getSecond());
        // prints the total elapsed time in seconds: 172,800
        System.out.printf("The elapsed time in seconds is: %d \n", t1.calculateTotalSeconds());

        System.out.println(" ");
        System.out.println("Tests for t2: ");

        Clock t2 = new Clock(3, 1, 4, 5);
        //prints 3:01:04:05
        System.out.println(t2.getDay() + ":" + t2.getHour() +":" +t2.getMinute() + ":" + t2.getSecond());
        // sets hour to 15
        t2.setHour(15);
        // sets day to 16
        t2.setDay(16);
        // sets minute to 34
        t2.setMinute(34);
        // sets seconds to 59
        t2.setSecond(59);
        // prints: 16:15:34:59
        System.out.println(t2.getDay() + ":" + t2.getHour() +":" + t2.getMinute() + ":" + t2.getSecond());
        // increments time t1 by 123 seconds:
        t2.increment(123);
        // prints: 16:15:37:02
        System.out.println(t2.getDay() + ":" + t2.getHour() +":" +t2.getMinute() + ":" + t2.getSecond());
        // prints the total elapsed time in seconds: 
        System.out.printf("The elapsed time in seconds is: %d \n", t2.calculateTotalSeconds());
    }
}
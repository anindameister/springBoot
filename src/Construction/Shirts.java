package Construction;

public class Shirts {

    public String color;
    public char size;


    public static void putOn(){
        System.out.print("Shirt is on");
    }
    public static void takeOff(){
        System.out.println("Shirt is off");
    }

    Shirts(){
        System.out.println("constructor is a method which creates an object.");
    }



    Shirts(String NewColor, char NewSize){
        color=NewColor;
        size=NewSize;
    }
}

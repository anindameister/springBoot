package Construction;

public class Main {

    public static void main(String[] args){

        Shirts s=new Shirts("black",'X');

        Shirts t=new Shirts();

        t.takeOff();

        s.putOn();
        System.out.println("*********");
        System.out.println(s.color);
        System.out.println(s.size);
        System.out.println(t.color);








    }
}

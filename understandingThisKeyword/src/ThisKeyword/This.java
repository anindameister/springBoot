package ThisKeyword;

public class This {

    int a;
    int b;

    public static void setData(int a, int b){
        a=a+1;
        b=b+2;

    }

    public static void main(String[]args){

        setData(4,3);

        //dont forget that we use the class and not the method directly from a class without mentioning the class. We can't create a human object without specifying that it belows to mamals class
        This c=new This();
        c.setData(4,3);
        System.out.println(c.a);
        System.out.println(c.b);


    }
}

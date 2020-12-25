package ThisKeyword;

public class This {

    int a;
    int b;
    public static void setData(int a, int b){

        a=a;
        b=b;
        System.out.println(a);
        System.out.println(b);

    }

    public static void main(String[]args){

        setData(1,2);

        This object=new This();
        System.out.println(object.a);
        System.out.println(object.b);
        object.a;
        object.b;

    }
}

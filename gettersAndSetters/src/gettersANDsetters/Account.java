package gettersANDsetters;

public class Account {

    String name;
    int age;
    Account(){

    }

    public static void main(String[]args){

        sayHBD(28,"Arunava");

        Account forAnuja=new Account();
        forAnuja.sayHBD(31,"Anuja");
        forAnuja.getDetails(31,"Anuja");


        ageDifferenceFromMe(33,"Archita");



    }

    public static void sayHBD(int age, String name){
        System.out.println("I wish you many happy returns on your "+age+"nd Birthday. Happy Birthday "+name+". May God fulfill all your wishes in life");
    }

    public static void getDetails(int age,String name){
        System.out.println("The person named "+name+" was born on "+(2020-age));
    }

    public static void ageDifferenceFromMe(int age,String name){
        int yearOfBirth=2020-age;
        System.out.println("The person named "+name+" was born on "+yearOfBirth+" which gives this person a difference of "+(1988-yearOfBirth));
    }


}

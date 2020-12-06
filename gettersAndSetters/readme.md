# getters and setters
- http://youtube.com/watch?v=6wVmqY-CrGM&t=6m22s

- getters and setters let you get and set variables inside of a class
- a class is a blueprint of an object
- an object has (attributes/properties) and methods

- The below way is about calling a function in the main method.
```
package gettersANDsetters;

public class gettersNsetters {

    String name;
    int age;

    public static void main(String[]args){

        sayHBD(28,"Arunava");

    }

    public static void sayHBD(int age, String name){
        System.out.println("I wish you many happy returns on your "+age+"nd Birthday. Happy Birthday "+name+". May God fulfill all your wishes in life");
    }


}
```
- let me attempt to do the same thing by using class, invisibleORvisible Constructor and object.
```
package gettersANDsetters;

public class gettersNsetters {

    String name;
    int age;
    gettersNsetters(){

    }

    public static void main(String[]args){

        sayHBD(28,"Arunava");

        gettersNsetters forAnuja=new gettersNsetters();
        forAnuja.sayHBD(31,"Anuja");



    }

    public static void sayHBD(int age, String name){
        System.out.println("I wish you many happy returns on your "+age+"nd Birthday. Happy Birthday "+name+". May God fulfill all your wishes in life");
    }


}
```
- the above works without the constructor, but I just decided to put it there.
- just created another method before proceeding to getters&setters
```
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



    }

    public static void sayHBD(int age, String name){
        System.out.println("I wish you many happy returns on your "+age+"nd Birthday. Happy Birthday "+name+". May God fulfill all your wishes in life");
    }

    public static void getDetails(int age,String name){
        System.out.println("The person named "+name+" was born on "+(2020-age));
    }


}
```
## static keyword
- Alex Lee says that the static keyword is not required to be mentioned in the methods created when you know that this method would be called within the same class. Got to check on this.
- let's check out the below code
```
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
```
- so the above code just works, without creating an object. So why do we really need to create an object is the existence of object is not far away from that class. So objects come into existence when someone needs to have a bodily form and that is mandatory outside the class. Inside the class, it is not mandatory. In Python, based on my current knowledge, I created functions and not objects as of yet, because I am doing it within one python program and not going outside a python program to connect it to some other python program with the help of an object.


## Understanding **This** Keyword

```
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

        setData(4,3);


    }
}
```
- the output is
```
4
3
```
- so what we did in the above program is: 
1. initialised the variables a,b; though it seems to me now that without initialising this would have also given the same result. Let me try that. Yes, it does work without initialising.
2. Moving on, it just seems that we created a function named setData which accepts two integers. Once, it receives the two parameters, it just assigns it to two integers named a,b which are already initialised and then prints it.
3. To note, this section is about **this** keyword which has not been used.

- we continued without initially declaring the two integers and viola! it prints again.

```
package ThisKeyword;

public class This {

//    int a;
//    int b;

    public static void setData(int a, int b){
        a=a;
        b=b;
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[]args){

        setData(4,3);

        //dont forget that we use the class and not the method directly from a class without mentioning the class. We can't create a human object without specifying that it belows to mamals class
        This c=new This();
        c.setData(4,3);


    }
}
```
- the output
```
4
3
4
3
```
- Now, we uncommented the initailised variable and we get the exact result as above, below is the code and above is the result.
```
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

        setData(4,3);

        //dont forget that we use the class and not the method directly from a class without mentioning the class. We can't create a human object without specifying that it belows to mamals class
        This c=new This();
        c.setData(4,3);


    }
}
```
- in the below, we made a couple of changes
1. we removed the System.out.println from the setData method and used the same within the main method.
2. So continuing, the above point, we made System.out.println available within the main method.
- now, an object has methods and attributes/properties, say whatever for attributes. These attributes are basically variables. So human object has attributes like age,height, weight and methods like walking,talking
- so an object that has been created can use a method of the class. Eg:Human object can perform(call) the methods like talking,producingMilk,notLayingEggs of it's mamal class. Similarly Human object also has age,height,weight,pinnah(ears). So human object should be able to use these attributes. Some human objects cannot, so computerTechnology helps them and that way every human is supposed to have access to the attributes of mamal class.
- so now, we would attempt to call attribute of the object created,c.
```
package ThisKeyword;

public class This {

    int a;
    int b;

    public static void setData(int a, int b){
        a=a;
        b=b;

    }

    public static void main(String[]args){

        setData(4,3);

        //dont forget that we use the class and not the method directly from a class without mentioning the class. We can't create a human object without specifying that it belows to mamals class
        This c=new This();
        c.setData(4,3);
        System.out.println(c.a);


    }
}
```
- the output
```
0
```
- so the output basically doesn't give anything. The reason is that the program is confused in regards to bringing in 4 or .... to be checked out in the video.
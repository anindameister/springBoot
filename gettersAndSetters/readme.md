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

#### removed the previous and in order to check the old stuff go for 2:09pm on 25th december and get the history from github

- from the below code, execution on 25th dec,2020; I just learnt that I can create an object and call it's attributes but not get that executed. It gives an error. Got to have a consolidated idea on the fact that, **if we have call an attribute of an object then if that can be done directly like the way we call method or not**

![error2callAttributeAfterObjectCreation](https://github.com/anindameister/springBoot/blob/main/snaps/1.PNG)

- In the below program, we'll see that, an attribute of an object when called just gives the initial value, because at this point, java is confused if it needs to send the initial values of the attribute or something else.

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

        setData(1,2);

        This object=new This();
        System.out.println(object.a);
        System.out.println(object.b);
      

    }
}
```
- output
```
1
2
0
0
```
- so what is happening is that the play button in intellij instialises the main method, which initially calls the function **setData** and assigns the parameters to 1 and 2 and we have 1,2 in the output. Again, when we create an object **object** of class **This**, then it takes the attributes a,b and doesn't assign the value 1,2; because no values have actually been assigned to the attributes actually. Confusing java, as said by Alex Lee, is not being taken into account as of yet because using **setData** as a functions gives 1,2 and when using **setData** as method it doesn't give the values 1,2 and instead gives 0,0 because values have never been truly assigned to class **This**'s attributes a,b.

- let's check the below code and it's output

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

        setData(1,2);
        This object=new This();
        object.setData(3,4);
        System.out.println(object.a);
        System.out.println(object.b);


    }
}
```
- output
```
1
2
3
4
0
0
```
- in this way, **setData(1,2)**, setData has been used as function and passed in two parameters, like a regular function of any language is used.
**setData(3,4)**, this way we are calling the method setData and assigning values as 3,4 and getting that printed out. Thus calling method is exactly been used as calling function. **System.out.println(object.a);** , calling the attribute is not giving result because java is confused if it needs to output the initial attribute value or acquired attribute value. Eg: Baby default "nature" attribute is "simple". Life, calls the Baby and assigns it's "nature" attribute to "complicated".

- introuducing "this" keyword in the code

![introuducing "this" keyword in the code](https://github.com/anindameister/springBoot/blob/main/snaps/2.PNG)

- **static** keyword and **this** keyword cannot be used together and hence removing the static keyword and found out the below.

![setData cannot be used as function anymore](https://github.com/anindameister/springBoot/blob/main/snaps/3.PNG)

- setData cannot be used as function anymore. Recollect Python. We cannot use "this" keyword in Python's function. This "this" keyword comes in oops. Thus, we will remove the function calling now.

- below is snap of the clean and correct code.

![correct usage of "this" keyword](https://github.com/anindameister/springBoot/blob/main/snaps/4.PNG)

- **so "this" keyword is used to change the initial parameter value of a class to a desired value.**

#### wordkAround for not using **this**

```
package ThisKeyword;

public class This {

    int c;
    int d;
    public void setData(int a, int b){

        c=a;
        d=b;
        System.out.println(a);
        System.out.println(b);

    }

    public static void main(String[]args){


        This object=new This();
        object.setData(3,4);
        System.out.println(object.c);
        System.out.println(object.d);

    }
}
```

- output
```
3
4
3
4
```
- Again a mammal class has attributes like legs, not tentacles etc. So this mammal class has method like movingWay which uses the legs parameters. Or if we are trying to use "tentacles" parameter then within the method, we have to say that the initial class' attribute legs has been now changed to tentacles. Later, we create an object of this class and call the method and pass it attribute values

```
package ThisKeyword;

public class Mammal {

    int legs;

    public void usingMovingPart(int tentacles){

        legs=tentacles;
        System.out.println(legs);

    }

    public static void main(String[]args){


        Mammal human=new Mammal();
        human.usingMovingPart(9);


    }
}
```
- output
```
9
```
- not using **this** or **workAround**

```
package ThisKeyword;

public class thisMammal {

    int legs;

    public void usingMovingPart(int legs){

        legs=legs;
        System.out.println(legs);

    }

    public static void main(String[]args){


        thisMammal human=new thisMammal();
        human.usingMovingPart(9);
        System.out.println(human.legs);


    }
}
```

- output

```
9
0
```
- **we get the 9 by setting the parameters used by the method. We get a 0, because with "human.legs" within "System.out.println(human.legs)" we are trying to use the original attribute of the class which is 0. Thus an object can change the attribute of the class to a different value, as seen in the below program.**

```
package ThisKeyword;

public class thisMammal {

    int legs;

    public void usingMovingPart(int legs){

        this.legs=legs;
        System.out.println(legs);

    }

    public static void main(String[]args){


        thisMammal human=new thisMammal();
        human.usingMovingPart(9);
        System.out.println(human.legs);


    }
}

```
- output
```
9
9
```
- in the above, we changed nothing but just introduced the term **this**

# toString()

- let's look at this
- creating a student class within a package named "LearningTogether"

```
package LearningTogether;

public class Student {

    String UniversityRollNumber;
    String name;
}
```
- creating another class called CodingIsFun within the same package "LearningTogether" and also involving a main method within this class. Calling the student class' attributes and assigning values to it, by creating an object named s1. Later, attempting to bring everything of the object s1.

```
package LearningTogether;

public class CodingIsFun {

    public static void main(String[]args){
        Student s1=new Student();
        s1.UniversityRollNumber="1GS07EE001";
        s1.name="Aamira Farzeen";

        System.out.println(s1);
    }
}
```
- output
```
LearningTogether.Student@5f184fc6
```
- so in the above output, we see that, we get the memory location of the object. But we dont want that. We dont want to see a human object's location. We want to see, what are the attributes of this human object. Let's attempt to see that.
- So, there's no one external who could just see the attributes of this human object, unless the human object gets the mammal class' **toString** method. So, once that's declared, we see the attributes of this human object in our class.

```
package LearningTogether;

public class Student {

    String UniversityRollNumber;
    String name;

    public String toString(){
        return UniversityRollNumber + name;
    }
}
```
- output from the main class
```
1GS07EE001Aamira Farzeen
```
- the concept ends here.
- Let's try to use the complicated Alex Lee way, and it is important to get into the complication because we just learnt the user of **this** method and also read about constructors.

#### Alex Lee

- we create a constructor and pass in two parameters. Within this constructor, we use the **this** keyword to say that whatever parameters are there is equal to the original class' parameters.
- Next, we keep the **toString** method like before
```
package LearningTogether;

public class Student {

    String UniversityRollNumber;
    String name;

    Student(String UniversityRollNumber, String name){
        this.UniversityRollNumber=UniversityRollNumber;
        this.name=name;

    }

    public String toString(){
        return UniversityRollNumber + name;
    }
}
```
- main class, the name of the class is so, because it contains the main method.

```
package LearningTogether;

public class CodingIsFun {

    public static void main(String[]args){
        Student s2=new Student("1GS07EE002","Amith Kumar");

        System.out.println(s2);
    }
}
```
- output
```
1GS07EE002Amith Kumar
```

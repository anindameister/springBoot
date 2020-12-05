# constructors - https://www.youtube.com/watch?v=G1Iln3PSrUg&t=90s

## scenario 1

- constructors constructs object.
```
Shirts t=new Shirts();
```
- t is the object which is being created by the constructor new Shirts.. We can say that new is the constructor of type Shirts. Shirts is the class. t is the object of that class. and this object being created and associated to the class named Shirts is done by the constructor
- now, since Shirts, the class is available in the same package as the otherClass where we have t: the object of class, Constructor; hence we dont have to import anything.
- if Shirts class would have been available elsewhere then the package containing the class Shirts would have been required to be imported.
- for having the above constructor, below is an optional constructor declaration within the Shirt Class.
```
Shirts(){
        System.out.println("constructor is a method which creates an object.");
    }
```
- the above constructor was made to print something, just to say that I exist, though I try to be there all the time even am invisible. 
- So, constructors are basically the God, who is always there, no matter if you see it or not. Sometimes, due to negligence God messes up the entire program. So never mess with God.

## scenario 2

- so, a class has properties and methods which means it has certain properties like age,dimention and also some methods like a class can stayStill,move,activatedByExternalForce
- constructors creates objects and gives the properties and methods to the object that it creates.
- in the scenario 1, we created a class and then created a object and gave methods of the class to this object with the help of constructor.
- in scenario 2, we'll create a constructor which would give the properties of the Shirts class to a object that has been created in the second class. 
- The below is the code

```
    public String color;
    public char size;


    Shirts(String NewColor, char NewSize){
        color=NewColor;
        size=NewSize;
    }
```
- in the next class, we have

```
Shirts s=new Shirts("black",'X');

System.out.println(s.color);
System.out.println(s.size);
```
- so in order to print the properties of the Shirts class, we dont have to use "()"

### scenario 3

```
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

    }
}
```

- the below is the Shirts Class

```
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
```

- since we have used Shirts constructor twice, once for the properties and other time for the methods. 
- Constructors need not be mentioned for methods.
- s,t are the two objects that has been created by the constructor from class Shirts, so both have the "putOn" and "takeOff" methods.
- BUT, both doesn't have the same properties. object named s has color and size properties. But t doesn't have that. We will look into the output and then the main class and then the end.

```
"G:\Program Files\Java\jdk-14.0.1\bin\java.exe" "-javaagent:G:\Program Files\JetBrains\IntelliJ IDEA 2020.2.2\lib\idea_rt.jar=51913:G:\Program Files\JetBrains\IntelliJ IDEA 2020.2.2\bin" -Dfile.encoding=UTF-8 -classpath H:\WebDevelopmentClass\ThatReadmeFIle\out\production\ConstructorsConstructsObjects Construction.Main
constructor is a method which creates an object.
Shirt is off
Shirt is on*********
black
X
null
```

- the main class program

```
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
```




# Interfaces in Java

- Like a class, an interface can have methods and variables, but the methods declared in an interface are by **default abstract** (only method signature, no body).  

## Access modifiers

![Access modifiers](https://github.com/anindameister/springBoot/blob/main/snaps/18.PNG)

## Non-Access Modifiers

![Non-Access Modifiers](https://github.com/anindameister/springBoot/blob/main/snaps/19.PNG)

- **For classes, you can use either final or abstract:**
- **final**:- The class cannot be inherited by other classes 
- **abstract**:- The class cannot be used to create objects (To access an abstract class, it must be inherited from another class. You will learn more about inheritance and abstraction in the Inheritance and Abstraction chapters)
- So basically an abstract class doesn't let objects to be created in other class by the below
```
anAbstractClass object=new anAbstractClass()
```
- in order to create an object of an abstract class, we have to do the below,
```
public class toCreateAbstractClassObject extends anAbstractClass(){

}
```
- **abstract attributes and methods**- Can only be used in an abstract class, and can only be used on methods. The method does not have a body, for example abstract void run();. The body is provided by the subclass (inherited from). You will learn more about inheritance and abstraction in the Inheritance and Abstraction chapters

- **Why do we use interface ? It is used to achieve total abstraction. Since java does not support multiple inheritance in case of class, but by using interface it can achieve multiple inheritance from abstract classes.**

- **Conclusion 7:57pm IST on 27Dec2020** Java class cannot inherit multiple class. So we use interface class to inherit multiple classes. Interface class can only inherit abstract classes. **Note:- it can also be said that Java class can inherit from abstract classes but not from multiple abstract classes**


# What’s Spring ?

- Abstraction of the complexity
- Dealing with ideas rather than events.

- Provides utility classes
- Spring provides useful classes

- Helps to focus on the business code and not on the technical plumbing
- Plumbing is a term used to describe the technology and connections between systems in a cloud computing model.
- The term is an analogy to the plumbing of water systems. Just as water is carried from reservoirs to homes and usage centers, 
- the data from data centers is delivered to the end stations via its plumbing.
- So, Spring gives the opportunity to focus on business logic and not on the technical plumbing. So, let's say one class can use the method of another class with simple annotations, helping us not to worry about how that particular annotation is working.

- Spring is an entire ecosystem.
- The simplest definition of an ecosystem is that it is a community or group of living organisms that live in and interact with each other in a specific environment.
- So let's say that Spring let's the classes live in the framework and interacct with each other with easy.

- Spring Core provides a framework to simplify project technical aspects
- The above point is for me to accept, because I have struggled to get the entire scenario in my head.

## Generate
- To start a new project, you can (you should) use the official generator https://start.spring.io/

![Generate the entirity of the files](https://github.com/anindameister/WebDevelopmentClass/blob/main/snaps/2.PNG)

- the details of the theory can be found in here https://dev-mind.fr/training/spring/spring-intro.html . Just the key points are mentioned here

- So, basically it all starts from downloading those files from the website, unzip it in a folder. Consider those set of files as your project. Yeah! The project name can be given in the site itself and we can move on.
- Moving on to do the gradle settings.
- Gradle is basically our build tool. The way we do pip install someLibrary in python and then import thatLibrary in the python project, exactly the same work is handled by gradle and maven. Maven handles it in .xml file and gradle in build.gradle file

- settings.gradle

![settings.gradle](https://github.com/anindameister/WebDevelopmentClass/blob/main/snaps/3.PNG)

- File : > build.gradle contains informations used by Gradle to build app

![settings.gradle](https://github.com/anindameister/WebDevelopmentClass/blob/main/snaps/4.PNG)

- The above Adds the Spring Boot plugin to be able to manage your app with Gradle.

- A virtual environment is a Python environment such that the Python interpreter, libraries and scripts installed into it are isolated from those installed in other virtual environments,
-  and (by default) any libraries installed in a “system” Python, i.e., one which is installed as part of your operating system.
- Similarly, we have Spring dependency management plugin to do the exact same thing 
```
id 'io.spring.dependency-management' version '1.0.10.RELEASE
```
- the above Adds Spring dependency management plugin to use the compatible dependencies with the Spring Boot version

- Now check the below,
```
id 'java' 
```
- Adds the Java plugin to help Gradle to manage our app lifecyle
- Probably this is necessary because with the growing popularity of Kotlin, this is can also be used. Let's check the internet. Apparently, it seems that Kotlin can be used for springBoot:

```
group = 'com.emse.spring'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '14'
```
- the above shows Project id and versions

```
repositories {
	mavenCentral()
}
```
- The above would Tell Gradle where it will find all libraries
- We would later find out that MavenCentral is not the only place, others are there as well.

```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}
```
- spring-boot-starter-test : Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest and Mockito
- here we are just choosing JUNit
- we have learnt before that in a good application, all files are tested and verified by unit tests
- spring-boot-devtools : devtools is a set of tools that can make the application development experience a little more pleasant (live reload or automatic restart). 
- Okay, let's hope that spring-boot-devtools gives what it promises and we'd get an experience similar to LiveServerByRitwicKDey for expressJS
- spring-boot-starter-web : Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container
- about the above statement, I understand that it comes with an integrated TOMCAT and since this TOMCAT is intgrated so we'll not be able to do activities like LiveServerByRitwicKDey for expressJS.
- Now, again, the above question arrises that what is the use of developmentOnly 'org.springframework.boot:spring-boot-devtools' then.
- Moving on spring-boot-starter-web : Starter for building web, including RESTful. This is understandable.
- what is the meaning of applications using Spring MVC is my question. Let's find out. Came across this link, which seems to be useful https://www.javatpoint.com/spring-mvc-tutorial
- question now is that what is the difference between SpringMVC and SpringBoot. From the above link, it seems that SpringMVC and SpringBoot is absolutely same(based on my current knowledge status)
- Basically, I have got some idea by exploring the web, but more ideas would follow later.

- Now, for right now, the below class is my entry point to spring. So the document states that "This is your app entry point". So based on my understanding, we are making a spring boot app which can be accessed by this class.
- In order to mark it as the entry point to our SpringBootApp, we choose to annotate this by using @SpringBootApplication. So, here's the class as below

```
package com.emse.spring.faircorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyWebApplication{

	public static void main(String[]args){
		SpringApplication.run(MyWebApplication.class, args);
	}

}
```

- Now, we'd attempt to create a test file of our FaircorpApplication. So we would create the test file for our entryClass which is named here MyWebApplication. So this is the className that I have chosen as the entry point to our Faircorp application. We would now try to test this entry point class.

- A problem came up. This problem came up maybe because I tried to initiate the work from the basics again.
- The problem was that I was not able to create a class with the create class option from the package.
- https://stackoverflow.com/questions/38254612/intelli-j-cannot-create-class-file . The last comment from the link was an easy read. I tried to explore something and this idea popped up.
- from the top right corner, I chose the ProjectStructure and got the box as below

![projectStructure](https://github.com/anindameister/WebDevelopmentClass/blob/main/snaps/5.PNG)

- from the dialogue box, I chose the option modules, went to sources option and made the src of my project as the source folder. I believe the problem is fixed now. I will try to check now.
- I dont know, if the problem is resolved or not. Let me try to check more.
- since, I couldn't understand what I was doing, so decided to create a new project. So this time, I didn't go to the website but instead decided to do it from the intellij. Giving this some time to rebuild. Since the entire idea of this project is to copy and paste, so let's hope that this is not gonna be a problem.

- so, as of right now, the below is my build.gradle situation. To be noted, the sourceCompatibility was 11, I made it 14 and did a gradlew build in the terminal. let's find out what's the problem in store for me, next.

```
plugins {
    id 'org.springframework.boot' version '2.4.0'
    id 'io.spring.dependency-management' version '1.0.10.RELEASE'
    id 'java'
}

group = 'com.emse.spring'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '14'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

test {
    useJUnitPlatform()
}
```

- at-least right now, I have the right project structure with the right package name which has been separated. It also gives me the option to create class files. This particular thing needs to be checked after the application is closed. It would be checked later, with the sole purpose of making it a little more complicated later.
- anyway, here's the look

![projectStructure](https://github.com/anindameister/WebDevelopmentClass/blob/main/snaps/6.PNG)

- Now, again, we'' try to create that entryPoint for the app named faircorpagain, based on my understanding. Let's find out.
- So, while creating the entryPoint, we imported a couple of class. The first option came in for simply copying the lines like below
```
public class FaircorpApplication {
	public static void main(String[] args) {
		SpringApplication.run(FaircorpApplication.class, args);
	}
}
```
- we imported this library(the term library was just used based on my python concept)
```
import org.springframework.boot.SpringApplication;
```
- again we imported below to use @SpringBootApplication
```
import org.springframework.boot.autoconfigure.SpringBootApplication;
```
- the final code is as below

```
package com.emse.spring.faircorpagain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FaircorpApplication {
    public static void main(String[] args) {
        SpringApplication.run(FaircorpApplication.class, args);
    }

}
```

- again, we tried to create a testing class named FaircorpApplicationTests
- in this we use the annotation @RunWith(SpringRunner.class) to use a Runner to use when we want to test a Spring class..

## predefined classes, not to be changed

- FaircorpApplication.java was already there in the package. So the entryPoint to the springBoot Application comes by default. We dont have to re-create that.
- Similarly FaircorpagainApplicationTests.java comes by default. So I feel that there needs not be any over-analysing with these two.
- Finally, we create the springBoot Application skeleton from either the website or from the intellijPremium, by choosing the right settings. After the project is build, we dont try to change anything. It comes with the right setup of gradle, entryPoint of the app, and the testingClass. Again, the main purpose of SpringBoot is not to concentrate on the plumbing but to take care of the business logic and uptil now we have not even started with the business logic.

### Summarisation of what have been understood by now.
- we create the springBoot Application skeleton from either the website or from the intellijPremium, by choosing the right settings. After the project is build, we dont try to change anything. It comes with the right setup of gradle, entryPoint of the app, and the testingClass. Again, the main purpose of SpringBoot is not to concentrate on the plumbing but to take care of the business logic and uptil now we have not even started with the business logic.
- when we run the testingClass in the beginning, it is supposed to go on smooth because we just tested something that has been given to us by default.
- the below command seems to get stopped at 75 or 80% and if we go to localhost:8080, the webpage is gonna come up which doesnt have anything as of yet.
```
gradlew --continuous bootRun
```
- Again, the core technical reasons could be read on https://dev-mind.fr/training/spring/spring-intro.html . this is the first page of springBoot and I have not yet progressed. MovingOn now.
- Now, based on the documentation, we are instructed to run the startingPoint which comes as default. Once attempted, we get a message saying that TOMCAT is already running on port 8080.
- Now, this TOMCAT is an integrated computer(in my terms) within springBoot which has many ports like a regular computer but it accepts&serves one request at any given point of time; because comeon 1. it's integrated as of right now. I dont know how to run an individual tomcat which is not intgrated within springBoot. So, it is like an integrated graphicsCard which comes with most of the motherboards. This integrated system doesn't have the capability to update the webpage just by getting the code updated. This kind of codeUpdateWebpageUpdate reference is being made based on the LiveServerByRitwickDey for expressJS. Anyway, even if we open a differrent port for this intgrated TOMCAT by saying the below, it wont work. We would just get an error message saying "PORT 8081 is already is use"
```
server.port=8081
```
- the above, if being written in the file named application.properties would give an error saying that port8081 is already in use.
- so basically, we have to free up port8080 of this integrated TOMCAT to proceed.
- Now, according to the document, we did a test and later tried to start the integrated TOMCAT by saying gradlew --continuous bootRun
- now, when we tried to start the entryPoint by just running it we get 8080AlreadyInUse. 
- so that is why ctrl+C was used to stop the TOMCAT and later when we tried to initialise the entryPointClass, no error came up in regards to portInUse.
- Anyway, if we wanna see something on that server then the following HTML is copied in the resources/static/index.html

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
Hello World
</body>
</html>
```
- Again, more theory is available in the document, but we could come back to that theory later. It seems that we can finally move to the next document.

# https://dev-mind.fr/training/spring/spring-ioc.html

## dependency injection
- Dependency injection is a programming technique that makes a class independent of its dependencies.
- That enables you to replace dependencies without changing the class that uses them. 
- It also reduces the risk that you have to change a class just because one of its dependencies changed.
- we got this wonderful explanation from https://stackify.com/dependency-injection/

- When we want to create an object we write for example
```
package com.emse.spring.faircorpagain;

public class NameService {
    public String getName() {
        return "Guillaume";
    }
}

```
- And to use this object elsewhere we have to create a new instance with a new instruction
```
package com.emse.spring.faircorpagain;

public class WelcomeService {
    public void sayHello() {
        NameService nameService = new NameService();
        System.out.println("Hello " + nameService.getName());
    }
}

```
- We have a strong coupling between these classes WelcomeService and NameService. If we want to change NameService we have a good chance of having to update WelcomeService

- Now, let's check the updated NameService class which needs to be checked in the document. So, in here we have given whatever is in the document. It's just that the setter method for the private objects contains parameters. To call this class and the emthod getName, we just used a constructor so that it can be used in other class.

```
package com.emse.spring.faircorpagain;

public class NameService {

    private UserService userService;
    private SettingService settingService;
    private UserRepository userRepository;

    public NameService(UserService userService, SettingService settingService, UserRepository userRepository) {
        this.userService = userService;
        this.settingService = settingService;
        this.userRepository = userRepository;
    }

    public NameService() {

    }


    public String getName() {
        return "Guillaume";
    }
}

```
- "if NameService need to use others objects, you have to update the WelcomeService classc constructor", this is being said in the document
- below is a snap of WelcomeService situation now. 

![WelcomeService situation now](https://github.com/anindameister/WebDevelopmentClass/blob/main/snaps/7.PNG)

- it says that "Expected 3 arguments but found 0" <-- this is the exact error message
- after much investigation, the following is the code for NameService. Just an additional note, we have created classes named UserService,SettingService,UserRepository in order to use them in our current class namely NameService

```
package com.emse.spring.faircorpagain;


public class WelcomeService {
    public void sayHello() {
        NameService nameService = new NameService();
        System.out.println("Hello " + nameService.getName());
    }
}
```

## Inversion of Control
- just above we saw that by changing the class named NameService, we have disturbed the className WelcomeService; which was just using the method named getName of NameService class.
- so we can well realise that for simple usage of method from other class, due to tight-coupling, can cause so much of hassle.
- to break the hassle, we have a looseCoupling concept and this concept can be implemented by Invesion of Control.
*****
### Interface
- interface is a list of variables and methods.
- we just list them out. Again, interface is just a list of variables and methods

#### https://www.youtube.com/watch?v=IIvGvfGoLas

- @RestController: it is responsible for handling all the incoming client requests and delegating it to the appropriate service methods depending on the uri pattern of the respective request.
- @RestController is a convenient annotation that combines @Controller and @ResponseBody which eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation.

```
package com.emse.spring.faircorpagain.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewBornBabyController {

    @GetMapping("baby/name")
    public String getBabyName(){
        return "Alexander";
    }
}
```
- so the server was already running
- the primary task was to stop the server, which was done successfully by the stop option, the redButton at the top right corner of the page
- we started the server with the below command
```
gradlew --continuous bootRun
```
- and finally got to see the below at http://localhost:8080/baby/name

![@RestController and @GetMapping("baby/name")](https://github.com/anindameister/WebDevelopmentClass/blob/main/snaps/8.PNG)

### @Component and @Autowired 

```
package com.emse.spring.faircorpagain.hello;

import org.springframework.stereotype.Component;

@Component
public class NewBornBabyService {

    public String getBabyName(){
        return "AlexanderMaulik";
    }


}
```

- by the above, we just created a class and inside the class, we created a method. This method returns something.
- now, we want to use this method somewhere else.
- In general the following code should have come into action

```
public class NewBornBabyServiceUtilisation {

	
	NewBornBabyService newBornBabyService=new NewBornBabyService();
	
    public String getBabyName(){
        return newBornBabyService.getBabyName();
    }
}
```
- the above code is valid without @Component and @Autowired
- Now, I tried to remove @Autowired and attempted to make it work. Indeed it worked.

```
package com.emse.spring.faircorpagain.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewBornBabyController {

//    @Autowired
    NewBornBabyService newBornBabyService=new NewBornBabyService();

    @GetMapping("baby/name")
    public String getBabyName(){
        return newBornBabyService.getBabyName();
    }
}
```
- I attempted to remove @Component and it worked as well. Below is the code.
```
package com.emse.spring.faircorpagain.hello;

import org.springframework.stereotype.Component;

//@Component
public class NewBornBabyService {

    public String getBabyName(){
        return "AlexanderMaulik";
    }


}
```
- Concept of bean also come up here, but let's just ignore that for a moment.

## @Value
- the value was stored in application.properties
- Let's consider that the value doesn't come from application.properties then it can be stored within, code available to explain better. The value given within the class is probably in jsp format.

```
package com.emse.spring.faircorpagain.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewBornBabyController {

    @Value("${baby.weight:we didn't get the value from application.properties}")
            String babyweight;

//    @Autowired
    NewBornBabyService newBornBabyService=new NewBornBabyService();

    @GetMapping("baby/name")
    public String getBabyName(){
        return "The baby name is "+newBornBabyService.getBabyName() +". "+"The baby weight is "+babyweight;
    }
}
```
***********
## jsp

- we create a folder under main, and name it "webapp", could be different, dont forget to check the telusko video if this doesnt work
- we have to create a home.jsp page. This is done by creating a html page and then choose refactor option to renane this to .jsp
- we put the below dependency of tomcat jasper from mvnCentral

```
// https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-jasper
    compile group: 'org.apache.tomcat', name: 'tomcat-jasper', version: '9.0.39'
```

- for now, the below is a working jsp file
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="addAlien">
    <input type="text" name="aid"><br>
    <input type="text" name="aname"><br>
    <input type="submit"><br>
</form>



</body>
</html>
```


## h2 database Telusko

```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa' // libs to use JPA in your project
implementation 'com.h2database:h2' // libs to use a H2 database
```

- the above goes under dependencies in the build.gradle
- we need to do "gradlew build"
- we need to put in the below lines in the application.properties

```
spring.h2.console.enabled=true
spring.datasource.platform=h2
spring.datasource.url=jdbc:h2:mem:aninda
```

- the database will be accessible in localhost:8080/h2-console
- the below was there before and testConnection failed
```
jdbc:h2:mem:aninda
```
- fixed it by getting the right thing from application.properties
- @Entity @Id, gives me a table and gets "JPA" introduced. 
- this database is inMemoryDatabase, so everytime we relaunch it, the data gets lost. So having a data fie eg:data.sql which contains the data is so much better.
- now the below works
```
insert into alien values(101,'Aninda')
```
- the below doesn't work
```
insert into alien values(101,"Aninda")
```
*******
# SpringBoot Navin Reddy

- Many Java EE features and one of them is EJB
- EJB

## Spring Features
- POJO
- Dependency Injection
- MVC
- RESTful
- Security
- Batch
- Data
- AOP
- It can integrate with other frameworks as well like Hibernate and Struts

## you have to work with
- jar files
- configurations

![The track](https://github.com/anindameister/WebDevelopmentClass/blob/main/snaps/10.PNG)

## scopes in spring framework
- singleton(for core)<-- even if you dont create an object in a different class, SpringFramework would give you the object. This creation of objects before hand is called singleton design pattern. And also it would create an object only once. Recall Telusko at 32:00
- prototype(for core)<-- if you dont ask for objects, it wont be created. Mention prototype in SpringFramework to call this. Java core app gives this feature by default.
- request(for web)
- session(for web)

- the below shows that by default java follows prototype, so it creates object as many times, the user wants. Below is a proof
```
constructor is a method which creates an object.
constructor is a method which creates an object.
Shirt is off
Shirt is off
Shirt is on*********
black
X
null
```
- the above is from Alex Lee's constructors. 

# 25th December,2020.

- we can manually create an object of a different "Alien" class in my current entry class **DemoApplication.java** , but dependency injection says, hey! developer, you dont need to manually create objects. Focus on the logic and we'll create the objects for you.
- current status of "DemoApplication.java" is as below

```
package com.emse.spring.faircorpagain.telusko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }
}
```
- we are now attempting to check the **run** method of the **SpringApplication** object. We do **Alt+F7** . If we do that, we'll be able to see the "run" method in the **SpringApplication.java**.. We would see that, "run" method gives an object of **ConfigurableApplicationContext**.
- Now, we would attempt to create an object of the type "ConfigurableApplicationContext" from the package **import org.springframework.context.ConfigurableApplicationContext;**. This package requests, being imported. 
- so, we will be creating an object, of name "context" of type "ConfigurableApplicationContext", using the "run" method of **"SpringApplication" class**.
```
ConfigurableApplicationContext object=SpringApplication.run(DemoApplication.class, args);
```
- Now, we would try to call a method of the object, "context". I get options by intellij. I see **getBean**, which wants a parameter. This parameter is the className, whose bean(object) the programmer wants.

```
Alien alienObject=context.getBean(Alien.class);
```
- so let's see the complete program
```
package com.emse.spring.faircorpagain.telusko;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context=SpringApplication.run(DemoApplication.class, args);

            Alien alienObject=context.getBean(Alien.class);
            alienObject.show();

    }
}

```
- we get an **error**
```
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.emse.spring.faircorpagain.telusko.Alien' available
```
- so basically this error message said that there's **no qualifying bean** 
- with the below line, we have initialised a Spring container
```
        ConfigurableApplicationContext context=SpringApplication.run(DemoApplication.class, args);
```
- but there's no bean inside the Spring container, that we just created

![empty Spring Container](https://github.com/anindameister/springBoot/blob/main/snaps/6.PNG)

- The empty Spring Container has two scopes which is for core apps. They are **Singleton** and **prototypes**. The other ones mentioned above, are for web applications.

- with the below line, we say that give me a bean/object of type "alien". According to the above error message, there's no qualifying bean, as in, we never told Spring Application explicitly that we need bean/object of Alien class. 
- So, we never told Spring Application that create a bean of Alien class, but we are calling a bean. 
- **It is same as, not creating a baby of Maulik class, but always calling for the baby to help/assist/work for my coding.**

- by doing the below, we specify, this is a class of which I want an object.

```
@Component
```
- with the above keyword, below becomes the current situation.
- so, we have not changed the above code at all, we just added **@Component** in the Alien class and we have the output as 
```
MerryChristmasOn25ThDecember,2020
```
- in the Alien.class, all we did is give three private attributes and associate getters&settes for the same. Then, we created a method, so that have a reason to create an object in the different class. Finally, we have put across the "@Component" keyword to tell Spring Application that this is the class, whose object/bean we give permission to be created by Spring Application.

- program Alien.class
```
package com.emse.spring.faircorpagain.telusko;

import org.springframework.stereotype.Component;

@Component
public class Alien {

    private int aid;
    private String aname;
    private String tech;



    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public void show(){
        System.out.println("MerryChristmasOn25ThDecember,2020");
    }

}
```
- we would now, attempt to create another object from the class Alien. In order to do that, we will do the DemoApplication

```            
Alien alienObject=context.getBean(Alien.class);

        Alien alienObjects=context.getBean(Alien.class);
                    alienObject.show();

            alienObjects.show();
```
- output
```
MerryChristmasOn25ThDecember,2020
MerryChristmasOn25ThDecember,2020
```
- Constructors are God. So let's try see the number of times, God/constructor comes into existence. So, we'll remove the above stuff to create multiple object. We would explicitly mention a constructor inside the Alien.class, to check the number of times it comes into existence in the DemoApplication
- we introduced the below in Alien.class 
```
    public Alien() {
        System.out.println("25Dec2020at2337hrs");
    }
```
- and got output
```
25Dec2020at2337hrs
MerryChristmasOn25ThDecember,2020
```
- so now, with the below code in DemoApplication, 
```
Alien alienObject=context.getBean(Alien.class);

        Alien alienObjects=context.getBean(Alien.class);
                    alienObject.show();

            alienObjects.show();
```
- output
```
25Dec2020at2337hrs
MerryChristmasOn25ThDecember,2020
MerryChristmasOn25ThDecember,2020
```
- so,object was created once, but method was called twice. Basicaly, we got **one instance** because of the singleton design pattern followed by SpringFramework.

- after commenting out the above code, we get the below output
```
25Dec2020at2337hrs
```
- This default object creation happens because **SpringFramework follows the concept of Singleton design pattern** which means that it would give you the object pre-hand, as in, we dont even have to wait for the object creation.
- **Note** this would have not happened, i.e. getting the object created pre-hand without the constructor, explicitly being defined in the Alien.class.. Just checked the same, and there's **no error and no output**

### prototype

```
import org.springframework.context.annotation.Scope;
@Component
@Scope(value="prototype")
```
- now the instance of the class would be created twice with the exact last code. Check out the output
```
25Dec2020at2337hrs
25Dec2020at2337hrs
MerryChristmasOn25ThDecember,2020
MerryChristmasOn25ThDecember,2020
```
- **Note**, we wont get a bean by default, we will get objects created with the keyword **getBean** . Number of times, object would be created would be based on the number of times "getBean" is called.
- So, the above code, being commented out in the DemoApplication, we won't be getting the object created even once due to the implimentation of "prototype".

### introducing another class and later bring in **AutoWired**

- we'll get a laptop class which would contain private attributes and in order to access these private attributes, we'll bring in getters&setters. Finally, we would try to bring in an object of this laptop class within the Alien.class. Let's proceed by getting a laptop class

```
package com.emse.spring.faircorpagain.telusko;

public class Laptop {

    private int lid;
    private String brand;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public void compile(){
        System.out.println("compiling");
    }
}
```
- so we created an object,"laptop" of class "Laptop" in the Alien.class
```
    private Laptop laptop;
```
- we created getters&setters in order to access the private object "laptop" from private class "Laptop". **It seems that we're explicitly saying that, let's make this "Laptop" class private.**
- we called a method from laptop class within show method
```
public void show(){
        
        System.out.println("MerryChristmasOn25ThDecember,2020");
        laptop.compile();
    }
```
- Now, after all this we got an error, saying **NullPointerException**, and this is because we didn't create an object like we do in regular times like doing the below
```
Laptop laptop=new Laptop()
```
- but this is SpringFramework, so we just declare "@Component" on top of the Laptop class.


![Laptop.class' object](https://github.com/anindameister/springBoot/blob/main/snaps/8.PNG)

- **note** before getting into **Autowired**, I just called the Laptop.class's object, basic java style and it worked. Again, we have to rememer that the sole purpose of bringing in Spring Boot is to get **loose coupling**
```
25Dec2020at2337hrs
25Dec2020at2337hrs
MerryChristmasOn25ThDecember,2020
compiling
MerryChristmasOn25ThDecember,2020
compiling
```
- we will get the same output by introducing "@Autowired"
- yes, by introducing "@Autowired" we have done the below and got the exact above output. **Note that, no .toString() used in Laptop.class**

![@Autowired](https://github.com/anindameister/springBoot/blob/main/snaps/9.PNG)

-**By default, the "@Autowired" searches by the class name, we would attempt to make "@Autowired" search by object name below**

- add **@Qualifier("lap1")** in the Alien.class and **@Component("lap1")** in laptop.class

- Laptop.class code remains same as top with a very small difference.
```
@Component("lap1")
```
- Alien.class code, changes a bit in terms of the code above, posting the same below

- Alien.class
```
package com.emse.spring.faircorpagain.telusko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Alien {

    private int aid;
    private String aname;
    private String tech;
    @Autowired
    @Qualifier("lap1")
    private Laptop laptop;



    public Alien() {
        System.out.println("25Dec2020at2337hrs");
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Laptop getLaptop() {        return laptop;    }

    public void setLaptop(Laptop laptop) {        this.laptop = laptop;    }

    public void show(){

        System.out.println("MerryChristmasOn25ThDecember,2020");
        laptop.compile();
    }

}
```
- and "DemoApplication.java" code remains the same

## web app using Spring Boot

- Choose **web** from that website or from the intellij
- **Reactive web** has not been chosen now, and this has been introduced in 2.0
- fixed the "DemoApplication.java" to the defaults, by just commenting the notNecessaryNow parts.
```
package com.emse.spring.faircorpagain.telusko;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }
}
```
- **src/main/webapp/home.jsp**
- basic skeleton of a .jsp page is as below, which would work
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

</body>
</html>
```
- **localhost:8080/home** whenever, client/browser has got this url, it should call for home.jsp.
- So the .jsp page in here is our view. Client would request the server. The request goes to the **controller** and the "controller" would call the home.jsp ..Right now, we dont have a controller. Question is, how do we create a controller in Spring. We just create a **controller class** and give it any name.
- so when we go to "localhost:8080/home", we are supposed to get that page. It doesn't have anything, because nobody is accepting the client's request as of right now. Someone should accept the client's request and who would do that, it is the "Controller".
- So where were we? We attempted to create a class. This class should have a method. And in order to have this class work as a controller, we need to annotate this class with **@Controller**.. Just a note, for REST services, we need **RestController**.

![Annotations learnt till now](https://github.com/anindameister/springBoot/blob/main/snaps/10.PNG)

#### web app using Spring Boot contd..

- so, we have a .jsp file user "src/main/webapp/home.jsp".. We have a controller in place, which is capable of serving the Client's request. Now, the Client's Request is associated to "http://localhost:8080/home".. Now, the server needs to serve the request coming from "http://localhost:8080/home" and the way it does that is by **@RequestMapping("/home")**.. This annotation is used above the method of the Controller class, which is supposed to serve the Client's request coming from "localhost:8080/home".. 
- **addingJspDependency** because Spring Boot doesn't support jsp by default

```
// https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-jasper
    compile group: 'org.apache.tomcat', name: 'tomcat-jasper', version: '9.0.39'
```
- the above version is based on the **embedded Tomcat version**
- with the above dependency being added, Spring Boot now knows, **how to convert jsp into servelets**

- current JSP code
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>What are the annotations, we have learnt till now?</h1>
<ol><li>
    @Component
    <ul><li>This tells that, I authorise this class to be used as bean</li></ul>
</li>
    <li>@Scope(value="prototype")
    </li>
    <ul><li>To be noted, the default type is Singleton for Spring Boot which means that an instance of the class would be given to the other class, even without calling it</li>
    <li>with @Scope(value="prototype") , the class needs to call for the bean explicitly</li></ul>
    <li>@Autowired</li>
    <ul><li>a class' method to be called within another class' method</li>
    <li>Eg:Laptop class called by Alien.class and this Alien.class being called by DemoApplication.java</li>
    </ul>
    <li> @Autowired @Qualifier("lap1")</li>
    <ul><li>@Autowired is used to connect one class to another class on the basis of class name</li>
    <li>@Autowired @Qualifier("lap1") is used to connect a class to another class, by the other class' object name by using things like @Component("lap1")
    </li>
    <li>@Controller</li>
        <ul><li>When client request a server to serve the webPage, then this Client searches for the controller in the server. To create this Controller, the server just needs a class and this class should have a method. This class needs to be annotated by @Controller</li>
        </ul>
    </ul>
    <li>@RestController</li>
    <ul><li>Same as @Controller but @RestController would be used for creating Restful Services.</li></ul>

</ol>

<form action="addAlien">
    <input type="text" name="aid"><br>
    <input type="text" name="aname"><br>
    <input type="submit"><br>
</form>



</body>
</html>
```
- output 


![jsp basic page](https://github.com/anindameister/springBoot/blob/main/snaps/13.PNG)

#### calling HTML
- I would now attempt to serve a html thing. It works perfectly. I followed the same way. 
- **ResponseBody**, we got the appropriate response by typing in the below code.

- we would end this section, by giving the codes given in the "Controller" class.
```
package com.emse.spring.faircorpagain.telusko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlienController {

    @RequestMapping("/home")
    public String home(){
        return "home.jsp";
    }

    @RequestMapping("/anindaHtml")
    public String html(){
        return "index.html";
    }

    @RequestMapping("/ResponseBodyIntroduced")
    @ResponseBody
    public String ResponseBodyIntroduced(){
        return "ResponseBodyIntroduced";
    }

}
```

![html page](https://github.com/anindameister/springBoot/blob/main/snaps/12.PNG)


- introduced to basic web page serving to client request by Spring Boot's controller. Also learnt the way to serve the nonDefault JSP page by adding Tomcat Jasper dependency. Served Html page. Got introduced to @ResponseBody annotation, which would be used more in REST

## Web App using Spring boot Application Properties File

- we would attempt to ** manuseparate the extension and location of the page to be served to the client,ally, without using the default of Spring Boot for .jsp within "src/main/webapp/home.jsp" and for .html "src/main/resources/static/index.html"**

1. The reason, we are doing this is because the public would know from where the .jsp pages are coming by default. So, we'd using the default and just introduce a new folder with certain name. We would give the same in the **application.properties**. The look of the application.properties at this point is as below,
```
spring.mvc.view.prefix=/jspPages/
spring.mvc.view.suffix=.jsp
```

![manualPageServingConfigurationJsp](https://github.com/anindameister/springBoot/blob/main/snaps/11.PNG)

2. We would now try to do the same for serving html pages. **Couldn't do that, getting error to be checked later. Not the same way like serving .jsp**

## Web App using Spring Boot Accepting Client Data 1:00:13

## 1:08:51 Web App using Spring Boot ModelAndView
- 1:15:39

```
@RequestMapping("/learningMV")
    public ModelAndView learningMV(@RequestParam("name") String myName){
        ModelAndView mv=new ModelAndView();
        mv.addObject("name",myName);

        mv.setViewName("learningMV");
        return mv;

    }
```
- **@RequestMapping("/learningMV")**
:- the default path
- **ModelAndView mv=new ModelAndView();** :- we are creating **mv** object of ModelAndView class
- **return mv;** we are returning an object of type mv, and hence
- **public ModelAndView learningMV(@RequestParam("name") String myName)** in here, we are mentioning "ModelAndView" because this is basically the return type. So accessModifier returnType className(attribute1=matchingTheKeyNameWithTheIncomingKeyName attribute2=storingTheValueOfKeyvaluePairInAString)
- **mv.addObject("name",myName);**:- we are calling the **addObject** method of ModelAndView class and sending the data to the view whose name is mentioned in the below line
- **mv.setViewName("learningMV");**

- output at
```
http://localhost:8080/learningMV?name=aninda
```

![ModelAndView](https://github.com/anindameister/springBoot/blob/main/snaps/14.PNG)

- http://localhost:8080/learningMV?age=aninda would not work and give an error because it doesnt match **@RequestParam("name")**

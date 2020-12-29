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
- btw, it has got to be "aninda", "Aninda" is being changed to lowerCase

![ModelAndView](https://github.com/anindameister/springBoot/blob/main/snaps/14.PNG)

- http://localhost:8080/learningMV?age=aninda would not work and give an error because it doesnt match **@RequestParam("name")**

#### Recap:
- server is accepting request from with the help of **@RequestMapping("/learningMV")**
- server is having ModelAndView, where Model is the data and View is the viewName
- Data is accepted from **@RequestParam("name")** and stored in **String myName**
- ModelAndView is sending the data with it's method **mv.addObject("name",myName);** to the viewName **mv.setViewName("learningMV")** and finally returning **mv**, data and view
- ModelAndView is the special class powered by Spring Boot

## Web App using Spring Boot Model Object

- Accepting a lot of values from the client. This could be only done, if the server can give this scope to the client. Previously, it was just giving the scope of 1, which was through "@RequestParam("name")".. "name" had to match with the client's request parameter. 
- This time, we are giving the scope to the client through **public ModelAndView learningMV4Multiple(Maulik maulik){**
- so we have created a class called **Maulik** and in here, we are creating an object. This object contains the attributes, and all those attributes become the new scope of the client's request.
- **mv.addObject("maulikObject",maulik);** , this is the required keyValue pair
- **maulikObject** is termed as **attributeName** by Spring Boot
- it seems that we cannot do **${maulik.memberOccupation}** , so we are doing **${maulikObject.memberName}** instead, because comeon we cannot use the java objects within JSP

- jsp
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
Welcome to the world of Spring Boot
You, yes you, ${maulikObject.memberName} could be of age ${maulikObject.memberAge} but since your ${maulikObject.memberOccupation}, your occupation supports a lot of mental work so you would be able to cope up with Spring Boot
</body>
</html>
```
- Maulik.class has 3 private variables and getters&Setters for them
- the below is added for the AlienController.java
```
@RequestMapping("/learningMV4Multiple")
    public ModelAndView learningMV4Multiple(Maulik maulik){
        ModelAndView mv=new ModelAndView();
        mv.addObject("maulikObject",maulik);

        mv.setViewName("learningMV4Multiple");
        return mv;

    }
```
- output


![ModelAndView's request accepting from client, scope, has been increased](https://github.com/anindameister/springBoot/blob/main/snaps/15.PNG)

- **Note:- Recall the error of localHost, that came up due to silly mistake of not spelling "local", right.. The error should be Whitepage... and not localHost error which might mean that the internet cable has been unplugged**

## Spring Boot JPA MVC H2 Example

- web
- **jpa**
- **h2**

- some kind of bug is coming up and hence getting, the below, got to check the **.jsp.jsp bug**
![jsp.jsp](https://github.com/anindameister/springBoot/blob/main/snaps/16.PNG)

- Moving on, by putting the .jsp file in the default directory and commenting out the application.properties part
- below are the 3 settings that needs to be put in the application.properties , in order to get started with h2 database
```
spring.h2.console.enabled=true
spring.datasource.platform=h2
spring.datasource.url=jdbc:h2:mem:aninda
```
- **http://localhost:8080/h2-console** to access the console
- click **Test connection** and we're supposed to get a success message
- we'll click on connect and proceed.

#### JPA
- **@Entity** table name
- **@Id** table data
- controller/AlienController.java
```
@RequestMapping("/learningDatabase")
    public String learningDatabase(){

        return "learningH2.jsp";
    }
```
- model/Alien.java
```
package com.emse.spring.faircorpagain.telusko.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;

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

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                '}';
    }
}
```
- we have now got a table in the h2 named **ALIEN**
- we attempted to check the data availability by 
```
select * from alien
```
- we found none, because with "@Id" we were able to set the fields of the table, let's consider that we're able to give the **column names** to our table. Now, we have got to insert data.

- in order to enter data into the database, we would attempt to create a separate data file under **resources/data.sql**
- Now, **h2 is an in-memory database**, so if we insert data from h2, then everytime we re-launch it then we'll lose the data..That's why we are keeping our data in a separate file.

- database
![database console](https://github.com/anindameister/springBoot/blob/main/snaps/17.PNG)

- data.sql
```
insert into alien values(101,'Aninda')
insert into alien values(102,'Arunava')
```
#### Now, we want the client to enter data
- let's look at the .jsp file
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
- we have **form action="addAlien"** but the server is not yet entertaining this action called "addAlien". Let server address this client's action "addAlien"
- so the server would accept request from http://localhost:8080/addAlien
and for this we have got @RequestMapping("/addAlien")
- so whenever the server would receive the request from "/addAlien", it would **first send the request to the controller class which has been annotated by @Controller** and then within the controller class, find out who is accepting the request from client which would be gotten by @RequestMapping("/addAlien") and the corresponding method would handle this request. 
- The request is coming with some data and this would be handled by **public String addingAlien(Alien alien)**. Let's understand that Alien.class in here is responsible to create the database table along with assigning the table column value. So now, **alien** object would be able to get the data coming from the client in accordance to the parameters mentioned in the Alien class. Now, the question might come up that, how is a newly created object, becomes capable of getting the data so that's exactly the beauty of Spring Boot. Spring Boot is giving the capability to the newly created object to get the data. 

```

@RequestMapping("/addAlien")
public String addingAlien(Alien alien){

    return "learningH2.jsp";
}
````

- Now, server is capable to accept request, accept the data coming with the request, and now the server needs to store the data in the database.

- https://github.com/anindameister/springBoot/tree/main/InterfaceLearningForSpringBoot

- for saving the data in the database that is **update** part from **CRUD:-Create, read, update and delete**

- we would attempt to get this power of performing CRUD operation and we just need to tell Spring Boot, **gimme the power to perform CRUD operation**.. In response, Spring Boot says who needs the CRUD power. We say, CRUD power is required by Java class. But Java class wont be able to handle the powerful CRUD, it doesn't have the capability to handle the multiple inheritances that would come along with CRUD. So, we say, fine! Java class dont have the capability to get CRUD power because of the multiple inheritances coming along but Java Interface has the power to handle multiple inheritances provided they are all abstract classes. Thus, we now have to create an **Interface which would extend the CrudRepository and we have to just pass the parameter where we have to mention which class has the proven power to create and set the database column names. The answer is the Alien class. So we pass in the first parameter as Alien. The second parameter is that what kind of value would CRUD need to handle? The answer is primitiveValues ie Integer and that becomes the second parameter**
```
package com.emse.spring.faircorpagain.telusko.dao;

import com.emse.spring.faircorpagain.telusko.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
}
```
- Now we have this in the CrudRepository. We can access that with ALT+F7
```
public interface CrudRepository<T, ID> extends Repository<T, ID> {
```
- CrudRepository.java contains all the stuff which helps in performing CRUD operations

- Before CRUD coming into picture, our situation was this as below.
- Now, server is capable to accept request, accept the data coming with the request, and now the server needs to store the data in the database.
- So basically our Controller who is gonna accept the incoming requests from client along with data needs to store the data. In order to store data, this Controller class is gonna use an object of the class, which gives the power to store data.

```
AlienRepo alienRepo;
```
- Ok, done. Now, controller class has an object. So, let's just loosely couple them with the help of "@Autowired"

![@Autowired](https://github.com/anindameister/springBoot/blob/main/snaps/20.PNG)

- Okay, now Controller has the object. 
- Time to use the object.
- BTW, why is Controller class trying to use the object??
- Controller class is trying to use the object to save data and let's do that

```
        alienRepo.save(alien);
```
- so we have this as below
```
    @Autowired
    AlienRepo alienRepo;

    @RequestMapping("/addAlien")
    public String addingAlien(Alien alien){

        alienRepo.save(alien);

        return "learningH2.jsp";
    }
```
- .jsp status
```
<form action="addAlien">
    <input type="text" name="aid"><br>
    <input type="text" name="aname"><br>
    <input type="submit"><br>
</form>
```

![Sending data from the jsp page](https://github.com/anindameister/springBoot/blob/main/snaps/21.PNG)

- data from .jsp goes as below because there is no REST and it is very dangerous for sending passwords without implementing REST

![jsp sending data without REST,not REST, recall talking to Maxim](https://github.com/anindameister/springBoot/blob/main/snaps/22.PNG)

- below is the database status

![h2 database status](https://github.com/anindameister/springBoot/blob/main/snaps/23.PNG)

## Spring Boot JPA MVC H2 Example Part 2

- why do we need a service layer?
- in enterprise application, at times, data is not coming from database, instead coming from network or the input provided by the user. Thus we need to process something and that processing is to be done in the service layer.
- In case, the data is coming from Repository then the service layer would interact with the repository, so that's how we build our application. 
- But in order to have an introductory understanding of the Spring Data JPA we went directly with the alienRepo.
- Now, we have a alienRepo and we are able to add data to the repository. Question, is that, what if we wanna fetch the data

- we start with the .jsp
```
<hr>
<form action="getAlien">
    <input type="text" name="aid"><br>

    <input type="submit"><br>
</form>
```
- so from .jsp we have created a pseudo method called "getAlien". So the above part would accept an "aid" and when the user hits submit, it should fetch the data from the database based on the aid.
- Now the Controller, receives the client's request named "getAlien" and accepts the same through this,
```
    @RequestMapping("/getAlien")
```
- the Controller, also receives 1 data, aid, by the following
```
    public String gettingAlien(@RequestParam int aid){
```
- **@RequestParam** is used to fetch data from client
- okay, the controller just got the data, now what! Now, we have to show the data in form of a .jsp page .. Jsp page construction is in process.
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

${alien}

</body>
</html>
```
- in the controller, controller has accepted the data coming with client request. The data is an int "aid"
- Now, we would try to call the method of alienRepo. This is an object of the interface which extends the CrudRepository
- In case we dont find the id then we will send a "null" value.
- let's recollect this, **alienRepo.save(alien);**
- so we were getting the method to save, so for sure we are getting the method to find

```
        alienRepo.findById(aid).orElse(null);
```
- Again, we have below, as of right now
```
    @RequestMapping("/getAlien")
    public ModelAndView gettingAlien(@RequestParam int aid){
```
- with the above, controller gets the data
- recollecting again, we were saving "alien" before in here "alienRepo.save(alien);"
- we would try to store the data again into "alien"
- so we have searched for the data with **alienRepo.findById(aid).orElse(null);** and now we'll store the data within alien like below. And just fyi, alien is an object of class Alien. Just like we mention String a="Aninda Maulik" similar to this is below
```
Alien alien=alienRepo.findById(aid).orElse(null);
```
- Now, **ModelAndView mv=new ModelAndView("showAlien.jsp");** is used for telling ModelAndView that this is the .jsp page where you have to send your mv. And what's the value of this "mv" it is "alien"
```
@RequestMapping("/getAlien")
    public ModelAndView gettingAlien(@RequestParam int aid){

        ModelAndView mv=new ModelAndView("showAlien.jsp");

        Alien alien=alienRepo.findById(aid).orElse(null);
        mv.addObject(alien);

        return mv;
    }
```

![fetch the data](https://github.com/anindameister/springBoot/blob/main/snaps/24.PNG)
- Now, if attempt to **fetch the id which is non-existent then we get an error**, changing the code and checking now.
- changed the line to below with changing to this **orElse(new Alien())**. 
We are just returning a new object instead of null, which was giving an exception before. We can also create a fake object, return fake data and all that.


```
        Alien alien=alienRepo.findById(aid).orElse(new Alien());
```
- full code
```
@RequestMapping("/getAlien")
    public ModelAndView gettingAlien(@RequestParam int aid){

        ModelAndView mv=new ModelAndView("showAlien.jsp");

        Alien alien=alienRepo.findById(aid).orElse(new Alien());
        mv.addObject(alien);

        return mv;
    }
```

![no id available](https://github.com/anindameister/springBoot/blob/main/snaps/25.PNG)

## Spring Boot Data JPA MVC H2 Query Methods Example Part 3

1. **http://localhost:8080/getAlien** doesn't work as an individual website and instead this works, **http://localhost:8080/getAlien?aid=106**.. Attempted to remove the form part for getALlien within jsp and relaunch the app, just to find that even now, the same thing persists.

2.Attempted to change the Alien.java file.. Attempts were made to add another private attribute called tech. Corresponding getters&setters, toString() were also added. Code's current structure can be well thought of, right now.

3. It seemed that the database didn't contain the previous data any longer after an attempt was made to change the Alien.java file, not 100% sure though

![database status](https://github.com/anindameister/springBoot/blob/main/snaps/26.PNG)

- from the above snap, we see that 107 doesn't exist and we tried to search for the same and got the below

![null value thingy not messed within the code but getting null results](https://github.com/anindameister/springBoot/blob/main/snaps/27.PNG)

4. **alienRepo.save(alien);** is saving to database temporarily or not, got to check. Yes, it is not saving with any sort of permanence.Yes, it wasn't. Thank God, for getting recalled and sticking to that recallment, which I dont do generally. ANyway, I have got to save it in data.sql file,
```
insert into alien values(101,'Aninda','Python and Java')
insert into alien values(102,'Arunava','Python')
insert into alien values(103,'Rohith','Python')
insert into alien values(104,'Dayanath Dharmalingam','Java')
insert into alien values(105,'Poulomi Nandy','Java')
insert into alien values(106,'Jonathan Mallet','Python and Java')
insert into alien values(106,'Sri Kalindi','Java and Python')
insert into alien values(107,'Dr. Kalpana Maulik','Parasytology')
```
5. **to note that the single entries such as Parasytology and 'Java and Python' are not coming up**This problem came up because if we look up 106 is assiged for both JonathanMaller and Sri and that's wrong, so anything after that wasn't coming up. Got that fixed and now out final output is after point 8 in this section.

6. Addition in AlienController.java
```
@RequestMapping("/getAlien")
    public ModelAndView gettingAlien(@RequestParam int aid){

        ModelAndView mv=new ModelAndView("showAlien.jsp");

        Alien alien=alienRepo.findById(aid).orElse(new Alien());

        System.out.println(alienRepo.findByTech("Java"));
        System.out.println(alienRepo.findByTech("Python and Java"));
        System.out.println(alienRepo.findByTech("Java and Python"));
        System.out.println(alienRepo.findByTech("Parasytology"));

        mv.addObject(alien);

        return mv;
    }
```
7. Corresponding addition in Alienrepo.java
```
package com.emse.spring.faircorpagain.telusko.dao;

import com.emse.spring.faircorpagain.telusko.model.Alien;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

    List<Alien> findByTech(String tech);
}
```
8. Output as of right now,in the Java console
```
[Alien{aid=104, aname='Dayanath Dharmalingam', tech='Java'}, Alien{aid=105, aname='Poulomi Nandy', tech='Java'}]
[Alien{aid=101, aname='Aninda', tech='Python and Java'}, Alien{aid=106, aname='Jonathan Mallet', tech='Python and Java'}]
[]
[]
```
- The above problem was caused by wrong entry in data.sql
9. Addition to AlienRepo.java
```
List<Alien> findByAidGreaterThan(int aid);
```
- we got to remember that **findByAidGreaterThan** is exactly based on convention and the beauty of Spring Boot is that, it came up automatically.
- 10. Based on this section's work, the new additions in AlienController.java
```
System.out.println(alienRepo.findByTech("Java"));
        System.out.println(alienRepo.findByTech("Python and Java"));
        System.out.println(alienRepo.findByTech("Java and Python"));
        System.out.println(alienRepo.findByTech("Parasytology"));

        System.out.println(alienRepo.findByAidGreaterThan(102));
```
11. Output
```
[Alien{aid=104, aname='Dayanath Dharmalingam', tech='Java'}, Alien{aid=105, aname='Poulomi Nandy', tech='Java'}]
[Alien{aid=101, aname='Aninda', tech='Python and Java'}, Alien{aid=106, aname='Jonathan Mallet', tech='Python and Java'}]
[Alien{aid=107, aname='Sri Kalindi', tech='Java and Python'}]
[Alien{aid=108, aname='Dr. Kalpana Maulik', tech='Parasytology'}]
[Alien{aid=103, aname='Rohith', tech='Python'}, Alien{aid=104, aname='Dayanath Dharmalingam', tech='Java'}, Alien{aid=105, aname='Poulomi Nandy', tech='Java'}, Alien{aid=106, aname='Jonathan Mallet', tech='Python and Java'}, Alien{aid=107, aname='Sri Kalindi', tech='Java and Python'}, Alien{aid=108, aname='Dr. Kalpana Maulik', tech='Parasytology'}]
```
12. Creating our own methods and in order to do that, we have to write the query as well.
```
 @Query("from Alien where tech=?1 order by aname")
```
- so the above is JPQL query since we are working with JPA. JPQL is almost same as HQL and that is similar to SQL, with some changes. 
- sql
```
Select * from table
```
- JPQl, because "select *" is the boiler plate code and we dont need that.
```
from table
```
- complete JPQL query attempting1
```
from Alien where tech=?1
```
- ? is used because the value is coming from the user
- in JPQL we use ?1, which means the number of question marks
```
from Alien where tech=?1 order by aname
```
- **order by aname** because we wanna sort based on the name
13. Addition to the AlienRepo.java
```
        System.out.println(alienRepo.findByTechSorted("Java"));
```
14. output
```
[Alien{aid=104, aname='Dayanath Dharmalingam', tech='Java'}, Alien{aid=105, aname='Poulomi Nandy', tech='Java'}]
```




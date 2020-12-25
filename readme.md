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





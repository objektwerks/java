Java
----
>Java feature tests to include:
* classes
* collections
* control flow
* datetime
* enums
* futures
* generics
* http client
* logging
* loops
* math
* optional
* pattern matching
* random
* records
* recursion
* streams
* threads
* text blocks
* variables
* varargs
>And quite possibly a few more features.:)

Java X Project
--------------
>See [Java X Project](https://github.com/objektwerks/java.x) for some dated yet useful work on:
1. aop ( aspect-oriented-programming )
2. hibernate ( object-relational mapping )
3. models ( homeschool, beer )
4. jaxb ( java <-> xml binding )
5. jms ( messaging )
6. jpa ( object-relational mapping )
7. quartz ( scheduling )
8. xml ( structured markup language )
9. spring ( dependency injection framework and more )

Swing Project
-------------
>Also see [Swing Project](https://github.com/objektwerks/swing) for Java2D and Swing work.

New Features ( JDK 8 to JDK 18 )
--------------------------------
* [New Features](https://advancedweb.hu/a-categorized-list-of-all-java-and-jvm-features-since-jdk-8-to-18/)

Preview Features
----------------
>Status of build tools and IDEs vis-a-vis JDK 17 **preview features**:
1. Maven **does** understand; unit tests **pass**.
2. Gradle **does not** understand; and unit tests **fail**.
3. Intellij **does** understand; yet unit tests **fail** since it defaults to Gradle. 
   1. **Solution:** Configure Intellij to run tests using Intellij and Maven.
4. VS Code **does not** understand. See **VS Code Settings** section below!
>See maven and gradle build files for details:
1. pom.xml
2. build.gradle.kts
>Commandline options:
* javac: ```javac --release 17 --enable-preview```
* java: ```java --release 17 --enable-preview```

VS Code Settings
----------------
>Via File > Preferences > Settings: **enter** java.jdt.ls.java.home > **select** Edit in settings.json
```
   "java.jdt.ls.java.home": "/Library/Java/JavaVirtualMachines/zulu-17.jdk/Contents/Home",
   "java.jdt.ls.vmargs": "--release 17 --enable-preview",
   "java.configuration.runtimes": [
      {
         "name": "JavaSE-17",
         "path": "/Library/Java/JavaVirtualMachines/zulu-17.jdk/Contents/Home",
         "default": true
      },    
   ],
```
>These settings are supposed to ensure JDK 17 preview features are **enabled**!
>**WARNING** Sadly this setting ```"java.jdt.ls.vmargs": "--release 17 --enable-preview"```
>fundamentally disables Java support in VS Code.

Install
-------
>On a Unix system, consider using [Sdkman](https://sdkman.io/) to install Maven and Gradle.
1. [Maven](https://maven.apache.org/)
2. [Gradle](https://gradle.org/)

Build
-----
1. gradle clean build
2. mvn clean install

Test
----
1. gradle clean test
2. mvn clean test
3. In Intellij, right-select java > src > test > java > objektwerks > Run Tests in objektwerks

Run
---
1. gradle run
2. mvn exec:java

Package
-------
>Package and assemble, via maven-assembly-plugin, an executable jar:
1. mvn package

Execute
-------
>Run executable jar:
1. java -jar target/java-1.0-SNAPSHOT-jar-with-dependencies.jar

Learn Java
----------
>Random thoughts on how to learn Java - from a guy who used Java for 16 years.
1. Create a **free** [Github Account](https://github.com).
2. Learn [Git Basics](https://www.freecodecamp.org/news/learn-the-basics-of-git-in-under-10-minutes-da548267cc91/).
3. Download and install:
   1. [Java JDK 17](https://www.oracle.com/java/technologies/downloads/#java17).
   2. [Intellij Community Edition](https://www.jetbrains.com/idea/download/#section=mac)
4. Start learning Java with [Get Started with Java Series](https://www.baeldung.com/get-started-with-java-series).
5. Maintain all Java project work in one or more Github repositories as required.

>***Always keep it simple!*** ***And never forget Murphy's law!***

IDEs
----
>The following IDEs are also used in the Java community:
1. [Eclipse](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers)
2. [Visual Studio (VS) Code]( https://code.visualstudio.com/download ).
3. [Netbeans](https://netbeans.apache.org/)

Resources
---------
1. [Baeldung](https://www.baeldung.com/)
2. [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
3. [Jenkov Java Tutorials](https://jenkov.com/tutorials/java/index.html)
4. [Java Tutorials Point](https://www.tutorialspoint.com/java/index.htm)
5. [Manning Books](https://www.manning.com/)
6. [Amazon Java Best Sellers](https://www.amazon.com/Best-Sellers-Books-Java-Programming/zgbs/books/3608)
7. [Udemy Java](https://www.udemy.com/courses/search/?src=ukw&q=java)
8. [Coursera Java](https://www.coursera.org/search?query=java&)
9. [Rock the JVM Java Video](https://www.youtube.com/watch?v=sjGjoDiD2F8)
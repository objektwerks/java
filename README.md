Java
----
>Java feature tests using both Gradle and Maven build tools.

Bug
---
>In VS Code, the Red Hat **Language Support for Java** extension contains a bug that emits this error message:
* Project 'java' has no explicit encoding set
* See: https://github.com/redhat-developer/vscode-java/issues/2416
>The next release, likely 1.6.0, will include a fix. Ignore for now.

Build
-----
1. gradle clean build
2. mvn clean install

Test
----
1. gradle clean test
2. mvn clean test

Run
---
1. gradle run
2. mvn exec:java

Learn Java
----------
>Random thoughts on how to learn Java - from a guy who used Java for 16 years.
1. Create a free [Github Account]( https://github.com ).
2. Learn [Git Basics]( https://www.freecodecamp.org/news/learn-the-basics-of-git-in-under-10-minutes-da548267cc91/ ).
3. Download and install:
   1. [Java JDK 17]( https://www.oracle.com/java/technologies/downloads/#java17 ).
   2. [Visual Studio (VS) Code]( https://code.visualstudio.com/download ).
   3. VS Code [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).
   4. [Intellij Community Edition](https://www.jetbrains.com/idea/download/#section=mac)
4. View short video tutorial on [VS Code]( https://code.visualstudio.com/learn/get-started/basics ).
5. Start learning Java with [Learn Java Tutorial](https://www.codecademy.com/learn/learn-java).
6. Maintain all Java project work in one or more Github repositories as required.

>I recommend using both VS Code and Intellij, given their popularity in the Java space. Eventually you'll develop a
>preference for one, but know both.
>The following IDEs are also used in the Java community:
1. [Eclipse](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers)
2. [Netbeans](https://netbeans.apache.org/)

>***Always keep it simple!*** ***And never forget Murphy's law!***
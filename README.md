# Environment setup guide

1. Install a JDK (version at least 1.8 and no higher than 11)
    * A tutorial for Windows : [click here](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-0DB9580B-1ACA-4C13-8A83-9780BEDF30BB)
    * A tutorial for MacOS : [click here](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-F575EB4A-70D3-4AB4-A20E-DBE95171AB5F)
    * A tutorial for Linux : [click here](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-ADC9C14A-5F51-4C32-802C-9639A947317F)
    
2. Install and well configure an IDE for Java ([Eclipse](https://www.eclipse.org) or [IDEA](https://www.jetbrains.com/idea/))
    * Set JDK for Eclipse : [click here](https://stackoverflow.com/questions/13635563/setting-jdk-in-eclipse)
    * Set JDK for IDEA : [click here](https://stackoverflow.com/questions/18987228/how-do-i-change-the-intellij-idea-default-jdk)

3. Make sure there is a runnable [tomcat server](http://tomcat.apache.org)(version 7.0+) in your computer.
    * To install and run tomcat server, you can follow this [guide](https://www.ntu.edu.sg/home/ehchua/programming/howto/tomcat_howto.html) from step 0 to step 4. 
        and here is a little [demo video](https://1drv.ms/v/s!AosZzKUb3fmfgZ84BhznWlThFwN-TQ?e=7OH71q).
    
4. Configure the Tomcat server in your IDE
    * [Configure tomcat server in Eclipse](https://javatutorial.net/run-tomcat-from-eclipse)
    * [Configure tomcat server in Intellij IDEA](https://www.jetbrains.com/help/idea/configuring-and-managing-application-server-integration.html?keymap=primary_windows#when_creating_project_or_module)

5. Import this project into your IDE
    * For Eclipse : [click here](https://stackoverflow.com/questions/6760115/importing-a-github-project-into-eclipse)
    * For IDEA : [click here](https://www.jetbrains.com/help/idea/import-project-or-module-wizard.html)
    
6. Deploy the project on Tomcat server

7. Run the project and pray it works.


If every thing goes well, we can see the picture below.
![homepage](assets/Homepage.png)
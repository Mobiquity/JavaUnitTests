To run the test case of this project perform below mention steps.

1) The project JDK version should be 1.8. 

2) Import the existing maven project into Eclipse workspace.
	*) click on File Menu -> select "Import" -> select "Existing Maven Projects".
	*) Locate the path were the project "JavaServerUnitTestExample" has been checkout from GIT repository.
	*) Click the project check box to import.
	*) Click on "Finish" button.
	
3) Build the project in Eclipse.
    *) Select the project -> click on "Project" menu -> select "Build Automatically"

4) To run the test case perform following steps.
	*) Locate any test case class in the source folder "/src/test/java".
	*) Right click on the test case class -> from the pop-up menu select "Run As" -> select "Junit Test".
	

Changes to be done in pom.xml:

The dependency for wolfram 1.1 jar is not available openly on maven repository so it is needed to be added manually into system using 
following steps:

1) Copy the WolframAlpha-1.1.jar present under directory structure 'lib/' to a desired path on the system. 

2) Inside pom.xml change the system path for wolfram Aplha dependency using the absolute path where the jar is placed. For instance
 presently the path is:
 
 <dependency>
	<groupId>com.wolfram.alpha</groupId>
	<artifactId>WolframAlpha</artifactId>
	<version>${wolfram.alpha.version}</version>
	<scope>system</scope>
	<systemPath>/Users/ravinair/wolfram/WolframAlpha-1.1.jar</systemPath>
</dependency>

Provide the current path of the jar in the systemPath tag and then compile the application.
Note: The path of the jar should be absolute not relative. 
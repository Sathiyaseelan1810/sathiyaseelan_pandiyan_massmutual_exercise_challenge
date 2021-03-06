# sathiyaseelan_pandiyan_massmutual_exercise_challenge

Team - Greetings :)

Please see below the details about the tools used and the procedure to execute the scripts.

Tools & Framework Details: 
	Tool Used: Eclipse IDE for Java Developers (Version: 2021-03 (4.19.0)
	Programming Language: Java/JRE 8
	Testing Framework: Cucumber(BDD Approach) 
	JAR Dependencies: Cucumber, JUnit, RestAssured, Extent Report, Mockito
	Plugin: Cucumber Eclipse Plugin, Natural
	Repository: Git
	Project Architecture: Maven 
	OS Platfrom: Windows10

PreRequisites Details: 
	Step1: Install Java and Eclipse in the devices directly (Operating System Platfroms Independent)
		Note: If (Java and Eclipse) are already installed in the device, then skip the Step1 and proceed with the steps below, 
	Step 2: Install the GitHub plugin in eclipse
	Step 3: Goto: File -> Import -> GIT -> select (Projects from GIT) -> Click Next -> Clone URI
	Step 4: In Location Section: 
				URI = Provide the Git Local Folder to map from the repo
				Repo Path = Provide the GIT repo 
	Step 5: Click Next and complete the process.
	Step 6: Verfiy the Project should appear in the left panel of eclipse
	Step 7: Select the project and rightclick, then select (configure)-> convert as Cucumber Project.
	Step 8: You should see the progress at the right bottom panel.
	Step 8a: All the associated dependencies from the POM.xml are automatically installed in the background.
	Step 9: Run -> Run Configurations -> JRE -> Choose the path where the JRE installed
	Step 10: Make sure there should not be any errors from the project prespective. 
	Step 10a) If there is an error in the pom.xml -> Right click on the Root Folder -> Maven -> Update Project -> Select the checkbox(Force update of Snapshots/Releases)
	Step 11: Create the extent-config.xml in the src/main/resources to utilize the extent report for report generataion

Framework Overview: 
	I have implemented the Cucumber Testing framework which has 1) FeatureFile 2) StepDefinition 3) TestRunner
	Features: 	
		User can provide the parameter values in the feature file that will pass into the scripts during the runtime.
		Execute the TestRunner through Junit.
		Create the xml for log4j & extent report config files
	
Scripts Flow: 
	Step 1: Properties File created to store the unique keys.
	Step 2: Created the script to call the properties file and initialize the WebDriver in the Base Class
	Step 3: Created the utilities class to store the global values.
	Step 4: Created the Page Factory class to store the webelements.	
	Step5: Customized the Extent Factory report to store the passed /failed results.
	Step6: Created the resuable functions to call in the step defintion files.	
		For Scenario: (Validate the Counts)
			Feature File Location: src/test/java/mockupExericse/CucumberFeatures/ValidateValues.feature
			StepDefinition Location: src/test/java/mockupExericse/StepDefinitions/CustomStepDefinition.java
			TestRunner Location: src/test/java/mockupExericse/TestRunner/TestRunnerMock.java		
		
Execution Steps: 			
	Step 1a: To Execute (Option1 through Feature File)
		Goto -> src/test/java/mockupExericse/Featurefiles/CucumberFeatures/ValidateValues.feature Open as Cucumber Editor -> Right Click (Run as Cucumber Feature)
															(or)
	Step 1b: To Execute (Option2 through Test Runner for Report Generation)
		Goto -> src/test/java/mockupExericse/TestRunner/TestRunnerMock.java -> RightClick(Run as Junit)
	Step 2: If its executed through an option 1b) then cucumber extent reports will be generated and its available at the location CucumberReports/	
		Note: Reports are available in the following format(.html, .xml, .json)

Report Location: 
	1) Execution Report for the Scenario1 is available at CucumberReports
	Note: My execution reports are available at the same location for reference.
		To Open/review the report, Please download to any of the location and open it through Chrome Browser.	

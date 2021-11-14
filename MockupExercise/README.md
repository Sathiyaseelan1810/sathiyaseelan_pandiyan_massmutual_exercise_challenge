# MockupExercise

Overview: 

Author: Sathiyaseelan Pandiyan

Tools & Infrasctructure

  1) IDE: Eclipse Version: 2021-03 (4.19.0)
  2) Language: Java 8
  3) Framework: Cucumber (BDD) with Junit
  4) Plugins: Cucumber for Eclipse, Natural/JBehave
  5) Platform: OS_Windows

OverView: 

  1) Created this as Maven Project to build as .jar for future integration
  2) Implemented Mockito, Extent Report, Junit, Screenshots API libraries.
  3) Created FeatureFile, StepDefinitions, TestRunner Files as Part of BDD approach.
  4) Page Objects and Browser Initialization are handled in the separate files for reusability.
  5) Reusable functions are wrapped then called in Step Definitions.
  6) P.S: For Installed Jar's.
  7) Errors are handled in exceptions.
  8) Sample Extent Reports are generated and screenshots attached in the report.

Scenarios Covered:

  1) Get the PageObjects and captured the values and validate the counts
  2) Verify each values are greater than '0'
  3) Compare the amount with the total balance values.
  4) Verify each values are formatted as currency
  5) Verify the total values against the sum of values.


package mockupExercise.StepDefinitions;

/*    -------------------------------------------------------------
 * 		AUTHOR: Sathiyaseelan Pandiyan
 * 		AUTHOR EMAIL: seelan.pandiyan@gmail.com* 
 * 
     ------------------------------------------------------------- */

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.cucumber.listener.Reporter;
import com.test.pages.HomePage;
import com.test.utils.ReportLogs;
import com.test.utils.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wrapperMethod.CustomizeMethods;
import wrapperMethod.FetchValues;

public class CustomStepDefinition
{
	@Mock
	HomePage homePage;
	FetchValues fetchValues;
	TestBase baseClass;		
	CustomizeMethods StepCustoms;
	
	@Test
	@Given("Launch the Chrome Browser sucessfully")
	public void launch_the_Chrome_Browser_sucessfully() 
	{
		baseClass = new TestBase();		
		baseClass.browserInitialize();	
	}

	@Test
	@Given("Navigate to the URL")
	public void navigate_to_the_URL() 	
	{
		baseClass = new TestBase();		
		baseClass.navigateURL();	
	}

	@Test
	@When("Fetch the label and values from the mock webpage and verify the counts")
	public void fetch_the_label_and_values_from_the_mock_webpage_and_verify_the_counts() 
	{
		@SuppressWarnings("unchecked")
		List<WebElement> listElements = mock(List.class);			
		homePage = new HomePage();
		StepCustoms = new CustomizeMethods();
		int actualSize = StepCustoms.countValues().size();		
		try 
		{
			Mockito.when(listElements.size()).thenReturn(homePage.totalListWebElements().size());
			if(listElements.size() == actualSize)
	    	{
	    		assertEquals(listElements.size(), StepCustoms.countValues().size(), "Count Size is not matched");     
	    		ReportLogs.logPassed("PASSED: Total Number Of Values is displayed " + actualSize);
	        	String[][] data = 
	    			{
	    				{"TITLE", "EXPECTED RESULT", "ACTUAL RESULT", "STATUS"},
	    				{"Count of Values", ""+listElements.size(), ""+actualSize, "PASSED"}
	    			};
	    		Markup markup = MarkupHelper.createTable(data);
	    		ReportLogs.logPassed(markup.getMarkup());     		
	    	}	
			else
			{
				assertEquals(listElements.size(),StepCustoms.countValues().size(),  "Count Size is not matched");
				ReportLogs.logFailed("FAILED: Verified the Count Size: " + StepCustoms.countValues().size()); 
			}				
	    	Reporter.addScenarioLog("'Fetch the label and values from the mock webpage and verify the counts '" + "is Completed"); 
		} 
		catch (AssertionError e) 
		{
			ReportLogs.logFailed("Assertion Error " + e.getMessage());
			ReportLogs.logFailed("FAILED: Verified the Count Size: " + StepCustoms.countValues().size());   
		}		  	
	}

	@Test
	@When("Verify the each values displayed on the screen are greater than Zero")
	public void verify_the_each_values_displayed_on_the_screen_are_greater_than_Zero() throws ParseException 
	{
		@SuppressWarnings("unchecked")
		List <String> listElements = mock(List.class);		
		fetchValues = new FetchValues();
		StepCustoms = new CustomizeMethods();
		try 
		{
			listElements.add(Mockito.when(listElements.get(0)).thenReturn(fetchValues.getTEXT_1()).toString());
			assertEquals(StepCustoms.valueComparison(listElements.get(0)), true, "Is Not Greater Than '0'");
			listElements.add(Mockito.when(listElements.get(1)).thenReturn(fetchValues.getTEXT_2()).toString());
			assertEquals(StepCustoms.valueComparison(listElements.get(1)), true, "Is Not Greater Than '0'");
			listElements.add(Mockito.when(listElements.get(2)).thenReturn(fetchValues.getTEXT_3()).toString());
			assertEquals(StepCustoms.valueComparison(listElements.get(2)), true, "Is Not Greater Than '0'");
			listElements.add(Mockito.when(listElements.get(3)).thenReturn(fetchValues.getTEXT_4()).toString());
			assertEquals(StepCustoms.valueComparison(listElements.get(3)), true, "Is Not Greater Than '0'");
			listElements.add(Mockito.when(listElements.get(4)).thenReturn(fetchValues.getTEXT_5()).toString());
			assertEquals(StepCustoms.valueComparison(listElements.get(4)), true, "Is Not Greater Than '0'");
		} 
		catch (AssertionError e) 
		{
			ReportLogs.logFailed("Assertion Error " + e.getMessage());
		}				 
	}

	@Test
	@When("Compare the total balance shown on the screen")
	public void compare_the_total_balance_shown_on_the_screen() throws ParseException 
	{	
		@SuppressWarnings("unchecked")
		List <Double> TotalValue = mock(List.class);	
		fetchValues = new FetchValues();
		StepCustoms = new CustomizeMethods();
		Mockito.when(TotalValue.get(0)).thenReturn(StepCustoms.fetchValuesFromString(fetchValues.getTOTAL_TEXT_VALUE()));
		Double storeFinalValue = StepCustoms.conversionValue();
		try 
		{			
			if(TotalValue.get(0) == StepCustoms.conversionValue())
			{			
				assertEquals("$"+String.format("%.02f", storeFinalValue), "$"+String.format("%.02f", TotalValue.get(0)),"Compare the Total Count Vs sum of the counts");    		
	        	ReportLogs.logPassed("PASSED: Sum of counts and Total Count are matched");
	        	String[][] data = 
	    			{
	    				{"TITLE", "EXPECTED RESULT", "ACTUAL RESULT", "STATUS"},
	    				{"Count of Values", "$"+String.format("%.02f", TotalValue.get(0)), "$"+String.format("%.02f", storeFinalValue), "PASSED"}
	    			};
	    		Markup markup = MarkupHelper.createTable(data);
	    		ReportLogs.logPassed(markup.getMarkup());
	    		Reporter.addStepLog(" ------- PASS: Counts are Matched ------- ");    			
	    	}
			else
			{
				assertEquals("$"+String.format("%.02f", storeFinalValue), "$"+String.format("%.02f", TotalValue.get(0)), "Compare the Total Count Vs sum of the counts"); 
	        	String[][] data = 
	    			{
	    				{"TITLE", "EXPECTED RESULT", "ACTUAL RESULT", "STATUS"},
	    				{"Count of Values", "$"+String.format("%.02f", TotalValue.get(0)), "$"+String.format("%.02f", storeFinalValue), "FAILED"}
	    			};
	    		Markup markup = MarkupHelper.createTable(data);
	    		ReportLogs.logFailed(markup.getMarkup());  
			}
	    	   	
	    	Reporter.addScenarioLog("'Compare the total counts vs sum of counts'" + "is Completed"); 
		} 
		catch (AssertionError e) 
		{
			ReportLogs.logFailed("Assertion Error:  " + e.getMessage());
			ReportLogs.logFailed("FAILED: Sum of counts and Total Count are not matched");
        	String[][] data = 
    			{
    				{"TITLE", "EXPECTED RESULT", "ACTUAL RESULT", "STATUS"},
    				{"Count of Values", "$"+String.format("%.02f", TotalValue.get(0)), "$"+String.format("%.02f", storeFinalValue), "FAILED"}
    			};
    		Markup markup = MarkupHelper.createTable(data);
    		ReportLogs.logFailed(markup.getMarkup()); 		  		   	
		}		
	}	
	
	@Test
	@When("Verify the Values are formatted as currencies")
	public void verify_the_Values_are_formatted_as_currencies() throws ParseException 
	{
		@SuppressWarnings("unchecked")
		List <String> compareValue = mock(List.class);	
		fetchValues = new FetchValues();
		StepCustoms = new CustomizeMethods();
		try 
		{
			compareValue.add(Mockito.when(compareValue.get(0)).thenReturn(fetchValues.getTEXT_1()).toString());
			assertEquals(StepCustoms.verifyCurrencyFormat(compareValue.get(0)), true, "Is Not Formatted as Currency");
			compareValue.add(Mockito.when(compareValue.get(1)).thenReturn(fetchValues.getTEXT_2()).toString());
			assertEquals(StepCustoms.verifyCurrencyFormat(compareValue.get(1)), true, "Is Not Formatted as Currency");
			compareValue.add(Mockito.when(compareValue.get(2)).thenReturn(fetchValues.getTEXT_3()).toString());
			assertEquals(StepCustoms.verifyCurrencyFormat(compareValue.get(2)), true, "Is Not Formatted as Currency");
			compareValue.add(Mockito.when(compareValue.get(3)).thenReturn(fetchValues.getTEXT_4()).toString());
			assertEquals(StepCustoms.verifyCurrencyFormat(compareValue.get(3)), true, "Is Not Formatted as Currency");
			compareValue.add(Mockito.when(compareValue.get(4)).thenReturn(fetchValues.getTEXT_5()).toString());
			assertEquals(StepCustoms.verifyCurrencyFormat(compareValue.get(4)), true, "Is Not Formatted as Currency");
			compareValue.add(Mockito.when(compareValue.get(5)).thenReturn(fetchValues.getTOTAL_TEXT_VALUE()).toString());
			assertEquals(StepCustoms.verifyCurrencyFormat(compareValue.get(5)), true, "Is Not Formatted as Currency");
		} 
		catch (AssertionError e) 
		{
			ReportLogs.logFailed("Assertion Error " + e.getMessage());
		}
	}

	@Test
	@Then("Sum the values and validate against the total balance")
	public void sum_the_values_and_validate_against_the_total_balance() throws ParseException 
	{
		@SuppressWarnings("unchecked")
		List <Double> TotalValue = mock(List.class);	
		fetchValues = new FetchValues();
		StepCustoms = new CustomizeMethods();
		Mockito.when(TotalValue.get(0)).thenReturn(StepCustoms.fetchValuesFromString(fetchValues.getTOTAL_TEXT_VALUE()));
		Double storeFinalValue = StepCustoms.conversionValue();
		try 
		{			
			if(TotalValue.get(0) == StepCustoms.conversionValue())
			{			
				assertEquals("$"+String.format("%.02f", storeFinalValue), "$"+String.format("%.02f", TotalValue.get(0)),"Compare the Total Count Vs sum of the counts");    		
	        	ReportLogs.logPassed("PASSED: Sum of counts and Total Count are matched");
	        	String[][] data = 
	    			{
	    				{"TITLE", "EXPECTED RESULT", "ACTUAL RESULT", "STATUS"},
	    				{"Count of Values", "$"+String.format("%.02f", TotalValue.get(0)), "$"+String.format("%.02f", storeFinalValue), "PASSED"}
	    			};
	    		Markup markup = MarkupHelper.createTable(data);
	    		ReportLogs.logPassed(markup.getMarkup());
	    		Reporter.addStepLog(" ------- PASS: Counts are Matched ------- ");    			
	    	}
			else
			{
				assertEquals("$"+String.format("%.02f", storeFinalValue), "$"+String.format("%.02f", TotalValue.get(0)), "Compare the Total Count Vs sum of the counts"); 
	        	String[][] data = 
	    			{
	    				{"TITLE", "EXPECTED RESULT", "ACTUAL RESULT", "STATUS"},
	    				{"Count of Values", "$"+String.format("%.02f", TotalValue.get(0)), "$"+String.format("%.02f", storeFinalValue), "FAILED"}
	    			};
	    		Markup markup = MarkupHelper.createTable(data);
	    		ReportLogs.logFailed(markup.getMarkup());  
			}
	    	   	
	    	Reporter.addScenarioLog("'Compare the total counts vs sum of counts'" + "is Completed"); 
		} 
		catch (AssertionError e) 
		{
			ReportLogs.logFailed("Assertion Error:  " + e.getMessage());
			ReportLogs.logFailed("FAILED: Sum of counts and Total Count are not matched");
        	String[][] data = 
    			{
    				{"TITLE", "EXPECTED RESULT", "ACTUAL RESULT", "STATUS"},
    				{"Count of Values", "$"+String.format("%.02f", TotalValue.get(0)), "$"+String.format("%.02f", storeFinalValue), "FAILED"}
    			};
    		Markup markup = MarkupHelper.createTable(data);
    		ReportLogs.logFailed(markup.getMarkup()); 		  		   	
		}		
	}	
		
	@Test
	@Then("Close the Browser")
	public void close_the_Browser() 
	{
		baseClass = new TestBase();		
		baseClass.closeBrowser();
	}

}

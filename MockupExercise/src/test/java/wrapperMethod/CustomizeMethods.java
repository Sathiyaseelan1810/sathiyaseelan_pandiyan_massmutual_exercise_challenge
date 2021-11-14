package wrapperMethod;


import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.cucumber.listener.Reporter;
import com.test.utils.ReportLogs;

/*    -------------------------------------------------------------
 * 		AUTHOR: Sathiyaseelan Pandiyan
 * 		AUTHOR EMAIL: seelan.pandiyan@gmail.com* 
 * 
     ------------------------------------------------------------- */

public class CustomizeMethods extends FetchValues
{	
	FetchValues fetchvalues = new FetchValues();
	
	/*
	 * Note: The following function has been created to store the values in the same order which has been scrapperd from the UI (Screenshot.PPTX)
	 */	
	public HashMap<String, String> countValues()
	{
		HashMap<String, String> fetchValues = new LinkedHashMap<String, String>();
		try 
		{
			fetchValues.put(fetchvalues.getLABEL_1(), fetchvalues.getTEXT_1());
			fetchValues.put(fetchvalues.getLABEL_2(), fetchvalues.getTEXT_2());
			fetchValues.put(fetchvalues.getLABEL_3(), fetchvalues.getTEXT_3());
			fetchValues.put(fetchvalues.getLABEL_4(), fetchvalues.getTEXT_4());
			fetchValues.put(fetchvalues.getLABEL_5(), fetchvalues.getTEXT_5());					
		} 
		catch (Exception e) 
		{
			Reporter.addStepLog("Unable to add those data's in Hashmap "+ e.getMessage());
		}
		return fetchValues;		
	}
	
	/*
	 * Note: The following function has been created to convert the string value to double for comparison and store the total counts as sum
	 */
	public Double conversionValue() throws ParseException
	{
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		Double storeValues = 0.00;
		List <String> keyValues = new ArrayList<String>();
		for(String values: countValues().keySet())		
			keyValues.add(countValues().get(values));		
		for(int i=0; i<keyValues.size(); i++)
		{						
			Double Values = format.parse(keyValues.get(i)).doubleValue();
			storeValues+=Values;
		}		
		return storeValues;	
	}
	
	/*
	 * Note: The following function has been created to convert the string value to double for comparison of each webelements text
	 */
	public boolean valueComparison(String stubValues) throws ParseException
	{
		boolean result = true; 
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);		
		Double doubleNumber = format.parse(stubValues).doubleValue();
		if(doubleNumber > 0)
		{					
			String[][] data = 
    			{
    				{"VALUE", "RESULT", "STATUS"},
    				{""+stubValues, "is Greater than '0'", "PASSED"}
    			};
    		Markup markup = MarkupHelper.createTable(data);
    		ReportLogs.logPassed(markup.getMarkup());
    		result = true;
		}
		else
		{				
			String[][] data = 
    			{
    				{"VALUE", "RESULT", "STATUS"},
    				{""+stubValues, "is Not Greater than '0'", "FAILED"}
    			};
    		Markup markup = MarkupHelper.createTable(data);
    		ReportLogs.logFailed(markup.getMarkup());
    		result = false;
		}
		return result;
	}
	
	/*
	 * Note: The following function has been created to convert the string value to double for comparison
	 */
	public double fetchValuesFromString(String value) throws ParseException
	{
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);		
		Double doubleNumber = format.parse(value).doubleValue();
		return doubleNumber;
	}
	
	/*
	 * Note: The following function has been created to compare the format as mentioned in currency
	 */
	public boolean verifyCurrencyFormat(String Value)
	{		
		boolean format = true;			
		Pattern pattern = Pattern.compile("^\\$\\d{1,3}\\.[0-9]{2}$|^\\$(\\d{1,3},)+\\d{3}\\.[0-9]{2}$");
		Matcher matcher = pattern.matcher(Value);
		boolean matchFound = matcher.find();	
		if(matchFound)	
		{					
			String[][] data = 
    			{
    				{"VALUE", "RESULT", "STATUS"},
    				{Value, "is Formatted as Currency", "PASSED"}
    			};
    		Markup markup = MarkupHelper.createTable(data);
    		ReportLogs.logPassed(markup.getMarkup());
    		format = matchFound;
		}
		else
		{				
			String[][] data = 
    			{
    				{"VALUE", "RESULT", "STATUS"},
    				{Value, "is Not Formatted as Currency", "FAILED"}
    			};
    		Markup markup = MarkupHelper.createTable(data);
    		ReportLogs.logFailed(markup.getMarkup());
    		format = matchFound;
		}						
		return format;	
	}
	

			
}

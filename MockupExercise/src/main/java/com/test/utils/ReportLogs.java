package com.test.utils;

import com.cucumber.listener.Reporter;

/*@author SATHIYASEELAN
 * 
 * Note: Implmeneted the Extent Library and modified to show them as passed / failed based on the test steps
 *
 */
public class ReportLogs
{
	public static void logPassed(String stepName)
	{
		Reporter.addStepLog("<b><font color='green'>" + stepName + "</b></font>");
	}
	
	public static void logFailed(String stepName)
	{
		Reporter.addStepLog("<b><font color='red'>" + stepName + "</b></font>");
	}

}

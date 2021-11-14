package com.test.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.test.utils.TestBase;

/*
 * Note: This File has been created to store the web elements identified in the given UI(Screenshot.pptx)
 * 
 * Approach: Page Factory.
 */

public class HomePage extends TestBase
{
	//Page Factory for Label Value fields::
	@FindBy(how = How.ID, using = "lbl_val_1")
	  WebElement labelValue1;
	
	@FindBy(how = How.ID, using = "lbl_val_2")
	  WebElement labelValue2;
	
	@FindBy(how = How.ID, using = "lbl_val_3")
	  WebElement labelValue3;
	
	@FindBy(how = How.ID, using = "lbl_val_4")
	  WebElement labelValue4;
	
	@FindBy(how = How.ID, using = "lbl_val_5")
	  WebElement labelValue5;
	
	//Page Factory for text value fields::
	@FindBy(how = How.ID, using = "txt_val_1")
	  WebElement textValue1;
	
	@FindBy(how = How.ID, using = "txt_val_2")
	  WebElement textValue2;
	
	@FindBy(how = How.ID, using = "txt_val_4")
	  WebElement textValue3;
	
	@FindBy(how = How.ID, using = "txt_val_5")
	  WebElement textValue4;
	
	@FindBy(how = How.ID, using = "txt_val_6")
	  WebElement textValue5;
	
	//Page Factory For Label Total::
	@FindBy(how = How.ID, using = "lbl_ttl_val")
	  WebElement labelTotalValue;
	
	//Page Factory for Text Total::
	@FindBy(how = How.ID, using = "txt_ttl_val")
	  WebElement textTotalValue;
	
	//Initializing the page objects declared above as webelement
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Store the webelement for Step Definitions
	public List<WebElement>  totalListWebElements()
	{
	    List<WebElement> webElementList = new ArrayList<WebElement>();
	    webElementList.add(textValue1);
	    webElementList.add(textValue2);
	    webElementList.add(textValue3);
	    webElementList.add(textValue4);
	    webElementList.add(textValue5);
	    return webElementList;	   
	}
	
	
}

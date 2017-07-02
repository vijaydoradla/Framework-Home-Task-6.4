package com.flight.FrmaeworkTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchResultsPage {

	WebDriver driver;

	public FlightSearchResultsPage(WebDriver driver) {
		this.driver = driver;

	}

	// private static final String currencyType="kr";
	private static final String outboundCurrencyType_Txt = "//span[text()='16 Jul']/ancestor::div[1]//span[@class='price price-sek']//span[@class='before']";
	private static final String outboundPrice_Txt = "//span[text()='16 Jul']/ancestor::div[1]//span[@class='price price-sek']//span[@class='major']";

	private static final String returnFlightTicketCurrencyType_Txt = "//span[text()='28 Jul']/ancestor::div[1]//span[@class='price price-sek']//span[@class='before']";
	private static final String returnFlightTicketPrice_Txt = "//span[text()='28 Jul']/ancestor::div[1]//span[@class='price price-sek']//span[@class='major']";

	@FindBy(xpath = outboundCurrencyType_Txt)
	private WebElement outboundCurrencyType;

	@FindBy(xpath = outboundPrice_Txt)
	private WebElement outboundPrice;

	@FindBy(xpath = returnFlightTicketCurrencyType_Txt)
	private WebElement returnCurrencyType;

	@FindBy(xpath = returnFlightTicketPrice_Txt)
	private WebElement returnPrice;

	public String getOutboundFlightsDetails() {
		String outbondFlightTicketCurrencyType = outboundCurrencyType.getText();
		String outbondFlightTicketPrice = outboundPrice.getText();
		String outbondTicketPrice = outbondFlightTicketCurrencyType + outbondFlightTicketPrice;
		return outbondTicketPrice;

	}

	
	
	
	public String getReturnFlightsDetails() {
		String returnFlightCurrencyType = returnCurrencyType.getText();
		String returnFlightPrice = returnPrice.getText();
		String returnTicketPrice = returnFlightCurrencyType + returnFlightPrice;
		return returnTicketPrice;

	}

}//

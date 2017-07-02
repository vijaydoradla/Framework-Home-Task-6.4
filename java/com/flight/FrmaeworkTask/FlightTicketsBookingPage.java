package com.flight.FrmaeworkTask;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class FlightTicketsBookingPage {
	WebDriver driver;

	public FlightTicketsBookingPage(WebDriver driver) {
		this.driver = driver;

	}

	private static final String cookiePolicyAccept_Btn = "//button[text()='Accept & Close']";
	private static final String depature_Input = "origin";
	private static final String destination_ImgBtn = "//label[text()='To:']/following-sibling::a";
	private static final String destination_CityBtn = "//a[text()='London (All Airports)']";
	private static final String departureDatePicker_Btn = "//div[contains(text(),'Departing')]/following-sibling::a";
	private static final String departureDate_Btn = "//h3[contains(text(),'July 2017')]/following-sibling::div//a/span[text()='16']";

	private static final String returnDatePicker_Btn = "//div[contains(text(),'Returning')]/following-sibling::a";
	private static final String returnDateNumber_Btn = "//h3[contains(text(),'July 2017')]/following-sibling::div//a/span[text()='28']";
	private static final String adultsPassengersQuantity_Txt = "//input[@name='Adults']";
	private static final String addChildPassengers_Btn = "//div[@passenger-label='Children (2-15)']//button[@class='quantity-button-add']";
	private static final String childrensPassengersQuantity_Txt = "Children";

	private static final String showFlights_Btn = "//button[text()='Show flights']";

	@FindBy(xpath = cookiePolicyAccept_Btn)
	private WebElement cookiePolicyAcceptBtn;

	@FindBy(name = depature_Input)
	private WebElement fromInput;

	@FindBy(xpath = destination_ImgBtn)
	private WebElement destinationImgBtn;

	@FindBy(xpath = destination_CityBtn)
	private WebElement destinationCity;

	@FindBy(xpath = departureDatePicker_Btn)
	private WebElement departureDatePickerBtn;

	@FindBy(xpath = departureDate_Btn)
	private WebElement departureDateBtn;

	@FindBy(xpath = returnDatePicker_Btn)
	private WebElement returnDatePickerBtn;

	@FindBy(xpath = returnDateNumber_Btn)
	private WebElement returnDateNumberBtn;

	@FindBy(xpath = adultsPassengersQuantity_Txt)
	private WebElement adultsPassengersQuantityTxt;

	@FindBy(xpath = addChildPassengers_Btn)
	private WebElement childerensTicketsAddBtn;

	@FindBy(xpath = childrensPassengersQuantity_Txt)
	private WebElement childrensPassengersQuantityTxt;

	@FindBy(xpath = showFlights_Btn)
	private WebElement showFlightsBtn;

	public void cookiePolicyPopup() {
		if (cookiePolicyAcceptBtn.isDisplayed()) {
			cookiePolicyAcceptBtn.click();

		}
	}

	public void orginCity(String departureCity) throws Exception {
		fromInput.click();
		fromInput.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		fromInput.sendKeys(departureCity);
		fromInput.sendKeys(Keys.ENTER);
		
	}

	
	


	public void destinationAirport() throws Exception {
		destinationImgBtn.click();
		destinationCity.click();

	}

	
	public void depatureDate() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(departureDatePickerBtn));		
		Actions actions = new Actions(driver);
		//actions.click(departureDatePickerBtn);
		actions.moveToElement(departureDatePickerBtn);
		Thread.sleep(2000);
		actions.click().build().perform();
		Thread.sleep(2000);
		actions.moveToElement(departureDateBtn);
		Thread.sleep(2000);
		actions.click().build().perform();

	}

	public void returnDate() throws Exception {
       
		Actions actions = new Actions(driver);
		actions.moveToElement(returnDatePickerBtn);
		Thread.sleep(2000);
		actions.click().build().perform();
		Thread.sleep(2000);
		actions.moveToElement(returnDateNumberBtn);
		Thread.sleep(2000);
		actions.click().build().perform();

	}

	public void addChildPassenger() {
		childerensTicketsAddBtn.click();

	}

	public void showFlights() {
		showFlightsBtn.click();

	}

	public String getDepatureCity() {
		String depatureAirport = fromInput.getAttribute("value");
		return depatureAirport;

	}

	public int defaultSelectedAdultsTickets() {
		String adultsTickets = adultsPassengersQuantityTxt.getAttribute("value");
		int ticketbyDefault = Integer.parseInt(adultsTickets);

		return ticketbyDefault;

	}
	
	


}//







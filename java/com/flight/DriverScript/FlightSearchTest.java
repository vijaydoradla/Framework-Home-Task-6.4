package com.flight.DriverScript;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.flight.FrmaeworkTask.FlightSearchResultsPage;
import com.flight.FrmaeworkTask.FlightTicketsBookingPage;
public class FlightSearchTest  {
	WebDriver driver;
	private static final String applicationURL = "https://www.easyjet.com/en/";
	private static final String departureCity = "Stockholm";
	private static final int adultsDisplayedTickets = 1;
	private static final String currencyType = "kr";

	@Test
	
	public void flightTicketsBooking() throws Exception {
		
		FlightTicketsBookingPage ticketsBookingPage = PageFactory.initElements(driver, FlightTicketsBookingPage.class);
		// Closing Cookie policy Pop up
		ticketsBookingPage.cookiePolicyPopup();
		ticketsBookingPage.orginCity(departureCity);	
		ticketsBookingPage.destinationAirport();
		ticketsBookingPage.depatureDate();
		ticketsBookingPage.returnDate();
		Assert.assertEquals(ticketsBookingPage.defaultSelectedAdultsTickets(), adultsDisplayedTickets,
				"Default Adults tickets not match");
		
		ticketsBookingPage.addChildPassenger();		
		ticketsBookingPage.showFlights();

	}

	@Test(dependsOnMethods = { "flightTicketsBooking" })
	public void verifyingSearchResults() throws Exception {

		FlightSearchResultsPage flightSearchResultsPage = PageFactory.initElements(driver,
				FlightSearchResultsPage.class);

		Assert.assertTrue(flightSearchResultsPage.getOutboundFlightsDetails().contains(currencyType),
				"Outbound Flights details not contain prices details");
		
		Assert.assertTrue(flightSearchResultsPage.getReturnFlightsDetails().contains(currencyType),
				"Return Flights details not contain prices details");

	}

	
	@BeforeClass
	public void launchBrowser() {
		    
		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(applicationURL);
       	
	}

	

	@AfterClass
	public  void closeWebBrowser(){
        if (null != driver){
        	driver.quit();
        
        }
        driver = null;
    }
	
	

	   
	   
}//

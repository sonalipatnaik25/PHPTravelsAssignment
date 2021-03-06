package StepDefinitions;

import PageObjects.HotelSearchPage;
import PageObjects.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import StepDefinitions.common.base;

@RunWith(Cucumber.class)
public class HotelSearchStepDefinition extends base {

    @Given("^user clicks on the hotel Search tab$")
    public void and_user_clicks_on_the_hotel_Search_tab() throws Throwable {
        landingPage.clickHotelTab().click();
    }

    @Given("^The user enters the destination \"([^\"]*)\", \"([^\"]*)\" date, \"([^\"]*)\" date, \"([^\"]*)\" adult, \"([^\"]*)\" child$")
    public void the_user_enters_the_destination_date_date_adult_child(String hotelCityName, String checkindate, String checkoutdate, int numberOfAdults, int numberOfKids) throws Throwable {
        landingPage.searchHotelsPrepare(hotelCityName, checkindate, checkoutdate, numberOfAdults, numberOfKids);
    }

    @When("^the user clicks in the search button$")
    public void the_user_clicks_in_the_search_button() throws Throwable {
        landingPage.getHotelSearchButton().click();
    }

    @Then("^The user is redirected to hotel search results")
    public void the_user_is_redirected_to_hotel_search_results() throws Throwable {
        hotelSearchPage.confirmHotelSearchResults();
    }

}


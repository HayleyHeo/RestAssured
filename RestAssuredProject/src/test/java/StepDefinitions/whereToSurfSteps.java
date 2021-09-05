package StepDefinitions;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import main.weatherbit;
import pojo.Datum;
import pojo.Weatherbit;

public class whereToSurfSteps extends weatherbit{

	
	
	@Given("An user try to find where to surf in Sydney")
	public void user_sets_the_base_the_base() {
		
		
	}
	
	@Given("I look up the the weather forecast with {int}")
	public void i_look_up_the_the_weather_forecast_with(Integer postal_code) {
		weather = getWeather(postal_code);
	}

	@Given("I only like to surf on Monday and Friday in next 16 days")
	public void i_only_like_to_surf_on_monday_and_friday_in_next_days() throws ParseException {
		List<Integer> mondayFriday = getAvailableDate();
		System.out.println(mondayFriday.toString());
		

	}
	@When("I like to surf in any of two beaches Out of top ten of Sydney")
	public void i_like_to_surf_in_any_of_two_beaches_out_of_top_ten_of_sydney() {
		
	}

	@Then("I check to if see the temperature is between {int} and {int}")
	public void i_check_to_if_see_the_temperature_is_between_and(Integer low, Integer high) throws ParseException {	
		List<Integer> goodTempDay = filterGoodTemparature(mondayFriday,low,high);
		System.out.println(goodTempDay);
		//return goodTempDay;
	}

	@Then("I check wind speed to be between {int} and {int}")
	public void i_check_wind_speed_to_be_between_and(Integer low, Integer high) {
		List<Integer> goodWindDay = filterGoodWind(goodTempDay,low,high);
		System.out.println(goodWindDay);
		//return goodWindDay;
	}

	@Then("I check to see if UV index is equal or less than {int}")
	public void i_check_to_see_if_uv_index_is_equal_or_less_than(Integer UVIndex) {
		List<Integer> lessUVDay = filterLessUV(goodWindDay,UVIndex);
		System.out.println(lessUVDay);
	}

	@Then("I Pick best suitable spot out of top two spots based upon suitable weather forecast for the day")
	public void i_pick_best_suitable_spot_out_of_top_two_spots_based_upon_suitable_weather_forecast_for_the_day() {
		System.out.println("*********"+lessUVDay.size() + " & post code is "+ postcode);
	}



}

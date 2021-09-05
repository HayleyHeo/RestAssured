package main;
import static io.restassured.RestAssured.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import pojo.Weatherbit;

public class weatherbit {

	protected static List<Integer> mondayFriday = new ArrayList<Integer>();
	protected static List<Integer> goodTempDay = new ArrayList<Integer>();
	protected static List<Integer> goodWindDay = new ArrayList<Integer>();
	protected static List<Integer> lessUVDay = new ArrayList<Integer>();
	protected static Weatherbit weather = new Weatherbit();
	protected static Integer postcode;
	
	public static Weatherbit getWeather(Integer postal_code) {
		baseURI = "https://api.weatherbit.io/v2.0"; 
		
		Weatherbit weather = 
		
				 given(). 
				   
				  param("key", "a4701061c8cc4e9ca0197491f04a0e56").
				  //param("city", "Sydney").
				  //param("country", "AU"). 
				  param("postal_code", postal_code).
				  when(). 
				  get("/forecast/daily").as(Weatherbit.class);
				 
		postcode = postal_code;
        return weather;
    }
	
	public static List<Integer> getAvailableDate() throws ParseException {
		mondayFriday.clear();
		//Weatherbit weather = getWeather();
		int size =weather.getData().size();
		
		
		
		for(int i = 0; i < size; i++) {  

			String datetime = weather.getData().get(i).datetime;


			  SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
			  Date dt1=format1.parse(datetime);

		
			String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

			  Calendar c = Calendar.getInstance();
			  c.setTime(dt1); //set the date
			  int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // Sun=1, Mon=2, ... Sat=7
  
			  if((weeks[dayOfWeek-1] == "Monday") || (weeks[dayOfWeek-1] == "Friday")) {
				  
				  mondayFriday.add(i);
			  }
		}
		
		return mondayFriday;

	}
	@Test
	public static List<Integer> filterGoodTemparature(List<Integer> dayID, Integer low, Integer high) { 
		  
		goodTempDay.clear();
		  
	      int i, x = 0;

	      for (i = 0; i < dayID.size(); i++) {

	          x = dayID.get(i);
	          
		  double high_temp = weather.getData().get(x).high_temp;
		  double low_temp = weather.getData().get(x).low_temp;
		  double temp = weather.getData().get(x).temp;
		  
		  if((temp>=low) && (temp<=high) && (low_temp>=low) && (high_temp<=high)) {
			  //System.out.println("The best weather is : "+weather.getData().get(x).datetime); 
			  Collections.addAll(goodTempDay, x);
		  	} 
		  }
	      
	      //System.out.println(x);
		return goodTempDay;
		  
	      }
	@Test
	public static List<Integer> filterGoodWind(List<Integer> dayID, Integer low, Integer high) { 
		  
		goodWindDay.clear();
		
	      int i, x = 0;

	      for (i = 0; i < dayID.size(); i++) {

	          x = dayID.get(i);
	          
		  double wind_spd = weather.getData().get(x).wind_spd;
		  
		  if((wind_spd>=low) && (wind_spd<=high)) {
			  //System.out.println("The good wind is : "+weather.getData().get(x).datetime); 
			  Collections.addAll(goodWindDay, x);
		  	} 
		  }
	      
	      //System.out.println(x);
		return goodWindDay;
		  
	      }
	public static List<Integer> filterLessUV(List<Integer> dayID, Integer UVIndex) { 
		  
		lessUVDay.clear();

	      int i, x = 0;

	      for (i = 0; i < dayID.size(); i++) {

	          x = dayID.get(i);
	          
		  double uv = weather.getData().get(x).uv;
		  //System.out.println(uv);
		  
		  if(uv<=UVIndex) {
			  //System.out.println("The less UV day is : "+weather.getData().get(x).datetime); 
			  Collections.addAll(lessUVDay, x);
		  	} 
		  }
	      
	      //System.out.println(x);
		return lessUVDay;
		  
	      }

}

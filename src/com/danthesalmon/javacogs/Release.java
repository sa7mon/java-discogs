package com.danthesalmon.javacogs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Release
{
   //  VARIABLES
   // http://www.discogs.com/developers/#page:database,header:database-release-get
   private String strTitle = "";
   private Integer intId = 0;
   private String strDataQuality = "";
   private String strStatus = "";
   private String strUri = "";
   private String strCompanies = "";
   private String strCountry = "";
   private Integer intMasterId = 0;
   private JSONObject jsonObject;
   private ArrayList<String> arrGenres = new ArrayList<String>();
   
   // Default constructor method
   public Release(String releaseID)
   {
      // Create new JSONParser object
      JSONParser parser = new JSONParser();
      
      try {
         // Get the JSON response
         RestGet releaseResponse = new RestGet("https://api.discogs.com/releases/"+releaseID);
         
         // DEBUG Output full JSON response
         System.out.println("Response: "+releaseResponse.toString());
         
         // Create an object
         Object obj = parser.parse(releaseResponse.toString());

         // Create a JSONObject of the generic Object obj
         jsonObject = (JSONObject) obj;
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
   
      /////-------GET VALUES--------
         
      // Get value: Country
      strCountry = (String) jsonObject.get("country");
      
      // Get value: DataQuality
      strDataQuality = (String) jsonObject.get("data_quality");
      
      // Get values: Genres      
      JSONArray jsonArray = (JSONArray) jsonObject.get("genres"); 
      arrGenres = toArrayList(jsonArray);
      
      // Get value: ID
      intId = (Integer) Integer.parseInt(jsonObject.get("id").toString());
      
      // Get value: master_id
      intMasterId = (Integer) Integer.parseInt(jsonObject.get("master_id").toString());
         
      // Get value: title
      strTitle = (String) jsonObject.get("title");
   
   } // End constructor method

   //  GENERAL PURPOSE METHODS
   private ArrayList <String> toArrayList(JSONArray jsArray) {
      // Takes a JSONArray object and returns an arrayList of various types.
      
      ArrayList<String> arrStrings = new ArrayList<String>();
      
      if (jsArray != null) { 
         int len = jsArray.size();
         for (int i=0;i<len;i++){ 
            arrGenres.add(jsArray.get(i).toString());
            System.out.println(jsArray.get(i).toString());
         } 
      }
      return arrStrings;
   }
   
   //  SETTERS
   
   //  GETTERS
   public String getCountry() {
      return this.strCountry;
   }
   public Integer getMasterId() {
      return this.intMasterId;
   }
   public String getTitle() {
      return this.strTitle;
   }
   public Integer getID(){
      return this.intId;
   }
   public String getDataQuality() {
	   return this.strDataQuality;
   }
   public String getCompanies() {
	   return this.strCompanies;
   }
   public ArrayList getGenres() {
      return this.arrGenres;
   }
   public String getUri() {
      return strUri;
   }
}

package com.danthesalmon.javacogs;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Release
{
   //  VARIABLES
   // http://www.discogs.com/developers/#page:database,header:database-release-get
   private String title = "";
   private Integer id = 0;
   private String dataQuality = "";
   private String status = "";
   
   // Default constructor method
   public Release(String releaseID)
   {
      // Create new JSONParser object
      JSONParser parser = new JSONParser();
      
      try {
         // Get the JSON response
         String jsonResp = ClsRest.httpGet("https://api.discogs.com/releases/"+releaseID);
         System.out.println("Response: "+jsonResp);
         
         // Create an object
         Object obj = parser.parse(jsonResp);

         JSONObject jsonObject = (JSONObject) obj;

         title = (String) jsonObject.get("title");
         //id = (Integer) jsonObject.get("id").toString();
         dataQuality = (String) jsonObject.get("data_quality");
         
         // loop array
         //JSONArray msg = (JSONArray) jsonObject.get("messages");
         //Iterator<String> iterator = msg.iterator();
         //while (iterator.hasNext()) {
           //  System.out.println(iterator.next());
         //}

     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     } catch (ParseException e) {
         e.printStackTrace();
     }
   }

   //  SETTERS
   
   //  GETTERS
   public String getTitle() {
      return this.title;
   }

   public Integer getID(){
      return this.id;
   }
}

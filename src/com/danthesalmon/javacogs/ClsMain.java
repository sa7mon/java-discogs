package com.danthesalmon.javacogs;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.danthesalmon.javacogs.ClsRest;
import com.danthesalmon.javacogs.getRelease;
public class ClsMain
{

   public static void main(String[] args)
   {
      
      getRelease();
      
      JSONParser parser = new JSONParser();
      
      try {
          String jsonResp = ClsRest.httpGet("https://api.discogs.com/releases/249504");
          System.out.println("Response: "+jsonResp);
          
          Object obj = parser.parse(jsonResp);

          JSONObject jsonObject = (JSONObject) obj;

          String meta = (String) jsonObject.get("title");
          System.out.println(meta);

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

}

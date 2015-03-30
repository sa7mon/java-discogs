package com.danthesalmon.javacogs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ClsRest
{
   public static String httpGet(String urlStr) throws IOException {
      URL url = new URL(urlStr);
      HttpURLConnection conn =
          (HttpURLConnection) url.openConnection();
      // Set the User-Agent or Discogs will ignore our request and we'll get a big error.
      conn.setRequestProperty("User-Agent", "Test UA");

      if (conn.getResponseCode() != 200) {
        throw new IOException(conn.getResponseMessage());
      }

      // Buffer the result into a string
      BufferedReader rd = new BufferedReader(
          new InputStreamReader(conn.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = rd.readLine()) != null) {
        sb.append(line);
      }
      rd.close();

      conn.disconnect();
      return sb.toString();
    }

   
      

}


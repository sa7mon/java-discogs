package com.danthesalmon.javacogs;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ClsRest
{
   public static String httpGet(String urlStr) throws IOException {
      URL url = new URL(urlStr);      
      HttpURLConnection conn =
          (HttpURLConnection) url.openConnection();
      
      
      // Set the User-Agent or Discogs will ignore our request and we'll get a big error.
      conn.setRequestProperty("User-Agent", "Test UA");
      System.out.println("Header 1: "+ conn.getHeaderField(0));
      System.out.println("Header 2: "+ conn.getHeaderField(1));
      System.out.println("Server: "+conn.getHeaderField("Server"));
      
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


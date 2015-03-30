/**
 * 
 */
package com.danthesalmon.javacogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 
 *
 */
public class RestGet {
	
	private String strResponse = "";
	private String strUserAgent = "TEST UA";
	private Map<String,List<String>> mapHeaders = new HashMap<String,List<String>>();

	/**
	 * Default constructor method
	 */
	public RestGet(String strUrl) throws IOException {
		URL url = new URL(strUrl);      
	      HttpURLConnection conn =
	          (HttpURLConnection) url.openConnection();
	      
	      // Set the User-Agent or Discogs will ignore our request and we'll get a big error.
	      conn.setRequestProperty("User-Agent", strUserAgent);
	      
	      if (conn.getResponseCode() != 200) {
	    	  throw new IOException(conn.getResponseMessage());
		  }
	      
	      /*for (int i = 0;; i++) {
	          String headerName = conn.getHeaderFieldKey(i);
	          String headerValue = conn.getHeaderField(i);
	          System.out.println(headerName);
	          System.out.println(headerValue);

	          if (headerName == null && headerValue == null) {
	            System.out.println("No more headers");
	            break;
	          }
	       }
	       */
	      
	      mapHeaders = conn.getHeaderFields();
	      
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
	      
	      // Assign the raw JSON output to the string variable.
	      strResponse = sb.toString();
	} // End constructor

	// GETTERS
	public String toString() {
		return this.strResponse;
	}
	public String getUserAgent() {
		return this.strUserAgent;
	}
	public Map<String,List<String>> getHeaders() {
		return this.mapHeaders;
	}
}

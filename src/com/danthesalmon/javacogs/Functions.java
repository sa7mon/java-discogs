package com.danthesalmon.javacogs;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Functions {

	public Functions() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<String> toArrayList(JSONArray jsarray) {
		ArrayList<String> list = new ArrayList<String>();     
		JSONArray jsonArray = (JSONArray)JSONObject; 
		if (jsonArray != null) { 
		   int len = jsonArray.length();
		   for (int i=0;i<len;i++){ 
		    list.add(jsonArray.get(i).toString());
		   } 
		} 
	}

}

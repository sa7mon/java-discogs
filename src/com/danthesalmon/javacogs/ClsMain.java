package com.danthesalmon.javacogs;

import java.util.ArrayList;

public class ClsMain
{
   public static void main(String[] args)
   {
      
      Release release1 = new Release("249504"); 
      System.out.println("Title: " + release1.getTitle());
      System.out.println("ID: " + release1.getID());
      System.out.println("Data Quality" + release1.getDataQuality());
      System.out.println("Companies:" + release1.getCompanies());
      ArrayList <String> genresList = release1.getGenres();
      for(int i=0; i<genresList.size(); i++){
         System.out.println("Genre: " + genresList.get(i));
     }
   }
}

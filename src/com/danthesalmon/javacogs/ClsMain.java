package com.danthesalmon.javacogs;

public class ClsMain
{
   public static void main(String[] args)
   {
      
      Release release1 = new Release("249504"); 
      System.out.println("Title: " + release1.getTitle());
      System.out.println("ID: " + release1.getID());
   }
}

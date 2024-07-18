/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LegalRules;

/**
 *
 * @author Duzie Uche-Abba
 */
public class PriceRules {
    //For certain imported goods from specific countries, we are going to mark up unit price by only 25% or 20% in some cases due to ethical reasons
    public void applyPriceRules(String[] countriesOfOrigin, String [] productNames, String country, String price) throws Exception{
        for(String origin: countriesOfOrigin){
           for(String product: productNames){
                //check if country has value prior to enforcing rules
            if(!country.isEmpty() 
                    || country.equalsIgnoreCase("Please select") 
                    || !product.isEmpty() 
                    || product.equalsIgnoreCase("Please select") 
                    || !price.isEmpty() 
                    || price.equalsIgnoreCase("Please select")
              )
            {
                if(country.equalsIgnoreCase(origin) && Integer.parseInt(price) > 100){
                throw new Exception( "Product imported from " + country + " is sold for not more than $100 per unit, Agreed?");
                }
                if(country.equalsIgnoreCase("Bangladesh") || country.equalsIgnoreCase("Cambodia") && (Integer.parseInt(price) > 50)){
                    throw new Exception( "Product imported from " + country + " is sold for not more than $50, Agreed?");
                }
            } else {
                throw new Exception("You must enter country of origin, price, and product to determine which price to set!");
            }
           }
        }
    }
}

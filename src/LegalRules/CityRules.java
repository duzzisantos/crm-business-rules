/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LegalRules;

/**
 *
 * @author user
 */
public class CityRules {
     //Although we ship to certain states, there are cities we do not deliver to due to logistics reasons
    public void applyCityShippingRules(String [] cities, String providedCity) throws Exception {
        for(String city: cities){
            if(providedCity.equalsIgnoreCase(city)){
                throw new Exception("Due to logistics concerns, we do not ship to this US city.");
            }
        }
    }
}

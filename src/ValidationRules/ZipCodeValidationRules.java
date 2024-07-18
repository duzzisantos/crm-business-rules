/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidationRules;

/**
 *
 * @author user
 */
public class ZipCodeValidationRules {
    
    public void TestZipCode(int zipcode) throws Exception {
        
        //use a logarithmic approach
        int length = (int)(Math.log10(zipcode) + 1);
        
        if(length != 5){
            throw new Exception("US Zip Code must contain 5 digits");
        }
    }
}

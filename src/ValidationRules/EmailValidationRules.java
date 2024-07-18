/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidationRules;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Duzie Uche-Abba
 * description: This rule tests email addresses to check if they are valid. It also keeps in mind that email addresses can have double
 * TLDs. Eg: ben@nowhere.somewhere.net. We do not desire that users input whatever data they desire. It would ruin the essence of the R in CRM.
 */
public class EmailValidationRules {
    
    public void TestEmailAddress(String email) throws Exception {
        
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
        
        Pattern test = Pattern.compile(emailPattern);
        
        Matcher match = test.matcher(email);
        
        if(!match.find()){
            throw new Exception("This is not a valid email address");
        }
    }
}

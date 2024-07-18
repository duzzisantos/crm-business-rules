/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LegalRules;

/**
 *
 * @author user
 */
public class StateRules {
    
    //There are US states we don't ship to for logistics reasons
    public void applyStateShippingRules(String [] statesList ,String usState) throws Exception{
    
        for(String state: statesList){
            if(usState.equalsIgnoreCase(state)){
                throw new Exception("Due to logistics concerns, we do not ship to this US State.");
            }
        }
}
    
   
}

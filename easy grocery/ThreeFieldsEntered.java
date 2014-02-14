
/**
 * Write a description of class ThreeFieldsEntered here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThreeFieldsEntered implements PhoneNumberState
{
    PhoneNumberStateMachine machine;
    
    public ThreeFieldsEntered(){
    }
    
    public ThreeFieldsEntered(PhoneNumberStateMachine machine){
        this.machine=machine;
    }
    
    public void backspace(){
       machine.setStateTwoFieldsEntered(null);
    }
    
   public void number( String digit ) {
    }
    
   public boolean validPin(String digit){
        if(digit.length()==4){
            return true;
        }
                    return false;
    }
    
   public void invalidPin(){
       System.out.println("Invalid phone number, Enter four digits Code");
       machine.setStateNoFieldEntered();
    }
}

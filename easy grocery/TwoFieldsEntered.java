
/**
 * Write a description of class TwoFieldsEntered here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwoFieldsEntered implements PhoneNumberState
{
   PhoneNumberStateMachine machine;
   
   public TwoFieldsEntered(){
   }
    
   public TwoFieldsEntered(PhoneNumberStateMachine machine){
       this.machine=machine;
   }
   
   public void backspace(){
       machine.setStateOneFieldEntered(null);
    }
    
   public void number( String digit ) {
       machine.setStateThreeFieldsEntered(digit);
    }
    
   public boolean validPin(String digit){
        if(digit.length()==3){
            return true;
        }
                    return false;
    }
    
   public void invalidPin() {
       System.out.println("Invalid phone number, Enter three digits Code");
       machine.setStateOneFieldEntered(null);
    }
}

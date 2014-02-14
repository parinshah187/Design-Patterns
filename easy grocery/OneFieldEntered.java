
/**
 * Write a description of class OneFieldEntered here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OneFieldEntered implements PhoneNumberState
{
   PhoneNumberStateMachine machine;
    
    public OneFieldEntered(){
    }
    
    public OneFieldEntered(PhoneNumberStateMachine machine){
        this.machine=machine;
    }
    
    public void backspace() {
        machine.setStateNoFieldEntered();
    }
    
    public void number( String digit ){
        machine.setStateTwoFieldsEntered(digit);
    }
    
    public boolean validPin(String digit){
        if(digit.length()==3){
            return true;
        }
        return false;
    }
    
    public void invalidPin(){
        System.out.println("Invalid Area Code, Enter three digits Code");
        machine.setStateNoFieldEntered();
    }
}

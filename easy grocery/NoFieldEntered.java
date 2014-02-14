
/**
 * Write a description of class NoFieldEntered here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NoFieldEntered implements PhoneNumberState
{
   PhoneNumberStateMachine machine;
    
    public NoFieldEntered(){
    }
    
    public NoFieldEntered(PhoneNumberStateMachine machine){
        this.machine=machine;
    }
    
    public void backspace() {
    }
    
    public void number( String digit ){
        machine.setStateOneFieldEntered(digit);
    }
    
    public boolean validPin(String digit){
        return true;
    }
    
    public void invalidPin(){
    }
}

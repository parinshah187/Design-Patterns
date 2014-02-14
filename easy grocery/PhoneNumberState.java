
/**
 * Write a description of interface PhoneNumberState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface PhoneNumberState
{
    public void backspace() ;
    public void number( String digit ) ;
    public boolean validPin(String digit) ;
    public void invalidPin() ;
}

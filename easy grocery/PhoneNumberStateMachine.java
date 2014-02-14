
/**
 * Write a description of interface PhoneNumberStateMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface PhoneNumberStateMachine
{
   void backspace() ;
   void type( int digit ) ;
   boolean validPin(String digit) ;
   void invalidPin() ;

   void setStateNoFieldEntered() ;
   void setStateOneFieldEntered( String digit ) ;
   void setStateTwoFieldsEntered( String digit ) ;
   void setStateThreeFieldsEntered( String digit ) ;
}

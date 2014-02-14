
/**
 * Write a description of class Pin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pin
{
    
    private String secretPin = "(123)456-7890" ;
    private boolean authenticated = false ;
    private static Pin instance ;

    private Pin()
    {
    }

    public static Pin getInstance() {
        if (instance == null) {
            instance = new Pin();
        }
        return instance;
    }

    public boolean isAuthenticated()
    {
        return this.authenticated ;
    }
    
    public void validate( String pinInput ) 
    {
        if ( secretPin.equals(pinInput) )
        {
            this.authenticated = true ;
            System.out.println( "Valid Pin" ) ;
            System.out.println("Now please choose a payment method.");
        }
        else
        {
            this.authenticated = false ;
            System.out.println( "Invalid Pin" ) ;
            System.out.println("Please type pin again");
        }
    }
}

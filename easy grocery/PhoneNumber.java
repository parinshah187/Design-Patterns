
/**
 * Write a description of class PhoneNumber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhoneNumber implements PhoneNumberObserver
{
    private int num_digits ;

    public PhoneNumber()
    {
        this.num_digits = 0 ;
    }

     public String display()
    {
        String str ;
        switch( num_digits )
        {
            case 0: str = "(_ _ _) _ _ _ - _ _ _ _" ; break ;
            case 1: str = "(123) _ _ _ - _ _ _ _" ; break ;
            case 2: str = "(123) 456 - _ _ _ _" ; break ;
            case 3:  str = "(123) 456 - 7890 " ;  break ;
            default: str = "_ _ _ _ _ _ _ _ _ _" ;
        }
        System.out.println( str ) ;
        return str ;    
    }
     
    public void update(int count)
    {
        this.num_digits = count ;
        display() ;
        //if( this.num_digits == 3)System.out.println("THANK YOU");
    }
}


/**
 * Write a description of interface PhoneNumberSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface PhoneNumberSubject
{
    void registerObserver( PhoneNumberObserver obj ) ;
    void removeObserver( PhoneNumberObserver obj ) ;
    void notifyObservers( ) ;
}

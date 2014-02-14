
/**
 * Write a description of interface PaymentHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface PaymentHandler
{
    void makePayment();
    void setNext(PaymentHandler next);
}

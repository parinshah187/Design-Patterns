
/**
 * Write a description of class CashHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CashHandler implements PaymentHandler
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class CashHandler
     */
    private PaymentHandler next;
    public int PaymentMode; // 1-> Online (Credit / Debit) 2 -> On pick-up
    public CashHandler()
    {
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void makePayment(){
        System.out.println("In makePayment() of CashHandler");
        System.out.println("Okay, you can pay when you come to pick-up");
    }
    public void setNext(PaymentHandler p){
        next = p;
    }
}

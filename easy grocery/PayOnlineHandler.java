
/**
 * Write a description of class PayOnlineHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PayOnlineHandler implements PaymentHandler
{
    // instance variables - replace the example below with your own
    private PaymentHandler next;
    private CashHandler cash = new CashHandler();
    public int PaymentMode; // 1-> Online (Credit / Debit) 2 -> On pick-up
    
    /**
     * Constructor for objects of class PayOnlineHandler
     */
    public PayOnlineHandler()
    {
        // initialise instance variables
    }
    
    public void makePayment(){
        int PaymentMethodId = this.PaymentMode;
        System.out.println("In makePayment() of PayOnlineHandler");
        if(PaymentMethodId==1){
            System.out.println("Your payment was successful through online account registered with us !");
        }
        else{
            this.setNext(next);
        }
    }
    public void setNext(PaymentHandler p){
       // next = p;
            System.out.println("Jumping to makePayment() of CashHandler");
            next = cash;
            cash.PaymentMode=2;
            this.next.makePayment();
    }
}

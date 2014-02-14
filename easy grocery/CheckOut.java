import java.util.ArrayList;

public class CheckOut implements GroceryScreen, PhoneNumberSubject, PhoneNumberStateMachine
{
  
     private GroceryController gc;
    // Pin Domain Object
    private Pin pin ;
    private int numCount=0 ;
    
    // pin machine states
    private NoFieldEntered field0 ;
    private OneFieldEntered field1 ;
    private TwoFieldsEntered field2 ;
    private ThreeFieldsEntered field3 ;

    // current state
    private PhoneNumberState state ;

    // pin captured so far
    private String str1="", str2="", str3="" ;

    // Observers
    private ArrayList<PhoneNumberObserver> observers ;
    
    //chain of responsibility pattern handlers
    private PayOnlineHandler online = new PayOnlineHandler();
    
    public CheckOut()
    {
        gc = GroceryController.getInstance();
        observers = new ArrayList<PhoneNumberObserver>() ;
        field0 = new NoFieldEntered( this ) ;
        field1 = new OneFieldEntered( this ) ;
        field2 = new TwoFieldsEntered( this ) ;
        field3 = new ThreeFieldsEntered( this ) ;
        this.state = field0 ;
        this.pin = Pin.getInstance() ;
    }
    
   public void display()
   {
       System.out.println("\n------->  Check Out <------");
       System.out.println("Enter your contact no. ");
       System.out.println(" (___) ___ - ____ ");
       System.out.println(" \n");
       System.out.println(" How would you like to pay?");
       System.out.println(" (_) Pay Online ");
       System.out.println(" (_) Pay on Pick-up ");
       System.out.println("\n");
       System.out.println("-----| PLACE ORDER |---- \n");
       System.out.println("{type(123) -> for each  text box" );
       System.out.println("touch(1) -> Pay online,\n touch(2) -> Pay on pick up");
       System.out.println("touch(3) - > place order}");
   }
   public void touch(int i)
   {
       if(Pin.getInstance().isAuthenticated())
       {
           if(i==1){
               System.out.println("Online payment mode selected !");
               online.PaymentMode=1;
               
           }
           else if(i==2){
               System.out.println("Payment on pick-up requested");
               online.PaymentMode=2;
           }
           else if(i!=3){
               System.out.println("Wrong payment method selected !");
            }
           if(i==3){
               System.out.println("Checkout Button pressed!");
               this.placeOrder();
           }
        }
        else
        {
            System.out.println("Please type a correct contact number first then choose a payment method");
        }
    
    }
    public void placeOrder()
    {
       online.makePayment();
       System.out.println("Thank you ! Your order has been placed");
       System.out.println("---------------------------------------");
       Inventory.update(gc.getMyCart().finalItems());
       System.out.println("\n \n Launching a new Instance of app");
       gc.goToHome();
       gc.clearHistory();
    }
   public void type(int num)
   {
       String digit = Integer.toString(num);
       this.state.number( digit ) ;
    }
   public void checkOut()
   {}
   
   
   
   // State Pattern code
    public void registerObserver( PhoneNumberObserver obj )
    {
        observers.add( obj ) ;
    }

    public void removeObserver( PhoneNumberObserver obj )
    {
        int i = observers.indexOf(obj) ;
        if ( i >= 0 )
            observers.remove(i) ;
    }

    public void notifyObservers( )
    {
        for (int i=0; i<observers.size(); i++)
        {
            PhoneNumberObserver observer = observers.get(i) ;
            observer.update( this.numCount ) ;
        }
    }

    // get name of current state for unit testing
    public String getCurrentState()
    {
        return state.getClass().getName() ;
    }
    
    
//     public PhoneNumberMachine( )
//     {
//         observers = new ArrayList<PhoneNumberObserver>() ;
//         field0 = new NoFieldEntered( this ) ;
//         field1 = new OneFieldEntered( this ) ;
//         field2 = new TwoFieldsEntered( this ) ;
//         field3 = new ThreeFieldsEntered( this ) ;
//         this.state = field0 ;
//         this.pin = Pin.getInstance() ;
//     }

    public void backspace() {
        this.state.backspace() ;
    }

//     public void number( int num ) {
//         String digit = Integer.toString(num);
//         this.state.number( digit ) ;
//     }

    public boolean validPin(String digit) {
        return this.state.validPin(digit) ;
    }

    public void invalidPin() {
        this.state.invalidPin() ;
    }

    public void setStateNoFieldEntered()
    {
        this.numCount = 0 ;
        notifyObservers() ;
        this.state = field0 ;
        this.str1 = "" ;
        this.str2 = "" ;
        this.str3 = "" ;
        //debug() ;
    }

    public void setStateOneFieldEntered( String digit )
    {
        this.numCount = 1 ;
        notifyObservers() ;
        this.state = field1 ;
        if ( digit != null ){
            if(this.validPin(digit)){

                this.str1 = "(" + digit + ")" ;
                        debug() ;
            }
            else{
                this.invalidPin();
                        debug() ;
            }
        }
        else
            this.str2 = "" ;

    }

    public void setStateTwoFieldsEntered( String digit )
    {
        this.numCount = 2 ;
        notifyObservers() ;
        this.state = field2 ;
        if ( digit != null ){
         if(this.validPin(digit)){

            this.str2 = digit + "-" ;
                    debug() ;
                }
            else{
                this.invalidPin();
                        debug() ;
            }
        }
        else
            this.str3 = "" ;

    }

    public void setStateThreeFieldsEntered( String digit )
    {
        this.numCount = 3 ;
        notifyObservers() ;
         //if(this.numCount == 3)
            System.out.println("thank you");
        this.state = field3 ;
        if ( digit != null )
        {
         if(this.validPin(digit)){

            this.str3 = digit ;
                    debug() ;
        }
            else{
                this.invalidPin();
                        debug() ;
            }
        }

           else{
                this.state.invalidPin();
            }

            System.out.println( "Authenticating..." ) ;
            this.pin.validate( str1+str2+str3) ;
            if ( !this.pin.isAuthenticated() )
                  setStateNoFieldEntered() ;
        }
    

    private void debug()
    {
        System.out.println( "Current State: " + state.getClass().getName() ) ;
        System.out.println( "str1 = " + str1 ) ;
        System.out.println( "str2 = " + str2 ) ;
        System.out.println( "str3 = " + str3 ) ;
    }
}

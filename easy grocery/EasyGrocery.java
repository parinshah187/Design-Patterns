
/**
 * Write a description of class EasyGrocery here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EasyGrocery
{
    private GroceryController gc;   
    public EasyGrocery()
    {
         gc = GroceryController.getInstance();
         gc.initiate();
    }
//     public void display()
//     {
//         gc.display();
//     }
   public void touch(int i)
   {
       gc.touch(i);
   }
   public void checkMyCart()
   {
       gc.checkMyCart();
    }
   public void goToHome()
   {
       gc.goToHome();
    }
   public void type(int j)
   {
       gc.type(j);
    }
   public void checkOut()
   {
       gc.checkOut();
    }
   public void goBack()
   {
       gc.goBack();
    }
    public void backspace()
    {
        gc.backspace();
    }
}

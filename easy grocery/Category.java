
/**
 * Write a description of class Category here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Category implements GroceryScreen
{
   private GroceryController gc;
   public Category()
   {
    gc = GroceryController.getInstance();
   }
   public void display()
   {
        System.out.println("\n         -----> HOME <-------     ");
        System.out.println("   |------------------------------|");
        System.out.println("1. | Dairy Products and Breakfast |");
        System.out.println("   |------------------------------|");
        System.out.println("2. | Vegetables & fruits          |");
        System.out.println("   |------------------------------|");
        System.out.println("3. | Bakery Items                 |");
        System.out.println("   |------------------------------|");
        System.out.println("4. | Beer & Wine                  |");
        System.out.println("   |------------------------------|");
        System.out.println("(Please touch no. of button to Go to that page (e.g. touch(2)->Vegetables page)) \n");
        
    }
   
   public void touch(int i)
   {
       switch(i)
       {
           case 1:
            gc.goDairy();
            break;
           case 2:
            gc.goVeg();
            break;
           case 3:
            gc.goBakery();
            break;
           case 4:
            gc.goWine();
            break;
            default:
                System.out.println("No button on "+i+" number");
        }
    }
   public void type(int j)
   {}
   public void checkOut()
   {}
   public void backspace()
   {}
}

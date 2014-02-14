import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Dairy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Dairy implements GroceryScreen, SendMyCart
{
   List<Item> dairy = new ArrayList<Item>();
   private GroceryController gc;
   public Dairy()
   {
      gc = GroceryController.getInstance();
      dairy.add(new Item("Great Value: Whole Milk ",39.56f));
      dairy.add(new Item("Danaon Activia: Vanill Greek Yogurt",1.06f));
      dairy.add(new Item("Great Value: Easy Melt Cheese",4.58f));
      dairy.add(new Item("Ferrero Rocher : chocolates, 5.30 oz",3.08f));
      dairy.add(new Item("Supreme cookies: cheese cake",42.99f));
      dairy.add(new Item("Honey bunches of oats cereals",4.99f));
    }
    
   public void display()
   {
        System.out.println(" \n      --------------> DAIRY PRODUCTS <---------  \n");
        System.out.println("    ------------------------------------------------|");
        System.out.println("0. |"+ dairy.get(0).getName()+ ", $"+ dairy.get(0).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("1. |"+ dairy.get(1).getName()+ ", $"+ dairy.get(1).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("2. |"+ dairy.get(2).getName()+ ", $"+ dairy.get(2).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("3. |"+ dairy.get(3).getName()+ ", $"+ dairy.get(3).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("4. |"+ dairy.get(4).getName()+ ", $"+ dairy.get(4).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("5. |"+ dairy.get(5).getName()+ ", $"+ dairy.get(5).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("(Please touch no. of button to add it to cart (e.g. touch(2) -> to add 3rd item)) \n");
               
    }
   public void touch(int i)
   {
       if( Inventory.checkInventory(dairy.get(i).getName()) > 0)
       {
           System.out.println(dairy.get(i).getName()+" is added to your cart.");
           System.out.println(Inventory.checkInventory(dairy.get(i).getName())+ " items are left in stock");
           notifyObservers(dairy.get(i));
        }
        else
        {
            System.out.println(" Sorry!! " + dairy.get(i).getName()+ " can't be added to your cart. They are out of stock!");
        }
    }
    public void notifyObservers(Item item)
    {
        gc.getMyCart().update(item);
        
    }
    
   public void type(int j)
   {}
   public void checkOut()
   {
       System.out.println("\nplease check My Cart first");
       System.out.println("Going to My Cart");
       gc.checkMyCart();
    }
   public void backspace()
   {}
}

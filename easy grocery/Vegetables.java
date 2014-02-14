import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Vegetables here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vegetables implements GroceryScreen, SendMyCart
{
   List<Item> vegal = new ArrayList<Item>();
   private GroceryController gc;
    public Vegetables()
   {
      gc = GroceryController.getInstance();
      vegal.add(new Item("Betty Croker Potato buds",2.18f));
      vegal.add(new Item("Fresh Grand Produce Tomatoes",4.50f));
      vegal.add(new Item("Dell Monte Premium banana",3.59f));
      vegal.add(new Item("Great Value Sweet Pease",1.88f));
      vegal.add(new Item("Mellisa's Habanero Peppers",3.48f));
      vegal.add(new Item("Sun-Maid California Apricots",3.18f));   
    }
   public void display()
   {
         System.out.println(" \n    --------------> Vegetables & Fruits <---------  \n");
        System.out.println("    ------------------------------------------------|");
        System.out.println("0. |"+ vegal.get(0).getName()+ ", $"+ vegal.get(0).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("1. |"+ vegal.get(1).getName()+ ", $"+ vegal.get(1).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("2. |"+ vegal.get(2).getName()+ ", $"+ vegal.get(2).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("3. |"+ vegal.get(3).getName()+ ", $"+ vegal.get(3).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("4. |"+ vegal.get(4).getName()+ ", $"+ vegal.get(4).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("5. |"+ vegal.get(5).getName()+ ", $"+ vegal.get(5).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("(Please touch no. of button to add it to cart (e.g. touch(2) -> to add 3rd item)) \n");
    }
   public void touch(int i)
   {
       if( Inventory.checkInventory(vegal.get(i).getName()) > 0)
       {
           System.out.println(vegal.get(i).getName()+" is added to your cart.");
           System.out.println(Inventory.checkInventory(vegal.get(i).getName())+ " items are left in stock");
           notifyObservers(vegal.get(i));
        }
        else
        {
            System.out.println(" Sorry!! " + vegal.get(i).getName()+ " can't be added to your cart. They are out of stock!");
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

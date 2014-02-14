import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Wine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wine implements GroceryScreen, SendMyCart
{
    List<Item> wineal = new ArrayList<Item>();
    private GroceryController gc;
    public Wine()
    {
      gc = GroceryController.getInstance();
      wineal.add(new Item("Parducci summer Mixed Pack, 2X 750 ml",27.00f));
      wineal.add(new Item("Tagaris winery radiant reds mixed pack, 4 x 750 ML",46.40f));
      wineal.add(new Item("Waterbrook ombre mixed pack, 3 x 750 ML",27.98f));
      wineal.add(new Item("Vampire vineyards vampire variety, 3 X 750 ml",66.90f));
      wineal.add(new Item("Hughes wellman 2009 Napa valley",55.00f));
      wineal.add(new Item("Le Grand Courtage Sparkling, 3 X 750 ml",57.00f));
    }
   public void display()
   {
      System.out.println(" \n      --------------> Beer & Wine <---------  \n");
        System.out.println("    --------------------------------------------------------|");
        System.out.println("0. |"+ wineal.get(0).getName()+ ", $"+ wineal.get(0).getPrice());
        System.out.println("    --------------------------------------------------------|");
        System.out.println("1. |"+ wineal.get(1).getName()+ ", $"+ wineal.get(1).getPrice());
        System.out.println("    --------------------------------------------------------|");
        System.out.println("2. |"+ wineal.get(2).getName()+ ", $"+ wineal.get(2).getPrice());
        System.out.println("    --------------------------------------------------------|");
        System.out.println("3. |"+ wineal.get(3).getName()+ ", $"+ wineal.get(3).getPrice());
        System.out.println("    --------------------------------------------------------|");
        System.out.println("4. |"+ wineal.get(4).getName()+ ", $"+ wineal.get(4).getPrice());
        System.out.println("    --------------------------------------------------------|");
        System.out.println("5. |"+ wineal.get(5).getName()+ ", $"+ wineal.get(5).getPrice());
        System.out.println("    --------------------------------------------------------|");
        System.out.println("(Please touch no. of button to add it to cart (e.g. touch(2) -> to add 3rd item)) \n");
    }
   public void touch(int i)
   {
        if( Inventory.checkInventory(wineal.get(i).getName()) > 0)
        {
           System.out.println(wineal.get(i).getName()+" is added to your cart.");
           System.out.println(Inventory.checkInventory(wineal.get(i).getName())+ " items are left in stock"); 
           notifyObservers(wineal.get(i));
        }
        else
        {
            System.out.println(" Sorry!! " + wineal.get(i).getName()+ " can't be added to your cart. They are out of stock!");
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

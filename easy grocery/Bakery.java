import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Bakery here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bakery implements GroceryScreen, SendMyCart
{
   List<Item> bakery = new ArrayList<Item>();
   private GroceryController gc;
   public Bakery()
   {
      gc = GroceryController.getInstance();
      bakery.add(new Item("Rocky Mountain party pack assorted",32.99f));
      bakery.add(new Item("Happy birthday Expresso Cake",21.99f));
      bakery.add(new Item("Ener-G Goods Bread 6 pack Gluten Free",32.99f));
      bakery.add(new Item("David's cookies and Animes' Mini deserts",42.99f));
      bakery.add(new Item("Seattle Chocolates Derby",47.99f));
      bakery.add(new Item("Frech Chocolate Molten Cake",79.99f));
    }
   
public void display()
   {
        System.out.println(" \n      --------------> Bakery PRODUCTS <---------  \n");
        System.out.println("    ------------------------------------------------|");
        System.out.println("0. |"+ bakery.get(0).getName()+ ", $"+ bakery.get(0).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("1. |"+ bakery.get(1).getName()+ ", $"+ bakery.get(1).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("2. |"+ bakery.get(2).getName()+ ", $"+ bakery.get(2).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("3. |"+ bakery.get(3).getName()+ ", $"+ bakery.get(3).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("4. |"+ bakery.get(4).getName()+ ", $"+ bakery.get(4).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("5. |"+ bakery.get(5).getName()+ ", $"+ bakery.get(5).getPrice());
        System.out.println("    ------------------------------------------------|");
        System.out.println("(Please touch no. of button to add it to cart (e.g. touch(2) -> to add 3rd item)) \n");
               
    } 
   public void touch(int i)
   {
       if( Inventory.checkInventory(bakery.get(i).getName()) > 0)
       {
           System.out.println(bakery.get(i).getName()+" is added to your cart.");
           System.out.println(Inventory.checkInventory(bakery.get(i).getName())+ " items are left in stock");
           notifyObservers(bakery.get(i));
        }
        else
        {
            System.out.println(" Sorry!! " + bakery.get(i).getName()+ " can't be added to your cart. They are out of stock!");
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
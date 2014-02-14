import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class MyCart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyCart implements GroceryScreen, ItemObserver
{
    private GroceryController gc;
    private List<Item> mycartal;
    private ArrayList<String> names;
    private float total = 0f;
   public MyCart()
   {
        gc = GroceryController.getInstance();
        mycartal = new ArrayList<Item>();
        names = new ArrayList<String>();
   }
//     private List<Item> mycartal = new ArrayList<Item>();
//     private List<String> names = new ArrayList<String>();
//     for(Item i : mycartal)
//     {
//         names.add(i.getName());
//     }
   public void display()
   {
      //mycartal.add(new Item("Rocky Mountain party pack assorted",32.99f));
      //mycartal.add(new Item("Happy birthday Expresso Cake",21.99f));
      System.out.println(" \n             --------------> My Cart <---------  \n");
        System.out.println("    --------------------------------------------------------|");
      int count = 0;
      total = 0;
      for(Item cartItems : mycartal)
      {
        System.out.println(count +". |"+ mycartal.get(count).getName()+ ", $"+ mycartal.get(count).getPrice());
        total += mycartal.get(count).getPrice();
        count++;
        System.out.println("    --------------------------------------------------------|");
      }
      System.out.println("Total = "+total);
      System.out.println("    --------------------------------------------------------|");
      System.out.println("\n (Press checkOut() -> to check out)");
      System.out.println("\n please touch no. of button to add it to cart (e.g. touch(2) -> to remove 3rd item)) \n");
   }
   public void touch(int i)
   {
        if(mycartal.size()>i)
        {
            
           
                System.out.println(mycartal.get(i).getName()+" is removed from your cart.");
                //total -= mycartal.get(i).getPrice();
                //total = 0;
                mycartal.remove(mycartal.get(i));
                gc.setScreen(this);
            
        }
    }
   public void type(int j)
   {}
   public void checkOut()
   {
       
       //notifyAll() -> to inventory
//          {
//              Inventory.update(names);
//           }
       gc.goCheckOut();
   }
   public List<String> getItems()
   {
       return names;
    }
    
    public void update(Item item)
    {
        mycartal.add(item);
        
    }
    public void backspace()
   {}
   
    public ArrayList<String> finalItems()
    {
       for(Item i : mycartal)
       {
            names.add(i.getName());
       }
       return names;
    }
   
   
}

import java.util.*;
/**
 * Write a description of class Inventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventory
{
    // inventory is maintaned separately, it is not dependant upon the objects of Easy Grocery App.
    // So that all the objects can access same Inventory.
    
    //*hash map storing all the items with its availability */
    private static HashMap<String, Integer> inv;
            
    public static void invetoryConfig()
    {
        inv = new HashMap<String, Integer>();
        inv.put("Great Value: Whole Milk ",7);
        inv.put("Danaon Activia: Vanill Greek Yogurt",15);
        inv.put("Great Value: Easy Melt Cheese",20);
        inv.put("Ferrero Rocher : chocolates, 5.30 oz",30);
        inv.put("Supreme cookies: cheese cake",2);
        inv.put("Honey bunches of oats cereals",9);  
        inv.put("Betty Croker Potato buds",45); 
        inv.put("Fresh Grand Produce Tomatoes",125);
        inv.put("Dell Monte Premium banana",12);
        inv.put("Great Value Sweet Pease",16);
        inv.put("Mellisa's Habanero Peppers",18); 
        inv.put("Sun-Maid California Apricots",9);
        inv.put("Rocky Mountain party pack assorted",7);
        inv.put("Happy birthday Expresso Cake",1);
        inv.put("Ener-G Goods Bread 6 pack Gluten Free",38);
        inv.put("David's cookies and Animes' Mini deserts",28);
        inv.put("Seattle Chocolates Derby",38);
        inv.put("Frech Chocolate Molten Cake",5);
        inv.put("Parducci summer Mixed Pack, 2X 750 ml",38);
        inv.put("Tagaris winery radiant reds mixed pack, 4 x 750 ML",40);
        inv.put("Waterbrook ombre mixed pack, 3 x 750 ML",10);
        inv.put("Vampire vineyards vampire variety, 3 X 750 ml",21);
        inv.put("Hughes wellman 2009 Napa valley",91);
        inv.put("Le Grand Courtage Sparkling, 3 X 750 ml",9);
     }
    
     public static int checkInventory(String item)
     {
         return inv.get(item);
         
      }
    
      //     private List<String> cartItems = new ArrayList<String>();
    public Inventory()
    {
        
    }
    public static void update(ArrayList<String> cartItems)
    {
        for(String s:cartItems)
        {
            int num = inv.get(s);
            num--;
            inv.put(s,num);
        }
    }
}

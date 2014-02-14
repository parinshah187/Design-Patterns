
/**
 * Write a description of class Items here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
   
    private String name;
    private float price;
    Item(String s,float p){
        name = s;
        price=p;
    }
    public String getName()
    {
        return this.name;
    }
    public float getPrice()
    {
        return this.price;
    }
}

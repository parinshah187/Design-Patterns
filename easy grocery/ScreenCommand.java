
public class ScreenCommand implements ICommand
{
   private GroceryScreen screen;
   public ScreenCommand(GroceryScreen screen)
   {
            this.screen = screen;
   }
   
   public void execute()
   {
        GroceryController gc = GroceryController.getInstance();
        gc.setScreen(screen);
   }
}

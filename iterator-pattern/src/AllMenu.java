import java.util.ArrayList;

public class AllMenu {
    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();

    DinerMenu dinerMenu = new DinerMenu();
    MenuItem[] lunchItems = dinerMenu.getMenuItems();

    for (int i = 0; i < breakfastItems.size(); i++) {
        MenuItem menuItem = breakfastItems.get(i);
        System.out.println(menuItem.getName());
        System.out.println(menuItem.getPrice());
        System.out.println(menuItem.getDescription());

    }
    for (int i = 0; i < lunchItems.length; i++) {
        MenuItem menuItem = lunchItems[i];
        System.out.println(menuItem.getName());
        System.out.println(menuItem.getPrice());
        System.out.println(menuItem.getDescription());
    }

}

package grocery;
import util.Input;

import java.util.ArrayList;

public class GroceryApplication {

    public static void main(String[] args) {
        Input sc = new Input();
        ArrayList<Grocery> Cart = new ArrayList<>();
        ArrayList<String> Categories = new ArrayList<>();

        Grocery item1 = new Grocery("apple", "produce");
        Cart.add(item1);
        Categories.add(item1.getCategory());

        Grocery item2 = new Grocery("steak", "meat");
        Cart.add(item2);
        Categories.add(item2.getCategory());


        String one = "Item Name";
        String two = "Category";
        System.out.printf("%-10s|%-10s%n", one, two);
        for(int i = 0; i < Cart.size(); i++){
            format(Cart.get(i).getItemName(), Categories.get(i));
        }

        boolean notExit = true;
        do{
            int choice = sc.number(shop(), 1, 3);
            if(choice == 3){
                notExit = false;
                System.out.println("Total is x");
            }

        }while(notExit);


    }

    public static String shop(){
        return ("[1] Add to cart, [2] View cart, [3] Checkout");
    }

    public static void format(String s1, String s2){
        System.out.printf("%-10s|%-10s%n", s1, s2);
    }

}

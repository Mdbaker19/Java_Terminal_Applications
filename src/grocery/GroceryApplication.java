package grocery;
import util.Input;

import java.util.ArrayList;
import java.util.HashMap;

public class GroceryApplication {

    public static void main(String[] args) {
        Input sc = new Input();
        ArrayList<Grocery> cart = new ArrayList<>();

        boolean notExit = true;
        do{
            int choice = sc.number(shop(), 1, 3);
            if(choice == 3){
                notExit = false;
                System.out.println("Total is x");
            } else {
                shopping(choice, sc, cart);
            }
        }while(notExit);
    }

    public static String shop(){
        return ("[1] Add to cart, [2] View cart, [3] Checkout");
    }

    public static void format(String s1, String s2, int s3){
        System.out.printf("| %-10s| %-10s| %-10d|%n", s1, s2, s3);
    }

    public static void shopping (int choice, Input sc, ArrayList<Grocery> cart){
        switch (choice){
            case 1:
                addToCart(sc, cart);
                break;
            case 2:
                viewCart(cart);
                break;
        }
    }

    public static void addToCart(Input sc, ArrayList<Grocery> cart){
        String name = sc.string("What are you adding?");
        if(cart.size() > 0) {
            boolean match = false;
            for (Grocery item : cart) {
                if (item.getItemName().equalsIgnoreCase(name)) {
                    System.out.println("Looks like you already have that in your cart");
                    int addMore = sc.number("How many more are you buying?", 1, 9999);
                    int currAmount = item.getAmount();
                    item.setAmount(addMore + currAmount);
                    match = true;
                    break;
                }
            }
            if(!match){
                String category = sc.string("What category does this item belong to?");
                int howMany = sc.number("And how many are you buying?", 1, 9999);
                Grocery item1 = new Grocery(name, category);
                item1.setAmount(howMany);
                cart.add(item1);
            }
        } else {
            String category = sc.string("What category does this item belong to?");
            int howMany = sc.number("And how many are you buying?", 1, 9999);
            Grocery item1 = new Grocery(name, category);
            item1.setAmount(howMany);
            cart.add(item1);
        }
    }

    public static void viewCart(ArrayList<Grocery> cart){
        String one = "Item Name";
        String two = "Category";
        String three = "Amount";
        System.out.println(" ");
        System.out.println("|-----------|-----------|-----------|");
        System.out.printf("| %-10s| %-10s| %-10s|%n", one, two, three);
        for(int i = 0; i < cart.size(); i++){
            format(cart.get(i).getItemName(), cart.get(i).getCategory(), cart.get(i).getAmount());
        }
        System.out.println(" ");
    }

}

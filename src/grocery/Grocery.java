package grocery;

public class Grocery {

    private String itemName;
    private String category;
    private double price;
    private int amount;

    public Grocery(String name, String category){
        this.itemName = name;
        this.category = category;
    }
    public void setPrice(){
        this.price = (Math.random() * 11) + 1;
    }
    public double getPrice(){
        return this.price;
    }
    public String getItemName(){
        return this.itemName;
    }
    public String getCategory(){
        return this.category;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

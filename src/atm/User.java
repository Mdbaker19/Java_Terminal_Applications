package atm;

public class User {

    private String name;
    private double monies;
    private String workPlace;
    private double payRate;

    public User(String name, String workPlace, double pay, double startingBalance){
        this.name = name;
        this.workPlace = workPlace;
        this.payRate = pay;
        this.monies = startingBalance;
    }

    public void work(int hours){
        double made = this.payRate * hours;
        this.setMonies(this.getMonies() + made);
    }

    public double getMonies(){
        return this.monies;
    }

    public void setMonies(double newMonies){
        this.monies = newMonies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
}

package atm;

import util.Input;

import java.util.ArrayList;
import java.util.Arrays;

public class AtmApplication {

    public static void main(String[] args) {

        Input sc = new util.Input();

        User self = new User("Matt", "Tesla", 37.50, 1000);

        ArrayList<String> atm = new ArrayList<>(Arrays.asList("[0] Withdraw", "[1] Deposit", "[2] Check Balance", "[3] Close", "[4] Sign up"));
        ArrayList<String> atmSignedUp = new ArrayList<>(Arrays.asList("[0] Withdraw", "[1] Deposit", "[2] Check Balance", "[3] Close", "[4] Work"));

        Atm machine = new Atm(atm);


        boolean notSignedUp = true;
        do{
            System.out.println(machine.getMethods());
            int signUp = sc.number("Enter an option", 0, atm.size() - 1);
            if(signUp == 4){
                self.setPinNumber(sc.number("Please enter a new 4-digit pin", 1000, 9999));
                notSignedUp = false;
                machine.setMethods(atmSignedUp);
            } else {
                System.out.println("Please sign up in order to use the ATM");
            }
        } while(notSignedUp);


        boolean notExit = true;
        do{
            System.out.println(machine.getMethods());
            int choice = sc.number("Select an option", 0, atm.size() - 1);
            if(choice == 3){
                notExit = false;
            } else {
                runMethods(choice, sc, self);
            }
        }while(notExit);
        System.out.println("Thank you, goodbye");

    }



    public static void runMethods(int choice, Input sc, User self){
        switch (choice){
            case 0:
                self.setCashOnHand(checkBalance(self.getPinNumber(), self, sc, "How much would you like Withdraw?"));
                break;
            case 1:
                if(self.getCashOnHand() > 0) {
                    deposit(self, sc);
                } else {
                    System.out.println("Looks like you do not have any money to deposit");
                }
                break;
            case 2:
                System.out.println(checkBalance(self.getPinNumber(), self, sc));
                break;
            case 4:
                System.out.println("Working");
                int hours = sc.number("How many hours did you work", 0, 10);
                self.work(hours);
                break;
        }
    }

    public static double checkBalance(int pin, User self, Input sc){
        if(pin == sc.number("Please enter your pin", 1000, 9999)){
            return self.getMonies();
        }
        else return checkBalance(pin, self, sc);
    }
    public static double checkBalance(int pin, User self, Input sc, String p){
        System.out.println(p);
        if(pin == sc.number("Please enter your pin", 1000, 9999)){
            double amount = sc.number((p), 0, self.getMonies());
            self.setMonies(self.getMonies() - amount);
            return amount;
        }
        else return checkBalance(pin, self, sc, "Incorrect Pin");
    }

    public static void deposit(User self, Input sc){
        System.out.printf("Current cash on hand: %f%n", self.getCashOnHand());
        double amount = sc.number("Enter an amount to deposit", 0, self.getCashOnHand());
        System.out.printf("Deposited %f%n", amount);
        self.setMonies(self.getMonies() + amount);
        self.setCashOnHand(self.getCashOnHand() - amount);
    }

}

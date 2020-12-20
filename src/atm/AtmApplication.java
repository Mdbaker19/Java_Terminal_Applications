package atm;

import util.Input;

import java.util.ArrayList;
import java.util.Arrays;

public class AtmApplication {
    public static void main(String[] args) {

        Input sc = new util.Input();

        User self = new User("Matt", "Tesla", 37.50, 1000);

        ArrayList<String> atm = new ArrayList<>(Arrays.asList("[0] Withdraw", "[1] Deposit", "[2] Check Balance"));

        Atm machine = new Atm(atm);

        System.out.println(machine.getMethods());

        sc.number("Enter a number", 0, atm.size()-1);

    }

}

package util;

import java.util.Scanner;

public class Input {

    private Scanner sc;

    public Input(){
        this.sc = new Scanner(System.in);
    }

    public String string(){
        return this.sc.next();
    }

    public String string(String prompt){
        System.out.println(prompt);
        return this.sc.next();
    }

    public int number(String prompt, double min, double max){
        System.out.println(prompt);
        String input = this.string();
        try{
            int parsed = Integer.parseInt(input);
            if(parsed > max || parsed < min){
                return number("Input not recognized please try again", min, max);
            }
            return parsed;
        }catch (Exception e){
            e.printStackTrace();
            return number("Invalid input detected", min, max);
        }
    }

    public double doubleNum(String prompt){
        System.out.println(prompt);
        String input = this.string();
        try{
            double parsed = Double.parseDouble(input);
            return parsed;
        }catch (Exception e){
            e.printStackTrace();
            return doubleNum("Invalid input detected");
        }
    }
    public double doubleNum(){
        String input = this.string();
        try{
            double parsed = Double.parseDouble(input);
            return parsed;
        }catch (Exception e){
            e.printStackTrace();
            return doubleNum("Invalid input detected");
        }
    }

}

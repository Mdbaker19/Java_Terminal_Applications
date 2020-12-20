package atm;

import java.util.ArrayList;

public class Atm {

    private ArrayList<String> methods;

    public Atm(ArrayList<String> methods){
        this.methods = methods;
    }

    public ArrayList<String> getMethods(){
        return this.methods;
    }

}

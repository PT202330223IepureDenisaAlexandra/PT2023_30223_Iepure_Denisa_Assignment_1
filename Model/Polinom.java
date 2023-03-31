package Model;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;


public class Polinom {

    private Map<Integer,Double> polinom;

    public Polinom()
    {
        polinom= new TreeMap<Integer,Double>(Collections.reverseOrder());

    }


    public Map<Integer, Double> getPolinom() {
        return polinom;
    }

    public void setPolinom(Map<Integer, Double> polinom) {
        this.polinom = polinom;
    }
}
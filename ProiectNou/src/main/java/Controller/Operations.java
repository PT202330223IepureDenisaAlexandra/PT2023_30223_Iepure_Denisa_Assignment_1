package Controller;

import Model.Polinom;

import java.util.Map;
import java.util.TreeMap;

public class Operations {

    Polinom polinom1;
    public Operations(Polinom polinom1) {
        this.polinom1 = polinom1;
    }
    public void addOperation(Polinom p) {
        // creez un nou polinom si il initializez cu primul polinom
        Polinom res= new Polinom();
        res.setPolinom(polinom1.getPolinom());
            for (Integer key2 : p.getPolinom().keySet()) {
                if (polinom1.getPolinom().containsKey(key2)) {
                    double sum = polinom1.getPolinom().get(key2) + p.getPolinom().get(key2);
                    res.getPolinom().put(key2,sum);
                } else {
                    res.getPolinom().put(key2, p.getPolinom().get(key2));
                }
            }
          polinom1.setPolinom(res.getPolinom());
               for (Integer key3 : polinom1.getPolinom().keySet())
                    System.out.println(polinom1.getPolinom().get(key3));
    }



    public void substrOperation(Polinom p) {
        // creez un nou polinom si il initializez cu primul polinom
        Polinom res= new Polinom();
        res.setPolinom(polinom1.getPolinom());
        for (Integer key2 : p.getPolinom().keySet()) {

            if (polinom1.getPolinom().containsKey(key2)) {
                double dif = polinom1.getPolinom().get(key2) - p.getPolinom().get(key2);
                res.getPolinom().put(key2,dif);

            } else {
                res.getPolinom().put(key2, -p.getPolinom().get(key2));
            }
        }
        polinom1.setPolinom(res.getPolinom());
        for (Integer key3 : polinom1.getPolinom().keySet())
            System.out.println(polinom1.getPolinom().get(key3));
    }
    public void multiplication(Polinom p) {
        // creez un nou polinom si il initializez cu primul polinom
        Polinom res= new Polinom();
        int new_key=0;
        for (Integer key2 : polinom1.getPolinom().keySet()) {
            for (Integer key : p.getPolinom().keySet()) {
               double result = polinom1.getPolinom().get(key2) * p.getPolinom().get(key);
             if (key==0) new_key=key2;
             else if (key2==0) new_key=key;
             else new_key = key + key2;


                  if (res.getPolinom().containsKey(new_key))
                         res.getPolinom().put(new_key, result + res.getPolinom().get(new_key));
                  else  res.getPolinom().put(new_key, result);
             }
            }

        polinom1.setPolinom(res.getPolinom());
        for (Integer key3 : polinom1.getPolinom().keySet())
            System.out.println(polinom1.getPolinom().get(key3));
    }

    public void derivate()
    {
        Polinom result= new Polinom();
        for (Integer key : polinom1.getPolinom().keySet())
        {
           if (key>0)
            result.getPolinom().put(key-1,polinom1.getPolinom().get(key)*key);
        }
        polinom1.setPolinom(result.getPolinom());
        for (Integer key3 : polinom1.getPolinom().keySet())
            System.out.println(polinom1.getPolinom().get(key3)+"x^"+key3);
    }

    public void integrate()
    {
        Polinom result= new Polinom();
        for (Integer key : polinom1.getPolinom().keySet())
        {

            result.getPolinom().put(key+1,polinom1.getPolinom().get(key)/(key+1));
        }
        polinom1.setPolinom(result.getPolinom());
        for (Integer key3 : polinom1.getPolinom().keySet())
            System.out.println(polinom1.getPolinom().get(key3)+"x^"+key3);
    }


}

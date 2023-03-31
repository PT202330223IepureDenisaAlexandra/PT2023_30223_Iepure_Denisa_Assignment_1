package org.example;

import Controller.FrameController;
import Controller.Operations;
import Model.Polinom;


public class Main {
    public static void main(String[] args) {
       try {
            FrameController frController = new FrameController();
            frController.startLogic();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }



  /*Polinom p = new Polinom();
        p.getPolinom().put(3, 1.0);  // x^3-2x^2+3x-1
        p.getPolinom().put(2, -2.0);
        p.getPolinom().put(1, 3.0);
        p.getPolinom().put(0, -1.0);



        Polinom p1 = new Polinom();

        p1.getPolinom().put(1, 1.0);  //x+2
        p1.getPolinom().put(0, 2.0);


        Operations op = new Operations(p);
        // p.metoda();
         // op.addOperation(p1);
        // op.substrOperation(p1);
        //   op.multiplication(p1);
        //op.integrate();
        //op.derivate();


       op.divide(p1);
        for (Integer key : p.getPolinom().keySet())
            System.out.println(p.getPolinom().get(key) + " " + key);

      System.out.println(op.polToString(p));
*/
    }
}
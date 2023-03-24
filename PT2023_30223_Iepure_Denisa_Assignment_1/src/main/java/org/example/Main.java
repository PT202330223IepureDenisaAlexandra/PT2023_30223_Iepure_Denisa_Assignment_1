package org.example;

import Controller.FrameController;
import Controller.Operations;
import Model.Polinom;


public class Main
{
    public static void main(String[] args) {
       /* try{
            FrameController frController = new FrameController();
            frController.startLogic();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        */


       Polinom p= new Polinom();
      //  p.getPolinom().put(5,2.0);  // x^7+2x^5+4x^3
        //p.getPolinom().put(7,1.0);
        p.getPolinom().put(3,1.0);
        p.getPolinom().put(2,4.0);
        p.getPolinom().put(0,5.0);
       //p.getPolinom().put(3,4.0);


        Polinom p1= new Polinom();
       // p1.getPolinom().put(5,3.0);  // 8.5x^34+5.5x^14+6x^12+5x^7+3x^5
       //p1.getPolinom().put(7,5.0);
       p1.getPolinom().put(1,1.0);
       p1.getPolinom().put(0,-2.0);
      //  p1.getPolinom().put(0,1.0);
        Operations op= new Operations(p);
     // p.metoda();
   //   op.addOperation(p1);
    //  op.substrOperation(p1);
     //   op.multiplication(p1);
       //op.integrate();
        //op.derivate();
      //p.metoda();
      op.regexmethod("2x^5+4x+3");

    }
}
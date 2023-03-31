package Controller;

//import app.Design_form;

import Model.Polinom;
import View.Design_form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameController
{

    public void startLogic()
    {
        Design_form designForm = new Design_form();
        GUIFrameContrl.changePanel(designForm.getMainPanel(),"Calculator");

        designForm.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1=new Polinom();
                Polinom p2= new Polinom();
             String p1_string =designForm.getTextField1().getText();
             String p2_string =designForm.getTextField2().getText();
             if (p1_string.equals("") && !p2_string.equals("")) {
                 JOptionPane.showMessageDialog(null, "Please fill the first field");
                 return;
             }

             if (p2_string.equals("") && !p1_string.equals(""))
             {JOptionPane.showMessageDialog(null, "Please fill the second field");
                 return;}

             if (p1_string.equals("") && p2_string.equals(""))
             {JOptionPane.showMessageDialog(null, "Please fill the fields before");
                 return;}


                Operations op=new Operations(p1);

                op.regexmethod(p1_string,p1);
                op.regexmethod(p2_string,p2);

                op.addOperation(p2);
                op.polToString(p1);
            designForm.getTextField3().setText(op.polToString(p1));

            }
        });

        designForm.getSubButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1=new Polinom();
                Polinom p2= new Polinom();
                String p1_string =designForm.getTextField1().getText();
                String p2_string =designForm.getTextField2().getText();

                if (p1_string.equals("") && !p2_string.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the first field");
                    return;
                }

                if (p2_string.equals("") && !p1_string.equals(""))
                {JOptionPane.showMessageDialog(null, "Please fill the second field");
                    return;}

                if (p1_string.equals("") && p2_string.equals(""))
                {JOptionPane.showMessageDialog(null, "Please fill the fields before");
                    return;}


                Operations op=new Operations(p1);

                op.regexmethod(p1_string,p1);
                op.regexmethod(p2_string,p2);

                op.substrOperation(p2);
                op.polToString(p1);
                designForm.getTextField3().setText(op.polToString(p1));

            }
        });

        designForm.getMulButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1=new Polinom();
                Polinom p2= new Polinom();
                String p1_string =designForm.getTextField1().getText();
                String p2_string =designForm.getTextField2().getText();
                if (p1_string.equals("") && !p2_string.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the first field");
                    return;
                }

                if (p2_string.equals("") && !p1_string.equals(""))
                {JOptionPane.showMessageDialog(null, "Please fill the second field");
                    return;}

                if (p1_string.equals("") && p2_string.equals(""))
                {JOptionPane.showMessageDialog(null, "Please fill the fields before");
                    return;}


                Operations op=new Operations(p1);

                op.regexmethod(p1_string,p1);
                op.regexmethod(p2_string,p2);

                op.multiplication(p2);
                op.polToString(p1);
                designForm.getTextField3().setText(op.polToString(p1));

            }
        });

        designForm.getDivButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1=new Polinom();
                Polinom p2= new Polinom();
                String p1_string =designForm.getTextField1().getText();
                String p2_string =designForm.getTextField2().getText();
                if (p1_string.equals("") && !p2_string.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the first field");
                    return;
                }

                if (p2_string.equals("") && !p1_string.equals(""))
                {JOptionPane.showMessageDialog(null, "Please fill the second field");
                    return;}

                if (p1_string.equals("") && p2_string.equals(""))
                {JOptionPane.showMessageDialog(null, "Please fill the fields before");
                    return;}
                if ( p2_string.equals("0"))
                {
                    JOptionPane.showMessageDialog(null, "Division by 0!!");
                    return;
                }


                Operations op=new Operations(p1);

                op.regexmethod(p1_string,p1);
                op.regexmethod(p2_string,p2);

               // op.divide(p2);
                Polinom q= new Polinom();
                Polinom r= new Polinom();
                ArrayList<Polinom> result_div=op.divide(p2);
                q=result_div.get(0);
                r=result_div.get(1);

                op.polToString(q);
                op.polToString(r);
                designForm.getTextField3().setText(op.polToString(q)+"  restul este: "+op.polToString(r) );

            }
        });

        designForm.getDerivButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1=new Polinom();
                Polinom p2= new Polinom();
                String p1_string =designForm.getTextField1().getText();
                String p2_string =designForm.getTextField2().getText();
                if (p1_string.equals("") ) {
                    JOptionPane.showMessageDialog(null, "Please fill the first field, only this will be derivated");
                    return;
                }

                Operations op=new Operations(p1);

                op.regexmethod(p1_string,p1);
                op.regexmethod(p2_string,p2);

                op.derivate();
                op.polToString(p1);
                designForm.getTextField3().setText(op.polToString(p1));

            }
        });


        designForm.getIntegrButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1=new Polinom();
                Polinom p2= new Polinom();
                String p1_string =designForm.getTextField1().getText();
                String p2_string =designForm.getTextField2().getText();

                if (p1_string.equals("") ) {
                    JOptionPane.showMessageDialog(null, "Please fill the first field, only this will be integrated");
                    return;
                }
                Operations op=new Operations(p1);

                op.regexmethod(p1_string,p1);
                op.regexmethod(p2_string,p2);

                op.integrate();
                op.polToString(p1);
                designForm.getTextField3().setText(op.polToString(p1));

            }
        });
    }


}
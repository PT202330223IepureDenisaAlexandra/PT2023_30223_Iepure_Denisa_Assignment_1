package Controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Model.Polinom;
import com.sun.jdi.IntegerValue;

import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class Operations {

    Polinom polinom1;

    public Operations(Polinom polinom1) {
        this.polinom1 = polinom1;
    }

    public Polinom addOperation(Polinom p) {
        // creez un nou polinom si il initializez cu primul polinom
        Polinom res = new Polinom();
        res.setPolinom(polinom1.getPolinom());

        for (Integer key2 : p.getPolinom().keySet()) {
            if (polinom1.getPolinom().containsKey(key2)) {

                double sum = polinom1.getPolinom().get(key2) + p.getPolinom().get(key2);
                res.getPolinom().put(key2, sum);
               }
            else {
                res.getPolinom().put(key2, p.getPolinom().get(key2));
            }
        }
        polinom1.setPolinom(res.getPolinom());
        return polinom1;
    }


    public Polinom substrOperation(Polinom p) {
        // creez un nou polinom si il initializez cu primul polinom
        Polinom res = new Polinom();
        res.setPolinom(polinom1.getPolinom());
        for (Integer key2 : p.getPolinom().keySet()) {

            if (polinom1.getPolinom().containsKey(key2)) {
                double dif = polinom1.getPolinom().get(key2) - p.getPolinom().get(key2);
                res.getPolinom().put(key2, dif);

            } else {
                res.getPolinom().put(key2, -p.getPolinom().get(key2));
            }
        }
        polinom1.setPolinom(res.getPolinom());

         return polinom1;
    }

    public Polinom multiplication(Polinom p) {
        // creez un nou polinom si il initializez cu primul polinom
        Polinom res = new Polinom();
        int new_key = 0;
        for (Integer key2 : polinom1.getPolinom().keySet()) {
            for (Integer key : p.getPolinom().keySet()) {
                double result = polinom1.getPolinom().get(key2) * p.getPolinom().get(key);
                if (key == 0) new_key = key2;
                else if (key2 == 0) new_key = key;
                else new_key = key + key2;


                if (res.getPolinom().containsKey(new_key))
                    res.getPolinom().put(new_key, result + res.getPolinom().get(new_key));
                else res.getPolinom().put(new_key, result);
            }
        }

        polinom1.setPolinom(res.getPolinom());
      return polinom1;
    }

    public Polinom derivate() {
        Polinom result = new Polinom();
        for (Integer key : polinom1.getPolinom().keySet()) {
            if (key > 0)
                result.getPolinom().put(key - 1, polinom1.getPolinom().get(key) * key);
        }
        polinom1.setPolinom(result.getPolinom());

       return polinom1;
    }

    public Polinom integrate() {
        Polinom result = new Polinom();
        for (Integer key : polinom1.getPolinom().keySet()) {

            result.getPolinom().put(key + 1, polinom1.getPolinom().get(key) / (key + 1));
        }
        polinom1.setPolinom(result.getPolinom());

        return polinom1;
    }
    public ArrayList<Polinom> divide(Polinom p2) {
        Polinom q = new Polinom();
        Polinom trans = new Polinom();
        Polinom prod;
        ArrayList<Polinom> result_div = new ArrayList<>();
        int exp = 0;
        double coef= 0.0;
        int first_key1 = 0;
        for (Integer key : polinom1.getPolinom().keySet()) {
            first_key1 = key;
            break;
        }

        int first_key2 = 0;
        for (Integer key : p2.getPolinom().keySet()) {
            first_key2 = key;
            break;
        }

        Polinom r = new Polinom();
        r.setPolinom(polinom1.getPolinom());

        int ok=0;

        while (!(r.getPolinom().isEmpty()) &&  first_key1 >= first_key2) {

            if (first_key1 == first_key2) {
                exp = 0;
            } else {
                exp = first_key1 - first_key2;
            }

            coef = r.getPolinom().get(first_key1) / p2.getPolinom().get(first_key2);
            trans.getPolinom().put(exp, coef);


            Operations op = new Operations(q);
            op.addOperation(trans);


            Operations op1 = new Operations(trans);
            prod = op1.multiplication(p2);



            Operations op2 = new Operations(r);
            r = op2.substrOperation(prod);


            trans.getPolinom().clear();

            for (Integer key : r.getPolinom().keySet()) {
                if (first_key1 != key && r.getPolinom().get(key) != 0) {
                    first_key1 = key;
                    if (r.getPolinom().get(first_key1) == 0)  first_key1=-1; // daca ambele sunt 0 sa nu intre in ciclu inf

                    break;
                }
                else first_key1=-99;


            }

        }
        polinom1.setPolinom(q.getPolinom());
        result_div.add(polinom1);
        result_div.add(r);

        return result_div;

    }
    public Polinom regexmethod(String text, Polinom p) {

        Pattern pattern = Pattern.compile("([+-]?\\d*[.]?\\d*[^-+]+)");
        Matcher matcher = pattern.matcher(text);
        // fiecarui monom gasit ii delimitez semnul , coeficientul, x-ul, ^ si exponentul

        while (matcher.find()) {
            String match = matcher.group();
            Pattern monomialPattern = Pattern.compile("([+-]?)(\\d*\\.?)(x?)(\\^?)(\\d*)");
            Matcher monomialMatcher = monomialPattern.matcher(match);
            if (!monomialMatcher.matches())
            {
                JOptionPane.showMessageDialog(null, "The input you provided is incorrect");
                continue;
            }
            if (monomialMatcher.matches()) {
                if (monomialMatcher.group(1) != null && monomialMatcher.group(2) != null && monomialMatcher.group(3) != null && monomialMatcher.group(4) != null) {
                    String sign = monomialMatcher.group(1);
                    // pentru a putea inmulti cu semnul fara a influenta
                    sign = sign + "1";
                    Integer si = Integer.valueOf(sign);

                    String coefficient = monomialMatcher.group(2);
                    if (coefficient.equals("")) {

                        if (sign.equals("-")) coefficient = "-1";
                        else coefficient = "1";

                    }
                    String variable = monomialMatcher.group(3);
                    String pow= monomialMatcher.group(4);
                    String exponent = monomialMatcher.group(5);
                    if (exponent.equals("")) {
                        if (variable.equals("x")) exponent = "1";
                        else exponent = "0";

                    }
                    else {
                        if (pow.equals("") && !exponent.equals("")) {
                            JOptionPane.showMessageDialog(null, "The input you provided is incorrect , we expect x^n");
                        continue;
                        }
                    }
                    Integer exp = Integer.valueOf(exponent);
                    Double coef = Double.valueOf(coefficient);
                    p.getPolinom().put(exp, si * coef);
                }
            }
        }
        return p;
    }

    public String polToString(Polinom p) {
        StringBuilder sb = new StringBuilder();
        boolean firstTerm = true; // primul termen al unui polinom


        for (Integer key : p.getPolinom().keySet()) {
            double coef = p.getPolinom().get(key);
            int exp = key;



            DecimalFormat df = new DecimalFormat("#.###");
            if (coef == 0) {
                continue;
            }


            if (!firstTerm && coef > 0 && exp==0) {
                sb.append("+");
            }
            if (!firstTerm && coef > 1 && exp!=0) {
                sb.append("+");
            }


            // append the coefficient
            if (coef == -1.00) {
               if (exp!=0) sb.append("-");
                if (exp==0){
                    if (coef==(int)coef) sb.append((int)coef);
                }
            } else if (coef == 1.00 && exp != 0) {
                if (!firstTerm) {
                    sb.append("+");
                }
            } else if (coef < 0 && exp != 0) {
                {  if (coef==(int)coef) sb.append((int)coef);
                else
                    sb.append(df.format(coef));
                }
            } else if (coef > 0 && exp != 0) {
                if (coef==(int)coef) sb.append((int)coef);
                else
                    sb.append(df.format(coef));
            } else {
                if (coef==(int)coef) sb.append((int)coef);
                else
                    sb.append(df.format(coef));
            }

            if (exp == 1) {
                sb.append("x");
            } else if (exp > 1) {
                sb.append("x^" + exp);
            } else if (exp == 0) {
            }
            firstTerm = false;
        }
          if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
}
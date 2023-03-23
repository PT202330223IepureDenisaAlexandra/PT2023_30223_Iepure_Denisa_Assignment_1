package Model;


public class Monom {
    // atribute
    //puterea si coeficientul fiecarui monom
    private int power;
    private double coef;

    // constructor
    public Monom(int power, double coef)
    {
        this.power=power;
        this.coef=coef;
    }

    public int getPower() {
        return power;
    }

    public double getCoef() {
        return coef;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }
}

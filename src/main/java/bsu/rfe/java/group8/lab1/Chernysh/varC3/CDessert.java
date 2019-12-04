package bsu.rfe.java.group8.lab1.Chernysh.varC3;

public class CDessert extends CFood {
    private String sComponent1;
    private String sComponent2;
    
    public CDessert (String component1, String component2) {
        super ("Dessert");
        this.sComponent1 = component1;
        this.sComponent2 = component2;
    }
    
    public String getCompnent1() {
        return sComponent1;
    }
    
    public String getComponent2() {
        return sComponent2;
    }
    
    public void setComponent1(String component1) {
        this.sComponent1 = component1;
    }
    
    public void setComponent2(String component2) {
        this.sComponent2 = component2;
    }
    
    public String toString() {
       return super.toString() + ", that consist of " + sComponent1 + " and " + sComponent2;
    }
    
    public void consume() {
        System.out.println(this + ", was eaten");
    }
    
    public int calculateCalories() {
        return sComponent1.length() + sComponent2.length() + 7;
    }
    
    public boolean equals (Object arg0) {
        if (!(super.equals(arg0)))
            return false;
        if (!(arg0 instanceof CDessert))
            return false;
        if (sComponent1.equals(((CDessert)arg0).sComponent1))
            return sComponent2.equals(((CDessert)arg0).sComponent2);
        else {
            if (!(sComponent1.equals(((CDessert)arg0).sComponent2)))
                return false;
            else
                return sComponent2.equals(((CDessert)arg0).sComponent1);
        }
    }
}

package bsu.rfe.java.group8.lab1.Chernysh.varC3;

public class CCheese extends CFood {
    public CCheese() {
        super("Cheese");
    }
    
    public int calculateCalories() {
        return sName.length();
    }
    
    public void consume() {
        System.out.println(this + " was eaten");
    }
}

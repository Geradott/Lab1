package bsu.rfe.java.group8.lab1.Chernysh.varC3;

public abstract class CFood implements IConsumable, INutritious {
    String sName = null;
    
    public CFood(String name) {
        this.sName = name;
    }
    
    public String getName() {
        return sName;
    }
    
    public void setName(String name) {
        this.sName = name;
    }
    
    public boolean equals (Object arg0) {
        if (!(arg0 instanceof CFood))
            return false;
        if (sName == null || ((CFood)arg0).sName == null)
                return false;
        return sName.equals(((CFood)arg0).sName);
    }
    
    public String toString() {
        return sName;
    }
}
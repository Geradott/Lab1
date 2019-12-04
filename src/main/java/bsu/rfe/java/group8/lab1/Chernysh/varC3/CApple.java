package bsu.rfe.java.group8.lab1.Chernysh.varC3;

public class CApple extends CFood {
    private String sSize;
    
    public CApple (String size) {
        super("Apple");
        this.sSize = size;
    }
    
    public String getSize() {
        return sSize;
    }
    
    public void setSize(String size) {
        this.sSize = size;
    }
    
    public void consume() {
        System.out.println(this + " was eaten");
    }
    
    public int calculateCalories() {
        return sSize.length() + 5;
    }
    
   public String toString() {
       return super.toString() + " size '" + sSize.toUpperCase() + "'";
   }
   
   public boolean equals(Object arg0) {
       if (super.equals(arg0)) {
           if (!(arg0 instanceof CApple)) 
               return false;
           else
               return sSize.equals(((CApple)arg0).sSize);
       } else
           return false;
   }
}

package bsu.rfe.java.group8.lab1.Chernysh.varC3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;

public class MainApplication {
    public static void main(String[] args) throws InstantiationException {
        CFood[] CBreakfast = new CFood[20];
        int iItems = 0;
        boolean bSort = false;
        boolean bCalories = false;
        for (String arg : args) {
            String[] sParts = arg.split("/");
            if (arg.startsWith("-")) {
                if (arg.equals("-calories"))
                    bCalories = true;
                else if (arg.equals("-sort"))
                    bSort = true;
            }
            else {
                if (sParts[0].equals("Apple") || sParts[0].equals("Cheese") || sParts[0].equals("Dessert")) {
                    try {
                        Class CMyClass = Class.forName("bsu.rfe.java.group8.lab1.Chernysh.varC3.C" + sParts[0]);
                        switch (sParts.length) {
                            case 1:
                                {
                                    Constructor constructor = CMyClass.getConstructor();
                                    CBreakfast[iItems] = (CFood)constructor.newInstance();
                                    break;
                                }
                            case 2:
                                {
                                    Constructor constructor = CMyClass.getConstructor(String.class);
                                    CBreakfast[iItems] = (CFood)constructor.newInstance(sParts[1]);
                                    break;
                                }
                            case 3:
                                {
                                    Constructor constructor = CMyClass.getConstructor(String.class, String.class);
                                    CBreakfast[iItems] = (CFood)constructor.newInstance(sParts[1], sParts[2]);
                                    break;
                                }
                        }
                        iItems++;
                    } 
                    catch (ClassNotFoundException ex) {
                        System.err.println("Class don't exist: " + ex);
                    } 
                    catch (NoSuchMethodException | InstantiationException ex) {
                        System.err.println("Constructor or method don't exist: " + ex);
                    }
                    catch (IllegalAccessException ex) {
                        System.err.println("No access: " + ex);
                    }
                    catch (InvocationTargetException ex) {
                        System.err.println("Problem: " + ex.getCause());
                    }
                }
            }
        }
        if (bSort) {
            Arrays.sort(CBreakfast, new Comparator() {
                public int compare (Object food1, Object food2) {
                    if (food1 == null)
                        return 1;
                    if (food2 == null)
                        return -1;
                    return ((CFood)food1).getName().compareTo(((CFood)food2).getName());
                }
            });
            }
        if (bCalories) {
            int iCalories = 0;
            for (CFood breakfast : CBreakfast) {
                if (breakfast != null) {
                    iCalories += breakfast.calculateCalories();
                }
                else {
                    break;
                }
            }
            System.out.println("Calories: " + iCalories);
        }
        for (CFood breakfast : CBreakfast) {
            if (breakfast != null) {
                breakfast.consume();
            }
            else {
                break;
            }
        }
    }
}

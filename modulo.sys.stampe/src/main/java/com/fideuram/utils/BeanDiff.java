package com.fideuram.utils;

import com.fideuram.exception.ClassOriginException;
import java.lang.reflect.Field;
import java.util.Hashtable;

/**
 * Created by
 * User: logan
 * Date: 15/02/12
 * Time: 12.05
 *
 * <br>Questa Classe confronta per reflection due bean, istanze di una stessa classe </br>
 * <br>e ne evidenza i valori differenti</br>
 */
public class BeanDiff {

    /*public static void main(String args[]){
        Hashtable h= null;
        try {
            h = new BeanDiff().getDiff(Mock.getM1(), Mock.getM2());
        } catch (ClassOriginException e) {
            e.printStackTrace();
        }
        System.out.println(h.size() + " difference........................");
       Enumeration e = h.keys();
       for (int i=0;i<h.size();i++){
           String s = e.nextElement().toString();
           System.out.println(s +" " + h.get(s));
       }
    }*/

    /**
     * Questo metodo resituisce la diff da due istanze di una stessa classe
     * @param o1
     * @param o2
     * @return
     */
    public static Hashtable getDiff(Object o1, Object o2) throws ClassOriginException{

        Class c1 = o1.getClass();
        Class c2 = o2.getClass();

        if(!(c1.getName()==c2.getName())){
            throw new ClassOriginException("o1 and o2 are not instance of the same Class");
        }

        Hashtable diff = new Hashtable();
        Field f[] = c1.getDeclaredFields();

        for (int i = 0; i < f.length; i++){

            try {
                f[i].setAccessible(true);
                if(!(f[i].get(o1).equals(f[i].get(o2)))){
                  diff.put(f[i].getName(),f[i].get(o1)+"<->"+f[i].get(o2));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

      return diff;

    }
}

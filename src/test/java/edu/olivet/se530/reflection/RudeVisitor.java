package edu.olivet.se530.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <a href="mailto:nathanael4ever@gmail.com>Nathanael Yang</a> 4/12/2016 4:46 PM
 */
public class RudeVisitor {
    public static void main(String[] args) {
        Method method = null;
        try {
            method = PrivateNowPublic.class.getDeclaredMethod("secretWay");
            method.invoke(new PrivateNowPublic());
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (method != null) {
                    method.setAccessible(true);
                    method.invoke(new PrivateNowPublic());
                }
            } catch (IllegalAccessException | InvocationTargetException ex) {
                ex.printStackTrace();
                System.exit(4);
            }
        }
        System.exit(0);
    }
}

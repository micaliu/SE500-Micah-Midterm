package edu.olivet.se530.reflection;

import java.lang.reflect.Method;

/**
 * <a href="mailto:nathanael4ever@gmail.com>Nathanael Yang</a> 4/12/2016 4:42 PM
 */
public class PrivateNowPublic {

    private void secretWay() {
        System.out.println("This is a private garden and none of you are allowed to play around here!");
    }

    public static void main(String[] args) {
        try {
            Method method = PrivateNowPublic.class.getDeclaredMethod("secretWay");
            method.invoke(new PrivateNowPublic());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(4);
        }
        System.exit(0);
    }
}

import java.util.ResourceBundle;

/*
 * @(#) testClass.java
 * @Author:windheaven(mail) 2013-7-4
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-7-4
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class testClass {
    private static ResourceBundle bundle = ResourceBundle.getBundle("config");
    public static String A = bundle.getString("A");
    public static String attr = bundle.getString("A." + A);

    /**
      * 创建一个新的实例 
      */
    public testClass() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // Class.forName("testClass");
        System.out.println(A);
        System.out.println(attr);
    }
}

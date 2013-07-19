import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/*
 * @(#) test15_list.java
 * @Author:windheaven(mail) 2013-7-15
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-7-15
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class test15_list {

    /**
      * 创建一个新的实例 
      */
    public test15_list() {
        // TODO Auto-generated constructor stub
    }

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
      */
    public static void main(String[] args) {
        Vector<Integer> vs = new Vector<Integer>();
        LinkedList<Integer> link = new LinkedList<Integer>();

        loop(10, new Operator() {

            int i = 1;

            @Override
            public void proc(Object[] args) {
                ((List) args[0]).add(i++);
            }

        }, link);
        for (int i = 0; i < link.size(); i++) {
            if (link.get(i) > 5) {
                link.remove(i);
                i--;
            }
        }
        // loop(vs.size(), new Operator() {
        //
        // int i = 0;
        //
        // @Override
        // public void proc(Object[] args) {
        // if (((Vector<Integer>) args[0]).get(i++) > 3) {
        // ((Vector<Integer>) args[0]).remove(--i);
        // }
        //
        // // System.out.println(((Vector<Integer>) args[0]).get(i++));
        // }
        //
        // }, vs);
        System.out.println(link.size());

    }

    public static void loop(int i, Operator op, Object... args) {
        if (i > 0) {
            op.proc(args);
            loop(--i, op, args);
        }
    }

    interface Operator {
        void proc(Object... args);
    }
}

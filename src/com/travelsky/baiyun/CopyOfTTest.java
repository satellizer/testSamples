/*
 * @(#) test.java
 * @Author:windheaven(mail) 2013-6-3
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.baiyun;

import java.util.List;

import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.Device;

/**
  * @author windheaven(mail) 2013-6-3
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class CopyOfTTest {

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
      */
    public static void main(String[] args) {
        while (true) {
            try {
                List<Device> list = Push.feedback("src/resources/product_baiyun.p12", "baiyun321", true);
                for (Device d : list) {
                    System.out.println(d.toString());
                }
            } catch (CommunicationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (KeystoreException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("==============");
            try {
                Thread.sleep(60 * 1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

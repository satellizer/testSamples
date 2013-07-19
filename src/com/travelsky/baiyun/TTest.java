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
import javapns.notification.PushedNotification;
import javapns.notification.PushedNotifications;

/**
  * @author windheaven(mail) 2013-6-3
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class TTest {

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
      */
    public static void main(String[] args) {

        try {
            PushedNotifications ps = Push.combined("Hello World!", 1, "default", "src/resources/push_develop.p12", "123456", true,
                    "21f33b460682f715e5496f995a2b85d0a806641e24353fe8b870abd7a81fcd40");
            for (PushedNotification d : ps) {

                System.out.println(d.isTransmissionCompleted());
                System.out.println(d.isSuccessful());
                if (null != d.getResponse()) {
                    System.out.println(d.getResponse().getMessage());
                    Exception theProblem = d.getException();
                    theProblem.printStackTrace();
                }
                System.out.println(d.toString());
            }
            List<Device> list = Push.feedback("src/resources/push_develop.p12", "123456", true);
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
            PushedNotifications ps = Push.combined("Hello World!", 1, "default", "src/resources/push_develop.p12", "123456", false,
                    "21f33b460682f715e5496f995a2b85d0a806641e24353fe8b870abd7a81fcd40");

            for (PushedNotification d : ps) {
                System.out.println(d.isTransmissionCompleted());
                System.out.println(d.isSuccessful());
                if (null != d.getResponse()) {
                    System.out.println(d.getResponse().getMessage());
                    Exception theProblem = d.getException();
                    theProblem.printStackTrace();
                }
                System.out.println(d.toString());
            }
            List<Device> list = Push.feedback("src/resources/push_develop.p12", "123456", false);
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

    }
}

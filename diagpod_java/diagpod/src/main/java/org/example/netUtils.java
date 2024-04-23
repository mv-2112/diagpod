package org.example;

import java.net.InetAddress;

public class netUtils {
    public static void ping(String args) {
        try {
            InetAddress address = InetAddress.getByName("192.168.68.1");
            boolean reachable = address.isReachable(10000);

            System.out.println("Is host reachable? " + reachable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
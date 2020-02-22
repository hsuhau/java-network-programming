package com.hsuhau.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 示例4-2：查找本地机器的地址
 */
public class MyAddress {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
        } catch (UnknownHostException ex) {
            System.out.println("Could not find this computer's address.");
        }
    }
}

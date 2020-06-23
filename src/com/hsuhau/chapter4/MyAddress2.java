package com.hsuhau.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 示例4-4：找到本机器的IP地址
 * <p>
 * 102p
 */
public class MyAddress2 {
    public static void main(String[] args) {
        try {
            InetAddress me = InetAddress.getLocalHost();
            String dottedQuad = me.getHostAddress();
            System.out.println("My address is " + dottedQuad);
        } catch (UnknownHostException ex) {
            System.out.println("I'm sorry, I don't know my own address.");
        }
    }
}

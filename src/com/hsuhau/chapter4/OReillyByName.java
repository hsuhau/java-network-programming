package com.hsuhau.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 示例4-1：显示www.oreilly.com地址的程序
 */
public class OReillyByName {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.oreilly.comm");
            System.out.println(address);
        } catch (UnknownHostException ex) {
            System.out.println("Could not find www.oreilly.com");
        }
    }
}

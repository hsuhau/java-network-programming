package com.hsuhau.chapter4;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 示例4-8：列出所有网络接口的程序
 * <p>
 * 110p
 */
public class InterfaceLister {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
        }
    }
}

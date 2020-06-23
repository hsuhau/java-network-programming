package com.hsuhau.chapter4;

import java.net.InetAddress;

/**
 * 示例4-5：确实IP地址是IPv4还是IPv6
 * <p>
 * 103p
 */
public class AddressTests {
    public static int getVersion(InetAddress ia) {
        byte[] address = ia.getAddress();
        if (address.length == 4) {
            return 4;
        } else if (address.length == 6) {
            return 6;
        } else {
            return -1;
        }
    }
}

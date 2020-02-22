package com.hsuhau.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 示例4-6：测试IP地址的性质
 */
public class IPCharacteristics {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName(args[0]);
            if (address.isAnyLocalAddress()) { // 通配地址
                System.out.println(address + " is a wildcard address.");
            }
            if (address.isLoopbackAddress()) { // 回送地址
                System.out.println(address + " is a loopback address.");
            }
            if (address.isLinkLocalAddress()) { // IPv4本地链路地址
                System.out.println(address + " is a link-local address.");
            } else if (address.isSiteLocalAddress()) { // IPv6本地网站地址
                System.out.println(address + " is a site-local address.");
            } else {
                System.out.println(address + " is a global address.");
            }

            if (address.isMulticastAddress()) { // 组播地址
                if (address.isMCGlobal()) { // 全球组播地址
                    System.out.println(address + " is a global multicast address.");
                } else if (address.isMCOrgLocal()) { // 组织组播地址
                    System.out.println(address + " is an organization wide multicast address.");
                } else if (address.isMCSiteLocal()) { // 网站范围组播地址
                    System.out.println(address + " is a site wide multicast address.");
                } else if (address.isMCLinkLocal()) { // 组网范围组播地址
                    System.out.println(address + " is a subnet wide multicast address. ");
                } else if (address.isMCNodeLocal()) { // 本地接口组播地址
                    System.out.println(address + " is an interface-local multicast address.");
                } else {
                    System.out.println(address + " is an unknown mutlicast address type.");
                }
            } else {
                System.out.println(address + " is a unicast address.");
            }
        } catch (UnknownHostException ex) {
            System.err.println("Could not resolve " + args[0]);
        }
    }
}

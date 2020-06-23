package com.hsuhau.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 示例4-6：测试IP地址的性质
 * <p>
 * 105p
 */
public class IPCharacteristics {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName(args[0]);
            // 通配地址
            if (address.isAnyLocalAddress()) {
                System.out.println(address + " is a wildcard address.");
            }
            // 回送地址
            if (address.isLoopbackAddress()) {
                System.out.println(address + " is a loopback address.");
            }
            // IPv4本地链路地址
            if (address.isLinkLocalAddress()) {
                System.out.println(address + " is a link-local address.");

            }
            // IPv6本地网站地址
            else if (address.isSiteLocalAddress()) {
                System.out.println(address + " is a site-local address.");
            } else {
                System.out.println(address + " is a global address.");
            }

            // 组播地址
            if (address.isMulticastAddress()) {
                // 全球组播地址
                if (address.isMCGlobal()) {
                    System.out.println(address + " is a global multicast address.");
                }
                // 组织组播地址
                else if (address.isMCOrgLocal()) {
                    System.out.println(address + " is an organization wide multicast address.");
                }
                // 网站范围组播地址
                else if (address.isMCSiteLocal()) {
                    System.out.println(address + " is a site wide multicast address.");
                }
                // 组网范围组播地址
                else if (address.isMCLinkLocal()) {
                    System.out.println(address + " is a subnet wide multicast address. ");
                }
                // 本地接口组播地址
                else if (address.isMCNodeLocal()) {
                    System.out.println(address + " is an interface-local multicast address.");
                } else {
                    System.out.println(address + " is an unknown multicast address type.");
                }
            } else {
                System.out.println(address + " is a unicast address.");
            }
        } catch (UnknownHostException ex) {
            System.err.println("Could not resolve " + args[0]);
        }
    }
}

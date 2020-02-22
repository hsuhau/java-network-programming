package com.hsuhau.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 示例4-7：www.ibiblio.org和helios.ibiblios.org相同？
 */
public class IBiblioAliases {
    public static void main(String[] args) {
        try {
            InetAddress ibiblio = InetAddress.getByName("www.ibiblio.org");
            InetAddress helios = InetAddress.getByName("helios.ibiblio.org");
            if (ibiblio.equals(helios)) {
                System.out.println("www.ibiblio.org is the same as helios.ibiblio.org");
            } else {
                System.out.println("www.ibiblio.org is not the same as helios.ibiblio.org");
            }
        } catch (UnknownHostException ex) {
            System.out.println("Host lookup failed.");
        }
    }
}

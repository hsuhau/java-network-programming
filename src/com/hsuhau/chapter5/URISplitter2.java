package com.hsuhau.chapter5;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 示例5-6：URI的各部分
 */
public class URISplitter2 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                URI u = new URI(args[i]);
                System.out.println("The URI is " + u);
                if (u.isOpaque()) {
                    System.out.println("This is an opaque URI.");
                    System.out.println("The scheme is " + u.getScheme());
                    System.out.println("The schem specific part is " + u.getSchemeSpecificPart());
                    System.out.println("The fragment ID is " + u.getFragment());
                } else {
                    System.out.println("This is a hierarchical URI.");
                    System.out.println("The scheme is " + u.getScheme());
                    try {
                        u = u.parseServerAuthority();
                        System.out.println("The host is " + u.getHost());
                        System.out.println("The user info is " + u.getUserInfo());
                        System.out.println("The port is " + u.getUserInfo());
                    } catch (URISyntaxException ex) {
                        // 必须是基于注册的授权机构
                        System.err.println("The authority is " + u.getAuthority());
                    }
                    System.out.println("The path is " + u.getPath());
                    System.out.println("The query string is " + u.getQuery());
                    System.out.println("The fragment ID is " + u.getFragment());
                }
            } catch (URISyntaxException ex) {
                System.err.println(args[i] + " does not seem to be a URI.");
            }
            System.out.println();
        }
    }
}

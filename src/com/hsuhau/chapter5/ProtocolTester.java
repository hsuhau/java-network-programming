package com.hsuhau.chapter5;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 示例5-1：虚拟机支持哪些协议？
 */
public class ProtocolTester {
    public static void main(String[] args) {

        // 超文本传输协议
        testProtocol("http://www.adc.org");

        // 安全超文本传输协议
        testProtocol("https://www.amazon.com/exec.obidos/order2/");

        // 文件传输协议
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");

        // 简单邮件传输协议
        testProtocol("mailto:elharo@ibiblio.org");

        // telnet
        testProtocol("telnet://dibner.poly.edu/");

        // 本地文件访问
        testProtocol("file:///etc/passwd");

        // gopher
        testProtocol("gopher://gopher.anc.org.za/");

        // 轻量组文件传输协议
        testProtocol("ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");

        // JAR
        testProtocol("jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!" +
                "/com/macfaq/io/StreamCopier.class");

        // NFS, 网络文件系统
        testProtocol("nfs://utopia.poly.edu/usr/tmp/");

        // JDBC的定制协议
        testProtocol("jdbc://mysql://luna.ibiblio.org:3306/NEWS");

        // rmi, 远程方法调用的定制协议
        testProtocol("rmi://ibiblio.org/RenderEngine");

        // HotJava的定制协议
        testProtocol("doc:/UserGuide/release.html");
        testProtocol("netdoc:/UsersGuide/release.html");
        testProtocol("systemresource://www.adc.org/+/index.html");
        testProtocol("verbatim:http://www.adc.org/");
    }

    private static void testProtocol(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported.");
        } catch (MalformedURLException ex) {
            String protocol = url.substring(0, url.indexOf(":"));
            System.err.println(protocol + " is not supported.");
        }
    }
}

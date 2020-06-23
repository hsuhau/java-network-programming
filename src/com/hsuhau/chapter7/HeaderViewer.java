package com.hsuhau.chapter7;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * 示例7-4：返回首部
 * <p>
 * 194p
 *
 * @author hsuhau
 * @date 2020/6/22 13:58
 */
public class HeaderViewer {
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                URL u = new URL(arg);
                URLConnection uc = u.openConnection();
                System.out.println("content-type: " + uc.getContentType());
                if (uc.getContentEncoding() != null) {
                    System.out.println("content-encoding: " + uc.getContentEncoding());
                }
                if (uc.getDate() != 0) {
                    System.out.println("Date: " + new Date(uc.getDate()));
                }
                if (uc.getLastModified() != 0) {
                    System.out.println("Last modified: " + uc.getLastModified());
                }
                if (uc.getExpiration() != 0) {
                    System.out.println("Expiration date: " + new Date(uc.getExpiration()));
                }
                if (uc.getContentLength() != 0) {
                    System.out.println("content-length: " + uc.getContentLength());
                }
            } catch (MalformedURLException ex) {
                System.err.println(arg + " is not a URL I understand");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println();
        }
    }
}

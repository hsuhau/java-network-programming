package com.hsuhau.chapter7;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 示例7-5：显示整个HTTP首部
 * <p>
 * 196p
 *
 * @author hsuhau
 * @date 2020/6/22 13:58
 */
public class AllHeaders {
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                URL u = new URL(arg);
                URLConnection uc = u.openConnection();
                for (int i = 0; ; i++) {
                    String header = uc.getHeaderField(i);
                    if (header == null) {
                        break;
                    }
                    System.out.println(uc.getHeaderFieldKey(i) + ": " + header);
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

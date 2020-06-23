package com.hsuhau.chapter5;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 示例5-12：下载由口令保护的Web页面的程序
 * <p>
 * 165p
 */
public class SecureSourceViewer {
    public static void main(String[] args) {
        Authenticator.setDefault(new DialogAuthenticator());
        for (int i = 0; i < args.length; i++) {
            try {
                // 打开URL进行读取
                URL u = new URL(args[i]);
                try (InputStream in = new BufferedInputStream(u.openStream())) {
                    // 将InputStream串链到一个Reader
                    Reader r = new InputStreamReader(in);
                    int c;
                    while ((c = r.read()) != -1) {
                        System.out.println((char) c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }

            // 打印一个空行，以分割页面
            System.out.println();
        }

        // 由于我们使用了AWT，所以应该显示推出
        System.exit(0);
    }
}

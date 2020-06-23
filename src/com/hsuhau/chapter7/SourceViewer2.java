package com.hsuhau.chapter7;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 示例7-1：用URLConnection下载一个Web页面
 * <p>
 * 188p
 *
 * @author hsuhau
 * @date 2020/6/22 13:21
 */
public class SourceViewer2 {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                // 打开URLConnection进行读取
                URL u = new URL(args[0]);
                URLConnection uc = u.openConnection();
                // 自动关闭
                try (InputStream raw = u.openStream()) {
                    InputStream buffer = new BufferedInputStream(raw);
                    // 将InputStream串链到一个Reader
                    Reader reader = new InputStreamReader(buffer);
                    int c;
                    while ((c = reader.read()) != -1) {
                        System.out.println((char) c);
                    }
                } catch (MalformedURLException ex) {
                    System.err.println(args[0] + " is not a parsable URL");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

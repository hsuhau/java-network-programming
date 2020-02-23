package com.hsuhau.chapter5;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 示例5-2：下载一个Web页面
 */
public class SourceViewer {
    public static void main(String[] args) {
        if (args.length > 0) {
            InputStream in = null;
            try {
                // 打开URL进行读取
                URL u = new URL(args[0]);
                in = u.openStream();
                // 缓冲输入以提高性能
                File file;
                in = new BufferedInputStream(in);
                // 将InputStream串廉到一个Reader
                Reader r = new InputStreamReader(in);
                int c;
                while ((c = r.read()) != -1) {
                    System.out.println((char) c);
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            } finally {
                if ((in != null)) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        // 忽略
                    }
                }
            }
        }
    }
}

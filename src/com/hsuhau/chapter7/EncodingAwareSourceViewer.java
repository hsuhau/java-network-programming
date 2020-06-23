package com.hsuhau.chapter7;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 示例7-2：用正确的字符集下载一个Web页面
 * <p>
 * 190p
 *
 * @author hsuhau
 * @date 2020/6/22 13:29
 */
public class EncodingAwareSourceViewer {
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                // 设置默认编码格式
                String encoding = "ISO-8859-1";
                URL u = new URL(arg);
                URLConnection uc = u.openConnection();
                String contentType = uc.getContentType();
                int encodingStart = contentType.indexOf("charset=");
                if (encodingStart != -1) {
                    encoding = contentType.substring(encodingStart + 8);
                }
                InputStream in = new BufferedInputStream(uc.getInputStream());
                Reader r = new InputStreamReader(in, encoding);
                int c;
                while ((c = r.read()) != -1) {
                    System.out.println((char) c);
                }
                r.close();
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parsable URL");
            } catch (UnsupportedEncodingException ex) {
                System.err.println("Server send an encoding Java dose not support: " + ex.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

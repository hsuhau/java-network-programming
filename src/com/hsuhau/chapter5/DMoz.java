package com.hsuhau.chapter5;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 5-10：完成一个Open Directory搜索
 */
public class DMoz {
    public static void main(String[] args) {
        String target = "";
        for (int i = 0; i < args.length; i++) {
            target += args[i] + " ";
        }
        target = target.trim();

        QueryString query = new QueryString();
        query.add("q", target);
        try {
            URL u = new URL("http://dmoz.org/search/q?" + query);
            try (InputStream in = new BufferedInputStream(u.openStream())) {
                InputStreamReader theHTML = new InputStreamReader(in);
                int c;
                while ((c = theHTML.read()) != -1) {
                    System.out.println((char) c);
                }
            }
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

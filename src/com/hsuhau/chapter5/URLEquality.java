package com.hsuhau.chapter5;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 示例5-5：https://www.ibinlio.org和https://ibinlio.org/相等吗？“【pplp------------------oooooooooooooooooooooooooooooooooooooooooo
 */
public class URLEquality {
    public static void main(String[] args) {
        try {
            URL www = new URL("https://www.ibinlio.org/");
            URL ibiblio = new URL("https://ibinlio.org/");
            if (ibiblio.equals(www)) {
                System.out.println(ibiblio + " is the same as " + www);
            } else {
                System.out.println(ibiblio + " is not the same as " + www);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}

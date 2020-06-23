package com.hsuhau.chapter6;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

/**
 * 示例6-1： 阻塞所有 .gov cookie 但接受其他 cookie 的 cookie 策略
 * <p>
 * 184p
 *
 * @author hsuhau
 * @date 2020/6/22 13:13
 */
public class NoGovernmentCookies implements CookiePolicy {
    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        return !uri.getAuthority().toLowerCase().endsWith(".gov")
                && !cookie.getDomain().toLowerCase().endsWith(".gov");
    }
}

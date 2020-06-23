package com.hsuhau.chapter5;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * 示例5-9：ProxySelector会记住可以连接的URL
 * <p>
 * 156p
 */
public class LocalProxySelector extends ProxySelector {

    private List<URI> failed = new ArrayList<>();

    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> result = new ArrayList<>();
        if (failed.contains(uri) ||
                !"http".equalsIgnoreCase(uri.getScheme())) {
            result.add(Proxy.NO_PROXY);
        } else {
            SocketAddress proxtAddress = new InetSocketAddress("proxy.example.com", 8000);
            Proxy.Type type;
            Proxy proxy = new Proxy(Type.HTTP, proxtAddress);
            result.add(proxy);
        }
        return result;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException e) {
        failed.add(uri);
    }
}

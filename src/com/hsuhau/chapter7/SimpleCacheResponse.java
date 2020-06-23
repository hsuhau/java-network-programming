package com.hsuhau.chapter7;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 示例7-10：{@link AbstractCacheResponse}的一个具体子类
 * <p>
 * 207p
 *
 * @author hsuhau
 * @date 2020/6/22 15:22
 */
public class SimpleCacheResponse extends AbstractCacheResponse {
    private final Map<String, List<String>> headers;
    private final SimpleCacheRequest request;
    private final Date expires;
    private final CacheControl control;

    public SimpleCacheResponse(Map<String, List<String>> headers, SimpleCacheRequest request, Date expires, CacheControl control) {
        this.headers = headers;
        this.request = request;
        this.expires = expires;
        this.control = control;
    }

    @Override
    public Map<String, List<String>> getHeaders() throws IOException {
        return headers;
    }

    @Override
    public InputStream getBody() throws IOException {
        return new ByteArrayInputStream(request.getData());
    }

    public CacheControl getControl() {
        return control;
    }

    public boolean isExpired() {
        Date now = new Date();
        if (control.getMaxAge().before(now)) {
            return true;
        } else if (expires != null && control.getMaxAge() != null) {
            return expires.before(now);
        } else {
            return false;
        }
    }
}

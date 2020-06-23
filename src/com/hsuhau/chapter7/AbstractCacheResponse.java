package com.hsuhau.chapter7;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 示例7-9：{@link AbstractCacheResponse}类
 * <p>
 * 202p
 *
 * @author hsuhau
 * @date 2020/6/22 15:15
 */
public abstract class AbstractCacheResponse {
    public abstract Map<String, List<String>> getHeaders() throws IOException;

    public abstract InputStream getBody() throws IOException;
}

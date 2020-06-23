package com.hsuhau.chapter7;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 示例7-7：{@link AbstractCacheRequest}类
 * <p>
 * 201p
 *
 * @author hsuhau
 * @date 2020/6/22 15:08
 */
public abstract class AbstractCacheRequest {
    public abstract OutputStream getBody() throws IOException;

    public abstract void abort();
}

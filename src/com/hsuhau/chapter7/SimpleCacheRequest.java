package com.hsuhau.chapter7;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 示例7-8：{@link AbstractCacheRequest}的一个具体子类
 * <p>
 * 202p
 *
 * @author hsuhau
 * @date 2020/6/22 15:10
 */
public class SimpleCacheRequest extends AbstractCacheRequest {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Override
    public OutputStream getBody() throws IOException {
        return out;
    }

    @Override
    public void abort() {
        out.reset();
    }

    public byte[] getData() {
        return out.size() == 0 ? null : out.toByteArray();
    }
}

package com.hsuhau.chapter7;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 示例7-3：从Web网站下载二进制文件并保存到磁盘
 * <p>
 * 192p
 *
 * @author hsuhau
 * @date 2020/6/22 13:41
 */
public class BinarySaver {
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                URL root = new URL(arg);
                saveBinaryFile(root);
            } catch (MalformedURLException ex) {
                System.err.println(arg + " is not URL I understand.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void saveBinaryFile(URL u) throws IOException {
        URLConnection uc = u.openConnection();
        String contentType = uc.getContentType();
        int contentLength = uc.getContentLength();
        if (contentType.startsWith("text/") || contentLength == -1) {
            throw new IOException("This is not a binary file.");
        }
        try (InputStream raw = uc.getInputStream()) {
            InputStream in = new BufferedInputStream(raw);
            byte[] data = new byte[contentLength];
            int offset = 0;
            while (offset < contentLength) {
                int bytesRead = in.read(data, offset, data.length - offset);
                if (bytesRead == -1) {
                    break;
                }
                offset += bytesRead;
            }

            if (offset != contentLength) {
                throw new IOException("Only read " + offset + " bytes; Excepted " + contentLength + " bytes");
            }
            String fileName = u.getFile();
            fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
            File file;
            try (FileOutputStream fout = new FileOutputStream(fileName)) {
                fout.write(data);
                fout.flush();
            }
        }
    }
}

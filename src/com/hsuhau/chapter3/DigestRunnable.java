package com.hsuhau.chapter3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 示例：3-2：{@link DigestRunnable}
 * <p>
 * 63p
 */
public class DigestRunnable implements Runnable {
    private String filename;

    public DigestRunnable(String filename) {
        this.filename = filename;
    }

    public static void main(String[] args) {
        for (String filename : args) {
            DigestRunnable dr = new DigestRunnable(filename);
            Thread t = new Thread(dr);
            t.start();
        }
    }

    @Override
    public void run() {
        try {
            File file;
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream dim = new DigestInputStream(in, sha);
            while (dim.read() != -1) ;
            dim.close();
            byte[] digest = sha.digest();

            StringBuilder result = new StringBuilder();
            result.append(": ");
//            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}

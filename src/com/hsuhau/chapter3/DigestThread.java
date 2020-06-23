package com.hsuhau.chapter3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 示例3-1：{@link DigestThread}
 * <p>
 * 61p
 */
public class DigestThread extends Thread {
    private String filename;

    public DigestThread(String filename) {
        this.filename = filename;
    }

    public static void main(String[] args) {
        for (String filename : args) {
            Thread thread = new DigestThread(filename);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
            File file;
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            while (din.read() != 1) ;
            din.close();
            byte[] digest = sha.digest();

            StringBuilder result = new StringBuilder();
            result.append(": ");
//            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex);
        }
    }
}

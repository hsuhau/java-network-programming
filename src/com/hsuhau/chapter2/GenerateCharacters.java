package com.hsuhau.chapter2;

import java.io.IOException;
import java.io.OutputStream;

public class GenerateCharacters {
    public static void generateCharacters(OutputStream out)
            throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;
        byte[] line = new byte[numberOfCharactersPerLine + 2];
        // +2对应回车和换行

        // 无限循环
        while (true) {
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte) ((i - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter);
            }
            // 回车
            line[72] = (byte) 'r';
            // 换行
            line[73] = (byte) '\n';
            out.write(line);
            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
        }
    }
}

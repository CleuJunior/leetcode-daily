package br.com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class EncryptDecrypt {

    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length()).append(":").append(str);
        }

        return encoded.toString();
    }

    public static List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // Find the delimiter to determine the length of the next string
            int colonIndex = str.indexOf(':', i);
            int length = Integer.parseInt(str.substring(i, colonIndex));
            i = colonIndex + 1; // Move past the colon
            // Extract the string of the given length
            decoded.add(str.substring(i, i + length));
            i += length; // Move to the next encoded string
        }

        return decoded;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.nio.charset.*;

/**
 *
 * @author ason
 */
public class Function {

    public static boolean isAllLetter(String str) {
        byte[] byteText = str.getBytes(Charset.forName("UTF-8"));
        str = new String(byteText, Charset.forName("UTF-8"));
        for (int i = 0; i < str.length(); i++) {
            if (!(Character.isLetter(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!(Character.isDigit(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlNum(String str) {
        byte[] byteText = str.getBytes(Charset.forName("UTF-8"));
        str = new String(byteText, Charset.forName("UTF-8"));
        for (int i = 0; i < str.length(); i++) {
            if (!(Character.isLetter(str.charAt(i)))) {
                if (!(Character.isDigit(str.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }
}

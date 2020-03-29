package cn.grady.niuke;

import java.util.Scanner;

/**
 * @author gradyzhou
 * @version 1.0, on 16:32 2020/3/8.
 */
public class StringRverse {

    public static void reverseStr(String str) {
        int i = str.length();
        char c;
        while (i > 0) {
            c = str.charAt(--i);
            System.out.print(c);

        }
    }

    public static String reverse(String sentence) {
        StringBuffer result = new StringBuffer();
        String[] words = sentence.split(" ");
        int i = words.length;
        while (i > 0) {
            String word = words[--i];
            result.append(word).append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
//           reverseStr(str);
            System.out.println(reverse(str));
        }

    }


}

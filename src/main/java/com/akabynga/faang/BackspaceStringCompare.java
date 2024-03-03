package com.akabynga.faang;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        String s = "bxj##tw";
        String t = "bxj###tw";

        System.out.println(backspaceCompare_1(s, t));
//        System.out.println(buildString(s));
//        System.out.println(buildString(t));
//        System.out.println(backspaceCompare_1(s, t));
    }

    public static boolean backspaceCompare_1(String s, String t) {
        return buildString(s).compareTo(buildString(t)) == 0;
    }

    public static String buildString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            } else if (!sb.isEmpty()) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static boolean backspaceCompare(String s, String t) {

        int pointerS = s.length() - 1;
        int pointerT = t.length() - 1;

        int sBackspace = 0;
        int tBackspace = 0;

        while (pointerS >= 0 || pointerT >= 0) {

            if (sBackspace > 0 && pointerS >= 0 && s.charAt(pointerS) != '#') {
                sBackspace--;
                pointerS--;
                continue;
            }

            if (tBackspace > 0 && pointerT >= 0 && t.charAt(pointerT) != '#') {
                tBackspace--;
                pointerT--;
                continue;
            }

            if (pointerS >= 0 && s.charAt(pointerS) == '#') {
                sBackspace++;
                pointerS--;
                continue;
            }

            if (pointerT >= 0 && t.charAt(pointerT) == '#') {
                tBackspace++;
                pointerT--;
                continue;
            }
            if (pointerT < 0 && pointerS >= 0 || pointerS < 0 && pointerT >= 0 || t.charAt(pointerT) != s.charAt(pointerS)) {
                return false;
            }
            pointerS--;
            pointerT--;
        }

        return true;
    }
}

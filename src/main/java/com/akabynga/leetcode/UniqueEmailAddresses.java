package com.akabynga.leetcode;

import java.util.*;

public class UniqueEmailAddresses {
    public static void main(String[] args) {
        String[] array = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        System.out.println(numUniqueEmails(array));
    }

    public static int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();

        for (int i = 0; i < emails.length; i++) {
            set.add(fixEmail(emails[i]));
        }

        return set.size();
    }

    public static String fixEmail(String email) {
        char[] chars = email.toCharArray();
        StringBuilder sb = new StringBuilder();
        int domainPartIndex = -1;
        int plusPartIndex = -1;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '+') {
                plusPartIndex = i;
            }
            if (chars[i] == '@') {
                domainPartIndex = i;
                break;
            }
            if (chars[i] != '.' && plusPartIndex < 0) {
                sb.append(chars[i]);
            }

        }
        sb.append(chars, domainPartIndex, chars.length - domainPartIndex);

        return sb.toString();
    }

    public static int numUniqueEmails_old(String[] emails) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < emails.length; i++) {
            String leftPart = emails[i].substring(0, emails[i].indexOf("@")).replaceAll("(\\+.*)|(\\.)", "");
            String rightPart = emails[i].substring(emails[i].indexOf("@"));
            String emailForRedirection = leftPart + rightPart;
            if (!map.containsKey(emailForRedirection)) {
                List<String> emailsList = new ArrayList<>();
                map.put(emailForRedirection, emailsList);
            }
            map.get(emailForRedirection).add(emails[i]);
        }

        return map.size();
    }
}

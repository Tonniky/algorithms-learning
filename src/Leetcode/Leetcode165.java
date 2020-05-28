package Leetcode;

public class Leetcode165 {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("//.");
        String[] ver2 = version2.split("//.");
        int len1 = version1.length(), len2 = version2.length();
        int v1, v2;
        for (int i = 0; i < Math.max(len1, len2); i++) {
            v1 = i < len1 ? Integer.parseInt(ver1[i]) : 0;
            v2 = i < len2 ? Integer.parseInt(ver2[i]) : 0;
            if (v1 > v2)
                return 1;
            else
                return -1;
        }
        return 0;
    }
    }

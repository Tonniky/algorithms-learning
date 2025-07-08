package interviewCompany.Huawei.aTypeCode;

import java.util.ArrayList;

public class dancidaoxu8 {

    public static void main(String[] args) {
        String str = "siht ihs ow";
        System.out.println(getReverseString(str));
    }

    private static String getReverseString(String str) {
        ArrayList<Integer> idxs = new ArrayList<>();

        idxs.add(-1);
        for (int i = 0; i < str.length(); i++) {
            if (",.? ".indexOf(str.charAt(i)) != -1) {
                idxs.add(i);
            }
        }
        idxs.add(str.length());

        char[] chars = str.toCharArray();

        for (int i = 0; i < idxs.size() - 1; i++) {
            int l = idxs.get(i) + 1;
            int r = idxs.get(i + 1) - 1;

            while (l < r) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c: chars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}

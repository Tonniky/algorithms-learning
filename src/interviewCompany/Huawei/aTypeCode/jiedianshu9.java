package interviewCompany.Huawei.aTypeCode;

import java.util.ArrayList;
import java.util.HashMap;

public class jiedianshu9 {

    public static void main(String[] args) {

    }

    private static String getResult(String head, HashMap<String, String[]> nodes) {
        ArrayList<String> link = new ArrayList<>();

        String[] node = nodes.get(head);
        while (node != null) {
            String val = node[0];
            String next = node[1];

            link.add(val);
            node = nodes.get(next);
        }

        int len = link.size();
        int mid = len / 2;
        return link.get(mid);
    }


}

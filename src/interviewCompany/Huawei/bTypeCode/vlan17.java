package interviewCompany.Huawei.bTypeCode;

import java.util.*;

public class vlan17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        Integer destVlan = Integer.parseInt(in.nextLine());

        List<Integer> vlanPool = parseVlanPool(input);

        Collections.sort(vlanPool);

        vlanPool.remove(destVlan);

        String result = formatVlanPool(vlanPool);
        System.out.println(result);

    }

    private static List<Integer> parseVlanPool(String input) {
        List<Integer> vlanPool = new ArrayList<>();
        String[] vlanGroup = input.split(",");
        for (String vlanItem: vlanGroup) {
            if (vlanItem.contains("-")) {
                String[] vlanItems = vlanItem.split("-");
                Integer start = Integer.parseInt(vlanItems[0]);
                Integer end = Integer.parseInt(vlanItems[1]);
                for (int j = start; j <= end; j++) {
                    vlanPool.add(j);
                }
            } else {
                vlanPool.add(Integer.parseInt(vlanItem));
            }
        }
        return vlanPool;
    }

    private static String formatVlanPool(List<Integer> vlanPool) {
        StringBuilder result = new StringBuilder();
        Integer last = null;
        for (int index = 0; index < vlanPool.size(); index++) {
            if (last == null) {
                result.append(vlanPool.get(index));
                last = vlanPool.get(index);
            } else {
                if (vlanPool.get(index) - last == 1) {
                    if (result.toString().endsWith("-" + last)) {
                        result.replace(result.lastIndexOf(last.toString()), result.length(), vlanPool.get(index).toString());
                    } else {
                        result.append("-").append(vlanPool.get(index));
                    }
                } else {
                    result.append(",").append(vlanPool.get(index));
                }
                last = vlanPool.get(index);
            }
        }
        return result.toString();
    }


}

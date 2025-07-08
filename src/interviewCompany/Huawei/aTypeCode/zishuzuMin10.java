package interviewCompany.Huawei.aTypeCode;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Scanner;

public class zishuzuMin10 {

    public static void main(String[] args) {
        int m = 7;
        LinkedList<Integer> link = new LinkedList<>();
        link.add(4);
        link.add(3);
        link.add(2);
        link.add(3);
        link.add(5);
        link.add(2);
        link.add(1);
        System.out.println(getResult(link, m));
    }

    private static int getResult(LinkedList<Integer> link, int m) {
        link.sort((a, b) -> a -b);
        int sum = 0;
        for(Integer ele: link) {
            sum += ele;
        }
        while (m > 0) {
            LinkedList<Integer> link_cp = new LinkedList<>(link);
            if (canPartitionMSubsets(link_cp, sum, m)) return sum / m;
            m--;
        }
        return sum;
    }

    private static boolean canPartitionMSubsets(LinkedList<Integer> link, int sum, int m) {
        if (sum % m != 0)
            return false;

        int sumSum = sum / m;
        if (sumSum < link.get(0))
            return false;

        while (link.size() > 0 && link.get(0) == sumSum) {
            link.removeFirst();
            m--;
        }

        int[] buckets = new int[m];
        return partition(link, 0, buckets, sumSum);
    }

    private static boolean partition(LinkedList<Integer> link, int index, int[] buckets, int subSum) {
        if (index == link.size())
            return true;

        int select = link.get(index);

        for (int i = 0; i < buckets.length; i++) {
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;

            if (select + buckets[i] <= subSum) {
                buckets[i] += select;
                if (partition(link, index + 1, buckets, subSum))
                    return true;
                buckets[i] -= select;
            }
        }
        return false;
    }

}

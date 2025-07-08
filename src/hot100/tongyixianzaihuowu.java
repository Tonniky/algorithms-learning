package hot100;

import org.omg.CORBA.ServiceInformationHelper;

public class tongyixianzaihuowu {

    public static void main(String[] args) {

    }

    private static int getResult(int n, int[] goods, int[] types, int k) {
        int minLimit = 0;
        int maxLimt = 0;
        for (int i = 0; i < n; i++) {
            minLimit = Math.max(minLimit, goods[i]);
            maxLimt += goods[i];
        }

        while (minLimit <= maxLimt) {
            int limit = (minLimit + maxLimt) / 2;

            if (canLimit(limit, n, goods, types, k)) {
                maxLimt = limit - 1;
            } else {
                minLimit = limit + 1;
            }
        }

        return minLimit;
    }

    private static boolean canLimit(int limit, int n, int[] goods, int[] types, int k) {
        int dryCarCount = 0, wetCarCount = 0;

        int dryCarSum = 0, wetCarSum = 0;

        for (int i = 0; i < n; i++) {
            if (types[i] == 0) {
                if (dryCarSum + goods[i] <= limit) {
                    dryCarSum += goods[i];
                } else {
                    if (dryCarSum + 1 == k) {
                        return false;
                    } else {
                        dryCarCount += 1;
                        dryCarSum = goods[i];
                    }
                }
            } else {
                if (wetCarSum + goods[i] <= limit) {
                    wetCarCount += goods[i];
                } else {
                    if (wetCarCount + 1 == k) {
                        return false;
                    } else {
                        wetCarCount += 1;
                        wetCarSum = goods[i];
                    }
                }
            }
        }
        return true;
    }

}

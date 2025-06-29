package interviewCompany.Huawei.bTypeCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class xunilicai19 {
    public static void main() {
//        Scanner in = new Scanner(System.in);
//        int[] tmp = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//        int m = tmp[0];
//        int n = tmp[1];
//        int x = tmp[2];
//
//        int[] returns = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] risks = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] maxInvestments = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = 5;
        int n = 100;
        int x = 10;

        int[] returns = {10, 20, 30, 40, 50};
        int[] risks = {3, 4, 5, 6, 10};
        int[] maxInvestments = {20, 30, 20, 40, 30};


        int maxReturn = 0;
        int[] bestInvestments = new int[m];

        for (int i = 0; i < m; i++) {
            if (risks[i] <= x) {
                int investmentForI = Math.min(n, maxInvestments[i]);
                int currentReturn = investmentForI * returns[i];

                if (currentReturn > maxReturn) {
                    maxReturn = currentReturn;

                    bestInvestments = new int[m];
                    bestInvestments[i] = investmentForI;
                }
            }

            for (int j = i + 1; j < m; j++) {
                if (risks[i] + risks[j] <= x) {
                    int investmentForI, investmentForJ;

                    if (returns[i] > returns[j]) {
                        investmentForI = Math.min(n, maxInvestments[i]);
                        investmentForJ = Math.min(n - investmentForI, maxInvestments[j]);
                    } else {
                        investmentForJ = Math.min(n, maxInvestments[j]);
                        investmentForI = Math.min(n - investmentForJ, maxInvestments[i]);
                    }
                    int currentReturn = investmentForI * returns[i] + investmentForJ * returns[j];
                    if (currentReturn > maxReturn) {
                        maxReturn = currentReturn;
                        bestInvestments = new int[m];
                        bestInvestments[i] = investmentForI;
                        bestInvestments[j] = investmentForJ;
                    }
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int investment: bestInvestments) {
            sj.add(String.valueOf(investment));
        }
        System.out.println(sj.toString());
//        in.close();
    }


    public static void main(String[] args) {

        int m = 5;
        int n = 100;
        int x = 10;

        int[] returns = {10, 20, 30, 40, 50};
        int[] risks = {3, 4, 5, 6, 10};
        int[] maxInvestments = {20, 30, 20, 40, 30};

        int maxFit = 0;
        int[] invest = new int[m];

        for (int i = 0; i < m; i++) {

            if (risks[i] <= x) {
                int investForI = Math.min(maxInvestments[i], n);
                int currentInvest = investForI * returns[i];
                if (currentInvest > maxFit) {
                    maxFit = currentInvest;
                    invest = new int[m];
                    invest[i] = investForI;
                }
            }

            for (int j = i + 1; j < m; j++) {
                if (risks[i] + risks[j] <= x) {
                    int investForI, investForJ;
                    if (returns[i] > returns[j]) {
                        investForI = Math.min(maxInvestments[i], n);
                        investForJ = Math.min(maxInvestments[j], n - investForI);
                    } else {
                        investForJ = Math.min(maxInvestments[j], n);
                        investForI = Math.min(maxInvestments[i], n - investForJ);
                    }
                    int currentInvest = investForI * returns[i] + investForJ * returns[j];
                    if (currentInvest > maxFit) {
                        maxFit = currentInvest;
                        invest = new int[m];
                        invest[i] = investForI;
                        invest[j] = investForJ;
                    }
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int in: invest) {
            sj.add(String.valueOf(in));
        }
        System.out.println(sj);
    }

    }

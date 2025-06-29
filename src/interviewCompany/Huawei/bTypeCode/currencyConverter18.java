package interviewCompany.Huawei.bTypeCode;

import java.util.Scanner;

public class currencyConverter18 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        double totalFen = 0;

        for (int i = 0; i < n; i++) {
            String record = in.nextLine();
            int amount = 0;
            StringBuilder unit = new StringBuilder();

            for (int j = 0; j < record.length(); j++) {
                char c = record.charAt(j);
                if (Character.isDigit(c)) {
                    amount = amount * 10 + (c - '0');
                } else {
                    unit.append(c);
                }

                if (j == record.length() - 1 || Character.isDigit(record.charAt(j + 1)) && unit.length() > 0) {
                    totalFen += amount * exChange(unit.toString());
                    amount = 0;
                    unit.setLength(0);
                }
            }
        }
    }

    private static double exChange(String unit) {
        switch (unit) {
            case "CNY":
                return 100.0;
            case "JPY":
                return 100.0 / 1825 * 100;
            case "HKD":
                return 100.0 / 14 * 100;
            case "EUR":
                return 100.0 / 12 * 100;
            case "GBP":
                return 100.0 / 12 * 100;
            case "fen":
                return 1.0;
            case "cents":
                return 1.0;
            case "sen":
                return 100.0 / 1825;
            case "eurocents":
                return 100.0 / 14;
            case "pence":
                return 100.0 / 12;
            default:
                return 0.0;
        }
    }



}

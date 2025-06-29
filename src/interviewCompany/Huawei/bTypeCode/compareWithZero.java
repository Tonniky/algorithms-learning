package interviewCompany.Huawei.bTypeCode;

import java.util.Arrays;
import java.util.Scanner;

public class compareWithZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] arr = Arrays.stream(sc.nextLine().split(";")).map(s -> s.split(",")).toArray(String[][]::new);

        double[] a1 = Arrays.stream(arr[0]).mapToDouble(Double::valueOf).toArray();
        double[] a2 = Arrays.stream(arr[1]).mapToDouble(Double::valueOf).toArray();
        double[] a3 = Arrays.stream(arr[2]).mapToDouble(Double::valueOf).toArray();
        double[] x = Arrays.stream(arr[3]).mapToDouble(Double::valueOf).toArray();
        double[] b = Arrays.stream(arr[4]).mapToDouble(Double::valueOf).toArray();

        String[] y = arr[5];

//        double diff1 = a1[0] * x[0] + a1[]


    }
}

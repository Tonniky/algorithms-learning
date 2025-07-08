package interviewCompany.Huawei.aTypeCode;

import java.util.*;

public class findLastPerson3 {
    public static void main() {
//        Scanner in = new Scanner(System.in);
//
//        int M = in.nextInt();

        int M = 3;


        if (M <= 1 || M >= 100) {
            System.out.println("ERROR!");
        } else {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                numbers.add(i + 1);
            }

            List<Integer> result = find_last_person(numbers, M);
            Collections.sort(result);

            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
                if (i != result.size() - 1) {
                    System.out.println(",");
                }
            }
            System.out.println();
        }
    }

    private static List<Integer> find_last_person(List<Integer> numbers, int M) {
        for (int i = 1; i <= numbers.size(); i++) {
            if (i == M) {
                List<Integer> temp = new ArrayList<>(numbers.subList(M, numbers.size()));
                temp.addAll(numbers.subList(0, M - 1));
                return find_last_person(temp, M);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        int M = 3;

        if (M <= 1 || M >= 100) {
            System.out.println("ERROR!");
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i + 1);
        }

        List<Integer> findLast = findLast(numbers, M);

        StringJoiner sb = new StringJoiner(",");
        for (int i = 0; i < findLast.size(); i++) {
            sb.add(findLast.get(i).toString());
        }
        System.out.println(sb);

    }

    private static List<Integer> findLast(List<Integer> numbers, int M) {
        for (int i = 1; i <= numbers.size(); i++) {
            if (M == i) {
                List<Integer> temp = new ArrayList<>(numbers.subList(M, numbers.size()));
                temp.addAll(numbers.subList(0, M - 1));
                return findLast(temp, M);
            }
        }
        return numbers;
    }
}

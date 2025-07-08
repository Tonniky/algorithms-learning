package interviewCompany.Huawei.aTypeCode;

import java.util.*;

public class caishuzi1 {

    static String[][] infos;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        infos = new String[n][2];
        for (int i = 0; i < n; i++) {
            infos[i][0] = in.next();
            infos[i][1] = in.next();
        }

        System.out.println();
    }

    private static String getResult() {
        ArrayList<HashSet<Character>> num = getCombine();
        ArrayList<String> cache = new ArrayList<>();

        for (Character c1: num.get(0)) {
            for (Character c2: num.get(1)) {
                for (Character c3: num.get(2)) {
                    for (Character c4: num.get(3)) {
                        String answer = new String(new char[] {c1, c2, c3, c4});
                        if (isValid(answer)) {
                            cache.add(answer);
                        }
                    }
                }
            }
        }
        if (cache.size() != 1) return "NA";
        else return cache.get(0);
    }

    private static ArrayList<HashSet<Character>> getCombine() {
        List<Character> tmp = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        ArrayList<HashSet<Character>> num = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            num.add(new HashSet<>(tmp));
        }

        for (String[] info: infos) {
            String guess_num = info[0];
            String guess_result = info[1];

            int countA = guess_result.charAt(0) - '0';
            int countB = guess_result.charAt(2) - '0';

            if (countA == 0) {
                for (int i = 0; i < 4; i++) {
                    Character c = guess_num.charAt(i);
                    if (countB == 0) {
                        num.get(0).remove(c);
                        num.get(1).remove(c);
                        num.get(2).remove(c);
                        num.get(3).remove(c);
                    } else {
                        num.get(i).remove(c);
                    }
                }
            }
        }
        return num;
    }

    private static boolean isValid(String answer) {
        for (String[] info: infos) {
            String guess = info[0];
            String expect_result = info[1];
            String real_result = getGuessResult(guess, answer);
            if (!expect_result.equals(real_result))
                return false;
        }
        return true;
    }

    private static String getGuessResult(String guess, String answer) {
        int countA = 0;
        int countB = 0;

        int[] answer_arr = new int[10];
        int[] guess_arr = new int[10];

        for (int i = 0; i < guess.length(); i++) {
            char c1 = guess.charAt(i);
            char c2 = answer.charAt(i);

            if (c1 == c2) countA++;
            else {
                answer_arr[c2 - '0']++;
                guess_arr[c1 - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            countB += Math.min(answer_arr[i], guess_arr[i]);
        }

        return new StringBuilder().append(countA).append("A").append(countB).append("B").toString();
    }



}

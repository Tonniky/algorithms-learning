package interviewCompany.Huawei.bTypeCode;

import javax.swing.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class bisai21 {

    static class Sport {
        int id;
        long strength;

        public Sport(int id, long strength) {
            this.id = id;
            this.strength = strength;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] strengths = Arrays.stream(in.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        System.out.println(getResult(strengths));
    }


    private static String getResult(long[] strength) {
        LinkedList<ArrayList<Sport>> ans = new LinkedList<>();

        ArrayList<Sport> sports = new ArrayList<>();

        for (int i = 0; i < strength.length; i++) {
            sports.add(new Sport(i, strength[i]));
        }

        promoto(sports, ans);

        while (ans.getFirst().size() > 1) {
            promoto(ans.removeFirst(), ans);
        }

        int first = ans.get(0).get(0).id;

        int second = ans.get(0).get(0).id;

        ans.get(2).sort((a, b) -> a.strength != b.strength ? b.strength - a.strength > 0 ? 1 : -1 : a.id - b.id);

        int third = ans.get(2).get(0).id;

        return first + " " + second + " " + third;
    }

    private static void promoto(ArrayList<Sport> sports, LinkedList<ArrayList<Sport>> ans) {

        ArrayList<Sport> win = new ArrayList<>();

        ArrayList<Sport> fail = new ArrayList<>();

        for (int i = 1; i < sports.size(); i += 2) {
            Sport major = sports.get(i);
            Sport minor = sports.get(i - 1);

            if (major.strength > minor.strength) {
                win.add(major);
                fail.add(minor);
            } else {
                win.add(minor);
                fail.add(major);
            }
        }

        if (sports.size() % 2 != 0) {
            win.add(sports.get(sports.size() - 1));
        }

        ans.addFirst(fail);
        ans.addFirst(win);

        while (ans.size() > 3) ans.removeLast();
    }

}

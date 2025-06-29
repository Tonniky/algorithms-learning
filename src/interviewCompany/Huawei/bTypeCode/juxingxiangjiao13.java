package interviewCompany.Huawei.bTypeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class juxingxiangjiao13 {

    public static void main(String[] args) {
        List<Integer> x_coords = new ArrayList<>();
        List<Integer> y_coords = new ArrayList<>();
        List<int[]> rectangles = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int w = in.nextInt();
            int h = in.nextInt();

            int x2 = x1 + w;
            int y2 = y1 - h;
            x_coords.add(x1);
            x_coords.add(x2);
            y_coords.add(y1);
            y_coords.add(y2);
            rectangles.add(new int[]{x1, y1, x2, y2});
        }

        int min_x_coord = Integer.MAX_VALUE;
        int max_x_coord = Integer.MIN_VALUE;
        int min_y_coord = Integer.MAX_VALUE;
        int max_y_coord = Integer.MIN_VALUE;

        for (int x: x_coords) {
            min_y_coord = Math.min(min_x_coord, x);
            max_y_coord = Math.max(max_x_coord, x);
        }
        for (int y: y_coords) {
            min_y_coord = Math.min(min_x_coord, y);
            max_y_coord = Math.max(max_x_coord, y);
        }

        int x_offset = 0 - min_x_coord;
        int y_offset = 0 - min_y_coord;

        int[][] intersection_area = new int[max_x_coord - min_x_coord][Math.abs(max_y_coord - min_y_coord)];

        for (int[] rectangle: rectangles) {
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            int x2 = rectangle[2];
            int y2 = rectangle[3];
            for (int i = Math.min(x2, x1) + x_offset; i < Math.max(x2, x1) + x_offset; i++) {
                for (int j = Math.min(y2, y1) + y_offset; j < Math.max(y2, y1) + y_offset; j++) {
                    intersection_area[i][j] += 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < intersection_area.length; i++) {
            for (int j = 0; j < intersection_area[0].length; j++) {
                if (intersection_area[i][j] == 3) {
                    ret += 1;
                }
            }
        }

        System.out.println(ret);
    }
}

package interviewCompany.Huawei.bTypeCode;

import com.sun.deploy.security.SandboxSecurity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class whisperTime7 {

    public static void main() {
        Scanner in = new Scanner(System.in);
        int[] whisperTimes = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        in.close();

        int maxTime = 0;
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            int parentNodeIndex = nodeQueue.poll();

            int leftChildIndex = 2 * parentNodeIndex + 1;
            int rightChildIndex = 2 * parentNodeIndex + 2;

            if (leftChildIndex < whisperTimes.length && whisperTimes[leftChildIndex] != -1) {
                whisperTimes[leftChildIndex] += whisperTimes[parentNodeIndex];
                nodeQueue.add(leftChildIndex);
                maxTime = Math.max(maxTime, whisperTimes[leftChildIndex]);
            }

            if (rightChildIndex < whisperTimes.length && whisperTimes[rightChildIndex] != -1) {
                whisperTimes[rightChildIndex] += whisperTimes[parentNodeIndex];
                nodeQueue.add(rightChildIndex);
                maxTime = Math.max(maxTime, whisperTimes[rightChildIndex]);
            }
        }

        System.out.println(maxTime);
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int[] allTree = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::new).toArray();

        int[] allTree = {0, 9, 20, -1, -1, 15, 7, -1, -1, -1, -1, 3, 2};
        int maxTime = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            if (leftIndex < allTree.length && allTree[leftIndex] != -1) {
                allTree[leftIndex] += allTree[index];
                queue.add(leftIndex);
                maxTime = Math.max(maxTime, allTree[leftIndex]);
            }
            if (rightIndex < allTree.length && allTree[rightIndex] != -1) {
                allTree[rightIndex] += allTree[index];
                queue.add(rightIndex);
                maxTime = Math.max(maxTime, allTree[rightIndex]);
            }
        }
        System.out.println(maxTime);
    }

}

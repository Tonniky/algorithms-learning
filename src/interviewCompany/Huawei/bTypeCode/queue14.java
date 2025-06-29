package interviewCompany.Huawei.bTypeCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class queue14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        int[] msgArr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] consArr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] msgsArr = {2, 22, 1, 11, 4, 44, 5, 55, 3, 33};
        int[] conArr = {1, 7, 2, 3};

        processMessage1(msgsArr, conArr);
    }

    // 处理消息发布和订阅的函数
    private static void processMessage(int[] msgArr, int[] consArr) {
        int msgLen = msgArr.length;  // 消息发布者数组的长度
        int consLen = consArr.length;

        int[][] msgs = new int[msgLen / 2][];
        int i = 0;
        int mIdx = 0;
        while (i < msgLen) {
            msgs[mIdx++] = new int[] {msgArr[i], msgArr[i + 1]};
            i += 2;
        }
        int[][] consumers = new int[consLen / 2][];
        int j = 0;
        int cIdx = 0;
        while (j < consLen) {
            consumers[cIdx++] = new int[] {consArr[j], consArr[j + 1]};
            j += 2;
        }

        Arrays.sort(msgs, (x, y) -> x[0] - y[0]);

        ArrayList<ArrayList<Integer>> receivedMsgs = new ArrayList<>();
        for (int k = 0; k < consumers.length; k++) {
            receivedMsgs.add(new ArrayList<>());
        }

        int pubIdx = 0;
        while (pubIdx < msgs.length) {
            int msgTime = msgs[pubIdx][0];
            int msgContent = msgs[pubIdx][1];

            int subIdx = consumers.length - 1;
            while (subIdx >= 0) {
                int subTime = consumers[subIdx][0];
                int unsubTime = consumers[subIdx][1];

                if (msgTime >= subTime && msgTime < unsubTime) {
                    receivedMsgs.get(subIdx).add(msgContent);
                    break;
                }
                subIdx--;
            }
            pubIdx++;
        }

        int idx = 0;
        while (idx < receivedMsgs.size()) {
            ArrayList<Integer> contentList = receivedMsgs.get(idx);
            if (contentList.isEmpty()) {
                System.out.println("-1");
            } else {
                StringJoiner sj = new StringJoiner(" ");
                for (int content: contentList) {
                    sj.add(Integer.toString(content));
                }
                System.out.println(sj.toString());
            }
            idx++;
        }
    }

    public static void processMessage1(int[] msgArr, int[] conStr) {
        int msgLen = msgArr.length;
        int consLen = conStr.length;

        int[][] msg = new int[msgLen / 2][2];
        for (int i = 0; i < msgLen / 2; i++) {
            msg[i][0] = msgArr[2 * i];
            msg[i][1] = msgArr[2 * i + 1];
        }

        int[][] cons = new int[consLen / 2][2];
        for (int j = 0; j < consLen /2; j++) {
            cons[j][0] = conStr[2 * j];
            cons[j][1] = conStr[2 * j + 1];
        }

        Arrays.sort(msg, (x, y) -> x[0] - y[0]);

        ArrayList<ArrayList<Integer>> receiveMessage = new ArrayList<>();
        for (int k = 0; k < cons.length; k++) {
            receiveMessage.add(new ArrayList<>());
        }

        int pubIdx = 0;
        while (pubIdx < msg.length) {
            int msgIndex = msg[pubIdx][0];
            int msgContent = msg[pubIdx][1];

            int subIdx = cons.length - 1;
            while (subIdx >= 0) {
                int subTime = cons[subIdx][0];
                int unSubTime = cons[subIdx][1];
                if (msgIndex >= subTime && msgIndex < unSubTime) {
                    receiveMessage.get(subIdx).add(msgContent);
                    break;
                }
                subIdx--;
            }
            pubIdx++;
        }

            int idx = 0;
            while (idx < receiveMessage.size()) {
                ArrayList<Integer> contentList = receiveMessage.get(idx);
                if (contentList.isEmpty()) {
                    System.out.println("-1");
                } else {
                    StringJoiner sj = new StringJoiner(" ");
                    for (int content: contentList) {
                        sj.add(Integer.toString(content));
                    }
                    System.out.println(sj.toString());
                }
                idx++;
            }

    }
}

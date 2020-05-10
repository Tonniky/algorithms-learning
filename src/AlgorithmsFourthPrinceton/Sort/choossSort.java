package AlgorithmsFourthPrinceton.Sort;

public class choossSort {
    public static void main(String[] args) {

    }

    //选择排序
    public choossSort(String s){
        char[] chars = s.toCharArray();
        int len = chars.length;
        for(int i = 0; i < len; i++){
            int min = i;
            for(int j = i + 1; j < len; j++){
                if(chars[j] < chars[min]){
                    min = j;
                }
                exchange(chars, min, i);
            }
        }
    }

    private void exchange(char[] chars1, int index1, int index2){
        char temp = chars1[index1];
        chars1[index2] = chars1[index1];
        chars1[index1] = temp;
    }

}

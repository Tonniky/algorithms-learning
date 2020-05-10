package AlgorithmsFourthPrinceton.Sort;

public class insertSort {
    public static void main(String[] args) {
        int[] in = {1, 2, 3, 6, 2};
        int[] res = insertSort(in);
    }

    public static int[] insertSort(int[] in){
        for(int i = 1; i < in.length; i++){
            int temp = in[i];
            int j;
            for(j = i; j > 0 && in[j-1] > in[j]; j--){
                in[j] = in[j-1];
            }
            in[j] = temp;
        }
        return in;
    }
}

package AlgorithmsFourthPrinceton.Sort;

public class shellSort {
    public static void main(String[] args) {
        int[] in = {1, 3, 3, 5, 2, 5};

    }

    private int[] shellSort(int[] in){
        int gap = in.length/2;
        while(gap>0){
            for(int i = 0; i < in.length; i++){
                int temp = in[gap];
                int j;
                for(j = i; j>0 && in[j-1] > in[j]; j-=gap){
                    in[j] = in[j-1];
                }
                in[j] = temp;
            }
            gap = gap/2;
        }
        return in;
    }
}

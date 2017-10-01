package wangyi;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class duilie {

	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
			int[] arr=new int[n];
			List<Integer> list=new ArrayList<>();  //¡–±Ì¿¥¥Ê¥¢
			for(int i=0;i<n;i++){
				arr[i]=in.nextInt();
			}
			for(int i=n-1;i>=0;i--){
				while(!list.contains(arr[i])){
					list.add(arr[i]);
				}
			}
			for(int i=list.size();i>=0;i--){
				System.out.print(list.get(i));
				while(i!=0){
					System.out.print(" ");
				}
			}		
		}
	}	
}

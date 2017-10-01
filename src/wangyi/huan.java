package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class huan {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			int k=sc.nextInt();
			int[][] band=new int[1][n];
			for(int i=0;i<n;i++){
				band[0][i]=sc.nextInt();
			}
			
			int[][] src=new int[n][n];
			for(int i=0;i<n;i++){
				if(i+1<n){
					src[i][i]=1;
					src[i+1][i]=1;
				}else{
					src[i][i]=1;
					src[0][i]=1;
				}
				
			}
			
			int[][] ans=new int[1][n];
			for(int i=0;i<n;i++){
				ans[0][i]=band[0][i];
			}
			
			for(int i=0;i<n;i++){
				System.out.println(Arrays.toString(src[i]));
			}
			
			while(k>0){
				if(k%2==1){
					ans=mutAndMod(src,src);
					k>>=1;
				}
			System.out.println(ans[0][0]);
			for(int i=1;i<n;i++){
				System.out.print(" "+ans[0][i]);
			}
			
			System.out.println( );
			
			}
			
			
			
			
		}
	}
	
	
}

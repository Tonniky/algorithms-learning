package niukeone;

import java.util.Scanner;

public class yu {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int maxSize=sc.nextInt();
		int minSize=sc.nextInt();
		int inNumber=sc.nextInt();
		int[] inFinishSize=new int[inNumber];
		for(int i=0;i<inNumber;i++){
			inFinishSize[i]=sc.nextInt();
		}
		
		int canput=0;
		for(int i=minSize;i<=maxSize;i++){
			boolean Eat=false;
			for(int j=0;j<inNumber;j++){
				if((10*i>=inFinishSize[j] && 2*i<=inFinishSize[j]) || (i>=2*inFinishSize[j] && i<
						10*inFinishSize[j])){
					Eat=true;
					break;
				}
			}
		if(!Eat){
			canput++;
		}
		}
		
		System.out.println(canput);
	}
	
}

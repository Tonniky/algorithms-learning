package wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class jihe {

	public static void main(String[] args){
		Scanner  myscanner=new Scanner(System.in);
		int w=myscanner.nextInt();
		int x=myscanner.nextInt();
		int y=myscanner.nextInt();
		int z=myscanner.nextInt();
		myscanner.close();
		float p=0;
		Set mySet=new HashSet();
		for(float i=w;i<=x;i++)
			for(float j=y;j<=z;j++){
				p=i/j;
				mySet.add(Float.toString(p));
			}
	}
	System.out.print(mySet.size());
	
}

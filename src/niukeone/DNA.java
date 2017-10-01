package niukeone;

import java.util.Scanner;

public class DNA {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		if(s1==null || s2==null || s1.length()!=s2.length() ||
				s2.isEmpty() || s1.isEmpty()){
			return;
		}
		int count=0;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)=='A' && s2.charAt(i)=='T')
				continue;
			if(s1.charAt(i)=='T' && s2.charAt(i)=='A')
				continue;
			if(s1.charAt(i)=='C'&& s2.charAt(i)=='G')
				continue;
			if(s1.charAt(i)=='G'&& s2.charAt(i)=='C')
				continue;
			count++;
		}
		System.out.println(count);
	}
}

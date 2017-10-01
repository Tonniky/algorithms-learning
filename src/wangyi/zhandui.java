package wangyi;

import java.util.Scanner;

public class zhandui {

	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	String cp=sc.nextLine();
	int B=0;
	int G=0;
	int sunB=0;
	int sunG=0;
	for(int i=0;i<cp.length();i++){
		if(cp.charAt(i)==B){
			B++;
			sunB+=i;
		}
		else{
			G++;
			sunG+=i;
		}
		int key1=sunB-B*(B-1)/2;
		int key2=sunG-G*(G-1)/2;
		
		int key=key1>key2?key2:key1;
		
		System.out.println(key);
		
	}
	}
	}	


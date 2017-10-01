package wangyi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class jidanci {

	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
			int m=in.nextInt();
			List<String> systemWords=new ArrayList<>();
			Set<String> writeWordsSet=new HashSet<>();
			List<String> writeWordsList=new ArrayList<>();
			for(int i=0;i<n;n++){
				systemWords.add(in.next());
			}
			for(int i=0;i<m;i++){
				String str=in.next();
				if(systemWords.contains(str)){
					writeWordsSet.add(str);
				}
			}
			writeWordsList.addAll(writeWordsSet);
			int sum=0;
			for(int i=0;i<writeWordsList.size();i++){
				int len=writeWordsList.get(i).length();
				sum+=Math.pow(len,2);
			}
			System.out.println(sum);
		}
		in.close();
	}
}

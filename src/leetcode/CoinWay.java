package leetcode;

public class CoinWay {

	public int coins1(int[] arr,int aim){
		if(arr==null || arr.length==0 || aim<0){
			return 0;
		}
		
		return process1(arr,0,aim);
		
	}
	
	public int process1(int[] arr,int index,int aim){
		int res=0;
		if(index==arr.length){
			res=aim==0?1:0;
		}else{
			for(int i=0;arr[index]*i<aim;i++){
				res+=process1(arr,index+1,aim-arr[index]*i);  //
			}
		}
		
		return res;
	}
	
	public int coins2(int[] arr,int aim){
		if(arr==null || arr.length==0 || aim<0){
			return 0;
		}
		
		return process1(arr,0,aim);
		
	}
	
    public int process2(int[] arr,int index,int aim,int[][] map){
    	int res=0;
    	if(index==arr.length){
    		res=aim==0?1:0;
    	}
    	else{
    		int mapValue=0;
    		for(int i=0;arr[index]*i<=aim;i++){
    			mapValue=map[index+1][aim-arr[index]*i];
    			if(mapValue!=0){
    				res+=mapValue==-1?0:mapValue;
    			}else{
    				res+=process2(arr,index+1,aim-arr[index]*i,map);
    			}
    			
    			
    		}
    	}
    	map[index][aim]=res==0? -1:res;
    	return res;
    }
	
	
	public static void main(String[] args){
		
	}
	
	
}

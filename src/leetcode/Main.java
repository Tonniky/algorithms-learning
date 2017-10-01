package leetcode;

public class Main
{
    //求出第K个幸运数的“位数”
    private static int getBits(int k)
    {
        int count=0;
        int bit=0;
        while(count<k)
        {
            ++bit;
            count+=Math.pow(2,bit);
        }
        return bit;
         
    }
     
     
    private static void slove(int[] arr)//static
     {
          
         for(int i=0;i<arr.length;i++)
         {
             int bits=getBits(arr[i]);
             int addOne=arr[i]+1;
             //将十进制数转化为二进制串
             String bitStr=Integer.toBinaryString(addOne);
             //将二进制串转化为字符数组；
             char[] bitArr=bitStr.toCharArray();
             //移除二进制串中的最高位的1
             char[] reArr=new char[bits];
             StringBuilder str=new StringBuilder(bits);
             for(int j=0;j<bits;j++)
             {
                 reArr[j]=bitArr[j+1];
                //将01串变为47串
                 if(reArr[j]=='0')
                 {
                     str.append('4');
                 }
                 else
                 {
                     str.append('7');
                 }
                     
             }//for
              
             System.out.println(str.toString());
         }
              
             
          
     }
      
     public static void main(String[] args)
     {
         Scanner sc=new Scanner(System.in);
     
         while(sc.hasNextInt())
         {
             int arrayNum=sc.nextInt();
             int[] inputNum=new int[arrayNum];
             for(int i=0;i<arrayNum;i++)
             {
                inputNum[i]=sc.nextInt();  
             }
              
             slove(inputNum);
              
          
         }//while
 
     }
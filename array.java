import java.util.LinkedList;

public class Array{


   //
	public int[] getMaxWindow(int[] arr ,int w){
       if(arr.length<w||w<1||arr==null){
       	return null;
       }

       LinkedList<Integer> qmax=new LinkedList<Integer>();
       int[] res=new int[arr.length-w+1];
       int index=0;
       for(int i=0;i<arr.length-1;i++){
       	  while(!qmax.isEmpty()&&qmax.peekLast()<=arr[i]){
       	  	    qmax.poolLast();
       	  }
       	  qmax.add(i);
       	  if(qmax.peekFirst==i-w){
       	  	  qmax.poolFirst();
       	  }
        if(i>w-1){  //从这个地方开始数
        	res[index++]=arr[qmax.peekFirst];
        }
 
       }
       	return res;
	}

    //两个无环链表
    public Node noLoop(Node node1,Node node2){
    	if(node1==null || node2==null){
    		return null;
    	}
    	Node cur1=node1.next;
    	Node cur2=node2.next;
    	int n=0;
    	while(node1!=null){
    		n++;
    		cur1=cur1.next;
    	}
    	while(node2!=null){
    		n--;
    		cur2=cur2.next;
    	}
    	if(cur1!=cur2){
    		return null;
    	}

    	cur1=n>0?node1:node2;
    	cur2=cur1==cur1?node2:node1;
    	n=Math.abs(n);
    	while(n!=0){   //关键
    		n--;
    		cur1=cur1.next;
    	}
    	while(cur1!=cur2){   //这一步一定要想清楚
    		cur1=cur1.next;
    		cur2=cur2.next;
    	}
    	return cur1;
    }



    public Node bothLoop(Node node1,Node loop1,Node node2,Node loop2){

    	Node cur1=null;
    	Node cur2=null;
    	int n=0;
    	if(loop1==loop2){
    		cur1=node1;
    		cur2=node2;
    		while(cur1!=loop1){
    			cur1=cur1.next;
    			n++;
    		}
    		while(cur2!=loop2){
    			cur2=cur2.next;
    			n--;
    		}
    		cur1=n>0:node1:node2;
    		cur2=cur1==node1?node2:node1;
    		n=Math.abs(n);
    		if(n!=0){
    			cur1=cur1.next;
    			n--;
    		}
    		if(cur1!=cur2){
    			cur1=cur2.next;
    			cur2=cur2.next;
    		}else{
    			cur1=loop1.next;
    			while(cur1!=loop1){
    				if(cur1==loop2){
    					return loop;
    				}
    				cur1=cur1.next;
    			}
    			return null;

    		}


    	}

    }



    //删除掉其中的值。

    public void removeRep1(Node node){
    	if(node==null){
    		return;
    	}

    	Node pre=node;
    	Node cur=node.next;
    	HashSet<Integer> set=new HashSet<Integer>();
    	set.add(node)
    	while(cur!=null){
    		if(set.continues(cur)){
    			pre.next=cur.next;
    		}else{
    			set.add(cur);
    			pre=cur;
    		}
    		cur=cur.next;
    	}

    }
    


    public Node removeValue1(Node node,int num){
    	Stack<Node> stack=new Stack<Node>();
    	while(head!=null){
    		if(head.value!=num){
    			stack.push(head);
    		}
    		head=head.next;
    	}
    	while(!stack.isEmpty()){
    		stack.peek().next=head;
    		head=stack.pop();
    	}
    	return head;
    }






  //先序遍历
  	public void preOrder(Node head){
  		if(head==null || head.length==0){
  			return null;
  		}
  		Stack<Node> stack=new Stack<Node>();
  		stack.push(head)
  		while(!stack.isEmpty){
  			Node head=stack.peek();
  			System.out.print(head);
  			if(head.right!=null){
  				head.push(head.right);
  			}
  			if(head.left!=null){
  				head.push(head.left);
  			}
  		}
  	}

     



  	public int minPath(int[][] m){

        if(m==null || m.length==0 || m[0]==null || m[0].length==0){
        	return 0;
        }

  		int col=m.length;
  		int row=m[0].length;
  		int[][] dp=new int[col][row];
  		dp[0][0]=m[0][0];
  		for(int i=1;i<col;i++){
  			dp[i][0]=dp[i-1][0]+col[i][0];
  		}

  		for(int j=0;j<row;j++){
  			dp[0][j]=dp[0][j-1]+m[0][j];
  		}

  		for(int i=1;i<col;i++){
  			for(int j<1;j<row;j++){
  				dp[i][j]=Math.min(dp[i][j-1]+m[i][j],dp[i-1][j]);
  			}
  		}
  		return dp[col-1][row-1];

  	}


  //更新数
   public int getMaxLength(int[] arr,int k){
   	if(arr==null || arr.length==0 || k<=0){
   		return 0;
   	}
   	int left=0;
   	int right=0;
   	int sum=arr[0];
   	int len=0;
   	while(right<arr.length){
   		if(sum==k){
            len=Math.max(len,right-left+1);
            sum-=arr[left++];
   		}else if(sum<k){
   			right++;
   			sum+=arr[right];
   		}else{
   			left++;
   			sum-=arr[left];
   		}

   	}
   	return len;

   }


  //生成窗口的最大值

   public int[] getMaxLength(int[] arr,int k){

    	if(arr==null || arr.length==k || k<1){
    		return null;
    	}


    	LinkedList<Integer> qmax=new LinkedList<Integer>();
    	int[] res=new int[arr.length-k+1];
    	int index=0;

    	for(int i=0;i<arr.length;i++){

    		while(!qmax.isEmpty() && arr[qmax.peekLast]<=arr[i]){
    			qmax.poolLast();
    		}
    		qmax.addLast();
    		if(qmax.peekFirst()==i-k){
    			qmax.poolFirst();
    		}
    		if(i>k-1){   //每次将最大值赋给res
    			res[index++]=arr[qmax.peekFirst()];
    		}

    	}
    	return res;
   }



   
  //前序遍历
  public void preOrderUnRecur(Node node){
  	Sytem.out.print("pre-order:");

  	if(head!=null){
  		Stack<Node> stack=new Stack<Node>();
  		stack.add(head);
  		while(!stack.isEmpty){
  			head=stack.pop();
  			System.out.print(head.value+" ");
  			if(head.right!=null){
  				stack.push(head.right);
  			}
  			if(head.left!=null){
  				stack.push(head.left);
  			}
  		}
  	}
  	        System.out.println();

  }


  public void    preOrderUnRecur(Node head){
  	System.out.println("pre-order");

    if(head!=null){
    	Stack<Node> stack=new Stack<Node>();
    	stack.add(head);
    	while(!stack.isEmpty){
    		head=stack.pop();
    		System.out.print(head.value+" ");
    		if(head.right!=null){
    			stack.push(head.right);
    		}
    		if(head.left!=null){
    			stack.push(head.left);
    		}
    	}
    }
    System.out.println("");

  }


  //中序遍历
  public void inOrderUnrecur(Node head){
  	System.out.print("in-order:");
  	if(head!=null){
  		Stack<Node> stack=new Stack<Node>();
  		while(!stack.isEmpty || head!=null){   //使用的是
  			if(head!=null){
  				stack.push(head);
  				head=head.left;
  			}else{
  				head=stack.pop();
  				System.out.print(head.value+" ");
  				head=head.right;
  			}
  		}
  	}

  }



  public void inOrderUnrecur(Node head){
  	System.out.print("in-order");
  	if(head!=null){
  		Stack<Node> stack=new Stack<Node>();
  		while(!stack.isEmpty || head!=null){
  			if(head!=null){
  				stack.push(head);
  				head=head.left;
  			}else{
  				head=stack.pop();
  				System.out.print(head.value+" ");    //
  				head=head.right;                     // 
  			}
  		}
  	}
  }



  // if(head!=null){
  // 	head.push(head);
  // 	head=head.left;
  // }else{
  // 	head=stack.pop();
  // 	System.out.print(head.value+" ");
  // 	head=head.right;
  // }


  while(!stack.isEmpty || head=null ){

      if(head!=null){
      	stack.push(head);
      	head=head.left;
      }else{
      	head=stack.pop();
      	System.out.print(head.value+" ");
      	head=head.right;
      }


  }



  //后序遍历
  public void posOrderRecur(Node head){
  	System.out.print("pos-order");
  	if(head!=null){
  		Stack<Node> s1=new Stack<Node>();
  		Stack<Node> s2=new Stack<Node>();
  		s1.pusdh(head);
  		while(!s1.isEmpty){
  			head=s1.pop();
  			s2.push(head);
  			if(head.left!=null){
  				s1.push(head.left);
  			}
  			if(head.right!=null){
  				s1.push(head.right);
  			}
  		}
  		while(!s2.isEmpty()){
  			System.out.print(s1.pop()+" ")
  		}
  	}
  }


  public void posOrderRecur(int head)


   
  //t1是是否包含t2

  public class Node{
  	public int value;
  	public Node left;
  	public Node right;
  	public Node(int data){
  		this.value=data;
  	}
  }

  public boolean contains(Node t1,Node t2){
  	return isCheck(t1,t2) || contains(t1.left,t2) || contains(t1.right,t2); 
  }


  public  boolean isCheck(Node n1,Node n2){
  	if(n2==null){
  		return true;
  	}

  	if(n1==null || n1.value!=n2.value){
  		return false;
  	}

  	return isCheck(n1.left,n2.right) && isCheck(n1.right,n2.right);

  }


  public int getHeight(Node head,int level,boolean[] res){
  	if(head==null){
  		return level;
  	}

  	int lh=getHeight(head.left,level+1,res);
  	if(!res[0]){
  		return level;
  	}
  	int rh=getHeight(head.right,level+1,res);
  	if(!res[0]){
  		return level;
  	}
  	if(Math.abs(lh-rh)>1){
  		res[0]=false;
  	}
  	return Math.max(lh,rh);

  }

   

   public boolean isBoolean(Node head){
   	boolean[] res=new boolean[1];
   	res[0]=true;
   	getHeight(head,1,res);
   	return res[0];
   }



   public int getHeight(Node head,int level,int[] res){
   	if(head==null){
   		return level;
   	}

   	int lh=getHeight(head.left,level+1,res);
   	if(!res[0]){
   		return level;
   	}

   	int rh=getHeight(head.right,level+1,res);
   	if(!res[0]){
   		return level;
   	}
   	if(Math.abs(lh-rh)>1){
   		res[0]=false;
   	}
   	return Math.max(lh,rh);   //最大值

   }

    

    //通过有序链表生成平衡搜索二叉树
    public Node generateTree(int[] sortArr){
    	if(sortArr==null){
    		return null;
    	}

    	return generate(sortArr,0,sortArr.length-1);
    }

    public Node generate(int[] sortArr,int start,int end){
    	if(start<end){
    		return null;
    	}

    	int mid=(start+end)/2;
    	Node head=new Node(sortArr(mid));
    	head.left=generate(sortArr,start,mid-1);
    	head.right=generate(sortArr,mid,end);
    	return head;
    }


    public Node generate(int[] sortArr,int start,int end){
    	if(start<end){
    		return null;
    	}

    	int mid=(start+end)/2;
    	Node head=new Node(sortArr[mid]);
    	head.left=generate(sortArr,start,mid-1);
    	head.right=generate(sortArr,mid,end);
    	return head;
    }



    //动态规划
    public int f1(int n){
    	if(n<1){
    		return 0;
    	}

    	if(n==1||n==2){
    		return 1;
    	}
    	return f1(n-1)+f1(n-2);
    }
    
    //中间值是
    public int f2(int n){
    	if(n<1){
    		return 1;
    	}
    	if(n==1||n==2){
    		return 1;
    	}

    	int res=1;
    	int pre=1;
    	int tmp=0;
    	for(int i=3;i<=n;i++){
    		tmp=res;
    		res=res+pre;
    		pre=tmp;
    	}
    	return res;
    }


    public int s1(int n){
    	if(n<1){
    		return 0;
    	}

    	if(n==1||n==2){
    		return n;
    	}

    	return s1(n-1)+s1(n-2);
    }

    public int s2(int n){
    	if(n<1){
    		return 0;
    	}
    	if(n==1&&n==2){
    		return n;
    	}

    	int res=2;
    	int pre=1;
    	int tmp=0;
    	for(int i=3;i<=n;i++){
    		tmp=res;   //n-2
    		res=res+pre;  //n-2+ n-1
    		pre=tmp;
    	}
    }


  

    	//中间值是
    public int minPathSum(int[][] m){
    	if(m==null || m.length==0 || m[0]==null || m[0].length==0){
    		return 0;
    	}

    	int row=m.length;
    	int col=m[0].length;
    	int[][] dp=new int[row][col];
    	dp[0][0]=m[0][0];
    	for(int i=0;i<row;i++){
    		dp[i][0]=dp[i-1][0]+m[i][0];
    	}

    	for(int j=1;j<row;j++){
    		dp[0][j]=dp[0][j-1]+m[0][j];
    	}
 		//很好理解：   
    	for(int i=1;i<row;i++){
    		for(int j=1;j<col;j++){
    			dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]+m[i][j]);
    		}
    	}
    }



    //
    public int minCoins1(int[] arr,int aim){
    	if(arr==null || arr.length==0 || aim<0){
    		return -1;
    	}
    	int n=arr.length;
    	int max=Integer.MAX_VALUE;
    	int[][] dp=new int[n][aim+1];
    	for(int j=1;j<=aim;j++){
    		dp[0][j]=max;
    		if(j-arr[0]>=0 && dp[0][j-arr[0]]!=max){
    			dp[0][j]=dp[0][j-arr[0]]+1;  //其中arr[i]代表的就是硬币数
    		}
    	}
    	int left=0;
    	for(int i=1;i<n;i++){
    		left=max;
    		for(int j=1;j<=aim;j++){
    			left=dp[i][j-arr[i]]+1;  //每次统计一下1到i中的值是否是中间值
    		}
    		dp[i][j]=Math.min(left,dp[i-1][j]);   //
    	}
    }



    //首先把dp[0][j]求出来
    // int left=0;
    // for(int i=1;i<=n;i++){
    // 	left=max;
    // 	for(int j=1;j<aim;j++){
    // 		left=dp[i][j-arr[i]]+1;
    // 	}
    // 	dp[i][j]=Math.min(left,dp[i-1][j]);
    // }


    public int minCoins1(int[] arr,int aim){
    	if(arr==null || arr.length==0 || aim<0){
    		return -1;
    	}
    	int n=arr.length;
    	int max=Integer.MAX_VALUE;
    	int[][] dp=new int[n][aim+1];
    	for(int j=1;j<=aim;j++){
    		dp[0][j]=max;
    		if(j-arr[0]>=0 && dp[0][j-arr[0]]!=max){
    			dp[0][j]=dp[0][j-arr[0]]+1;
    		}
    	}


    	//中间值是
    	int left=0;
    	for(int i=1;i<n;i++){
    		left=max;
    		for(int j=1;j<=aim;j++){
    			left=dp[i][j-arr[i]]+1;
    		}
    		dp[i][j]=Math.min(left,dp[i-1][j]);
    	}
    }
    return dp[n-1][aim]!=max?dp[n-1][aim]:-1;
}




    //中间值
    public int coins1(int[] arr,int aim){
    	if(arr==null || arr.length==0 || aim<0){
    		return 0;
    	}

    	return process1(arr,0,aim);
    }

    //中间值
    public int process1(int[] arr,int index,int aim){
    	int res=0;
    	if(index==arr.length){
    		res=aim==0?1:0;
    	}
    	else{
    		for(int i=0;i<arr[index]*i<=aim;i++){
    			res+=process1(arr,index+1,aim-arr[index]*i);
    		}
    	}
    }


    public int[] getdp1(int[] arr){
    	int[] dp=
    }


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
   		for(int i=0;arr[index]*i<=aim;i++){
   			res+=process1(arr,index+1,aim-arr[index]*i);
   		}
   	}
   	return res;

   }



   //中间值是
   public int[] getdp1(int[] arr){
   	int[] dp=new int[arr.length];
   	for(int i=0;i<arr.length;i++){
   		dp[i]=1;
   		for(int j=0;j<i;j++){  
   			if(arr[i]>arr[j]){
   				dp[i]=Math.max(dp[i],dp[j]+1);
   			}
   		}
   	}

   	return dp;
   }



  public int[] getdp1(int[] arr){
  	int[] dp=new int[arr.legnth];
  	for(int i=0;i<arr.length;i++){
  		dp[i]=1;   //i=0
  		for(int j=0;j<i;j++){    
  			if(arr[i]>arr[j]){
  				dp[i]=Math.max(dp[i],dp[j]+1);
  			}
  		}
  	}
  	return dp;
  }


  public int[]  getdp1(int[] arr){
  	int[] dp=new int[arr.length];
  	for(int i=0;i<arr.length;i++){
  		dp[i]=1;
  		for(int j=0;j<i;j++){
  			if(arr[j]<arr[i]){
  				dp[i]=Math.max(dp[i],dp[j]+1);
  			}
  		}
  	}
  	return dp;
  }

  public int[] generate(int[] arr,int[] dp){
  	int len=0;
  	int index=0;
  	for(int i=0;i<dp.length;i++){
  		if(dp[i]>len){
  			len=dp[i];
  			index=i;
  		}
  	}
  	int[] lis=new int[len];
  	lis[--len]=arr[index];
  	for(int i=index;i>=0;i--){
  		if(arr[i]<arr[index]&&dp[i]==dp[index]-1){
  			list[--len]=arr[i];
  			index=1;
  		}
  	}
  	return lis;
  }

  public int[] lis1(int[] arr){
  	if(arr==null || arr.length==0){
  		return null;
  	}
  	int[] dp=getdp1(arr);
  	return generate(arr,dp);
  }


  public int[][] getdp(char[] str1,char[] str2){
  	int[][] dp=new int[str1.length][str2.length];
  	dp[0][0]=str1[0]==str2[0]?1:0;


  	for(int i=1;i<str1.length;i++){
  		dp[i][0]=Math.max(dp[i-1][0],str1[i]==str2[0]?1:0);
  	}

  	for(int j=1;j<str2.length;j++){
  		dp[0][j]=Math.max(dp[0][j-1],str1[0]==str2[j]>1:0);
  	}


  	for(int i=1;i<str1.length;i++){
  		for(int j=1;j<str2.length;j++){
  			dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
  			if(str1[i]==str2[j]){
  				dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
  			}
  		}
  	}

  }


}



for(int i=1;i<str1.length;i++){
	for(int j=1;j<str2.length;j++){
		dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
		if(str1[i]==str2[j]){
			dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
		}
	}
}



public int[][] getdp(char[] str1,int str2){
	int[][] dp=new int[str1.length][str2.length];
	for(int i=0;i<str1.length;i++){
		if(str1[i]==str2[0]){
			dp[i][0]=1;
		}
	}

	for(int j=0;j<str2.length;j++){
		if(str1[0]==str2[j]){
			dp[0][j]=1;
		}
	}

	for(int i=1;i<str1.length;i++){
		for(int j=1;j<str2.length;j++){
			dp[i][j]=dp[i-1][j-1]+1;
		}
	}
	return dp;
}

public String lct1(String str1,String str2){
	if(str1==null || str2==null || str1.equals("") || str2.equals("")){
		return "";
	}

	char[] chs1=str1.toCharArray();
	char[] chs2=str2.toCharArray();
	int[][] dp=getdp(chs1,chs2);
	int end=0;
	int max=0;
	for(int i=0;i<chs1.length;i++){
		for(int j=0;j<chs1.length;j++){
			if(dp[i][j]>max){
				end=i;      //此时的i为最大
				max=dp[i][j];  //一直更新max
			}

		}
	}
	return str1.subString(end-max+1,end+1);  //使用
}


  //
public int minCoins1(String str1,String str2){
	if(str1==null || str2==null){
		return 0;
	}

	char[] chs1=str1.toCharArray();
	char[] chs2=str2.toCharArray();
	int row=chs1.length+1;
	int col=chs2.length+1;
	for(int i=1;i<row;i++){
		dp[i][0]=dc*i;
	}
	for(int j=1;j<col;j++){
		dp[0][j]=ic*j;
	}

	for(int i=1;i<row;j++){
		for(int j=1;j<col;j++){
			if(chs1[i-1]==chs2[j-1]){
				dp[i][j]=dp[i-1][j-1];
			}else{
				dp[i][j]=dp[i-1][j-1]+rc;
			}
			dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+ic);
			dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+dc);
		}
	}
	return dp[row-1][col-1];
}


//跳跃游戏
public int jump(int[] arr){
	if(arr==null || arr.length==0){
		retrun 0;
	}

	int jump=0;
	int cur=0;
	int next=0;
	for(int i=0;i<arr.length;i++){
		if(cur<i){    //开始跳了
			jump++;   //步数加一
			cur=next;  //下一步为当前
		}
		next=Math.max(next,i+arr[i]);   //下一步九尾
	}
	return jump;
}



public int jump(int[]  arr){
	if(arr==null || arr.length==0){
		return 0;
	}

     int jump=0;
     int cur=0;
     int next=0;
	for(int i=0;i<arr.length;i++){
		if(cur<i){
			jump++;
			cur=next;
		}
		next=Math(next,i+arr[i]);
	}
}



public int longestConsecutive(int[] arr){
	if(arr==null || arr.length==0){
		return 0;
	}
	int max=1;
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	for(int i=0;i<arr.length;i++){
		if(!map.containsKey(arr[i])){
			max=Math.max(max,merge(map,arr[i]-1,arr[i]));
					}
	}
}



//字符串问题
public boolean isDeformation(String str1,String str2){
	if(str1==null || str2==null || str1.length==0 || str2.length==0){
		return false;
	}

	char[] chs1=str1.toCharArray();
	char[] chs2=str2.toCharArray();
	int[] map=new int[256];
	for(int i=0;i<chas1.length;i++){
		map[char[i]]++;
	}
	for(int i=0;i<chs2.length;i++){
		if(map[chas2[i]]--==0){
			return false;
		}
	}
	return true;
}


//
public boolean isDeformation(String str1,String str2){
  if(str1==null || str2==null || str1.length==0 || str2.length==0){
      return false;
  }

  char[] chas1=str1.toCharArray();
  char[] chas2=str2.toCharArray();
  map[] map=new int[256];
  for(int i=0;i<chas1.length;i++){
    map[chas1[i]]++;
  }

  for(int j=0;j<chas2.length;j++){
    if(map[chas2[i]]--==0){ 
      return false;
    }
    return false;
  }


  for(int j=0;j<chas2.length;j++){
    if(map[chas2[i]]--==0){
      return false;
    }
    return true;
  }
}


public int numSum(String str){
  if(str==null){
    return 0;
  }
  char[] charArr=str.toCharArray();
  int res=0;
  int num=0;
  boolean posi=true;
  int cur=0;
  for(int i=0;i<charArr.length;i++){
    cur=charArr[i]-'0';
    if(cur<0||cur>9){
      res-=num;
      num=0;
      if(charArr[i]=='-'){
        if(i-1>-1 && charArr[i-1]=='-'){
          posi=!posi;
        }else{
          posi=false;
        }
      }else{
        posi=true;
      }
    }else{
      num=num*10+(posi?cur:-cur);  //中间值
    }
  }
}


public String removeKZeros(String str,int k){
  if(str==null ||k<1){
    return str;
  }

  char[] chas=str.toCharArray();
  int count=0,start=-1;
  for(int i=0;i!=chas.length;i++){   //
    if(chas[i]=='0'){
      count++;
      start=start==-1?i:start;
    }else{
      if(count==k){
        while(count--!=0)
          chas[start++]=0;
      }
      count=0;
      start=-1;
    }
  }
  if(count==k){       //
    while(count--!=0)
      chas[start++]=0;
  }
  return String.valueOf(chas);

}


public boolean isRotation(String a,String b){
  if(a==null || b==null ||a.length==0 || b.length==0){
    return false;
  }
  String b2=b+b;
  return getIndexOf(b2,a)!=-1;  //getIndexOf   kmp
}


public getIndexOf(String str1,String str2){
  char[] chas1=str1.toCharArray();
  char[] chas2=str2.toCharArray();
  int m=str2.length;
  for(int i=1;i<=str1.length-m;i++){
      //直接比对
      if(str.subString(i,i+m).equals(str2)){
        return true;
    }
  }
}



//中间值是
public boolean isValid(String[] chas){
  if(chas[0]!='-' && (chas[0]<'0'||chas[0]>'9')){
    return false;
  }
  if(chas[0]=='-' && (chas.length==1 && chas[1]=='0')){
    return false;
  }
  if(chas[0]=='-' && chas.length>1){
    return false;
  }

  for(int i=1;i<chas.length;i++){
    if(chas[i]<'0' || chas[i]>'9'){
      return false;
    }
  }
  return true;  //
}

public int conver(String str){
  if(str==null ||str.length==0){
    return 0;  //
  }

  char[] chas=str.toCharArray();
  if(!isValid(chas)){
    return 0;
  }

  boolean posi=chas[0]=='-'?false:true;
  int minq=Integer.MIN_VALUE/10;
  int minr=Integer.MAX_VALUE%10;
  int res=0;
  int 
}


public boolean isUnique(char[] chas){
  if(chas==null){
    return true;
  }
  boolean[] map=new boolean[256];
  for(int i=0;i<chas.length;i++){
    if(map[chas[i]]){
      return false;
    }
    map[chas[i]]=true;
  }
  return true;

}


public boolean isUnique(char[] chas){
  if(chas==null){
    return true;
  }
  boolean[] map=new boolean[256];
  for(int i=0;i<chas.length;i++){
    if(map[chas[i]]){
      return false;
    }
    map[chas[i]]=true;
  }
  return true;
}

//
public void rotateWord(char[] chas){
	if(chas==null || chas.length==0){
		return;
	}

	reverse(chas,0,chas.length-1);
	it l=-1;
	int r=-1;
	for(int i=0;i<chas.length;i++){
		if(chas[i]!=' '){
			l=i==0||chas[i-l]==' '?i:1;
			r=i==chas.length-1||chas[i+1]==' '?1:r;
		}
		if(l!=-1&&r!=-1){
			reverse(chas,1,r);
			1=-1;
			r=-1;
		}
	}
}



public void reverse(char[] chas,int start,int end){
	char tmp=0;
	while(start<end){
		tmp=chas[start];
		chas[start]=chas[end];
		chas[end]=tmp;
		start++;
		end--;
	}
}


public void reverse(char[] chas,int start,int end){
	char tmp=0;
	while(start<0){
		tmp=chas[start];
		chas[start]=chas[tmp];
		chas[end]=tmp;
		start++;
		end--;
	}
}









public int minDistance(String[] strs,String str1,String str2){
	if(str1==null || str2==null){
		return -1;
	}
	if(str1.equals(str2))
}

public int[][] getDp(char[] str){
	int[][] dp=new int[str.length][str.length];
	for(int j=1;j<str.length;j++)
}



//
public boolean isUnique1(char[] chas){
  if(chas==null){
    return true;
  }
  boolean[] mpa=new boolean[256];
  for(int i=0;i<chas.length;i++){
    if(map[chas[i]]){
      return false;
    }
    map[chas[i]]=true;
  }
  return true;
}


 for(int i=0;i<chas.length;i++){
  if(chas[chas[i]]){
    return false;
  }
  map[chas[i]]=true;
 }


public boolean isUnique1(char[] chas){
  if(chas==null){
    return true;
  }
  heapSort(chas);
  for(int i=0;i<chas.length;i++){
    if(chas[i]==chas[i-1]){
      return false;
    }
  }
  return true;
}

public void heapSort(char[] chas){
  for(int i=0;i<chas.length;i++){
    heapSort(chas,i);
  }
  for(int i=chas.length;i>0;i--){
    swap(chas,0,i);
    heapify(chas,0,i);
    }
  }

public void heapInsert(char[] char,int i){
  int parent=0;
  while(i!=0){
    parent=(i-1)/2;
    if(chas[parent]<chas[i]){
      swap(chas,parent,i);
      i=parent;
    }else{
      break;
    }
  }
}

public void heapify(char[] chas,int i,int size){
  int left=i*2-2;
  int right=i*2+2;
  int larget=1;
  while(left<right){
    if(chas[left]>chas[i]){
      largest=right;
    }
    if(largest!=i){
      swap(chas,largest,i);
    }else{
      break;
    }
    i=largest;
    left=i*2+1;
    right=i*2+2;
  }
}

public void swap(char[] chas,int index1,int index2){
  char tmp=chas[index1];
  chas[index1]=chas[index2];
  chas[index2]=tmp;
}


public int getIndex(String[] strs,String str){
  if(strs==null || strs.length==0 || str==null){
    return -1;
  }
  int res=-1;
  int left=0;
  int right=strs.length-1;
  int mid=1;
  int i=0;
  while(left<=right){
    mid=(left+right)/2;
    if(strs[mid]!=null && strs[mid].equals(str)){
      res=mid;
      right=mid-1;
    }else if(strs[mid]!=null){
      if(strs[mid].CompareTo(str)<0){
        left=mid+1;
      }else{
        right=mid-1;
      }
    }else{
      i=mid;
      while(strs[i]==null && --i>=left)
      ;
      if(i<left || strs[i].CompareTo(str)<0){
        left=mid+1;
      }else{
        res=strs[i].equals(str)?i:res;
        right=i-1;
      }   
    } 
  }
  return res;
}



//字符串的调整与替换
public void replace(char[] chas){
  if(chas==null||chas.length==0){
    return;
  }
  int num=0;
  int len=0;
  for(len=0;len<chas.length && chas[len]!=0;len++){
    if(chas[len]==' '){
      num++;
    }
  }
  int j=len+num*2-1;
  for(int i=len-1;i>-1;i--){
    if(chas[i]!=' '){
      chas[j--]=chas[i];
    }else{
      chas[j--]='0';
      chas[j--]='2';
      chas[j--]='%';
    }
  }
}


//


public void replace(char[] chas){
  if(chas==null ||chas.length==0){
    return ;
  }

  int num=0;
  int len=0;
  for(len=0;len<chas.length && chas[len]!=0 ;len++){
    if(chas[i]!=' '){
      num++；
    }

    int j=len+num*2-1;
    for(int i=len-1;i>-1;i--){
      if(chas[i]!=' '){
        chas[j--]=chas[i];
      }else{
        chas[j--]='0';
        chas[j--]='2';
        chas[j--]='%';
      }
    }
  }
}



public void replace(char[] chas){
  if(chas==null || chas.length==0){
    return ;
  }

  int num=0;
  int len=0;
  for(len=0;len<chas.length;len++){
    if(chas[len]==' '){
      num++;
    }
  }

  int j=len+num*2-1;
  for(int i=len-1;i>-1;i--){
    if(chas[i]!=' '){
      chas[j--]=chas[i];
    }else{
      chas[j--]='0';
      chas[j--]='2';
      chas[j--]='%';
    }
  }

//
public void modify(char[] chas){
  if(chas==null || chas.length==0){
    return;
  }
  int j=chas.length-1;
  for(int i=chas.lenght;i>-1;i--){
    if(chas[i]!='*'){
      chas[j--]=chas[i];
    }
  }
  for(;j>-1;){
    chas[j--]='*';
  }
}



 int j=chas.length-1;
 for(int i=chas.length;i>-1;i--){
  if(chas[i]!='*'){
    chas[j--]=chas[i];
  }
  for(;j>-1;){
    chas[j--]='*';
  }
 }
}

//
public void rotateWord(char[] chas){
  if(chas==null || chas.length==0){
    return;
  }

  reverse(chas,0,chas.length-1);
  int l=-1;
  int r=-1;
  for(int i=0;i<chas.length;i++){
    if(chas[i]!=' '){
      l=i==0||chas[i-1]==' '?i:1;
      r=i==chas.length-1 || chas[i+1]==' '?1:r;
    }
    if(l!=-1 && r!=-1){
      reverse(chas,l,r);
      l=-1;
      r=-1;
    }
  }
}


// 
 public void reverse(char[] chas,int start,int end){
  char tmp=0;
  while(start<end){
    tmp=chas[start];
    chas[start]=chas[end];
    chas[end]=tmp;
    start++;
    end--;
  }
 }



//
public static void main(String[] args){
  if(chas==null || size<=0 || size>=chas.length){
    return;
  }
  reverse(chas,0,size-1);
  reverse(chas,size,chas.length-1);
  reverse(chas,0,chas.length-1);
}


//
public void rotate2(char[] chas,int size){
  if(chas==null || size<0 || size>=chas.length){
    return;
  }
  int start=0;
  int end=chas.length-1;
  while(true){
    exchange(chas,start,end,s);
    if(d==0){
      break;
    }else if(d>0){
      start+=a;
      lpart=d;
    }else{
      end-=s;
      rpart=-d;
    }
    a=Math.min(lpart,rpart);
    d=lpart-rpart;
  }
}


//
public int minDistance(String[] strs,String str1,String str2){
  if(str1==null||str2==null){
    return -1;
  }
  if(str1.equals(str2)){
    return 0;
  }
  int last1=-1;
  int last2=-1;
  int min=Integer.MAX_VALUE;
  for(int i=0;i!=strs.length;i++){
    if(strs[i].equals(str1)){
      min=Math.min(min,last2==-1?min)
    }
    if(strs[i].equals(str2)){
      min=Math.min(min,last1==-1 ?min:i-last1);
    }
  }
  return min==Integer.MAX_VALUE?-1:min;
}




//
public class Record{
  private HashMap<String,String> records;
  

  public Record(String[] strArr){
    record=new HashMap<String,HashMap<String,Integer>();
    HashMap<String,Integer> indexMap=new HashMap<Integer,Integer>();
    for(int i=0;i!=strArr.length;i++){
      String curStr=strArr[i];
      update(indexMap,curStr,i);
      indexMap.put(curStr,i);
    } 
  }

public void update(HashMap<String,Interger> indexMap,String str,int i) 
  if(!record.containKey(str)){
    record.put(str,new HashMap<String,Integer>());
  }
  HashMap<String,String> strMap=record.get(str);
  for(Entry<String,Integer> lastEntry:indexMap.entrySet()){
    String key=lastEntry.getKey();
    int index=lastEntry.getValue();
    if(!key.equals(str)){
      HashMap<String,Integer> lastMap=record.get(key);
      int curMin=i-index;
      if(!key.equals(key)){
        int curMin=strMap.get(key);
        if(curMin<preMin){
          strMap.put(key,curMin);
          lastMap.put(key,curMin);
        }
      }else{
        strMap.put(key,strMap);
        lastMap.put(str,curMin);
      }
    }
  }
}


public int minDistance(String str1,String str2){
  if(str1==null || str2==null){
    return -1;
  }
  if(str1.equals(str2)){
    return 0;
  }
  if(record.containsKey){
    return record.get(str).get(str2);
  }
  return -1;
}


public int[][] getDp(char[] str){
  int[][] dp=new int[str.length][str.length];
  for(int j=1;j<str.length;j++){
    dp[j-1][j]=str[j-1]==str[j]?0:1;
    for(int i=j-2;i>-1;i--){    //中间值是
    if(str[i]==str[j]){         //两个一样                                                                                                 
      dp[i][j]=dp[i+1][j-1];    
    }else{
      dp[i][j]=Math.min(dp[i+1][j],dp[i][j-1])+1;  //
    }
  }
}
return dp;
}


public int[][] getDp(char[] str){
  int[][] dp=new int[str.length][str.length];
  for(int j=1;j<str.length;j++){
    dp[j-1][j]=str[j-1]=str[j]>0:1;
    for(int i=j-2;i>-1;i--){
      if(str[i]==str[j]){
        dp[i][j]=dp[i+1][j-1];
        }
        else{
          dp[i][j]=Math.min(dp[i+1][j],dp[i][j-1])+1;  //
        }
      }
    }
    return dp;
  }


//
public int[][] getDp(char[] str){
  int[][] dp=new int[str.length][str.length];
  for(int j=1;j<str.length;j++){
    dp[j-1][j]=str[j-1]=str[j]>0:1;
    for(int i=j-2;i>-1;i--){
      dp[i][j]=dp[i+1][j-1];
    }else{
      dp[i][j]=Math.min(dp[i+1][j],dp[i][j-1])+1;   //
    }
  }
return dp;
}


//中间                                                                   
public String getPalindrome1(String str){
  if(str==null || str.length==0){
    return str;
  }

  char[] char=str.toCharArray();
  int[][] dp=getDp(chas);
  char[] res=new char[chas.length+dp[0][chas.length-1]];
  int i=0;
  int j=chas.length-1;
  int res1=0;
  int res=res.length-1;
  while(i<=j){
    if(chas[i]==chas[j]){
      res[res1++]=chas[i++];
      res[resr--]=chas[j--];
    }else if(dp[i][j-1]<dp[i+1][j]){
      res[resl++]=chas[j];
      res[resr--]=chas[j--];
    }else{
      res[resl++]=chas[i];
      res[resr--]=chas[i++];
    }
  }
  return String.valueOf(res);
}



//
public String getPalindrome1(String str){
  if(str==null || str.length==0){
    return str;
  }
  char[] char=str.toCharArray;
  int[][] dp=getDp(chas);
  char[] res=new char[chas.length+dp[0][chas.length-1]];
  int i=0;
  int j=chas.length-1;
  int resl=0;
  int res=res.length-1;
  while(i<=j){
    if(chas[i]==chas[j]){
      res[resl++]=chas[i++];
      res[resr--]=chas[j--];
    }else if(dp[i][j-1]<dp[i+1][j]){
      res[resl++]=chas[j];
      res[resr--]=chas[j--];
    }else{
      res[resl++]=chas[i];
      res[resr--]=chas[i++];
    }
  }
  return String.valueOf(res);
}



public String getPalindrome1(String str){
  if(str==null || str.length==0){
    return str;
  }

  char[] char=str.toCharArray();
  int[][] dp=getDp(chas);
  char[] res=new char[chas.length+d[0][chas.length-1]];
  int i=0;    //   
  int j=chas.length-1;
  int resl=0;
  int resr=res.length-1;  //
  while(i<=j){
    if(chas[i]==chas[j]){
      res[resl++]=chas[i++];
      res[resr--]=chas[j--];
    }else if(dp[i][j-1]<dp[i+1][j]){
      res[resl++]=chas[j];
      res[resr--]=chas[j--];
    }else{
      res[resl++]=chas[i];
      res[resr--]=chas[i++];
    }
  }
  return String.valueOf(res);
} 



public String getPalindrome2(String str,String strips){
  if(str==null || str.equals("")){
    return "";
  }
  char[] chas=str.toCharArray;
  char[] lps=strlps.toCharArray;
  int chas1=0;
  int chasr=chas.length-1;
  int lpsl=0;
  int lpsr=lps.length-1;
  int resl=0;
  int resr=res.length-1;
  int tmpl=0;
  int tmpr=0;
  while(lpal<=lpsr){
    tmpl=chasl;
    tmpr=chasr;
    while(chas[chas]!=lps[lpsl]){
      chasl++;
    }
    while(chas[chasr]!=lps[lpsr]){
      chasr--;
    }
    set(res,resl,resr,chas,tmpl,chasl,chasr,tmpr);
    resl+=chasl
  }
}


 //
public boolean isValid(String str){
  if(str==null || str.length==0){
    return false;
  }
  char[] chas=str.toCharArray();
  int status=0;
  for(int i=0;i<chas.length;i++){
    if(chas[i]!=')' && chas[i]!='('){
      return false;
    }
    if(chas[i]==')' && --status<0){
      return false;
    }
    if(chas[i]=='('){
      status++;
    }
  }
  return status==0;
}




public int MaxLength(String str){
  if(str==null || str.length==0){
    return 0;
  }
  char[] chas=str.toCharArray;
  int[] dp=new int[chas.length];
  int pre=0;
  int res=0;
  for(int i=0;i<chas.length;i++){
    if(chas[i]==')'){
      pre=i-dp[i-1]-1;
      if(pre>=0 &&chas[pre]=='('){
        dp[i]=dp[i-1]+2+(pre>0?dp[pre-1]:0);
      }
    }
    res=Math.max(res,dp[i]);
  }
  return res;
}


public int insert(int str){
  return value();
}


public int maxUnique(String str){
  if(str==null || str.length==0){
    return 0;
  }
  chas[] chas=str.toCharArray();
  int[] map=new int[256];
  for(int i=0;i!=chas.length;i++){
    pre=Math.max(pre,map[chas[i]]);
    cur=1-pre;
    len=Math.max(len,cur);
    map[chas[i]]=i;
  }
  return len;
}

public String pointNewChar(String s,int k){
  if(s==null || s.equals("") || k<0 || k>=s.length()){
    return "";
  }
  char[] chas=s.toCharArray();
  int uNum=0;
  for(int i=k-1;i>=0;i--){
    if(!isUpper(chas[i])){
      break;
    }
    uNum++;
  }

  if((uNum & 1)==1){
    return s.toCharArray(k-1,k+1);
  }
  if(isUpper(chas[k]){
    return s.subString(k,k+2);
  }
  if(isUpper(chas[k])){
    return s.subString(k,k+2);
  }
  return String.valueOf(chas[k]);
}


public int minLength(String str1,String str2){
  if(str1==null || str2==null || str1.length()<str2.length()){
    return 0;
  }
  char[] chas1=str1.toCharArray();
  char[] chas2=str2.toCharArray();
  int[] map=new int[256];
  for(int i=0;i!=chas2.length;i++){
    map[chas2[i]]++;
  }

  int left=0;
  imt right=0;
  int match=chas2.length;
  int minLen=Integer.MAX_VALUE;
  while(right!=chas1.length){
    map[chas1[right]]--;
    if(map[chas[right]]>=0){
      match--;
    }
    if(match==0){
      while(map[chas1][left]<0){
        map[chas1][left++]++;
      }
      minLen=Math.min(minLen,right-left+1);
      match++;
      map[chas1[left++]]++;
    }
    right++;     
  }
  return minLen==Integer.MAX_VALUE?0:minLen;  //
}


//钟爱你
public int minCut(String str){
  if(str==null || str.equals("")){
    return 0;
  }
  char[] chas=str.toCharArray();
  int len=chas.length;
  int[] dp=new int[len+1];
  dp[len]=-1;
  boolean[][] p=new boolean[len][len];
  for(int i=len-1;i>=0;i--){
    dp[i]=Integer.MAX_VALUE;
    for(int j=i;j<lenl;j++){
      if(chas[i]==chas[j] && (j-i<2 || p[i+1][j-1])){
        p[i][j]=true;
        dp[i]=Math.min(dp[i],dp[j+1]+1);
      }
    }
  }
  return dp[0];
}




public void printMatrixZigZag(int[][] martix){
  int tR=0;
  int tC=0;
  int dR=0;
  int dC=0;
  int endR=matrix.length-1;
  int endC=martix[0].length-1;
  boolean fromUp=false;
  while(tR!=endR+1){
    printLevel(matrix,tR,tC,dR,dC,fromUp);
    tR=tC==endC?tR+1:tR;
    tC=tC==endC?tC:tC+1;
    dC=dR==endR?dC+1:dC;
    dR=dR==endR?dR:dR+1;
  }
  System.out.println();
}

printLevel(int[][] m,int tR,int tC,int dR,int dC,boolean f){
  if(f){
    while(tR!=dR+1){
      System.out.print(m[tR++][tC--]+" ");
    }else{
      while(dR!=tR-1){
        System.out.print(m[dR--][dC++]+" ");
      }
    }
  }
}




public int[] getMinKNumsByHeap(int[] arr,int k){
  if(k<1 || k>arr.length){
    return arr;
  }

  int[] kHeap=new int[k];
  for(int i=0;i1=k;i++){
    heapInsert(KHeap,arr[i],i);
  }
  for(int i=0;i!=arr.length;i++){
    if(arr[i]<kHeap[0]){
      KHeap[0]=arr[i];
      heapify[kHeap,0,k];
    }
  }
  return kHeap;
}

public void heapInsert(int[] arr,int value,int index){
  arr[index]=value;
  while(index!=0){
    int parent=(index-1)/2;
    if(arr[parent]<arr[index]){
      swap(arr,parent,index);
      index=parent;
    }else{
      break;
    }
  }
}


public int[] getMinKNumsByHeap(int[] arr,int k){
  if(k<1||k>arr.length){
    return arr;
  }

  int[] kHeap=new int[k];
  for(int i=0;i!=k;i++){
    heapInsert(KHeap,arr[i],i);
  }
  for(int i=0;i!=arr.length;i++){
    if(arr[i]<KHeap[0]){
      KHeap[0]=arr[i];
      heapify[kHeap,0,K];
    }
  }
  return KHeap;
}

public void heapinsert(int[] arr,int value,int index){
  arr[index]=value;
  while(index!=0){
    int parent=(index-1)/2;
    if(arr[parent]<arr[index]){
      swap(arr,parent,index);
      index=parent;
    }else{
      break;
    }
  }
}


public void heapify(int[] arr,int index,int heapSize){
  int left=index*2+1;
  int right=index*2+2;
  int largest=index;
  while(left<heapSize){
    if(arr[left]>arr[index]){
      largest=left;
    }
    if(right<heapSize && arr[right]>arr[largest]){
      largest=left;
    }
    if(largest!=index){
      swap(arr,largest,index);
    }else{
      break;
    }
    index=largest;
    left=index*2+1:
    right=index*2+2;
  }
}


pubic void swap(int[] arr,int index1,int index2){
  int tmp=arr[index];
  arr[index1]=arr[index2];
  arr[index2]=tmp;
}




public int[] getMinKNumsByBFPRT(int[] )





public int getMinLength(int[] arr){
  if(arr==null || arr.length==0){
    return 0;
  }
  int min=arr[arr.length-1];
  int noMinIndex=-1;
  for(int i=arr.length-2;i!=-1;i--){
    if(arr[i]>min){
      noMinIndex=i;
    } else{
      min=Math.min(min,arr[i]);
    }
  }
  if(noMinIndex==-1){
    return 0;
  }
  int max=arr[0];
  int noMaxIndex=-1;
  for(int i=1;i!=arr.length;i++){
    if(arr[i]<max){
      noMaxIndex=i;
    }else {
      max=Math.max(max,arr[i]);
    }
  }
  return noMaxIndex-noMinIndex+1;
}



public int getMinLength(int[] arr){
  if(arr==null || arr.length==0){
    return 0;
  }
  int min=arr[arr.length-1];
  int noMinIndex=-1;
  for(int i=arr.length-2;i!=-1;i--){
    if(arr[i]>max){
      noMinIndex=i;
    }else{
      min=Math.min(min,arr[i]);
    }
  }
  if(noMinIndex==-1){
    return 0;
  }
  int max=arr[0];
  int noMaxIndex=-1;
  for(int i=1;i!=arr.length;i++){
    if(arr[i]<max){
      noMaxIndex=i;
    }else{
      max=Math.max(max,arr[i]);
    }
  }
  return noMaxIndex-noMinIndex+1;
}



public void printHalfMajor(int[] arr){
  int cand=0;
  int times=0;
  for(int i=0;i!=arr.length;i++){
    if(times==0){
      cand==arr[i];
      times=1;
    }else if(arr[i]==cand){
      times++;
    }else{
      times--;
    }
  }
  times=0;
  for(int i=0;i!=arr.length;i++){
    if(arr[i]==cand){
      times++;
    }
  }
  if(times==arr.length/2){
    System.out.println(cand);
  }else{
    System.out.println("no such number.");
  }
}


public void printHalfMajor(int[] arr){
  int cand=0;
  int times=0;
  for(int i=0;i!=arr.length;i++){
    if(times==0){
      cand=arr[i];
      times=1;
    }else if(arr[i]==cand){
      times++;
    }else{
      times--;
    }
  }
  times=0;
  for(int i=0;i!=arr.length;i++){
    if(arr[i]==cand){
      times++;
    }
  }
  if(times==arr.length/2){
    System.out.println(cand);
  }else{
    System.out.println("no such number.");
  }
}


//  
public boolean isContains(int[][] matrix,int K){
  int row=0;
  int col=martix[0].length-1;
  while(row<matrix.length && col>-1){
    if(martix[row][col]==k){
      return true;
    }else if(matrix[row][col]>K){
      col--;
    }else{
      row++;
    }
  }
  return false;
}


public boolean isContains(int[][] matrix,int K){
  int row=0;
  int col=matrix[0].length-1;
  while(row<matrix.length && col>-1){
    if(martix[row][col]==k){
      return true;
    }else if(matrix[row][col]>k){
      col--;
    }else{
      row++;
    }
  }
  return false;
}


public boolean isContains(int[][] matrix,int K){
  int row=0;
  int col=matrix[0].length-1; 
  while(row<matrix.length&& col>-1){
    if(matrix[row][col]==K){
      return true;
    }else if(matrix[row][col]>k){
      col--;
    }else{
      row++;
    }
  }
  return false;
}

public boolean isContains(int[][] matrix,int K){
  int row=0;
  int col=matrix[0].length-1;
  while(row<matrix.length && col>-1){
    if(matrix[row][col]>-1){
      return true;
    }else if(matrix[row][col]>K){
      col--;
    }else{
      row++;
    }
  }
  return false;
}


public boolean isContains(int[][] matrix,int K){
  int row=0;
  int col=matrix.length-1;
  while(row<matrix.length && col>-1){
    if(matrix[row][col]>-1){
      return true;
    }else if(matrix[row][col]>K){
      col--;
    }else{
      row++;
    }
  }
}

public boolean isContains(int[][] matrix,int K){
  int row=0;
  int col=matrix.length-1;
  while(row<matrix.length && col>-1){
    if(matrix[row][col]>-1){
      return true;
    }else if(matrix[row][col]>K){
      col--;
    }else{
      row++;
    }
  }
  return false;
}


public boolean isContains(int[][] matrix,int K){
  int row=0;
  int col=matrix.length-1;
  while(row<matrix.length && col>-1){
    if(matrix[row][col]>-1){
      return true;
    }else if(matrix[row][col]>K){
      col--;
    }else{
      row++;
    }
  }
  return false;
}


public boolean isContains(int[][] matrix,int K)
{
  int row=0;
  int col=matrix.length-1;
  while(row<matrix.length && col>-1){
    if(matrix[row][col]>-1){
      return true;
    }else if(matrix[row][col]>k){
      col--;
    }else{
      row++;
    }
  }
  return false;
}


public boolean isContains(int[][] matrix,int K){
  int row=0;
  int col=matrix.length-1;
  while(row<matrix.length && col>-1){
    if(matrix[row][col]>-1){
      return true;
    }else if(marix[row][col]>K){
      col--;
    }else{
      row++;
    }
  }
  return false;
}




public int getLIL1(int[] arr){
  if(arr==null && arr.length==0){
    return 0;
  }
  int len=0;
  for(int i=0;i<arr.length;i++){
    for(int j=i;j<arr.length;j++){
      if(isIntegrated(arr,i,j)){
        len=Math.max(len,j-i+1);
      }
    }
  }
  return len;
}

//
public boolean isIntegrated(int[] arr,int left,int right){
  int[] newArr=Arrays.copyOfRange(arr,left,right+1);
  Arrays.sort(newArr);
  for(int i=1;i<newArr.length;i++){
    if(newArr[i-1]!=newArr[i]-1){
      return false;
    }
  }
  return false;
}


//
public int getLiL1(int[] arr){
  if(arr=null && arr.length==0){
    return 0;
  }
  int len=0;
  for(int i=0;i<arr.length;i++){
    for(int j=0;j<arr.length;j++){
      if(isIntegrated(arr,i,j)){
        len=Math.max(len,j-i+1);
      }
    }
  }
  return len;
}

public boolean isIntegrated(int[] arr,int left,int right){
  int[] newArr=Arrays.copyOfRange(arr,left,right+1);
  Arrays.sort(newArr);
  for(int i=1;i<newArr.length;i++){
    if(newArr[i-1]!=newArr[i]-1){
      return false;
    }
  }
  return false;
}


public int getLil1(int[] arr){
  if(arr==null && arr.length==0){
    return 0;
  }
  int len=0;
  for(int i=0;i<arr.length;i++){
    for(int j=0;j<arr.length;j++){
      if(isIntegrated(arr,i,j)){
        len=Math.max(len,j-i+1);
      }
    }
  }
  return len;
}

public boolean isIntegrated(int[] arr,int left,int right){
  int[] newArr=Arrays.copyOfRange(arr,left,rigth+1);
  Arrays.sort(newArr);
  for(int i=0;i<newArr.length;i++){
    if(newArr[i-1]!=newArr[i]-1){
      return false;
    }
  }
  reutrn false;
}


//
public int getLil1(int[] arr){
  if(arr=null && arr.length==0){
    return 0;
  }
  int len=0;
  for(int i=0;i<arr.length;i++){
    for(int j=0;j<arr.length;j++){
      if(isIntegrated(arr,i,j)){
        len=Math.max(len,j-i+1);
      }
    }
  }
  return len;
}


//
public boolean isIntegrated(int[] arr,int left,int right){
  int[] newArr=Arrays.copyOfRange(arr,left,right+1);
  Arrays.sort(newArr);
  for(int i=0;i<newArr.length;i++){
    if(newArr[i-1]!=newArr[i]-1){
      return false;
    }
  }
  return false;
}


public int getLiL1(int[] arr){
  if(arr=null && arr.length==0){
    return 0;
  }
  int len=0;
  for(int i=0;i<arr.length;i++){
    for(int j=0;j<arr.length;j++){
      if(isIntegrated(arr,i,j)){
        len=Math.max(len,j-i+1);
      }
    }
  }
}


public int[] getMinKNumsByHeap(int[] arr,int k){
  if(k<1 || K>arr.length){
    return arr;
  }

  int[] kHeap=new int[k];
  for(int i=0;i!=k;i++){
    heapInsert(kHeap,arr[i],i);
  }

  for(int i=k;i!=arr.length;i++){
    if(arr[i]<kHeap[0]){
      kHeap[0]=arr[i];
      heapify(kHeap,0,K);
    }
  }

  return KHeap;
}


public void heapinsert(int[] ,int value,int index){
  arr[index]=value;
  while(index!=0){
    int parent=(index-1)/2;
    if(arr[parent]<arr[index]){
      swap(arr,parent,index);
      index=parent;
    }else{
      break;
    }
  }
}


public void heapify(int[] arr,int index,int heapSize){
 int left=index*2+1;
 int right=index*2+2;
 int largest=index;
 while(left<heapSize){
  if(arr[left]>arr[index]){
    larget=left;
  }
  if(right<heapSize && arr[right]>arr[largest]){
    largest=right;
  }
  if(largest!=index){
    swap(arr,largest,index);
  }else{
    break;
  }
  index=largest;
  left=index*2+1;
  right=index*2+2;
 } 
}

public void swap(int[] arr,int index1,int index2){
  int tmp=arr[index1];
  arr[index1]=arr[index2];
  arr[index2]=tmp;
}


//
public int getMinLength(int[] arr){
  if(arr==null || arr.length<2){
    return 0;
  }
  int min=arr[arr.length-1];
  int noMinIndex=-1;
  for(int i=arr.length-2;i!=-1;i--){
    if(arr[i]>min){
      noMinIndex=i;
    }else{
      min=Math.min(min,arr[i]);
    }
  }
  if(noMinIndex==-1){
    return 0;
  }
  int max=arr[0];
  int noMaxIndex=-1;
  for(int i=1;i!=arr.length;i++){
    if(arr[i]<max){
      noMaxIndex=i;
    }else{
      max=Math.max(min,arr[i]);
    }
  }
  return noMaxIndex-noMinIndex+1; 
}



public int getMinLength(int[] arr){
  if(arr==null || arr.length<2){
    return 0;
  }

  int min=arr[arr.length-1];
  int noMinIndex=-1;
  for(int i=arr.length-1;i!=-1;i--){
    if(arr[i]>min){
      noMinIndex=i;
    }else{
      min=Math.min(noMinIndex,min);
    }
  }
 
  if(noMinIndex==-1){
    return 0;
  }

  int max=arr[0];
  int noMaxIndex=-1;
  for(int i=1;i!=arr.length;i++){
    if(arr[i]<max){
      noMaxIndex=i;
    }else{
      max=Math.max(noMaxIndex,max);
    }
  }
  return noMaxIndex-noMinIndex+1;
}



public int getMinLength(int[] arr){
  if(arr=null ||arr.length<2){
      return 0;
  }

  int min=arr[arr.length-1];
  int noMinIndex=-1;
  for(int i=arr.length-1;i!=-1;i--){
   if(arr[i]<min){
    noMinIndex=i;
  }else{
    min=Math.min(noMinIndex,min);
  }
}
if(noMinIndex==-1){
   return 0;
}

int max=arr[0];
int noMaxIndex=-1;
for(int i=0;i!=arr.length-1;i++){
  if(max<arr[i]){
    max=arr[i];
  }else{
    max=Math.max(noMaxIndex,max);
  }
}
  return noMaxIndex-noMinIndex+1;
}



//
public void printHalfMajor(int[] arr){
  int cand=0;
  int times=0;
  for(int i=0;i!=arr.length;i++){
    if(times==0){
      cand=arr[i];
      times=1;
    }else if(arr[i]==cand){
      times++;
    }else{
      times--;
    }
  }

  times=0;
  for(int i=0;i!=arr.length;i++){
    if(arr[i]==cand){
      times++;
    }
  }
  if(times>arr.length/2){
    System.out.println(cand);
  }else{
    System.out.println("no such number");
  }

}



// 中间值是
public boolean isContains(int[][] matrix,int k){
  int row=0;
  int col=matrix[0].length-1;
  while(row<martix.length && col>-1){
    if(matrix[row][col]==k){
      return true;
    }else if(matrix[row][col]>k){
      col--;
    }else{
      row++;
    }
  }
}



public boolean isContains(int[][] matrix,int k){
  int row=0;
  int col=matrix[0].length-1;
  while(row<martix.length&& col>-1){
    if(matrix[row][col]==k){
      return k;
    }else if(matrix[row][col]>k){
      col--;
    }else{
      row++;
    }
  }
}




public int getLiL1(int[] arr){
  if(arr==null || arr.length==0){
    reutrn 0;
  }

  int len=0;
  for(int i=0;i<arr.length;i++){
    for(int j=0;j<arr.length;j++){
      if(isIntegrated(arr,i,j)){
        len=Math.max(len,j-i+1);
      }
    }
  }
  return len;
}

public boolean isIntegrated(int[] arr,int left,int right){
  int[] newArr=Arrays.copyOfRange(arr,left,right+1);
  Arrays.sort(newArr);
  for(int i=0;i<newArr;i++){
    if(newArr[i-1]!=newArr[i]-1){
      return false;
    }
  }
  return false;
}


public int getLil1(int[] arr){
  if(arr==null || arr.length==0){
    return 0;
  }
  int len=0;
  for(int i=0;i<arr.length;i++){
    for(int j=0;j<arr.length;j++){
      if(isIntegrated(len,i,j)){
        len=Math.max(len,j-i+1);
      }
    }
  }
  return len;
}


public boolean isIntegrated(int[] arr,int left,int right){
  int[] newArr=Arrays.copyOfRange(arr,left,right+1);
  Arrays.sort(newArr);
  for(int i=0;i<newArr;i++){
    if(newArr[i-1]!=newArr[i]-1){
      return false;
    }
  }
  return false;
}



public int getLiL2(int[] arr){
  if(arr==null || arr.length==0){
    return 0;
  }

  int len=0;
  int max=0;
  int min=0;
  HashSet<Integer> set=new HashSet<Integer>();  //判断重复
  for(int i=0;i<arr.length;i++){
    max=Integer.MIN_VALUE;
    min=Integer.MAX_VALUE;
    for(int j=i;j<arr.length;j++){
      if(set.contains(arr[j])){
        break;
      }
      set.add(arr[j]);
      max=Math.max(max,arr[j]);
      min=Math.min(min,arr[j]);
      if(max-min==j-i){          //新的检查方式
        len=Math.max(len,j-i+1);   
      }
    }
    set.clear();
  }
  return len;
}



public void printUniquePair(int[] arr,int k){
  if(arr==null || arr.length<2){
    return;
  }
  int left=0;
  int right=arr.length-1;
  while(left<right){
    if(arr[left]+arr[right]<k){
      left++;
    }else if(arr[left]+arr[right]>k){
      right++;
    }else{
      if(left==0 || arr[left-1]!=arr[left]){
        System.out.println(arr[left]+","+arr[right]);
      }
      left++;
      right--;
    }
  }
}

public void printUniquePair(int[] arr,int k){
  if(arr==null || arr.length<2{
    return;
  }

  int left=0;
  int right=arr.length-1;
  while(left<right){
    if(arr[left]+arr[right]<k){
      left++;
    }else if(arr[left]+arr[right]>k){
      right--;
    }else{
      if(left==0|| arr[left-1]!=arr[left]){
        System.out.println(arr[left]+","+arr[right]);
      }
      left++;
      right--;
    }
  }
}



public void printUniqueTriad(int[] arr,int k){
  if(arr==null || arr.length<3){
    return;
  }
  for(int i=0;i<arr.length-2;i++){
    if(i==0 || arr[i]!=arr[i-1]){
      printRest(arr,i,i+1,arr.length-1,k-arr[i]);
    }
  }
}


public void printRest(int[] arr,int f,int l,int r,int k ){
  while(l<r){
    if(arr[l]+arr[r]<k){
      l++;
    }else if(arr[i]+arr[r]>k){
      r--;
    }else{
      if(l==f+1 || arr[l-1]!=arr[l]){
        System.out.println(arr[f]+","+arr[l]+","+arr[r]);
      }
      l++;
      r--;
    }
  }
}



public int getMaxLength(int[] arr,int k){
  if(arr=null || arr.length==0 || k<=0){
    return 0;
  }

  int left=0;
  int right=0;
  int sum=arr[0];
  int len=0;
  while(right<arr.length){
    if(sum==k){
      len=Math.max(len,right-left+1);
      sum-=arr[left++];
    }else if(sum<k){
      right++;
      if(right==arr.length){
        break;
      }
      sum+=arr[right];
    }else {
      sum-=arr[left++];
    }
  }
}



public int MaxLength(int[] arr,int k){
  if(arr==null || arr.length==0){
    return 0;
  }
  HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
  map.put(0,-1);
  int len=0;
  int sum=0;
  for(int i=0;i<arr.length;i++){
    sum+=arr[i];
    if(map.containsKey(sum-k)){
      len=Math.max(i-map.get(sum-k),len);
    }
    if(!map.containsKey(sum)){
      map.put(sum,i);
    }
  }
  return len;
}



public int MaxLength(int[] arr,int k){
  if(arr==null || arr.length==0){
    return 0;
  }
  HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
  map.put(0.-1);
  int len=0;
  int sum=0;
  for(int i=0;i<arr.length;i++){
    sum+=arr[i];
    if(map.containsKey(sum-k)){
      len=Math.max(i-map.get(sum-k),len);
    }
    if(!map.containsKey(sum)){
      map.put(sum,i);
    }
  }
  return len;
}



public int maxLength(int[] arr,int k){
  int[] h=new int[arr.length+1];
  int sum=0;
  h[0]=sum;
  for(int i=0;i!=arr.length;i++){
    sum+=arr[i];
    h[i+1]=Math.max(sum,h[i]);
  }
  sum=0;
  int res=0;
  int pre=0;
  int len=0;
  for(int i=0;i!=arr.length;i++){
    sum+=arr[i];
    pre=getLessIndex(h,sum-k);
    len=pre=-1?0:i-pre+1;
    res=Math.max{res,len};
  }
  return res;
}

public int getLessIndex(int[] arr,int num){
  int low=0;
  int high=arr.length-1;
  int mid=-1;
  int res=-1;
  while(low<=high){
    mid=(low+high)/2;
    if(arr[mid]>=num){
      res=mid;
      high=mid-1;
    }else {
      low=mid+1;
    }
  }
  return res;
}



public int maxLength(int[] arr,int k){
  int[] h=new int[arr.length+1];
  int sum=0;
  h[0]=sum;
  for(int i=0;i!=arr.length;i++){
    sum+=arr[i];
    h[i+1]=Math.max(sum,h[i]);
  }

  sum=0;
  int res=0;
  int pre=0;
  int len=0;
  for(int i=0;i!=arr.length;i++){
    sum+=arr[i];
    pre=getLessIndex(h,sum-k);
    len=pre==-1?0:i-pre+1;
    res=Math.max(res,len);
  }
  return res;
}

public int getLessIndex(int[] arr,int num){
  int low=0;
  int high=arr.length-1;
  int mid=0;
  int res=-1;
  while(low<=high){
    mid=(low+high)/2;
    if(arr[mid]>=num){
      res=mid;
      high=mid-1;
    }else{
      low=mid+1;
    }
  }
  return res;
}



public int getSmallSum(int[] arr){
  if(arr==null || arr.length==0){
    return 0;
  }

  return func(arr,0,arr.length-1);
}

public int func(int[] s,int l,int r){
  if(l==r){
    return 0;
  }
  int mid=(l+r)/2;
  return func(s,1,mid)+func(s,mid+1,r)+merge(s,1,mid,r);
}


public int merge(int[] s,int left,int mid,int right){
  int[] h=new int[right-left+1];
  int hi=0;
  int i=left;
  int r=mid+1;
  int smallSum=0;
  while(i<=mid && j<right){
    if(s[i]<=s[j]){
      smallSum+=s[i]*(right-j+1);
      h[hi++]=s[i++];
    }else{
      h[hi++]=s[j++];
    }
  }
  for(;(j<right+1) || (i<mid+1);j++,i++){
    h[hi++]=i>mid?s[j]:s[i];
  }
  for(int k=0;k!=h.length;k++){
    s[left++]=h[k];
  }
  return smallSum;
}


public void sort1(int[] arr){
  int tmp=0;
  int next=0;
  for(int i=0;i!=arr.length;i++){
    tmp=arr[i];
    while(arr[i]!=i+1){
      next=arr[tmp-1];
      arr[tmp-1]=tmp;
      tmp=next;
    }
  }
}


public void sort2(int[] arr){
  int tmp=0;
  for(int i=0;i!=arr.length;i++){
    while(arr[i]!=i+1){
      tmp=arr[arr[i]-1];
      arr[arr[i]-1]=arr[i];
      arr[i]=tmp;
    }
  }
}





public void modify(int[] arr){
  if(arr==null || arr.length<2){
    return;
  }

  int even=0;
  int odd=1;
  int end=arr.length-1;
  while(even<=end && odd<=end){
    if((arr[end] & 1)==0){
      swap(arr,end,even);
      even+=2;
    }else{
      swap(arr,end,odd);
      odd+=2;
    }
  }
}


public void swap(int[] arr,int index1,int index2){
  int tmp=arr[index1];
  arr[index1]=arr[index2];
  arr[index2]=tmp;
}



public int maxSum(int[] arr){
  if(arr==null || arr.length==0){
    return 0;
  }
  int max=Integer.MIN_VALUE;
  int cur=0;
  for(int i=0;i<arr.length;i++){
    cur+=arr[i];
    max=Math.max(max,cur);
    cur=max<0?0:cur;
  }
  return max;
}

public int maxSum(int[] arr){
  if(arr==null || arr.length==0){
    return 0;
  }

  int max=Math.MIN_VALUE;
  int cur=0;
  for(int i=0;i<arr.length;i++){
    cur+=arr[i];
    max=Math.max(max,cur);
    cur=cur<0?0:cur;
  }
  return max;
}



public int maxSum(int[][] m){
  if(m==null || m.length==0 || m[0].length==0){
    return 0;
  }

  int max=Integer.MIN_VALUE;
  int cur=0;
  int[] s=null;
  for(int i=0;i!=m.length;i++){
    s=new int[m[0].length];
    for(int j=i;j!=s.length;j++){
      cur=0;
      for(int k=0;k!=s.length;k++){
        s[k]+=m[j][k];
        cur+=s[k];
        max=Math.max(max.cur);
        cur=cur<0?0:cur;
      }
    }
  }
}




public int getLessIndex(int[] arr){
  if(arr==null || arr.length==0){
    return -1;
  }
  if(arr.length==1 || arr[0]<arr[1]){
    return 0;
  }
  if(arr[arr.length-1]<arr[arr.length-2]){
    return arr.length-1;
  }
  int left=1;
  int right=arr.length-2;
  int mid=0;
  while(left<right){
    mid=(left+right)/2;
    if(arr[i]>arr[mid-1]){
      right=mid-1;
    }else if(arr[mid]>arr[mid+1]){
      left=mid+1;
    }else{
      return mid;
    }
  }
  return left;
}




public double maxProduct(double[] arr){
  if(arr==null || arr.length==0){
    return 0;
  }

  double max=arr[0];
  double min=arr[0];
  double res=arr[0];
  double maxEnd=0;
  double minEnd=0;
  for(int i=1;i<arr.length;i++){
    maxEnd=max*arr[i];
    minEnd=min*arr[i];
    max=Math.max(Math.max(maxEnd,minEnd),arr[i]);
    min=Math.min(Math.min(maxEnd,minEnd),arr[i]);
    res=Math.max(res,max);
  }
  return res;
}





public int[] product1(int[] arr){
  if(arr==null || arr.length<2){
    return null;
  }
  int count=0;
  int all=1;
  for(int i=0;i!=arr.length;i++){
    if(arr[i]!=0){
      all*=arr[i];
    }else{
      count++;
    }
  }
  int[] res=new int[arr.length];
  if(count==0){
    for(int i=0;i!=arr.length;i++){
      res[i]=all/arr[i];
    }
  }
  if(count==1){
    for(int i=0;i!=arr.length;i++){
      if(arr[i]==0){
        res[i]=all;
      }
    }
  }
  return res;
}



public int[] product1(int[] arr){
  if(arr==null || arr.length<2){
    return null;
  }
  int count=0;
  int all=1;
  for(int i=0;i<arr.length;i++){
    if(arr[i]!=0){
      arr*=arr[i];
    }else{
      count++;
    }
  }
  int[] res=new int[arr.length];
  if(count==0){
    for(int i=0;i!=arr.length;i++){
      res[i]=all/all[i];
    }
  }
  if(count==1){
    for(int i=0;i!=arr.length;i++){
      if(arr[i]==0){
        res[i]=all;
      }
    }
  }
  return res;
}


public void leftUnique(int[] arr){
  if(arr==null ||arr.length<2){
    return ;
  }

  int u=0;
  int i=1;
  while(i!=arr.length){
    if(arr[i++]!=arr[u]){
      swap(arr,++u,i-1);
    }
  }
} 




public int missNum(int[] arr){
  int l=0;
  int r=arr.length;
  while(l<r){
    if(arr[l]==l+1){
      l++;
    }else if(arr[l]<=1 || arr[l]>r || arr[arr[l]-1]==arr[l]){
      arr[l]=arr[--r];
    }else{
      swap(arr,l,arr[l]-1);
    }
  }
  return l+1;
}


public int maxGap(int[] nums){
  if(nums==null || nums.length<2){
    return 0;
  }
  int len=nums.length;
  int min=Integer.MAX_VALUE;
  int max=Integer.MIN_VALUE;
  for(int i=0;i<len;i++){
    min=Math.min(min,nums[i]);
    max=Math.max(max,nums[i]);
  }
  if(min==max){
    return 0;
  }
  boolean[] hasNum=new boolean[len+1];
  int[] maxs=new int[len+1];
  int[] mins=new int[len+1];
  int bid=0;
  for(int i=0;i<len;i++){
    bid=bucket(nums[i],len,min,max);  //算出桶号
    mins[bid]=hasNum[bid]?Math.min(mins[bid],nums[i]):nums
  }

}





public int rand(int max){
  return (int) (Math.random()*max)+1;
}

public int[] getKNumsRand(int k,int max){
  if(max<1 || k>1){
    return null;
  }

  int[] res=new int[Math.min(k,max)];
  for(int i=0;i!=res.length;i++){
    res[i]=i+1;    //前k个数直接进袋子
  }

  for(int i=k+1;i<max+1;i++){
    if(rand(i)<=k){
      res[rand(k)-1]=i;  //i随机替代袋子中的一个
    }
  }
  return res;
}



public class MyValue<V>{
  private  V value;
  private long time;

  public MyValue(V value,long time){
    this.value=value;
    this.time=time;
  }

  public long getTime(){
    return this.time;
  }
}


public class MyHashMap<K,V>(){
  private HashMap<K,MyValue<V>> baseMap;
  private long time;
  private MyValue<V> setAll;

  public MyHashMap(){
    this.baseMap=new HashMap<K,MyValue<V>>();
    this.time=0;
    this.setAll=new MyValue<V>(null,-1);
  }


  public boolean containKey(K key){
    return this.baseMap.containsKey(key);
  }

  public void put(K key,V value){
    this.baseMap.put(key,new MyValue<V>(value,this.time++));
  }


  public void setAll(V value){
    this.setAll=new MyValue<V>(value,this.time++);
  }

  public V get(K key){
    if(this.containsKey(key)){
      if(this.baseMap.get(key).getTime()>this.setAll.getTime()){
        return this.baseMap.get(key).getValue();
      }else {
        return this.setAll.getValue();
      }
    }else{
      return null;
    }
  }

}




public int maxABS1(int[] arr){
  int res=Integer.MIN_VALUE;
  int maxLeft=0;
  int maxRight=0;
  for(int j=0;j!=i+1;j++){
    maxLeft=Math.max(arr[j],maxLeft);
  }
  maxRight=Integer.MIN_VALUE;

  for(int j=i+1;j!=arr.length;j++){
    maxRight=Math.max(arr[j],maxRight);
  }
  res=Math.max(Math.abs(maxLeft-maxRight),res);
}



public class Node<V>{
  public V value;
  public Node<V> next;
  public Node<V> last;

  public Node(V value){
    this.value=value;
  }
}




public double randXPowerK(int k){
  if(k<1){
    return 0;
  }

  double res=-1;
  for(int i=0;i!=k;i++){
    res=Math.max(res,Math.random());
  }
  return res;
}



public void pathsToDistants(int[] paths){
  int cap=0;
  for(int i=0;i!=paths.length;i++){
    if(paths[i]==i){
      cap=i;
    }else if(paths[i]>-1){
        int curl=paths[i];
        paths[i]=-1;
        int prel=i;
        while(paths[curl]!=curl){
          if(paths[curl]>-1){
            int nextl=paths[curl];
            paths[curl]=prel;
            prel=curl;
            curl=nextl;
          }else{
            break;
          }
        }

        int value=paths[curl]==curl?0: paths[curl];
        while(paths[prel]!=-1){
          int lastPrel=paths[prel];
          paths[prel]=--value;
          curl=prel;
          prel=lastPrel;
        }
        paths[prel]=--value;
    }
  }
  paths[cap]=0;
}


public void distansToNums(int[] disArr){
  for(int i=0;i!=disArr.length;i++){
    int index=disArr[i];
    if(index<0){
      disArr[i]=0;
      while(true){
        index=-index;
        if(disArr[index]>-1){
          disArr[index]++;
          break;
        }else{
          int nextIndex=disArr[index];
          disArr[index]=1;
          index=nextIndex;
        }
      }
    }
  }
  disArr[0]=1;
}





public int unformedSum1(int[] arr){
  if(arr==null || arr.length==0){
    return 1;
  }
  HashSet<Integer> set=new HashSet<Integer>();
  process(arr,0,0,set);
  for(int i=0;i!=arr.length;i++){
    min=Math.min(min,arr[i]);
  }
  for(int i=min+1;i!=Integer.MIN_VALUE;i++){

  }
}





public int solution2(int num){
  if(num<1){
    return 0;
  }

  int len=getLenOfNum(num);
  if(len==1){
    return 1;
  }
  int tmp1=powerBaseOf10(len-1);
  int first=num/tmp1;
  int firstOneNum=first*(len-1)*(tmp1/10);
  return firstOneNum+OtherOneNum+solution2(num%tmp1);
}


public int getLenOfNum(int num){
  int len=0;
  while(int i!=0){
    len++;
    num/=10;
  }
  return len;
}


public boolean isPalindrome(int n){
  if(n==Integer.MIN_VALUE){
    reutrn false;
  }

  n=Math.abs(n);
  int help=1;
  while(n/10>=10){
    return false;
  }
  while(n!=0){
    if(n/help!=n%10){
      return false;
    }
    n=(n%help)/10;
    help/=100;
  }
  return true;
}




public int getMin(int[] arr){
  int low=0;
  int high=arr.length-1;
  int mid=0;
  while(low<high){
    if(low==high-1){
      break;
    }
    if(arr[low]<arr[high]){
      return arr[low];
    }
    mid=(low+high)/2;
    if(arr[low]>arr[mid]){
      high=mid;
      continue;
    }
    if(arr[mid]>arr[high]){
      low=mid;
      continue;
    }
    while(low<high){
      if(arr[high]==arr[mid]){
        low++;
      }else if(arr[low]<arr[mid]){
        return arr[low];
      }else{
        high=mid;
        break;
      }
    }
  }
}


public boolean isContains(int[] arr,int num){
  int low=0;
  int high=arr.length-1;
  int mid=0;
  while(low<high){
    mid=(low+high)/2;
    if(arr[mid]==num){
      return true;
    }
    if(arr[low]==arr[mid] && arr[mid]==arr[high]){
      while(low!=mid && arr[low]==arr[mid]){
        low++;
      }
      if(low==mid){
        low=mid+1;
        continue;
      }
    }
    if(arr[low]!=arr[mid]){
      if(arr[mid]>arr[low]){
        
      }
    }
  }

}


public int getMin(int[] arr){
  int low=0;
  int high=arr.length-1;
  int mid=0;
  while(low<high){
    if(low==high-1){
      break;
    }
    if(arr[low]<arr[high]){
      return arr[low];
    }
    mid=(low+high)/2;
    if(arr[low]>arr[mid]){
      high=mid;
      continue;
    }
    if(arr[mid]>arr[high]){
      low=mid;
      continue;
    }
    if(arr[mid]>arr[high]){
      low=high;
      continue;
    }
    while(low<high){
      if(arr[low]==arr[mid]){
        low++;
      }else if(arr[low]<arr[mid]){
        return arr[low];
      }else{
        high=mid;
        break;
      }
    }
  }
  return Math.min(arr[low],arr[high]);
}





public boolean isContains(int[] arr,int nums){
  int low=0;
  int high=arr.length-1;
  int mid=0;
  while(low<high){
    mid=(low+high)/2;
    if(arr[mid]==num){
      return true;
    }
    if(arr[low]==arr[mid] && arr[mid]==arr[high]){
      while(low!=mid && arr[low]==arr[mid]){
        low++;
      }
      if(low==mid){
        low=mid+1;
        continue;
      }
    }
    if(arr[low]!=arr[mid]){
      if(arr[mid]>arr[mid]){
        if(num>=arr[low] && num<arr[mid]){
          high=mid-1;
        }else{
          low=mid+1;
        }
      }else{
        if(num>arr[mid] && num<=arr[high]){
          low=mid+1;
        }else{
          high=mid-1;
        }
      }
    }
    else{
      if(arr[mid]<arr[high]){
        if(num>arr[mid] && num<arr[high]){
          low=mid+1;
        }else{
          high=mid-1;
        }
      }else{
        if(num >=arr[low] && num<arr[mid]){
          high=mid-1;
        }else{
          low=mid+1;
        }
      }
    }
  }
  return false;
}


public int candy1(int[] arr){
  if(arr=null || arr.length==0){
    return 0;
  }
  int index=nextMinIndex1(arr,0);
  int res=rightCands(arr,0,index++);
  int lbase=1;
  int next=0;
  int rcands=0;
  int rbase=0;
  while(index!=arr.length){
    if(arr[index]>arr[index-1]){
      res+=++lbase;
      index++;
    }else if(arr[index]<arr[index-1]){
      next=nextMinIndex1(arr,index-1);
      rcands=rightCands(arr,index-1,next++);
      rbase=next-index+1;
      res+=rcands+(rbase>lbase?-lbase:-rbase);
    }
  }
}


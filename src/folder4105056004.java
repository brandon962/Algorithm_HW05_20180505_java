
public class folder4105056004 extends folder{
	
	public static void main(String[] args) 
	{
		int A[] = {30,31,32,33,34,35,36,37,38,39,40,-1,26,27};
		folder4105056004 test = new folder4105056004();
		
		System.out.println("\nans = " + test.fold_min(A));
	}
	
	
	public int fold_min(int[] A) {
		int len = A.length;
		int head, cut1, cut2, end;
		
		head = 0;
		end = len - 1;
		cut1 = end / 3;
		cut2 = cut1 * 2;
		
		while(end - head > 5)
		{
			//System.out.println("\ncont = " + cont);
			//System.out.println(A[head] + " " + A[cut1] + " " + A[cut2] + " " + A[end]);
			if(A[head] < A[cut1] && A[cut1] < A[cut2] && A[cut2] < A[end])  // 1234
			{
				//System.out.println("1234");
				return A[head];
			}
			else if(A[cut1] < A[cut2] && A[cut2] < A[end] && A[end] < A[head])	// 4123
			{
				//System.out.println("4123");
				end = cut1;
				cut1 = head + (end-head)/3;
				cut2 = head + (end-head)*2/3;
				//System.out.println("num:"+head + " " + cut1 + " " + cut2 + " " + end);
			}
			else if(A[cut2] < A[end] && A[end] < A[head] && A[head] < A[cut1])
			{
				//System.out.println("3412");
				head = cut1;
				cut1 = head + (end-head)/3;
				cut2 = head + (end-head)*2/3;
				//System.out.println("num:"+head + " " + cut1 + " " + cut2 + " " + end);
			}
			else if(A[end] < A[head] && A[head] < A[cut1] && A[cut1] < A[cut2])
			{
				//System.out.println("2341");
				head = cut2;
				cut1 = head + (end-head)/3;
				cut2 = head + (end-head)*2/3;
				//System.out.println("num:"+head + " " + cut1 + " " + cut2 + " " + end);
			}
			else
			{
				//System.out.println("else");
				break;
			}
		}
		
		for(int i  = head; i < end; i++)
		{
			//System.out.print(A[i]);
			if(A[i] > A[i+1])
				return A[i+1];
		}
		//System.out.println("");
		return A[head];
	}
}

import java.util.Arrays;

//Memoized fibonacci
public class Fib_Memoized {

	
	public static void main(String[] args) {
		int num=5;
		dp=new int[num+1];
		
		System.out.println(fib(num));
		System.out.println(Arrays.toString(dp));

	}

	
	static int dp[];
	
	private static int fib(int num) {
		
		if(num==0 || num==1)
			return num;
		
		if(dp[num]!=0)
			return dp[num];
		
		else{
			dp[num]=fib(num-2)+fib(num-1);
			return dp[num];
		}
		
	}
	
	
	
	

}

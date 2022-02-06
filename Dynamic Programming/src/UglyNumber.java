
/*
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15,
 *  … shows the first 11 ugly numbers. By convention, 1 is included. 
 *  Given a number n, the task is to find n’th Ugly number
 */
public class UglyNumber {

	public static void main(String[] args) {
		
		System.out.println(uglyNum(10));

	}

	private static int uglyNum(int num) {
		
		int i2=0, i3=0, i5=0;
		int dp[] = new int[num];
		dp[0]=1;
		
		int nextMultiple_2=2;
		int nextMultiple_3=3;
		int nextMultiple_5=5;
		int uglyNum;
		
		for(int index=1;index<num;index++) {
			
			uglyNum=Math.min(nextMultiple_2, Math.min(nextMultiple_5, nextMultiple_3));
			
			dp[index]=uglyNum;
			
			if(uglyNum==nextMultiple_2) {
				nextMultiple_2=dp[++i2]*2;
			}
			
			else if(uglyNum==nextMultiple_3) {
				nextMultiple_3=dp[++i3]*3;
			}
			
			else if(uglyNum==nextMultiple_5) {
				nextMultiple_5=dp[++i5]*5;
			}
			
			
		}
		
		return dp[num-1];
	}

}

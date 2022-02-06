import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//Memoized Version of Longest Common Subsequence
public class LongestCommonSubsequence {

	static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    static int dp[][]; 
	public static void main(String[] args) throws IOException {
	
		int s1Length = readInt();
		int s2Length = readInt();
		
		int X[] = new int[s1Length];
		int Y[] = new int[s2Length];
		dp= new int[X.length+1][Y.length+1];
		
		//Fill the memo with default negative values
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[i].length;j++)
				dp[i][j]=-1;
		
		//User input for the values
		for(int i=0;i<s1Length;i++) 
			X[i]=readInt();
		
		for(int i=0;i<s2Length;i++) 
			Y[i]=readInt();
		
		
		System.out.println(lcs(X,Y,s1Length-1,s2Length-1));
	}
	
	private static int lcs(int[] X, int[] Y, int m, int n) {
		
		if(m==-1 || n==-1)
			return 0;
		
		if(dp[m][n]!=-1)
			return dp[m][n];
		
		if(X[m]==Y[n]) {
			dp[m][n]=1+lcs(X,Y,m-1,n-1);
			return dp[m][n];
		}
		
		else
			return Math.max(lcs(X,Y,m-1,n),lcs(X,Y,m,n-1));
		
	}

	

	static String next () throws IOException {
	       while (st == null || !st.hasMoreTokens())
	            st = new StringTokenizer(br.readLine().trim()); 
	        return st.nextToken();
	    }
	    static long readLong () throws IOException {
	        return Long.parseLong(next());
	    }
	    static int readInt () throws IOException {
	        return Integer.parseInt(next());
	    }
	    static double readDouble () throws IOException {
	        return Double.parseDouble(next());
	    }
	    static String readLine () throws IOException {
	        return br.readLine().trim();
	    }
}
